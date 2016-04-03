package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.content.Intent;
import android.test.ApplicationTestCase;
import android.text.TextUtils;

import java.util.concurrent.CountDownLatch;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {

    CountDownLatch signal = null;
    private String value;

    public ApplicationTest() {
        super(Application.class);
    }

    @Override
    protected void setUp() throws Exception {
        signal = new CountDownLatch(1);
    }

    @Override
    protected void tearDown() throws Exception {
        signal.countDown();
    }

    public void testAsyncTask() throws InterruptedException{
        EndpointsAsyncTask task = new EndpointsAsyncTask(getContext());
        task.setOnTaskCompletedListener(new OnTaskCompleted() {
            @Override
            public void onTaskCompleted(String result) {
                signal.countDown();
                value = result;
            }
        });
        task.execute();
        signal.await();

        assertNotNull(value);
        assertFalse(TextUtils.isEmpty(value));
    }
}