package com.lambda.zoos.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller
{
    @GetMapping("/test")
    public ResponseEntity<?> doTest()
    {
        return new ResponseEntity<>("All Good", HttpStatus.OK);
    }
}
