package proxy_interface;


public class xxx_2service implements xxxservice2{
	@Override
	public void eatFirst(String key) {
		System.out.println("service2eatFirst"+key);
	}
	@Override
	public void eatSecond(String key) {
		System.out.println("service2eatSecond"+key);
	}
	@Override
	public void eatAll(String key) {
		System.out.println("service2eatAll"+key);
	}
}
