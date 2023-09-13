package T09P1;
import java.util.Scanner;

 abstract class Personaje {
        private String nombre;
        private int nivel;

        public Personaje(String nombre, int nivel) {
            if (nivel < 1) {
                throw new IllegalArgumentException("El nivel no puede ser menor que 1.");
            }
            this.nombre = nombre;
            this.nivel = nivel;
        }

        public void atacar() {
            if (nivel < 5) {
                throw new RuntimeException("No se puede atacar. El nivel es demasiado bajo.");
            }
            System.out.println(nombre + " ataca.");
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getNivel() {
            return nivel;
        }

        public void setNivel(int nivel) {
            if (nivel < 1) {
                throw new IllegalArgumentException("El nivel no puede ser menor que 1.");
            }
            this.nivel = nivel;
        }
    }

    interface HabilidadesMagicas {
        void lanzarHechizo();
    }

    interface HabilidadesFisicas {
        void usarArma();
    }

    class JugadorConHabilidades extends Personaje implements HabilidadesMagicas, HabilidadesFisicas {
        private String clase;

        public JugadorConHabilidades(String nombre, int nivel, String clase) {
            super(nombre, nivel);
            this.clase = clase;
        }

        public void usarHabilidadEspecial() {
            System.out.println(getNombre() + " utiliza su habilidad especial como " + clase + ".");
        }

        @Override
        public void lanzarHechizo() {
            System.out.println(getNombre() + " lanza un hechizo mágico.");
        }

        @Override
        public void usarArma() {
            System.out.println(getNombre() + " usa su arma física.");
        }

        public String getClase() {
            return clase;
        }

        public void setClase(String clase) {
            this.clase = clase;
        }
    }

    class Enemigo extends Personaje {
        private String tipo;

        public Enemigo(String nombre, int nivel, String tipo) {
            super(nombre, nivel);
            this.tipo = tipo;
        }

        public void gritar() {
            System.out.println(getNombre() + " emite un grito aterrador como un " + tipo + ".");
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }
    }
    public class MainJuegoRPG {
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);

        System.out.print("Ingresa el nombre del jugador: ");
        String nombreJugador = consola.nextLine();

        int nivelJugador;
        do {
            System.out.print("Ingresa el nivel del jugador (debe ser al menos 1): ");
            nivelJugador = consola.nextInt();
        } while (nivelJugador < 1);

        consola.nextLine(); // Consumir la nueva línea pendiente

        System.out.print("Ingresa la clase del jugador: ");
        String claseJugador = consola.nextLine();

        JugadorConHabilidades jugador1 = new JugadorConHabilidades(nombreJugador, nivelJugador, claseJugador);
        Enemigo enemigo1 = new Enemigo("Orco Grunh", 5, "Bestia");

        int numeroDeTurnos = 3;

        for (int turno = 1; turno <= numeroDeTurnos; turno++) {
            System.out.println("Turno " + turno + ":");

            jugador1.atacar();
            jugador1.usarHabilidadEspecial();
            jugador1.lanzarHechizo(); // Usar habilidad mágica
            jugador1.usarArma(); // Usar habilidad física

            enemigo1.atacar();
            enemigo1.gritar();
            
            System.out.println();
        }
        
        consola.close();
    }

}
