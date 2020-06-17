package View;

import Controller.AppController;
import Model.Personaje;
import Model.Enemigo;
import Repositories.RepositoryEnemigo;
import Repositories.RepositoryPersonaje;
import java.util.Scanner;
import java.util.List;
import java.util.Set;

/**
 *
 * @author educa
 */
public class GUI {

    static AppController controller = new AppController();
    static Model.Enemigo enemigo = new Enemigo();
    static Model.Personaje personaje = new Personaje();

    public static void logo() {
        System.out.println("_   _ _   _____ ___ __  __    _  _____ _____   _____ ___ ____ _   _ _____ _____ ____  ");
        System.out.println("| | | | | |_   _|_ _|  \\/  |  / \\|_   _| ____| |  ___|_ _/ ___| | | |_   _| ____|  _ \\ ");
        System.out.println("| | | | |   | |  | || |\\/| | / _ \\ | | |  _|   | |_   | | |  _| |_| | | | |  _| | |_) |");
        System.out.println("| | | | |   | |  | || |\\/| | / _ \\ | | |  _|   | |_   | | |  _| |_| | | | |  _| | |_) |");
        System.out.println("| |_| | |___| |  | || |  | |/ ___ \\| | | |___  |  _|  | | |_| |  _  | | | | |___|  _ < ");
        System.out.println("\\___/|_____|_| |___|_|  |_/_/   \\_\\_| |_____| |_|   |___\\____|_| |_| |_| |_____|_| \\_\\");
    }

    public static void menu() {
        logo();
        if (controller.loadAllDDBB()) {
            System.out.println("Base de datos cargada");
        } else {
            System.out.println("Error en la base de datos");
        }

        int numero;

        do {
            System.out.println("        Menu Principal    ");
            System.out.println("                    ");
            System.out.println(" 1) Menu Personajes");
            System.out.println(" 2) Menu Enemigos");
            System.out.println(" 3) Luchar");
            System.out.println(" 0) Salir ");
            Scanner teclado = new Scanner(System.in);
            System.out.println("Introduce una opción: ");
            numero = teclado.nextInt();
            opciones(numero);
        } while (numero != 0);
    }

    static void opciones(int numero) {
        switch (numero) {
            case 0:
                if (controller.saveAllDDBB()) {
                    System.out.println("Base de datos guardada correctamente");
                } else {
                    System.out.println("La base de datos no se ha guardado");
                }
                System.out.println("Te esperamos pronto");

                break;

            case 1:
                menu_Personaje();
                break;

            case 2:
                menu_Enemigo();
                break;
            case 3:
                
                
                
                
                
                
            System.out.println("\n+----------------------------+" );    
            System.out.println("|    Personaje:"+personaje.getNombre()+ "          |"  );
            System.out.println("+----------------------------+" );
            System.out.println("| Vida: "+personaje.getVida()+"                    |");
            System.out.println("| Ataque: "+personaje.getAtaque()+"                  |");
            System.out.println("| Defensa: "+personaje.getDefensa()+"                 |");          
            System.out.println("+----------------------------+"  );
             System.out.println("");
             System.out.println("_    __ ");   
             System.out.println("| |  / /____");
             System.out.println("| | / / ___/");
             System.out.println("| |/ (__  )"); 
             System.out.println("|___/____/");
            System.out.println("");    
            System.out.println("\n+----------------------------+" );    
            System.out.println("|    Personaje:"+enemigo.getNombre()+ "          |"  );
            System.out.println("+----------------------------+" );
            System.out.println("| Vida: "+enemigo.getVida()+"                    |");
            System.out.println("| Ataque: "+enemigo.getAtaque()+"                  |");
            System.out.println("| Defensa: "+enemigo.getDefensa()+"                 |");          
            System.out.println("+----------------------------+"  );

            pulsarEnter();
                System.out.println("");
            
                int total_Personaje = personaje.getVida() + personaje.getDefensa() + personaje.getAtaque();
                int total_Enemigo = enemigo.getVida() + enemigo.getDefensa() + enemigo.getAtaque();

                if (total_Personaje > total_Enemigo) {
                    System.out.println("El Personaje " + personaje.getNombre() + " ha ganado el duelo");
                    enemigo = null;
                } else if (total_Enemigo > total_Personaje) {
                    System.out.println("El Enemigo " + enemigo.getNombre() + " ha ganado el duelo");
                    personaje = null;
                } else {
                    System.out.println("Empate, Toca mejorar.");
                }
        }
    }

    static void crear_personaje() {

        System.out.println("    Creacion de personaje    ");

        int codigo = devolverInt("Introduce el codigo del personaje: ");
        personaje.setCodigo(codigo);
        String nombre = devolverString("Introduce el nombre del personaje: ");
        personaje.setNombre(nombre);

        int vida = personaje.generarVida();
        System.out.println("Tu vida es :" + vida);
        personaje.setVida(vida);

        int ataque = personaje.generarAtaque();
        System.out.println("Tu ataque es :" + ataque);
        personaje.setAtaque(ataque);

        int defensa = personaje.generarDefensa();
        System.out.println("Tu defensa es :" + defensa);
        personaje.setDefensa(defensa);

        

        controller.personaje.createPersonaje(codigo, nombre, vida, ataque, defensa);
        controller.personaje.addPersonaje(codigo, nombre, vida, ataque, defensa);
       
        System.out.println("Disfruta del Juego");

    }

