package ccnasa.data.api.v1;

/**
 * Bean for the response of Countdown Resource
 * @author pedro.monzo
 *
 */
public class Countdown {

	private final String remainingTime;
	
	private Countdown(Builder builder) {
		remainingTime = builder.remainingTime;
	}

	public static class Builder {
		private String remainingTime ;
		
		public Builder() {			
		}
		
		public Builder remainingTime(String remainingTime) {
			this.remainingTime =  remainingTime;
			return this;
		}
		
		public Countdown build() {
			return new Countdown(this);
		}
	}

	public String getRemainingTime() {
		return remainingTime;
	}

	@Override
	public String toString() {
		return "Countdown [remainingTime=" + remainingTime + "]";
	}
	
}
