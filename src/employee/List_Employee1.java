package employee;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class List_Employee1 extends JFrame implements ActionListener {

    JTable j1;
    JButton b1, b2;
    String h[] = {"Emp id", "Name", "FNAME", "Address", "D.O.B", "POST", "Email id", "Phone", "Adhar No", "Education", "Department"};
    String d[][] = new String[30][11];
    int i = 0, j = 0;

    List_Employee1() {
        setTitle("View Data");
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setSize(1000, 400);
        setLocation(250, 200);

        try {
            String q = "select * from employee";
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery(q);
            while (rs.next()) {
                // i = 0 j = 0
                d[i][j++] = rs.getString("EMP_ID");
                d[i][j++] = rs.getString("NAME");
                d[i][j++] = rs.getString("FNAME");
                d[i][j++] = rs.getString("Address");
                d[i][j++] = rs.getString("DOB");
                d[i][j++] = rs.getString("POST");
                d[i][j++] = rs.getString("EMAIL");
                d[i][j++] = rs.getString("Phone");
                d[i][j++] = rs.getString("ADHAR");
                d[i][j++] = rs.getString("EDUCATION");
                d[i][j++] = rs.getString("DEPARTMENT");
                i++;
                j = 0;
            }
            j1 = new JTable(d, h);

        } catch (Exception e) {
        }

        b1 = new JButton("Print");
        b1.setBounds(50,550,200,30);
        b2 = new JButton("Cancel");
        b2.setBounds(300,550,200,30);
        add(b1);
        add(b2);
        JScrollPane s1 = new JScrollPane(j1);
        add(s1);

        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1){
            try {
                j1.print();
            } catch (Exception e) {
            }
        }
        if(ae.getSource()==b2){
            View_Employee ve=  new View_Employee();
            dispose();
        }

    }
    public static void main(String s[]){
       List_Employee1 e1 = new List_Employee1();
    }
}