package com.volvo.congestion.calculator.facade.rest;

import com.volvo.congestion.calculator.facade.dto.ResponseDTO;
import com.volvo.congestion.calculator.facade.dto.TaxCalculateDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.volvo.congestion.calculator.service.*;
/**
 * an entry point to call the calculation with different inputs over HTTP.
 *
 * @author Guitar
 * @version 0.1
 */
@RestController
@RequestMapping("/api/calculator")
@Api(tags = "tax calculator service")
public class TaxCalculatorServiceRest {

    @Autowired
    TaxCalculatorService taxCalculatorService;

    @RequestMapping(value = "/tollfee",method = RequestMethod.POST)
    @ApiOperation("calculate toll fee")
    public @ResponseBody ResponseDTO calculateTollFee(@RequestBody TaxCalculateDTO request){
        return new ResponseDTO(
                taxCalculatorService.calculatorCongestionTax(
                        request.getCity(),
                        request.getVehicle(),
                        TaxCalculateDTO.convertToDateArray(request.getTimeline())
                )
        );
    }


}
