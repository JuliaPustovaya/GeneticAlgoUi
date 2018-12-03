package SA;

import Exp3.TimeSeria;
import SA.GA.RunAll;
import javafx.stage.FileChooser;
import sample.Controller;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class ReadDataFromFile {

    public static void ReadingDataInListFromFile(String filePath) {
        RunAll.datafromfile.clear();
        Scanner s = null;
        try {
            s = new Scanner(new File(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (s.hasNext()) {

            RunAll.datafromfile.add(Double.valueOf(s.next()));
        }
        s.close();


        System.out.println("DATA from opened file" +RunAll.datafromfile);

    }



    public static void openFile() throws Exception {
        FileDialog dialog = new FileDialog((Frame) null, "Select File to Open");
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);
        String file = dialog.getFile();
        System.out.println("Имя файла: " + file);
        ReadingDataInListFromFile(dialog.getDirectory() + file);
    }

    public static ArrayList<ArrayList<Double>> FormListOfZ_vector_histories(ArrayList<Double> datafromfile, int m) {
        SA.SA_main.Z_list_vector_history.clear();
        ArrayList<Double> dl;
        ArrayList<ArrayList<Double>> Z_list_vector_history = new ArrayList<>();
        try {
            for (int i = 1; i < datafromfile.size(); i++) {
                dl = new ArrayList<>();
                for (int j = 0; j < m; j++) {
                    dl.add(datafromfile.get(i + j));

                }
                Z_list_vector_history.add(dl);
                System.out.println(" " + i + dl);

            }
        } catch (Exception ex) {
        }
        SA.SA_main.Z_list_vector_history.addAll(Z_list_vector_history);
        return Z_list_vector_history;
    }

    public static ArrayList<Map.Entry<Integer, Double>> Evklidova_distance(ArrayList<ArrayList<Double>> Z_list_vector_history) {
        SA.SA_main.e_distance.clear();
        SortedMap<Integer, Double> z_points_S = new TreeMap<>();
        //  SortedSet<Map.Entry<Integer, Double>> sortedset;
        int q = 0;
        ArrayList<Map.Entry<Integer, Double>> sortedset;
        sortedset = new ArrayList<>();
        for (ArrayList<Double> i : Z_list_vector_history) {
            double sum = 0;
            for (int j = 0; j < i.size(); j++) {
                sum = sum + Math.pow((i.get(j) - Z_list_vector_history.get(Z_list_vector_history.size() - 1).get(j)), 2);
                if (sum != 0.0) {
                    z_points_S.put(q, Math.sqrt(sum));

                }
            }
            q++;
        }
        for (Double h : z_points_S.values()) {
            SA.SA_main.e_distance.add(h);

        }
        sortedset.addAll(z_points_S.entrySet());
        Collections.sort(sortedset, new Comparator<Map.Entry<Integer, Double>>() {
            @Override
            public int compare(Map.Entry<Integer, Double> e1,
                               Map.Entry<Integer, Double> e2) {
                return e1.getValue().compareTo(e2.getValue());
            }
        });
        System.out.println("евклід " + sortedset);
        return sortedset;
    }

    public static TreeMap<Integer, Double> pois_K_nearest(ArrayList<Map.Entry<Integer, Double>> sortedset, double k) {
        TreeMap<Integer, Double> nn = new TreeMap();
        int i = 0;
        for (SortedMap.Entry e : sortedset) {
            if (nn.size() < k) {
                double v;
                int q;
                v = (double) e.getValue();
                q = (int) e.getKey();
                nn.put(q, v);

            } else {
                break;
            }

        }
        System.out.println("nn" + nn);
        return nn;
    }

}
