package com.fist.project.first_project.controller;

import com.fist.project.first_project.entity.Employee;
import com.fist.project.first_project.service.EmpService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/emp/")
@AllArgsConstructor
public class EmpController {
    @Autowired
    EmpService empService;
    @PostMapping("save")
    public String addUser(@ModelAttribute Employee employee,
                          BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return "add_emp/add_emp";
            }
        }catch (Exception e){e.printStackTrace();}
        empService.saveEmployee(employee);
        return "redirect:list";
    }
    List<Employee> employees;


    @GetMapping("list")
    public String getUsers(Model model) {
        employees = empService.getUsers();
        model.addAttribute("userList", employees);
        return "index";
    }


    @GetMapping("emp-form")
    public String addUserPage(Model model) {
        model.addAttribute("employee", new Employee());
        return "add_emp/add_emp";
    }

    @GetMapping("delete/{userId}")
    public String deleteUser(@PathVariable("userId") Long id) {
        empService.deleteUser(id);
        return "redirect:/emp/list";
    }

    @GetMapping("edit/{userId}")

    public String editUser(@PathVariable("userId") Long abc, Model model) {
        Employee employee = empService.getUser(abc);
        model.addAttribute("employee", employee);
        return "add_emp/add_emp";
    }
}
