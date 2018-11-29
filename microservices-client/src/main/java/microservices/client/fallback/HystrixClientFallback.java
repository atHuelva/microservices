package microservices.client.fallback;

import com.netflix.hystrix.exception.HystrixTimeoutException;

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
		if (cause instanceof HystrixTimeoutException) {
			failObject.setName("Microservice not available. Timeout received");
		} else {
			failObject.setName(String.format("Microservice not available. Reason: %s", cause.getMessage()));
		}
		return failObject;
	}

	@Override
	public GreetingsDto getGreetings(String name) {
		GreetingsDto failObject;

		if (cause instanceof HystrixTimeoutException) {
			failObject = new GreetingsDto("Microservice not available. Timeout received");
		} else {
			failObject = new GreetingsDto(String.format("Microservice not available. Reason: %s", cause.getMessage()));
		}
		return failObject;
	}

}
