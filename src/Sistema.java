import clases.*;
import controladora.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        byte opcion;

        do{
            System.out.println("");
            System.out.println("1- Ingresar empresa");
            System.out.println("2- Ingresar animales");
            System.out.println("3- Ingresar animales al árbol");
            System.out.println("4- Listar animal por id");
            System.out.println("5- Listar genealogía de animal por id");
            System.out.println("6- Listar animales por especie");
            System.out.println("0- Salir");
            opcion = scan.nextByte();
            switch(opcion){
                case 0:
                    break;
                case 1:
                    Controladora.altaEmpresa();
                    break;
                case 2:
                    Controladora.altaAnimal();
                    break;
                case 3:
                    Controladora.ingresarArbol();
                    break;
                case 4:
                    System.out.println("Ingrese id de animal");
                    Controladora.listarAnimalPorId(scan.nextByte());
                    break;
                case 5:
                    System.out.println("Ingrese id de animal");
                    Controladora.listarGenealogiaPorId(scan.nextByte());
                    break;
                case 6:
                    Controladora.listarAnimalesPorEspecie();
                    break;
                default:
                    System.out.println("Número no válido, ingrese otro");
            }
        }while(opcion > 0);

        System.out.println("");

        if(Controladora.listaBovinos.size() > 0) {
            Controladora.listarBovinos(Controladora.listaBovinos, 0);
            Controladora.arbolBovino.alturaTotal();
            Controladora.arbolBovino.imprimirIn();
            Controladora.arbolBovino.imprimirPost();
            Controladora.arbolBovino.imprimirPre();
        }

        if(Controladora.listaOvinos.size() > 0){
            Controladora.listarOvinos(Controladora.listaOvinos, 0);
            Controladora.arbolOvino.alturaTotal();
            Controladora.arbolOvino.imprimirIn();
            Controladora.arbolOvino.imprimirPost();
            Controladora.arbolOvino.imprimirPre();
        }
    }
}