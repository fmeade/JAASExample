import java.util.*;

public class Employee {
	
	private String name;
	private int id;
	private String position;
	private String supervisor; 
	private BigInteger salary;
	
	public Employee(_name, _id, _position, _supervisor, _salary) {
		this.name = _name;
		this.id = _id;
		this.position = _position;
		this.supervisor = _supervisor;
		this.salary = _salary;
	}
	
	public void setSalary(BigInteger _salary) {
		this.salary = _salary;
	}
}