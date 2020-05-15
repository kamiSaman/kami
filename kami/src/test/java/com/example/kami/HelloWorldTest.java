package com.example.kami;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class HelloWorldTest {
	 @Test  
    public void testSayHello(){  
        HelloWorld helloWorld = new HelloWorld();  
        String result = helloWorld.sayHello();  
        assertEquals( "Hello Maven", result );  
    }  
}
