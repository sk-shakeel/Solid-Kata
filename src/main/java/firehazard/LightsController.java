package firehazard;

public class LightsController implements Controller{
    @Override
    public void changeState(LightsGrid lightsGrid,int startX, int startY, int endX, int endY, boolean state) {
        for (int x = startX; x <= endX; x++) {
            for (int y = startY; y <= endY; y++) {
                if (state) {
                    lightsGrid.lights[x][y].setState(true);
                } else {
                    lightsGrid.lights[x][y].setState(false);
                }
            }
        }
    }
}
