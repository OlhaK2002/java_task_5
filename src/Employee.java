public class Employee {
    private int id;
    private static int nextId=1;
    private String name, surname;
    private double salary = 1000;
    private Manager manager;

    Employee(String name_value, String surname_value, double salary_value, Manager manager_value) {
        setId();
        setName(name_value);
        setSurname(surname_value);
        setSalary(salary_value);
        setManager(manager_value);
    }

    public int getId() {
        return id;
    }

    final public void setId() {
        this.id = nextId++;
    }

    public String getName() {
        return name;
    }

    final public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    final public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public String getManagerName() {
        if (getManager() != null) {
            return getManager().getName() + " " + getManager().getSurname();
        } else {
            return "No manager";
        }
    }
    public Employee getTopManager() {
        if (manager != null) return manager.getTopManager();
        else {
            return this;
        }
    }

    public void raiseSalary (double p) {
        salary = salary + salary * p;
    }

    public String toString () {
        return getId() + ". " + getName() + " " + getSurname() + " - " + getSalary() + "; manager - " + getManagerName() + "; top manager - " + getTopManager().getName() + " " + getTopManager().getSurname();
    }

}

