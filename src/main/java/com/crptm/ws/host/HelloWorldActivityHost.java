package com.crptm.ws.host;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflowClientBuilder;
import com.amazonaws.services.simpleworkflow.flow.spring.SpringActivityWorker;
import com.crptm.ws.activity.impl.HelloWorldActivityImpl;

public class HelloWorldActivityHost {

    public static void initializeActivities() throws InstantiationException, IllegalAccessException, NoSuchMethodException {
        AmazonSimpleWorkflow amazonSimpleWorkflow = AmazonSimpleWorkflowClientBuilder.standard()
                .withCredentials(new ProfileCredentialsProvider("default"))
                .withRegion(Regions.US_EAST_1)
                .build();

        SpringActivityWorker springActivityWorker = new SpringActivityWorker(amazonSimpleWorkflow, "TestingDomain", "NewTestingDomain");
        springActivityWorker.addActivitiesImplementation(new HelloWorldActivityImpl());
        springActivityWorker.start();
    }
}
