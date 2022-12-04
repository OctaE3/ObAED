package controladora;

import clases.*;

import java.util.*;

public class Controladora {
    static Usuario usuario = new Usuario();
    static Empresa empresa;
    static List<Bovino> listaBovinos = new ArrayList();
    static List<Ovino> listaOvinos = new ArrayList();
    static Scanner scan = new Scanner(System.in);
    static Arbol arbol = new Arbol();

    public static Bovino buscarBovino(int id) {
        for (Bovino bovino : listaBovinos) {
            if (bovino.getId() == id) {
                return bovino;
            }
        }
        return null;
    }

    public static void altaEmpresa() {
        System.out.println("Ingrese los siguientes datos.");
        System.out.println("Ingrese el nombre");
        String nombre = scan.next();
        System.out.println("Ingrese la dirección");
        String direccion = scan.nextLine();

        empresa = new Empresa(nombre, direccion, listaOvinos, listaBovinos);
    }

    public static Boolean chequeoLogin(String nombre, String pass) {
        if (nombre.equals(usuario.getNombre()) && pass.equals(usuario.getContrasenia()))
            return true;
        else
            return false;
    }

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

    public static void altaAnimal() {
        System.out.println("Agregar Animal.");
        System.out.println("Ingrese 1 para agregar un Ovino");
        System.out.println("Ingrese 2 para agregar un Bovino");
        int elec = scan.nextInt();
        if (elec == 1) {
            System.out.println("Ingrese los datos del Ovino");
            System.out.println("Ingrese el id del Ovino");
            int id = scan.nextInt();
            System.out.println("Ingrese el sexo");
            String sexo = scan.next();
            System.out.println("El Ovino esta desparasitado?");
            System.out.println("Ingrese 1 si está desparasitado");
            System.out.println("Ingrese 2 si no está desparasitado");
            int desp = scan.nextInt();
            String desparasitado = "No";
            if (desp == 1) {
                System.out.println("Ingrese la fecha de desparasitación (Formate: dd/mm/yyyy)");
                String despa = scan.nextLine();
                desparasitado = "Si - Fecha: " + despa;
            }
            System.out.println("El Ovino esta vacunado?");
            System.out.println("Ingrese 1 si esta vacunado");
            System.out.println("Ingrese 2 si no esta vacunado");
            int vac = scan.nextInt();
            String vacunado = "No";
            if (vac == 1) {
                System.out.println("Ingrese la fecha de la vacunación (Formate: dd/mm/yyyy)");
                String vacuna = scan.nextLine();
                vacunado = "Si - Fecha : " + vacuna;
            }
            String tipo = "Ovino";
            int padre = 0;
            int madre = 0;
            Ovino ovino = new Ovino(id, 0, sexo, desparasitado, vacunado, tipo, padre, madre);
            listaOvinos.add(ovino);
        } else {
            System.out.println("Ingrese los datos del Bovino");
            System.out.println("Ingrese el id del Ovino");
            int id = scan.nextInt();
            System.out.println("Ingrese el sexo");
            String sexo = scan.next();
            System.out.println("El Bovino esta desparasitado?");
            System.out.println("Ingrese 1 si esta desparasitado");
            System.out.println("Ingrese 2 si no esta desparasitado");
            int desp = scan.nextInt();
            String desparasitado = "No";
            if (desp == 1) {
                System.out.println("Ingrese la fecha de desparasitación (Formate: dd/mm/yyyy)");
                String despa = scan.nextLine();
                desparasitado = "Si - Fecha: " + despa;
            }
            System.out.println("El Bovino esta vacunado?");
            System.out.println("Ingrese 1 si esta vacunado");
            System.out.println("Ingrese 2 si no esta vacunado");
            int vac = scan.nextInt();
            String vacunado = "No";
            if (vac == 1) {
                System.out.println("Ingrese la fecha de vacunación (Formate: dd/mm/yyyy)");
                String vacuna = scan.nextLine();
                vacunado = "Si - Fecha : " + vacuna;
            }
            String tipo = "Bovino";
            int padre = 0;
            int madre = 0;
            Bovino bovino = new Bovino(id, 0, sexo, desparasitado, vacunado, tipo, padre, madre);
            listaBovinos.add(bovino);
        }
    }

    public static boolean chequeoPadreMadre(Integer padre, Integer madre, Integer hijo, String tipo) {
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

    public static void asignarPadreMadreOvino(Ovino ovino) {
        System.out.println("Asignar Madre y Padre al ovino: " + ovino.getId());
        System.out.println("Ingrese el id del Padre");
        Integer padre = scan.nextInt();
        System.out.println("Ingrese el id del Madre");
        Integer madre = scan.nextInt();
        String tipo = "Ovino";
        if (!chequeoPadreMadre(padre, madre, ovino.getId(), tipo)) {
            while (!chequeoPadreMadre(padre, madre, ovino.getId(), tipo)) {
                System.out.println("Error al ingresar el padre o la madre, intente de nuevo");
                System.out.println("Ingrese el id del Padre");
                padre = scan.nextInt();
                System.out.println("Ingrese el id del Madre");
                madre = scan.nextInt();
            }
        }
        ovino.setId_Padre(padre);
        ovino.setId_Madre(madre);
        empresa.setListaOvinos(listaOvinos);
        System.out.println("Padre y Madre agregador con éxito");
    }

    public static void asignarPadreMadreBovino(Bovino bovino) {
        System.out.println("Asignar Madre y Padre al bovino: " + bovino.getId());
        System.out.println("Ingrese el id del Padre");
        Integer padre = scan.nextInt();
        System.out.println("Ingrese el id del Madre");
        Integer madre = scan.nextInt();
        String tipo = "Bovino";
        if (!chequeoPadreMadre(padre, madre, bovino.getId(), tipo)) {
            while (!chequeoPadreMadre(padre, madre, bovino.getId(), tipo)) {
                System.out.println("Error al ingresar el padre o la madre, intente de nuevo");
                System.out.println("Ingrese el id del Padre");
                padre = scan.nextInt();
                System.out.println("Ingrese el id del Madre");
                madre = scan.nextInt();
            }
        }
        bovino.setId_Padre(padre);
        bovino.setId_Madre(madre);
        empresa.setListaBovinos(listaBovinos);
        System.out.println("Padre y Madre agregados con éxito");
    }

    public static int idArbolPadre(int idHijo) {
        int altura = arbol.alturaTotal();
        int idPadre = 0;
        Bovino hijo = buscarBovino(idHijo);

        switch (altura) {
            case 0:
                return hijo.getIdArbol() - 300;
            case 1:
                return hijo.getIdArbol() - 100;
            case 2:
                return hijo.getIdArbol() - 50;
            case 3:
                return hijo.getIdArbol() - 10;
        }
        return 0;
    }

    public static void listarAnimalesPorEspecie(Empresa empresa) {
        System.out.println("Ovinos de la empresa: " + empresa.getNombre());
        for (Ovino ovino : empresa.getListaOvinos()) {
            ovino.toString();
        }
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Bovinos de la empresa: " + empresa.getNombre());
        for (Bovino bovino : empresa.getListaBovinos()) {
            bovino.toString();
        }
    }
}
