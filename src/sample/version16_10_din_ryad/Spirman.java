package sample.version16_10_din_ryad;

/**
 *
 * @author Юлия
 */
public class Spirman {

    private double[][] matrix_indicator;
    private double V_statistica;
    private double koefrangkorel;
    private double S_statistica;
    private String hipoteza;

    public double[][] getMatrix_indicator() {
        return matrix_indicator;
    }

    public double getV_statistica() {
        return V_statistica;
    }

    public double getKoefrangkorel() {
        return koefrangkorel;
    }

    public double getS_statistica() {
        return S_statistica;
    }

    public String getHipoteza() {
        return hipoteza;
    }

   public Spirman(int rows) {
        matrix_indicator = new double[rows - 2][rows - 1];
        V_statistica = 0;
        S_statistica = 0;
        koefrangkorel = 0;
        hipoteza = "";
    }

    public void displayArray(double[][] ar) {
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[i].length; j++) {
                System.out.print(" " + ar[i][j]);
            }
            System.out.println(" ");
        }

    }

    public double[][] reckonMatrix_indicator(DynamicSeria sr) {
        for (int i = 0; i < sr.getDynamic_seria().size() - 2; i++) {
            for (int j = i + 1; j < sr.getDynamic_seria().size() - 1; j++) {
                if (sr.getDynamic_seria().get(i).getPoint() < sr.getDynamic_seria().get(j).getPoint()) {
                    matrix_indicator[i][j] = 1.0;
                } else if (sr.getDynamic_seria().get(i).getPoint() == sr.getDynamic_seria().get(j).getPoint()) {
                    matrix_indicator[i][j] = 0.5;
                } else if (sr.getDynamic_seria().get(i).getPoint() > sr.getDynamic_seria().get(j).getPoint()) {
                    matrix_indicator[i][j] = 0.0;
                }

            }

        }
        displayArray(matrix_indicator);
        return matrix_indicator;
    }

    public double reckonV_statistika(double[][] ar) {
        double sum = 0;
        for (int i = 0; i < ar.length; i++) {
            for (int j = i + 1; j < ar[i].length; j++) {
                if (i < j) {
                    sum = sum + (j - i) * ar[i][j];
                }

            }
        }
        V_statistica = sum;

        return V_statistica;

    }

    public double reckonKoefrangkorel(int quantity) {

        return koefrangkorel = 1.0 - (12 * V_statistica / (quantity * (Math.pow(quantity, 2) - 1)));

    }

    public double rekonS_statiska(int quantity) {
        S_statistica = koefrangkorel / (Math.sqrt(1.0 / (quantity - 1)));

        return S_statistica;
    }

    public String setHipoteza() {
        if (Math.abs(S_statistica) <= Kvantili.kvantil_norm_raspred()) {
         //   hipoteza = "Ряд случайный.Принимаем гипотезу Н0";
            hipoteza = "Ряд випадковий. Принимаємо гіпотезу Н0";
        } else if (S_statistica < ((-1) * Kvantili.kvantil_norm_raspred())) {
       //     hipoteza = " С тендецией ряда возрастания. Принимаем гипотезу Н1";
            hipoteza = "Ряд з тенденцією зростання. Принимаємо гіпотезу Н1";
        } else if (S_statistica > Kvantili.kvantil_norm_raspred()) {
           // hipoteza = "С тендецией ряда cпадения. Принимаем гипотезу Н1";
            hipoteza = "Ряд з тенденцією спадання. Принимаємо гіпотезу Н1";
        }

        System.out.println(toString());
        return hipoteza;
    }

    @Override
    public String toString() {
        return "Spirman{ V_statistica=" + V_statistica + ", koefrangkorel=" + koefrangkorel + ", S_statistica=" + S_statistica + ", hipoteza=" + hipoteza + '}';
    }


}
