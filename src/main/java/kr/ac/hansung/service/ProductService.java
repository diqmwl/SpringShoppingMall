package kr.ac.hansung.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.ProductDAO;
import kr.ac.hansung.model.Product;

@Service
public class ProductService {

	@Autowired
	private ProductDAO productDAO;

	public void insert(Product product) {
		// TODO Auto-generated method stub
		productDAO.insert(product);
	}
	
}
