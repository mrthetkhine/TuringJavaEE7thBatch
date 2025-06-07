class Car 
{
    Engine engine;

    public Car(Engine engine)
    {
        this.engine = engine;
    }

    public void start()
    {
        engine.start();
    }
}
class Engine
{
    public void start()
    {
        System.out.println("Engine started");
    }
}
class DieselEngine extends Engine
{
    public void start()
    {
        System.out.println("DieselEngine started");
    }
}
class ElectricEngine extends Engine
{
    public void start()
    {
        System.out.println("ElectricEngine started");
    }
}
public class OCPProblem
{
    public static void main(String[] args)
    {
        //System.out.println("Hello World");
        Engine engine = new ElectricEngine();
        Car car = new Car(engine);
        car.start();
    }
}