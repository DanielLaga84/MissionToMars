public class Rocket implements SpaceShip {
    private int WeightOfRocket;
    private int weight;
    private int MAXloadCargo;
    private double totalWeight = WeightOfRocket + weight;
    private int cost;
// overriding launch
    @Override
    public boolean launch() {
        return true;
    }
// overriding land
    @Override
    public boolean land() {
        return true;
    }
// overriding method carry
    @Override
    public void carry(Item item) {
        System.out.println("I will take : " + item.getName() + "and it weight : " + item.getWeight());
        WeightOfRocket += item.getWeight();
    }
// overriding method canCarry
    @Override
    public boolean canCarry(Item item) {
        if (MAXloadCargo >= (WeightOfRocket + item.getWeight())) {

            return true;
        } else {
            System.out.println("Can't take with me: " + item.getName() + "because it weight: " + item.getWeight() + ". It's too heavy!!!");
            return false;
        }
    }
// seting all data and make returns
    public void setMAXloadCargo(int MAXloadCargo) {
        this.MAXloadCargo = MAXloadCargo;
    }

    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setWeightOfRocket(int weightOfRocket) {
        this.WeightOfRocket = weightOfRocket;
    }

    public double getWeight() {
        return weight;
    }

    public double getTotalWeight() {
        totalWeight = getWeightOfRocket() + getWeight();
        return totalWeight;
    }

    public double getMaxloadCargo(){
        return MAXloadCargo;
    }

    public double getWeightOfRocket() {
        return WeightOfRocket;
    }
}
