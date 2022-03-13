package utilidades;

import modelos.Jugador;
import modelos.Partida;
import modelos.Personaje;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class UtilidadesPartida implements IUtilidadesPartida {

    // hacer estos metodos privados


    private void inicializarPartida(Partida partida, List<Jugador> participantes, List<Personaje> personajesDisponibles) {




        for (Personaje personaje: personajesDisponibles){
            for (Jugador jugador: participantes){
                if (personaje.equals(jugador.getPersonajeFavorito())){
                    for (Personaje personaje_fav: jugador.getPersonajeFavorito()){
                        partida.getElecciones().put(jugador, personaje_fav);
                    }

                } else {
                    partida.getElecciones().put(jugador, personaje);
                }
            }
        }


        partida.setInicioPartida(LocalDateTime.now());

        Set<Jugador> equipo1 = new HashSet<>();
        Set<Jugador> equipo2 = new HashSet<>();

        for (Jugador jugador: participantes){
            for(int i = 0; i < participantes.size();i++){
                if (i % 2 == 0){
                    equipo1.add(jugador);
                } else {
                    equipo2.add(jugador);
                }
            }
        }
        partida.getJugadoresPorEquipo().put(1,equipo1);
        partida.getJugadoresPorEquipo().put(2,equipo2);


    }


    private void finalizarPartida(Partida partida, Integer equipoVencedor) {

    }
}
