package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cultivo")
public class Cultivo {
    public Cultivo() {
        super();
    }

    public Cultivo(int id, int prof_semilla, int dist_semilla, int dist_plantas, int temp_germ_max, int temp_germ_min, int temp_cre_max, int temp_cre_min, String luz) {
        this.id = id;
        this.prof_semilla = prof_semilla;
        this.dist_semilla = dist_semilla;
        this.dist_plantas = dist_plantas;
        this.temp_germ_max = temp_germ_max;
        this.temp_germ_min = temp_germ_min;
        this.temp_cre_max = temp_cre_max;
        this.temp_cre_min = temp_cre_min;
        this.luz = luz;
    }

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    @Column(name = "prof_semilla", length = 30)
    private int prof_semilla;
    @Column(name = "dist_semilla")
    private int dist_semilla;
     @Column(name = "dist_plantas")
    private int dist_plantas;
    @Column(name = "temp_germ_max")
    int temp_germ_max;
    @Column(name = "temp_germ_min")
    int temp_germ_min;
    @Column(name = "temp_cre_max")
    int temp_cre_max;
    @Column(name = "temp_cre_min")
    int temp_cre_min;
    @Column(name = "luz", length = 20)
    private String luz;

    @Override
    public String toString() {
        return "Cultivo{" +
                "id=" + id +
                ", prof_semilla=" + prof_semilla +
                ", dist_semilla=" + dist_semilla +
                ", dist_plantas=" + dist_plantas +
                ", temp_germ_max=" + temp_germ_max +
                ", temp_germ_min=" + temp_germ_min +
                ", temp_cre_max=" + temp_cre_max +
                ", temp_cre_min=" + temp_cre_min +
                ", luz=" + luz +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProf_semilla() {
        return prof_semilla;
    }

    public void setProf_semilla(int prof_semilla) {
        this.prof_semilla = prof_semilla;
    }

    public int getDist_semilla() {
        return dist_semilla;
    }

    public void setDist_semilla(int dist_semilla) {
        this.dist_semilla = dist_semilla;
    }

    public int getDist_plantas() {
        return dist_plantas;
    }

    public void setDist_plantas(int dist_plantas) {
        this.dist_plantas = dist_plantas;
    }

    public int getTemp_germ_max() {
        return temp_germ_max;
    }

    public void setTemp_germ_max(int temp_germ_max) {
        this.temp_germ_max = temp_germ_max;
    }

    public int getTemp_germ_min() {
        return temp_germ_min;
    }

    public void setTemp_germ_min(int temp_germ_min) {
        this.temp_germ_min = temp_germ_min;
    }

    public int getTemp_cre_max() {
        return temp_cre_max;
    }

    public void setTemp_cre_max(int temp_cre_max) {
        this.temp_cre_max = temp_cre_max;
    }

    public int getTemp_cre_min() {
        return temp_cre_min;
    }

    public void setTemp_cre_min(int temp_cre_min) {
        this.temp_cre_min = temp_cre_min;
    }

    public String getLuz() {
        return luz;
    }

    public void setLuz(String luz) {
        this.luz = luz;
    }
}
