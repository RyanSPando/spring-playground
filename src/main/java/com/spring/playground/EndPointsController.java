package com.spring.playground;

import org.springframework.web.bind.annotation.*;

@RestController
public class EndPointsController {

    @GetMapping("/")
    public String indexString() {
        return "This is the endpoint you are looking for";
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
}
