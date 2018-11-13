package Exp3;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

public class WriteToFile {
	public  static void createFile(ArrayList list ,String nameOfFile) throws Exception {
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(nameOfFile.concat(".txt")), "utf-8"))) {
			for (int i = 0; i <list.size() ; i++) {
				writer.write(list.get(i).toString()+"\n".replaceAll(".",","));
			}

		}
	}
	public static void writeToFile(ArrayList list,String nameOfFile){
		try {
			createFile(list,nameOfFile);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
