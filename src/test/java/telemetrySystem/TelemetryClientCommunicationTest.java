package telemetrySystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telemetrysystem.TelemetryClientCommunication;

import static org.junit.jupiter.api.Assertions.*;

public class TelemetryClientCommunicationTest {
    private TelemetryClientCommunication telemetryClientCommunication;

    @BeforeEach
    public void setUp() {
        telemetryClientCommunication = new TelemetryClientCommunication();
    }

    @Test
    public void testSendWithValidMessage() {
        String validMessage = "valid_message";
        assertDoesNotThrow(() -> telemetryClientCommunication.send(validMessage));
    }

    @Test
    public void testSendWithNullMessage() {
        assertThrows(IllegalArgumentException.class, () -> telemetryClientCommunication.send(null));
    }

    @Test
    public void testSendWithEmptyMessage() {
        assertThrows(IllegalArgumentException.class, () -> telemetryClientCommunication.send(""));
    }

    @Test
    public void testReceiveWithDiagnosticMessage() {
        String diagnosticMessage = "AT#UD";
        telemetryClientCommunication.send(diagnosticMessage);
        String receivedMessage = telemetryClientCommunication.receive();
        assertNotNull(receivedMessage);
        assertTrue(receivedMessage.contains("LAST TX rate"));
        assertTrue(receivedMessage.contains("HIGHEST TX rate"));
        assertTrue(receivedMessage.contains("LAST RX rate"));
        assertTrue(receivedMessage.contains("HIGHEST RX rate"));
        assertTrue(receivedMessage.contains("BIT RATE"));
        assertTrue(receivedMessage.contains("WORD LEN"));
        assertTrue(receivedMessage.contains("WORD/FRAME"));
        assertTrue(receivedMessage.contains("BITS/FRAME"));
        assertTrue(receivedMessage.contains("MODULATION TYPE"));
        assertTrue(receivedMessage.contains("TX Digital Los"));
        assertTrue(receivedMessage.contains("RX Digital Los"));
        assertTrue(receivedMessage.contains("BEP Test"));
        assertTrue(receivedMessage.contains("Local Rtrn Count"));
        assertTrue(receivedMessage.contains("Remote Rtrn Count"));
    }

    @Test
    public void testReceiveWithRandomMessage() {
        String receivedMessage = telemetryClientCommunication.receive();
        assertNotNull(receivedMessage);
        assertTrue(receivedMessage.length() >= 60);
    }
}
