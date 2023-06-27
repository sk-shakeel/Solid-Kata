package firehazard;

public class NewLightController extends Controller{
    @Override
    public void changeState(LightsGrid lightsGrid, int x1, int y1, int x2, int y2, boolean state) {
        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                if (state) {
                    lightsGrid.lights[x][y].increaseBrightness();
                } else {
                    lightsGrid.lights[x][y].decreaseBrightness();
                }
            }
        }
    }
        public void toggleState(LightsGrid lightsGrid, int startX, int startY, int endX, int endY) {
            for (int x = startX; x <= endX; x++) {
                for (int y = startY; y <= endY; y++) {
                    lightsGrid.lights[x][y].toggleBrightness();
                }
            }
        }

    public int count(LightsGrid lightsGrid) {
        int totalBrightness = 0;
        for (int x = 0; x < lightsGrid.lights.length; x++) {
            for (int y = 0; y < lightsGrid.lights[x].length; y++) {
                totalBrightness += lightsGrid.lights[x][y].getBrightness();
            }
        }
        return totalBrightness;
    }

}
