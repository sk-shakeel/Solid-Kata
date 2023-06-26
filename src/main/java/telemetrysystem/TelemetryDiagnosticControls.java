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

}
