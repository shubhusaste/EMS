package employee;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Set_Salary extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JButton b1,b2;
    Choice c2;

    Set_Salary(){

        setTitle("Set Salary");

        setLayout(new GridLayout(8,2,20,20));
        c2 = new Choice();

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee where EMP_ID not in (select EMP_ID from salary)");

            while(rs.next()){
                c2.add(rs.getString("EMP_ID"));
            }
        }catch(Exception e){ }

        add(new JLabel("      Select Emp ID"));
        add(c2);

        l1 = new JLabel("     HRA");
        t1 = new JTextField(15);
        add(l1);
        add(t1);

        l3 = new JLabel("     DA");
        t3 = new JTextField(15);
        add(l3);
        add(t3);

        l4 = new JLabel("     MED");
        t4 = new JTextField(15);
        add(l4);
        add(t4);

        l5 = new JLabel("     PF");
        t5 = new JTextField(15);
        add(l5);
        add(t5);

        l6 = new JLabel("     Basic Salary");
        t6 = new JTextField(15);
        add(l6);
        add(t6);

        b1 =new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2 = new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        add(b1);
        add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);


        setSize(550,550);
        setLocation(400,100);
        setVisible(true);


        getContentPane().setBackground(Color.WHITE);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            String hra = t1.getText();
            String id = c2.getSelectedItem();
            String da = t3.getText();
            String med = t4.getText();
            String pf = t5.getText();
            String basic = t6.getText();
            String qry = "insert into salary values(" + id + "," + hra + "," + da + "," + med + "," + pf + "," + basic + ")";

            try {
                Conn c1 = new Conn();
                c1.s.executeUpdate(qry);
                JOptionPane.showMessageDialog(null, "Salary updated");
                t1.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
//                this.setVisible(false);
//               new details1();

            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }
        if (ae.getSource() == b2) {
           this.setVisible(false);
            new details1();
        }
    }

    public static void main(String[] args){
        new Set_Salary();
    }
}