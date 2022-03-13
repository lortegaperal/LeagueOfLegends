package utilidades;

import modelos.Item;
import modelos.Personaje;

public class UtilidadesItem {

    public static void equiparItem(Personaje personaje, Item item){

        personaje.getEquipamiento().add(item);
        personaje.setAtaque(personaje.getAtaque() + item.getAumentoDano());
        personaje.setDefensa(personaje.getDefensa() + item.getAumentoDefensa());
        personaje.setVida(personaje.getVida() + item.getAumentoSalud());
        personaje.setMana(personaje.getMana() + item.getAumentoMana());
    }

    //creado para no añadir de nuevo el mismo equipamiento y actualizar las stats
    public static void actualizarStatsItem(Personaje personaje, Item item){

        personaje.setAtaque(personaje.getAtaque() + item.getAumentoDano());
        personaje.setDefensa(personaje.getDefensa() + item.getAumentoDefensa());
        personaje.setVida(personaje.getVida() + item.getAumentoSalud());
        personaje.setMana(personaje.getMana() + item.getAumentoMana());
    }


}
