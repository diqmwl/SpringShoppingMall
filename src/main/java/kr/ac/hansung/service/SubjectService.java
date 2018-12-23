package kr.ac.hansung.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.SubjectDAO;
import kr.ac.hansung.model.Subject;

@Service
public class SubjectService {

	@Autowired
	private SubjectDAO subjectDAO;

	public List<Subject> getCurrent(String name) {
		return subjectDAO.getSubject(name);
	}
	
	public List<Subject> getCurrents(String name, String year, String semester) {
		return subjectDAO.getSubjects(name, year, semester);
	}

	public void insert(Subject subject, String username) {
		// TODO Auto-generated method stub
		subjectDAO.insert(subject, username);
	}
	
	public List<Subject> search(String username) {
		return subjectDAO.getSubjects(username, "2019", "1");
	}

}
