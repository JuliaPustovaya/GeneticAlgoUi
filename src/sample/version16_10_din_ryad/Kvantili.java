
package sample.version16_10_din_ryad;

/**
 *
 * @author Юлия
 */
public class Kvantili {
   static double u;
    static double t;

  static  double  kvantil_norm_raspred() {
        double L = 0.05;
        double a = (1 - (1.0-0.05/2));
        double t = Math.sqrt(-2*Math.log(a));
        double c0 = 2.515517;
        double c1 = 0.802853;
        double c2 = 0.010328;
        double d1 = 1.432788;
        double d2 = 0.1892659;
        double d3 = 0.001308;
        double result;
        double ch = c0 + (c1 * t) + (c2 * t * t);
        double zn = 1 + (d1 * t) + (d2 * t * t) + (d3 * t * t * t);
        result = (t - (ch / zn));
        System.out.println("kvantil_norm= " + result);
        u = result;
        return result;
}
}