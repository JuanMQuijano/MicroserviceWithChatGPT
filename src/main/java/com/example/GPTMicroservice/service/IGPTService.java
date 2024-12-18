package com.example.GPTMicroservice.service;

import com.example.GPTMicroservice.model.Answer;

import java.util.List;

public interface IGPTService {

    List<Answer> makePrompt(String theme, int total);

}
