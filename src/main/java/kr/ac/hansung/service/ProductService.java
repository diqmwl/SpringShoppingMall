package kr.ac.hansung.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public int reviewcount(String productname) {
		// TODO Auto-generated method stub
		return productDAO.reviewcount(productname);
	}

	public List<Review> reviewsearch(int key) {
		// TODO Auto-generated method stub
		int startkey;
		int endkey;
		startkey = ((key - 1) * 10);
		return productDAO.reviewsearch(startkey);

	}

	public HashMap<String, Integer> paging(int allreview, int key) {
		// TODO Auto-generated method stub
		int displaynum = 10;
		int endPage;
		int startPage;
		int totalPage;
		totalPage = (int) Math.ceil(allreview / 10.0);
		endPage = (int) (Math.ceil(key / 10.0)) * 10;
		startPage = endPage - displaynum + 1;
		if(totalPage < endPage) endPage = totalPage;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("totalPage", totalPage);
		map.put("endPage", endPage);
		map.put("startPage", startPage);
		return map;
	}

}
