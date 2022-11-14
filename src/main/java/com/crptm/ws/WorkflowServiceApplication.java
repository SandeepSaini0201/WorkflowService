package com.crptm.ws;

import com.crptm.ws.host.HelloWorldActivityHost;
import com.crptm.ws.host.HelloWorldWorkflowHost;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.crptm.ws")
public class WorkflowServiceApplication {

    public static void main(String[] args) {
        initializeHosts();
        SpringApplication.run(WorkflowServiceApplication.class, args);
    }

    public static void initializeHosts() {
        try {
            HelloWorldWorkflowHost.initializeWorkflows();
            HelloWorldActivityHost.initializeActivities();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
