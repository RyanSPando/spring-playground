package com.spring.playground;

import Service.MathService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/math")
public class QueryController{

    @GetMapping("/pi")
    public String pi() {
        return "3.141592653589793";
    }

    @GetMapping("/calculate")
    public String mathIt(@RequestParam(value = "operation", required = false) String operation, @RequestParam String x, @RequestParam String y) {
        return MathService.calculate(operation, x, y);
    }
}