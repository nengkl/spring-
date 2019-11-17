package spring_03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class jdbcdemo {
	/* 
	 * 	程序的耦合
	 * 		耦合：程序见依赖关系
	 * 			包括：类之间的依赖
	 * 				方法之间的依赖
	 * 		解耦：
	 * 			降低程序之间的依赖关系
	 * 		实际开发中：应在编译期间不依赖，运行时才依赖
	 *  	解决：
	 *  		第一步：使用反射创建对象
	 *  		第二步：通过读取配置文件来获取要创建的对象全限定类名
	 *  		
	*/
	public static void main(String[] args) throws Exception{
		//注册jdbc驱动
//		DriverManager.registerDriver(new com.mysql.jdbc.Driver());	
		//他依赖于mysql-conneor-java jar包，没有jar包无法通过编译
		Class.forName("com.mysql.jdbc.Driver");
		//它使用"com.mysql.jdbc.Driver" 字符串不依赖该jar包，没有jar包时虽不能运行但也可以通过编译
		
		//获取连接
	    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123123");
		//操作数据库预处理对象
	    PreparedStatement preparedStatement = connection.prepareStatement("select * from students"); 
		//执行sql得到结果集
	    ResultSet rs = preparedStatement.executeQuery();
		//遍历/封装结果集
	    while (rs.next()) {
			System.out.println(rs.getString("name"));
		}
		//释放资源

	    rs.close();
	    preparedStatement.close();
	    connection.close();
	  

	}

}
