package com.crptm.ws.workflow.impl;

import com.amazonaws.services.simpleworkflow.flow.core.Promise;
import com.crptm.ws.activity.interfaces.IHelloWorldActivityClient;
import com.crptm.ws.activity.interfaces.IHelloWorldActivityClientImpl;
import com.crptm.ws.workflow.interfaces.IHelloWorldWorkflow;

public class HelloWorldWorkflowImpl implements IHelloWorldWorkflow {

    private final IHelloWorldActivityClient helloWorldActivityClient = new IHelloWorldActivityClientImpl();

    @Override
    public void greet() {
        /*get greetings*/
        Promise<String> greetings = this.helloWorldActivityClient.getGreetings();

        /*say greeting*/
        this.helloWorldActivityClient.sayGreetings(greetings);
    }
}
