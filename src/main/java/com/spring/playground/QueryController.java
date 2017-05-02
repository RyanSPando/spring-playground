package com.spring.playground;

import Service.MathService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/sum")
    public String sum(@RequestParam List<String> n) {
        return MathService.sum(n);
    }

}