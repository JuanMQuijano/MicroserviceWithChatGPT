package com.example.GPTMicroservice.controller;

import com.example.GPTMicroservice.model.Answer;
import com.example.GPTMicroservice.service.IGPTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class GPTController {

    @Autowired
    private IGPTService gptService;

    @GetMapping
    public ResponseEntity<List<Answer>> getAnswer(@RequestParam(name = "theme", required = true) String theme, @RequestParam(name = "total", required = true) int total) {
        return new ResponseEntity<>(gptService.makePrompt(theme, total), HttpStatus.OK);
    }

}
