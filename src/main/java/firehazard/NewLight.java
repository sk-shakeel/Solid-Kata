package firehazard;

public class NewLight {
    private int brightness;

    public int getBrightness() {
        return brightness;
    }

    public void increaseBrightness() {
        brightness++;
    }

    public void decreaseBrightness() {
        if (brightness > 0) {
            brightness--;
        }
    }

    public void toggleBrightness() {
        brightness += 2;
    }
}
