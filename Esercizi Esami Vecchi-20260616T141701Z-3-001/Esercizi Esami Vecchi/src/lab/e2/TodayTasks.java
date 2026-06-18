package lab.e2;

/**
 * It models the tasks to do in agiven day
 */

public interface TodayTasks {

	/**
	 *  startTime should be between 8 and 18, duration should be positive and avoid escaping 19:00 
	 *  A task from 10 lasting 2 means that it starts at 10:00 and ends at 11:59
	 *  throws IllegalArgumentException if start or duration are invalid or description is null
	 *  returns false if input is ok but task can't be taken since an intersecting one already exists
	 */	
	boolean addTask(int startTime, int duration, String description);
	
	/**
	 *  returns null if at that time there is no task
	 */
	String getTaskDescription(int time);
}
