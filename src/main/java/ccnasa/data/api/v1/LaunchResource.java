package ccnasa.data.api.v1;

import ccnasa.ILaunch;

public enum LaunchResource {
	INSTANCE;
	
	// TODO: Improve for multiple launches
	//private Map<Integer, ILaunch> launches = new ConcurrentHashMap<Integer, ILaunch>();
	
	private ILaunch launch;
	
	public void addLaunch(ILaunch launch) {
	}
	
	public ILaunch getLaunch() {
		return launch;
	}
}
