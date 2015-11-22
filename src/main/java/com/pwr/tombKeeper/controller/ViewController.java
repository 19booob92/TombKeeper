package com.pwr.tombKeeper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

	@RequestMapping(value = "/")
	public String getMainView() {
		return "user.html";
	}
	
}
