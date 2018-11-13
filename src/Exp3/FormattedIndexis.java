package Exp3;

import java.util.ArrayList;

import static Exp3.Coefficients.*;
import static Exp3.InitialIndexis.*;
import static sample.Main.timeSeria;
import static sample.Main.updatedTimeSerias;

public class FormattedIndexis {
	public ArrayList formSt(int t) {
		double tempS = 0.0;
		double tempB = 0.0;
		double tempC = 0.0;
		if (t <= L) {
			if (t == 1) {
				tempS = ALFA * (timeSeria.get(t - 1).getYt() / (double) c0.get(0)) + (1 - ALFA) * (S0 + b0);
				tempB = BETTA * (tempS - S0) + (1 - BETTA) * b0;
				tempC = GAMMA * (timeSeria.get(t - 1).getYt() / (double) tempS) + (1 - GAMMA) * c0.get(0);updatedTimeSerias.add(new UpdatedTimeSeria(tempS, tempB, tempC));
			} else {
				tempS =
						ALFA * (timeSeria.get(t - 1).getYt() / (double) c0.get(t - 1)) + (1 - ALFA) * (updatedTimeSerias.get((t - 1) - 1)
								.getsT()
								+ updatedTimeSerias.get((t - 1) - 1).getbT());
				tempB = BETTA * (tempS - updatedTimeSerias.get((t - 1) - 1).getsT()) + (1 - BETTA) * updatedTimeSerias.get((t - 1) - 1).getbT();
				tempC = GAMMA * (timeSeria.get(t - 1).getYt() / (double) tempS) + (1 - GAMMA) * c0.get(t - 1);
				updatedTimeSerias.add(new UpdatedTimeSeria(tempS, tempB, tempC));
			}
		} else {
			tempS =
					ALFA * (timeSeria.get(t - 1).getYt() / (double) updatedTimeSerias.get(t -L- 1).getcT()) + (1 - ALFA) * (updatedTimeSerias.get((t - 1) - 1)
							.getsT()
							+ updatedTimeSerias.get((t - 1) - 1).getbT());
			tempB = BETTA * (tempS - updatedTimeSerias.get((t - 1) - 1).getsT()) + (1 - BETTA) * updatedTimeSerias.get((t - 1) - 1).getbT();
			tempC = GAMMA * (timeSeria.get(t - 1).getYt() / (double) tempS) + (1 - GAMMA) * updatedTimeSerias.get(t -L- 1).getcT();
			updatedTimeSerias.add(new UpdatedTimeSeria(tempS, tempB, tempC));
		}

	return updatedTimeSerias;

	}
}
