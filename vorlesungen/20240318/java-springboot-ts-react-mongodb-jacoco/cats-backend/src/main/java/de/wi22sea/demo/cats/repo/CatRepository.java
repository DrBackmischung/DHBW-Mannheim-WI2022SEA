package de.wi22sea.demo.cats.repo;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import de.wi22sea.demo.cats.entity.Cat;

public interface CatRepository extends MongoRepository<Cat, UUID> {
	
	Optional<Cat> findByFirstName(String firstName);
	
}
