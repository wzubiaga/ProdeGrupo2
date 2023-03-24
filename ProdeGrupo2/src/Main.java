import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args)throws IOException   {

        ArrayList<Partido> importarR = ImportadorDeResultados.GetResultadosFromFile("ProdeGrupo2/src/resultados.csv");
        if (importarR.isEmpty()) {
            System.out.println("No se encontraron Resultados");
        } else {
            for (Partido p : importarR) {
                System.out.println(p.imprimeResulado());
            }
        }

        ArrayList<Pronostico> importarP = ImportadorDeResultados.GetPronosticoFromFile("ProdeGrupo2/src/pronostico.csv");
        if (importarP.isEmpty()) {
            System.out.println("No se encontraron Pronosticos");
        } else {
            for (Pronostico p : importarP) {
                System.out.println(p.imprimeResulado());
            }
        }


    }
}
