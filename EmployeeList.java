import java.util.ArrayList;

public class EmployeeList
{
   private ArrayList<Employee> empList;
   EmployeeList()
   {
        empList=new ArrayList<>();
   }
   int search(int empcode)
   {
        for(int i=0;i<empList.size();i++)
        {
            if(empList.get(i).getCode()==empcode)
            {
                return i;
            }
        }
        return -1;
   }
   boolean canAddEmployee(int empcode)
   {
        int k=search(empcode);
        if(k!=-1)
        {
            return false;
        }
        else{
            return true;
        }
   }
   String  addEmployee(Employee e)
   {
        empList.add(e);
        return "Employee added successfully";
   }
   Employee displayEmp(int empcode)
   {
        int k=search(empcode);
        if(k==-1)
        {
            return null;
        }
        else{
            return empList.get(k);
        }
   }
}
class Employee
{
    private int code;
    private String name;
    private int depcode;
    private double basic;
    private char grade;
    public Employee(int c,String n,int dcode,double b,char g)
    {
        code=c;
        name=n;
        depcode=dcode;
        basic=b;
        grade=g;
    }
    public int getCode()
    {
        return code;
    }
    public int getDepCode()
    {
        return depcode;
    }
    public double getBasic()
    {
        return basic;
    }
    public char getGrade()
    {
        return grade;
    }
    public String getName()
    {
        return name;
    }
    public String toString()
    {
        return "Name:"+name+'\n'
        +"Employee Code:"+code+'\n'
        +"Department Code:"+code+'\n'
        +"Basic salary:"+basic+'\n'
        +"Grade:"+grade+'\n';
    }
}