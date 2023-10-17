/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fee_report_app.FeeReport;

/**
 *
 * @author HP
 */
import java.sql.*;

//To connect the project to Database.
public class ClassConnection
{
   //creating public variables.
   Connection con;
   Statement stm;
   
   ClassConnection()
   {

    try {
        con = DriverManager.getConnection ("jdbc:oracle:thin:@//localhost:1521/xe","ANUBHAV19","Anubhav2003");

        //To create statment
        stm = con.createStatement();

      /*  if(con.isClosed())
        {
            System.out.println("Not connect");
        }


        else
        {
            System.out.println("connect");
        }*/
    }
    
    catch (Exception e) {
        e.printStackTrace();
    }
   }
   
   public static void main(String []args)
   {
    new ClassConnection();
   }

}