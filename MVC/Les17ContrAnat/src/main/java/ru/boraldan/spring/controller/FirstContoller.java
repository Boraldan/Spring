package ru.boraldan.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstContoller {


//    ------------------------------------------> Les 17
//    @GetMapping("/hello")
//    public String fistHello(){
//        return "first/hello";
//    }
//
//    @GetMapping("/goodbye")
//    public String goodbye(){
//        return "first/goodbye";
//    }

//    ------------------------------------------> Les 18
//    @GetMapping("/hello")
//    public String fistHello(@RequestParam("name") String name,
//                            @RequestParam("surname") String surname) {
//        System.out.println("Hello, " + name + " " + surname);
//        return "first/hello";
//    }

//    @GetMapping("/hello")
//    public String fistHello(@RequestParam(value = "name", required = false) String name,
//                            @RequestParam(value = "surname", required = false) String surname) {
//        System.out.println("Hello, " + name + " " + surname);
//        return "first/hello";
//    }
//
//    @GetMapping("/goodbye")
//    public String goodbye(HttpServletRequest request) {
//        String name = request.getParameter("name");
//        String surname = request.getParameter("surname");
//        System.out.println("Goodbye, " + name + " " + surname);
//        return "first/goodbye";
//    }

    //    ------------------------------------------> Les 19
//    @GetMapping("/hello")
//    public String fistHello(@RequestParam(value = "name", required = false) String name,
//                            @RequestParam(value = "surname", required = false) String surname,
//                            Model model) {
//        model.addAttribute("message", "Hello, " + name + " " + surname);
//        return "first/hello";
//    }


    //    ------------------------------------------> Les 19 Задача с калькулятором


    @GetMapping("/calc")
    public String fistCalc(@RequestParam("a") int a,
                           @RequestParam("b") int b,
                           @RequestParam("action") String action,
                           Model model) {

//        double result;
//        switch (action) {
//            case "*":
//                result = a * b;
//                break;
//            case "division":
//                result = a / (double) b;
//                break;
//            case "subtraction":
//                result = a - b;
//                break;
//            case "plus":  // не использовать символ "*"  он куда-то пропадает
//                result = a + b;
//                break;
//            default:
//                result = 0;
//                break;
//        }
//        model.addAttribute("result", result);
        model.addAttribute("result", calcUp(a, b, action));  // через внешнюю функцию
        return "first/calc";
    }

    public double calcUp(int a, int b, String act) {
        double result;
        switch (act) {
            case "*":
                result = a * b;
                break;
            case "division":
                result = a / (double) b;
                break;
            case "subtraction":
                result = a - b;
                break;
            case "plus":  // не использовать символ "+"  он куда-то пропадает
                result = a + b;
                break;
            default:
                result = 0;
                break;
        }

        return result;
    }


}
