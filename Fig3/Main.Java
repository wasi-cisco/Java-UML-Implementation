package Java;

interface Employee {
    void doWork();
}

class Designer implements Employee {
    public void doWork() {
        System.out.println("Designer is creating designs...");
    }
}

class Programmer implements Employee {
    public void doWork() {
        System.out.println("Programmer is writing code...");
    }
}

class Tester implements Employee {
    public void doWork() {
        System.out.println("Tester is testing the software...");
    }
}

abstract class Company {
    public abstract Employee[] getEmployees();

    public void createSoftware() {
        System.out.println("Company is starting software creation...");
        Employee[] employees = getEmployees();
        for (Employee e : employees) {
            e.doWork();
        }
        System.out.println("Software creation completed!\n");
    }
}

class GameDevCompany extends Company {
    @Override
    public Employee[] getEmployees() {
        return new Employee[] {
            new Designer(),
            new Programmer(),
            new Tester()
        };
    }
}

class OutsourcingCompany extends Company {
    @Override
    public Employee[] getEmployees() {
        return new Employee[] {
            new Programmer(),
            new Tester()
        };
    }
}

public class Main {
    public static void main(String[] args) {
        Company gameCompany = new GameDevCompany();
        Company outsourceCompany = new OutsourcingCompany();

        gameCompany.createSoftware();
        outsourceCompany.createSoftware();
    }
}
