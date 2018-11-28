package microservices.client.dto;


public class GreetingsDto {

	protected String content;

	protected GreetingsDto() {
		this.content = "Hola";
	}

	public GreetingsDto(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

}
