package telemetrySystem;


import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import telemetrysystem.TelemetryClientConnection;

import static org.junit.Assert.*;

public class TelemetryClientConnectionTest {
    private TelemetryClientConnection telemetryClientConnection;

    @BeforeEach
    public void setUp() {
        telemetryClientConnection = new TelemetryClientConnection();
    }

    @Test
    public void testConnectWithValidConnectionString() {
        String validConnectionString = "valid_connection_string";
        telemetryClientConnection.connect(validConnectionString);
        assertTrue(telemetryClientConnection.getOnlineStatus());
    }

    @Test
    public void testConnectWithNullConnectionString() {
        assertThrows(IllegalArgumentException.class, () -> {
            telemetryClientConnection.connect(null);
        });
        assertFalse(telemetryClientConnection.getOnlineStatus());
    }

    @Test
    public void testConnectWithEmptyConnectionString() {
        assertThrows(IllegalArgumentException.class, () -> {
            telemetryClientConnection.connect("");
        });
        assertFalse(telemetryClientConnection.getOnlineStatus());
    }

    @Test
    public void testDisconnect() {
        telemetryClientConnection.connect("valid_connection_string");
        telemetryClientConnection.disconnect();
        assertFalse(telemetryClientConnection.getOnlineStatus());
    }
}
