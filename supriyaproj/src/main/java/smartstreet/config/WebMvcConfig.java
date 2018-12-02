package smartstreet.config;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;

import smartstreet.dao.ISensorDao;
import smartstreet.dao.impl.SensorDaoImpl;
import smartstreet.service.ISensorService;
import smartstreet.service.impl.SensorServiceImpl;
 
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "smartstreet"})
public class WebMvcConfig implements WebMvcConfigurer {
 
   /**
    * View Resolver
    * @return InternalResourceViewResolver
    */
  /* @Bean
   public InternalResourceViewResolver resolver() {
      InternalResourceViewResolver resolver = new InternalResourceViewResolver();
      resolver.setViewClass(JstlView.class);
      resolver.setPrefix("/WEB-INF/views/jsp/");
      resolver.setSuffix(".jsp");
      return resolver;
   }*/
	
	 /**
	    * Configure TilesConfigurer.
	    */
	   @Bean
	   public TilesConfigurer tilesConfigurer(){
	       TilesConfigurer tilesConfigurer = new TilesConfigurer();
	       tilesConfigurer.setDefinitions(new String[] {"/WEB-INF/views/**/tiles.xml"});
	       tilesConfigurer.setCheckRefresh(true);
	       return tilesConfigurer;
	   }
	
	/**
     * Configure ViewResolvers to deliver preferred views.
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        TilesViewResolver viewResolver = new TilesViewResolver();
        registry.viewResolver(viewResolver);
    }
   
   @Override
   public void addResourceHandlers(ResourceHandlerRegistry registry) {

    // Register resource handler for CSS and JS
      registry.addResourceHandler("/bootstrap/**").addResourceLocations("/WEB-INF/views/jsp/bootstrap/");
   // Register resource handler for dist
      registry.addResourceHandler("/dist/**").addResourceLocations("/WEB-INF/views/jsp/dist/");
   // Register resource handler for plugins
      registry.addResourceHandler("/plugins/**").addResourceLocations("/WEB-INF/views/jsp/plugins/");
   }
   
  
   
   /**
    * Jackson for Json converter
    */
   public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
       Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
       builder.indentOutput(true);
       converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
   }
   
   /**
    * Resource Bundle for error messages
    * @return MessageSource
    */
   
   @Bean
   public MessageSource messageSource() {
      ResourceBundleMessageSource source = new ResourceBundleMessageSource();
      source.setBasename("messages");
      return source;
   }
   
   /**
    * Mongo DB instance for nosql DB
    * @return MongoDbFactory
    */
   
   @Bean
   public MongoDbFactory mongoDbFactory(){
	
	   MongoClientURI uri = new MongoClientURI(
			    "mongodb://iotcluster:iotcluster@iotcluster-shard-00-00-72f0t.mongodb.net:27017,iotcluster-shard-00-01-72f0t.mongodb.net:27017,iotcluster-shard-00-02-72f0t.mongodb.net:27017/admin?ssl=true&replicaSet=iotcluster-shard-0&authSource=admin");
	   return new SimpleMongoDbFactory(new MongoClient(uri),
			   "iotcluster");
	   
	  
			
   }
   
   /**
    * Mongo DB Template
    * @return MongoTemplate
    */
   
   @Bean
   public MongoTemplate mongoTemplate() {
	   return new MongoTemplate(mongoDbFactory());
   }
   
   
}
