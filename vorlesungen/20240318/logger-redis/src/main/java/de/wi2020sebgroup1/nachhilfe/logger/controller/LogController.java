package de.wi2020sebgroup1.nachhilfe.logger.controller;

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

import de.wi2020sebgroup1.nachhilfe.logger.entity.Log;
import de.wi2020sebgroup1.nachhilfe.logger.entity.LogRepository;

@Controller
@RestController
@RequestMapping(value = "/log")
public class LogController {
	
	@Autowired
	LogRepository repo;
	
	@GetMapping(value = "/")
	public ResponseEntity<Iterable<Log>> getAll() {
		return new ResponseEntity<>(repo.findAll(),HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getSpecific(@PathVariable String id){
		try {
			return new ResponseEntity<Object>(repo.findById(id).get(), HttpStatus.OK);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Object>("Log "+id+" nicht gefunden.", HttpStatus.NOT_FOUND);
		}
	}
	
    @PostMapping(value = "/")
    public ResponseEntity<Log> save(@RequestBody Log l) {
    	Log log = new Log(UUID.randomUUID().toString(), l.getTitle(), l.getMessage(), l.getType(), l.getDate(), l.getTime(), l.getSource());
    	return new ResponseEntity<>(repo.save(log), HttpStatus.CREATED);
    }
	
    @DeleteMapping(value = "/reset")
    public ResponseEntity<Object> delete() {
    	repo.deleteAll();
		return new ResponseEntity<Object>("Alle Einträge gelöscht", HttpStatus.OK);
    }

}
