package spring_03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class jdbcdemo {
	/* 
	 * 	��������
	 * 		��ϣ������������ϵ
	 * 			��������֮�������
	 * 				����֮�������
	 * 		���
	 * 			���ͳ���֮���������ϵ
	 * 		ʵ�ʿ����У�Ӧ�ڱ����ڼ䲻����������ʱ������
	 *  	�����
	 *  		��һ����ʹ�÷��䴴������
	 *  		�ڶ�����ͨ����ȡ�����ļ�����ȡҪ�����Ķ���ȫ�޶�����
	 *  		
	*/
	public static void main(String[] args) throws Exception{
		//ע��jdbc����
//		DriverManager.registerDriver(new com.mysql.jdbc.Driver());	
		//��������mysql-conneor-java jar����û��jar���޷�ͨ������
		Class.forName("com.mysql.jdbc.Driver");
		//��ʹ��"com.mysql.jdbc.Driver" �ַ�����������jar����û��jar��ʱ�䲻�����е�Ҳ����ͨ������
		
		//��ȡ����
	    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123123");
		//�������ݿ�Ԥ�������
	    PreparedStatement preparedStatement = connection.prepareStatement("select * from students"); 
		//ִ��sql�õ������
	    ResultSet rs = preparedStatement.executeQuery();
		//����/��װ�����
	    while (rs.next()) {
			System.out.println(rs.getString("name"));
		}
		//�ͷ���Դ

	    rs.close();
	    preparedStatement.close();
	    connection.close();
	  

	}

}
