package fr.diginamic.hello.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.hello.services.HelloService;

@RestController
@RequestMapping("/hello")
public class HelloControleur {
    HelloService helloService = new HelloService();

    @GetMapping
    public String direHello() {
        return helloService.salutations();
    }
}
