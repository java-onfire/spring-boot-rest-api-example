package com.java.onfire.controller;

import com.java.onfire.entity.Actor;
import com.java.onfire.service.ActorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ActorController {

    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/api/actors/{id}")
    public Optional<Actor> findActorById(@PathVariable("id") int id) {
        return actorService.findActorById(id);
    }

    @GetMapping("/api/actors")
    public List<Actor> findActorByLastname(@RequestParam("lastname") String name) {
        return actorService.findActorByLastname(name);
    }

    @PostMapping("/api/actors")
    public Actor saveActor(@RequestBody Actor actor) {
        return actorService.saveActor(actor);
    }

}
