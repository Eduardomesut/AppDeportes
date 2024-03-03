package Entregas.OrientadoAObjetos.EjercicioLigaFútbol;

import Entregas.OrientadoAObjetos.Ejercicio4Mapas.Jugador;

import java.util.ArrayList;

public class Equipo implements Comparable{

    private String nombre;
    private String colores;

    private int partidosJugados;
    private String nombreEntrenador;
    private String nombreEstadio;
    private int puntos;
    private int golesFavor;
    private int golesContra;
    private ArrayList<Jugadores> arrayjug = new ArrayList<>();

    public Equipo(String nombre, String colores, String nombreEntrenador, String nombreEstadio, int puntos, int golesFavor, int golesContra, ArrayList<Jugadores> arrayjug) {
        this.nombre = nombre;
        this.colores = colores;
        this.nombreEntrenador = nombreEntrenador;
        this.nombreEstadio = nombreEstadio;
        this.puntos = puntos;
        this.golesFavor = golesFavor;
        this.golesContra = golesContra;
        this.arrayjug = arrayjug;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public Equipo(String nombre) {
        this.nombre = nombre;
    }

    public void addJugador(Jugadores p){

        this.arrayjug.add(p);
    }



    @Override
    public String toString() {
        return "Equipo{" +
                "nombre='" + nombre + '\'' +
                ", colores='" + colores + '\'' +
                ", nombreEntrenador='" + nombreEntrenador + '\'' +
                ", nombreEstadio='" + nombreEstadio + '\'' +
                ", puntos=" + puntos +
                ", golesFavor=" + golesFavor +
                ", golesContra=" + golesContra +
                '}';
    }

    public ArrayList<Jugadores> getArrayjug() {
        return arrayjug;
    }
    
    public Jugadores getMaximoGoleador(){
        
        Jugadores max = new Jugadores("", "","",0);
        for (Jugadores jugadores : arrayjug) {
            if (jugadores.getGoles() > max.getGoles()) {
                max = jugadores;
            }
            
        }
        
        return max;       
    }

    public double valorEquipo(){
        double sumaValor = 0;
        for (Jugadores jug: arrayjug) {
            sumaValor += jug.getValorMercado();
        }
        return sumaValor;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColores() {
        return colores;
    }

    public void setColores(String colores) {
        this.colores = colores;
    }

    public String getNombreEntrenador() {
        return nombreEntrenador;
    }

    public void setNombreEntrenador(String nombreEntrenador) {
        this.nombreEntrenador = nombreEntrenador;
    }

    public String getNombreEstadio() {
        return nombreEstadio;
    }

    public void setNombreEstadio(String nombreEstadio) {
        this.nombreEstadio = nombreEstadio;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getGolesFavor() {
        return golesFavor;
    }

    public void setGolesFavor(int golesFavor) {
        this.golesFavor = golesFavor;
    }

    public int getGolesContra() {
        return golesContra;
    }

    public void setGolesContra(int golesContra) {
        this.golesContra = golesContra;
    }

    @Override
    public int compareTo(Object o) {
        Equipo otro = (Equipo) o;
        return otro.puntos - this.puntos;
    }
}
