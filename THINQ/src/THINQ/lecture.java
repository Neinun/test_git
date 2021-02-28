package THINQ;

public class lecture {
	String ID;
	String teacherName;
	String specialization;
	String duration;
	String cost;
	lecture()
	{
		
	}
	lecture(String id,String teachername, String specialization, String duration, String cost)
	{
		this.ID = id;
		this.teacherName = teachername;
		this.specialization = specialization;
		this.cost = cost;
		this.duration = duration; 
	}

}
