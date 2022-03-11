package modelos;

import java.util.Objects;

public class Habilidad {
    private int id;
    private String nombre;
    private Double danobase;
    private Double dano;
    private Double costeMana;
    private TipoHabilidad tipoHabilidad;

    public Habilidad(int id, String nombre, Double danobase, Double dano, Double costeMana, TipoHabilidad tipoHabilidad) {
        this.id = id;
        this.nombre = nombre;
        this.danobase = danobase;
        this.dano = dano;
        this.costeMana = costeMana;
        this.tipoHabilidad = tipoHabilidad;
    }

    public Habilidad() {

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

    public Double getDanobase() {
        return danobase;
    }

    public void setDanobase(Double danobase) {
        this.danobase = danobase;
    }

    public Double getDano() {
        return dano;
    }

    public void setDano(Double dano) {
        this.dano = dano;
    }

    public Double getCosteMana() {
        return costeMana;
    }

    public void setCosteMana(Double costeMana) {
        this.costeMana = costeMana;
    }

    public TipoHabilidad getTipoHabilidad() {
        return tipoHabilidad;
    }

    public void setTipoHabilidad(TipoHabilidad tipoHabilidad) {
        this.tipoHabilidad = tipoHabilidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Habilidad habilidad = (Habilidad) o;
        return id == habilidad.id && Objects.equals(nombre, habilidad.nombre) && Objects.equals(danobase, habilidad.danobase) && Objects.equals(dano, habilidad.dano) && Objects.equals(costeMana, habilidad.costeMana) && tipoHabilidad == habilidad.tipoHabilidad;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, danobase, dano, costeMana, tipoHabilidad);
    }

    @Override
    public String toString() {
        return "Habilidad{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", danobase=" + danobase +
                ", dano=" + dano +
                ", costeMana=" + costeMana +
                ", tipoHabilidad=" + tipoHabilidad +
                '}';
    }
}
