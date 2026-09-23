package com.initilizers;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.config.WebAppConfig;
 
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
 
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}
 
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebAppConfig.class };
	}
	
	
	//allows dispatcherservlet to handle requests coming from root ("/")  of applications...
	@Override  
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
 
}
