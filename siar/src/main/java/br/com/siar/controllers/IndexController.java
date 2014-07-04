package br.com.siar.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	/**
	 * Testing URL request method. Returns the controller name to the view.
	 */
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public ModelAndView index(){
		logger.info("Testing index page. Thank you!");
		
		String friend = "Homer J. Simpson";
		
		return new ModelAndView("index", "friend", friend);
	}
}
