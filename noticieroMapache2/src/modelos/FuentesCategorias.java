package modelos;

public class FuentesCategorias {

	public String categoria,periodico, url, css;

	public FuentesCategorias(String categoria, String periodico, String url, String css) {
		super();
		this.categoria = categoria;
		this.periodico = periodico;
		this.url = url;
		this.css = css;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getPeriodico() {
		return periodico;
	}

	public void setPeriodico(String periodico) {
		this.periodico = periodico;
	}

	@Override
	public String toString() {
		return "FuentesCategorias [categoria=" + categoria + ", periodico=" + periodico + ", url=" + url + ", css="
				+ css + "]";
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

	
}
