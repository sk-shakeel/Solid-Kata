package telemetrysystem;

public class TelemetryDiagnosticControls
{
    private final String DiagnosticChannelConnectionString = "*111#";

    private final TelemetryClientConnection telemetryClientConnection;
    private final TelemetryClientCommunication telemetryClientCommunication;
    private String diagnosticInfo = "";

    public TelemetryDiagnosticControls(
            TelemetryClientConnection telemetryClientConnection,
            TelemetryClientCommunication telemetryClientCommunication
    ) {
        this.telemetryClientConnection = telemetryClientConnection;
        this.telemetryClientCommunication = telemetryClientCommunication;
    }

    public String getDiagnosticInfo() {
        return diagnosticInfo;
    }

    public void setDiagnosticInfo(String diagnosticInfo) {
        this.diagnosticInfo = diagnosticInfo;
    }

    public void checkTransmission() throws Exception {
        diagnosticInfo = "";

        telemetryClientConnection.disconnect();

        int retryLeft = 3;
        while (!telemetryClientConnection.getOnlineStatus() && retryLeft > 0) {
            telemetryClientConnection.connect(DiagnosticChannelConnectionString);
            retryLeft -= 1;
        }

        if (!telemetryClientConnection.getOnlineStatus()) {
            throw new Exception("Unable to connect.");
        }

        telemetryClientCommunication.send(TelemetryClientCommunication.DIAGNOSTIC_MESSAGE);
        diagnosticInfo = telemetryClientCommunication.receive();
    }

}
