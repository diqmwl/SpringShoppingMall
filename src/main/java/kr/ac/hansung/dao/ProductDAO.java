package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Product;
import kr.ac.hansung.model.Review;

@Repository
public class ProductDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public boolean insert(Product product) {
		// TODO Auto-generated method stub
		String product_name = product.getProduct_name();
		int product_price = product.getProduct_price();
		String product_desc = product.getProduct_desc();
		String product_url = product.getProduct_url();
		String sqlStatement = "insert into product (product_name, product_price, product_desc, product_url) values (?, ?, ?, ?)";
		return jdbcTemplate.update(sqlStatement,
				new Object[] { product_name, product_price, product_desc, product_url }) == 1;
	}

	public List<Product> search() {
		// TODO Auto-generated method stub
		String sqlStatement = "select * from product";
		return jdbcTemplate.query(sqlStatement, new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Product product = new Product();
				product.setProduct_id(rs.getInt("product_id"));
				product.setProduct_name(rs.getString("product_name"));
				product.setProduct_price(rs.getInt("product_price"));
				product.setProduct_desc(rs.getString("product_desc"));
				product.setProduct_url(rs.getString("product_url"));
				return product;
			}
		});

	}

	public List<Product> detailsearch(String productname) {
		// TODO Auto-generated method stub
		String sqlStatement = "select * from product where product_name = ?";
		return jdbcTemplate.query(sqlStatement, new Object[] { productname }, new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Product product = new Product();
				product.setProduct_id(rs.getInt("product_id"));
				product.setProduct_name(rs.getString("product_name"));
				product.setProduct_price(rs.getInt("product_price"));
				product.setProduct_desc(rs.getString("product_desc"));
				product.setProduct_url(rs.getString("product_url"));
				return product;
			}
		});
	}

	public boolean reviewinsert(Review review) {
		// TODO Auto-generated method stub
		String username = review.getUsername();
		String product_name = review.getProduct_name();
		String review_desc = review.getReview_desc();
		int score = review.getScore();
		String date = review.getDate();
		String sqlStatement = "insert into review (username, product_name, review_desc, score, date) values (?, ?, ?, ?, ?)";
		return jdbcTemplate.update(sqlStatement,
				new Object[] { username, product_name, review_desc, score, date }) == 1;
	}

	public Integer reviewcount(String productname) {
		// TODO Auto-generated method stub
		String sqlStatement = "select count(*) from review where product_name = ?";
		return jdbcTemplate.queryForObject(sqlStatement, new Object[] { productname }, Integer.class);
	}

	public List<Review> reviewsearch(int startkey) {
		// TODO Auto-generated method stub
		String sqlStatement = "select * from review limit ?, ?";
		return jdbcTemplate.query(sqlStatement, new Object[] { startkey, 10 }, new RowMapper<Review>() {

			@Override
			public Review mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Review review = new Review();
				review.setUsername(rs.getString("username"));
				review.setProduct_name(rs.getString("product_name"));
				review.setReview_desc(rs.getString("review_desc"));
				review.setScore(rs.getInt("score"));
				review.setDate(rs.getString("date"));
				
				return review;
			}

		});
	}

}
