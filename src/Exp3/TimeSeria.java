package Exp3;

public class TimeSeria {

	private Double Yt;

	public TimeSeria(Double yt) {
		Yt = yt;
	}

	@Override
	public String toString() {
		return " " + Yt;
	}

	public Double getYt() {
		return Yt;
	}

	public void setYt(Double yt) {
		Yt = yt;
	}
}
