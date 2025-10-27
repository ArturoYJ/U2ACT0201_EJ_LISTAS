package listas;

public class ListaTareas {
    private Nodo cabeza;
    private int tamanio;

    private class Nodo {
        Tarea tarea;
        Nodo siguiente;

        Nodo(Tarea tarea) {
            this.tarea = tarea;
            this.siguiente = null;
        }
    }

    public ListaTareas() {
        this.cabeza = null;
        this.tamanio = 0;
    }

    public void agregarTarea(String descripcion, String prioridad) {
        Tarea nuevaTarea = new Tarea(descripcion, prioridad);
        Nodo nuevoNodo = new Nodo(nuevaTarea);

        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
        tamanio++;
        System.out.println("Tarea agregada exitosamente!");
    }

    public void agregarTareaOrdenada(String descripcion, String prioridad) {
        Tarea nuevaTarea = new Tarea(descripcion, prioridad);
        Nodo nuevoNodo = new Nodo(nuevaTarea);

        if (cabeza == null || nuevaTarea.getValorPrioridad() > cabeza.tarea.getValorPrioridad()) {
            nuevoNodo.siguiente = cabeza;
            cabeza = nuevoNodo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null &&
                    actual.siguiente.tarea.getValorPrioridad() >= nuevaTarea.getValorPrioridad()) {
                actual = actual.siguiente;
            }
            nuevoNodo.siguiente = actual.siguiente;
            actual.siguiente = nuevoNodo;
        }
        tamanio++;
        System.out.println("Tarea agregada y ordenada por prioridad!");
    }

    public void marcarCompletada(String descripcion) {
        if (cabeza == null) {
            System.out.println("La lista está vacía");
            return;
        }

        if (cabeza.tarea.getDescripcion().equalsIgnoreCase(descripcion)) {
            cabeza.tarea.marcarCompletada();
            System.out.println("Tarea completada: " + descripcion);
            cabeza = cabeza.siguiente;
            tamanio--;
            return;
        }

        Nodo actual = cabeza;
        while (actual.siguiente != null) {
            if (actual.siguiente.tarea.getDescripcion().equalsIgnoreCase(descripcion)) {
                actual.siguiente.tarea.marcarCompletada();
                System.out.println("Tarea completada: " + descripcion);
                actual.siguiente = actual.siguiente.siguiente;
                tamanio--;
                return;
            }
            actual = actual.siguiente;
        }
        System.out.println("Tarea no encontrada: " + descripcion);
    }

    public void mostrarTareasPendientes() {
        if (cabeza == null) {
            System.out.println("\nNo hay tareas pendientes");
            return;
        }

        System.out.println("\nLISTA DE TAREAS PENDIENTES:");
        System.out.println("================================");
        Nodo actual = cabeza;
        int contador = 1;
        while (actual != null) {
            System.out.println(contador + ". " + actual.tarea);
            actual = actual.siguiente;
            contador++;
        }
        System.out.println("Total: " + tamanio + " tarea(s)\n");
    }

    public void buscarTarea(String descripcion) {
        if (cabeza == null) {
            System.out.println("La lista está vacía");
            return;
        }

        Nodo actual = cabeza;
        boolean encontrada = false;
        System.out.println("\n RESULTADOS DE BÚSQUEDA:");
        while (actual != null) {
            if (actual.tarea.getDescripcion().toLowerCase().contains(descripcion.toLowerCase())) {
                System.out.println("→ " + actual.tarea);
                encontrada = true;
            }
            actual = actual.siguiente;
        }
        if (!encontrada) {
            System.out.println("No se encontraron tareas con: \n" + descripcion);
        }
    }

    public void mostrarAltaPrioridad() {
        if (cabeza == null) {
            System.out.println("\nNo hay tareas pendientes");
            return;
        }

        System.out.println("\n TAREAS DE ALTA PRIORIDAD:");
        Nodo actual = cabeza;
        int contador = 0;
        while (actual != null) {
            if (actual.tarea.getPrioridad().equals("alta")) {
                System.out.println(actual.tarea);
                contador++;
            }
            actual = actual.siguiente;
        }
        if (contador == 0) {
            System.out.println("No hay tareas de alta prioridad \n");
        }
    }

    public int getTamanio() {
        return tamanio;
    }
}
