package modelos;

import java.util.Objects;

public class Escalabilidad {

    private int id;
    private Double incremetoDanoNivel;
    private Double incremetoDefensaNivel;
    private Double incremetoSaludNivel;
    private Double incremetoManaNivel;

    public Escalabilidad(int id, Double incremetoDanoNivel, Double incremetoDefensaNivel, Double incremetoSaludNivel, Double incremetoManaNivel) {
        this.id = id;
        this.incremetoDanoNivel = incremetoDanoNivel;
        this.incremetoDefensaNivel = incremetoDefensaNivel;
        this.incremetoSaludNivel = incremetoSaludNivel;
        this.incremetoManaNivel = incremetoManaNivel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getIncremetoDanoNivel() {
        return incremetoDanoNivel;
    }

    public void setIncremetoDanoNivel(Double incremetoDanoNivel) {
        this.incremetoDanoNivel = incremetoDanoNivel;
    }

    public Double getIncremetoDefensaNivel() {
        return incremetoDefensaNivel;
    }

    public void setIncremetoDefensaNivel(Double incremetoDefensaNivel) {
        this.incremetoDefensaNivel = incremetoDefensaNivel;
    }

    public Double getIncremetoSaludNivel() {
        return incremetoSaludNivel;
    }

    public void setIncremetoSaludNivel(Double incremetoSaludNivel) {
        this.incremetoSaludNivel = incremetoSaludNivel;
    }

    public Double getIncremetoManaNivel() {
        return incremetoManaNivel;
    }

    public void setIncremetoManaNivel(Double incremetoManaNivel) {
        this.incremetoManaNivel = incremetoManaNivel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Escalabilidad that = (Escalabilidad) o;
        return id == that.id && Objects.equals(incremetoDanoNivel, that.incremetoDanoNivel) && Objects.equals(incremetoDefensaNivel, that.incremetoDefensaNivel) && Objects.equals(incremetoSaludNivel, that.incremetoSaludNivel) && Objects.equals(incremetoManaNivel, that.incremetoManaNivel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, incremetoDanoNivel, incremetoDefensaNivel, incremetoSaludNivel, incremetoManaNivel);
    }

    @Override
    public String toString() {
        return "Escalabilidad{" +
                "id=" + id +
                ", incremetoDanoNivel=" + incremetoDanoNivel +
                ", incremetoDefensaNivel=" + incremetoDefensaNivel +
                ", incremetoSaludNivel=" + incremetoSaludNivel +
                ", incremetoManaNivel=" + incremetoManaNivel +
                '}';
    }
}
