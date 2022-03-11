package utilidades;
import modelos.*;
import utilidades.UtilidadesPersonaje;
import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static utilidades.UtilidadesPersonaje.levelTo0;
import static utilidades.UtilidadesPersonaje.levelUp;

public class UtilidadesFichero {

    public static final char SEPARATOR=',';
    public static final char QUOTE='"';

    CSVReader reader_personaje = null;
    CSVReader reader_habilidades = null;
    CSVReader reader_item = null;

    public List<Personaje> leerPersonajes() {

        List<Personaje> personajes = new ArrayList<>();

        try {
            reader_personaje = new CSVReader(new FileReader("C:\\Users\\orteg\\IdeaProjects\\LeagueOfLegends\\src\\documentos\\personajes.csv"),SEPARATOR,QUOTE);
            String[] siguienteLinea= null ;
            int contador = 0;

            while ((siguienteLinea = reader_personaje.readNext()) != null) {

                if(contador > 0) {
                    String[] valores = siguienteLinea;
                    Personaje p = new Personaje();
                    levelTo0(p);
                    p.setId(Integer.parseInt(valores[0]));
                    p.setNombre(valores[1]);
                    p.setFechaCreacion(LocalDate.parse(valores[2], DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                    p.setAtaqueBase(Double.valueOf(valores[3]));
                    p.setDefensaBase(Double.valueOf(valores[4]));
                    p.setVidaBase(Double.valueOf(valores[5]));
                    p.setManaBase(Double.valueOf(valores[6]));
                    p.setRegion(Region.valueOf(valores[7]));
                    p.setNivel(1);
                    personajes.add(p);
                }
                contador++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return personajes;
    }

    public List<Personaje> leerYAprenderHabilidades(){

        List<Personaje> personajes = new ArrayList<>();
        List<Habilidad> habilidades = new ArrayList<>();



        try {

            reader_habilidades = new CSVReader(new FileReader("C:\\Users\\orteg\\IdeaProjects\\LeagueOfLegends\\src\\documentos\\habilidades.csv"), SEPARATOR, QUOTE);
            reader_personaje = new CSVReader(new FileReader("C:\\Users\\orteg\\IdeaProjects\\LeagueOfLegends\\src\\documentos\\personajes.csv"),SEPARATOR,QUOTE);
            reader_item = new CSVReader(new FileReader("C:\\Users\\orteg\\IdeaProjects\\LeagueOfLegends\\src\\documentos\\item.csv"),SEPARATOR,QUOTE);

            String[] siguienteLinea = null;
            int contador = 0;


            while ((siguienteLinea = reader_habilidades.readNext()) != null) {

                if(contador > 0) {
                    String[] valores = siguienteLinea;
                    Habilidad h = new Habilidad();
                    h.setId(Integer.parseInt(valores[0]));
                    h.setNombre(valores[2]);
                    h.setDanobase(Double.valueOf(valores[3]));
                    h.setCosteMana(Double.valueOf(valores[4]));
                    h.setTipoHabilidad(TipoHabilidad.valueOf(valores[5]));
                    habilidades.add(h);
                }
                contador++;
            }


            while ((siguienteLinea = reader_personaje.readNext()) != null) {

                if(contador > 0) {
                    String[] valores = siguienteLinea;
                    Personaje p = new Personaje();
                    levelTo0(p);
                    p.setId(Integer.parseInt(valores[0]));
                    p.setNombre(valores[1]);
                    p.setFechaCreacion(LocalDate.parse(valores[2], DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                    p.setAtaqueBase(Double.valueOf(valores[3]));
                    p.setDefensaBase(Double.valueOf(valores[4]));
                    p.setVidaBase(Double.valueOf(valores[5]));
                    p.setManaBase(Double.valueOf(valores[6]));
                    p.setRegion(Region.valueOf(valores[7]));
                    p.setNivel(1);
                    p.setHabildades(habilidades);
                    personajes.add(p);

                }
                contador++;
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }

        return personajes;
    }

    public List<Item> leerItems() throws IOException {

        List<Item> items = new ArrayList<>();
        reader_item = new CSVReader(new FileReader("C:\\Users\\orteg\\IdeaProjects\\LeagueOfLegends\\src\\documentos\\item.csv"),SEPARATOR,QUOTE);

        String[] siguienteLinea = null;
        int contador = 0;

        while ((siguienteLinea = reader_item.readNext()) != null) {

            if(contador > 0) {
                String[] valores = siguienteLinea;
                Item i = new Item();
                i.setId(Integer.parseInt(valores[0]));
                i.setNombre(valores[1]);
                i.setAumentoDano(Double.valueOf(valores[2]));
                i.setAumentoDefensa(Double.valueOf(valores[3]));
                i.setAumentoSalud(Double.valueOf(valores[4]));
                i.setAumentoMana(Double.valueOf(valores[5]));
                items.add(i);
            }
            contador++;
        }

        return items;
    }


}