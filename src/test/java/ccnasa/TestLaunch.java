package ccnasa;

import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class TestLaunch {
	
	private static final Logger logger = LogManager.getLogger(TestLaunch.class);

	@Test
	public void testCountdown(){
		Launch launch = new Launch.Builder().launchTime(5).id(1).build();
		try {
			Thread.sleep(1000);
			String countdown = launch.countdown("s.S");
			logger.debug("countdown: " + countdown);
			assertTrue(Float.valueOf(countdown) < Float.valueOf("4.00") 
					&& Float.valueOf(countdown) > Float.valueOf("3.80"));
			Thread.sleep(5000);
			String countdownZero = launch.countdown("s.S");
			logger.debug("countdownZero: " + countdownZero);
			assertTrue(Float.valueOf(countdownZero).equals(Float.valueOf("0.00")));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
