package utilidades;

import modelos.Escalabilidad;
import modelos.Personaje;


public class UtilidadesPersonaje {

    public Personaje levelUp(Personaje personaje){

       Integer subida_nivel = personaje.getNivel() + 1;

       Double ataque = personaje.getAtaqueBase() + (subida_nivel * personaje.getEscalabilidad().getIncremetoDanoNivel());
       Double defensa = personaje.getDefensaBase() + (subida_nivel * personaje.getEscalabilidad().getIncremetoDefensaNivel());
       Double vida = personaje.getVidaBase() + (subida_nivel * personaje.getEscalabilidad().getIncremetoSaludNivel());
       Double mana = personaje.getMana() + (subida_nivel * personaje.getEscalabilidad().getIncremetoManaNivel());

        return personaje;
    }


}
