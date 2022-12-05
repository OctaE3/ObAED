package controladora;

import clases.*;

import java.util.*;

public class Controladora {
    //#region Instancias y Listas
    static Usuario usuario = new Usuario();
    public static Empresa empresa;
    public static List<Bovino> listaBovinos = new ArrayList();
    public static List<Ovino> listaOvinos = new ArrayList();

    public static List<Animal> animales = new ArrayList<Animal>();
    static Scanner scan = new Scanner(System.in);
    public static Arbol arbolBovino = new Arbol();
    public static Arbol arbolOvino = new Arbol();

    //#endregion

    //#region Login

    public static void login() {
        System.out.println("Ingrese el usuario");
        String nombre = scan.next();
        System.out.println("Ingrese la contraseña");
        String pass = scan.next();

        while (!chequeoLogin(nombre, pass)) {
            System.out.println("Usuario o Contraseña incorrectos, pruebe de nuevo");
            System.out.println("Usuario:");
            nombre = scan.next();
            System.out.println("Contraseña:");
            pass = scan.next();
        }
    }

    public static Boolean chequeoLogin(String nombre, String pass) {
        if (nombre.equals(usuario.getNombre()) && pass.equals(usuario.getContrasenia()))
            return true;
        else
            return false;
    }

    //#endregion

    //#region Empresa

    public static void altaEmpresa() {
        System.out.println("Ingrese los siguientes datos.");
        System.out.println("Ingrese el nombre");
        String nombre = scan.nextLine();
        System.out.println("Ingrese la dirección");
        String direccion = scan.nextLine();

        empresa = new Empresa(nombre, direccion, listaOvinos, listaBovinos);
    }

    //#endregion

    //#region Animal

    public static void altaAnimal() {   //Agregar Animal
        System.out.println("Agregar Animal.");
        System.out.println("Ingrese 1 para agregar un Ovino");
        System.out.println("Ingrese 2 para agregar un Bovino");
        int elec = scan.nextInt();
        if (elec == 1) {
            while (listaOvinos.size() < 7) {
                System.out.println("Ingrese los datos del Ovino");
                System.out.println("Ingrese el id del Ovino");
                int id = scan.nextInt();
                while (buscarOvino(id) != null || buscarBovino(id) != null){
                    System.out.println("El id ya existe, ingrese otro");
                    id = scan.nextInt();
                }
                System.out.println("Ingrese el sexo");
                String sexo = scan.next();
                System.out.println("El Ovino esta desparasitado?");
                System.out.println("Ingrese 1 si está desparasitado");
                System.out.println("Ingrese 2 si no está desparasitado");
                int desp = scan.nextInt();
                String desparasitado = "No";
                if (desp == 1) {
                    System.out.println("Ingrese la fecha de desparasitación (Formate: dd/mm/yyyy)");
                    String despa = scan.next();
                    desparasitado = "Si - Fecha: " + despa;
                }
                System.out.println("El Ovino esta vacunado?");
                System.out.println("Ingrese 1 si esta vacunado");
                System.out.println("Ingrese 2 si no esta vacunado");
                int vac = scan.nextInt();
                String vacunado = "No";
                if (vac == 1) {
                    System.out.println("Ingrese la fecha de la vacunación (Formate: dd/mm/yyyy)");
                    String vacuna = scan.next();
                    vacunado = "Si - Fecha : " + vacuna;
                }
                String tipo = "Ovino";
                Ovino ovino = new Ovino(id, 0, sexo, desparasitado, vacunado, tipo, null, null, null);
                listaOvinos.add(ovino);
                animales.add(ovino);
            }
            if(listaOvinos.size() == 7){
                System.out.println("Ya están agregados todos los ovinos!");
            }
        } else if(elec == 2) {
            while (listaBovinos.size() < 7) {
                System.out.println("Ingrese los datos del Bovino");
                System.out.println("Ingrese el id del Ovino");
                int id = scan.nextInt();
                while (buscarBovino(id) != null || buscarOvino(id) != null){
                    System.out.println("El id ya existe, ingrese otro");
                    id = scan.nextInt();
                }
                System.out.println("Ingrese el sexo");
                String sexo = scan.next();
                System.out.println("El Bovino esta desparasitado?");
                System.out.println("Ingrese 1 si está desparasitado");
                System.out.println("Ingrese 2 si no está desparasitado");
                int desp = scan.nextInt();
                String desparasitado = "No";
                if (desp == 1) {
                    System.out.println("Ingrese la fecha de desparasitación (Formato: dd/mm/yyyy)");
                    String despa = scan.next();
                    desparasitado = "Si - Fecha: " + despa;
                }
                System.out.println("El Bovino está vacunado?");
                System.out.println("Ingrese 1 si está vacunado");
                System.out.println("Ingrese 2 si no está vacunado");
                int vac = scan.nextInt();
                String vacunado = "No";
                if (vac == 1) {
                    System.out.println("Ingrese la fecha de vacunación (Formato: dd/mm/yyyy)");
                    String vacuna = scan.next();
                    vacunado = "Si - Fecha : " + vacuna;
                }
                String tipo = "Bovino";
                Bovino bovino = new Bovino(id, 0, sexo, desparasitado, vacunado, tipo, null, null, null);
                listaBovinos.add(bovino);
                animales.add(bovino);
            }
            if(listaBovinos.size() == 7){
                System.out.println("Ya están agregados todos los bovinos!");
            }
        }
        else{
            System.out.println("Esa opción no existe.");
        }
    }

