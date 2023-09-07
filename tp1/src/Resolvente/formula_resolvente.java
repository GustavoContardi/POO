package Resolvente;

public class formula_resolvente {
    private int A;
    private int B;
    private int C;

    public void setA(int a){ this.A = a; }

    public int getA() { return A; }
    public void setB(int b){ this.B = b; }
    public int getB() { return B; }
    public void setC(int c){ this.C = c; }
    public int getC() { return C; }

    public void buscar_raices(){
        double resultado1 = 0.0, resultado2 = 0.0, raiz;

        raiz = Math.pow(A, 2) - (4*A*C);

        if(raiz < 0){
            System.out.println("No hay raices reales");
        }
        else{
            resultado1 = (-B - Math.sqrt(raiz)) / (2*A);
            resultado2 = (-B + Math.sqrt(raiz)) / (2*A);
        }
        if((int)resultado2 == (int)resultado1){
            System.out.println("Tiene una unica raiz: " + (int)resultado1);
        }
        else System.out.printf("Raiz 1: %d \nRaiz 2: %d", (int)resultado1, (int)resultado2);
    }
}
