package firehazard;

public class LightsGrid {
    public static Light[][] lights;

    public LightsGrid(int size) {
        lights = new Light[size][size];
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                lights[x][y] = new Light();
            }
        }
    }


}
