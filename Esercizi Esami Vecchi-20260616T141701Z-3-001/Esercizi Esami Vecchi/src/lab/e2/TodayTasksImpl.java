package lab.e2;

import java.util.HashMap;
import java.util.Map;

public class TodayTasksImpl implements TodayTasks {
	
	private final Map<Integer,String> agenda = new HashMap<>();
	
	@Override
	public boolean addTask(final int startTime, final int duration,
			final String description) {
		if (startTime > 18 || startTime < 8 || duration < 0
				|| startTime + duration > 19 || description == null) {
			throw new IllegalArgumentException();
		}
		for(int i = startTime;i<startTime+duration;i++){
			if(agenda.containsKey(i)){
				return false;
			}
		}
		for(int i = startTime;i<startTime+duration;i++){
			agenda.put(i, description);
		}
		return true;
	}

	@Override
	public String getTaskDescription(final int time) {
		return agenda.get(time);
	}

}
