import java.io.*;
import java.util.*;
public class EmployeeUserDatabase {
    private String fileName;
    private ArrayList<EmployeeUser> records;
    public EmployeeUserDatabase(String fileName){
        this.fileName = fileName;
        records = new ArrayList<EmployeeUser>();
    }
    public void readFromFile() throws IOException {
        BufferedReader buff = new BufferedReader(new FileReader(fileName));
        String line = buff.readLine();
        while (line != null) {
            String[] fields = line.split(",");
            EmployeeUser record = new EmployeeUser(fields[0], fields[1], fields[2], fields[3], fields[4]);
            records.add(record);
            line = buff.readLine();
        }
        buff.close();
    }
    public EmployeeUser createRecordFrom(String line){
        String[] fields = line.split(",");
        return new EmployeeUser(fields[0], fields[1], fields[2], fields[3], fields[4]);
    }
    public ArrayList<EmployeeUser> returnAllRecords(){
        return records;
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
    public void insertRecord(EmployeeUser record){
        records.add(record);
    }
    public void deleteRecord(String key){
        EmployeeUser record = getRecord(key);
        if(record != null)
            records.remove(record);
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
