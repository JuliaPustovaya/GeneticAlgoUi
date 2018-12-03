/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.version16_10_din_ryad;

import Exp3.TimeSeria;

import java.io.BufferedReader;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author Юлия
 */
public class ReadPoints {

    public static ArrayList<Points> readDataInArray(DynamicSeria listofstrings, String PATH) {
        try (BufferedReader bufferedInput = new BufferedReader(new FileReader(new File(PATH)))) {
            String line;
            while ((line = bufferedInput.readLine()) != null) {
                String[] numbers = line.split(" ");
                for (String num : numbers) {
                    double data = Double.parseDouble(num);
                    Points p = new Points();
                    p.setPoint(data);
                    listofstrings.fillSeria(p);
                }
            }
            listofstrings.setQuantity(listofstrings.getDynamic_seria().size());
            System.out.println("Seria of points:" + listofstrings.getDynamic_seria());
            System.out.println("Length of seria:" + listofstrings.getQuantity());
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
        //listofstrings.addAll(ar);
        return listofstrings.getDynamic_seria();
    }

    public static ArrayList<Points> readDataInListFromTimeseria(DynamicSeria listofstrings, ArrayList<TimeSeria> timeSerias) {
        for (int i = 0; i <timeSerias.size() ; i++) {
            Points p= new Points();
            p.setPoint(timeSerias.get(i).getYt());
            listofstrings.fillSeria(p);
        }

            listofstrings.setQuantity(listofstrings.getDynamic_seria().size());
            System.out.println("Seria of points:" + listofstrings.getDynamic_seria());
            System.out.println("Length of seria:" + listofstrings.getQuantity());

        //listofstrings.addAll(ar);
        return listofstrings.getDynamic_seria();

    }
    public static ArrayList<Points> readDataInListFromKData(DynamicSeria listofstrings, ArrayList<Double> list) {
        for (int i = 0; i <list.size() ; i++) {
            Points p= new Points();
            p.setPoint(list.get(i));
            listofstrings.fillSeria(p);
        }

        listofstrings.setQuantity(listofstrings.getDynamic_seria().size());
        System.out.println("Seria of points:" + listofstrings.getDynamic_seria());
        System.out.println("Length of seria:" + listofstrings.getQuantity());

        //listofstrings.addAll(ar);
        return listofstrings.getDynamic_seria();

    }
}