package employee;

import java.sql.*;
import javax.swing.*;
import java.util.Date;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;

import static groovy.console.ui.text.FindReplaceUtility.dispose;

public class TakeAttendence implements ActionListener {
    JFrame f;
    JLabel l1, l2, l3, l4, l5, l6, l7,date;
    JTextField t1, t2, t3, t4, t5, t6, t7;
    JButton b1, b2;
    Choice c2, fh, sh;

    TakeAttendence() {
        f = new JFrame();
        f.setTitle("Add Attendance");
        f.setLayout(new GridLayout(5, 2, 50, 50));
        c2 = new Choice();
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            while (rs.next()) {
                c2.add(rs.getString("emp_id"));
            }


        } catch (Exception e) {
        }
        l3= new JLabel("    Date & Time");
        t1= new JTextField("Date Time");
        Date date=new Date();
        SimpleDateFormat d=new SimpleDateFormat("dd/MM/YYYY");
        t1.setText(d.format(date));
        f.add(l3);
        f.add(t1);


        f.add(new JLabel("      Select Employee Id"));
        f.add(c2);


        l1 = new JLabel("      First Half");
        fh = new Choice();
        fh.add("Present");
        fh.add("Absent");
        fh.add("Leave");


        f.add(l1);
        f.add(fh);

        l2 = new JLabel("      Second Half");
        sh = new Choice();
        sh.add("Present");
        sh.add("Absent");
        sh.add("Leave");

        f.add(l2);
        f.add(sh);

        b1 = new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2 = new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        f.add(b1);
        f.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        f.getContentPane().setBackground(Color.WHITE);

        f.setVisible(true);
        f.setSize(500, 600);
        f.setLocation(400, 100);

    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1){
            try {
        String f = fh.getSelectedItem();
        String s = sh.getSelectedItem();
        String dt = t1.getText();
        String id = c2.getSelectedItem();
        String qry = "insert into attendence values(" + id + ",'" + dt + "','" + f + "','" + s + "')";


            Conn c1 = new Conn();
            c1.s.executeUpdate(qry);
            JOptionPane.showMessageDialog(null, "Attendence confirmed");
            dispose();

        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }
        if(ae.getSource()==b2){
            f.setVisible(false);
            details1 d=new details1();
        }

}
    public static void main(String s[]){
        new TakeAttendence();
    }
}