package org.zerock.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
    public static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    public HomeController() {
        System.out.println("contruct...");
    }

    @RequestMapping(value = "/")

    public String Home(ModelMap model){
        System.out.println("home.....");
        logger.debug("Logger","homeController");
        model.put("Title","Hello");

        return "index";
    }
}
