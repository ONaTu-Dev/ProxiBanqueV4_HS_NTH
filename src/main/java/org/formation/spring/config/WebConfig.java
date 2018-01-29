package org.formation.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


	/**
	 * La configuration de Web
	 * @author HS NTH
	 *
	 */
	@EnableWebMvc
	@Configuration
	@ComponentScan(basePackages= {"org.formation.spring"}, excludeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Configuration.class) })
	@Import({ProxiBanqueConfig.class})
	@PropertySource("classpath:application.properties")
	public class WebConfig extends WebMvcConfigurerAdapter{
		
		@Bean
		public InternalResourceViewResolver internalResourceViewResolver() {
			InternalResourceViewResolver resolver = new InternalResourceViewResolver();
			resolver.setPrefix("/WEB-INF/pages/");
			resolver.setSuffix(".jsp");
			return resolver;
		}
		
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**");
		}
		@Override
		public void addViewControllers(ViewControllerRegistry registry) {
			registry.addViewController("/").setViewName("login");
		}

		 @Override
		 public void addResourceHandlers(ResourceHandlerRegistry registry) {
			 
		 registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		
		 }
}
