package firehazard;

public interface Operations {
    void turningOn(int x1, int y1, int x2, int y2, boolean state);
    void toggling(int x1, int y1, int x2, int y2);
    int count();
}
