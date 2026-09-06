package com.demo.ollamas.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChatController {

    private final ChatClient chatClient;

    @GetMapping("/api/chat")
    public String getResponse(@RequestParam("message") String message) {
        return chatClient
                .prompt(message)
                .call()
                .content();
    }
}
