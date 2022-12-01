package clases;

public class Animal {
    private Integer id;
    private String sexo;
    private String desparasitado;
    private String vacunado;
    private String tipo;
    private Integer id_Padre;
    private Integer id_Madre;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDesparasitado() {
        return desparasitado;
    }

    public void Desparasitado(String desparasitado) {
        this.desparasitado = desparasitado;
    }

    public String getVacunado() {
        return vacunado;
    }

    public void setVacunado(String vacunado) {
        this.vacunado = vacunado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getId_Padre() {
        return id_Padre;
    }

    public void setId_Padre(Integer id_Padre) {
        this.id_Padre = id_Padre;
    }

    public Integer getId_Madre() {
        return id_Madre;
    }

    public void setId_Madre(Integer id_Madre) {
        this.id_Madre = id_Madre;
    }

    @Override
    public String toString() {
        return "Id: " + id + ", Sexo: " + sexo + ", Desparasitado: " + desparasitado + ", Vacunado: " + vacunado + ", Tipo: " + tipo + ", Id Padre: " + id_Padre + ", Id Madre: " + id_Madre;
    }

    public Animal() { }

    public Animal(int id, String sexo, String desparasitado, String vacunado, String tipo, Integer id_Padre, Integer id_Madre) {
        this.id = id;
        this.sexo = sexo;
        this.desparasitado = desparasitado;
        this.vacunado = vacunado;
        this.tipo = tipo;
        this.id_Padre = id_Padre;
        this.id_Madre = id_Madre;
    }
}