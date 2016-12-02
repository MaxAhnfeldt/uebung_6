
public class AutoTester {

	public static void main(String[] args) {
		{
			Auto testwagen1 = new Auto();
			Auto testwagen2 = new Auto();

			int i = 0;
			while (i < 10) {
				int streckeA = Zufall.getZufallInt(0, 200);
				int streckeB = Zufall.getZufallInt(0, 200);

				if (streckeA * testwagen1.benzinverbrauch <= testwagen1.tankinhalt) {
					testwagen1.fahre(streckeA);
					System.out.println("Das erste Auto ist " + testwagen1.kilometerstand
							+ "km gefahren und hat einen Tankinhalt von " + testwagen1.tankinhalt + "l.");
				} else {

					int tankmenge1 = (int) (testwagen1.maxTankinhalt - testwagen1.tankinhalt);
					testwagen1.tanken(tankmenge1);
					System.out.println("Auto 1 hat  " + tankmenge1 + "l getankt.");

				}
				if (streckeB * testwagen2.benzinverbrauch <= testwagen2.tankinhalt) {
					testwagen2.fahre(streckeB);
					System.out.println("Das zweite Auto ist " + testwagen2.kilometerstand
							+ "km gefahren und hat einen Tankinhalt von " + testwagen2.tankinhalt + "l.");
				} else {
					int tankmenge2 = (int) (testwagen2.maxTankinhalt - testwagen2.tankinhalt);
					testwagen2.tanken(tankmenge2);
					System.out.println("Auto 2 hat " + tankmenge2 + "l getankt.");
				}
				
				i++;
			}
		}
	}
}