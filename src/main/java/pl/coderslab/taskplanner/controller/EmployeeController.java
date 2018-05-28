package pl.coderslab.taskplanner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.coderslab.taskplanner.model.Employee;
import pl.coderslab.taskplanner.repository.EmployeeRepository;


@Controller
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeData;

//	@RequestMapping(value = "/addNewEmployee.html", method = RequestMethod.POST)
//	public String newEmployee(Employee employee) {
//
//		employeeData.save(employee);
//		return ("redirect:/listEmployees");
//
//	}

	@PostMapping("/addNewEmployee")
	public String newEmployee(Employee employee) {

		employeeData.save(employee);
		return ("redirect:/listEmployees");
	}

	@RequestMapping(value = "/addNewEmployee", method = RequestMethod.GET)
	public ModelAndView addNewEmployee() {

		Employee emp = new Employee();
		return new ModelAndView("newEmployee", "form", emp);

	}

	@RequestMapping(value = "/listEmployees", method = RequestMethod.GET)
	public ModelAndView employees() {
		List<Employee> allEmployees = employeeData.findAll();
		return new ModelAndView("allEmployees", "employees", allEmployees);

	}

}