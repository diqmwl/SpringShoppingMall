package kr.ac.hansung.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.SubjectDAO;
import kr.ac.hansung.dao.UserDAO;
import kr.ac.hansung.model.Subject;
import kr.ac.hansung.model.User;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;

	public void insert(User user) {
		// TODO Auto-generated method stub
		userDAO.insert(user);
	}

}
