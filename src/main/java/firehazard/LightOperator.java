package firehazard;

public class LightOperator implements Operator {
    @Override
    public void toggleState(LightsGrid lightsGrid,int startX, int startY, int endX, int endY) {
        for (int x = startX; x <= endX; x++) {
            for (int y = startY; y <= endY; y++) {
                lightsGrid.lights[x][y].setState(!(lightsGrid.lights[x][y].getState()));
            }
        }
    }
}
