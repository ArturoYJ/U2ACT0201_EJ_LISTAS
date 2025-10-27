package playlist;


import java.util.Scanner;

public class MenuPlaylist {

    public static void ejecutar() {
        playlist.PlaylistCircular playlist = new playlist.PlaylistCircular();
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n EJERCICIO 2: PLAYLIST CIRCULAR");

        boolean continuar = true;
        while (continuar) {
            mostrarMenu();
            System.out.print("Selecciona una opción: ");

            try {
                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.print("\nTítulo: ");
                        String titulo = scanner.nextLine();
                        System.out.print("Artista: ");
                        String artista = scanner.nextLine();
                        playlist.agregarCancion(titulo, artista);
                        break;

                    case 2:
                        playlist.reproducirSiguiente();
                        break;

                    case 3:
                        playlist.reproducirAnterior();
                        break;

                    case 4:
                        playlist.eliminarActual();
                        break;

                    case 5:
                        playlist.mostrarActual();
                        break;

                    case 6:
                        playlist.mostrarPlaylist();
                        break;

                    case 7:
                        playlist.modoAleatorio();
                        break;

                    case 0:
                        System.out.println("\n Volviendo al menú principal...");
                        continuar = false;
                        break;

                    default:
                        System.out.println("\nOpción inválida");
                }
            } catch (Exception e) {
                System.out.println("\nError: Ingresa un número válido");
                scanner.nextLine();
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n 1.Agregar canción");
        System.out.println("2.Siguiente");
        System.out.println("3.Anterior");
        System.out.println("4.Eliminar actual");
        System.out.println("5.Ver actual");
        System.out.println("6.Ver playlist");
        System.out.println("7.Modo aleatorio");
        System.out.println("0.Volver");
    }
}
