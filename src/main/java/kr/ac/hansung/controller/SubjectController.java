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

import kr.ac.hansung.model.Subject;
import kr.ac.hansung.service.SubjectService;

@Controller
public class SubjectController {

	@Autowired
	private SubjectService subjectService;

	@RequestMapping("/subject/grades")
	public String grades(Model model, Principal principal) {
		List<Subject> subject = subjectService.getCurrent(principal.getName());
		model.addAttribute("subject", subject);

		return "grades";
	}

	@RequestMapping("/subject/gradesdetail")
	public String gradesDetail(@RequestParam(value = "year", required = false) String year,
			@RequestParam(value = "semester", required = false) String semester, Model model, Principal principal) {
		List<Subject> subject = subjectService.getCurrents(principal.getName(), year, semester);
		model.addAttribute("subject", subject);

		return "gradesdetail";
	}

	@RequestMapping("/subject/apply")
	public String subjectApply(Model model) {
		model.addAttribute("subject", new Subject());
		return "subject";
	}
	
	@RequestMapping("/subject/docreate")
	public String doCreate(Model model, @Valid Subject subject, BindingResult result,  Principal principal) {
		if (result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}
			return "subject";
		}
		subjectService.insert(subject, principal.getName());
		return "home";

	}
	
	@RequestMapping("/subject/gradessearch")
	public String gradessearch(Model model, Principal principal) {
		List<Subject> subject = subjectService.search(principal.getName());
		model.addAttribute("subject", subject);

		return "gradessearch";

	}

}