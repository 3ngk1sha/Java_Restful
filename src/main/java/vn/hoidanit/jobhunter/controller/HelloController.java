package vn.hoidanit.jobhunter.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.hoidanit.jobhunter.util.error.IDInvalidException;

@RestController
public class HelloController {

    @GetMapping("/")
    @CrossOrigin
    public String getHelloWorld() throws IDInvalidException {

        return "Hello World";
    }
}
