package com.kisonihc.spring.mvc_hibernate_aop.controller;

import com.kisonihc.spring.mvc_hibernate_aop.dao.EmployeeDAO;
import com.kisonihc.spring.mvc_hibernate_aop.entity.Employee;
import com.kisonihc.spring.mvc_hibernate_aop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {

    @Autowired   //// DI////
    private EmployeeService employeeService;

    @RequestMapping("/")
    public String showAllEmployees(Model model){ // Чтобы view смог отобразить значение полей employees нужно в методе контроллера создать Model и добавить работников в качестве атрибутов нашей model*

        List<Employee> allEmployees = employeeService.getAllEmployees();//*
        model.addAttribute("allEmps",allEmployees);//*

        return "all-employees";
    }
    @RequestMapping("/addNewEmployee")
    public String addNewEmployees(Model model){

       Employee employee = new Employee();
       model.addAttribute("employee",employee);

        return "employees-info";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){

    employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam("empId") int id, Model model){

        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee",employee);

        return "employees-info";
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("empId") int id){

        employeeService.deleteEmployee(id);

        return "redirect:/";
    }
}
// Controller работаем с бд через Service