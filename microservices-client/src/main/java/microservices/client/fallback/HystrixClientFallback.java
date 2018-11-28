package microservices.client.fallback;

import microservices.client.dto.GreetingsDto;
import microservices.client.dto.GreetingsPhpDto;
import microservices.client.service.GreetingsFeignClient;
import microservices.client.service.GreetingsPhpFeignClient;

public class HystrixClientFallback implements GreetingsPhpFeignClient, GreetingsFeignClient {

	private final Throwable cause;

	public HystrixClientFallback(Throwable cause) {
		this.cause = cause;
	}

	@Override
	public GreetingsPhpDto getSaludos() {
		GreetingsPhpDto failObject = new GreetingsPhpDto();
		failObject.setName(String.format("Microservice not available. Reason: %s", cause.getMessage()));
		return failObject;
	}

	@Override
	public GreetingsDto getGreetings(String name) {
		return new GreetingsDto(String.format("Microservice not available. Reason: %s", cause.getMessage()));
	}

}
