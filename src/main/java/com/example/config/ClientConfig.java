package com.example.config;

import io.modelcontextprotocol.client.McpAsyncClient;
import io.modelcontextprotocol.client.McpSyncClient;
import jakarta.annotation.Resource;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.mcp.AsyncMcpToolCallbackProvider;
import org.springframework.ai.mcp.SyncMcpToolCallbackProvider;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfig {



    @Bean
    @ConditionalOnBean(McpSyncClient.class)
    public ToolCallbackProvider syncMcpToolCallbackProvider(McpSyncClient mcpSyncClient){
        return  new SyncMcpToolCallbackProvider(mcpSyncClient);
    }

    @Bean
    @ConditionalOnBean(McpAsyncClient.class)
    public ToolCallbackProvider asyncMcpToolCallbackProvider(McpAsyncClient mcpAsyncClient){
        return  new AsyncMcpToolCallbackProvider(mcpAsyncClient);
    }

}
