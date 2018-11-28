package microservices.hello.dto;

import java.io.Serializable;

public class Greetings implements Serializable {

	private static final long serialVersionUID = -255569305182454413L;
	private String content;

	public Greetings(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
