package ccnasa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.event.EventListener;

import ccnasa.data.api.v1.LaunchResource;

@SpringBootApplication
@EnableConfigurationProperties
public class Application {
	
	private static final Logger logger = LogManager.getLogger(Application.class);
	
	@Autowired
	private LaunchConfig config;
	
	public static void main(String[] args) {
		logger.debug("Application for countdown launch started");
		SpringApplication.run(Application.class, args);
	}
	
	@EventListener(ApplicationReadyEvent.class)
	/**
	 * On application startup we setp-up the launch with the countdown loaded
	 * from application.properties
	 */
	public void startLaunch(){
		Launch launch = new Launch
				.Builder()
				.launchTime(Integer.valueOf(config.getCountdown()))
				.id(1)
				.build();
		LaunchResource.INSTANCE.addLaunch(launch);
	}
}