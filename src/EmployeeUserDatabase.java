import javax.xml.transform.Templates;
import java.io.*;
import java.util.*;
public class EmployeeUserDatabase extends Database<EmployeeUser>{

    public EmployeeUserDatabase(String fileName){
        this.fileName = fileName;
        t = new ArrayList<EmployeeUser>();
    }

    public EmployeeUser createRecordFrom(String line){
        String[] fields = line.split(",");
        return new EmployeeUser(fields[0], fields[1], fields[2], fields[3], fields[4]);
    }



}
