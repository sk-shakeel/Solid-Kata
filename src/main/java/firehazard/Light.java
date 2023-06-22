package firehazard;

public class Light implements Switch{

    private boolean state;

    @Override
    public void turnOn() {
        state = true;
    }

    @Override
    public void turnOff() {
        state = false;
    }

    @Override
    public void toggle() {
        state = !state;
    }

    public boolean isOn() {
        return state;
    }
}
