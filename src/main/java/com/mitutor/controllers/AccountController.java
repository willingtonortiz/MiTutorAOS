package com.mitutor.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mitutor.entities.Authority;
import com.mitutor.entities.Person;
import com.mitutor.entities.Student;
import com.mitutor.entities.University;
import com.mitutor.entities.User;
import com.mitutor.service.IAuthorityService;
import com.mitutor.service.IPersonService;
import com.mitutor.service.IStudentService;
import com.mitutor.service.IUniversityService;
import com.mitutor.service.IUserService;
import com.mitutor.viewModels.UserMaster;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private IUniversityService universityService;

	@Autowired
	private IPersonService personService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IStudentService studentService;

	@Autowired
	private IAuthorityService authorityService;

	@GetMapping("/login")
	public String index() {
		return "/account/login";
	}

	@GetMapping("/register")
	public String register(Model model) {
		try {
			model.addAttribute("listadoUniversidad", universityService.findAll());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/account/register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String submit(@Valid @ModelAttribute("userMaster") UserMaster userMaster, BindingResult result,
			ModelMap model) {

		try {
			BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);

			Integer universityId = userMaster.getUniversityId();
			// Optional<University> university =
			// universityService.findById(Integer.valueOf(employee.getUniversity_id()));
			Optional<University> optionalUniversity = universityService.findById(universityId);
			University university = optionalUniversity.get();

			Person newPerson = new Person();
			newPerson.setName(userMaster.getName());
			newPerson.setLastName(userMaster.getLastname());
			newPerson.setSemester(userMaster.getSemester());
			newPerson.setUniversity(university);
			personService.save(newPerson);

			Optional<Authority> optionalAuthority = authorityService.findByAuthority("ROLE_STUDENT");
			Authority authority = optionalAuthority.get();

			User newUser = new User();
			newUser.setEnabled(false);
			newUser.setEmail(userMaster.getEmail());
			newUser.setUsername(userMaster.getUsername());
			newUser.setPassword(bCryptPasswordEncoder.encode(userMaster.getPassword()));
			newUser.setPerson(newPerson);
			newUser.addAuthority(authority);
			userService.save(newUser);

			Student student = new Student(0);
			student.setPerson(newPerson);
			studentService.save(student);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return "/account/login";
	}

}
