package org.phraseapp.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by cgallen
 */
@Controller
public class PageController {

    @RequestMapping("/changeLocale")
    public String homePage(){
        return "changeLocaleSpring";
    }
    
    @RequestMapping("/cookieLocale")
    public String cookieLocalePage(){
        return "cookieLocaleSpring";
    }
    
    @RequestMapping("/requestLocale")
    public String requestLocalePage(){
        return "requestLocaleSpring";
    }
    
    @RequestMapping("/sessionLocale")
    public String sessionLocalePage(){
        return "sessionLocaleSpring";
    }
    
    @RequestMapping("/welcome")
    public String welcomePage(){
        return "welcomeSpring";
    }

}
