package com.java.onfire.controller;

import com.java.onfire.entity.Actor;
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
    void should_save_an_actor() {
        Actor actor = new Actor(1L, "Monica", "Geller");
        ResponseEntity<Actor> response = restTemplate.postForEntity("/api/actors", actor, Actor.class);

        Assertions.assertThat(response.getBody().getId()).isEqualTo(1);
        Assertions.assertThat(response.getBody().getFirstname()).isEqualTo("Monica");
        Assertions.assertThat(response.getBody().getLastname()).isEqualTo("Geller");
    }

}