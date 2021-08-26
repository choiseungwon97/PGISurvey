package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CommonDao {

   private static CommonDao instance;
   
   public static CommonDao getInstance() {
      if (instance == null) {
         instance = new CommonDao();
      }
      return instance;
   }
   
   public CommonDao(){
       init();
   }
   
   private Connection conn = null;
   String url= "jdbc:oracle:thin:@203.247.52.213:80:xe";
   String user= "PGI2021";
   String pass="1234";
   
   
   private void init(){
      
         url = "jdbc:oracle:thin:@203.247.52.213:80:xe";
         user = "PGI2021";
         pass = "1234";
         
         try {
            Class.forName("oracle.jdbc.OracleDriver");
         } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         
   }
   
   public Connection getConnection(){
      
      try {
         init();
         conn = DriverManager.getConnection(url, user, pass);
         System.out.println("접속성공");
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      
      return conn;
   }


   public void dbClose() {
      try {
         conn.close();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
   }
   
}