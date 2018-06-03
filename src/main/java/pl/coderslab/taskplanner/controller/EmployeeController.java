package pl.coderslab.taskplanner.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.coderslab.taskplanner.model.Employee;
import pl.coderslab.taskplanner.model.UserRegistration;
import pl.coderslab.taskplanner.repository.EmployeeRepository;


@Controller
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	JdbcUserDetailsManager jdbcUserDetailsManager;

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

	@GetMapping("/addNewEmployee")
	public ModelAndView addNewEmployee() {

		Employee emp = new Employee();
		return new ModelAndView("newEmployee", "form", emp);

	}

	@PostMapping("/addNewEmployee")
	public String newEmployee(Employee employee) {

		employeeRepository.save(employee);
		return ("redirect:/getEmployees");
	}

	@GetMapping("/getEmployees")
	public ModelAndView employees() {
		List<Employee> allEmployees = employeeRepository.findAll();
		return new ModelAndView("allEmployees", "employees", allEmployees);
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() {
		return new ModelAndView("registration", "user", new UserRegistration());
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView processRegister(@ModelAttribute("user") UserRegistration userRegistrationObject) {

		// authorities to be granted
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

		String encodedPassword = bCryptPasswordEncoder.encode(userRegistrationObject.getPassword());

		User user = new User(userRegistrationObject.getUsername(), encodedPassword, authorities);
		jdbcUserDetailsManager.createUser(user);
		return new ModelAndView("redirect:/welcome");
	}

}