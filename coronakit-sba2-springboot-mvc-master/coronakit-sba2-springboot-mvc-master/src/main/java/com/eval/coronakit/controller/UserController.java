package com.eval.coronakit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eval.coronakit.entity.CoronaKit;
import com.eval.coronakit.entity.KitDetail;
import com.eval.coronakit.entity.MyKit;
import com.eval.coronakit.entity.ProductMaster;
import com.eval.coronakit.service.CoronaKitService;
import com.eval.coronakit.service.KitDetailService;
import com.eval.coronakit.service.ProductService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CoronaKitService coronaKitService;
	
	@Autowired
	KitDetailService kitDetailService;
	
	@Bean
	public CoronaKit ckit() {
		return new CoronaKit();
	}
	
	@Bean
	public KitDetail mykit() {
		return new KitDetail();
	}
	
	@Bean
	public MyKit myCkit() {
		return new MyKit();
	}
	
	@RequestMapping("/home")
	public String home() {
		return "user-home";
	}
	
	@RequestMapping("/show-kit")
	public ModelAndView showKit() {
		List<KitDetail> kit = new ArrayList<KitDetail>();
		kit.addAll(kitDetailService.getAllKitItems());
		return new ModelAndView("show-cart", "kit", kit);
	}

	@RequestMapping("/show-list")
	public ModelAndView showList() {
		ModelAndView mv = new ModelAndView("show-all-item-user");
		mv.addObject("products", productService.getAllProducts());
		return mv;
	}
	
	/*
	 * @RequestMapping("/add-to-cart") public ModelAndView addToKit(@ModelAttribute
	 * ProductMaster product) { ModelAndView mv = new
	 * ModelAndView("show-all-item-user"); mv.addObject("products",
	 * productService.getAllProducts());
	 * 
	 * //mykit = new KitDetail((Integer) null, (Integer) null, product.getId(),
	 * 1,product.getCost());
	 * 
	 * mykit().setProductId(product.getId()); mykit().setQuantity(1);
	 * mykit().setAmount(product.getCost()*mykit().getQuantity());
	 * mykit().setCoronaKitId(ckit().getId());
	 * 
	 * kitDetailService.addKitItem(mykit()); return mv; }
	 */
	@RequestMapping("/add-to-cart")
	public ModelAndView addToKit(@ModelAttribute ProductMaster product) {
		ModelAndView mv = new ModelAndView("show-all-item-user");
		mv.addObject("products", productService.getAllProducts());
		myCkit().setProductId(product.getId());
		myCkit().setProductName(product.getProductName()); 
		myCkit().setCost(product.getCost());
		myCkit().setProductDescription(product.getProductDescription());
		myCkit().setAmount(product.getCost());
			 
		  kitDetailService.addKitItem(mykit());
		return mv;
	}
	
	@RequestMapping("/checkout")
	public String checkout(Model model) {
		return null;
	}
	
	@RequestMapping("/finalize")
	public String finalizeOrder(String address,Model model) {
		return null;
	}
	
	@RequestMapping("/delete/{itemId}")
	public String deleteItem(@PathVariable("itemId") int itemId) {
		return null;
	}
}
