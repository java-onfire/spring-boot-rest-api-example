package com.java.onfire.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ActorControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void should_return_hello_world() {
        ResponseEntity<String> response = restTemplate.getForEntity("/hello", String.class);
        String body = response.getBody();

        Assertions.assertThat(body).isEqualTo("hello world !");
    }

    @Test
    void should_return_hello_chris() {
        ResponseEntity<String> response = restTemplate.getForEntity("/api/hello?name=chris", String.class);
        String body = response.getBody();

        Assertions.assertThat(body).isEqualTo("hello chris !");
    }

    @Test
    void should_return_hello_bryan() {
        ResponseEntity<String> response = restTemplate.getForEntity("/api/hello/Bryan", String.class);
        String body = response.getBody();

        Assertions.assertThat(body).isEqualTo("hello Bryan !");
    }
}