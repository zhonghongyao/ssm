package com.zhong.plugin;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		/*HttpSession session = request.getSession();
		Map<String,Object> user = (Map<String,Object>) session.getAttribute("user");
		String url = request.getRequestURI();
		if(url.indexOf("static") > 0||url.indexOf("/user/login")>0){
			return true;
		}
		if (user != null || url.indexOf("login") > 0 ) {
			//判断登录失效
			if(request.getSession(false)==null){
				response.sendRedirect(request.getContextPath() + "/user/loginOut");
				return false;
			}
			return true;
		}
		response.sendRedirect(request.getContextPath() + "/user/loginOut");
		return false;*/
		return true;
	}

}
