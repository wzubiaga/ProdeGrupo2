public class Partido {
    private Equipo equipo1;
    private  Equipo equipo2;
    private int golesEquipo1;
    private int golesEquipo2;

    public Partido(Equipo a, Equipo b,int golesA, int golesB) {
        this.golesEquipo1 = golesA;
        this.golesEquipo2 = golesB;
        equipo1 = a;
        equipo2 = b;
    }

    public Equipo Equipo1(){return equipo1;}
    public Equipo Equipo2(){return equipo2;}
    public  int golesEquipo1(){return golesEquipo1;}
    public  int golesEquipo2(){return golesEquipo2;}

    public ResultadoEnum Resultado (Equipo a){
        Equipo b;
        int golesA = 0;
        int golesB = 0;
        if (a.equals(this.equipo1)){
            b=this.equipo2;
            golesB=this.golesEquipo2;
            golesA=this.golesEquipo1;
            }
        else
            if (a.equals(equipo2)){
                b=this.equipo1;
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

   public String imprimeResulado(){
       //return "Equipo1:"+ equipo1.nombre()+"["+golesEquipo1+"]"+" VS Equipo2:"+ equipo2.nombre()+"["+golesEquipo2+"]";
       return equipo1.nombre()+"["+golesEquipo1+"]"+" VS. "+ equipo2.nombre()+"["+golesEquipo2+"]";
   }
}
