package gxyu.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * <p>Title: HandlerInterceptor1</p>
 * <p>Description:登陆认证拦截�?</p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2015-4-14下午4:45:47
 * @version 1.0
 */
public class LoginInterceptor implements HandlerInterceptor {

	
	//进入 Handler方法之前执行
	//用于身份认证、身份授�?
	//比如身份认证，如果认证�?过表示当前用户没有登陆，�?��此方法拦截不再向下执�?
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		//获取请求的url
		String url = request.getRequestURI();
		//判断url是否是公�?地址（实际使用时将公�?地址配置配置文件中）
		//这里公开地址是登陆提交的地址
		if(url.indexOf("login.action")>=0){
			//如果进行登陆提交，放�?
			return true;
		}
		
		//判断session
		HttpSession session  = request.getSession();
		//从session中取出用户身份信�?
		String username = (String) session.getAttribute("username");
		
		if(username != null){
			//身份存在，放�?
			return true;
		}
		
		//执行这里表示用户身份�?��认证，跳转登陆页�?
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		
		//return false表示拦截，不向下执行
		//return true表示放行
		return false;
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
