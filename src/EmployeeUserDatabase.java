import javax.xml.transform.Templates;
import java.io.*;
import java.util.*;
public class EmployeeUserDatabase extends Database<EmployeeUser>{

    ArrayList<EmployeeUser> records;
    public EmployeeUserDatabase(String fileName){
        this.fileName = fileName;
        records = new ArrayList<EmployeeUser>();
    }

    public EmployeeUser createRecordFrom(String line){
        String[] fields = line.split(",");
        return new EmployeeUser(fields[0], fields[1], fields[2], fields[3], fields[4]);
    }
    public boolean contains(String key){
        for (EmployeeUser record : records)
            if (record.getEmployeeId().equals(key))
                return true;
        return false;
    }
    public EmployeeUser getRecord(String key){
        for (EmployeeUser record : records)
            if (record.getEmployeeId().equals(key))
                return record;
        return null;
    }

    public void saveToFile() {
        try {
            File file = new File(fileName);
            FileWriter writer = new FileWriter(file);
            boolean flag = false;
            for (EmployeeUser record : records) {
                if(flag)
                  writer.write("\n"+record.lineRepresentation());
                else
                {
                    writer.write(record.lineRepresentation());
                    flag = true;
                }
            }
            writer.close();
        }catch (IOException e){
            System.out.println("Error writing to file");
        }
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}
