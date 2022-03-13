package utilidades;

import modelos.Jugador;
import modelos.Partida;
import modelos.Personaje;

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
        partida.setInicioPartida(LocalDateTime.now());

    }


    private void finalizarPartida(Partida partida, Integer equipoVencedor) {

        partida.setFinPartida(LocalDateTime.now());
        int diferencia_horas = (partida.getFinPartida().getHour() * 3600) - (partida.getInicioPartida().getHour() * 3600);
        int diferencia_minutos = (partida.getFinPartida().getMinute() * 60) - (partida.getInicioPartida().getMinute() * 60);
        int diferencia_segundos = (partida.getFinPartida().getSecond()) - (partida.getInicioPartida().getSecond());
        partida.setDuracionPartida(diferencia_horas + diferencia_minutos + diferencia_segundos);

        partida.setEquipoVencedor(equipoVencedor);


        Set<Jugador> vencedores = partida.getJugadoresPorEquipo().get(equipoVencedor);
        for(Jugador jugador : vencedores){

            Personaje personaje = partida.getElecciones().get(jugador);
            Map<Personaje,Integer> partidasGanadas = jugador.getPartidasGanadas();
            int nuevaPartidasGanadas =  partidasGanadas.get(personaje)+1;
            partidasGanadas.put(personaje,nuevaPartidasGanadas);
            jugador.setPartidasGanadas(partidasGanadas);
        }

    }
}
