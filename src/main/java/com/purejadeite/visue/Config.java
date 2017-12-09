/* */
package com.purejadeite.visue;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.purejadeite.server.filter.CORSFilter;

@Configuration
public class Config extends WebMvcConfigurerAdapter {
	  @Bean
	  public FilterRegistrationBean newCORSFilter() {
	    FilterRegistrationBean bean = new FilterRegistrationBean();
	    bean.setFilter(new CORSFilter());
	    bean.setOrder(1);
	    return bean;
	  }

//	  @Bean
//	  public ServletRegistrationBean newClientLogServlet() {
//		  ServletRegistrationBean bean = new ServletRegistrationBean();
//	    bean.setServlet(new ClientLogServlet());
//	    bean.addUrlMappings("/log/*");
//	    bean.setOrder(1);
//	    return bean;
//	  }
}
