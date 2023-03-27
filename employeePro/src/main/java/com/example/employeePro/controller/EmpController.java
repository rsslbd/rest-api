package com.example.employeePro.controller;

import com.example.employeePro.entity.Employee;
import com.example.employeePro.service.EmpService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("")
public class EmpController {

    @Autowired
    EmpService empService;

    @PostMapping("/emp/save")
    public String addEmp(@ModelAttribute Employee e, BindingResult bindResult) {
        try {
            if(bindResult.hasErrors()){
                return "emp_form/emp_form";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        empService.saveEmployee(e);
        return "redirect:/emp/list";
    }

    @GetMapping("/emp/list")
    public String getAll(Model model) {
        List<Employee> emp= empService.getAll();
        model.addAttribute("empList", emp);
        return "index";
    }

    @GetMapping("")
    public String getAllForm(Model model) {
        List<Employee> emp = empService.getAll();
        model.addAttribute("empList", emp);
        return "index";
    }

    @GetMapping("/emp/emp-form")
    public String addPage(Model model) {
        model.addAttribute("employee", new Employee());
        return "emp_form/emp_form";
    }

    @GetMapping("/emp/delete/{empId}")
    public String deleteEmp(@PathVariable("stdId") Long id) {
        empService.deleteEmpById(id);
        return "redirect:/emp/list";
    }

    @GetMapping("/emp/edit/{empId}")
    public String editEmp(@PathVariable("stdId") Long id, Model model) {
        Employee emp = empService.getEmp(id);
        model.addAttribute("employee", emp);
        return "emp_form/emp_form";
    }

}
