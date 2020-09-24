package com.eval.coronakit.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eval.coronakit.entity.ProductMaster;
import com.eval.coronakit.service.ProductService;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

	@Autowired
	ProductService productService;
	
	@GetMapping("/home")
	public String home() {
		return "admin-home";
	}
	
	@GetMapping("/product-entry")
	public String productEntry(Model model) {
		ProductMaster product = new ProductMaster();
		model.addAttribute("product", product);		
		return "add-new-item";
	}
	
	@PostMapping("/product-save")
	public ModelAndView productSave(@Valid @ModelAttribute ProductMaster product, BindingResult result ) {
		ModelAndView mv = new ModelAndView("show-all-item-admin");
		productService.addNewProduct(product);
		mv.addObject("products", productService.getAllProducts());
		return mv;
	}
	

	@GetMapping("/product-list")
	public ModelAndView productList(Model model) {
		return new ModelAndView("show-all-item-admin","products",productService.getAllProducts());
	}
	
	@GetMapping("/product-delete")
	public ModelAndView productDelete(@RequestParam("productId") int productId) {
		ModelAndView mv = new ModelAndView("show-all-item-admin");
		productService.deleteProduct(productId);
		mv.addObject("products", productService.getAllProducts());
		return mv;
	}
	
	
}
