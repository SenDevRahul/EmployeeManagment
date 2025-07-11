package com.rahul.demo.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeCtrl {
	
	@GetMapping("/")
	public String index() {
		return "main";
	}
    
	@GetMapping("/main")
	public String main() {
		return "main";
	}
}
