import javax.xml.transform.Templates;
import java.util.*;
import java.io.*;
public abstract class Database<T extends TheInterface> {
     String fileName;
    ArrayList<T> t = new ArrayList<T>();
    public void readFromFile()
    {
        try {
            BufferedReader buff = new BufferedReader(new FileReader(fileName));
            String line = buff.readLine();
            while (line != null&&t!=null) {
                T record = createRecordFrom(line);
                t.add(record);
                line = buff.readLine();
            }
            buff.close();
        }catch (IOException e){
            System.out.println("Error reading from file");
        }
    }
    public void deleteRecord(String key){
        T record = getRecord(key);
        if(record != null)
            t.remove(record);
    }
    public void insertRecord(T record){
        t.add(record);
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public ArrayList<T> returnAllRecords(){
        return t;
    }

    public abstract T createRecordFrom(String line);
    public boolean contains(String key)
    {
        for(T record : t)
            if(record.getSearchKey().equals(key))
                return true;
        return false;

    }


    public  T getRecord(String key)
    {
        for(T record : t)
            if(record.getSearchKey().equals(key))
                return record;
        return null;
    }
       public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (T record : t) {
                writer.write(record.lineRepresentation());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

