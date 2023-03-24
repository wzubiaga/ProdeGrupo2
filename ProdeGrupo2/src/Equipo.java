public class Equipo {
    private String nombreEquipo;
    private String descripcionEquipo;

    public Equipo(String nombre, String descripcion) {
        this.nombreEquipo = nombre;
        this.descripcionEquipo = descripcion;
    }

    public String nombre() { return nombreEquipo; }
    public String descripcion() {return  descripcionEquipo; }

    public boolean equals(Equipo e) {
        if ((e.nombre()==this.nombre())&&(e.descripcion()==this.descripcion())) return true;
        return  false;
    }

}
