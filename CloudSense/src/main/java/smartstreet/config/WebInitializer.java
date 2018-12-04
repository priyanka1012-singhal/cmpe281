package smartstreet.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

/**
 * 
 * @return
 */
@Override
protected Class<?>[] getRootConfigClasses() { 
	//return new Class[] { WebMvcConfig.class };
	return new Class[] { SecurityConfig.class };
}

/**
 * 
 * @return
 */
@Override
protected Class<?>[] getServletConfigClasses() {
return new Class[] { WebMvcConfig.class };
}

/**
 * 
 * @return
 */
@Override
protected String[] getServletMappings() {
return new String[] { "/" };
}
}

