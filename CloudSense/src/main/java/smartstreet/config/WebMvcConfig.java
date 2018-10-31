package smartstreet.config;


import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.mongodb.MongoClient;
 
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "smartstreet"})
public class WebMvcConfig implements WebMvcConfigurer {
 
   /**
    * View Resolver
    * @return InternalResourceViewResolver
    */
   @Bean
   public InternalResourceViewResolver resolver() {
      InternalResourceViewResolver resolver = new InternalResourceViewResolver();
      resolver.setViewClass(JstlView.class);
      resolver.setPrefix("/WEB-INF/views/");
      resolver.setSuffix(".jsp");
      return resolver;
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
   public MongoDbFactory mongoDbFactory() {
	   return new SimpleMongoDbFactory(new MongoClient("localhost",27017),"cloudsenseiotdb");
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
