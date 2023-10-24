package T19;
import java.util.ArrayList;
import java.util.List;
public class comparar {
    
    public static void main (String [] args){

    ArrayList <Integer> numeros = new ArrayList<>();
    numeros.add (33);
    numeros.add (11);
    numeros.add (44);
    numeros.add (22);

    ArrayList <String> colores = new ArrayList<>();
    colores.add ("Violeta");
    colores.add ("Rosa");
    colores.add ("Cafe");
    colores.add ("Morado");

    mostrarLista(numeros);
    }

        public  static void mostrarLista (List<?>lista){
            for (Object x : lista) {
                System.out.println(x);
            }
        }
}
