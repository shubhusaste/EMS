package employee;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class details1 extends JPanel implements ActionListener{

    JFrame f;
    JPanel panel;
    JMenuBar mb;
    JLabel l;
    JButton b;
    JMenu emp_det,emp_salary,emp_attendance;
    JMenuItem add_emp,view_emp_det,rem_emp,update_emp,add_attendance,show_attendance,set_salary,update_salary, emp_payslip;

    details1(){
        f= new JFrame("Dashboard");
        f.setSize(1500,850);
        f.setVisible(true);
        f.setLayout(null);
        f.setDefaultCloseOperation(3);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);

        panel = new JPanel();
        l= new JLabel("shubhamamamama");
        l.setBounds(0,0,1500,800);
        l.setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("details.jpg"));
        l.setIcon(i1);
       panel.setBorder(new EmptyBorder(0, 5,5, 5));
        f.setContentPane(panel);            
       panel.setLayout(null);
        mb= new JMenuBar();
        f.setJMenuBar(mb);

        panel.add(l);


        b= new JButton("Logout");
        b.addActionListener(this);
        b.setBounds(1000,0,40,30);
       // b.setBackground(Color.white);


        emp_det=new JMenu("Employee Details");
        emp_attendance= new JMenu("Employee Attendance");
        emp_salary= new JMenu("Employee Salary");

        mb.add(emp_det);
        mb.add(emp_attendance);
        mb.add(emp_salary);
        mb.add(b);

        add_emp= new JMenuItem("Add Employee");
        view_emp_det= new JMenuItem("View Employee Details");
        rem_emp= new JMenuItem("Remove Employee");
        update_emp= new JMenuItem("Update Employee");

        emp_det.add(add_emp);
        emp_det.add(view_emp_det);
        emp_det.add(rem_emp);
        emp_det.add(update_emp);

        add_emp.addActionListener(this);
        view_emp_det.addActionListener(this);
        rem_emp.addActionListener(this);
        update_emp.addActionListener(this);

        add_attendance=new JMenuItem("Add Attendance");
        show_attendance=new JMenuItem("Show Attendance");
        emp_attendance.add(add_attendance);
        emp_attendance.add(show_attendance);

        add_attendance.addActionListener(this);
        show_attendance.addActionListener(this);

        set_salary= new JMenuItem("Set Employee Salary");
        update_salary=new JMenuItem("Update Employee Salary");
        emp_payslip=new JMenuItem("Employee Pay Slip");

        emp_salary.add(set_salary);
        emp_salary.add(update_salary);
        emp_salary.add(emp_payslip);

        set_salary.addActionListener(this);
        update_salary.addActionListener(this);
        emp_payslip.addActionListener(this);


    }
    public void actionPerformed(ActionEvent e){

        if(e.getSource()==add_emp){
            f.setVisible(false);
            new Add_Employee();
        }
        if(e.getSource()==view_emp_det){
            f.setVisible(false);
            new View_Employee();
        }

        if(e.getSource()==rem_emp){
            f.setVisible(false);
            new Remove_Employee();
        }
        if(e.getSource()==update_emp){
            f.setVisible(false);
            new Search_Employee();
        }
        if(e.getSource()==add_attendance){
            f.setVisible(false);
            new TakeAttendence();

        }
        if(e.getSource()==show_attendance){
            f.setVisible(false);
            new List_Attendence();

        }
        if(e.getSource()==set_salary){
            f.setVisible(false);
            new Set_Salary();

        }
        if(e.getSource()==update_salary){
            f.setVisible(false);
            new Update_salary();

        }
        if(e.getSource()==emp_payslip){
            f.setVisible(false);
            new Pay_Slip();

        }
        if(e.getSource()==b){
            f.setVisible(false);
            new login();

        }

    }


    public static void main(String[] args) {
        details1 m= new details1();
    }
}
