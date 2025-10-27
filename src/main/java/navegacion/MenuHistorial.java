package navegacion;

import java.util.Scanner;

public class MenuHistorial {

    public static void ejecutar() {
        navegacion.HistorialNavegacion historial = new navegacion.HistorialNavegacion();
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEJERCICIO 3: HISTORIAL NAVEGACIÓN");

        boolean continuar = true;
        while (continuar) {
            mostrarMenu();
            System.out.print("Selecciona una opción: ");

            try {
                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.print("\nURL: ");
                        String url = scanner.nextLine();
                        System.out.print("Título: ");
                        String titulo = scanner.nextLine();
                        historial.agregarPagina(url, titulo);
                        break;

                    case 2:
                        historial.navegarAtras();
                        break;

                    case 3:
                        historial.navegarAdelante();
                        break;

                    case 4:
                        historial.mostrarHistorial();
                        break;

                    case 5:
                        System.out.print("\nBuscar (palabra clave): ");
                        String busqueda = scanner.nextLine();
                        historial.buscarPagina(busqueda);
                        break;

                    case 6:
                        System.out.print("\n¿Seguro que deseas limpiar el historial? (s/n): ");
                        String confirmar = scanner.nextLine();
                        if (confirmar.equalsIgnoreCase("s")) {
                            historial.limpiarHistorial();
                        } else {
                            System.out.println("Operación cancelada");
                        }
                        break;

                    case 7:
                        historial.marcarComoFavorita();
                        break;

                    case 8:
                        historial.mostrarFavoritos();
                        break;

                    case 9:
                        historial.mostrarPaginaActual();
                        break;

                    case 0:
                        System.out.println("\nVolviendo al menú principal...");
                        continuar = false;
                        break;

                    default:
                        System.out.println("\nOpción inválida");
                }
            } catch (Exception e) {
                System.out.println("\n Error: Ingresa un número válido");
                scanner.nextLine();
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n1. ➕ Visitar página");
        System.out.println("│ 2. ◀️  Navegar atrás                │");
        System.out.println("│ 3. ▶️  Navegar adelante             │");
        System.out.println("│ 4. 🌐 Ver historial                 │");
        System.out.println("│ 5. 🔍 Buscar en historial           │");
        System.out.println("│ 6. 🗑️  Limpiar historial            │");
        System.out.println("│ 7. ⭐ Marcar como favorita          │");
        System.out.println("│ 8. ⭐ Ver favoritos                 │");
        System.out.println("│ 9. 📍 Ver página actual             │");
        System.out.println("│ 0. ← Volver                         │");
        System.out.println("└─────────────────────────────────────┘");
    }
}
