package proxy_Method;

public class test {
	public static void main(String args[]) {
		serviceImpl serviceImpl = new serviceImpl();
		proxyService proxyService = new proxyService();
		proxyService.setObj(serviceImpl);
		serviceImpl = (serviceImpl)proxyService.objproxy;
		serviceImpl.doFirst("Y");
		serviceImpl.doFirst("N");
		serviceImpl.doSecond("Y");
		serviceImpl.doSecond("N");
	}
}
