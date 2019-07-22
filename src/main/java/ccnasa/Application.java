package ccnasa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ccnasa.data.api.v1.LaunchResource;

@SpringBootApplication
public class Application {
	
	private static final Logger logger = LogManager.getLogger(Application.class);

	public static void main(String[] args) {
		logger.debug("Application for countdown launch started");
		SpringApplication.run(Application.class, args);
		Launch launch = new Launch
				.Builder()
				.launchTime(new LaunchConfig().seconds)
				.id(1)
				.build();
		LaunchResource.INSTANCE.addLaunch(launch);
	}
}