package com.mitutor.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mitutor.entities.Student;
import com.mitutor.entities.TutoringSession;
import com.mitutor.repository.IStudentRepository;
import com.mitutor.repository.IUniversityRepository;
import com.mitutor.service.IStudentService;
import com.mitutor.service.ITutoringSessionService;
import com.mitutor.viewEntities.publishTutoringView;
import com.mitutor.viewEntities.tutoringSessionDetailView;

@Controller
@RequestMapping("/students")
public class studentController {

	@Autowired
	private ITutoringSessionService tutoringService;

	@Autowired
	private IStudentService studentService;

	@GetMapping("/tutoringSessionDetails/{studentId}/{tutoringId}")
	public String publishTutoringSession(@PathVariable(value = "studentId") Integer studentId,
			@PathVariable(value = "tutoringId") Integer tutoringId, Model model) throws Exception {

		TutoringSession tutoringSession = tutoringService.findById(tutoringId).get();
		tutoringSessionDetailView _tutoringSessionDetailView = new tutoringSessionDetailView();
		_tutoringSessionDetailView.setTutoringSession(tutoringSession);

		Student student = studentService.findById(studentId).get();
		_tutoringSessionDetailView.setStudentId(studentId);
		_tutoringSessionDetailView.setConfirmed(false);
		_tutoringSessionDetailView.setConfirmedStudents(tutoringSession.getStudents().size());

		for (TutoringSession t : student.getTutoringSessions()) {
			if (t.getId() == tutoringId)
				_tutoringSessionDetailView.setConfirmed(true);
		}

		model.addAttribute("_tutoringSession", _tutoringSessionDetailView);
		return "/student/tutoringDetail";
	}

	@PostMapping("/tutoringSessionDetailsConfirmed")
	public String publishTutoringSession(@ModelAttribute("_tutoringSession") tutoringSessionDetailView tutoringView,
			Model model) throws Exception {
		
		System.out.print(tutoringView.getStudentId().toString());

		if (!tutoringView.getConfirmed()) {
			Student student = studentService.findById(tutoringView.getStudentId()).get();
			TutoringSession tutoringSession = tutoringView.getTutoringSession();

			List<Student> students = new ArrayList<>();
			List<TutoringSession> tutoringSessions = new ArrayList<>();

			students.add(student);
			tutoringSessions.add(tutoringSession);

			tutoringView.getTutoringSession().setStudents(students);
			student.setTutoringSessions(tutoringSessions);

			tutoringService.save(tutoringSession);
			studentService.save(student);
		}

		return "/student";
	}

}
