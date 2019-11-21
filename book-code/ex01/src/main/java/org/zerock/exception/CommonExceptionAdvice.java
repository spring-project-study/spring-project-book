package org.zerock.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class CommonExceptionAdvice {

    public String exception(Exception ex, Model model) {
        System.out.println(ex.getMessage());
        model.addAttribute("exception",ex);
        return "error_page";
    }
}
