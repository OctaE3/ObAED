import clases.*;
import controladora.*;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
    public static List<Ovino> listaOvinos = new ArrayList<Ovino>();
    public static List<Bovino> listaBovinos = new ArrayList<Bovino>();

    static Arbol arbol = new Arbol();
    public static void main(String[] args) {
        Empresa empresa = new Empresa();

        Bovino bovino1 = new Bovino(1, null, "Masculino", "Si", "Si", "Bovino", null, null);
        Bovino bovino2 = new Bovino(2, null, "Femenino", "No", "No", "Bovino", null, null);
        Bovino bovino3 = new Bovino(3, null, "Femenino", "Si", "No", "Bovino", null, null);
        Bovino bovino4 = new Bovino(4, null, "Femenino", "Si", "No", "Bovino", null, null);
        Bovino bovino5 = new Bovino(5, null, "Femenino", "Si", "No", "Bovino", null, null);
        Bovino bovino6 = new Bovino(6, null, "Femenino", "Si", "No", "Bovino", null, null);
        Bovino bovino7 = new Bovino(7, null, "Femenino", "Si", "No", "Bovino", null, null);
        Bovino bovino8 = new Bovino(8, null, "Femenino", "Si", "No", "Bovino", null, null);
        Bovino bovino9 = new Bovino(9, null, "Femenino", "Si", "No", "Bovino", null, null);
        Bovino bovino10 = new Bovino(10, null, "Femenino", "Si", "No", "Bovino", null, null);
        Bovino bovino11 = new Bovino(11, null, "Femenino", "Si", "No", "Bovino", null, null);
        Bovino bovino12 = new Bovino(12, null, "Femenino", "Si", "No", "Bovino", null, null);
        Bovino bovino13 = new Bovino(13, null, "Femenino", "Si", "No", "Bovino", null, null);
        Bovino bovino14 = new Bovino(14, null, "Femenino", "Si", "No", "Bovino", null, null);
        Bovino bovino15 = new Bovino(15, null, "Femenino", "Si", "No", "Bovino", null, null);

        listaBovinos.add(bovino1);
        listaBovinos.add(bovino2);
        listaBovinos.add(bovino3);
        listaBovinos.add(bovino4);
        listaBovinos.add(bovino5);
        listaBovinos.add(bovino6);
        listaBovinos.add(bovino7);
        listaBovinos.add(bovino8);
        listaBovinos.add(bovino9);
        listaBovinos.add(bovino10);
        listaBovinos.add(bovino11);
        listaBovinos.add(bovino12);
        listaBovinos.add(bovino13);
        listaBovinos.add(bovino14);
        listaBovinos.add(bovino15);
        empresa.setListaBovinos(listaBovinos);

        bovino2.setIdArbol(1000);
        arbol.insertar(bovino2.getIdArbol());

        bovino1.setIdArbol(idArbolPadre(2)); // 700
        arbol.insertar(bovino1.getIdArbol());
        bovino3.setIdArbol(idArbolMadre(2)); // 1300
        arbol.insertar(bovino3.getIdArbol());

        bovino4.setIdArbol(idArbolPadre(1)); // 600
        arbol.insertar(bovino4.getIdArbol());
        bovino5.setIdArbol(idArbolMadre(1)); // 800
        arbol.insertar(bovino5.getIdArbol());

        bovino6.setIdArbol(idArbolPadre(3)); // 1200
        arbol.insertar(bovino6.getIdArbol());
        bovino7.setIdArbol(idArbolMadre(3)); // 1400
        arbol.insertar(bovino7.getIdArbol());

        bovino8.setIdArbol(idArbolPadre((4))); // 550
        arbol.insertar(bovino8.getIdArbol());
        bovino9.setIdArbol(idArbolMadre(4)); // 650
        arbol.insertar(bovino9.getIdArbol());


        System.out.println(arbol.alturaTotal());

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

    public static Bovino buscarBovino(int id) {
        for (Bovino bovino : listaBovinos) {
            if (bovino.getId() == id) {
                return bovino;
            }
        }
        return null;
    }
    public static int idArbolPadre(int idHijo) {
        int altura = arbol.alturaTotal();
        if(altura >= 3){
            altura = altura - 1;
        }
        Bovino hijo = buscarBovino(idHijo);

        switch (altura) {
            case 1:
                return hijo.getIdArbol() - 300;
            case 2:
                return hijo.getIdArbol() - 100;
            case 3:
                return hijo.getIdArbol() - 50;
            case 4:
                return hijo.getIdArbol() - 10;
        }
        return 0;
    }

    public static int idArbolMadre(int idHijo) {
        int altura = arbol.alturaTotal() - 1;
        Bovino hijo = buscarBovino(idHijo);

        switch (altura) {
            case 1:
                return hijo.getIdArbol() + 300;
            case 2:
                return hijo.getIdArbol() + 100;
            case 3:
                return hijo.getIdArbol() + 50;
            case 4:
                return hijo.getIdArbol() + 10;
        }
        return 0;
    }
}