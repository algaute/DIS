package com.lab4tech.web.beans;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

public class CustomLogoutHandler implements LogoutHandler {
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {

	    //Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    //if (authentication != null){    
    	//    new SecurityContextLogoutHandler().logout(request, response, authentication);
    	//}
	    //return "redirect:/login?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
    	// business logic here
    }
}