package com.volvo.congestion.calculator.facade.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.volvo.congestion.VolvoTestApplication;
import com.volvo.congestion.calculator.domain.area.CityType;
import com.volvo.congestion.calculator.domain.vehicle.VehicleType;
import com.volvo.congestion.calculator.facade.dto.ResponseDTO;
import com.volvo.congestion.calculator.facade.dto.TaxCalculateDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.Filter;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = VolvoTestApplication.class)
@WebAppConfiguration
public class TaxCalculatorServiceRestTest {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    private Gson gson = new Gson();

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
    @Test
    public void calculateTollFree() throws Exception{
        // given
        TaxCalculateDTO dto = new TaxCalculateDTO();
        dto.setCity(CityType.Gothenburg);
        dto.setVehicle(VehicleType.Car);
        dto.setTimeline(loadTimeLine());
        // when
        ResultActions result = mockMvc.perform(post("/api/calculator/tollfee")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(dto)));
        gson.fromJson(result.andReturn().getResponse().getContentAsString(), ResponseDTO.class);
        // then
        result.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success", is(true)))
                .andExpect(jsonPath("$.errorCode", is(0)))
                .andExpect(jsonPath("$.message", nullValue()))
                .andExpect(jsonPath("$.data", is(60)));
    }

    @Test
    public void calculateTollFreeThrowBusinessException() throws Exception{
        // given
        TaxCalculateDTO dto = new TaxCalculateDTO();
        dto.setCity(CityType.NotExist);
        dto.setVehicle(VehicleType.Car);
        dto.setTimeline(loadTimeLine());
        // when
        ResultActions result = mockMvc.perform(post("/api/calculator/tollfee")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(dto)));
        gson.fromJson(result.andReturn().getResponse().getContentAsString(), ResponseDTO.class);
        // then
        result.andDo(print())
                .andExpect(status().is5xxServerError())
                .andExpect(jsonPath("$.success", is(false)))
                .andExpect(jsonPath("$.errorCode", is(500)))//business error code
                .andExpect(jsonPath("$.message", is("city[NotExist] cannot be found")))
                .andExpect(jsonPath("$.data", nullValue()));
    }

    private String[] loadTimeLine() {
        String[] datesArr = new String[]{
                "2013-01-14 21:00:00",
                "2013-01-15 21:00:00",
                "2013-02-07 06:23:27",
                "2013-02-07 15:27:00",
                "2013-02-08 06:27:00",
                "2013-02-08 06:20:27",
                "2013-02-08 14:35:00",
                "2013-02-08 15:29:00",
                "2013-02-08 15:47:00",
                "2013-02-08 16:01:00",
                "2013-02-08 16:48:00",
                "2013-02-08 17:49:00",
                "2013-02-08 18:29:00",
                "2013-02-08 18:35:00",
                "2013-03-26 14:25:00",
                "2013-03-28 14:07:27"
        };
        return datesArr;
    }
}