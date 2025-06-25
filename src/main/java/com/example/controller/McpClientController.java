package com.example.controller;


import jakarta.annotation.Resource;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemoryRepository;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/")
public class McpClientController {


    @Resource
    private  ChatClient.Builder chatClient;
    @Resource
    private ToolCallbackProvider toolCallbackProvider;





    @GetMapping("/mcpChat")
    public String mcpChat(@RequestParam("message") String message) {
        return chatClient.build()
                .prompt()
                .advisors(new SimpleLoggerAdvisor())
                .user(message)
                .toolCallbacks(toolCallbackProvider.getToolCallbacks())
                .call()
                .content();
    }
}
