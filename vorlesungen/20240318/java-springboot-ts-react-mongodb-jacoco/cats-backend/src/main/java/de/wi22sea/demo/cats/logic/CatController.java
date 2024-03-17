package de.wi22sea.demo.cats.logic;

import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.wi22sea.demo.cats.entity.Cat;
import de.wi22sea.demo.cats.entity.CatDAO;
import de.wi22sea.demo.cats.repo.CatRepository;

@Controller
@RestController
@RequestMapping("/cats")
public class CatController {
	
	@Autowired
	private CatRepository catRepository;
	
	@Autowired
	private CatFactory factory;

    @GetMapping("")
    public ResponseEntity<Object> getAll(){
        return new ResponseEntity<Object>(catRepository.findAll(), HttpStatus.OK); // Recap: Code "200" steht für "OK"
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getById(@PathVariable UUID id){
        try {
            return new ResponseEntity<Object>(catRepository.findById(id).get(), HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<Object>("Cat with the id " + id + " could not be found", HttpStatus.NOT_FOUND); // Recap: Code "404" steht für "Not Found"
        }
    }

    @GetMapping("name/{name}")
    public ResponseEntity<Object> getById(@PathVariable String name){
        try {
            return new ResponseEntity<Object>(catRepository.findByFirstName(name).get(), HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<Object>("Cat with first name " + name + " could not be found", HttpStatus.NOT_FOUND); 
        }
    }

    @PostMapping("")
    public ResponseEntity<Object> add(@RequestBody CatDAO catDAO){
        try {
            Cat cat = factory.createFromDAO(catDAO);
            return new ResponseEntity<Object>(catRepository.save(cat), HttpStatus.CREATED); // Recap: Code "201" steht für "Created"
        } catch (NoSuchElementException e){
            return new ResponseEntity<Object>("Address with the id " + catDAO.getAddressID() + " could not be found", HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id){
        try{
            catRepository.delete(catRepository.findById(id).get());
            return new ResponseEntity<Object>("Cat with id " + id + " deleted", HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Object>("Cat with id " + id + " could not be found", HttpStatus.NOT_FOUND);
        }
    }

}
