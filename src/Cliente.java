public class Cliente implements Comparable<Cliente> {
    public String nombre;
    public boolean esPrioritario;
    
    public Cliente(String nombre, boolean esPrioritario) {
        this.nombre = nombre;
        this.esPrioritario = esPrioritario;
    }
    
    
    @Override
        public int compareTo(Cliente otro) {
            return Boolean.compare(otro.esPrioritario, this.esPrioritario);
        }
}
