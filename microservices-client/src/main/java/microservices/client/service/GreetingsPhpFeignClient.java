package microservices.client.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import microservices.client.dto.GreetingsPhpDto;
import microservices.client.fallback.HystrixClientFallbackFactory;

@FeignClient(name = "sidecar", fallbackFactory = HystrixClientFallbackFactory.class)
public interface GreetingsPhpFeignClient {
	@RequestMapping(method = RequestMethod.GET, value = "/microservicio.php")
	public GreetingsPhpDto getSaludos();

}
