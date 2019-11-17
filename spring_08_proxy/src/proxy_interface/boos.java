package proxy_interface;

public class boos {

	public static void main(String[] args) {
		xxx_1service service1 = new xxx_1service();
		xxx_2service service2 = new xxx_2service();
		serviceproxy serviceproxy = null;

		serviceproxy = new serviceproxy(service1);
		serviceproxy.setProxy();
		xxxservice1 interface1 = (xxxservice1)serviceproxy.objproxy;
		interface1.doFirst("Y");
		interface1.doSecond("N");
		
		serviceproxy = new serviceproxy(service2);
		serviceproxy.setProxy();
		xxxservice2 interface2 = (xxxservice2)serviceproxy.objproxy;
		interface2.eatFirst("Y");
		interface2.eatSecond("N");
		interface2.eatAll("Y");
		
	}

}
