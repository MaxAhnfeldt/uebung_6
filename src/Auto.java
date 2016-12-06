public class Auto {

	public double kilometerstand;

	public double tankinhalt;

	public final double maxTankVolumen;

	public final double verbrauchProKm;

	public double profiltiefeReifen;

	public final double profiltiefeNeuerReifen = 0.8;

	public final double minimalErlaubteProfiltiefe = 0.3;

	public final double reifenabnutzungProKm = 0.00025;

	public final String wagenname;

	public Person fahrer;

	private final int fahrgestellnummer = letzteFahrgestellnummer++;

	private static int letzteFahrgestellnummer=1;

	public Auto(double maxTankVolumen, double verbrauchProKm, String wagenname) {
		this.maxTankVolumen = maxTankVolumen;
		this.verbrauchProKm = verbrauchProKm;
		this.wagenname = wagenname;
		
		

		tanken();
		wechsleReifen();
	}

	public Person getFahrer() {
		return fahrer;
	}

	public void setFahrer(Person fahrer) {
		this.fahrer = fahrer;
	}

	public void fahre(double km) {
		if (!isFahrerOk()) {
			return;
		}

		double reichweite = bestimmeReichweite();

		double wirklichGefahreneKm;
		if (km > reichweite) {
			wirklichGefahreneKm = reichweite;
		} else {
			wirklichGefahreneKm = km;
		}

		kilometerstand = kilometerstand + wirklichGefahreneKm;
		tankinhalt = tankinhalt - (getBenzinverbrauchProKm() * wirklichGefahreneKm);
		profiltiefeReifen = profiltiefeReifen - (getReifenAbnutzungProKm() * wirklichGefahreneKm);

	}

	public double bestimmeReichweite() {
		double reichweiteTank = tankinhalt / getBenzinverbrauchProKm();

		double verfahrbaresRestprofil = profiltiefeReifen - minimalErlaubteProfiltiefe;
		double reichweiteReifen = verfahrbaresRestprofil / getReifenAbnutzungProKm();

		if (reichweiteReifen < reichweiteTank) {
			return reichweiteReifen;
		} else {
			return reichweiteTank;
		}
	}

	public double getReifenAbnutzungProKm() {
		if (!isFahrerOk()) {
			return 0;
		}
		if (fahrer.getAlter() <= 20) {
			return reifenabnutzungProKm * 1.05;
		}
		if (fahrer.getAlter() >= 60) {
			return reifenabnutzungProKm * 0.95;
		}
		return reifenabnutzungProKm;
	}

	public double getBenzinverbrauchProKm() {
		if (!isFahrerOk()) {
			return 0;
		}
		if (fahrer.getAlter() <= 20) {
			return verbrauchProKm * 1.10;
		}
		if (fahrer.getAlter() >= 60) {
			return verbrauchProKm * 0.90;
		}
		return verbrauchProKm;
	}

	public boolean isFahrerOk() {
		if (fahrer == null) {
			return false;
		}
		if (fahrer.getAlter() < 18) {
			return false;
		}
		return true;
	}

	public void gebeDatenAus() {
		String fahrername = "Kein Fahrer";
		if (fahrer != null) {
			fahrername = fahrer.getName();
		}
		System.out.println(wagenname +" ("+fahrgestellnummer+") : " + fahrername + " am Steuer, " + kilometerstand
				+ " bisher gefahren. Tankinhalt " + tankinhalt + " liter und " + profiltiefeReifen
				+ " mm Reifenprofil uebrig.");
	}

	public void tanken() {
		tankinhalt = maxTankVolumen;
	}

	public void wechsleReifen() {
		profiltiefeReifen = profiltiefeNeuerReifen;

	}

	public void tanken(double liter) {
		if (liter + tankinhalt > maxTankVolumen) {
			tanken();
		} else {
			this.tankinhalt = liter + tankinhalt;
		}
	}

	public String getWagenname() {
		return wagenname;
	}

}
