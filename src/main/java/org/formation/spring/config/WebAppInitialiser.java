package org.formation.spring.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * la configuration de Servlet
 * @author
 *
 */
public class WebAppInitialiser implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		// TODO Auto-generated method stub
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(WebConfig.class);
	
		container.addListener(new ContextLoaderListener(rootContext));
		
		
		DispatcherServlet dispatcherServlet = new DispatcherServlet(rootContext);
		
		
		ServletRegistration.Dynamic registration = container.addServlet("dispatcherServlet", dispatcherServlet);
		
		
		registration.setLoadOnStartup(1);
		registration.addMapping("/");
	
	
	}
}
