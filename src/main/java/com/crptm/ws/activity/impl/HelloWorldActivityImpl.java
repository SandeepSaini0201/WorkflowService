package com.crptm.ws.activity.impl;

import com.crptm.ws.activity.interfaces.IHelloWorldActivity;
import com.crptm.ws.exception.ActivityFailureException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloWorldActivityImpl implements IHelloWorldActivity {

    private static boolean isExceptionExist = true;

    @Override
    public String getGreetings() {
        return "Namaste India!";
    }

    @Override
    public void sayGreetings(String greeting) {
        System.out.print("Inside say greeting activity...");
        if (isExceptionExist) {
            isExceptionExist = false;
            throw new ActivityFailureException("Say greeting activity failed...");
        }
        System.out.println(greeting);
    }
}
