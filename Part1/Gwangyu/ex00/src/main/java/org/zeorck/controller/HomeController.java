package org.zeorck.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
    public static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    @RequestMapping(value = "/")
    public String Home(ModelMap model){

        logger.info("Logger");
        model.put("Title","Hello");

        return "index";
    }
}
