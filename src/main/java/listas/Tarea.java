package listas;

public class Tarea {
    private String descripcion;
    private String prioridad;
    private boolean completada;

    public Tarea(String descripcion, String prioridad) {
        this.descripcion = descripcion;
        this.prioridad = prioridad.toLowerCase();
        this.completada = false;
    }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getPrioridad() { return prioridad; }
    public void setPrioridad(String prioridad) { this.prioridad = prioridad.toLowerCase(); }
    public boolean isCompletada() { return completada; }
    public void marcarCompletada() { this.completada = true; }

    public int getValorPrioridad() {
        switch (prioridad) {
            case "alta": return 3;
            case "media": return 2;
            case "baja": return 1;
            default: return 0;
        }
    }

    @Override
    public String toString() {
        String estado = completada ? "[✓]" : "[ ]";
        return String.format("%s [%s] %s", estado, prioridad.toUpperCase(), descripcion);
    }
}
