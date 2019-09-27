package com.mitutor.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/home")
public class HomeController {
	@GetMapping("/landing")
	public String landing() {
		return "/landing/landing";
	}
}
