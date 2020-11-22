package com.java.onfire.service;

import com.java.onfire.entity.Actor;
import com.java.onfire.repository.ActorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {

    private final ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public Optional<Actor> findActorById(long id) {
        return actorRepository.findById(id);
    }

    public List<Actor> findActorByLastname(String name) {
        return actorRepository.findByLastname(name);
    }

    public Actor saveActor(Actor actor) {
        return actorRepository.save(actor);
    }
}
