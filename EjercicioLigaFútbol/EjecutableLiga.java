package Entregas.OrientadoAObjetos.EjercicioLigaFútbol;

import Entregas.OrientadoAObjetos.Ejercicio4Mapas.Jugador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EjecutableLiga {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Liga>ligas = new ArrayList<Liga>();

        ArrayList<Jugadores> jugadoresMadrid = new ArrayList<>();
        ArrayList<Jugadores> jugadoresBarsa = new ArrayList<>();
        ArrayList<Jugadores> jugadoresMallorca = new ArrayList<>();
        ArrayList<Jugadores> jugadoresAtleti = new ArrayList<>();
        ArrayList<Jugadores> jugadoresGetafe = new ArrayList<>();
        ArrayList<Jugadores> jugadoresTotenham = new ArrayList<>();
        ArrayList<Jugadores> jugadoresArsenal = new ArrayList<>();
        ArrayList<Jugadores> jugadoresCity = new ArrayList<>();
        ArrayList<Jugadores> jugadoresLiverpool = new ArrayList<>();
        ArrayList<Jugadores> jugadoresChelsea = new ArrayList<>();

        ArrayList<Equipo> equiposEsp = new ArrayList<>();
        ArrayList<Equipo> equiposIng = new ArrayList<>();
        //Equipos Españoles
        Equipo a = new Equipo("Madrid", "Blanco", "Ancelloti", "Santiago Bernabeu", 0, 0, 0, jugadoresMadrid);
        Equipo b = new Equipo("Atleti", "Blanco", "Ancelloti", "Santiago Bernabeu", 0, 0, 0, jugadoresAtleti);
        Equipo c = new Equipo("Barsa", "Blanco", "Ancelloti", "Santiago Bernabeu", 0, 0, 0, jugadoresBarsa);
        Equipo d = new Equipo("Getafe", "Blanco", "Ancelloti", "Santiago Bernabeu", 0, 0, 0, jugadoresGetafe);
        equiposEsp.add(a);
        equiposEsp.add(b);
        equiposEsp.add(c);
        equiposEsp.add(d);
        Jugadores aaa = new Jugadores("Madrid", "Blanco", "Ancellotti", "Santiago Bernabeu", 0,0,0,jugadoresMadrid, "Bellingham", "Centrocampista", 15);
        Jugadores bbb = new Jugadores("Madrid", "Vinicius Jr", "Delantero", 12);
        Jugadores ccc = new Jugadores("Getafe", "Mayoral", "Delantero", 14);

        jugadoresMadrid.add(aaa);
        jugadoresMadrid.add(bbb);
        jugadoresGetafe.add(ccc);
        //Equipos Ingleses
        Equipo e = new Equipo("Manchester City", "Blanco", "Ancelloti", "Santiago Bernabeu", 0, 0, 0, jugadoresCity);
        Equipo f = new Equipo("Chelsea", "Blanco", "Ancelloti", "Santiago Bernabeu", 0, 0, 0, jugadoresChelsea);
        Equipo g = new Equipo("Arsenal", "Blanco", "Ancelloti", "Santiago Bernabeu", 0, 0, 0, jugadoresArsenal);
        Equipo h = new Equipo("Liverpool", "Blanco", "Ancelloti", "Santiago Bernabeu", 0, 0, 0, jugadoresLiverpool);
        Equipo i = new Equipo("Totenham", "Rojo", "Gallardo", "Cartuja", 0, 0, 0, jugadoresTotenham);
        equiposIng.add(e);
        equiposIng.add(f);
        equiposIng.add(g);
        equiposIng.add(h);
        equiposIng.add(i);
        Jugadores ddd = new Jugadores("Liverpool", "Salah", "Delantero", 15);

        jugadoresTotenham.add(ddd);
        Liga aa = new Liga("Liga EA", "España", "Primera", equiposEsp);
        Liga bb = new Liga("Premier", "Inglaterra", "Primera", equiposIng);

        aa.addResultado("Madrid", 2, "Barsa", 1);
        aa.addResultado("Mallorca", 3, "Getafe", 3);
        aa.addResultado("Atleti", 3, "Getafe", 4);
        aa.addResultado("Madrid", 2, "Mallorca", 0);

        bb.addResultado("Chelsea", 2, "Totenham", 0);
        bb.addResultado("Chelsea", 1, "Liverpool", 1);
        bb.addResultado("Manchester City", 2, "Arsenal", 0);
        bb.addResultado("Chelsea", 2, "Arsenal", 4);


        ligas.add(aa);
        ligas.add(bb);
        System.out.println("------Bienvenido a la nueva aplicación de deporte Total (Beta)------");

        menu(sc, ligas, a, aa);

    }

    public static void menu(Scanner sc, ArrayList<Liga>ligas, Equipo a, Liga aa) {
        do {


            int numMenu;

            System.out.println("MENU PRINCIPAL DEPORTE (BETA)");
            System.out.println("Pulsa 1 para ver la clasificación de diferentes ligas");
            System.out.println("Pulsa 2 para ver la lista de jugadores de cada equipo");
            System.out.println("Pulsa 3 para el máximo goleador del equipo que quieras");
            System.out.println("Pulsa 4 para el máximo goleador de la liga que quieras"); //Hacer bien
            System.out.println("Pulsa 5 para insertar un nuevo partido");
            System.out.println("Pulsa 6 para ingresar un nuevo equipo en una liga");
            System.out.println("Pulsa 7 para ingresar un nuevo jugador");
            System.out.println("Pulsa 8 para elegir el equipo que ver estadisticas"); //Acabar con diferentes ligas
            System.out.println("Pulsa 9 para saber la media de goles por partido que hay en cada Liga"); //Acabar con diferentes ligas
            System.out.println("Pulsa 10 para insertar un fichaje entre dos clubes de la Liga"); //Acabar con diferentes ligas
            System.out.println("Pulsa 11 para salir");
            numMenu = Integer.parseInt(sc.nextLine());
            if (numMenu == 1) {
                clasificacionLiga(ligas, sc);
            } else if (numMenu == 3) {
                String equipo;
                System.out.println("Que equipo quieres ver su máximo goleador: ");
                equipo = sc.nextLine();
                for (Liga lig: ligas) {
                    for (Equipo eqip: lig.getArrayeq()) {
                        if (equipo.equalsIgnoreCase(eqip.getNombre())){
                            System.out.println("El máximo goleadore del " + eqip.getNombre() + " es " + eqip.getMaximoGoleador().getNombre() +
                            " y lleva " + eqip.getMaximoGoleador().getGoles() + " goles");
                        }
                    }

                }

                System.out.println("--------------------------------");
            } else if (numMenu == 2) {
                mostrarJugadores(ligas, sc);
            } else if (numMenu == 5) {
                insertarPartido(sc, ligas);
            } else if (numMenu == 4) {
                System.out.println(aa.getMaximoGoleadorLiga());
                System.out.println("--------------------------------");
            } else if (numMenu == 11) {
                break;
            }else if (numMenu == 6) {
                ingresarEquipo(sc, ligas);
            }else if (numMenu == 7){
                crearJugador(sc,ligas);
            } else if (numMenu == 8) {
                verStats(sc, aa);
            } else if (numMenu == 9) {
                mediaGolesPartido(aa,sc);
            } else if (numMenu == 10) {
                fichaje(sc, aa);
            }

        } while (true);
    }

    public static void clasificacionLiga(ArrayList<Liga>ligas, Scanner sc) {
        String pais;
        System.out.println("Selecciona un país para ver su clasificación: ");
        pais = sc.nextLine();

        for (Liga clasi: ligas) {
            if (pais.equalsIgnoreCase(clasi.getPais())){
                int contador = 1;

                Collections.sort(clasi.getArrayeq());
                for (Equipo equipos : clasi.getArrayeq()) {
                    System.out.println(contador + ". " + equipos.getNombre() + " " + equipos.getPuntos() + " pts");
                    contador++;
                }
                System.out.println("------------------------------");
            }

        }



    }

    public static void mostrarJugadores(ArrayList<Liga>ligas, Scanner sc) {

        String pais;
        System.out.println("De que pais quieres ver los jugadores: ");
        pais = sc.nextLine();

        for (Liga jugas: ligas) {
            if (pais.equalsIgnoreCase(jugas.getPais())){
                for (Equipo equipos : jugas.getArrayeq()) {
                    System.out.println("Jugadores " + equipos.getNombre());
                    System.out.println("-------------------------------");
                    for (Jugadores juga:equipos.getArrayjug()) {
                        System.out.println(juga.getNombre());
                    }
                    System.out.println(equipos.getArrayjug());
                    System.out.println("-------------------------------");

                }
            }

        }



    }

    public static void insertarPartido(Scanner sc, ArrayList<Liga>ligas) {

        String pais;
        System.out.println("De que pais quieres añadir un resultado: ");
        pais = sc.nextLine();
        for (Liga jugas: ligas) {
            if (pais.equalsIgnoreCase(jugas.getPais())) {
                String resultado;
                System.out.println("Has elegido introducir un nuevo resultado " + jugas.getNombre());
                System.out.println("Introduce el resultado en este formato (Local 0 Visitante 0)");
                resultado = sc.nextLine();
                String[] resultados = resultado.split(" ");
                String equipoa = resultados[0];
                int golesa = Integer.parseInt(resultados[1]);
                String equipob = resultados[2];
                int golesb = Integer.parseInt(resultados[3]);

                jugas.addResultado(equipoa, golesa, equipob, golesb);
                System.out.println("Resultado añadido....................");
            }
        }

    }

    public static void ingresarEquipo(Scanner sc, ArrayList<Liga> ligas){
        String nombreEquipo;
        int puntosIni;
        String pais;
        System.out.println("---------Has elegido ingresar un nuevo equipo----------------");
        System.out.println("Dame el nombre del equipo");
        nombreEquipo = sc.nextLine();
        System.out.println("A que país quieres enviar este equipo? ");
        pais = sc.nextLine();
        for (Liga ligues:ligas) {
            if (ligues.getPais().equalsIgnoreCase(pais)){
                Equipo nuevos = new Equipo (nombreEquipo);
                System.out.println("Con cuantos puntos quieres que comience la liga el equipo");
                puntosIni = Integer.parseInt(sc.nextLine());
                nuevos.setPuntos(puntosIni);
                ligues.addEquipo(nuevos);
                System.out.println("Equipo añadido a la liga......................");
            }
        }



    }


    public static void crearJugador(Scanner sc, ArrayList<Liga>ligas){
        String nombreEq, nombreJug, posicion;
        int goles;
        System.out.println("Has elegido insertar un jugador");
        System.out.println("Cual es el nombre del jugador");
        nombreJug = sc.nextLine();
        System.out.println("En que equipo juega");
        nombreEq = sc.nextLine();

        for (Liga lig: ligas) {

            for (Equipo equipos: lig.getArrayeq()) {
                if (nombreEq.equalsIgnoreCase(equipos.getNombre())){
                    System.out.println("En que posición juega");
                    posicion = sc.nextLine();
                    System.out.println("Cuantos goles ha metido");
                    goles = Integer.parseInt(sc.nextLine());
                    Jugadores nuevo = new Jugadores(nombreEq,nombreJug,posicion,goles);
                    equipos.addJugador(nuevo);

                }
            }

        }
    }

    //Acabar
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


    //Acabar
    public static void mediaGolesPartido (Liga aa, Scanner sc){

        System.out.println("Has elegido ver la media de goles por partido de las diferentes ligas");
        System.out.println("La media de goles por partido de la Liga es de " + aa.getMediaGolesPartido() + " goles por partido");

    }


    //Acabar

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
