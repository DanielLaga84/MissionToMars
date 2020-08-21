import java.util.Random;
// create class rocket
public class U1 extends Rocket {
    private static int rocketU1Counter;
    private final int MaxloadCargo = 8000;
    private static final int cost = 100000000;
    private final int weight = 10000;
    private double chanceLanunched;
    private double chanceLanded;

    public U1() {
        this(0);
    }
    // setting up all data and how is read in U1
    public U1(int lastWeight) {
        setMAXloadCargo(MaxloadCargo);
        setCost(cost);
        setWeight(weight);
        setTotalWeight(lastWeight);
        rocketU1Counter++;
        System.out.println("-----------------------------");
    }
    public static int getRocketU1Counter() {
        return rocketU1Counter;
    }
    // making setRocketU1counter method
    public static void setRocketU1Counter(int rocketU1Counter){
        U1.rocketU1Counter = rocketU1Counter;
    }
    // Overriding launch method
    @Override
    public boolean launch() {
        System.out.println("\n/LAUNCHING...");
        // random number x math totalWeight / maxloadCargo
        Random randomNumber = new Random();
        double randn = randomNumber.nextDouble();
        chanceLanunched = 0.05 * getTotalWeight() / getMaxloadCargo();
        System.out.print("CargoL " + getWeightOfRocket());
        // if chanceLaunched is below random it will explode if it will be bigger or equal it will start
        if (chanceLanunched >= randn){
            System.out.println("U1 Exploded!!!");
            System.out.println("Preparing next mission!");
            return false;
        }else {
            System.out.println("U1 launched successfully");
            return true;
        }
    }
    // Overriding land  method
    @Override
    public boolean land() {
        System.out.println("\n/LANDING...");
        Random randomNumber = new Random();
        double randn = randomNumber.nextDouble();
        chanceLanded = 0.01 * getTotalWeight() / getMaxloadCargo();
        System.out.print("CargoL " + getWeightOfRocket());
        // if chanceLaunched is below random it will explode if it will be bigger or equal it will start
        if (chanceLanded >= randn){
            System.out.println("U1 CRASHED!!!");
            System.out.println("Preparing next mission!");
            return false;
        }else {
            System.out.println("U1 landed successfully");
            return true;
        }
    }
    // loading totalcost
    public static long getTotalCost() {
        return (long) getRocketU1Counter() * cost;
    }
}
