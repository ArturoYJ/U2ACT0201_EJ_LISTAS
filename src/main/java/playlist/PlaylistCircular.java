package playlist;

import java.util.ArrayList;
import java.util.Random;

public class PlaylistCircular {
    private Nodo cabeza;
    private Nodo actual;
    private int tamanio;

    private class Nodo {
        Cancion cancion;
        Nodo siguiente;

        Nodo(playlist.Cancion cancion) {
            this.cancion = cancion;
            this.siguiente = null;
        }
    }

    public PlaylistCircular() {
        this.cabeza = null;
        this.actual = null;
        this.tamanio = 0;
    }

    public void agregarCancion(String titulo, String artista) {
        Cancion nuevaCancion = new Cancion(titulo, artista);
        Nodo nuevoNodo = new Nodo(nuevaCancion);

        if (cabeza == null) {
            cabeza = nuevoNodo;
            nuevoNodo.siguiente = cabeza; // Apunta a sí mismo
            actual = cabeza;
        } else {
            Nodo temp = cabeza;
            while (temp.siguiente != cabeza) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevoNodo;
            nuevoNodo.siguiente = cabeza; // Cierra el círculo
        }
        tamanio++;
        System.out.println("Canción agregada: " + nuevaCancion);
    }

    public void reproducirSiguiente() {
        if (actual == null) {
            System.out.println("La playlist está vacía");
            return;
        }
        actual = actual.siguiente;
        System.out.println("▶Reproduciendo: " + actual.cancion);
    }

    public void reproducirAnterior() {
        if (actual == null) {
            System.out.println("La playlist está vacía");
            return;
        }
        Nodo temp = actual;
        while (temp.siguiente != actual) {
            temp = temp.siguiente;
        }
        actual = temp;
        System.out.println("◀Reproduciendo: " + actual.cancion);
    }

    public void eliminarActual() {
        if (actual == null) {
            System.out.println("La playlist está vacía");
            return;
        }

        if (tamanio == 1) {
            System.out.println("Eliminada: " + actual.cancion);
            cabeza = null;
            actual = null;
            tamanio = 0;
            return;
        }

        Nodo temp = actual;
        while (temp.siguiente != actual) {
            temp = temp.siguiente;
        }

        System.out.println("Eliminada: " + actual.cancion);

        if (actual == cabeza) {
            cabeza = actual.siguiente;
        }

        temp.siguiente = actual.siguiente;
        actual = actual.siguiente;
        tamanio--;
    }

    public void mostrarActual() {
        if (actual == null) {
            System.out.println("No hay canción reproduciéndose");
            return;
        }
        System.out.println("\n🎵 REPRODUCIENDO AHORA \n:");
        System.out.println(actual.cancion);
    }

    public void mostrarPlaylist() {
        if (cabeza == null) {
            System.out.println("\n La playlist está vacía");
            return;
        }

        System.out.println("\n PLAYLIST COMPLETA:");
        Nodo temp = cabeza;
        int contador = 1;
        do {
            String marcador = (temp == actual) ? "▶" : "   ";
            System.out.println(marcador + contador + ". " + temp.cancion);
            temp = temp.siguiente;
            contador++;
        } while (temp != cabeza);
        System.out.println("Total: " + tamanio + " canción(es)\n");
    }

    public void modoAleatorio() {
        if (cabeza == null) {
            System.out.println("La playlist está vacía");
            return;
        }

        // Crear lista de todas las canciones
        ArrayList<Cancion> canciones = new ArrayList<>();
        Nodo temp = cabeza;
        do {
            canciones.add(temp.cancion);
            temp = temp.siguiente;
        } while (temp != cabeza);

        // Mezclar aleatoriamente
        Random random = new Random();
        System.out.println("\n MODO ALEATORIO ACTIVADO:");

        for (int i = 0; i < tamanio; i++) {
            int indiceAleatorio = random.nextInt(canciones.size());
            Cancion cancionAleatoria = canciones.remove(indiceAleatorio);
            System.out.println((i + 1) + ". " + cancionAleatoria);
        }
    }

    public int getTamanio() {
        return tamanio;
    }
}
