import java.util.*;
import java.io.*;
public class Test1 {
    public static void main(String[] args)
    {
        EmployeeUserDatabase db = new EmployeeUserDatabase("Employees.txt");
        try {
            db.readFromFile();
        }catch (IOException e){
            System.out.println("Error reading from file");
        }
        ArrayList<EmployeeUser> records = db.returnAllRecords();
        for (EmployeeUser record : records)
            System.out.println(record.lineRepresentation());
        if(db.contains("E1200"))
            System.out.println("Record with key E1200 exists");
        else
            System.out.println("Record with key E1200 does not exist");
        EmployeeUser record = db.getRecord("A8368");
        if(record != null)
            System.out.println(record.lineRepresentation());
        else
            System.out.println("Record with key A8368 does not exist");
        db.insertRecord(new EmployeeUser("E3333", "John", "aa.ee", "123", "123"));
        db.saveToFile();
        ArrayList<EmployeeUser> records2 = db.returnAllRecords();
        for (EmployeeUser record2 : records2)
            System.out.println(record2.lineRepresentation());
    }
}
