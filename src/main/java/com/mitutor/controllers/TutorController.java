package com.mitutor.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mitutor.entities.Subject;
import com.mitutor.entities.Topic;
import com.mitutor.entities.Tutor;
import com.mitutor.entities.TutoringSession;
import com.mitutor.service.ISubjectService;
import com.mitutor.service.ITopicService;
import com.mitutor.service.ITutorService;
import com.mitutor.service.ITutoringSessionService;
import com.mitutor.viewEntities.publishTutoringView;
import com.mitutor.viewEntities.topicView;

@Controller
@RequestMapping("/tutors")
public class TutorController {

	@Autowired
	private ISubjectService subjectService;
	@Autowired
	private ITutorService tutorService;
	@Autowired
	private ITopicService topicService;
	@Autowired
	private ITutoringSessionService tutoringService;

	@InitBinder
	public void bindingPreparation(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm");
		CustomDateEditor orderDateEditor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, orderDateEditor);
	}

	@ModelAttribute("allSubjects")
	public List<Subject> populateSubjects() throws Exception {
		//ArrayList<Subject> subjects = (ArrayList<Subject>) subjectService.findAll();
		return (ArrayList<Subject>) subjectService.findAll();
	}

	@GetMapping("/getTopics")
	public @ResponseBody List<topicView> findTopics(@RequestParam(value = "subjectId", required = true) int subjectId)
			throws Exception {

		System.out.println(subjectId);
		List<Topic> topics = topicService.findBySubject(new Integer(subjectId));
		List<topicView> topicViews = new ArrayList<topicView>();

		for (Topic topic : topics) {
			topicViews.add(new topicView(topic.getId(), topic.getName()));
		}

		return topicViews;
	}

	@GetMapping("/publishTutoringSessionInput")
	public String publishTutoringSession(Model model) {
		model.addAttribute("tutoringSession", new publishTutoringView());
		return "/tutor/publishTutoringSession";
	}
	
	
	

	@PostMapping("/publishTutoringSessionInputConfirmed")
	public String publishTutoringSessionPost(
			@ModelAttribute("tutoringSession") publishTutoringView _publishTutoringView, Model model) {

		TutoringSession tutoringSession = new TutoringSession();
		List<Topic> topics = new ArrayList<>();
		Tutor tutor;
		Topic topicAux;

		tutoringSession.setCapacity(_publishTutoringView.getCapacity());
		tutoringSession.setDay(_publishTutoringView.getDayString());
		tutoringSession.setDescription(_publishTutoringView.getDescription());
		tutoringSession.setStartTime(_publishTutoringView.getStartTime());
		tutoringSession.setEndTime(_publishTutoringView.getEndTime());
		tutoringSession.setPlace(_publishTutoringView.getPlace());

		try {

			tutoringSession.setSubject(subjectService.findById(_publishTutoringView.getSubjectId()).get());

			for (int i = 0; i < _publishTutoringView.getTopicId().size(); ++i) {
				topicAux=topicService.findById(_publishTutoringView.getTopicId().get(i)).get();
				topics.add(topicAux);
				
				topicAux.setTutoringSessions(new ArrayList<>(Arrays.asList(tutoringSession)));
				topicService.save(topicAux);
			}
			
			tutoringSession.setTopics(topics);
			tutor = tutorService.findById(1).get();
			
			tutoringSession.setTutor(tutor);

			
			tutor.setTutoringSessions(new ArrayList<>(Arrays.asList(tutoringSession)));

			tutoringService.save(tutoringSession);
			tutorService.save(tutor);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

		return "/person";
	}

}
