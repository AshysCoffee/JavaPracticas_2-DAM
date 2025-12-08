package modelos;

public class EnvioCorreo {

	private String horaEnvio;
    private String emailSalida;
    private String pwdEmailSalida;
    private final String smtp_host = "smtp.gmail.com";
    private final int smtp_port = 587;
	
    
    public EnvioCorreo(String horaEnvio, String emailSalida, String pwdEmailSalida) {
		super();
		this.horaEnvio = horaEnvio;
		this.emailSalida = emailSalida;
		this.pwdEmailSalida = pwdEmailSalida;
	}


	public String getHoraEnvio() {
		return horaEnvio;
	}


	public void setHoraEnvio(String horaEnvio) {
		this.horaEnvio = horaEnvio;
	}


	public String getEmailSalida() {
		return emailSalida;
	}


	public void setEmailSalida(String emailSalida) {
		this.emailSalida = emailSalida;
	}


	public String getPwdEmailSalida() {
		return pwdEmailSalida;
	}


	public void setPwdEmailSalida(String pwdEmailSalida) {
		this.pwdEmailSalida = pwdEmailSalida;
	}


	public String getSmtp_host() {
		return smtp_host;
	}


	public int getSmtp_port() {
		return smtp_port;
	}


	@Override
	public String toString() {
		return "EnvioCorreo [horaEnvio=" + horaEnvio + ", emailSalida=" + emailSalida + ", pwdEmailSalida="
				+ pwdEmailSalida + ", smtp_host=" + smtp_host + ", smtp_port=" + smtp_port + "]";
	}
    
    
	
}
