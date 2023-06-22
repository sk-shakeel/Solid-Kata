package firehazard;

import java.util.List;

public class Executor {
    private Operations grid;

    public Executor(Operations grid){
        this.grid=grid;
    }

    public void executeInstructions(List<String> instructions) {
        for (String instruction : instructions) {
            executeInstruction(instruction);
        }
    }

    private void executeInstruction(String instruction) {
        String[] parts = instruction.split(" ");
        String action = parts[0];
        String[] startCoordinates;
        String[] endCoordinates;

        if (instruction.startsWith("toggle")) {
            startCoordinates = parts[1].split(",");
            endCoordinates = parts[3].split(",");
        } else {
            startCoordinates = parts[2].split(",");
            endCoordinates = parts[4].split(",");
        }


        int startX = Integer.parseInt(startCoordinates[0]);
        int startY = Integer.parseInt(startCoordinates[1]);
        int endX = Integer.parseInt(endCoordinates[0]);
        int endY = Integer.parseInt(endCoordinates[1]);

        switch (action) {
            case "turn":
                boolean state = parts[1].equals("on");
                grid.turningOn(startX, startY, endX, endY, state);
                break;
            case "toggle":
                grid.toggling(startX, startY, endX, endY);
                break;
            default:
                System.out.println("Invalid instruction: " + instruction);
        }
    }
}
