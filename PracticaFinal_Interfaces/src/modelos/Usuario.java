package modelos;

public class Usuario {

	private String usuario, pwd, correo, preferencias;
	private boolean esAdmin;
	private int visitas;

	public Usuario(String usuario, String pwd, String correo, boolean esAdmin, int visitas, String preferencias) {
		super();
		this.usuario = usuario;
		this.pwd = pwd;
		this.correo = correo;
		this.esAdmin = esAdmin;
		this.visitas = visitas;
		this.preferencias = preferencias;
	}
	
	

	public Usuario(String usuario, String pwd, String correo, boolean esAdmin, int visitas) {
		super();
		this.usuario = usuario;
		this.pwd = pwd;
		this.correo = correo;
		this.esAdmin = esAdmin;
		this.visitas = visitas;
	}



	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public boolean isEsAdmin() {
		return esAdmin;
	}

	public void setEsAdmin(boolean esAdmin) {
		this.esAdmin = esAdmin;
	}

	public int getVisitas() {
		return visitas;
	}

	public void setVisitas(int visitas) {
		this.visitas = visitas;
	}

	
	
	public String toStringUsuario() {
		return "//" + usuario + ";" + pwd + ";" + correo +";" +visitas+ ";"+preferencias+"//";
	}
	
	public String toStringAdmin() {
		return "@@" + usuario + ";" + pwd + ";" + correo +";" +visitas+";"+preferencias+"@@";

	}
	
	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + ", pwd=" + pwd + ", correo=" + correo + ", esAdmin=" + esAdmin
				+ ", visitas=" + visitas + ", preferencias = "+preferencias+"]";
	}

	
	
}
