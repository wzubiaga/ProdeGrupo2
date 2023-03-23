public class Partido {
    public Equipo Equipo1;
    public Equipo Equipo2;

    public  int golesEquipo1;
    public  int golesEquipo2;

    enum ResultadoEnum {perdedor,empate,ganador}

    public ResultadoEnum Resultado (Equipo a){
        Equipo b;
        int golesA = 0;
        int golesB = 0;
        if (a.equals(Equipo1)){
            b=this.Equipo2;
            golesB=this.golesEquipo2;
            golesA=this.golesEquipo1;
            }
        else
            if (a.equals(Equipo2)){
                b=this.Equipo1;
                golesB=this.golesEquipo1;
                golesA=this.golesEquipo2;
            }
            //else
              //  System.out.println("El Equipo ingresado no jugo en este partido");
                 

        if (golesA > golesB)
            return  ResultadoEnum.ganador;
            else
                if (golesA < golesB)
                    return ResultadoEnum.perdedor;
                else
                    // (golesA = golesB)
                    return ResultadoEnum.empate;

   }

}
