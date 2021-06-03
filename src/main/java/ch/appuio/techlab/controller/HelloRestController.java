package ch.appuio.techlab.controller;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ch.appuio.techlab.model.Hello;
import ch.appuio.techlab.repository.HelloRepository;

@RestController
@RequestMapping("/hellos")
public class HelloRestController {
	private HelloRepository helloRepository;
	
	@Autowired
	public void setHelloRepository(HelloRepository helloRepository) {
		this.helloRepository = helloRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Hello> hellos(){
		return helloRepository.findAllByOrderByIdDesc();
	}
	
	@RequestMapping(value = "/{name}", method = RequestMethod.POST)
	public ResponseEntity<?> add(@PathVariable String name){

		Hello result = helloRepository.save(new Hello(name,
				new Date()));
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(result.getId()).toUri());
		return new ResponseEntity<>(result, httpHeaders, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{helloid}", method = RequestMethod.GET)
	public Optional<Hello> get(@PathVariable Long helloid) {
		return this.helloRepository.findById(helloid);
	}
}
