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

@Repository
public class SubjectDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int getRowCount() {
		String sqlStatement = "select count(*) from offers";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);

	}

	// query and return a sum grades object
	public List<Subject> getSubject(String username) {
		String sqlStatement = "select year, semester, sum(grades) from course where username = ? and year < ? group by year, semester";
		return jdbcTemplate.query(sqlStatement, new Object[] { username, "2019" }, new RowMapper<Subject>() {

			@Override
			public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Subject subject = new Subject();
				subject.setYear(rs.getInt("year"));
				subject.setSemester(rs.getInt("semester"));
				subject.setGrades(rs.getInt("sum(grades)"));
				return subject;
			}
		});
	}

	// query and return a multiple object
	public List<Subject> getSubjects(String username, String year, String semester) {
		String sqlStatement = "select * from course where username = ? and year = ? and semester = ?";
		return jdbcTemplate.query(sqlStatement, new Object[] { username, year, semester }, new RowMapper<Subject>() {

			@Override
			public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Subject subject = new Subject();
				subject.setYear(rs.getInt("year"));
				subject.setSemester(rs.getInt("semester"));
				subject.setSubjectcode(rs.getString("subjectcode"));
				subject.setSubjectname(rs.getString("subjectname"));
				subject.setDivision(rs.getString("division"));
				subject.setGrades(rs.getInt("grades"));
				return subject;
			}
		});
	}

	// insert query and return boolean
	public boolean insert(Subject subject, String name) {
		int year = subject.getYear();
		int semester = subject.getSemester();
		String subjectcode = subject.getSubjectcode();
		String subjectname = subject.getSubjectname();
		String division = subject.getDivision();
		int grades = subject.getGrades();
		String username = name;

		String sqlStatement = "insert into course (year, semester, subjectcode, subjectname, division, grades, username) values (?, ?, ?, ?, ?, ?, ?)";
		return (jdbcTemplate.update(sqlStatement,
				new Object[] { year, semester, subjectcode, subjectname, division, grades, username }) == 1);

	}
}
