import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
public class ImportadorDeResultados {

    public static ArrayList<Partido> GetResultadosFromFile(String fileName)throws IOException {

        Path archivoResultado = Paths.get(fileName);
        // Path archivoPronostico = Paths.get("pronostico.csv");
        Scanner lector = new Scanner(archivoResultado);
        lector.useDelimiter("[;\r\n]+");
        ArrayList<Partido> listapartidos = new ArrayList<>();

        while (lector.hasNext()) {
            String A = lector.next();
            String B = lector.next();
            int golesA = lector.nextInt();
            int golesB = lector.nextInt();
            // System.out.println(A+B+golesA+golesB);

            //por ahora al tomar del archivo creo asi
            //habra una HashMap equipos y se trae de ahi el objeto y se pasa ese que esta creado
            Equipo equipo1 = new Equipo(A, "");
            Equipo equipo2 = new Equipo(B, "");

            Partido nuevo = new Partido(equipo1, equipo2, golesA, golesB);
            listapartidos.add(nuevo);
        }
        lector.close();
        return listapartidos;
    }

    public static ArrayList<Pronostico> GetPronosticoFromFile(String fileName)throws IOException {

        Path archivoPronostico = Paths.get(fileName);
        Scanner lector = new Scanner(archivoPronostico);
        lector.useDelimiter("[;\r\n]+");
        ArrayList<Pronostico> listapronosticos = new ArrayList<>();

        while (lector.hasNext()) {
            String A = lector.next();
            String ganaA = lector.next();
            String empate = lector.next();
            String ganaB = lector.next();
            String B = lector.next();
            // System.out.println(A+ganaA+empate+ganaB+B);

            //Ver como asociar esto con partido
           // Partido partido;
            Equipo equipo;
            ResultadoEnum resul;

            if (ganaB.equals(" ")) {
                equipo = new Equipo(A, "");
                if (ganaA.equals(" ")) {
                    resul = ResultadoEnum.empate;
                }else {resul = ResultadoEnum.ganador;}
            }else{
                equipo = new Equipo(B, "");
                resul = ResultadoEnum.ganador;}

            Pronostico nuevo = new Pronostico(equipo,resul);
            listapronosticos.add(nuevo);
            }
        lector.close();
        return listapronosticos;
    }
}