package com.example.demo.Controller;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class HotelControllerTest {

    @Test
    public void testREST() throws IOException {

//        HttpUriRequest request =
//                new HttpGet("http://ec2-3-139-98-176.us-east-2.compute.amazonaws.com/hotel");
//        CloseableHttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
//
//        assertThat(
//
//                httpResponse.getStatusLine().getStatusCode(),
//                equalTo(HttpStatus.OK.value())
//
//        );
    }
}
