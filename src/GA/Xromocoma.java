package GA;

import java.text.DecimalFormat;

public class Xromocoma {
	private Double alfa;
	private Double betta;
	private Double gamma;

	@Override
	public String toString() {
		return "Xromocoma{" +
				"alfa= " + new DecimalFormat("#0.00").format(alfa)+
				" ;betta= " + new DecimalFormat("#0.00").format(betta)+
				" ;gamma= " + new DecimalFormat("#0.00").format(gamma)+
				'}';
	}

	public Double getAlfa() {
		return alfa;
	}

	public void setAlfa(Double alfa) {
		this.alfa = alfa;
	}

	public Double getBetta() {
		return betta;
	}

	public void setBetta(Double betta) {
		this.betta = betta;
	}

	public Double getGamma() {
		return gamma;
	}

	public void setGamma(Double gamma) {
		this.gamma = gamma;
	}

	public Xromocoma(Double alfa, Double betta, Double gamma) {
		this.alfa = alfa;
		this.betta = betta;
		this.gamma = gamma;
	}

	public Xromocoma() {

	}
}
