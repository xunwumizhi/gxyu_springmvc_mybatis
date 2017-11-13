package gxyu.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * <p>Title: HandlerInterceptor1</p>
 * <p>Description:测试拦截�? </p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2015-4-14下午4:45:47
 * @version 1.0
 */
public class HandlerInterceptor1 implements HandlerInterceptor {

	
	//进入 Handler方法之前执行
	//用于身份认证、身份授�?
	//比如身份认证，如果认证�?过表示当前用户没有登陆，�?��此方法拦截不再向下执�?
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		System.out.println("HandlerInterceptor1...preHandle");
		
		//return false表示拦截，不向下执行
		//return true表示放行
		return true;
	}

	//进入Handler方法之后，返回modelAndView之前执行
	//应用场景从modelAndView出发：将公用的模型数�?比如菜单导航)在这里传到视图，也可以在这里统一指定视图
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("HandlerInterceptor1...postHandle");
		
	}

	//执行Handler完成执行此方�?
	//应用场景：统�?��常处理，统一日志处理
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		System.out.println("HandlerInterceptor1...afterCompletion");
	}

}
