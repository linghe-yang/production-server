package com.server.productionserver.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-20T16:45:17.792097900+08:00[Asia/Shanghai]")

@Configuration
@ComponentScan(basePackages = {"com.server.productionserver.api", "com.server.productionserver.config"})
@EnableWebMvc
@PropertySource("classpath:application.properties")
@Import(OpenAPIDocumentationConfig.class)
public class OpenAPIUiConfiguration extends WebMvcConfigurerAdapter {
    private static final String[] SERVLET_RESOURCE_LOCATIONS = { "/" };

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/META-INF/resources/", "classpath:/resources/",
            "classpath:/static/", "classpath:/public/" };

    private static final String[] RESOURCE_LOCATIONS;
    static {
        RESOURCE_LOCATIONS = new String[CLASSPATH_RESOURCE_LOCATIONS.length
                + SERVLET_RESOURCE_LOCATIONS.length];
        System.arraycopy(SERVLET_RESOURCE_LOCATIONS, 0, RESOURCE_LOCATIONS, 0,
                SERVLET_RESOURCE_LOCATIONS.length);
        System.arraycopy(CLASSPATH_RESOURCE_LOCATIONS, 0, RESOURCE_LOCATIONS,
                SERVLET_RESOURCE_LOCATIONS.length, CLASSPATH_RESOURCE_LOCATIONS.length);
    }

    private static final String[] STATIC_INDEX_HTML_RESOURCES;
    static {
        STATIC_INDEX_HTML_RESOURCES = new String[RESOURCE_LOCATIONS.length];
        for (int i = 0; i < STATIC_INDEX_HTML_RESOURCES.length; i++) {
            STATIC_INDEX_HTML_RESOURCES[i] = RESOURCE_LOCATIONS[i] + "index.html";
        }
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (!registry.hasMappingForPattern("/webjars/**")) {
            registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        }
        if (!registry.hasMappingForPattern("/**")) {
            registry.addResourceHandler("/**").addResourceLocations(RESOURCE_LOCATIONS);
        }
    }

  /*@Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
            .allowedOrigins("*")
            .allowedMethods("*")
            .allowedHeaders("Content-Type");
  }*/

    @Bean
    public Jackson2ObjectMapperBuilder builder() {
        return new Jackson2ObjectMapperBuilder()
                .indentOutput(true)
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .modulesToInstall(new JsonNullableModule())
                .dateFormat(new RFC3339DateFormat());
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new MappingJackson2HttpMessageConverter(objectMapper()));
        converters.add(new StringHttpMessageConverter());
        super.configureMessageConverters(converters);
    }

    @Bean
    public ObjectMapper objectMapper(){
        return builder().build();
    }
}
