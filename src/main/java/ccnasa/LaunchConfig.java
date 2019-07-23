package ccnasa;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "launch")
public class LaunchConfig {
	
	private String countdown;
	
	public LaunchConfig() {}

	public String getCountdown() {
		return countdown;
	}

	public void setCountdown(String countdown) {
		this.countdown = countdown;
	}
	
}
