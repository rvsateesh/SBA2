package com.eval.coronakit.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping("/custom-login")
	public String login() {
		return "login-form";
	}
	
	
	  @RequestMapping("/login?logout") 
	  public String loginlogout() {
	  return"main-menu"; }
	 
	
	@RequestMapping("/custom-error")
	public String error() {
		return "error-page";
	}
	
	@RequestMapping("/validate")
	public String validate() {
		return "main-menu";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		return "login-form";
	}
	
}
