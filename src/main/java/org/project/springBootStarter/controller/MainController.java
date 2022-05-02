package org.project.springBootStarter.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
//import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/home")
public class MainController {
    /*@RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/about")
    public String about() {
        return "About us";
    }*/

    /*@GetMapping("/")
    public ResponseEntity<String> getHome() {
        return ResponseEntity.of(Optional.of("Sweet home"));
    }*/
}
