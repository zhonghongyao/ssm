package com.zhong.plugin;

import com.alibaba.fastjson.JSON;
import com.zhong.entiry.CustomException;
import com.zhong.entiry.ResultResponse;
import com.zhong.enums.ResponseCode;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomExceptionResolver implements HandlerExceptionResolver {

	private static Logger log = Logger.getLogger(CustomExceptionResolver.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                         Exception ex) {

		response.setStatus(HttpStatus.OK.value()); // 设置状态码
		response.setContentType(MediaType.APPLICATION_JSON_VALUE); // 设置ContentType
		response.setCharacterEncoding("UTF-8"); // 避免乱码
		response.setHeader("Cache-Control", "no-cache, must-revalidate");
		// 如果该 异常类型是系统 自定义的异常，直接取出异常信息。
		CustomException customException = null;
		try {
			if (ex instanceof CustomException) {
				customException = (CustomException) ex;
				// 错误信息
				String error = JSON
						.toJSONString(new ResultResponse(customException.getCode(), customException.getMessage()));
				response.getWriter().write(error);
			} else {
				response.getWriter().write(
						JSON.toJSONString(new ResultResponse(ResponseCode.FAIL)));
				ex.printStackTrace();
			}
		} catch (IOException e) {
			log.error("异常:" + e.getMessage(), e);
			e.printStackTrace();
		}
		ModelAndView modelAndView = new ModelAndView();
		return modelAndView;
	}

}
