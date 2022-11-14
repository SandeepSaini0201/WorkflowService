package com.crptm.ws.activity.interfaces;

import com.amazonaws.services.simpleworkflow.flow.annotations.Activities;
import com.amazonaws.services.simpleworkflow.flow.annotations.ActivityRegistrationOptions;
import com.amazonaws.services.simpleworkflow.flow.annotations.ExponentialRetry;
import com.crptm.ws.exception.ActivityFailureException;
import org.aspectj.lang.annotation.Aspect;

@Aspect
@Activities(version = "1.5")
@ActivityRegistrationOptions(defaultTaskScheduleToStartTimeoutSeconds = 300, defaultTaskStartToCloseTimeoutSeconds = 300)
public interface IHelloWorldActivity {

    String getGreetings();

    @ExponentialRetry(initialRetryIntervalSeconds = 1, maximumAttempts = 5, exceptionsToRetry = ActivityFailureException.class)
    void sayGreetings(final String greeting);
}