    static void crear_enemigo() {

        System.out.println("    Creacion de Enenemigo    ");

        int codigo = devolverInt("Introduce el codigo del Enemigo: ");
        enemigo.setCodigo(codigo);
        String nombre = devolverString("Introduce el nombre del Enemigo: ");
        enemigo.setNombre(nombre);

        int vida = enemigo.generarVida();
        System.out.println("Tu vida es :" + vida);
        enemigo.setVida(vida);

        int ataque = enemigo.generarAtaque();
        System.out.println("Tu ataque es :" + ataque);
        enemigo.setAtaque(ataque);

        int defensa = enemigo.generarDefensa();
        System.out.println("Tu defensa es :" + defensa);
        enemigo.setDefensa(defensa);

        controller.enemigo.addEnemigo(codigo, nombre, vida, ataque, defensa);
        System.out.println("Disfruta del Juego");

    }

    public static String devolverString(String texto) {
        String resultado;
        Scanner teclado = new Scanner(System.in);

        System.out.print(texto);
        resultado = teclado.nextLine();

        return resultado;
    }

    public static int devolverInt(String texto) {
        int resultado;
        Scanner teclado = new Scanner(System.in);

        System.out.print(texto);
        resultado = teclado.nextInt();

        return resultado;
    }

    public static void menu_Enemigo() {
        int numero;

        do {
            System.out.println("        Menu Enemigo      ");
            System.out.println("                    ");
            System.out.println(" 1) Crear enemigo");
            System.out.println(" 2) Eliminar enemigo ");
            System.out.println(" 3) Listar enemigos");
            System.out.println(" 0) Salir ");
            Scanner teclado = new Scanner(System.in);
            System.out.println("Introduce una opción: ");
            numero = teclado.nextInt();
            switch (numero) {
                case 0:
                    if (controller.saveAllDDBB()) {
                        System.out.println("Base de datos guardada correctamente");
                    } else {
                        System.out.println("La base de datos no se ha guardado");
                    }

                    break;

                case 1:
                    crear_enemigo();
                    break;
                case 2:
                    String Nombre = devolverString("Introduce el Nombre del Enemigo :");
                    Enemigo EnemigoBorrar = controller.enemigo.searchByName(Nombre);
                    if (controller.personaje.removeEnemigo(EnemigoBorrar.getNombre())) {
                        System.out.println("Personaje Eliminado");
                    } else {
                        System.out.println("Error al eliminar el personaje");
                    }
                    break;

                case 3:
                    Set<Enemigo> ListaEnemigos = controller.enemigo.listAllEnemyTrue();
                    for (Enemigo enemigo : ListaEnemigos) {
                        System.out.println(personaje);
                        break;
                    }
            }
        } while (numero != 0);

    }

    public static void menu_Personaje() {
        int numero;
        String codigo;
        String nombre;

        do {
            System.out.println("        Menu Personaje      ");
            System.out.println("                    ");
            System.out.println(" 1) Crear Personaje");
            System.out.println(" 2) Eliminar Personaje");
            System.out.println(" 3) Listar personajes");
            System.out.println(" 0) Salir ");
            Scanner teclado = new Scanner(System.in);
            System.out.println("Introduce una opción: ");
            numero = teclado.nextInt();
            switch (numero) {
                case 0:
                      if (controller.savePersonajeDDBB()) {
                        System.out.println("Personajes guardados correctamente");
                    } else {
                        System.out.println("No se ha podido guardar los personajes");
                    }
                     
                    break;

                case 1:
                    crear_personaje();
                    break;
                case 2:
                    nombre = devolverString("Introduce el nombre del personaje :");
                    Personaje PersonajeBorrar = controller.personaje.searchByName(nombre);
                    if (controller.personaje.removeEnemigo(PersonajeBorrar.getNombre())) {
                        System.out.println("Personaje Eliminado");
                    } else {
                        System.out.println("Error al eliminar el personaje");
                    }
                    break;
                case 3:
                    Set<Personaje> ListaPersonajes = controller.personaje.listAllPersonajeTrue();
                    for (Personaje personaje : ListaPersonajes) {
                        System.out.println(personaje);
                    }
                    break;
                case 4:
            }

        } while (numero != 0);

    }

    public static Personaje menu_Editar(Personaje personaje) {
        int numero;

        do {
            System.out.println("        Menu editar      ");
            System.out.println("                    ");
            System.out.println(" 1) Cambiar Nombre");
            System.out.println(" 2) Generar Vida ");
            System.out.println(" 3) Generar ataque");
            System.out.println(" 4) Generar Defensa");
            System.out.println(" 0) Salir ");
            Scanner teclado = new Scanner(System.in);
            System.out.println("Introduce una opción: ");
            numero = teclado.nextInt();
            switch (numero) {
                case 0:
                    if (controller.savePersonajeDDBB()) {
                        System.out.println("Personaje Editados Correctamente ");
                    } else {
                        System.out.println("Personaje No modificado");
                    }
                    break;

                case 1:
                    String nombre = devolverString("Introduce el nuevo nombre: ");
                    personaje.setNombre(nombre);
                    System.out.println("Tu nuevo nombre es: " + nombre);
                    break;
                case 2:
                    int vida = personaje.generarVida();
                    personaje.setVida(vida);
                    System.out.println("Tu vida a cambiado a : " + vida);
                    break;

                case 3:
                    int ataque = personaje.generarAtaque();
                    personaje.setAtaque(ataque);
                    System.out.println("Tu ataque se ha modificado a: " + ataque);
                    break;
                case 4:
                    int defensa = personaje.getDefensa();
                    personaje.setDefensa(defensa);
                    System.out.println("Tu defensa se ha modificado a: " + defensa);

            }
        } while (numero != 0);
        return personaje;
    }
    
        public static void pulsarEnter() {
        System.out.print("\nPulsa Enter para continuar...");
        Scanner teclado = new Scanner(System.in);
        teclado.nextLine();
    }

}
