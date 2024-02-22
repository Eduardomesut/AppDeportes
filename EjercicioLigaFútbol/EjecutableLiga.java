package Entregas.OrientadoAObjetos.EjercicioLigaFútbol;

import Entregas.OrientadoAObjetos.Ejercicio4Mapas.Jugador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EjecutableLiga {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //Hacer menú y meter en las clases la mayoria de cosas posibles y aqui solo poner texto
        //Añadir jugadores a equipos, decir maximos goleadores de cada equipo y de la liga completa
        // Mas cosas que se me ocurran
        ArrayList<Jugadores> jugadoresMadrid = new ArrayList<>();
        ArrayList<Jugadores> jugadoresBarsa = new ArrayList<>();
        ArrayList<Jugadores> jugadoresMallorca = new ArrayList<>();
        ArrayList<Jugadores> jugadoresAtleti = new ArrayList<>();
        ArrayList<Jugadores> jugadoresGetafe = new ArrayList<>();
        ArrayList<Equipo> equiposEsp = new ArrayList<>();
        Equipo a = new Equipo("Madrid", "Blanco", "Ancelloti", "Santiago Bernabeu", 0, 0, 0, jugadoresMadrid);
        Equipo b = new Equipo("Atleti", "Blanco", "Ancelloti", "Santiago Bernabeu", 0, 0, 0, jugadoresAtleti);
        Equipo c = new Equipo("Barsa", "Blanco", "Ancelloti", "Santiago Bernabeu", 0, 0, 0, jugadoresBarsa);
        Equipo d = new Equipo("Getafe", "Blanco", "Ancelloti", "Santiago Bernabeu", 0, 0, 0, jugadoresGetafe);
        equiposEsp.add(a);
        equiposEsp.add(b);
        equiposEsp.add(c);
        equiposEsp.add(d);
        Equipo e = new Equipo("Mallorca", "Rojo", "Gallardo", "Cartuja", 0, 0, 0, jugadoresMallorca);
        Liga aa = new Liga("Liga EA", "España", "Primera", equiposEsp);
        aa.addEquipo(e);
        aa.addResultado("Madrid", 2, "Barsa", 1);
        aa.addResultado("Mallorca", 3, "Getafe", 3);
        aa.addResultado("Atleti", 3, "Getafe", 4);
        aa.addResultado("Madrid", 2, "Mallorca", 0);

        Jugadores aaa = new Jugadores("Madrid", "Bellingham", "Centrocampista", 10);
        Jugadores bbb = new Jugadores("Madrid", "Vinicius Jr", "Delantero", 12);
        Jugadores ccc = new Jugadores("Getafe", "Mayoral", "Delantero", 14);

        a.addJugador(aaa);
        a.addJugador(bbb);
        d.addJugador(ccc);

        System.out.println("------Bienvenido a la nueva aplicación de deporte Total (Beta)------");

        menu(sc, aa, a);

    }

    public static void menu(Scanner sc, Liga aa, Equipo a) {
        do {

            //Insertar muchos más métodos en el menú pero hacerlos en las clases y en el ejecutable solo lo visual
            int numMenu;

            System.out.println("MENU PRINCIPAL DEPORTE (BETA)");
            System.out.println("Pulsa 1 para ver la clasificación de diferentes ligas (Liga EA)");
            System.out.println("Pulsa 2 para ver la lista de jugadores de cada equipo");
            System.out.println("Pulsa 3 para el máximo goleador del equipo que quieras");
            System.out.println("Pulsa 4 para el máximo goleador de la liga que quieras");
            System.out.println("Pulsa 5 para insertar un nuevo partido");
            System.out.println("Pulsa 6 para ingresar un nuevo equipo en una liga");
            System.out.println("Pulsa 7 para ingresar un nuevo jugador");
            System.out.println("Pulsa 8 para elegir el equipo que ver estadisticas");
            System.out.println("Pulsa 9 para saber la media de goles por partido que hay en cada Liga");
            System.out.println("Pulsa 10 para insertar un fichaje entre dos clubes de la Liga");
            System.out.println("Pulsa 11 para salir");
            numMenu = Integer.parseInt(sc.nextLine());
            if (numMenu == 1) {
                clasificacionLiga(aa);
            } else if (numMenu == 3) {
                System.out.println(a.getMaximoGoleador());
                System.out.println("--------------------------------");
            } else if (numMenu == 2) {
                mostrarJugadores(aa);
            } else if (numMenu == 5) {
                insertarPartido(sc, aa);
            } else if (numMenu == 4) {
                System.out.println(aa.getMaximoGoleadorLiga());
                System.out.println("--------------------------------");
            } else if (numMenu == 11) {
                break;
            }else if (numMenu == 6) {
                ingresarEquipo(sc, aa);
            }else if (numMenu == 7){
                crearJugador(sc,aa);
            } else if (numMenu == 8) {
                verStats(sc, aa);
            } else if (numMenu == 9) {
                mediaGolesPartido(aa,sc);
            } else if (numMenu == 10) {
                fichaje(sc, aa);
            }

        } while (true);
    }

    public static void clasificacionLiga(Liga aa) {
        int contador = 1;
        Collections.sort(aa.getArrayeq());
        for (Equipo equipos : aa.getArrayeq()) {
            System.out.println(contador + ". " + equipos.getNombre() + " " + equipos.getPuntos() + " pts");
            contador++;
        }
        System.out.println("------------------------------");

    }

    public static void mostrarJugadores(Liga aa) {

        for (Equipo equipos : aa.getArrayeq()) {
            System.out.println("Jugadores " + equipos.getNombre());
            System.out.println("-------------------------------");

            System.out.println(equipos.getArrayjug());
            System.out.println("-------------------------------");

        }

    }

    public static void insertarPartido(Scanner sc, Liga aa) {
        String resultado;
        System.out.println("Has elegido introducir un nuevo resultado (Liga EA)");
        System.out.println("Introduce el resultado en este formato (Local 0 Visitante 0)");
        resultado = sc.nextLine();
        String[] resultados = resultado.split(" ");
        String equipoa = resultados[0];
        int golesa = Integer.parseInt(resultados[1]);
        String equipob = resultados[2];
        int golesb = Integer.parseInt(resultados[3]);

        aa.addResultado(equipoa, golesa, equipob, golesb);
        System.out.println("Resultado añadido....................");

    }
    
    public static void ingresarEquipo(Scanner sc, Liga aa){
        String nombreEquipo;
        int puntosIni;
        System.out.println("---------Has elegido ingresar un nuevo equipo----------------");
        System.out.println("Dame el nombre del equipo");
        nombreEquipo = sc.nextLine();
        Equipo nuevos = new Equipo (nombreEquipo);
        System.out.println("Con cuantos puntos quieres que comience la liga el equipo");
        puntosIni = Integer.parseInt(sc.nextLine());
        nuevos.setPuntos(puntosIni);
        aa.addEquipo(nuevos);
        System.out.println("Equipo añadido a la liga......................");

    }
    public static void crearJugador(Scanner sc, Liga aa){
        String nombreEq, nombreJug, posicion;
        int goles;
        System.out.println("Has elegido insertar un jugador");
        System.out.println("Cual es el nombre del jugador");
        nombreJug = sc.nextLine();
        System.out.println("En que equipo juega");
        nombreEq = sc.nextLine();
        System.out.println("En que posición juega");
        posicion = sc.nextLine();
        System.out.println("Cuantos goles ha metido");
        goles = Integer.parseInt(sc.nextLine());
        Jugadores nuevo = new Jugadores(nombreEq,nombreJug,posicion,goles);
        for (Equipo equipos:aa.getArrayeq()) {

            if (equipos.getNombre().equalsIgnoreCase(nombreEq)){
                equipos.addJugador(nuevo);
            }
        }

    }

    public static void verStats (Scanner sc, Liga aa){
        String equipo;
        int respuesta;
        System.out.println("Has elegido ver estadísticas detalladas de un equipo");
        System.out.println("Elige un equipo:");
        equipo = sc.nextLine();
        for (Equipo equipos:aa.getArrayeq()) {
            if (equipo.equalsIgnoreCase(equipos.getNombre())){

                System.out.println("Has elegido las estadisticas detalladas del " + equipos.getNombre());
                System.out.println("Que estadistica desea ver: 1. Partidos Jugados, 2. Goles a favor ..........");
                respuesta = Integer.parseInt(sc.nextLine());
                if (respuesta == 1){
                    System.out.println("El " + equipos.getNombre() + " ha jugado " + equipos.getPartidosJugados() + " partidos esta Liga");
                }else if (respuesta == 2) {
                    System.out.println("El" + equipos.getNombre() + "ha marcado " + equipos.getGolesFavor() + " goles a favor esta temporada");
                }else if (respuesta == 3) {
                    System.out.println("Se han jugado " + aa.getPartidosJugadosLiga() + " partidos en esta liga");
                    
                }

            }

        }
    }

    public static void mediaGolesPartido (Liga aa, Scanner sc){

        System.out.println("Has elegido ver la media de goles por partido de las diferentes ligas");
        System.out.println("La media de goles por partido de la Liga es de " + aa.getMediaGolesPartido() + " goles por partido");

    }

    public static void fichaje (Scanner sc,Liga aa){
        String nombre;

        String equipoCompra;
        System.out.println("Has seleccionado traspasar un jugador de un equipo a otro");
        System.out.println("Selecciona el nombre del jugador a traspasar: ");
        nombre = sc.nextLine();
        Jugadores nuevo = new Jugadores(null,null,null,0);

        for (Equipo equipos:aa.getArrayeq()) {
            for (Jugadores jugador:equipos.getArrayjug()) {
                if (jugador.getNombre().equalsIgnoreCase(nombre)){

                    System.out.println("A que equipo quieres traspasar a "+ jugador.getNombre() + " proveniente del " + equipos.getNombre());
                    nuevo = jugador;
                    equipos.getArrayjug().remove(jugador);

                }
            }
        }

        equipoCompra = sc.nextLine();
        for (Equipo equipos: aa.getArrayeq()) {
            if (equipos.getNombre().equalsIgnoreCase(equipoCompra)){
                equipos.getArrayjug().add(nuevo);
                System.out.println("Has añadido correctamente a "+ nuevo.getNombre() + " al " + equipos.getNombre());
            }
        }
    }
}
