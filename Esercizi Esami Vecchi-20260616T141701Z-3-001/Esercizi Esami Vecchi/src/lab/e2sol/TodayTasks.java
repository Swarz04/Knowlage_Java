package lab.e2sol;

public interface TodayTasks {

	/*
	 *  start should be between 8 and 18, duration should be positive and not lead to escape 19:00 
	 *  a task from 10 lasting 2 means it starts at 10:00 and ends at 11:59
	 *  throws IllegalArgumentException if start or duration are invalid or description is null
	 *  returns false if input is ok but task can't be taken
	 */	
	boolean addTask(int startTime, int duration, String description);
	
	/*
	 *  returns null if at that time there is no task
	 */
	String getTaskDescription(int time);
}
