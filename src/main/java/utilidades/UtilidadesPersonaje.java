package utilidades;

import modelos.Escalabilidad;
import modelos.Personaje;
import modelos.Region;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UtilidadesPersonaje {

    public Personaje levelUp(Personaje personaje){

       Integer subida_nivel = personaje.getNivel() + 1;

       Double ataque = personaje.getAtaqueBase() + (subida_nivel * personaje.getEscalabilidad().getIncremetoDanoNivel());
       Double defensa = personaje.getDefensaBase() + (subida_nivel * personaje.getEscalabilidad().getIncremetoDefensaNivel());
       Double vida = personaje.getVidaBase() + (subida_nivel * personaje.getEscalabilidad().getIncremetoSaludNivel());
       Double mana = personaje.getMana() + (subida_nivel * personaje.getEscalabilidad().getIncremetoManaNivel());

       personaje.setAtaque(ataque);
       personaje.setDefensa(defensa);
       personaje.setVida(vida);
       personaje.setMana(mana);

        return personaje;
    }

    public Map<Region, List<Personaje>> getPersonajesPorRegion(List<Personaje> personajes){

        Map<Region, List<Personaje>> mapa_personaje = new HashMap<>();

        mapa_personaje.put(Region.AGUAS_ESTANCADAS , new ArrayList<>());
        mapa_personaje.put(Region.BANDLE , new ArrayList<>());
        mapa_personaje.put(Region.DEMACIA , new ArrayList<>());
        mapa_personaje.put(Region.DESCONOCIDA , new ArrayList<>());
        mapa_personaje.put(Region.FREIJORD , new ArrayList<>());
        mapa_personaje.put(Region.JONIA , new ArrayList<>());
        mapa_personaje.put(Region.NOXUS , new ArrayList<>());
        mapa_personaje.put(Region.PILTOVER , new ArrayList<>());
        mapa_personaje.put(Region.SHURIMA , new ArrayList<>());
        mapa_personaje.put(Region.TARGON , new ArrayList<>());
        mapa_personaje.put(Region.ZAUM , new ArrayList<>());

        for (Personaje personaje: personajes){

            if (personaje.getRegion().equals(Region.AGUAS_ESTANCADAS)){
                mapa_personaje.get(Region.AGUAS_ESTANCADAS).add(personaje);
            }
            if (personaje.getRegion().equals(Region.BANDLE)){
                mapa_personaje.get(Region.BANDLE).add(personaje);
            }
            if (personaje.getRegion().equals(Region.DEMACIA)){
                mapa_personaje.get(Region.DEMACIA).add(personaje);
            }
            if (personaje.getRegion().equals(Region.FREIJORD)){
                mapa_personaje.get(Region.FREIJORD).add(personaje);
            }
            if (personaje.getRegion().equals(Region.JONIA)){
                mapa_personaje.get(Region.JONIA).add(personaje);
            }
            if (personaje.getRegion().equals(Region.NOXUS)){
                mapa_personaje.get(Region.NOXUS).add(personaje);
            }
            if (personaje.getRegion().equals(Region.PILTOVER)){
                mapa_personaje.get(Region.PILTOVER).add(personaje);
            }
            if (personaje.getRegion().equals(Region.SHURIMA)){
                mapa_personaje.get(Region.SHURIMA).add(personaje);
            }
            if (personaje.getRegion().equals(Region.TARGON)){
                mapa_personaje.get(Region.TARGON).add(personaje);
            }
            if (personaje.getRegion().equals(Region.ZAUM)){
                mapa_personaje.get(Region.ZAUM).add(personaje);
            }


        }

        return mapa_personaje;
    }




}
