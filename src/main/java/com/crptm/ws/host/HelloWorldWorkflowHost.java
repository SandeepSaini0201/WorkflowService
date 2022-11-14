package com.crptm.ws.host;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflowClientBuilder;
import com.amazonaws.services.simpleworkflow.flow.spring.SpringWorkflowWorker;
import com.crptm.ws.workflow.impl.HelloWorldWorkflowImpl;

public class HelloWorldWorkflowHost {

    public static void initializeWorkflows() throws InstantiationException, IllegalAccessException {
        AmazonSimpleWorkflow amazonSimpleWorkflow = AmazonSimpleWorkflowClientBuilder.standard()
                .withCredentials(new ProfileCredentialsProvider("default"))
                .withRegion(Regions.US_EAST_1)
                .build();

        SpringWorkflowWorker springWorkflowWorker = new SpringWorkflowWorker(amazonSimpleWorkflow, "TestingDomain", "NewTestingDomain");
        springWorkflowWorker.addWorkflowImplementation(new HelloWorldWorkflowImpl());
        springWorkflowWorker.start();
    }
}
