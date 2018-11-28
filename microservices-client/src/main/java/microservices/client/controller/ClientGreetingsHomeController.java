package microservices.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClientGreetingsHomeController {

	@RequestMapping("/")
	public String home() {
		return "index";
	}

}
