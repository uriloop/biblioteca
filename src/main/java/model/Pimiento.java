package model;


import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "pimiento")
public class Pimiento implements Serializable {


    public Pimiento() {
    }

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "nombre", length = 200)
    private String nombre;

    @Column(name = "descripcion",length = 5000)
    private String descripcion;

    @Column(name = "familia", length = 1000)
    private String familia;


    @Column(name = "origen", length = 90)
    private  String origen;

      @Column(name = "img", length = 200)
      private String img;

    public Pimiento(int id, String nombre, String descripcion, String familia, String origen, String img) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.familia = familia;
        this.origen = origen;
        this.img = img;
    }

    public Pimiento(String s) {
        this.id=Integer.parseInt(s);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Pimiento{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", familia='" + familia + '\'' +
                ", origen='" + origen + '\'' +
                ", img='" + img + '\'' +
                '}';
    }

}
