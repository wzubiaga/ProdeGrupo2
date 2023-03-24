import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Main {
    public static void main(String[] args)throws IOException {

        Liga equiposParticipantes = new Liga();

        Equipo a = new Equipo(1, "Argentina", " ");
        Equipo b = new Equipo(2, "Arabia Saudita", " ");
        Equipo c = new Equipo(3, "Polonia", " ");
        Equipo d = new Equipo(4, "México", " ");

        equiposParticipantes.agregarEquipo(a);
        equiposParticipantes.agregarEquipo(b);
        equiposParticipantes.agregarEquipo(c);
        equiposParticipantes.agregarEquipo(d);

        ArrayList<Partido> importarR = ImportadorDeResultados.GetResultadosFromFile("ProdeGrupo2/src/resultados.csv", equiposParticipantes);
        if (importarR.isEmpty()) {
            System.out.println("No se encontraron Resultados");
        } else {
            System.out.println("Resultado de la Liga: ");
            for (Partido p : importarR) {
                System.out.println(p.imprimeResulado());
            }
            System.out.println("----------------------");
        }

        Ronda primeraRonda = new Ronda(1, importarR);

        ArrayList<Pronostico> importarP = ImportadorDeResultados.GetPronosticoFromFile("ProdeGrupo2/src/pronostico.csv", equiposParticipantes, primeraRonda);

        if (Objects.equals(importarP, null)) {
            System.out.println("Se cargo una incongruencia en el archivo pronostico, esos equipo no se enfrentaron en la Liga");
        } else {
            if (importarP.isEmpty()) {
                System.out.println("No se encontraron Pronosticos");
            } else {
                System.out.println("Pronosticos del Participante:");
                int acumulados = 0;
                for (Pronostico p : importarP) {
                    acumulados = acumulados + p.getPuntos();
                    System.out.println(p.imprimeResulado());
                }
                System.out.println("----------------------");
                System.out.println("Puntos obtenidos:"+acumulados);
            }
        }
    }
}
