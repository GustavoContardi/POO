import Resolvente.formula_resolvente;

public class main_resolvente {
    public static void main(String[] arg){
        int A = 1;
        int B = 0;
        int C = 0;

        formula_resolvente b_raices = new formula_resolvente();

        b_raices.setA(A);
        b_raices.setB(B);
        b_raices.setC(C);

        System.out.printf("Coeficientes: A=%d | B=%d | C=%d\n\n", A, B, C);
        b_raices.buscar_raices();

    }
}
