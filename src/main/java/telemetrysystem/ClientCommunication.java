package telemetrysystem;

public interface ClientCommunication {
    void send(String message);
    String receive();
}
