import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Demo {
    public static void main(String[] args) throws IOException {
        ArrayList manager_list = new ArrayList<Manager>();
        BufferedReader reader = new BufferedReader(new FileReader("./InputManager.txt"));
        try {
            String s;
            ArrayList data = new ArrayList<ArrayList>();
            while ((s = reader.readLine()) != null) {
                ArrayList<String> strList = new ArrayList<String>(Arrays.asList(s.split(", ")));
                data.add(strList);
            }
            for (int i = 0; i < data.size(); i++) {
                ArrayList manager_info = (ArrayList) data.get(i);
                Manager top_manager = null;
                for (int j = 0; j < manager_list.size(); j++) {
                    Manager data_manager = (Manager) manager_list.get(j);
                    if (data_manager.getId() == Integer.parseInt((String) manager_info.get(3))) {
                        top_manager = data_manager;
                        break;
                    }
                }
                Manager manager = new Manager((String) manager_info.get(0), (String) manager_info.get(1),
                        Double.parseDouble((String) manager_info.get(2)), top_manager,
                        Double.parseDouble((String) manager_info.get(4)));
                manager_list.add(manager);
                System.out.println(manager.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (reader != null)
                reader.close();
        }

        BufferedReader reader_employee = new BufferedReader(new FileReader("./InputEmployeers.txt"));
        try {
            String s;
            ArrayList data = new ArrayList<ArrayList>();
            while ((s = reader_employee.readLine()) != null) {
                ArrayList<String> strList = new ArrayList<String>(Arrays.asList(s.split(", ")));
                data.add(strList);
            }
            for (int i = 0; i < data.size(); i++) {
                ArrayList employee_info = (ArrayList) data.get(i);
                Manager top_manager = null;
                for (int j = 0; j < manager_list.size(); j++) {
                    Manager data_manager = (Manager) manager_list.get(j);
                    if (data_manager.getId() == Integer.parseInt((String) employee_info.get(3))) {
                        top_manager = data_manager;
                        break;
                    }
                }
                Employee employee = new Employee((String) employee_info.get(0), (String) employee_info.get(1),
                        Double.parseDouble((String) employee_info.get(2)), top_manager);
                System.out.println(employee.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (reader != null)
                reader.close();
        }
    }
}
