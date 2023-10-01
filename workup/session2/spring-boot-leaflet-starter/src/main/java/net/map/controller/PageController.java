package net.map.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by pingwin on 27.10.16.
 */
@Controller
public class PageController {

    @RequestMapping("/")
    public String homePage(){
        return "index";
    }

}
