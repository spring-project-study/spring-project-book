package org.zeorck.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.logging.Logger;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String Home(ModelMap model){


        model.put("Title","Hello");

        return "index";
    }
}
