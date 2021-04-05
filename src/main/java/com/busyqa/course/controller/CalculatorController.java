package com.busyqa.course.controller;

import java.awt.List;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    /*{1} Add a mapping annotation here.*/
	@GetMapping("/")
    public String show() {
        System.out.println("Showing Quadratic Calculator!!!");

        return "calculator";
    }

    /*{2} Add a mapping annotation here.*/
	@PostMapping("/solve")
    public String solve(Model model,
    		            /*{3} Replace the following {tag_?} by the proper name.*/
    		           @RequestParam("param_a") double a,
    		           @RequestParam("param_b") double b,
    		           @RequestParam("param_c") double c)  {

        double res1 = 0.0;
        double res2 = 0.0;

  
        /*
         * {4} Code the math of the formula detailed in the instructions to get 
         *     result1 and result2.
         */
        double sqrt = Math.pow(b, 2)-(4*a*c);
      
        if(sqrt >= 0)
        {
        	res1 = ((-b) + Math.sqrt(sqrt))/(2*a);
        	res2 = ((-b) - Math.sqrt(sqrt))/(2*a);
        }
        
        else
        {
        	sqrt = 0.0;
        	res1 = ((-b) + Math.sqrt(sqrt))/(2*a);
        	res2 = ((-b) - Math.sqrt(sqrt))/(2*a);
        	
        }
       
       
        /* 
         * When it's necessary to send more than one variable to the view 
         * (html template), the Spring Model object can be used instead of the 
         * ModelAndView object.
         */
        
        model.addAttribute("result1", res1);
        model.addAttribute("result2", res2);
 
        return "calculator";
    }
}