    public static void ingresarArbol() {
        System.out.println("Agregar Animal.");
        System.out.println("Ingrese 1 para agregar árbol de ovinos");
        System.out.println("Ingrese 2 para agregar árbol de bovinos");
        int elec = scan.nextInt();
        if (elec == 1) {
            System.out.println("Ingrese el id del primer animal ");
            Ovino ovino1 = buscarOvino(scan.nextInt());
            ovino1.setIdArbol(1000);
            arbolOvino.insertar(ovino1.getIdArbol());

            System.out.println("Ingrese el id del padre del animal " + ovino1.getId());
            Ovino ovino2 = buscarOvino(scan.nextInt());
            ovino1.setId_Padre(ovino2.getId());
            ovino2.setId_Hijo(ovino1.getId());
            ovino2.setIdArbol(idArbolPadreOvino(ovino1.getId()));
            arbolOvino.insertar(ovino2.getIdArbol());

            System.out.println("Ingrese el id de la madre del animal " + ovino1.getId());
            Ovino ovino3 = buscarOvino(scan.nextInt());
            ovino1.setId_Madre(ovino3.getId());
            ovino3.setId_Hijo(ovino1.getId());
            ovino3.setIdArbol(idArbolMadreOvino(ovino1.getId()));
            arbolOvino.insertar(ovino3.getIdArbol());

            System.out.println("Ingrese el id del padre del animal " + ovino2.getId());
            Ovino ovino4 = buscarOvino(scan.nextInt());
            ovino2.setId_Padre(ovino4.getId());
            ovino4.setId_Hijo(ovino2.getId());
            ovino4.setIdArbol(idArbolPadreOvino(ovino2.getId()));
            arbolOvino.insertar(ovino4.getIdArbol());

            System.out.println("Ingrese el id de la madre del animal " + ovino2.getId());
            Ovino ovino5 = buscarOvino(scan.nextInt());
            ovino2.setId_Madre(ovino5.getId());
            ovino5.setId_Hijo(ovino2.getId());
            ovino5.setIdArbol(idArbolMadreOvino(ovino2.getId()));
            arbolOvino.insertar(ovino5.getIdArbol());

            System.out.println("Ingrese el id del padre del animal " + ovino3.getId());
            Ovino ovino6 = buscarOvino(scan.nextInt());
            ovino3.setId_Padre(ovino6.getId());
            ovino6.setId_Hijo(ovino3.getId());
            ovino6.setIdArbol(idArbolPadreOvino(ovino3.getId()));
            arbolOvino.insertar(ovino6.getIdArbol());

            System.out.println("Ingrese el id de la madre del animal " + ovino3.getId());
            Ovino ovino7 = buscarOvino(scan.nextInt());
            ovino3.setId_Madre(ovino7.getId());
            ovino7.setId_Hijo(ovino3.getId());
            ovino7.setIdArbol(idArbolMadreOvino(ovino3.getId()));
            arbolOvino.insertar(ovino7.getIdArbol());
        } else if (elec == 2) {
            System.out.println("Ingrese el id del primer animal ");
            Bovino bovino1 = buscarBovino(scan.nextInt());
            bovino1.setIdArbol(1000);
            arbolBovino.insertar(bovino1.getIdArbol());

            System.out.println("Ingrese el id del padre del animal " + bovino1.getId());
            Bovino bovino2 = buscarBovino(scan.nextInt());
            bovino1.setId_Padre(bovino2.getId());
            bovino2.setId_Hijo(bovino1.getId());
            bovino2.setIdArbol(idArbolPadreBovino(bovino1.getId()));
            arbolBovino.insertar(bovino2.getIdArbol());

            System.out.println("Ingrese el id de la madre del animal " + bovino1.getId());
            Bovino bovino3 = buscarBovino(scan.nextInt());
            bovino1.setId_Madre(bovino3.getId());
            bovino3.setId_Hijo(bovino1.getId());
            bovino3.setIdArbol(idArbolMadreBovino(bovino1.getId()));
            arbolBovino.insertar(bovino3.getIdArbol());

            System.out.println("Ingrese el id del padre del animal " + bovino2.getId());
            Bovino bovino4 = buscarBovino(scan.nextInt());
            bovino2.setId_Padre(bovino4.getId());
            bovino4.setId_Hijo(bovino2.getId());
            bovino4.setIdArbol(idArbolPadreBovino(bovino2.getId()));
            arbolBovino.insertar(bovino4.getIdArbol());

            System.out.println("Ingrese el id de la madre del animal " + bovino2.getId());
            Bovino bovino5 = buscarBovino(scan.nextInt());
            bovino2.setId_Madre(bovino5.getId());
            bovino5.setId_Hijo(bovino2.getId());
            bovino5.setIdArbol(idArbolMadreBovino(bovino2.getId()));
            arbolBovino.insertar(bovino5.getIdArbol());

            System.out.println("Ingrese el id del padre del animal " + bovino3.getId());
            Bovino bovino6 = buscarBovino(scan.nextInt());
            bovino3.setId_Padre(bovino6.getId());
            bovino6.setId_Hijo(bovino3.getId());
            bovino6.setIdArbol(idArbolPadreBovino(bovino3.getId()));
            arbolBovino.insertar(bovino6.getIdArbol());

            System.out.println("Ingrese el id de la madre del animal " + bovino3.getId());
            Bovino bovino7 = buscarBovino(scan.nextInt());
            bovino3.setId_Madre(bovino7.getId());
            bovino7.setId_Hijo(bovino3.getId());
            bovino7.setIdArbol(idArbolMadreBovino(bovino3.getId()));
            arbolBovino.insertar(bovino7.getIdArbol());
        }
        else{
            System.out.println("Esa opción no existe.");
        }
    }

