package modelos;

public class Fuentes {

	public String periodico, url, css;
	public Categorias categoria;
	
	
	public Fuentes(Categorias categoria, String periodico, String url, String css ) {
		super();
		this.periodico = periodico;
		this.url = url;
		this.css = css;
		this.categoria = categoria;
	}
	
	
	
	public String getPeriodico() {
		return periodico;
	}
	public void setPeriodico(String periodico) {
		this.periodico = periodico;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCss() {
		return css;
	}
	public void setCss(String css) {
		this.css = css;
	}
	public Categorias getCategoria() {
		return categoria;
	}
	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
	}
	
	
}
