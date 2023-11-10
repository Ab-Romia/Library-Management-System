import java.io.*;
import java.util.*;
public class AdminRole {
    private EmployeeUserDatabase database =new EmployeeUserDatabase("Employees.txt");

    public AdminRole()
    {
        this.database = new EmployeeUserDatabase("Employees.txt");
        this.database.readFromFile();
    }

    public void addEmployee(String employeeId, String name, String email, String address, String phoneNumber) {
        EmployeeUser emp = new EmployeeUser(employeeId, name, email, address, phoneNumber);
        database.insertRecord(emp);

    }
        public EmployeeUser[] getListOfEmployees()  {

        return database.returnAllRecords().toArray(new EmployeeUser[0]);
    }
    public void removeEmployee(String key)
    {
        if(database.contains(key))
        {
            database.deleteRecord(key);
        }
    }

    public void logout()  {
        database.saveToFile();
    }
}
