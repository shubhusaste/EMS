package employee;
import java.awt.print.PrinterException;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pay_Slip extends JFrame implements ActionListener{

    Choice c1;
    JTextArea t1;
    JButton b1,b2, b3;
    JPanel p;

    Pay_Slip(){
      setVisible(true);
        setSize(800,700);
        setLocation(400,150);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        c1 = new Choice();
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from salary");
            while(rs.next()){
                c1.add(rs.getString("EMP_ID"));
            }
        }catch(Exception e) { }

        setLayout(new BorderLayout());

        JPanel p1 = new JPanel();
        p1.add(new JLabel("Select Employee Id: "));
        p1.add(c1);
        add(p1,"North");
        //c1.addItemListener(this);
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout(3));


        t1 = new JTextArea(30,80);
        JScrollPane jsp = new JScrollPane(t1);

        Font f1 = new Font("arial",Font.BOLD,20);
        t1.setFont(f1);

        b1 = new JButton("Generate Pay Slip");
       // b1.setBounds(100,600,200,40);
        b2= new JButton("Cancel");
        b3= new JButton("Print");
        b3.addActionListener(this);

        add(p, BorderLayout.AFTER_LAST_LINE);
       // add(b1,"South");
        p.add(b1);
        p.add(b3);
        p.add(b2);

        //b2.setBounds(500,600,100,40);
        add(jsp,"Center");
        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {

            try {
                Conn c = new Conn();

                ResultSet rs = c.s.executeQuery("select * from employee where EMP_ID=" + c1.getSelectedItem());
                rs.next();
                String name = rs.getString("name");
                rs.close();

                rs = c.s.executeQuery("select * from salary where EMP_ID=" + c1.getSelectedItem());
                double gross = 0;
                double net = 0;

                java.util.Date d1 = new java.util.Date();
                int month = d1.getMonth();
                t1.setText("                          Org. Name:" +
                        " \n                          Organisation Address:"+
                        "\n                          Org. Contact No:"+
                        "\n                          Org. Email. Id:");

                t1.append("\n");
                t1.append("\n");

                t1.append("\n ----------------   PAY SLIP FOR THE MONTH OF " + month + " ,2022  ------------------------");
                t1.append("\n");

                if (rs.next()) {

                    t1.append("\n     Employee ID   :" + rs.getString("EMP_ID"));
                    t1.append("\n     Employee Name :" + name);

                    t1.append("\n----------------------------------------------------------------");
                    t1.append("\n");

                    double hra = rs.getDouble("hra");
                    t1.append("\n                          HRA           : " + hra);
                    double da = rs.getDouble("da");
                    t1.append("\n                          DA             : " + da);
                    double med = rs.getDouble("med");
                    t1.append("\n                          MED          : " + med);
                    double pf = rs.getDouble("pf");
                    t1.append("\n                          PF             : " + pf);
                    double basic = rs.getDouble("basic_salary");
                    gross = hra + da + med + pf + basic;
                    net = gross - pf;
                    t1.append("\n                  BASIC SALARY : " + basic);

                    t1.append("\n-------------------------------------------------------");
                    t1.append("\n");

                    t1.append("\n       GROSS SALARY :" + gross + "    \n         NET  SALARY   : " + net);
                    t1.append("\n                     Tax       :   2.1% of gross " + (gross * 2.1 / 100));
                    t1.append("\n -------------------------------------------------");
                    t1.append("\n");
                    t1.append("\n");
                    t1.append("\n");
                    t1.append("   (  Signature  )      ");

                }
            } catch (Exception ee) {
                ee.printStackTrace();
            }


        }
        if(e.getSource()==b2){
            this.setVisible(false);
            new details1();
        }
        if (e.getSource()==b3){
            try {
                t1.print();
                t1.setText("");
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        new Pay_Slip().setVisible(true);
    }
}
