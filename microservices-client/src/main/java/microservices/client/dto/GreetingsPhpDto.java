package microservices.client.dto;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("GreetingsPhpDto")
public class GreetingsPhpDto {

	protected String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
