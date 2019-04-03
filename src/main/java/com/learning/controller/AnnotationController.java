package com.learning.controller;

//package com.zhao.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

@Controller
public class AnnotationController extends AbstractController{

    @Override
    @RequestMapping(value="annotationController")
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        System.out.println("AnnotationController Working.");
        return new ModelAndView("home");
    }

}
