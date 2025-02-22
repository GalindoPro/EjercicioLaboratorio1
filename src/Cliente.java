public class Cliente implements Comparable<Cliente> {
    public String nombre;
    public boolean esPrioritario;
    
    public Cliente(String nombre, boolean esPrioritario) {
        this.nombre = nombre;
        this.esPrioritario = esPrioritario;
    }
    
    
    @Override
    public int compareTo(Cliente otroCliente) {
        if (this.esPrioritario && !otroCliente.esPrioritario) {
            return -1; // Clientes prioritarios van primero
        } else if (!this.esPrioritario && otroCliente.esPrioritario) {
            return 1; // Clientes no prioritarios van después
        } else {
            return 0; // Si ambos son prioritarios o no, misma prioridad
        }
    }
    
}
