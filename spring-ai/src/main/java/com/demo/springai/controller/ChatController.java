package com.demo.springai.controller;

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
    public String getMessage(@RequestParam("message") String message) {
        ChatClient.CallResponseSpec call = chatClient.prompt(message).call();
        return call.content();
    }
}
