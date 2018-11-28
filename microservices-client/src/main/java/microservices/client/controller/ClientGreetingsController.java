package microservices.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import microservices.client.dto.GreetingsDto;
import microservices.client.service.GreetingsFeignClient;

@Controller
public class ClientGreetingsController {

	@Autowired
	private GreetingsFeignClient greetingsFeignClient;

	@RequestMapping("/greetings")
	public String goHome() {
		return "index";
	}

	@RequestMapping("/greetings/{name}")
	public String greeting(Model model, @PathVariable("name") String name) {

		GreetingsDto greeting = greetingsFeignClient.getGreetings(name);
		model.addAttribute("greeting", greeting.getContent());

		return "greeting";
	}

	
}
