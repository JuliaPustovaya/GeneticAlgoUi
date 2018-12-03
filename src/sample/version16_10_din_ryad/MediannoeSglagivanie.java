
package sample.version16_10_din_ryad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MediannoeSglagivanie {

    private ArrayList<ArrayList<Points>> listdsformedians = new ArrayList<>();
    private ArrayList<Points> listofmedians = new ArrayList<>();

    public ArrayList<ArrayList<Points>> getListdsformedians() {
        return listdsformedians;
    }

    public ArrayList<Points> getListofmedians() {
        return listofmedians;
    }

    public Points rankMediana(ArrayList<Points> ps) {
        Points w = new Points();
        sort(ps);
        if (ps.size() % 2 != 0) {
            w.setPoint(ps.get(ps.size() / 2).getPoint());
        } else {
            w.setPoint((ps.get((ps.size() / 2) - 1).getPoint() + ps.get(ps.size() / 2).getPoint()) / 2);
        }
        return w;
    }

    public ArrayList<Points> sort(ArrayList<Points> ps) {
        Collections.sort(ps, new Comparator<Points>() {
            @Override
            public int compare(Points o1, Points o2) {
                if (o1.getPoint() > o2.getPoint()) {
                    return 1;
                } else if (o1.getPoint() == o2.getPoint()) {
                    return 0;
                } else {
                    return -1;
                }
            }

        });
        System.out.println("sort " + ps);
        return ps;
    }

    public ArrayList formListdsForMedians(ArrayList<Points> ps, int okno) {
        int index_nextel = 0;
        for (int i = 0; i < ps.size(); i++) {
            ArrayList<Points> ar = new ArrayList<>();
            for (int j = i; j < okno + i; j++) {
                if (j < ps.size()) {
                    ar.add(ps.get(j));

                }

            }
            if (ar.size() < okno) {
                index_nextel = i;
                i = ps.size() - 1;
                break;

            }
            listdsformedians.add(ar);
        }
        System.out.println("list..." + listdsformedians);
        System.out.println(" index " + index_nextel + "value " + ps.get(index_nextel).getPoint());
        for (int i = index_nextel; i < ps.size() - 2; i++) {
            ArrayList<Points> ar = new ArrayList<>();
            for (int j = i; j < 3 + i; j++) {
                if (j < ps.size()) {
                    ar.add(ps.get(j));
                }
            }
            listdsformedians.add(ar);
        }
        System.out.println(" new list..." + listdsformedians);
        return listdsformedians;
    }

    public void rankListofMedians(ArrayList<Points> ar) {
        listofmedians.add(0, ar.get(0));
        for (int i = 0; i < listdsformedians.size(); i++) {
            listofmedians.add(rankMediana(listdsformedians.get(i)));
        }
        listofmedians.add(ar.size() - 1, ar.get(ar.size() - 1));
        System.out.println("list of medians " + listofmedians);

    }
}
