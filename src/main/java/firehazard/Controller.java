package firehazard;

public interface Controller {
    void changeState(LightsGrid lightsGrid,int x1, int y1, int x2, int y2, boolean state);
}
