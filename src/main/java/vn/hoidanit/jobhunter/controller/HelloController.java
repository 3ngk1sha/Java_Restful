package vn.hoidanit.jobhunter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.hoidanit.jobhunter.service.error.IDInvalidException;

@RestController
public class HelloController {

    @GetMapping("/")
    public String getHelloWorld() throws IDInvalidException {
        if (true)
            throw new IDInvalidException("check mate hoidanit");
        return "Hello World";
    }
}
