package telemetrySystem;

import org.junit.Before;
import org.junit.Test;
import telemetrysystem.TelemetryClientCommunication;
import telemetrysystem.TelemetryClientConnection;
import telemetrysystem.TelemetryDiagnosticControls;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TelemetryDiagnosticControlsTest {
    private TelemetryClientConnection mockedClientConnection;
    private TelemetryClientCommunication mockedClientCommunication;
    private TelemetryDiagnosticControls diagnosticControls;

    @Before
    public void setUp() {
        mockedClientConnection = mock(TelemetryClientConnection.class);
        mockedClientCommunication = mock(TelemetryClientCommunication.class);
        diagnosticControls = new TelemetryDiagnosticControls(mockedClientConnection, mockedClientCommunication);
    }

    @Test
    public void checkTransmission_SuccessfulTransmission_ReturnsDiagnosticInfo() throws Exception {
        // Arrange
        String expectedDiagnosticInfo = "Mocked diagnostic info";
        when(mockedClientConnection.getOnlineStatus()).thenReturn(true).thenReturn(true);
        when(mockedClientCommunication.receive()).thenReturn(expectedDiagnosticInfo);

        // Act
        diagnosticControls.checkTransmission();

        // Assert
        assertEquals(expectedDiagnosticInfo, diagnosticControls.getDiagnosticInfo());
        verify(mockedClientConnection).disconnect();
        verify(mockedClientConnection, times(3)).getOnlineStatus();
        verify(mockedClientConnection).connect("*111#");
        verify(mockedClientCommunication).send(TelemetryClientCommunication.DIAGNOSTIC_MESSAGE);
        verify(mockedClientCommunication).receive();
    }

    @Test(expected = Exception.class)
    public void checkTransmission_FailedConnection_ThrowsException() throws Exception {
        // Arrange
        when(mockedClientConnection.getOnlineStatus()).thenReturn(false);

        // Act
        diagnosticControls.checkTransmission();
    }
}
