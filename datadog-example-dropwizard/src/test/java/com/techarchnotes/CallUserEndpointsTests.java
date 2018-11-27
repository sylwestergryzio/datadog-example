package com.techarchnotes;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.http.client.fluent.Request;
import org.testng.annotations.Test;

public class CallUserEndpointsTests {

    @Test(invocationCount = 60, sequential = true, threadPoolSize = 1, groups = "a")
    public void callUserLoginEndpointOncePerSecondForOneMinute() throws IOException, InterruptedException {
        callUserLoginEverySecond();
    }

    @Test(invocationCount = 120, sequential = true, threadPoolSize = 2, groups = "b", dependsOnGroups = "a")
    public void callUserLoginEndpointTwicePerSecondForTwoMinutes() throws IOException, InterruptedException {
        callUserLoginEverySecond();
    }

    @Test(invocationCount = 1200, sequential = true, threadPoolSize = 10, dependsOnGroups = "b")
    public void callUserLoginEndpoint10TimesPerSecondForTwoMinutes() throws IOException, InterruptedException {
        callUserLoginEverySecond();
    }

    private void callUserLoginEverySecond() throws IOException, InterruptedException {
        int intervalInSeconds = 1;
        String response = Request.Get("http://localhost:8080/user/login")
            .execute().returnContent().asString();
        assertEquals(response, "User has logged in");
        Thread.sleep(1000 * intervalInSeconds);
    }
}
