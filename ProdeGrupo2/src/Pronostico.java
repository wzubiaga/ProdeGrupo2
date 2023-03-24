public class Pronostico {
   // private Partido partido;
    private Equipo equipo;
    private ResultadoEnum resultadoEnum;

    public Pronostico( Equipo equipo, ResultadoEnum resultadoEnum) {
       // this.partido = partido;
        this.equipo = equipo;
        this.resultadoEnum = resultadoEnum;
    }
  //  public Partido getPartido() { return partido; }

    public Equipo getEquipo() { return equipo; }

    public ResultadoEnum getResultadoEnum() { return resultadoEnum; }
    public String imprimeResulado(){
        //return "Equipo1:"+ equipo1.nombre()+"["+golesEquipo1+"]"+" VS Equipo2:"+ equipo2.nombre()+"["+golesEquipo2+"]";
        return equipo.nombre()+"["+resultadoEnum+"]";
    }
}
