package proxy_interface;


public class xxx_1service implements xxxservice1{
	@Override
	public void doFirst(String key) {
		System.out.println("service1doFirst"+key);
	}
	
	@Override
	public void doSecond(String key) {
		System.out.println("service1doSecond"+key);
	}
}
