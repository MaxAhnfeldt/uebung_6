public class Auto {

	public double kilometerstand;
	public double tankinhalt = 40;
	public double benzinverbrauch = 0.1;
	public double maxTankinhalt = 40;

	public void fahre(double kilometer) {
		kilometerstand = kilometerstand + kilometer;
		tankinhalt = tankinhalt - (kilometer * benzinverbrauch);
	}

	public void tanken(int liter) {
		tankinhalt = tankinhalt + liter;
	}

} 