package com.example.GPTMicroservice.service.impl;

import com.example.GPTMicroservice.model.Answer;
import com.example.GPTMicroservice.service.IGPTService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.converter.BeanOutputConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class GPTServiceImpl implements IGPTService {

    @Autowired
    private ChatClient chatClient;

    String prompt = """
            Quiero que me muestres una lista con los {total} primeros sitios Web, en orden de importancia, que incluyan tutoriales sobre {theme}. 
            El resultado me lo mostrarás en una lista JSON, donde cada objeto incluye los siguientes campos: "url"(direccion del sitio), 
            "descripcion"(breve descripción del sitio Web) y "valoracion"(imagina que eres un experto en la materia y dame tu valoración del sitio entre 1, que significa mal tutorial,  y 5, que sería un muy buen tutorial)
            """;

    @Override
    public List<Answer> makePrompt(String theme, int total) {
        BeanOutputConverter<Answer[]> parser = new BeanOutputConverter<>(Answer[].class);

        PromptTemplate template = new PromptTemplate(prompt);
        template.add("total", total);
        template.add("theme", theme);

        ChatResponse chatResponse = chatClient.prompt(template.create()).call().chatResponse();
        return Arrays.asList(parser.convert(chatResponse.getResult().getOutput().getContent()));
    }
}
