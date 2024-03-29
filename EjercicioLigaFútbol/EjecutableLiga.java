package Entregas.OrientadoAObjetos.EjercicioLigaFútbol;

import Entregas.OrientadoAObjetos.Ejercicio4Mapas.Jugador;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EjecutableLiga {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Liga>ligas = new ArrayList<Liga>();



        ArrayList<Equipo> equiposEsp = new ArrayList<>();
        ArrayList<Equipo> equiposIng = new ArrayList<>();

        Liga aa = new Liga("Liga EA", "España", "Primera", equiposEsp);
        Liga bb = new Liga("Premier", "Inglaterra", "Primera", equiposIng);

        ligas.add(aa);
        ligas.add(bb);

        //Datos Equipos
        Equipo nuevo;
        String[] datos;
        try(Scanner scFile = new Scanner(new File("C:\\Users\\Eduardo\\Desktop\\Principal\\Programación\\OrientadoAObjetos\\EjercicioLigaFútbol\\Datos.csv"))){
            while (scFile.hasNextLine()){
            datos = scFile.nextLine().split(",");
            ArrayList<Jugadores>nuevos = new ArrayList<>();

            nuevo = new Equipo(datos[0], datos[1],datos[2],datos[3],Integer.parseInt(datos[4]), Integer.parseInt(datos[5]),Integer.parseInt(datos[6]),nuevos);
            if (datos[2].equalsIgnoreCase("España")){
                equiposEsp.add(nuevo);

            }
            if (datos[2].equalsIgnoreCase("Inglaterra")) {
                equiposIng.add(nuevo);
            }
            }

        }catch (Exception e){
            System.out.println("Error");
        }

        //Datos jugadores

        Jugadores nuevos;
        String [] dato;
        Jugadores jugador;
        try(Scanner scFile = new Scanner(new File("C:\\Users\\Eduardo\\Desktop\\Principal\\Programación\\OrientadoAObjetos\\EjercicioLigaFútbol\\MeterJugadores.csv"))){
            while (scFile.hasNextLine()){
                dato = scFile.nextLine().split(",");
                jugador = new Jugadores(dato[0], dato[1],dato[2],Integer.parseInt(dato[3]));

                for (Liga leagues:ligas) {
                    for (Equipo equ:leagues.getArrayeq()) {
                        if (equ.getNombre().equalsIgnoreCase(dato[0])){
                            equ.addJugador(jugador);

                        }
                    }
                }


            }
        }catch (Exception e){
            System.out.println("Error");
        }

        System.out.println("------Bienvenido a la nueva aplicación de deporte Total (Beta)------");

        menu(sc, ligas);

    }

    public static void menu(Scanner sc, ArrayList<Liga>ligas) {
        do {


            int numMenu;

            System.out.println("MENU PRINCIPAL DEPORTE (BETA)");
            System.out.println("Pulsa 1 para ver la clasificación de diferentes ligas");
            System.out.println("Pulsa 2 para ver la lista de jugadores de cada equipo");
            System.out.println("Pulsa 3 para el máximo goleador del equipo que quieras");
            System.out.println("Pulsa 4 para el máximo goleador de las ligas");
            System.out.println("Pulsa 5 para insertar un nuevo partido");
            System.out.println("Pulsa 6 para ingresar un nuevo equipo en una liga");
            System.out.println("Pulsa 7 para ingresar un nuevo jugador");
            System.out.println("Pulsa 8 para elegir el equipo que ver estadisticas");
            System.out.println("Pulsa 9 para saber la media de goles por partido que hay en cada Liga");
            System.out.println("Pulsa 10 para insertar un fichaje entre dos clubes de la Liga");
            System.out.println("Pulsa 11 para elegir un equipo que ver su valor total de jugadores");
            System.out.println("Pulsa 12 para salir");
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
                Jugadores bota = new Jugadores(null, null, null, 0);
                for (Liga lig:ligas) {
                    System.out.println("Máximo goleador liga " + lig.getNombre() + "(" + lig.getPais() + "): "
                            + lig.getMaximoGoleadorLiga().getNombre() + ", " + lig.getMaximoGoleadorLiga().getGoles() + " goles");
                    System.out.println("--------------------------------");
                    if (lig.getMaximoGoleadorLiga().getGoles() > bota.getGoles()){
                        bota = lig.getMaximoGoleadorLiga();
                    }
                }
                System.out.println("Y la bota de oro de las ligas europeas es " + bota.getNombre() +" con "+bota.getGoles() + " goles");
                System.out.println("--------------------------------");
            } else if (numMenu == 12) {
                break;
            }else if (numMenu == 6) {
                ingresarEquipo(sc, ligas);
            }else if (numMenu == 7){
                crearJugador(sc,ligas);
            } else if (numMenu == 8) {
                verStats(sc, ligas);
            } else if (numMenu == 9) {
                mediaGolesPartido(ligas,sc);
            } else if (numMenu == 10) {
                fichaje(sc, ligas);
            } else if (numMenu == 11) {
                verValorEquipo(sc, ligas);
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
                    System.out.println(contador + ". " + equipos.getNombre() + " " + equipos.getPuntos() + " pts " +
                            equipos.getGolesFavor() + " goles a favor y " + equipos.getGolesContra() + " goles en contra");
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
        double valor;
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
                    System.out.println("Cual es su valor de mercado en millones");
                    valor = Double.parseDouble(sc.nextLine());
                    nuevo.setValorMercado(valor);
                    equipos.addJugador(nuevo);

                }
            }

        }
    }


    public static void verStats (Scanner sc, ArrayList<Liga>ligas){
        String equipo;
        int respuesta;
        System.out.println("Has elegido ver estadísticas detalladas de un equipo");
        System.out.println("Elige un equipo:");

        equipo = sc.nextLine();
        for (Liga lig:ligas) {

            for (Equipo equipos:lig.getArrayeq()) {
                if (equipo.equalsIgnoreCase(equipos.getNombre())){

                    System.out.println("Has elegido las estadisticas detalladas del " + equipos.getNombre());
                    System.out.println("Que estadistica desea ver: 1. Partidos Jugados, 2. Goles a favor ..........");
                    respuesta = Integer.parseInt(sc.nextLine());
                    if (respuesta == 1){
                        System.out.println("El " + equipos.getNombre() + " ha jugado " + equipos.getPartidosJugados() + " partidos esta Liga");
                    }else if (respuesta == 2) {
                        System.out.println("El" + equipos.getNombre() + "ha marcado " + equipos.getGolesFavor() + " goles a favor esta temporada");
                    }else if (respuesta == 3) {
                        System.out.println("Se han jugado " + lig.getPartidosJugadosLiga() + " partidos en esta liga");

                    }

                }

            }

        }

    }

    public static void mediaGolesPartido (ArrayList<Liga> ligas, Scanner sc){

        System.out.println("Has elegido ver la media de goles por partido de las diferentes ligas");
        for (Liga lig:ligas) {
            System.out.println("La media de goles por partido de la liga " + lig.getNombre() + " es de " + lig.getMediaGolesPartido() + " goles por partido");
        }


    }

    public static void fichaje (Scanner sc,ArrayList<Liga>ligas){
        String nombre;

        String equipoCompra;
        System.out.println("Has seleccionado traspasar un jugador de un equipo a otro");
        System.out.println("Selecciona el nombre del jugador a traspasar: ");
        nombre = sc.nextLine();
        Jugadores nuevo = new Jugadores(null,null,null,0);
        for (Liga lig:ligas) {
            for (Equipo equipos:lig.getArrayeq()) {
                for (int i = 0; i < equipos.getArrayjug().size(); i++) {
                    if (equipos.getArrayjug().get(i).getNombre().equalsIgnoreCase(nombre)){
                        System.out.println("A que equipo quieres traspasar a "+ equipos.getArrayjug().get(i).getNombre() + " proveniente del " + equipos.getNombre());
                        nuevo = equipos.getArrayjug().get(i);
                        equipos.getArrayjug().remove(equipos.getArrayjug().get(i));
                        i--;
                    }
                }
            }


        }
        equipoCompra = sc.nextLine();
        for (Liga lig:ligas) {
            for (Equipo equipos: lig.getArrayeq()) {
                if (equipos.getNombre().equalsIgnoreCase(equipoCompra)){
                    equipos.getArrayjug().add(nuevo);
                    System.out.println("Has añadido correctamente a "+ nuevo.getNombre() + " al " + equipos.getNombre());
                }
            }

        }

    }

    public static void verValorEquipo (Scanner sc, ArrayList<Liga>ligas){
        String equipo;
        System.out.println("Elige un equipo para ver su valor de todos sus jugadores");
        equipo = sc.nextLine();
        for (Liga lig:ligas) {
            for (Equipo equipos: lig.getArrayeq()) {
                if (equipo.equalsIgnoreCase(equipos.getNombre())){
                    System.out.println("El valor todal de los jugadores del " + equipos.getNombre() + " son: " + equipos.valorEquipo() + " millones de euros");
                }
            }
        }
    }
}
