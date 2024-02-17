package Entregas.OrientadoAObjetos.EjercicioLigaFútbol;

import java.util.ArrayList;

public class Jugadores extends Equipo{

private String nombre;
private String posicion;

private int goles;


    public Jugadores(String nombre, String colores, String nombreEntrenador, String nombreEstadio, int puntos, int golesFavor, int golesContra, ArrayList<Jugadores> arrayjug, String nombre1, String posicion, int goles) {
        super(nombre, colores, nombreEntrenador, nombreEstadio, puntos, golesFavor, golesContra, arrayjug);
        this.nombre = nombre1;
        this.posicion = posicion;
        this.goles = goles;
    }
    public Jugadores(String nombre, String nombre1, String posicion, int goles){
        super(nombre);
        this.nombre = nombre1;
        this.posicion = posicion;
        this.goles = goles;

    }


    @Override
    public String toString() {
        return "Jugadores{" +
                "nombre='" + nombre + '\'' +
                ", posicion='" + posicion + '\'' +
                ", goles=" + goles +
                '}';
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
