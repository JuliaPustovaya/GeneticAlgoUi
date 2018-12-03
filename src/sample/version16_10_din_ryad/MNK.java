/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.version16_10_din_ryad;

import java.util.ArrayList;

public class MNK {

    static double a0 = 1.0 / 231.0;
    static double a1 = 1.0 / 1188.0;
    static double a2 = 1.0 / 924.0;
    static double a3 = 1.0 / 1188.0;
    static ArrayList<Integer> a0_parametrs = new ArrayList<>();
    static ArrayList<Integer> a1_parametrs = new ArrayList<>();
    static ArrayList<Integer> a2_parametrs = new ArrayList<>();
    static ArrayList<Integer> a3_parametrs = new ArrayList<>();

    static {
        a0_parametrs.add(-21);
        a0_parametrs.add(14);
        a0_parametrs.add(39);
        a0_parametrs.add(54);
        a0_parametrs.add(59);
        a0_parametrs.add(54);
        a0_parametrs.add(39);
        a0_parametrs.add(14);
        a0_parametrs.add(-21);

        a1_parametrs.add(86);
        a1_parametrs.add(-142);
        a1_parametrs.add(-193);
        a1_parametrs.add(-126);
        a1_parametrs.add(0);
        a1_parametrs.add(126);
        a1_parametrs.add(193);
        a1_parametrs.add(142);
        a1_parametrs.add(-86);

        a2_parametrs.add(28);
        a2_parametrs.add(7);
        a2_parametrs.add(-8);
        a2_parametrs.add(-17);
        a2_parametrs.add(-20);
        a2_parametrs.add(-17);
        a2_parametrs.add(-8);
        a2_parametrs.add(7);
        a2_parametrs.add(28);

        a3_parametrs.add(-14);
        a3_parametrs.add(7);
        a3_parametrs.add(13);
        a3_parametrs.add(9);
        a3_parametrs.add(0);
        a3_parametrs.add(-9);
        a3_parametrs.add(-13);
        a3_parametrs.add(-7);
        a3_parametrs.add(14);
    }

    private ArrayList< ArrayList<Points>> list_okon = new ArrayList<>();
    private ArrayList< Double> a_first_t_elements = new ArrayList<>();
    private ArrayList< Double> a_last_t_elements = new ArrayList<>();
    private ArrayList< Double> result = new ArrayList<>();
    public ArrayList<ArrayList<Points>> getList_okon() {
        return list_okon;
    }

    public ArrayList<Double> getA_first_t_elements() {
        return a_first_t_elements;
    }

    public ArrayList<Double> getA_last_t_elements() {
        return a_last_t_elements;
    }

    public ArrayList<Double> getResult() {
        return result;
    }

    
    public void formList_okon(ArrayList<Points> ps, int okno) {

        int index_nextel = 0;
        for (int i = 0; i < ps.size(); i++) {

            ArrayList<Points> temp = new ArrayList<>();
            for (int j = i; j < okno + i; j++) {
                if (j < ps.size()) {
                    temp.add(ps.get(j));

                }

            }
            if (temp.size() < okno) {
                index_nextel = i;
                i = ps.size() - 1;
                break;
            }

            list_okon.add(temp);

        }
        System.out.println("MNK list of okon" + list_okon);

    }
    public double rank_at(ArrayList<Points> ps, double ax, ArrayList<Integer> ax_parametrs) {

        double sum = 0.0;

        for (int i = 0; i < ps.size(); i++) {
            sum = sum + (ps.get(i).getPoint() * ax_parametrs.get(i));
        }
        System.out.println(" a " + ax + " " + sum * ax);
        Points p = new Points();
        p.setPoint(sum * ax);
        return p.getPoint();
    }
    public void rank_U_(int t) {
        //формируем первы 4 и элемента нового списка
        a_first_t_elements.add(rank_at(list_okon.get(0), a0, a0_parametrs));
        a_first_t_elements.add(rank_at(list_okon.get(0), a1, a1_parametrs));
        a_first_t_elements.add(rank_at(list_okon.get(0), a2, a2_parametrs));
        a_first_t_elements.add(rank_at(list_okon.get(0), a3, a3_parametrs));

        double ui = 0.0;

        for (int i = 1; i <= t; i++) {
            ui = a_first_t_elements.get(0)
                    + a_first_t_elements.get(1) * (-1) * i
                    + a_first_t_elements.get(2) * Math.pow((-1) * i, 2)
                    + a_first_t_elements.get(3) * Math.pow((-1) * i, 3);
            result.add(ui);
        }

        //формируем серединные  элементы нового списка
        for (int k = 0; k < list_okon.size(); k++) {
            result.add(rank_at(list_okon.get(k), a0, a0_parametrs));
        }
        //формируем последние 4и элемента нового списка
        a_last_t_elements.add(rank_at(list_okon.get(list_okon.size() - 1), a0, a0_parametrs));
        a_last_t_elements.add(rank_at(list_okon.get(list_okon.size() - 1), a1, a1_parametrs));
        a_last_t_elements.add(rank_at(list_okon.get(list_okon.size() - 1), a2, a2_parametrs));
        a_last_t_elements.add(rank_at(list_okon.get(list_okon.size() - 1), a3, a3_parametrs));
        ui = 0.0;

        for (int i = 1; i <= t; i++) {
            ui = a_last_t_elements.get(0)
                    + a_last_t_elements.get(1) * i
                    + a_last_t_elements.get(2) * Math.pow(i, 2)
                    + a_last_t_elements.get(3) * Math.pow(i, 3);
            result.add(ui);
        }

        System.out.println("резульат " + result);
    }
}
