package Exp3;

import java.text.DecimalFormat;

import static sample.Main.timeSeria;
import static sample.Main.updatedTimeSerias;

public class UpdatedTimeSeria {

	private Double sT = 0.0;
	private Double bT = 0.0;
	private Double cT = 0.0;

	public Double getsT() {
		return sT;
	}

	@Override
	public String toString() {
		return
				" sT=" + new DecimalFormat("#0.00").format(sT) +
						", bT=" + new DecimalFormat("#0.00").format(bT) +
						", cT=" + new DecimalFormat("#0.00").format(cT);
	}

	public Double getbT() {
		return bT;
	}

	public Double getcT() {
		return cT;
	}

	public UpdatedTimeSeria(Double sT, Double bT, Double cT) {
		this.sT = sT;
		this.bT = bT;
		this.cT = cT;
	}

	public static void getUpdatedTimeSeria() {
		System.out.println("Полученные S, b, c ");
		for (int i = 0; i < updatedTimeSerias.size(); i++) {
			System.out.println("i=  " + i + "  y= " + timeSeria.get(i) + updatedTimeSerias.get(i));
		}
	}
}
