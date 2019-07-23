package ccnasa;

import java.util.Calendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Stores the information necessary for a launch.
 * @author pedro.monzo
 *
 */
public class Launch implements ILaunch{
	
	private static final Logger logger = LogManager.getLogger(Launch.class);

	/**
	 * Time in millis to make a launch
	 */
	private final long launchTime;
	private final int id;
	
	public static class Builder{
		private long launchTime;
		private int id;
		
		/**
		 * Default constructor please set the launchTime.
		 * @param countdown Seconds to launchment.
		 */
		public Builder() {
		}
		
		/**
		 * Calculates launchtime adding the countdown to the time it is now. 
		 * @param countdown
		 * @return
		 */
		public Builder launchTime(int countdown) {
			try {
				Calendar calendar = Calendar.getInstance();
				logger.debug("Initial time: " + calendar.getTime());
				calendar.add(Calendar.SECOND, countdown);
				this.launchTime = calendar.getTimeInMillis();
				logger.debug("Launchtime calculated: " + this.launchTime + ", date: " + calendar.getTime());
				return this;
			}catch (Exception e) {
				throw new LaunchTimeException(e);
			}
		}
		
		public Builder id(int id) {
			this.id = id;
			return this;
		}
		
		/**
		 * Builds a Launch with the information in this builder.
		 * @return
		 */
		public Launch build() {
			return new Launch(this);
		}
		
		/**
		 * This exception is throwed when there is a problem with the calculation of the launchTime
		 * @author pedro.monzo
		 *
		 */
		public class LaunchTimeException extends RuntimeException{
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 8017497258006950538L;

			public LaunchTimeException(Throwable t) {
				super(t);
				logger.error("There is an error in the launchtime calculations");
			}
		}
	}
	
	
	
	public Launch(Builder builder) {
		this.launchTime = builder.launchTime;
		this.id = builder.id;
	}

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	/**
	 * Determines how many seconds left to the launch.
	 */
	public String countdown() {
		
		long now = System.currentTimeMillis();
		long remainingTime = this.launchTime - now;
		String countdown;
		if(remainingTime < 0) {
			countdown = "0.0";
		} else {
			countdown = String.valueOf(remainingTime/1000f);
		}
		logger.debug("Returned countdown: " + countdown);
		return countdown;
	}

	

}
