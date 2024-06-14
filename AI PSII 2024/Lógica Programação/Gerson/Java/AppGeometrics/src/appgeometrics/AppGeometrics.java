package appgeometrics;
/**
 *
 * @author lucas-gabreil_silva
 */
public class AppGeometrics {
    public static void main(String[] args) {
        
        System.out.println("Retangulo 1 -------------------------->>");
        
        Retangulo rec1 = new Retangulo(10, 5);
        
        rec1.calcArea();
        rec1.calcPerimetro();
        
        rec1.setLado2(7);
        
        rec1.calcArea();
        rec1.calcPerimetro();
        
        System.out.println("\nRetangulo 2 -------------------------->>");
        
        Retangulo rec2 = new Retangulo(20, 10);
        
        rec2.calcArea();
        rec2.calcPerimetro();
        
        rec2.setLado2(14);
        
        rec2.calcArea();
        rec2.calcPerimetro();
        
        System.out.println("\nRetangulo 3 -------------------------->>");
        
        Retangulo rec3 = new Retangulo(2, 8);
        
        rec3.calcArea();
        rec3.calcPerimetro();
        
        rec3.setLado1(10);
        
        rec3.calcArea();
        rec3.calcPerimetro();
        
        System.out.println("\nRetangulo 4 -------------------------->>");
        
        Retangulo rec4 = new Retangulo(7, 21);
        
        rec4.calcArea();
        rec4.calcPerimetro();
        
        rec4.setLado1(14);
        
        rec4.calcArea();
        rec4.calcPerimetro();
    }
    
}
