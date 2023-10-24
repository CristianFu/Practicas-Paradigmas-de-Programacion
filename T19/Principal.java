package T19;
public class Principal {
    public static void main (String [] args){
        Caja <String> caja1= new Caja<String>();
        caja1.setArticulo("Reloj");

        System.out.println ("Caja con: " + caja1.getArticulo());

        Caja <Integer> caja2= new Caja<Integer>();
        caja2.setArticulo(3);

        System.out.println("La caja de " + caja1.getArticulo() + " Tiene: " + caja2.getArticulo());

        Estudiante e1= new Estudiante(123, "Luis");
        Caja <Estudiante> caja3= new Caja<Estudiante>();
        caja3.setArticulo(e1);

        System.out.println("Caja con: " + caja3.getArticulo());
    }
}
