package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Subject;
import kr.ac.hansung.model.User;

@Repository
public class UserDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int getRowCount() {
		String sqlStatement = "select count(*) from offers";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);

	}

	// insert query and return boolean
	public boolean insert(User user) {
		String username = user.getUsername();
		String password = user.getPassword();
		int enabled = user.getEnabled();
		

		String sqlStatement = "insert into users (username, password, enabled) values (?, ?, ?)";
		String sqlStatement2 = "insert into authorities (username, authority) values (?, ?)";
		
		
		return (jdbcTemplate.update(sqlStatement,
				new Object[] { username, password, enabled }) == 1) && (jdbcTemplate.update(sqlStatement2,
						new Object[] { username, "ROLE_USER" }) == 1);

	}
}
