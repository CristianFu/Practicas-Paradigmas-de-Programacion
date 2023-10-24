package T19;

public class Main {
    public static void main (String [] args ){
        Estudiante e1= new Estudiante(123, "Luis");
        Caja <Estudiante> caja1= new Caja<Estudiante>();
        caja1.getArticulo(123, "Hola");
        System.out.println (caja1.setArticulo(e1));
    }
}
