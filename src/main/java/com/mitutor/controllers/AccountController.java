package com.mitutor.controllers;

import java.io.Console;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.mitutor.entities.Person;
import com.mitutor.entities.University;
import com.mitutor.entities.User;
import com.mitutor.service.IPersonService;
import com.mitutor.service.IUniversityService;
import com.mitutor.service.IUserService;
import com.mitutor.util.Passgenerator;
import com.mitutor.viewModels.UserMaster;

@Controller
@RequestMapping("/")
public class AccountController{
	
	
	
	@Autowired
	private IUniversityService universityService;
	
	@Autowired
	private IPersonService personaService;
	
	
	@Autowired
	private IUserService userService;
	
	@GetMapping("/register")
	public String register(Model model) {
		try {
			model.addAttribute("listadoUniversidad", universityService.findAll());
			// System.out.println(universityService.findById(1).get().getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/register";


	}
	
    @RequestMapping(
    		value = "/register", 
    		method = RequestMethod.POST
    	)
    public RedirectView submit(@Valid @ModelAttribute("userMaster")UserMaster employee, 
      BindingResult result, ModelMap model) {
     
    	Optional<University> university;
		try {
			university = universityService.findById(Integer.valueOf(employee.getUniversity_id()));
			
			
			System.out.println(employee.getUniversity_id());
			
			
		 	Person nuevaPersona =  new Person();
		 	
	    	nuevaPersona.setName(employee.getName());
	    	
	    	nuevaPersona.setLastName(employee.getLastname());
	    	
	    	nuevaPersona.setSemester(Integer.valueOf(employee.getSemester()));	    		    	
	    	
	    	nuevaPersona.setUniversity(university.get());
			personaService.save(nuevaPersona);

	    	
	    	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
	    	
	    	User nuevoUser = new User();
	    	
	    	
	    	nuevoUser.setEnabled(false);
	    	nuevoUser.setEmail(employee.getEmail());
	    	nuevoUser.setUsername(employee.getUsername());
	    	nuevoUser.setPassword(bCryptPasswordEncoder.encode(employee.getPassword()));
	    	
	    	nuevoUser.setPerson(nuevaPersona);
	    	
	    	
	    	userService.save(nuevoUser);
	    	
			
			
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    		
 
        

        return new RedirectView("/login");
    }

}
