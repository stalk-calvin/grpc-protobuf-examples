package com.calvin;

/*
 * Copyright Calvin Lee Since 2017.
 * All Rights Reserved.
 */

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

public class GreeterImplTest {
    private GreeterServer server = new GreeterServer();
    private GreeterClient fixture;

    @Before
    public void setUp() throws Exception {
        new Thread(() -> {
            try {
                server.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        fixture = new GreeterClient("localhost", 50051);
    }

    @Test
    public void shouldReceiveUsername() throws Exception {
        HelloReply r;
        try {
            String user = "world";
            r = fixture.greet(user);
        } finally {
            fixture.shutdown();
        }
        assertEquals("Hello world", r.getMessage());
    }


}
