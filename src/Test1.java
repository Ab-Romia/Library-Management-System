import java.util.*;
import java.io.*;
import java.time.LocalDate;
public class Test1 {
    public static void main(String[] args)
    {
        AdminRole ad = new AdminRole();
        EmployeeUser[] employee = ad.getListOfEmployees();

        ad.addEmployee("EMP-001", "Ahmed", "ahmed@email.com", "123 Street, Cairo", "+20123456789");
        employee = ad.getListOfEmployees();
        for(EmployeeUser emp : employee)
            System.out.println(emp.lineRepresentation());

    }
}
