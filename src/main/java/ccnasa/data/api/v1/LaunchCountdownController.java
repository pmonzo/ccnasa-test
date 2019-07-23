package ccnasa.data.api.v1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ccnasa.ILaunch;
import io.micrometer.core.annotation.Timed;
import reactor.core.publisher.Mono;

@RestController
public class LaunchCountdownController {
	
	private static final Logger logger = LogManager.getLogger(LaunchCountdownController.class);
	
	public static final String API_V1_PACKAGES = "/api/v1/countdown";
	
	private final LaunchResource resource = LaunchResource.INSTANCE;
	
    public LaunchCountdownController() {
    }
    
    public class LaunchAllException  extends RuntimeException{
    	
    	/**
		 * 
		 */
		private static final long serialVersionUID = -4946571119787035020L;

		public LaunchAllException(Throwable t) {
    		super(t);
    		logger.error("There is an error in countown all endpoint");
    	}
    }
    
    @Timed(value = "countdown.all")
    @GetMapping(API_V1_PACKAGES)
    /**
     * Expose the information of launch.
     * @return
     */
    public Mono<Countdown> all() {
    	try {
	    	ILaunch launch = resource.getLaunch();
	    	String remainingTime = launch.countdown();
	    	Countdown countdown = new Countdown.Builder().remainingTime(remainingTime).build();
	    	return Mono.just(countdown);
    	}catch (Exception e) {
			throw new LaunchAllException(e);
		}
    }
    
    
}
