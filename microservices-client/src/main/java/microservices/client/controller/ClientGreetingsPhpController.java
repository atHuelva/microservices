package microservices.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import microservices.client.dto.GreetingsPhpDto;
import microservices.client.service.GreetingsPhpFeignClient;

@Controller
public class ClientGreetingsPhpController {

	@Autowired
	protected GreetingsPhpFeignClient greetingsPhpFeignClient;

	@RequestMapping("/greetingsPhp/{name}")
	public String holaPhp(Model model, @PathVariable("name") String name) {

		GreetingsPhpDto greeting = greetingsPhpFeignClient.getSaludos();

		model.addAttribute("greetingsPhp", greeting.getName());

		return "greetingsPhp";
	}
}
