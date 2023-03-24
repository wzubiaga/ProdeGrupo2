public class Pronostico {
    private Partido partido;
    private Equipo equipo;
    private ResultadoEnum resultadoEnum;
    private int puntos=0;
    //private Participante participante;

    public Pronostico(Partido partido, Equipo equipo1,String ganaA,String empate,String ganaB,Equipo equipo2) {
      this.partido = partido;
      if (ganaB.equals(" ")) {
          this.equipo  =equipo1;
            if (ganaA.equals(" ")) {
                this.resultadoEnum = ResultadoEnum.empate;
            }else {this.resultadoEnum = ResultadoEnum.ganador;}
        }else{
            this.equipo = equipo2;
            this.resultadoEnum = ResultadoEnum.ganador;
      };
        int valor = partido.getGolesEquipo1()- partido.getGolesEquipo2();
        if (valor >0) {
            //gano equipo1
            if ((this.equipo.equals(equipo1))&&(this.resultadoEnum.equals(ResultadoEnum.ganador))){
                this.puntos = 1;
            }

        }else{
            if (valor <0) {
                //gano equipo2
                if ((this.equipo.equals(equipo2))&&(this.resultadoEnum.equals(ResultadoEnum.ganador))){
                    this.puntos = 1;
                }
            }else{
                //empate
                if (this.resultadoEnum.equals(ResultadoEnum.empate)){
                    this.puntos = 1;
                }


            }
        }
    }
  //  public Partido getPartido() { return partido; }
    public Equipo getEquipo() { return equipo; }
    public ResultadoEnum getResultadoEnum() { return resultadoEnum; }
    public int getPuntos() { return puntos; }
    public String imprimeResulado(){
        //return "Equipo1:"+ equipo1.nombre()+"["+golesEquipo1+"]"+" VS Equipo2:"+ equipo2.nombre()+"["+golesEquipo2+"]";
        return equipo.getNombre()+"["+resultadoEnum+"]";
    }

}
