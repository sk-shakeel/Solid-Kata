package firehazard;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int GRID_SIZE = 1000;

    public static void main(String[] args) {

        LightsGrid lightsGrid = new LightsGrid(GRID_SIZE);
        Operator lightOperator = new LightOperator();
        Controller lightsController = new LightsController();
        LightCounter counter=new LightCounter();

        List<String> instructions = new ArrayList<>();
        instructions.add("turn on 887,9 through 959,629");
        instructions.add("turn on 454,398 through 844,448");
        instructions.add("turn off 539,243 through 559,965");
        instructions.add("turn off 370,819 through 676,868");
        instructions.add("turn off 145,40 through 370,997");
        instructions.add("turn off 301,3 through 808,453");
        instructions.add("turn on 351,678 through 951,908");
        instructions.add("toggle 720,196 through 897,994");
        instructions.add("toggle 831,394 through 904,860");

        Executor executor = new Executor(lightsGrid,lightsController, lightOperator);

        executor.executeInstructions(instructions);

        int litCount = counter.count(lightsGrid);
        System.out.println("Number of lights lit: " + litCount);
    }
}
