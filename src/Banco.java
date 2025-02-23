import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Banco {
// LinkedList para la cola normal 
    private Queue<Cliente> colaNormal;
    
    // PriorityQueue para clientes prioritarios
    private PriorityQueue<Cliente> colaPrioritaria;
    private Scanner scanner;

    // costructor Banco 
    public Banco() {
        this.colaNormal = new LinkedList<>();
        this.colaPrioritaria = new PriorityQueue<>();
        this.scanner = new Scanner(System.in);
    }

    // metodo agregarCliente
    public void agregarCliente() {
        System.out.print("\n Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine().trim();

        if (nombre.isEmpty()) {
            System.out.println("El nombre no puede estar vacío. Intente nuevamente.");
            return;
        }

        boolean esPrioritario = false;
        while (true) {
            System.out.print("¿Es cliente prioritario? (Si/No): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("si")) {
                esPrioritario = true;
                break;
            } else if (input.equals("no")) {
                esPrioritario = false;
                break;
            } else {
                System.out.println("Entrada no válida. Ingrese 'Si' o 'No'.");
            }
        }

        Cliente cliente = new Cliente(nombre, esPrioritario);
        if (esPrioritario) {
            colaPrioritaria.add(cliente);
        } else {
            colaNormal.add(cliente);
        }
        mostrarEstado();
    }

    // metodo atenderCliente
    public void atenderCliente() {
        if (!colaPrioritaria.isEmpty()) {
            Cliente atendido = colaPrioritaria.poll();
            System.out.println("Atendiendo a cliente prioritario: " + atendido.nombre);
        } else if (!colaNormal.isEmpty()) {
            Cliente atendido = colaNormal.poll();
            System.out.println("Atendiendo a cliente: " + atendido.nombre);
        } else {
            System.out.println("No hay clientes en espera.");
        }
        mostrarEstado();
    }

    // metodo mostrarEstado
    public void mostrarEstado() {
        int totalClientes = colaPrioritaria.size() + colaNormal.size();
        System.out.println("Clientes en espera: " + totalClientes);
    }

    // metodo menu(switch)
    public void menu() {
        int opcion = 0;
        do {
            System.out.println("\n1. Agregar cliente");
            System.out.println("2. Atender cliente");
            System.out.println("3. Mostrar cola de espera");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Intente nuevamente.");
                continue; // Vuelve a pedir la opción sin salir del bucle
            }

            switch (opcion) {
                case 1:
                    agregarCliente();
                    break;
                case 2:
                    atenderCliente();
                    break;
                case 3:
                    mostrarEstado();
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 4);

        // Cerrar el Scanner después de salir del bucle
        scanner.close();
        System.out.println("Sistema cerrado correctamente.");
    }

}