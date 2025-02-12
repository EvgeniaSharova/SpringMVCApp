package ru.sharova.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {
        model.addAttribute("message", "hello " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculatorPage(@RequestParam("firstNumber") int firstNumber,
                                 @RequestParam("secondNumber") int secondNumber,
                                 @RequestParam(value = "action", required = false) String action,
                                 Model model) {
        switch (action) {

            case "addition":
                model.addAttribute("message", firstNumber + " + " + secondNumber + " = " + (firstNumber + secondNumber));
                break;

            case "subtraction":
                model.addAttribute("message", firstNumber + " - " + secondNumber + " = " + (firstNumber - secondNumber));
                break;

            case "division":
                model.addAttribute("message", firstNumber + " / " + secondNumber + " = " + (firstNumber / (double)secondNumber));
                break;

            case "multiplication":
                model.addAttribute("message", firstNumber + " * " + secondNumber + " = " + (firstNumber * secondNumber));
                break;
            default:
                model.addAttribute("message","action is unknown");
                break;
        }
        return "first/calculator";
    }
}
