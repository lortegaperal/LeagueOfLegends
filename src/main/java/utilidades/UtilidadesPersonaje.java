package utilidades;

import modelos.Escalabilidad;
import modelos.Personaje;
import modelos.Region;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UtilidadesPersonaje {

    public static Personaje levelUp(Personaje personaje) {

        Integer subida_nivel = personaje.getNivel() + 1;

        Double ataque = personaje.getAtaqueBase() + (subida_nivel * personaje.getEscalabilidad().getIncremetoDanoNivel());
        Double defensa = personaje.getDefensaBase() + (subida_nivel * personaje.getEscalabilidad().getIncremetoDefensaNivel());
        Double vida = personaje.getVidaBase() + (subida_nivel * personaje.getEscalabilidad().getIncremetoSaludNivel());
        Double mana = personaje.getMana() + (subida_nivel * personaje.getEscalabilidad().getIncremetoManaNivel());

        personaje.setAtaque(ataque);
        personaje.setDefensa(defensa);
        personaje.setVida(vida);
        personaje.setMana(mana);
        personaje.setNivel(subida_nivel);

        return personaje;
    }

    public Map<Region, List<Personaje>> getPersonajesPorRegion(List<Personaje> personajes) {

        Map<Region, List<Personaje>> mapa_personaje = new HashMap<>();

        mapa_personaje.put(Region.AGUAS_ESTANCADAS, new ArrayList<>());
        mapa_personaje.put(Region.BANDLE, new ArrayList<>());
        mapa_personaje.put(Region.DEMACIA, new ArrayList<>());
        mapa_personaje.put(Region.DESCONOCIDA, new ArrayList<>());
        mapa_personaje.put(Region.FREIJORD, new ArrayList<>());
        mapa_personaje.put(Region.JONIA, new ArrayList<>());
        mapa_personaje.put(Region.NOXUS, new ArrayList<>());
        mapa_personaje.put(Region.PILTOVER, new ArrayList<>());
        mapa_personaje.put(Region.SHURIMA, new ArrayList<>());
        mapa_personaje.put(Region.TARGON, new ArrayList<>());
        mapa_personaje.put(Region.ZAUM, new ArrayList<>());

        for (Personaje personaje : personajes) {

            if (personaje.getRegion().equals(Region.AGUAS_ESTANCADAS)) {
                mapa_personaje.get(Region.AGUAS_ESTANCADAS).add(personaje);
            }
            if (personaje.getRegion().equals(Region.BANDLE)) {
                mapa_personaje.get(Region.BANDLE).add(personaje);
            }
            if (personaje.getRegion().equals(Region.DEMACIA)) {
                mapa_personaje.get(Region.DEMACIA).add(personaje);
            }
            if (personaje.getRegion().equals(Region.FREIJORD)) {
                mapa_personaje.get(Region.FREIJORD).add(personaje);
            }
            if (personaje.getRegion().equals(Region.JONIA)) {
                mapa_personaje.get(Region.JONIA).add(personaje);
            }
            if (personaje.getRegion().equals(Region.NOXUS)) {
                mapa_personaje.get(Region.NOXUS).add(personaje);
            }
            if (personaje.getRegion().equals(Region.PILTOVER)) {
                mapa_personaje.get(Region.PILTOVER).add(personaje);
            }
            if (personaje.getRegion().equals(Region.SHURIMA)) {
                mapa_personaje.get(Region.SHURIMA).add(personaje);
            }
            if (personaje.getRegion().equals(Region.TARGON)) {
                mapa_personaje.get(Region.TARGON).add(personaje);
            }
            if (personaje.getRegion().equals(Region.ZAUM)) {
                mapa_personaje.get(Region.ZAUM).add(personaje);
            }


        }

        return mapa_personaje;
    }

    //MÉTODO PARA PONER EL NIVEL Y LAS ESTADÍSTICAS DEL PERSONAJE A 0

    public static Personaje levelTo0(Personaje personaje) {

        personaje.setAtaque(0.0);
        personaje.setDefensa(0.0);
        personaje.setVida(0.0);
        personaje.setMana(0.0);
        personaje.setNivel(0);

        return personaje;
    }

    //MÉTODO PARA PONER EL NIVEL Y LAS ESTADÍSTICAS DEL PERSONAJE DE 0 A 18

    public Personaje levelTo18(Personaje personaje) {

        levelTo0(personaje);
        while (personaje.getNivel() == 18) {
            levelUp(personaje);
        }
        return personaje;
    }


    public Personaje getMasPoderoso(List<Personaje> personajes) {

        Personaje mas_poderoso = null;
        for (Personaje personaje : personajes) {

            levelTo18(personaje);

            if (mas_poderoso == null) {
                mas_poderoso = personaje;
            }
            if (personaje.getNivel() == 18) {

                double poder = personaje.getAtaque() + personaje.getDefensa() + personaje.getMana() + personaje.getVida();
                double poder_mp = (mas_poderoso.getAtaque() + mas_poderoso.getDefensa() + mas_poderoso.getMana() + mas_poderoso.getVida());
                if (poder > poder_mp) {

                    mas_poderoso = personaje;
                }
            }
        }
        return mas_poderoso;
    }

    public Map<Region, Personaje> getMasPoderosoPorRegion(List<Personaje> personajes) {
        Map<Region, List<Personaje>> mapa_region = getPersonajesPorRegion(personajes);
        Map<Region, Personaje> mapaObjetivo = new HashMap<>();

        for (Region region : mapa_region.keySet()) {
                mapaObjetivo.put(region, getMasPoderoso(mapa_region.get(region)));
        }
        return mapaObjetivo;
    }
}