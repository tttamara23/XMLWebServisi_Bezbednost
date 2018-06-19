package pi.vezbe.annotations;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import pi.vezbe.model.Korisnik;
import pi.vezbe.model.Permission;
import pi.vezbe.service.RoleService;
import pi.vezbe.service.UserService;

public class PermissionInterceptor implements HandlerInterceptor {
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserService userService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		Korisnik ulogovani = userService.getCurrentUser();
		
		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler; 
			Method method = handlerMethod.getMethod();
			String permissionName = null;
			if(method.getDeclaringClass().isAnnotationPresent(RestController.class)) {
				if(method.isAnnotationPresent(PermissionAnnotation.class)) {
					PermissionAnnotation annotation = method.getAnnotation(PermissionAnnotation.class);
					permissionName = annotation.name();
				} else {
					return true;
				}
			} else {
				return true;
			}
			
			if(ulogovani == null) {
				return false;
			}
			
			for(Permission permission : ulogovani.getRole().getPermissions()){
				
				if(permission.getName().equals(permissionName)){
					return true;
				}
			}
		
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
