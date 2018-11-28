package microservices.hello.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import microservices.hello.dto.Greetings;

@RestController
public class HelloController {

	private static final String template = "Hello, %s!";

	@RequestMapping(method = RequestMethod.GET, path = "/greetings/{name}", produces = "application/json")
	public Greetings greeting(@PathVariable("name") String name) {
		return new Greetings(String.format(template, name));
	}
}
