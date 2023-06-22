package firehazard;

public class LightsGrid implements Operations{
    private Light[][] lights;

    public LightsGrid(int size) {
        lights = new Light[size][size];
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                lights[x][y] = new Light();
            }
        }
    }

    @Override
    public void turningOn(int startX, int startY, int endX, int endY, boolean state) {
        for (int x = startX; x <= endX; x++) {
            for (int y = startY; y <= endY; y++) {
                if (state) {
                    lights[x][y].turnOn();
                } else {
                    lights[x][y].turnOff();
                }
            }
        }
    }

    @Override
    public void toggling(int startX, int startY, int endX, int endY) {
        for (int x = startX; x <= endX; x++) {
            for (int y = startY; y <= endY; y++) {
                lights[x][y].toggle();
            }
        }
    }

    @Override
    public int count() {
        int litCount = 0;
        for (int x = 0; x < lights.length; x++) {
            for (int y = 0; y < lights[x].length; y++) {
                if (lights[x][y].isOn()) {
                    litCount++;
                }
            }
        }
        return litCount;
    }
}
