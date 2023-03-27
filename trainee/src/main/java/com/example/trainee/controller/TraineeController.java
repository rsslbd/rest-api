package com.example.trainee.controller;

import com.example.trainee.entity.Trainee;
import com.example.trainee.service.TraineeService;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/trainee/")
@AllArgsConstructor
public class TraineeController {
@Autowired
    TraineeService traineeService;
@PostMapping("save")
    public String addTrainee(@ModelAttribute Trainee trainee, BindingResult bindingResult){
    try {
        if(bindingResult.hasErrors()){
            return "addTrainee/addTrainee";
        }

    }catch (Exception e){

        e.printStackTrace();
    }
   return "redirect:list";
}
List<Trainee> trainees;
@GetMapping("list")
    public String getTrainee(Model model){
    trainees = traineeService.getTrainee();
    model.addAttribute("traineeList",trainees);
    return "index";
}

}


