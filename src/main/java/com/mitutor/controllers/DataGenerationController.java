package com.mitutor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mitutor.entities.Authority;
import com.mitutor.entities.Person;
import com.mitutor.entities.Student;
import com.mitutor.entities.Subject;
import com.mitutor.entities.Topic;
import com.mitutor.entities.User;
import com.mitutor.entities.Tutor;
import com.mitutor.entities.TutoringSession;
import com.mitutor.entities.University;
import com.mitutor.service.IAuthorityService;
import com.mitutor.service.IPersonService;
import com.mitutor.service.IStudentService;
import com.mitutor.service.ISubjectService;
import com.mitutor.service.ITopicService;
import com.mitutor.service.ITutorService;
import com.mitutor.service.ITutoringSessionService;
import com.mitutor.service.IUniversityService;
import com.mitutor.service.IUserService;

@Controller
@RequestMapping("/dataGeneration")
public class DataGenerationController {

	@Autowired
	private IUniversityService universityService;

	@Autowired
	private IAuthorityService authorityService;

	@Autowired
	private IPersonService personService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IStudentService studentService;

	@Autowired
	private ITutorService tutorService;

	@Autowired
	private ITutoringSessionService tutoringSessionService;

	@Autowired
	private ISubjectService subjectService;

	@Autowired
	private ITopicService topicService;

	@GetMapping("/create")
	public String create() {
		System.out.println("Creando datos");
		try {

			createData();

		} catch (Exception e) {
			System.out.println("Hubo un error en crear");
		}

		return "/dataGeneration/create";
	}

