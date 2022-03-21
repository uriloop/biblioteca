package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "caracteristicas")
public class Caracteristicas implements Serializable {

 public Caracteristicas() {
  super();
 }

 public Caracteristicas(int id, int altura_max, int altura_min, int ancho_max, int ancho_min, int scoville_max, int scoville_min, int dies_cult_max, int dies_cult_min, String rendimiento) {
  this.id = id;
  this.altura_max = altura_max;
  this.altura_min = altura_min;
  this.ancho_max = ancho_max;
  this.ancho_min = ancho_min;
  this.scoville_max = scoville_max;
  this.scoville_min = scoville_min;
  this.dies_cult_max = dies_cult_max;
  this.dies_cult_min = dies_cult_min;
  this.rendimiento = rendimiento;
 }

 @Id
    @Column(name = "id", unique = true, nullable = false)
   private int id;

    @Column(name = "altura_max")
    int altura_max;
    @Column(name = "altura_min")
    int altura_min;
    @Column(name = "ancho_max")
    int ancho_max;
    @Column(name = "ancho_min")
    int ancho_min;
    @Column(name = "scoville_max")
    int scoville_max;
    @Column(name = "scoville_min")
    int scoville_min;
    @Column(name = "dies_cult_max")
    int dies_cult_max;
    @Column(name = "dies_cult_min")
    int dies_cult_min;


     @Column(name = "rendimiento",length = 100)
    String rendimiento;


 @Override
 public String toString() {
  return "Caracteristicas{" +
          "id=" + id +
          ", altura_max=" + altura_max +
          ", altura_min=" + altura_min +
          ", ancho_max=" + ancho_max +
          ", ancho_min=" + ancho_min +
          ", scoville_max=" + scoville_max +
          ", scoville_min=" + scoville_min +
          ", dies_cult_max=" + dies_cult_max +
          ", dies_cult_min=" + dies_cult_min +
          ", rendimiento=" + rendimiento +
          '}';
 }

 public int getId() {
  return id;
 }

 public void setId(int id) {
  this.id = id;
 }

 public int getAltura_max() {
  return altura_max;
 }

 public void setAltura_max(int altura_max) {
  this.altura_max = altura_max;
 }

 public int getAltura_min() {
  return altura_min;
 }

 public void setAltura_min(int altura_min) {
  this.altura_min = altura_min;
 }

 public int getAncho_max() {
  return ancho_max;
 }

 public void setAncho_max(int ancho_max) {
  this.ancho_max = ancho_max;
 }

 public int getAncho_min() {
  return ancho_min;
 }

 public void setAncho_min(int ancho_min) {
  this.ancho_min = ancho_min;
 }

 public int getScoville_max() {
  return scoville_max;
 }

 public void setScoville_max(int scoville_max) {
  this.scoville_max = scoville_max;
 }

 public int getScoville_min() {
  return scoville_min;
 }

 public void setScoville_min(int scoville_min) {
  this.scoville_min = scoville_min;
 }

 public int getDies_cult_max() {
  return dies_cult_max;
 }

 public void setDies_cult_max(int dies_cult_max) {
  this.dies_cult_max = dies_cult_max;
 }

 public int getDies_cult_min() {
  return dies_cult_min;
 }

 public void setDies_cult_min(int dies_cult_min) {
  this.dies_cult_min = dies_cult_min;
 }

 public String getRendimiento() {
  return rendimiento;
 }

 public void setRendimiento(String rendimiento) {
  this.rendimiento = rendimiento;
 }
}
