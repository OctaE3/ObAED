package clases;

public class Bovino extends Animal{

    public Bovino() { }

    public Bovino(int id, String sexo, String desparasitado, String vacunado, String tipo, Integer id_Padre, Integer id_Madre)
    {
        super(id, sexo, desparasitado, vacunado, tipo, id_Padre, id_Madre);
    }
}
