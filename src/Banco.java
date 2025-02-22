import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Banco {
// LinkedList para la cola normal 
    private Queue<Cliente> colaNormal;

    // PriorityQueue para clientes prioritarios
    private PriorityQueue<Cliente> colaPrioritaria;
    
    // costructor Banco
    public Banco() {
        this.colaNormal = new LinkedList<>();
        this.colaPrioritaria = new PriorityQueue<>();
    }

    // Agrega clientes según su prioridad.
    public void agregarCliente(String nombre, boolean esPrioritario) {
        Cliente cliente = new Cliente(nombre, esPrioritario);
        if (esPrioritario) {
            colaPrioritaria.add(cliente);
            
        } else {
            colaNormal.add(cliente);
        }
        mostrarEstado();
    }
    
    // Atiende primero a los clientes prioritarios.
    public void atenderCliente() {
        if (!colaPrioritaria.isEmpty()) {
            Cliente atendido = colaPrioritaria.poll();
            System.out.println("\nAtendiendo a cliente prioritario: " + atendido.nombre);
        } else if (!colaNormal.isEmpty()) {
            Cliente atendido = colaNormal.poll();
            System.out.println("\nAtendiendo a cliente: " + atendido.nombre);
        } else {
            System.out.println("\nNo hay clientes en espera.");
        }
        mostrarEstado();
    }

    // Muestra la cantidad de clientes en espera.
    public void mostrarEstado() {
        int totalClientes = colaPrioritaria.size() + colaNormal.size();
        System.out.println("Clientes en espera: " + totalClientes  );
    }
}
