package com.volvo.congestion.aspect;

import com.volvo.congestion.calculator.domain.BusinessException;
import com.volvo.congestion.calculator.facade.dto.ResponseDTO;
import com.volvo.congestion.calculator.service.SystemException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * convert business exception and system exception to json format return to front-end
 *
 * @author Guitar
 * @version 0.1
 */
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
@RequiredArgsConstructor
public class GlobalExceptionHandlingControllerAdvice {
	
	@ResponseBody
	@ExceptionHandler(BusinessException.class)
	public ResponseDTO handleBusinessError(HttpServletResponse response, Exception exception) throws Exception {
		ResponseDTO errorResponse = new ResponseDTO();
		errorResponse.setSuccess(false);
		errorResponse.setErrorCode(500);
		errorResponse.setMessage(exception.getMessage());
		response.setStatus(500);// internal server error
//		log.error("Ops!", exception);
		return errorResponse;
	}

	@ResponseBody
	@ExceptionHandler(SystemException.class)
	public ResponseDTO handleSystemError(HttpServletResponse response, Exception exception) throws Exception {
		ResponseDTO errorResponse = new ResponseDTO();
		errorResponse.setSuccess(false);
		errorResponse.setErrorCode(501);
		errorResponse.setMessage(exception.getMessage());
		response.setStatus(500);// internal server error
		log.error("Ops!", exception);
		return errorResponse;
	}
}
