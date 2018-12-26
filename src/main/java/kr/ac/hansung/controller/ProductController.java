package kr.ac.hansung.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.hansung.model.Product;
import kr.ac.hansung.model.User;
import kr.ac.hansung.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping("/admin/productinsert")
	public String productinsert(Model model, Principal principal) {
		model.addAttribute("product", new Product());
		return "productinsert";
	}

	@RequestMapping("/admin/productinsert/docreate")
	public String doCreate(Model model, @Valid Product product, BindingResult result,  Principal principal) {
		if (result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}
			return "productinsert";
		}
		productService.insert(product);
		return "home";

	}
	}