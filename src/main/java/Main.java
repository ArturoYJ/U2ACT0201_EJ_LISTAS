import listas.MenuTareas;
import playlist.MenuPlaylist;
import navegacion.MenuHistorial;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        System.out.println("Ejercicios de Listas");

        while (continuar) {
            mostrarMenuPrincipal();
            System.out.print("Selecciona un ejercicio: ");

            try {
                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        MenuTareas.ejecutar();
                        break;

                    case 2:
                        MenuPlaylist.ejecutar();
                        break;

                    case 3:
                        MenuHistorial.ejecutar();
                        break;

                    case 0:
                        System.out.println("\n¡Hasta pronto");
                        continuar = false;
                        break;

                    default:
                        System.out.println("\n✗ Opción inválida");
                        esperarEnter(scanner);
                }
            } catch (Exception e) {
                System.out.println("\n✗ Error: Ingresa un número válido");
                scanner.nextLine();
                esperarEnter(scanner);
            }
        }

        scanner.close();
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n MENÚ DE EJERCICIOS");
        System.out.println("1.Lista de Tareas Pendientes");
        System.out.println("2.Playlist Musical Circular");
        System.out.println("3.Historial de Navegación Web");
        System.out.println("0.Salir");
    }

    private static void esperarEnter(Scanner scanner) {
        System.out.print("\nPresiona enter para continuar...");
        scanner.nextLine();
    }
}
