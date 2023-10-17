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
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class Due extends JFrame
{
    String a[] = {"Name", "Email","Course","Fee","Paid","Due","Address","City","State","Country","Contact",};
    String b[] [] = new String [20][12];
    int i = 0, j = 0;
    JTable t;
    Font f;

    Due()
    {
        super("Student Information");
        setLocation(1,1);
        setSize(1300,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f = new Font("Arial",Font.BOLD,15);

        try
        {
            ClassConnection obj = new ClassConnection();
            String q = "select *from addstudent where Due>0";
            ResultSet r = obj.stm.executeQuery(q);
            
            while(r.next())
            {
                /*b[i][j++]=r.getString("Roll_no");*/
                b[i][j++]=r.getString("name");
                b[i][j++]=r.getString("email");
                b[i][j++]=r.getString("Course");
                b[i][j++]=r.getString("Fee");
                b[i][j++]=r.getString("Paid");
                b[i][j++]=r.getString("Due");
                b[i][j++]=r.getString("Address");
                b[i][j++]=r.getString("City");
                b[i][j++]=r.getString("state");
                b[i][j++]=r.getString("country");
                b[i][j++]=r.getString("contact");
                i++;
                j=0;
            }

            t = new JTable(b,a);
            t.setFont(f);

            JScrollPane sp = new JScrollPane(t);
        add(sp);

        }
        catch(Exception ee)
        {
            ee.printStackTrace();
        }

    }
    public static void main(String [] args)
    {
        new Due().setVisible(true);
    }
}
