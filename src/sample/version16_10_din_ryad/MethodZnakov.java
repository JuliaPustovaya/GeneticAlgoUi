package sample.version16_10_din_ryad;

import java.util.ArrayList;

/**
 *
 * @author Юлия
 */
public class MethodZnakov {

    private double m;
    private double d;
    private double e;
    private double s;
    private String hipoteza;
    private ArrayList<Double> extrimPpoints;

    public MethodZnakov() {
        this.m = 0.0;
        this.d = 0.0;
        this.e = 0.0;
        this.s = 0.0;
        this.hipoteza = "";
        this.extrimPpoints = new ArrayList<>();
    }

    public String getHipoteza() {
        return hipoteza;
    }

    public void setHipoteza(String hipoteza) {
        this.hipoteza = hipoteza;
    }

    public double getS() {
        return s;
    }

    public void setS(double s) {
        this.s = s;
    }

    public void setE(double e) {
        this.e = e;
    }

    public double getM() {
        return m;
    }

    public void setM(double m) {
        this.m = m;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }

    public ArrayList<Double> getExtriPpoints() {
        return extrimPpoints;
    }

    public ArrayList<Double> setExtriPpoints(ArrayList<Points> extriPpoints) {

        for (int i = 1; i < extriPpoints.size() - 1; i++) {
            if (((extriPpoints.get(i).getPoint() > extriPpoints.get(i + 1).getPoint()) && (extriPpoints.get(i).getPoint() > extriPpoints.get(i - 1).getPoint()))
                    || ((extriPpoints.get(i).getPoint() < extriPpoints.get(i + 1).getPoint()) && (extriPpoints.get(i).getPoint() < extriPpoints.get(i - 1).getPoint()))) {
                extrimPpoints.add(1.0);
            } else {
                extrimPpoints.add(0.0);
            }
        }
        System.out.println("Extrim points" + extrimPpoints);
        return extrimPpoints;
    }

    public double getExtrimSum(ArrayList<Double> al) {

        for (Double d : al) {
            e = e + d;
        }
        setE(e);
        System.out.println("e= " + e);
        return e;
    }

    public double getE() {
        return e;
    }

    public double reckonM(DynamicSeria ds) {

        m = (2.0 / 3.0) * (ds.getQuantity() - 2);
        return m;
    }

    public double reckonD(DynamicSeria ds) {
        d = (16.0 * ds.getQuantity() - 29.0) / 90.0;
        return d;
    }

    public double reckonS() {
        s = (e - m) / Math.sqrt(d);
        return s;
    }

    public String setHipoteza() {
        if (Math.abs(s) <= Kvantili.kvantil_norm_raspred()) {
            hipoteza = "Ряд випадковий.Прийнимаєм гипотезу Н0";

        } else {
            hipoteza = "Ряд циклічный.Прийнимаємо гипотезу Н1";
        }

        System.out.println(toString());
        return hipoteza;

    }

    @Override
    public String toString() {
        return "MethodZnakov{" + "m=" + m + ", d=" + d + ", e=" + e + ", s=" + s + ", extrimPpoints=" + extrimPpoints + ", hipoteza=" + hipoteza + '}';
    }

}
