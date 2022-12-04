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

    public void recorrerListaOvinos(List<Ovino> listaOvino, int indice){
        if(indice == listaOvino.size()-1){
            System.out.println(listaOvino.get(indice));
        }else{
            System.out.println(listaOvino.get(indice));
            recorrerListaOvinos(listaOvino, indice + 1);
        }
    }

    public void recorrerListaBovinos(List<Bovino> listaBovino, int indice){
        if(indice == listaBovino.size()-1){
            System.out.println(listaBovino.get(indice));
        }else{
            System.out.println(listaBovino.get(indice));
            recorrerListaBovinos(listaBovino, indice + 1);
        }
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
