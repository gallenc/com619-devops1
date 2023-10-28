package org.solent.com619.devops.user.spring.web;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
 
@Configuration
public class MVCConfig implements WebMvcConfigurer {
	
    @Autowired
    private Environment env;
 
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        exposeDirectory("/user-photos/", registry);
    }
     
    private void exposeDirectory(String dirName, ResourceHandlerRegistry registry) {
		
    	String savePath = env.getProperty("image.file.uploadpath");
    	
        Path uploadDir = Paths.get(savePath+"/"+dirName);
        String uploadPath = uploadDir.toFile().getAbsolutePath();
        String resourceLocations = "file:/"+ uploadPath + "/";

        if (dirName.startsWith("../")) dirName = dirName.replace("../", "");
         
        registry.addResourceHandler("/" + dirName + "/**").addResourceLocations(resourceLocations);
    }
    
}