package navegacion;

import java.util.ArrayList;

public class HistorialNavegacion {
    private Nodo actual;
    private int tamanio;
    private int maxHistorial = 10;
    private ArrayList<PaginaWeb> favoritos;

    private class Nodo {
        PaginaWeb pagina;
        Nodo anterior;
        Nodo siguiente;

        Nodo(PaginaWeb pagina) {
            this.pagina = pagina;
            this.anterior = null;
            this.siguiente = null;
        }
    }

    public HistorialNavegacion() {
        this.actual = null;
        this.tamanio = 0;
        this.favoritos = new ArrayList<>();
    }

    public void agregarPagina(String url, String titulo) {
        PaginaWeb nuevaPagina = new PaginaWeb(url, titulo);
        Nodo nuevoNodo = new Nodo(nuevaPagina);

        if (actual != null) {
            // Eliminar todo el historial hacia adelante
            actual.siguiente = null;

            // Agregar nueva página
            nuevoNodo.anterior = actual;
            actual.siguiente = nuevoNodo;
        }

        actual = nuevoNodo;
        tamanio++;

        // Limitar historial a máximo 10
        if (tamanio > maxHistorial) {
            eliminarMasAntigua();
        }

        System.out.println("Página visitada: " + titulo);
    }

    private void eliminarMasAntigua() {
        if (actual == null) return;

        // Ir al inicio
        Nodo temp = actual;
        while (temp.anterior != null) {
            temp = temp.anterior;
        }

        // Eliminar la primera (más antigua)
        if (temp.siguiente != null) {
            temp.siguiente.anterior = null;
        }
        tamanio--;
    }

    public void navegarAtras() {
        if (actual == null) {
            System.out.println(" No hay historial");
            return;
        }

        if (actual.anterior == null) {
            System.out.println("Ya estás en la página más antigua");
            return;
        }

        actual = actual.anterior;
        System.out.println(" Navegando a: " + actual.pagina);
    }

    public void navegarAdelante() {
        if (actual == null) {
            System.out.println("No hay historial");
            return;
        }

        if (actual.siguiente == null) {
            System.out.println("Ya estás en la página más reciente");
            return;
        }

        actual = actual.siguiente;
        System.out.println("Navegando a: " + actual.pagina);
    }

    public void mostrarHistorial() {
        if (actual == null) {
            System.out.println("\n El historial está vacío");
            return;
        }

        // Ir al inicio
        Nodo temp = actual;
        while (temp.anterior != null) {
            temp = temp.anterior;
        }

        System.out.println("\nHISTORIAL COMPLETO:");
        int contador = 1;
        while (temp != null) {
            String marcador = (temp == actual) ? "► " : "  ";
            System.out.println(marcador + contador + ". " + temp.pagina);
            temp = temp.siguiente;
            contador++;
        }
        System.out.println("Total: " + tamanio + " página(s)\n");
    }

    public void buscarPagina(String termino) {
        if (actual == null) {
            System.out.println("El historial está vacío");
            return;
        }

        // Ir al inicio
        Nodo temp = actual;
        while (temp.anterior != null) {
            temp = temp.anterior;
        }

        System.out.println("\n RESULTADOS DE BÚSQUEDA:");
        boolean encontrada = false;
        while (temp != null) {
            if (temp.pagina.getTitulo().toLowerCase().contains(termino.toLowerCase()) ||
                    temp.pagina.getUrl().toLowerCase().contains(termino.toLowerCase())) {
                System.out.println(temp.pagina);
                encontrada = true;
            }
            temp = temp.siguiente;
        }

        if (!encontrada) {
            System.out.println(" No se encontraron páginas con: " + termino);
        }
    }

    public void limpiarHistorial() {
        actual = null;
        tamanio = 0;
        System.out.println(" Historial limpiado completamente");
    }

    public void marcarComoFavorita() {
        if (actual == null) {
            System.out.println(" No hay página actual");
            return;
        }

        if (!actual.pagina.isFavorita()) {
            actual.pagina.marcarFavorita();
            favoritos.add(actual.pagina);
            System.out.println(" Página marcada como favorita");
        } else {
            System.out.println(" Esta página ya es favorita");
        }
    }

    public void mostrarFavoritos() {
        if (favoritos.isEmpty()) {
            System.out.println("\n No hay favoritos");
            return;
        }

        System.out.println("\n PÁGINAS FAVORITAS:");
        for (int i = 0; i < favoritos.size(); i++) {
            System.out.println((i + 1) + ". " + favoritos.get(i));
        }
        System.out.println("Total: " + favoritos.size() + " favorito(s)\n");
    }

    public void mostrarPaginaActual() {
        if (actual == null) {
            System.out.println("No hay página actual");
            return;
        }
        System.out.println("\n PÁGINA ACTUAL:");
        System.out.println(actual.pagina);
    }

    public int getTamanio() {
        return tamanio;
    }
}
