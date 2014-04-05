package com.mycompany.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {


	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		return "email";
	}

	
	// À¯È¿¼º 
	@RequestMapping(value="/validata_email.json", method = RequestMethod.GET)
	public @ResponseBody HashMap<String, Object> getJSON(String email) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		boolean result = Pattern.matches("[\\w\\~\\-\\.]+@[\\w\\~\\-]+(\\.[\\w\\~\\-]+)+",email.trim());
		map.put("result", result);
		map.put("email", email);

		return map;

	}
}