import java.io.*;
import java.util.*;
public class AdminRole {
    private EmployeeUserDatabase database =new EmployeeUserDatabase("Employees.txt");



    public void addEmployee(String employeeId, String name, String email, String address, String phoneNumber) {
        try {
            File file = new File(database.getFileName());
            FileWriter fw = new FileWriter(file, true);
            if(file.length()==0)
                fw.write(employeeId + "," + name + "," + email + "," + address + "," + phoneNumber);
            else
                fw.write("\n" + employeeId + "," + name + "," + email + "," + address + "," + phoneNumber);
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
        public EmployeeUser[] getListOfEmployees() {
            try{
                BufferedReader buff = new BufferedReader(new FileReader("Employees.txt"));
                String line;
                ArrayList<EmployeeUser> records = new ArrayList<EmployeeUser>();
                while ((line = buff.readLine())!= null)
                {
                    String[] emp = line.split(",");
                    records.add(new EmployeeUser(emp[0], emp[1], emp[2], emp[3], emp[4]));

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
            BufferedReader buff = new BufferedReader(new FileReader("Employees.txt"));
            String line = buff.readLine();
            ArrayList<String> records = new ArrayList<String>();
            while (line != null) {
                String[] emp = line.split(",");
                if (!emp[0].equals(key))
                    records.add(line);
                line = buff.readLine();
            }
            buff.close();
            File file = new File("Employees.txt");
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

    public void logout()  {
        if(!database.t.isEmpty())
        {
            EmployeeUser[] employees = getListOfEmployees();
            for(EmployeeUser record: employees)
            {
                if(!database.contains(record.getEmployeeId()))
                    database.insertRecord(record);

            }
            database.saveToFile();
        }

    }
}
