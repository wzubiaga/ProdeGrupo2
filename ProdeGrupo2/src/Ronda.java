import java.util.ArrayList;

public class Ronda {

    private int nro;
    private ArrayList<Partido> listaPartidos;

    public Ronda(int nro,  ArrayList<Partido> lPartidos) {
        this.nro = nro;
        listaPartidos = new ArrayList<>(lPartidos);
    }

    public int getNro() {
        return nro;
    }

    public ArrayList<Partido> getListaPartidos() {
        return listaPartidos;
    }

    public Partido BuscarEnfrentamiento(Equipo a, Equipo b){
       for (Partido p: listaPartidos)
            {if(((p.getEquipo1().equals(a))&&(p.getEquipo2().equals(b))) || ((p.getEquipo1().equals(b))&&(p.getEquipo2().equals(a)))){
                return p;
                }
            }
        return  null;
    }
}
