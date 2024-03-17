package de.wi22sea.demo.cats.logic;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.wi22sea.demo.cats.entity.Address;
import de.wi22sea.demo.cats.entity.Cat;
import de.wi22sea.demo.cats.entity.CatDAO;
import de.wi22sea.demo.cats.repo.AddressRepository;

@Service
public class CatFactory {
	
	@Autowired
	private AddressRepository addressRepository;
	
	public Cat createFromDAO(CatDAO catDAO) {
		Address address;
		try {
			address = addressRepository.findById(catDAO.getAddressID()).get();
		} catch (NoSuchElementException e){
			throw new NoSuchElementException();
        }
		Cat cat = new Cat(catDAO.getLastName(), 
						  catDAO.getFirstName(), 
						  address, 
						  catDAO.getColor(), 
						  catDAO.getAge());
		return cat;
	}
	
}
