package com.spring.playground;

import org.springframework.web.bind.annotation.*;

@RestController
public class EndPointsController {

    @GetMapping("")
    public String blankString() {
        return "Hello from Spring!";
    }

    @GetMapping("/")
    public String indexString() {
        return "Hello from Spring!";
    }

    @PostMapping("/messages")
    public String postString() {
        return "Post Return";
    }

    @PatchMapping("/messages")
    public String patchString() {
        return "Patch Return";
    }

    @DeleteMapping("/messages")
    public String deleteString() {
        return "Delete Return";
    }

    @GetMapping("/math/pi")
    public String pi() {
        return "3.141592653589793";
    }
}
