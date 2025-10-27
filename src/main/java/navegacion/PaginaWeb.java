package navegacion;

import java.util.Date;
import java.text.SimpleDateFormat;

public class PaginaWeb {
    private String url;
    private String titulo;
    private Date fechaVisita;
    private boolean esFavorita;

    public PaginaWeb(String url, String titulo) {
        this.url = url;
        this.titulo = titulo;
        this.fechaVisita = new Date();
        this.esFavorita = false;
    }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public Date getFechaVisita() { return fechaVisita; }
    public boolean isFavorita() { return esFavorita; }
    public void marcarFavorita() { this.esFavorita = true; }
    public void desmarcarFavorita() { this.esFavorita = false; }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String favorito = esFavorita ? "⭐ " : "";
        return favorito + titulo + " (" + url + ") - " + sdf.format(fechaVisita);
    }
}
