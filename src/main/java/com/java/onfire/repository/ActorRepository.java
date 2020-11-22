package com.java.onfire.repository;

import com.java.onfire.entity.Actor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends CrudRepository<Actor, Long> {

    List<Actor> findByLastname(String lastName);

}
