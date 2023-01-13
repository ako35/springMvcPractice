package com.tpe;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override // db ve hibernate ile ilgili config ayarlarinin yapildigi yer
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {
             RootContextConfig.class
			};
	}

	@Override // Spring-MVC ile ilgili config ayarlarinin yapildigi yer
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {
			WebMvcConfig.class	
		};
	}

	@Override // hangi url hangi servlet ile iliskilendireceginin belirlendigi yer
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	


}
