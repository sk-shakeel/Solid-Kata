package telemetrysystem;

public class NetworkTransmitter implements Transmitter{
    private final TelemetryClientConnection telemetryClientConnection;
    private final TelemetryClientCommunication telemetryClientCommunication;

    public TransmissionChecker(
            TelemetryClientConnection telemetryClientConnection,
            TelemetryClientCommunication telemetryClientCommunication
    ) {
        this.telemetryClientConnection = telemetryClientConnection;
        this.telemetryClientCommunication = telemetryClientCommunication;
    }

    @Override
    public void checkTransmission(TelemetryDiagnosticControls diagnosticControls) throws Exception {
        diagnosticControls.setDiagnosticInfo("");

        telemetryClientConnection.disconnect();

        int retryLeft = 3;
        while (!telemetryClientConnection.getOnlineStatus() && retryLeft > 0) {
            telemetryClientConnection.connect(diagnosticControls.DiagnosticChannelConnectionString);
            retryLeft -= 1;
        }

        if (!telemetryClientConnection.getOnlineStatus()) {
            throw new Exception("Unable to connect.");
        }

        telemetryClientCommunication.send(TelemetryClientCommunication.DIAGNOSTIC_MESSAGE);
        diagnosticControls.setDiagnosticInfo(telemetryClientCommunication.receive());
    }



}