    public static boolean chequeoPadreMadre(Integer padre, Integer madre, Integer hijo, String tipo) { //Chequeo ascendencia
        if (tipo.equals("Ovino")) {
            for (Ovino ovino : listaOvinos) {
                if (ovino.getId_Padre().equals(padre) || ovino.getId_Madre().equals(madre)) {
                    return false;
                }
            }
            if (padre.equals(hijo) || madre.equals(hijo)) {
                return false;
            }
            return true;
        } else {
            for (Bovino bovino : listaBovinos) {
                if (bovino.getId_Padre().equals(padre) || bovino.getId_Madre().equals(madre)) {
                    return false;
                }
            }
            if (hijo.equals(padre) || hijo.equals(madre)) {
                return false;
            }
            return true;
        }
    }

    //#endregion

    //#region Bovino

    public static Bovino buscarBovino(int id) { //Buscar Bovinos
        for (Bovino bovino : listaBovinos) {
            if (bovino.getId() == id) {
                return bovino;
            }
        }
        return null;
    }

    public static int idArbolPadreBovino(int idHijo) {
        int altura = arbolBovino.alturaTotal();
        Bovino hijo = buscarBovino(idHijo);

        switch (altura) {
            case 0:
                return hijo.getIdArbol() - 300;
            case 1:
                return hijo.getIdArbol() - 100;
        }
        return 0;
    }

    public static int idArbolMadreBovino(int idHijo) {
        int altura = arbolBovino.alturaTotal();
        Bovino hijo = buscarBovino(idHijo);

        switch (altura) {
            case 0:
                return hijo.getIdArbol() + 300;
            case 1:
                return hijo.getIdArbol() + 100;
        }
        return 0;
    }
    public static void listarBovinos(List<Bovino> lista, int indice) {
        if (lista.size() > 0) {
            if (indice == lista.size() - 1) {
                System.out.println(lista.get(indice));
            } else {
                System.out.println(lista.get(indice));
                listarBovinos(lista, indice + 1);
            }
        }else{
            System.out.println("Lista de bovinos vacía");
        }
    }
    //#endregion

    //#region Ovino
    public static Ovino buscarOvino(int id) { //Buscar Ovinos
        for (Ovino ovino : listaOvinos) {
            if (ovino.getId() == id) {
                return ovino;
            }
        }
        return null;
    }

    public static int idArbolPadreOvino(int idHijo) {
        int altura = arbolOvino.alturaTotal();
        Ovino hijo = buscarOvino(idHijo);

        switch (altura) {
            case 0:
                return hijo.getIdArbol() - 300;
            case 1:
                return hijo.getIdArbol() - 100;
        }
        return 0;
    }

