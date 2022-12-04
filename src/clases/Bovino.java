package clases;

public class Bovino extends Animal{

    public Bovino() { }

    public Bovino(int id, Integer idArbol, String sexo, String desparasitado, String vacunado, String tipo, Integer id_Padre, Integer id_Madre)
    {
        super(id, idArbol, sexo, desparasitado, vacunado, tipo, id_Padre, id_Madre);
    }
}
