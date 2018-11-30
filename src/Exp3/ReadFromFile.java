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

    public static ArrayList<TimeSeria> readDataFromFile(String filePath) throws Exception {
        Scanner s = new Scanner(new File(filePath));
        while (s.hasNext()) {
            Controller.readedTimeSeriaFromFile.add(new TimeSeria(Double.parseDouble(s.next())));
        }
        s.close();
        return Controller.readedTimeSeriaFromFile;
    }

    public static void splitInitialTimeSeriaIntoRealandTimerseriaData(ArrayList<TimeSeria> list) {
        Controller.timeSeria.clear();
        Controller.realResult.clear();
        int removableQuantityOfTimeSeriaForComparion = Coefficients.m;
        for (int i = 0; i < list.size() - removableQuantityOfTimeSeriaForComparion; i++) {
            Controller.timeSeria.add(list.get(i));
        }
        for (int i = (list.size() - removableQuantityOfTimeSeriaForComparion); i < list.size(); i++) {
            Controller.realResult.add(list.get(i).getYt());
        }
        System.out.println("Размер исх.данных: " + list.size() + "\nДанные: " + Controller.timeSeria);
        System.out.println("Исходные данные для сравнения : " + Controller.realResult);

    }

    public static void openFile() throws Exception {
        FileDialog dialog = new FileDialog((Frame) null, "Select File to Open");
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);
        String file = dialog.getFile();
        System.out.println("Имя файла: " + file);
        Controller.globalFilePath = file;
        readDataFromFile(dialog.getDirectory() + file);
    }
}
