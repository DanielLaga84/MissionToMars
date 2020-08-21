import java.util.Random;
// create class rocket
public class U2 extends Rocket {
    private static int rocketU2Counter;
    private final int MaxloadCargo = 11000;
    private static final int cost = 120000000;
    private final int weight = 18000;
    private double chanceLanunched;
    private double chanceLanded;

    public U2() {
        this(0);
    }
    // setting up all data and how is read in U2
    public U2(int lastWeight) {
        setMAXloadCargo(MaxloadCargo);
        setCost(cost);
        setWeight(weight);
        setTotalWeight(lastWeight);
        rocketU2Counter++;
        System.out.println("-----------------------------");
    }
    public static int getRocketU2Counter() {
        return rocketU2Counter;
    }
    // making setRocketU2counter method
    public static void setRocketU2Counter(int rocketU2Counter){
        U2.rocketU2Counter = rocketU2Counter;
    }
    //// Overriding launch method
    @Override
    public boolean launch() {
        System.out.println("\n/LAUNCHING...");
        Random randomNumber = new Random();
        double randn = randomNumber.nextDouble();
        chanceLanunched = 0.04 * getTotalWeight() / getMaxloadCargo();
        System.out.print("CargoL " + getWeightOfRocket());

        if (chanceLanunched >= randn){
            System.out.println("U2 Exploded!!!");
            System.out.println("Preparing next mission!");
            return false;
        }else {
            System.out.println("U2 launched successfully");
            return true;
        }
    }
    // // Overriding land  method
    @Override
    public boolean land() {
        System.out.println("\n/LANDING...");
        Random randomNumber = new Random();
        double randn = randomNumber.nextDouble();
        chanceLanded = 0.01 * getTotalWeight() / getMaxloadCargo();
        System.out.print("CargoL " + getWeightOfRocket());

        if (chanceLanded >= randn){
            System.out.println("U2 CRASHED!!!");
            System.out.println("Preparing next mission!");
            return false;
        }else {
            System.out.println("U2 landed successfully");
            return true;
        }
    }
    // loading totalcost
    public static long getTotalCost() {
        return (long) getRocketU2Counter() * cost;
    }
}
