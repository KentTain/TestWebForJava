package com.learning.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

@Controller
@RequestMapping("/home")
///home/**
public class HomeController extends AbstractController{
	private static Logger log = LoggerFactory.getLogger(HomeController.class);

	// /home/index
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model) {
		log.debug("/home/index");
		return "index";
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
