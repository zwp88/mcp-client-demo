package com.example.heart;

import io.modelcontextprotocol.client.McpSyncClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Administrator
 */
@Service
@Slf4j
public class McpHeartbeatService {
    private final List<McpSyncClient> mcpClients;

    public McpHeartbeatService(List<McpSyncClient> mcpClients) {
        this.mcpClients = mcpClients;
    }

    @Scheduled(fixedRate = 120000) // 每2分钟1次发送心跳
    public void sendHeartbeat() {
        try {
            log.info("McpSyncClient ping... ");
            this.mcpClients.parallelStream().forEach(client -> {client.ping();});
        } catch (Exception e) {
            log.warn("Heartbeat failed, triggering reconnect");
        }
    }

}