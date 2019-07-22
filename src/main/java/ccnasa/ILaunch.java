package ccnasa;

public interface ILaunch {

	public Integer getId();
	
	/**
	 * Returns time remaining to launch in the spcified format
	 * @param format
	 * @return
	 */
	public String countdown(String format);
}
