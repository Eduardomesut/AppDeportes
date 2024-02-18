package Entregas.OrientadoAObjetos.EjercicioLigaFútbol;


import Entregas.OrientadoAObjetos.Ejercicio9Mapas.Persona;

import java.util.ArrayList;

public class Liga {

    private String nombre;
    private String pais;
    private String division;
    private int partidosJugadosLiga = 0;
    private int golesTotalesLiga = 0;


    private ArrayList <Equipo> arrayeq = new ArrayList<Equipo>();




    public void addEquipo(Equipo p){

        this.arrayeq.add(p);
    }

    public void addResultado(String equipoa, int golesA, String equipob, int golesB){

        for (Equipo team:getArrayeq()) {
            if (team.getNombre().equalsIgnoreCase(equipoa)){
                if (golesA > golesB){
                    team.setPuntos(team.getPuntos() + 3);
                }if (golesA == golesB) {
                    team.setPuntos(team.getPuntos() + 1);

                }
                team.setGolesFavor(team.getGolesFavor() + golesA);
                team.setGolesContra(team.getGolesContra() + golesB);
                team.setPartidosJugados(team.getPartidosJugados() + 1);
                this.setPartidosJugadosLiga(this.partidosJugadosLiga + 1);
                this.setGolesTotalesLiga(this.getGolesTotalesLiga() + golesA + golesB);
            }
            if (team.getNombre().equalsIgnoreCase(equipob)){
                if (golesA < golesB){
                    team.setPuntos(team.getPuntos() + 3);
                }if (golesA == golesB) {
                    team.setPuntos(team.getPuntos() + 1);
                }
                team.setGolesFavor(team.getGolesFavor() + golesB);
                team.setGolesContra(team.getGolesContra() + golesA);
                team.setPartidosJugados(team.getPartidosJugados() + 1);

            }
            
            
        }

    }

    public Liga(String nombre, String pais, String division, ArrayList<Equipo> arrayeq) {
        this.nombre = nombre;
        this.pais = pais;
        this.division = division;
        this.arrayeq = arrayeq;
    }

    @Override
    public String toString() {
        return "Liga{" +
                "nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                ", division='" + division + '\'' +
                ", arrayeq=" + arrayeq +
                '}';
    }
    
    public Jugadores getMaximoGoleadorLiga(){
        
        Jugadores max = new Jugadores("", "","",0);
        for (Equipo equipos : arrayeq) {
            if (equipos.getMaximoGoleador().getGoles() > max.getGoles()) {
                max = equipos.getMaximoGoleador();
                
            }
            
        }
        
        return max;       
    }

    public double getMediaGolesPartido(){
        double mediaGoles = 0;

        mediaGoles = this.getGolesTotalesLiga() / (double)this.getPartidosJugadosLiga();

        return  mediaGoles;
    }

    public int getPartidosJugadosLiga() {
        return partidosJugadosLiga;
    }

    public void setPartidosJugadosLiga(int partidosJugadosLiga) {
        this.partidosJugadosLiga = partidosJugadosLiga;
    }

    public int getGolesTotalesLiga() {
        return golesTotalesLiga;
    }

    public void setGolesTotalesLiga(int golesTotalesLiga) {
        this.golesTotalesLiga = golesTotalesLiga;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public ArrayList<Equipo> getArrayeq() {
        return arrayeq;
    }

    public void setArrayeq(ArrayList<Equipo> arrayeq) {
        this.arrayeq = arrayeq;
    }
}
