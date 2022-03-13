package utilidades;

import modelos.Habilidad;
import modelos.Item;
import modelos.Personaje;

import static utilidades.UtilidadesItem.actualizarStatsItem;
import static utilidades.UtilidadesItem.equiparItem;
import static utilidades.UtilidadesPersonaje.levelTo18;

public class UtilidadesHabilidad {

    public void golpearConHabilidad(Personaje emisor, Personaje receptor, Habilidad habilidadEmisor){

        if (habilidadEmisor.getTipoHabilidad().equals("DANO")){

            boolean vacio;
            double dañoHabilidadTotal;
            levelTo18(receptor);
            levelTo18(emisor);

            if (emisor.getEquipamiento().isEmpty()){
                vacio = true;
            }else {
                for (Item items : emisor.getEquipamiento() ){
                    actualizarStatsItem(emisor, items);
                }
                for (Item items : receptor.getEquipamiento() ){
                    actualizarStatsItem(emisor, items);
                }
            }
            dañoHabilidadTotal = habilidadEmisor.getDanobase() + (0.2 * emisor.getAtaque()) - (0.1 * receptor.getDefensa());
            emisor.setMana(emisor.getMana() - habilidadEmisor.getCosteMana());
            receptor.setVida(receptor.getVida() - habilidadEmisor.getDano());
        }
    }

}
