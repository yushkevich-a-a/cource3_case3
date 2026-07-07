import java.time.LocalDate;

public class Worker {
    private String fullName;   
    private String position;   
    private double salary;     
    private int hireYear;      

    public Worker() {
        this.fullName = "";
        this.position = "";
        this.salary = 0.0;
        this.hireYear = LocalDate.now().getYear();
    }

    public Worker(String fullName, String position, double salary, int hireYear) {
        this.fullName = fullName;
        this.position = position;
        this.salary = salary;
        this.hireYear = hireYear <= LocalDate.now().getYear() ? hireYear : LocalDate.now().getYear();
    }


    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setHireYear(int hireYear) {
        this.hireYear = hireYear;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    public int getHireYear() {
        return hireYear;
    }

    public String displayInfo() {
        return String.format("ФИО: %s, Должность: %s, Зарплата: %.2f, Год поступления: %d",
                fullName, position, salary, hireYear);
    }

    public int getExperience() {
        int currentYear = LocalDate.now().getYear();
        return currentYear - hireYear;
    }

    @Override
    public String toString() {
        return displayInfo();
    }
}