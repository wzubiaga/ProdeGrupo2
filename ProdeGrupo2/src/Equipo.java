public class Equipo {

    private int id;
    private String nombre;
    private String descripcion;

    public Equipo(int id,String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    public int getId() {return id;}
    public String getNombre() { return nombre; }
    public String getDescripcion() {return descripcion; }

    public boolean equals(Equipo e) {
        if ((e.getNombre()==this.getNombre())&&(e.getDescripcion()==this.getDescripcion())) return true;
        return  false;
    }

}
