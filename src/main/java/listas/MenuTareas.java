package listas;

import java.util.Scanner;

public class MenuTareas {

    public static void ejecutar() {
        listas.ListaTareas lista = new listas.ListaTareas();
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEJERCICIO 1: GESTIÓN DE TAREAS");

        boolean continuar = true;
        while (continuar) {
            mostrarMenu();
            System.out.print("Selecciona una opción: ");

            try {
                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.print("\nDescripción: ");
                        String desc = scanner.nextLine();
                        System.out.print("Prioridad (alta/media/baja): ");
                        String prio = scanner.nextLine();
                        lista.agregarTarea(desc, prio);
                        break;

                    case 2:
                        System.out.print("\nDescripción a completar: ");
                        String descComp = scanner.nextLine();
                        lista.marcarCompletada(descComp);
                        break;

                    case 3:
                        lista.mostrarTareasPendientes();
                        break;

                    case 4:
                        System.out.print("\nBuscar (palabra clave): ");
                        String busqueda = scanner.nextLine();
                        lista.buscarTarea(busqueda);
                        break;

                    case 5:
                        lista.mostrarAltaPrioridad();
                        break;

                    case 6:
                        System.out.print("\nDescripción: ");
                        String descOrd = scanner.nextLine();
                        System.out.print("Prioridad (alta/media/baja): ");
                        String prioOrd = scanner.nextLine();
                        lista.agregarTareaOrdenada(descOrd, prioOrd);
                        break;

                    case 0:
                        System.out.println("\n Volviendo al menú principal...");
                        continuar = false;
                        break;

                    default:
                        System.out.println("\n Opción inválida");
                }
            } catch (Exception e) {
                System.out.println("\n Error: Ingresa un número válido");
                scanner.nextLine();
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n1.Agregar tarea");
        System.out.println("2.Marcar completada");
        System.out.println("3.Mostrar pendientes");
        System.out.println("4.Buscar tarea");
        System.out.println("5.Alta prioridad");
        System.out.println("6.Agregar ordenada");
        System.out.println("0.Volver");
    }
}
