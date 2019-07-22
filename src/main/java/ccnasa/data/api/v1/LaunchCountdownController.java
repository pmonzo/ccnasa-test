package ccnasa.data.api.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ccnasa.ILaunch;
import reactor.core.publisher.Flux;

@RestController
public class LaunchCountdownController {

	public static final String API_V1_PACKAGES = "/api/v1/countdown";
	
	private final LaunchResource resource = LaunchResource.INSTANCE;
	
    public LaunchCountdownController() {
    }
    @GetMapping(API_V1_PACKAGES)
    public Flux<Countdown> all() {
    	ILaunch launch = resource.getLaunch();
    	String remainingTime = launch.countdown("s.S");
    	Countdown countdown = new Countdown.Builder().remainingTime(remainingTime).build();
    	return Flux.just(countdown);
    }
    
    /**@GetMapping(API_V1_PACKAGES + "/{id}")
	public Mono<Countdown> findById(@PathVariable String id, @RequestParam Map<String, String> queryMap, @RequestHeader(value="Accept-Language") String lang) {
    	PackageResourceParameters params = PackageResourceParamatersFactory.build(id, queryMap);
        return client.getResult(params,lang);
	}
    **/
    
}
