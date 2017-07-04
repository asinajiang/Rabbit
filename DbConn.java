import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class DbConn {
   private static DataSource ds = null;
   private static Connection conn = null;
   
   public static Connection getConn(){   //获取数据库连接
      try{
         String url = "jdbc:mysql://localhost:3306/test?useSSL=true";
         String username = "root";
         String password = "1234";
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         conn = DriverManager.getConnection(url, username, password);
         return conn;
      }catch (Exception e) {
         System.out.println("数据库连接异常：" + e.getMessage());
         return null;
      }
   }
   
   public void CloseConn(){   //关闭数据库
      try {
         conn.close();
      } catch (Exception e) {
         System.out.println("数据库连接关闭异常：" + e.getMessage());
      }
   }
   
   public static void main(String[] args){
      Connection connection;
      DbConn dbConn = new DbConn();
      connection = dbConn.getConn();
      try {
         Statement statement = connection.createStatement();
         String sql = "select * from person";
         ResultSet rs = statement.executeQuery(sql);
         while(rs.next()){
            System.out.println("name:" + rs.getString("name"));
            System.out.println("idCard:" + rs.getString("idCard"));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }finally {
         dbConn.CloseConn();
      }
   }
}
