package firehazard;

public class LightCounter extends LightOperator{
    public int count(LightsGrid lightsGrid) {
        int litCount = 0;
        for (int x = 0; x < lightsGrid.lights.length; x++) {
            for (int y = 0; y < lightsGrid.lights[x].length; y++) {
                if (lightsGrid.lights[x][y].getState()) {
                    litCount++;
                }
            }
        }
        return litCount;
    }
}
