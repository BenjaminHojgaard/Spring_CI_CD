package com.example.demo.unit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DemoTest {


    @Test
    void addition() {
        assertEquals(1, 1);
    }

}
