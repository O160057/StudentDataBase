package com.project.www;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.www.model.Student;
import com.project.www.repository.StudentRepository;

@Controller
public class HomeController {
	
	
	 @Autowired
	    private StudentRepository repo;

	    @GetMapping("/")
	    public String loginPage() {
	        return "index";
	    }

	    @GetMapping("/login")
	    public String login(@RequestParam String username, @RequestParam String password) {
	        if (username.equals("admin") && password.equals("admin")) {
	            return "form";
	        }
	        return "index";
	    }

	    @GetMapping("/form")
	    public String showForm(Model model) {
	        model.addAttribute("student", new Student());
	        return "form";
	    }

	    @PostMapping("/save")
	    public String saveStudent(@ModelAttribute Student student) {
	        repo.save(student);
	        return "redirect:/view";
	    }

	    @GetMapping("/view")
	    public String viewStudents(Model model) {
	    	List<Student> students = repo.findAll();
	        model.addAttribute("students", students);
	        return "view";
	    }

	    @GetMapping("/delete/{id}")
	    public String deleteStudent(@PathVariable Long id) {
	        repo.deleteById(id);
	        return "redirect:/view";
	    }
	    
	    @PostMapping("/update")
	    public String updateStudent(@ModelAttribute Student students) {
	    	repo.save(students);
	    	return "redirect:/view";
	    }

}
