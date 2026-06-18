package lab.e2sol;

public class TodayTasksImpl implements TodayTasks{
	
	private static final int SLOTS = 11;
	private static final int FIRST_SLOT = 8;
	private String[] tasks = new String[SLOTS];
	
	private void checkTime(int time){
		if (time < FIRST_SLOT || time >= FIRST_SLOT + SLOTS){
			throw new IllegalArgumentException();
		}
	}
	
	@Override
	public boolean addTask(int startTime, int duration, String description)
			throws IllegalArgumentException {
		checkTime(startTime);
		checkTime(startTime+duration-1);
		if (description == null || duration < 0){
			throw new IllegalArgumentException();
		}
		for (int i=0; i<duration; i++){
			if (getTaskDescription(startTime +i)!=null){
				return false;
			}
		}
		for (int i=0; i<duration; i++){
			setTaskDescription(startTime +i, description);
		}
		return true;
	}
	
	@Override
	public String getTaskDescription(int time) {
		checkTime(time);
		return this.tasks[time-FIRST_SLOT];
	}
	
	private void setTaskDescription(int time, String str){
		checkTime(time);
		this.tasks[time-FIRST_SLOT] = str;
	}	
	
}
