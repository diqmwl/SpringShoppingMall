package kr.ac.hansung.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import kr.ac.hansung.model.Review;
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
	public String doCreate(Model model, @Valid Product product, BindingResult result, Principal principal) {
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
	
	@RequestMapping("/main/productlist")
	public String productlist(Model model, Principal principal) {
		
		List<Product> product = productService.search();
		model.addAttribute("product", product);
		return "product_list";
	}
	
	@RequestMapping("/main/productlist/detail")
	public String productlistdetail(@RequestParam(value="productname") String productname,  Model model, Principal principal) {
		
		List<Product> product = productService.detatilsearch(productname);
		model.addAttribute("product", product.get(0));
		model.addAttribute("review", new Review());
		return "product_listdetail";
	}
	
	@RequestMapping("/auth/review")
	public String review(Model model, @Valid Review review, BindingResult result, Principal principal) throws UnsupportedEncodingException {
		if (result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}
			return "product_listdetail";
		}
		review.setUsername(principal.getName());
		SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String time = format.format(date);
		System.out.println(time);
		review.setDate(time);
		System.out.println(review.getProduct_name());
		return "redirect:/main/productlist/detail?productname="+URLEncoder.encode(review.getProduct_name(), "UTF-8");
	}
}