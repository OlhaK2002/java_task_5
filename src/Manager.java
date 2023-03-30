class  Manager extends Employee {
    private double bonus;

    Manager(String name_value, String surname_value, double salary_value, Manager manager_value, double b) {
        super(name_value, surname_value, salary_value, manager_value);
        bonus = b;
    }

    public void setBonus(double b) {
        this.bonus = b;
    }

    public double getSalary() {
        return super.getSalary() + bonus;
    }

    public String toString () {
        return getId() + ". " + getName() + " " + getSurname() + " - " + getSalary() + "; manager - " + getManagerName() + "; top manager - " + getTopManager().getName() + " " + getTopManager().getSurname();
    }
}
