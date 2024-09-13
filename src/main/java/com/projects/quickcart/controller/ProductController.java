package com.projects.quickcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projects.quickcart.service.BuyerService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProductController {
	@Autowired
	private BuyerService bService;

	@GetMapping("/products")
	public ModelAndView productsView(@RequestParam(required = false) String category) {
		ModelAndView mView = new ModelAndView("products");
		mView.addObject("producs", bService.getProducts(category));
		return mView;
	}

	@GetMapping("/products/{id}")
	public ModelAndView productInfoView(@PathVariable long id, HttpSession session) {
		ModelAndView mView = new ModelAndView("product-info");
		var id1 = (Long) session.getAttribute("userId");
		if (id1 != null) {
			boolean isWishlisted = bService.isProductWishlisted(id1, id);
			mView.addObject("wishlisted", isWishlisted);
			mView.addObject("inCart", bService.isProductInCart(id1, id));
		}
		mView.addObject("product", bService.getProduct(id));
		return mView;
	}
}
