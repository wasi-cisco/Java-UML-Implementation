package Java;

interface Engine{
    void move();
}

interface Driver{
    void navigate();
}

class CombustionEngine implements Engine{
    public void move(){
        System.out.println("Moving with Combustion Engine.");
    }
   
}

class ElectricEngine implements Engine{
    public void move(){
        System.out.println("Moving with Electric Engine.");
    }
}

class Robot implements Driver{
    public void navigate() {
        System.out.println("Robot is navigating the Driver.");
    }
}

class Human implements Driver{
    public void navigate(){
        System.out.println("Human is navigating the Driver");
    }
}

class Transport{
    private Engine engine;
    private Driver driver;

    public Transport(Engine engine, Driver driver){
        this.driver =driver;
        this.engine = engine;
    }

    public void deliver(String destination, String Cargo){
        System.out.println("Delivering " + Cargo + "to" +  destination);
        driver.navigate();
        engine.move();

    }
}

public class Main {
    public static void main(String[] args){
        Engine combustion = new CombustionEngine();
        Engine electric = new ElectricEngine();

        Driver human = new Human();
        Driver robot = new Robot();

        
        Transport truck = new Transport(combustion, human);
        Transport drone = new Transport(electric, robot);

        truck.deliver("Karachi", "Electronics");
        drone.deliver("Lahore", "Medicines");
    }
}
