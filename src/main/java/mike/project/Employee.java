package mike.project;

public class Employee
{
	private String first;
	private String last;
	private int salary;

	public Employee(String first, String last, int salary)
	{
		 this.first  = first;
		 this.last   = last;
		 this.salary = salary;
	}

	public int getSalary()
	{
		return this.salary;
	}

	public void setSalary(int salary)
	{
		this.salary = salary;
	}

	public String getFirst()
	{
		return this.first;
	}

	public void setFirst(String first)
	{
		this.first = first;
	}

	public String getLast()
	{
		return this.last;
	}

	public void setLast(String last)
	{
		this.last = last;
	}

	public String getFullName()
	{
		return this.first + " " + this.last;
	}

	public int getEarningsAfterTenYears()
	{
		return this.salary * 10;
	}
}