import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;
public class ImportadorDeResultados {

    public static ArrayList<Partido> GetResultadosFromFile(String fileName, Liga equiposParticipantes)throws IOException {

        Path archivoResultado = Paths.get(fileName);
        Scanner lector = new Scanner(archivoResultado);
        lector.useDelimiter("[;\r\n]+");
        ArrayList<Partido> listapartidos = new ArrayList<>();
        int nroLinea = 1;
        while (lector.hasNext()) {
            String A = lector.next();
            String B = lector.next();
            int golesA = lector.nextInt();
            int golesB = lector.nextInt();
            // System.out.println(A+B+golesA+golesB);
           Partido nuevo = new Partido(nroLinea, equiposParticipantes.getEquipoParticipante(A), equiposParticipantes.getEquipoParticipante(B), golesA, golesB);
            listapartidos.add(nuevo);
            nroLinea++;
        }
        lector.close();
        return listapartidos;
    }



    public static ArrayList<Pronostico> GetPronosticoFromFile(String fileName, Liga equiposParticipantes,Ronda primeraRonda)throws IOException {

        Path archivoPronostico = Paths.get(fileName);
        Scanner lector = new Scanner(archivoPronostico);
        lector.useDelimiter("[;\r\n]+");
        ArrayList<Pronostico> listapronosticos = new ArrayList<>();
        int puntos = 0;
        int acumulados = 0;

        while (lector.hasNext()) {
            String A = lector.next();
            String ganaA = lector.next();
            String empate = lector.next();
            String ganaB = lector.next();
            String B = lector.next();
            // System.out.println(A+ganaA+empate+ganaB+B);

            Partido partido=  primeraRonda.BuscarEnfrentamiento( equiposParticipantes.getEquipoParticipante(A), equiposParticipantes.getEquipoParticipante(B));

            if (Objects.equals(partido,null)){
                lector.close();
                //inventigar si esta bien salir asi de la funcion
                return null;
            }

            Pronostico nuevo = new Pronostico(partido,equiposParticipantes.getEquipoParticipante(A),ganaA,empate,ganaB ,equiposParticipantes.getEquipoParticipante(B));
            listapronosticos.add(nuevo);
        }

        lector.close();
        return listapronosticos;
    }

}