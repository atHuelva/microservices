package microservices.client.service;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import microservices.client.dto.GreetingsDto;
import microservices.client.fallback.HystrixClientFallbackFactory;

@FeignClient(name="greetings-service", fallbackFactory = HystrixClientFallbackFactory.class)
public interface GreetingsFeignClient {
	  @RequestMapping(method = RequestMethod.GET, value = "/greetings/{name}")
	    GreetingsDto getGreetings(@PathVariable("name") String name);
}
