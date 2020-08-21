import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
// making Simulation class, than setting up all Arraylist and Phases
public class Simulation {
    private ArrayList<Item> items;
    private ArrayList<Rocket> rocketu1;
    private ArrayList<Rocket> rocketu2;
    private boolean hasLanded = true;
    private File phase1 = new File("phase-1.txt");
    private File phase2 = new File("phase-2.txt");

    public Simulation() {
    }

    // setting loadItems in Arraylist
    public ArrayList<Item> loadItems(int phase) throws FileNotFoundException{

        if (phase == 1) {
            System.out.println("Loading phase1,get ready!");
            loadingscreen(phase1);
        }else{
            System.out.println("Loading phase2, get ready!");
            loadingscreen(phase2);
        }
        return items;
    }
    // Setting method of loading file and how it is read
    public void loadingscreen(File file) throws FileNotFoundException{
        items = new ArrayList<>();
        Scanner filescanner = new Scanner(file);

        while (filescanner.hasNextLine()){
            String string = filescanner.nextLine();
            String[] separated = string.split("=");

            Item item = new Item(separated[0],Integer.parseInt(separated[1]) );
            items.add(item);
        }
    }
    // setting loadU1 and method how rocket will be created
    public ArrayList<Rocket> loadU1(List<Item> itemsU1) {
        System.out.println("loading u1...");
        rocketu1 = new ArrayList<>();
        Rocket rocket = new U1();
        Iterator iterator = itemsU1.iterator();

        while (iterator.hasNext()){
            Item item = (Item) iterator.next();
            if (rocket.canCarry(item)) {
                rocket.carry(item);
            }else {
                rocketu1.add(rocket);
                rocket = new U1();
                System.out.println("New U1 rocket created");
                rocket.carry(item);
            }
            if (!iterator.hasNext()) {
                rocketu1.add(rocket);
            }
        }

        return rocketu1;
    }
    // setting loadU2 and method how rocket will be created
    public ArrayList<Rocket> loadU2(List<Item> itemsU2) {
        System.out.println("loading u2...");
        rocketu2 = new ArrayList<>();
        Rocket rocket = new U2();
        Iterator iterator = itemsU2.iterator();

        while (iterator.hasNext()){
            Item item = (Item) iterator.next();
            if (rocket.canCarry(item)) {
                rocket.carry(item);
            }else {
                rocketu2.add(rocket);
                rocket = new U2();
                System.out.println("New U2 rocket created");
                rocket.carry(item);
            }
            if (!iterator.hasNext()) {
                rocketu2.add(rocket);
            }
        }

        return rocketu2;
    }
    // Run simulation method
    public void runSimulation (ArrayList<Rocket>rockets, int i) {
    for (Rocket rocket : rockets) {

        while (!rocket.launch()){
            launchSimulation(i);
        }
        while (!rocket.land()){
            while (!rocket.launch()){
                launchSimulation(i);
            }
            landSimulation(i);
        }
    }
    }

    // setting launchSimulation method with U1 and U2 method
    public void launchSimulation(int i) {

        if (i == 1) {
            int counter1 = U1.getRocketU1Counter();
            counter1++;
            U1.setRocketU1Counter(counter1);
        } else {
            int counter1 = U2.getRocketU2Counter();
            counter1++;
            U2.setRocketU2Counter(counter1);
        }
    }
    // setting landSimulation method with U1 and U2 method
    public void landSimulation(int i) {

        if (i == 1) {
            int counter = U1.getRocketU1Counter();
                counter++;
                U1.setRocketU1Counter(counter);
            } else {
                int counter = U2.getRocketU2Counter();
                counter++;
                U2.setRocketU2Counter(counter);
            }

    hasLanded = false;
    }
}
