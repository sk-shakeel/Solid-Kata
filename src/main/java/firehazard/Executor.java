package firehazard;

import java.util.List;

public class Executor {
    private Controller controller;
    private Operator operator;
    private LightsGrid lightsGrid;
    public Executor(LightsGrid lightsGrid,Controller controller,Operator operator){
        this.lightsGrid=lightsGrid;
        this.controller=controller;
        this.operator=operator;
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
                controller.changeState(lightsGrid,startX, startY, endX, endY, state);
                break;
            case "toggle":
                operator.toggleState(lightsGrid,startX, startY, endX, endY);
                break;
            default:
                System.out.println("Invalid instruction: " + instruction);
        }
    }
}
