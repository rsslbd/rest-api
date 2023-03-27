package com.example.maven_jstl_template.controller;

import com.example.maven_jstl_template.entity.Student3;
import com.example.maven_jstl_template.service.Student3Service;
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
public class Student3Controller {

    @Autowired
    Student3Service stdService;

    @PostMapping("/std/save")
    public String addStd(@ModelAttribute Student3 std, BindingResult bindResult) {
        try {
            if(bindResult.hasErrors()){
                return "std_form/std_form";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        stdService.saveStudent(std);
        return "redirect:/std/list";
    }

    @GetMapping("/std/list")
    public String getAll(Model model) {
        List<Student3> std = stdService.getAll();
        model.addAttribute("stdList", std);
        return "index";
    }

    @GetMapping("")
    public String getAllForm(Model model) {
        List<Student3> std = stdService.getAll();
        model.addAttribute("stdList", std);
        return "index";
    }

    @GetMapping("/std/std-form")
    public String addPage(Model model) {
        model.addAttribute("student3", new Student3());
        return "std_form/std_form";
    }

    @GetMapping("/std/delete/{stdId}")
    public String deleteStd(@PathVariable("stdId") Long id) {
        stdService.deleteStdById(id);
        return "redirect:/std/list";
    }

    @GetMapping("/std/edit/{stdId}")
    public String editStd(@PathVariable("stdId") Long id, Model model) {
        Student3 std = stdService.getStd(id);
        model.addAttribute("student3", std);
        return "std_form/std_form";
    }

}
