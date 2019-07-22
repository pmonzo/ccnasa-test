package ccnasa;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "launch")
public class LaunchConfig {
	public int seconds;
	
	public LaunchConfig() {
		
	}
}
