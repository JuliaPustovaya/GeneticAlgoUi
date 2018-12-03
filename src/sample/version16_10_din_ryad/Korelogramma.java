package sample.version16_10_din_ryad;

import java.util.ArrayList;

public class Korelogramma {

    private ArrayList<ArrayList<Points>> x = new ArrayList<>();
    private ArrayList<ArrayList<Points>> y = new ArrayList<>();
    private ArrayList<Double> listofcorr = new ArrayList<>();

    public ArrayList<ArrayList<Points>> getX() {
        return x;
    }

    public ArrayList<ArrayList<Points>> getY() {
        return y;
    }

    public ArrayList<Double> getListofcorr() {
        return listofcorr;
    }

    public ArrayList transformDSX(ArrayList<Points> ds) {
        int length = ds.size() / 2;
        int various_length = ds.size() - 1;
        for (int q = 0; q < length; q++) {
            ArrayList<Points> ps = new ArrayList<>();
            for (int q1 = 0; q1 < various_length; q1++) {
                ps.add(ds.get(q1));
            }
            x.add(ps);
            various_length--;
        }
        System.out.println("x" + x);
        return x;
    }

    public ArrayList transformDSY(ArrayList<Points> ds) {
        int length = ds.size() / 2;
        int various_length = ds.size();
        for (int q = 0; q < length; q++) {
            ArrayList<Points> ps = new ArrayList<>();

            for (int q1 = q + 1; q1 < various_length; q1++) {
                ps.add(ds.get(q1));

            }
            y.add(ps);

        }
        System.out.println("y" + y);
        return y;
    }

    public double rankSredArif(ArrayList<Points> ps) {
        double sum = 0;
        for (int i = 0; i < ps.size(); i++) {
            sum = sum + ps.get(i).getPoint();
        }

        return sum / (double) ps.size();
    }

    public double rankXY_(ArrayList<Points> x, ArrayList<Points> y) {
        double sum = 0;
        for (int i = 0; i < x.size(); i++) {
            sum = sum + (x.get(i).getPoint() * y.get(i).getPoint());
        }

        return sum / (double) x.size();
    }

    public double rankDispersii(ArrayList<Points> ps, double sredarif) {
        double sum = 0;
        for (int i = 0; i < ps.size(); i++) {
            sum = sum + Math.pow((ps.get(i).getPoint() - sredarif), 2);
        }

        return Math.sqrt(sum / (double) ps.size());
    }

    public double rankCorr(ArrayList<Points> x, ArrayList<Points> y) {
        return (rankXY_(x, y) - rankSredArif(x) * rankSredArif(y)) / (rankDispersii(x, rankSredArif(x)) * rankDispersii(y, rankSredArif(y)));
    }

    public void formArrayCorr(ArrayList<Points> maindynamicseria) {

        listofcorr.add(formArrayCorr_r0(maindynamicseria));
        for (int i = 0; i < x.size(); i++) {

            listofcorr.add(rankCorr(x.get(i), y.get(i)));

        }
        System.out.println("list of corr" + listofcorr);
    }

    public double formArrayCorr_r0(ArrayList<Points> maindynamicseria) {
        double corr = 0.0;
        corr = (rankCorr(maindynamicseria, maindynamicseria));
        return corr;
    }
}
