import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class a4_4 {
    private static EmployeeList empList;
    public static void main(String[] args) {
        empList=new EmployeeList();
        MyFrame mf=new MyFrame(empList);
        mf.getClass();
    }
    
}

class MyFrame extends JFrame
{
    private JPanel p;
    private Map<Integer,String> mp;
    private JButton saveButton,searchButton;
    private JLabel l1,l2,l3,l4,l5,dataCode,dataName,dataDept,dataBasic,dataGrade,dataDeptName;
    private JTextField empField,nameField,basicField;
    private JRadioButton r1,r2,r3,r4,r5,r6,ra,rb,rc;
    public MyFrame(EmployeeList eList)
    {
        super("Employee's Application");
        setSize(900,900);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p=new JPanel();
        l1=new JLabel("To add employee enter your employee code here");
        empField=new JTextField(20);
        l2=new JLabel("Enter your name here");
        nameField=new JTextField(20);
        l3=new JLabel("Choose your department code");
        r1=new JRadioButton("Name:CSE Code:1020");
        r2=new JRadioButton("Name:ETCE Code:1030");
        r3=new JRadioButton("Name:EE Code:1040");
        r4=new JRadioButton("Name:CIVIL Code:1050");
        r5=new JRadioButton("Name:MECH Code:1060");
        r6=new JRadioButton("Name:IT Code:1070");
        l4=new JLabel("Enter your basic salary here");
        mp=new HashMap<>();
        mp.put(1020,"CSE");
        mp.put(1030, "ETCE");
        mp.put(1040, "EE");
        mp.put(1050, "CIVIL");
        mp.put(1060, "MECH");
        mp.put(1070, "IT");
        basicField=new JTextField(20);
        l5=new JLabel("Choose your grade");
        ra=new JRadioButton("A");
        rb=new JRadioButton("B");
        rc=new JRadioButton("C");
        dataCode=new JLabel();
        dataName = new JLabel();
        dataDept = new JLabel();
        dataBasic = new JLabel();
        dataGrade = new JLabel();
        dataDeptName=new JLabel();
        ButtonGroup bg=new ButtonGroup();
        ButtonGroup bg2=new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
        bg.add(r4);
        bg.add(r5);
        bg.add(r6);
        bg2.add(ra);
        bg2.add(rb);
        bg2.add(rc);
        saveButton=new JButton("SAVE");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                int option=JOptionPane.showConfirmDialog(null,"Are you sure to save your credentials?","Confirmation", JOptionPane.YES_NO_OPTION);
                if(option==0)
                {   try
                    {
                    int code=Integer.parseInt(empField.getText());
                    int k=eList.search(code);
                    if(k!=-1)
                    {
                        JOptionPane.showMessageDialog(null, "The following Employee code already exists!");
                    }
                    else
                    {   
                        int depcode=-1;
                        if(r1.isSelected())
                        {
                            depcode=1020;
                        }
                        else if(r2.isSelected())
                        {
                            depcode=1030;
                        }
                        else if (r3.isSelected()) {
                            depcode = 1040;
                        }
                        else if (r4.isSelected()) {
                            depcode = 1050;
                        }
                        else if (r5.isSelected()) {
                            depcode = 1060;
                        }
                        else if (r6.isSelected()) {
                            depcode = 1070;
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Please choose department code!");
                        }
                        String name=nameField.getText();
                        double basic=Double.parseDouble(basicField.getText());
                        char g='D';
                        if(ra.isSelected())
                        {
                            g='A';
                        }
                        else if(rb.isSelected())
                        {
                            g='B';
                        }
                        else if(rc.isSelected())
                        {
                            g='C';
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"Please choose your grade!");
                        }
                        Employee emp=new Employee(code, name, depcode, basic, g);
                        String validMsg=eList.addEmployee(emp);
                        JOptionPane.showMessageDialog(null, validMsg);
                    }
                    }
                    catch(Exception ex)
                    {JOptionPane.showMessageDialog(null, "Ensure all fields are filled correctly!");}
                }
            }
        });
        searchButton=new JButton("SEARCH");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                int empcode=Integer.parseInt(JOptionPane.showInputDialog("Enter your employee code here"));
                int k=eList.search(empcode);
                if(k==-1)
                {
                    JOptionPane.showMessageDialog(null, "Employee not found");
                }
                else
                {
                    Employee eObj=eList.displayEmp(empcode);
                    dataName.setText("Name:"+eObj.getName());
                    dataCode.setText("Employee Code:"+Integer.toString(eObj.getCode()));
                    dataDept.setText("Department Code:"+Integer.toString(eObj.getDepCode()));
                    dataDeptName.setText("Department Name:"+mp.get(eObj.getDepCode()));
                    dataBasic.setText("Basic Salary:"+Double.toString(eObj.getBasic()));
                    dataGrade.setText("Grade:"+eObj.getGrade());
                }
            }
        });
        p.add(l1);
        p.add(empField);
        p.add(l2);
        p.add(nameField);
        p.add(l3);
        p.add(r1); 
        p.add(r2);
        p.add(r3);
        p.add(r4);
        p.add(r5);
        p.add(r6);
        p.add(l4);
        p.add(basicField);
        p.add(l5);
        p.add(ra);
        p.add(rb);
        p.add(rc);
        saveButton.setSize(100,100);
        searchButton.setSize(100, 100);
        p.add(saveButton);
        p.add(searchButton);
        p.add(dataName);
        p.add(dataCode);
        p.add(dataDept);
        p.add(dataDeptName);
        p.add(dataBasic);
        p.add(dataGrade);
        p.setLayout(new GridLayout(0,1));
        add(p,BorderLayout.CENTER);
    }
}
 
 
 
 
 
 
 
 
 

 
 
 
 
 
 
 

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 

