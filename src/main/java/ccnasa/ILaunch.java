package ccnasa;

public interface ILaunch {

	/**
	 * The id os this launch, this can be used when there is more than one launch at the same time.
	 * @return
	 */
	public Integer getId();
	
	/**
	 * Returns time remaining to launch in seconds and miliseconds.
	 * @param format
	 * @return
	 */
	public String countdown();
}
