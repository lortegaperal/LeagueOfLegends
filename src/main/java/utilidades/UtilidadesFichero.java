package utilidades;
import utilidades.UtilidadesPersonaje;
import com.opencsv.CSVReader;
import modelos.Personaje;
import modelos.Region;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static utilidades.UtilidadesPersonaje.levelTo0;
import static utilidades.UtilidadesPersonaje.levelUp;

public class UtilidadesFichero {

    public static final char SEPARATOR=',';
    public static final char QUOTE='"';

    CSVReader reader = null;

    public List<Personaje> leerPersonajes() {

        List<Personaje> personajes = new ArrayList<>();

        try {
            reader = new CSVReader(new FileReader("C:\\Users\\orteg\\IdeaProjects\\LeagueOfLegends\\src\\documentos\\personajes.csv"),SEPARATOR,QUOTE);
            String[] siguienteLinea= null ;
            int contador = 0;

            while ((siguienteLinea = reader.readNext()) != null) {

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
                    levelUp(p);
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

}