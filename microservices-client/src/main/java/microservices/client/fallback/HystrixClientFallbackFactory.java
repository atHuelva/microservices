package microservices.client.fallback;

import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;
import microservices.client.service.GreetingsPhpFeignClient;

@Component
public class HystrixClientFallbackFactory implements FallbackFactory<GreetingsPhpFeignClient> {

	@Override
	public GreetingsPhpFeignClient create(Throwable arg0) {
		return new HystrixClientFallback(arg0);
	}

}