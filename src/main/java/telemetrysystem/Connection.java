package telemetrysystem;

public interface Connection {
    void connect(String telemetryServerConnectionString);
    void disconnect();
}
