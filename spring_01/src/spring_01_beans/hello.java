package spring_01_beans;

public class hello {

	private String name;
	public void setName(String name) {
		this.name=name;
	}
     
	public void show() {
		System.out.println("hello"+name);
	}
}
