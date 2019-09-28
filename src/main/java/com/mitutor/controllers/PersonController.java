package com.mitutor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mitutor.entities.Tutor;
import com.mitutor.entities.TutoringSession;
import com.mitutor.service.ITutorService;
import com.mitutor.service.ITutoringSessionService;

@Controller
@RequestMapping("/person")
public class PersonController {

	@Autowired
	ITutorService tutorService;

	@Autowired
	ITutoringSessionService tutoringSessionService;

	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("tutorsFound", false);
		model.addAttribute("tutoringsFound", false);

		return "/person/index";
	}

	@GetMapping("/searchTutoringsBySubject")
	public String searchTutoringsBySubject(Model model, @RequestParam("subjectName") String subjectName) {

		try {
			List<Tutor> tutors = tutorService.findBySubjectName(subjectName);

			if (tutors.size() > 0) {
				model.addAttribute("tutorsFound", true);
				model.addAttribute("tutors", tutors);
			} else {
				model.addAttribute("tutorsFound", false);
			}

			List<TutoringSession> tutorings = tutoringSessionService.findBySubjectName(subjectName);

			if (tutorings.size() > 0) {
				model.addAttribute("tutoringsFound", true);
				model.addAttribute("tutorings", tutorings);
			} else {
				model.addAttribute("tutoringsFound", false);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/person/index";
	}

}