	public void createData() throws Exception {
		// CREACION DE UNIVERSITIES
		University university = new University("Universidad Peruana de Ciencias Aplicadas");
		universityService.save(university);

		// CREACION DE AUTHORITIES
		Authority authority1 = new Authority("ROLE_TUTOR");
		Authority authority2 = new Authority("ROLE_STUDENT");
		authorityService.save(authority1);
		authorityService.save(authority2);

		// CREACION DE PERSONS
		Person person1 = new Person("tutorn_1", "tutora_1", 6);
		person1.setUniversity(university);
		Person person2 = new Person("tutorn_2", "tutora_2", 7);
		person2.setUniversity(university);
		Person person3 = new Person("tutorn_3", "tutora_3", 8);
		person3.setUniversity(university);
		Person person4 = new Person("studentn_1", "studenta_1", 2);
		person4.setUniversity(university);
		Person person5 = new Person("studentn_2", "studenta_2", 3);
		person5.setUniversity(university);
		Person person6 = new Person("studentn_3", "studenta_3", 4);
		person6.setUniversity(university);
		personService.save(person1);
		personService.save(person2);
		personService.save(person3);
		personService.save(person4);
		personService.save(person5);
		personService.save(person6);

		// CREACION DE USERS
		User user1 = new User("tutor1", "$2a$04$Zp8LT1rml6TEGRwCG40uv.ZnVd7R3wQvhZALoxcFNXQg7CxXhvDDW",
				"tutor1@hotmail.com", false);
		user1.setPerson(person1);
		user1.addAuthority(authority1);
		user1.addAuthority(authority2);
		User user2 = new User("tutor2", "$2a$04$Zp8LT1rml6TEGRwCG40uv.ZnVd7R3wQvhZALoxcFNXQg7CxXhvDDW",
				"tutor2@hotmail.com", false);
		user2.setPerson(person2);
		user2.addAuthority(authority1);
		user2.addAuthority(authority2);
		User user3 = new User("tutor3", "$2a$04$Zp8LT1rml6TEGRwCG40uv.ZnVd7R3wQvhZALoxcFNXQg7CxXhvDDW",
				"tutor3@hotmail.com", false);
		user3.setPerson(person3);
		user3.addAuthority(authority1);
		user3.addAuthority(authority2);
		User user4 = new User("student1", "$2a$04$Zp8LT1rml6TEGRwCG40uv.ZnVd7R3wQvhZALoxcFNXQg7CxXhvDDW",
				"student1@hotmail.com", false);
		user4.setPerson(person4);
		user4.addAuthority(authority2);
		User user5 = new User("student2", "$2a$04$Zp8LT1rml6TEGRwCG40uv.ZnVd7R3wQvhZALoxcFNXQg7CxXhvDDW",
				"student2@hotmail.com", false);
		user5.setPerson(person5);
		user5.addAuthority(authority2);
		User user6 = new User("student3", "$2a$04$Zp8LT1rml6TEGRwCG40uv.ZnVd7R3wQvhZALoxcFNXQg7CxXhvDDW",
				"student3@hotmail.com", false);
		user6.setPerson(person6);
		user6.addAuthority(authority2);
		userService.save(user1);
		userService.save(user2);
		userService.save(user3);
		userService.save(user4);
		userService.save(user5);
		userService.save(user6);

		// CREACION DE STUDENT
		Student student1 = new Student(0);
		Student student2 = new Student(0);
		Student student3 = new Student(0);
		Student student4 = new Student(0);
		Student student5 = new Student(0);
		Student student6 = new Student(0);
		student1.setPerson(person1);
		student2.setPerson(person2);
		student3.setPerson(person3);
		student4.setPerson(person4);
		student5.setPerson(person5);
		student6.setPerson(person6);
		studentService.save(student1);
		studentService.save(student2);
		studentService.save(student3);
		studentService.save(student4);
		studentService.save(student5);
		studentService.save(student6);

		// CREACION DE SUBJECTS
		Subject subject1 = new Subject("Calculo 2");
		Subject subject2 = new Subject("Fisica 1");
		Subject subject3 = new Subject("Programacion 1");
		subjectService.save(subject1);
		subjectService.save(subject2);
		subjectService.save(subject3);

		// CREACION DE SUBJECTS
		Topic topic1 = new Topic("Derivadas");
		topic1.setSubject(subject1);
		Topic topic2 = new Topic("Integrales");
		topic2.setSubject(subject1);
		Topic topic3 = new Topic("Limites");
		topic3.setSubject(subject1);
		Topic topic4 = new Topic("MRU");
		topic4.setSubject(subject2);
		Topic topic5 = new Topic("MRUV");
		topic5.setSubject(subject2);
		Topic topic6 = new Topic("MCU");
		topic6.setSubject(subject2);
		Topic topic7 = new Topic("Arreglos");
		topic7.setSubject(subject3);
		Topic topic8 = new Topic("Estructuras");
		topic8.setSubject(subject3);
		Topic topic9 = new Topic("Ciclos");
		topic9.setSubject(subject3);
		topicService.save(topic1);
		topicService.save(topic2);
		topicService.save(topic3);
		topicService.save(topic4);
		topicService.save(topic5);
		topicService.save(topic6);
		topicService.save(topic7);
		topicService.save(topic8);
		topicService.save(topic9);

		// CREACION DE TUTOR
		Tutor tutor1 = new Tutor(0, "description_1");
		Tutor tutor2 = new Tutor(0, "description_2");
		Tutor tutor3 = new Tutor(0, "description_3");
		tutor1.setPerson(person1);
		tutor2.setPerson(person2);
		tutor3.setPerson(person3);
		tutor1.addSubject(subject1);
		tutor2.addSubject(subject2);
		tutor3.addSubject(subject3);
		tutorService.save(tutor1);
		tutorService.save(tutor2);
		tutorService.save(tutor3);

		// CREACION DE TUTORINGSESSIONS
		TutoringSession tutoringSession1 = new TutoringSession();
		tutoringSession1.setSubject(subject1);
		tutoringSession1.setTutor(tutor1);
		TutoringSession tutoringSession2 = new TutoringSession();
		tutoringSession2.setSubject(subject2);
		tutoringSession2.setTutor(tutor2);
		TutoringSession tutoringSession3 = new TutoringSession();
		tutoringSession3.setSubject(subject3);
		tutoringSession3.setTutor(tutor3);
		tutoringSessionService.save(tutoringSession1);
		tutoringSessionService.save(tutoringSession2);
		tutoringSessionService.save(tutoringSession3);
	}

	@GetMapping("/delete")
	public String delete() {
		try {

			deleteData();

		} catch (Exception e) {
			System.out.println("Hubo un error en eliminar");
		}

		return "/dataGeneration/delete";
	}

	public void deleteData() throws Exception {

		tutoringSessionService.deleteAll();
		tutorService.deleteAll();
		topicService.deleteAll();
		subjectService.deleteAll();
		studentService.deleteAll();
		userService.deleteAll();
		personService.deleteAll();
		authorityService.deleteAll();
		universityService.deleteAll();

	}
}
