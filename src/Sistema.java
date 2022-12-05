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
                    if(Controladora.empresa == null)
                        Controladora.altaEmpresa();
                    else
                        System.out.println("La empresa ya esta ingresada");
                    break;
                case 2:
                    if(Controladora.listaOvinos.size() == 7 && Controladora.listaBovinos.size() == 7)
                        System.out.println("Ya están agregados todos los ovinos y bovinos!");
                    else
                        Controladora.altaAnimal();
                    break;
                case 3:
                    Controladora.ingresarArbol();
                    break;
                case 4:
                    System.out.println("Ingrese id de animal");
                    int id = scan.nextInt();
                    if(Controladora.buscarBovino(id) == null && Controladora.buscarOvino(id) == null)
                        System.out.println("Ese animal no existe.");
                    else
                        Controladora.listarAnimalPorId(id);
                    break;
                case 5:
                    System.out.println("Ingrese id de animal");
                    int idA = scan.nextInt();
                    if(Controladora.buscarBovino(idA) == null && Controladora.buscarOvino(idA) == null)
                        System.out.println("Ese animal no existe.");
                    else
                        Controladora.listarGenealogiaPorId(idA);
                    break;
                case 6:
                    if(Controladora.listaBovinos.size() > 0 && Controladora.listaOvinos.size() > 0)
                        Controladora.listarAnimalesPorEspecie();
                    else
                        System.out.println("La lista de animales esta vacía.");
                    break;
                default:
                    System.out.println("Opción no válida, ingrese otra");
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