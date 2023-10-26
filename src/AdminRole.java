import java.io.*;
import java.util.*;
public class AdminRole {
    private EmployeeUserDatabase database;
    public void eddEmployee(String employeeId, String name, String email, String address, String phoneNumber) {
        try {
            File file = new File(database.getFileName());
            FileWriter fw = new FileWriter(file, true);
            fw.write("\n" + employeeId + "," + name + "," + email + "," + address + "," + phoneNumber);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
        public EmployeeUser[] getListOfEmployees() {
            try{
                BufferedReader buff = new BufferedReader(new FileReader(database.getFileName()));
                String line = buff.readLine();
                if(line == null)
                    return null;
                ArrayList<EmployeeUser> records = new ArrayList<EmployeeUser>();
                while (line!= null)
                {
                    String[] emp = line.split(",");
                    records.add(new EmployeeUser(emp[0], emp[1], emp[2], emp[3], emp[4]));
                    line = buff.readLine();
                }
                buff.close();
                EmployeeUser[] employees = new EmployeeUser[records.size()];
                for(int i = 0; i < records.size(); i++)
                    employees[i] = records.get(i);
                return employees;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
    public void removeEmployee(String key)
    {
        try {
            BufferedReader buff = new BufferedReader(new FileReader(database.getFileName()));
            String line = buff.readLine();
            ArrayList<String> records = new ArrayList<String>();
            while (line != null) {
                String[] emp = line.split(",");
                if (!emp[0].equals(key))
                    records.add(line);
                line = buff.readLine();
            }
            buff.close();
            File file = new File(database.getFileName());
            FileWriter fw = new FileWriter(file);
            boolean flag = false;
            for (String record : records) {
                if(flag)
                    fw.write("\n"+record);
                else
                {
                    fw.write(record);
                    flag = true;
                }
            }
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void logout() throws IOException {
        database.readFromFile();
    }
}
