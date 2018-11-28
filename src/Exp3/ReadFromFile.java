package Exp3;

import sample.Controller;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Logger;

public class ReadFromFile {
    private static final Logger LOGGER = Logger.getLogger(ReadFromFile.class.getName());

    public static ArrayList<TimeSeria> readDataFromFile(String filePath, ArrayList<TimeSeria> listForTimeSeria, ArrayList listOfRealValue) throws Exception {
        int index = 1;
        Scanner s = new Scanner(new File(filePath));
        ArrayList<TimeSeria> list = new ArrayList<>();
        while (s.hasNext()) {
            list.add(new TimeSeria(Double.parseDouble(s.next())));
        }
        s.close();
        //int removableQuantityOfTimeSeriaForComparion = (int) (list.size() * 0.25);
        int removableQuantityOfTimeSeriaForComparion = Coefficients.L;
        for (int i = 0; i < list.size() - removableQuantityOfTimeSeriaForComparion; i++) {
            listForTimeSeria.add(list.get(i));
        }
        for (int i = (list.size() - removableQuantityOfTimeSeriaForComparion); i < list.size(); i++) {
            listOfRealValue.add(list.get(i).getYt());
        }
        System.out.println("Размер исх.данных: " + listForTimeSeria.size() + "\nДанные: " + listForTimeSeria);
        System.out.println("Исходные данные для сравнения : " + listOfRealValue);
        return listForTimeSeria;
    }

    public static void openFile(ArrayList<TimeSeria> listForTimeSeria, ArrayList listOfRealValue) throws Exception {
        FileDialog dialog = new FileDialog((Frame) null, "Select File to Open");
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);
        String file = dialog.getFile();
        System.out.println("Имя файла: "+file);
        Controller.globalFilePath=file;
        readDataFromFile(dialog.getDirectory() + file, listForTimeSeria, listOfRealValue);
    }
}
