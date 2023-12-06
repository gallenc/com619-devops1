package org.solent.spring.map.controller;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
 
// see https://www.baeldung.com/spring-mvc-static-resources
@Configuration
public class MVCConfig implements WebMvcConfigurer {
    private static final Logger LOG = LogManager.getLogger(MVCConfig.class);
	
    @Autowired
    private Environment env;
 
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        exposeDirectory("user-photos", registry);
    }
     
    // this exposes the files directory as a resource 
    private void exposeDirectory(String dirName, ResourceHandlerRegistry registry) {
		
    	String savePath = env.getProperty("image.file.uploadpath",System.getProperty("image.file.uploadpath"));
    	//String savePath = System.getProperty("image.file.uploadpath");
    	
        Path uploadDir = Paths.get(savePath+"/"+dirName);
        String uploadPath = uploadDir.toFile().getAbsolutePath();
        String resourceLocations = "file://"+ uploadPath + "/";
        
        // this is a messy  workaround to fix windows path issues
        resourceLocations = resourceLocations.replace("file://C:", "file:///C:");

        if (dirName.startsWith("../")) dirName = dirName.replace("../", "");
        
        LOG.debug("handler: "+"/" + dirName + "/**"
        		+ " expose directory resource locations:"+resourceLocations);
         
        registry.addResourceHandler("/" + dirName + "/**").addResourceLocations(resourceLocations);
    }
    
}