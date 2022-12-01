import clases.*;
public class Sistema {
    public static void main(String[] args) {

        Arbol arbol = new Arbol();
        arbol.insertar(10);
        arbol.insertar(6);
        arbol.insertar(18);
        arbol.insertar(4);
        arbol.insertar(9);
        arbol.insertar(15);
        arbol.insertar(21);

        System.out.println("Recorriendo inorden:");
        arbol.imprimirIn();

        System.out.println(" ");

        System.out.println("Recorriendo postorden:");
        arbol.imprimirPost();

        System.out.println(" ");

        System.out.println("Recorriendo preorden:");
        arbol.imprimirPre();

        System.out.println(" ");
    }
}