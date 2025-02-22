public class App {
    public static void main(String[] args) throws Exception {
Banco banco = new Banco();

        banco.agregarCliente("Juana Asicona", false);
        banco.agregarCliente("María de los Angeles", true);
        banco.agregarCliente("Carlos Vasquez", false);
        banco.agregarCliente("Ana Yolanda", true);
        System.out.println("\n");
        
        banco.atenderCliente();
        banco.atenderCliente();
        banco.atenderCliente();
        banco.atenderCliente();
        banco.atenderCliente();
    }
}
