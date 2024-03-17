package de.wi22sea.demo.cats.repo;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import de.wi22sea.demo.cats.entity.Address;

public interface AddressRepository extends MongoRepository<Address, UUID> {
	
}
