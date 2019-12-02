package org.zerock.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.logging.SimpleFormatter;

@Controller
@RequestMapping(value = "/sample/*")
public class SampleController {

    @RequestMapping("")
    public void basic() {
        System.out.println("basic.............");
    }

    @GetMapping(value = "get")
    public void basicGet(){
        System.out.println("basicGet");
    }

    @GetMapping(value = "get2")
    public void basicGet2(SampleDTOList list){
        System.out.println("basicGet");
        System.out.println(list);
    }
    //정리 필요
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat,false));
    }

    @GetMapping("ex03")
    public void ex03(TodoDTO todo){
        System.out.println(todo);

    }

    @GetMapping("ex04")
    public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
        System.out.println(dto);
        System.out.println(page);
        return "/sample/ex04";
    }
    //void 리턴
    @GetMapping("ex05")
    public void ex05(){
        System.out.println("ex05......");
    }

    //객체 리턴
    @GetMapping("ex06")
    public @ResponseBody SampleDTO ex06() {
        SampleDTO dto = new SampleDTO();
        dto.setName("aaa");
        dto.setAge(15);
        return dto;
    }

    @GetMapping("ex07")
    public ResponseEntity<String> ex07() {
        String msg="{\"name\": \"홍길동\"}";
        HttpHeaders header = new HttpHeaders();
        header.add("Content-type", "application/json;charset=UTF-8");

        return new ResponseEntity<String>(msg,header, HttpStatus.OK);

    }

    @PostMapping(value = "post")
    public void basicPost(){
        System.out.println("basicPost");
    }


}