    public static int idArbolMadreOvino(int idHijo) {
        int altura = arbolOvino.alturaTotal();
        Ovino hijo = buscarOvino(idHijo);

        switch (altura) {
            case 0:
                return hijo.getIdArbol() + 300;
            case 1:
                return hijo.getIdArbol() + 100;
        }
        return 0;
    }

    public static void listarOvinos(List<Ovino> lista, int indice) {
        if (lista.size() > 0) {
            if (indice == lista.size() - 1) {
                System.out.println(lista.get(indice));
            } else {
                System.out.println(lista.get(indice));
                listarOvinos(lista, indice + 1);
            }
        } else {
            System.out.println("Lista de ovinos vacía");
        }
    }

    //#endregion

    //#region Consultas
    public static void listarAnimalesPorEspecie() {
        System.out.println("Ovinos de la empresa: ");
        listarOvinos(listaOvinos, 0);
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Bovinos de la empresa: ");
        listarBovinos(listaBovinos, 0);
    }
    public static Animal listarAnimalPorId(List<Animal> animales, int inicio, int fin, int idAnimal) {
        if(animales.size() > 0) {
            Collections.sort(animales, Comparator.comparingInt(Animal::getId));
        }else{
            System.out.println("No hay animales");
        }

        if(inicio == fin){
            if(animales.get(inicio).getId() == idAnimal){
                return animales.get(inicio);
            }
            return null;
        }else{
            int mitad = (inicio + fin) / 2;
            Animal mitadIzq = listarAnimalPorId(animales, inicio, mitad, idAnimal);

            if(mitadIzq != null){
                return mitadIzq;
            }else{
                return listarAnimalPorId(animales, mitad+1, fin, idAnimal);
            }
        }
    }

    public static void listarGenealogiaPorId(int idAnimal) {
        Bovino bovino = buscarBovino(idAnimal);
        Bovino padreB, madreB, hijoB;
        Ovino padreO, madreO, hijoO;
        Ovino ovino = buscarOvino(idAnimal);

        if (bovino != null) {
            if (bovino.getId_Hijo() == null) {
                padreB = buscarBovino(bovino.getId_Padre());
                madreB = buscarBovino(bovino.getId_Madre());
                System.out.println("Padre: " + bovino.getId_Padre() + " Madre " + bovino.getId_Madre());
                System.out.println("Abuelo paterno: " + padreB.getId_Padre() + " Abuela paterna: " + padreB.getId_Madre());
                System.out.println("Abuelo materno: " + madreB.getId_Padre() + " Abuela materna: " + madreB.getId_Madre());
            }

            if (bovino.getId_Hijo() != null && bovino.getId_Padre() != null && bovino.getId_Madre() != null) {
                System.out.println("Hijo: " + bovino.getId_Hijo());
                System.out.println("Padre: " + bovino.getId_Padre() + " Madre: " + bovino.getId_Madre());
            }

            if (bovino.getId_Hijo() != null && bovino.getId_Padre() == null && bovino.getId_Madre() == null) {
                hijoB = buscarBovino(bovino.getId_Hijo());
                System.out.println("Hijo: " + bovino.getId_Hijo());
                System.out.println("Nieto: " + hijoB.getId_Hijo());
            }
        }else if (ovino != null) {
            if (ovino.getId_Hijo() == null) {
                padreO = buscarOvino(ovino.getId_Padre());
                madreO = buscarOvino(ovino.getId_Madre());
                System.out.println("Padre: " + ovino.getId_Padre() + " Madre " + ovino.getId_Madre());
                System.out.println("Abuelo paterno: " + padreO.getId_Padre() + " Abuela paterna: " + padreO.getId_Madre());
                System.out.println("Abuelo materno: " + madreO.getId_Padre() + " Abuela materna: " + madreO.getId_Madre());
            }

            if (ovino.getId_Hijo() != null && ovino.getId_Padre() != null && ovino.getId_Madre() != null) {
                System.out.println("Hijo: " + ovino.getId_Hijo());
                System.out.println("Padre: " + ovino.getId_Padre() + " Madre: " + ovino.getId_Madre());
            }

            if (ovino.getId_Hijo() != null && ovino.getId_Padre() == null && ovino.getId_Madre() == null) {
                hijoO = buscarOvino(ovino.getId_Hijo());
                System.out.println("Hijo: " + ovino.getId_Hijo());
                System.out.println("Nieto: " + hijoO.getId_Hijo());
            }
        }
    }

//#endregion
}
