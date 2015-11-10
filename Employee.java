import java.util.*;

public class Employee {
	
	private String name;
	private int id;
	private String position;
	private String supervisor; 
	private long salary;
	
	public Employee(String _name, int _id, String _position, String _supervisor, long _salary) {
		this.name = _name;
		this.id = _id;
		this.position = _position;
		this.supervisor = _supervisor;
		this.salary = _salary;
	}
	
	public String getName() { return this.name; }
	
	public int getId() { return this.id; }
	
	public String getPosition() { return this.position; }
	public void setPosition(String _position) { this.position = _position; }
	
	public String getSupervisor() { return this.supervisor; }
	
	public long getSalary() { return this.salary; }
	public void setSalary(long _salary) { this.salary = _salary; }
}