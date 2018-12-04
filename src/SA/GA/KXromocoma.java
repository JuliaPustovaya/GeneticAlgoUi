package SA.GA;

import java.text.DecimalFormat;

public class KXromocoma {
	private Integer alfa;
	private Integer betta;


	@Override
	public String toString() {
		return "Xromocoma{" +
				"alfa= " + new DecimalFormat("#0.00").format(alfa)+
				" ;betta= " + new DecimalFormat("#0.00").format(betta)+
				'}';
	}

	public Integer getAlfa() {
		return alfa;
	}

	public void setAlfa(Integer alfa) {
		this.alfa = alfa;
	}

	public Integer getBetta() {
		return betta;
	}

	public void setBetta(Integer betta) {
		this.betta = betta;
	}


	public KXromocoma(Integer alfa, Integer betta) {
		this.alfa = alfa;
		this.betta = betta;

	}
//	public KXromocoma(KXromocoma kXromocoma) {
//		this.alfa = kXromocoma.alfa;
//		this.betta = kXromocoma.betta;
//
//	}

	public KXromocoma() {

	}
}
