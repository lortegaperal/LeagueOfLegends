package modelos;

import java.util.Objects;

public class Item {
    private int id;
    private String nombre;
    private Double aumentoDano;
    private Double aumentoDefensa;
    private Double aumentoSalud;
    private Double aumentoMana;

    public Item(int id, String nombre, Double aumentoDano, Double aumentoDefensa, Double aumentoSalud, Double aumentoMana) {
        this.id = id;
        this.nombre = nombre;
        this.aumentoDano = aumentoDano;
        this.aumentoDefensa = aumentoDefensa;
        this.aumentoSalud = aumentoSalud;
        this.aumentoMana = aumentoMana;
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

    public Double getAumentoDano() {
        return aumentoDano;
    }

    public void setAumentoDano(Double aumentoDano) {
        this.aumentoDano = aumentoDano;
    }

    public Double getAumentoDefensa() {
        return aumentoDefensa;
    }

    public void setAumentoDefensa(Double aumentoDefensa) {
        this.aumentoDefensa = aumentoDefensa;
    }

    public Double getAumentoSalud() {
        return aumentoSalud;
    }

    public void setAumentoSalud(Double aumentoSalud) {
        this.aumentoSalud = aumentoSalud;
    }

    public Double getAumentoMana() {
        return aumentoMana;
    }

    public void setAumentoMana(Double aumentoMana) {
        this.aumentoMana = aumentoMana;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id && Objects.equals(nombre, item.nombre) && Objects.equals(aumentoDano, item.aumentoDano) && Objects.equals(aumentoDefensa, item.aumentoDefensa) && Objects.equals(aumentoSalud, item.aumentoSalud) && Objects.equals(aumentoMana, item.aumentoMana);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, aumentoDano, aumentoDefensa, aumentoSalud, aumentoMana);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", aumentoDano=" + aumentoDano +
                ", aumentoDefensa=" + aumentoDefensa +
                ", aumentoSalud=" + aumentoSalud +
                ", aumentoMana=" + aumentoMana +
                '}';
    }
}
