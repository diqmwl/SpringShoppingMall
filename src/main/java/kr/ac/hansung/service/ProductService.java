package kr.ac.hansung.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.ProductDAO;
import kr.ac.hansung.model.Product;
import kr.ac.hansung.model.Review;

@Service
public class ProductService {

	@Autowired
	private ProductDAO productDAO;

	public void insert(Product product) {
		// TODO Auto-generated method stub
		productDAO.insert(product);
	}

	public List<Product> search() {
		// TODO Auto-generated method stub
		return productDAO.search();
	}

	public List<Product> detatilsearch(String productname) {
		// TODO Auto-generated method stub
		return productDAO.detailsearch(productname);
	}

	public Boolean reviewinsert(Review review) {
		// TODO Auto-generated method stub
		return productDAO.reviewinsert(review);
	}
	
}
