package com.example;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.deepseek.DeepSeekChatModel;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

/**
 * @author Administrator
 */
@SpringBootApplication
public class McpClientDemoApplication {

    public static void main(String[] args) {

        System.setProperty("traceId", "req-"+ UUID.randomUUID().toString());
        System.setProperty("spring.application.name","mcp-client-demo");


        SpringApplication.run(McpClientDemoApplication.class, args);
    }


//    @Autowired
//    private ToolCallbackProvider tools;
//    @Autowired
//    DeepSeekChatModel chatModel;
//    @Bean
//    public CommandLineRunner predefinedQuestions(
//            ConfigurableApplicationContext context) {
//        return args -> {
//            // 构建ChatClient,注入mcp工具
//            var chatClient = ChatClient.builder(chatModel).defaultAdvisors(new SimpleLoggerAdvisor()).defaultToolCallbacks(tools.getToolCallbacks())
//                    .build();
//
//
//            // 使用ChatClient与LLM交互
//            String userInput = "重庆天气";
//            System.out.println("\n>>> QUESTION: " + userInput);
//            System.out.println("\n>>> ASSISTANT: " + chatClient.prompt().user(userInput).call().content());
//
//
//            context.close();
//        };
//    }

}
