package ccnasa;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Launch implements ILaunch{
	
	private static final Logger logger = LogManager.getLogger(Launch.class);

	/**
	 * Time in millis to make a launchment
	 */
	private final long launchTime;
	private final int id;
	
	public static class Builder{
		private long launchTime;
		private int id;
		
		/**
		 * 
		 * @param countdown Seconds to launchment.
		 */
		public Builder() {
		}
		
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
		
		public Launch build() {
			return new Launch(this);
		}
		
		public class LaunchTimeException extends IllegalArgumentException{
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 8017497258006950538L;

			public LaunchTimeException(Throwable t) {
				super(t);
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
	public String countdown(String format) {
		
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
