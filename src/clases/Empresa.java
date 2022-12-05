package clases;
import java.util.*;

public class Empresa {
    private String nombre;
    private String direccion;
    private List<Ovino> listaOvinos;
    private List<Bovino> listaBovinos;
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Ovino> getListaOvinos() {
        return listaOvinos;
    }

    public void setListaOvinos(List<Ovino> listaOvinos) {
        this.listaOvinos = listaOvinos;
    }

    public List<Bovino> getListaBovinos() {
        return listaBovinos;
    }

    public void setListaBovinos(List<Bovino> listaBovinos) {
        this.listaBovinos = listaBovinos;
    }

    public Empresa() { }

    public Empresa(String Nombre, String Direccion, List<Ovino> ListaOvinos, List<Bovino> ListaBovinos)
    {
        this.nombre = Nombre;
        this.direccion = Direccion;
        this.listaOvinos = ListaOvinos;
        this.listaBovinos = ListaBovinos;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "id="  +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
