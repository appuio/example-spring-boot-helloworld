package ch.appuio.techlab.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pod")
public class PodRestController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String pod(){
		return "Pod: " + System.getenv("HOSTNAME");
	}
}
