import javax.xml.transform.Templates;
import java.util.*;
import java.io.*;
public abstract class Database<T> {
    //refactor the methods in CustomerProductDatabase and ProductDatabase to be in this class
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

    public abstract boolean contains(String key);

    public abstract T getRecord(String key);
}

