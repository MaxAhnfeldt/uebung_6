
public class Person {

	public String vorname;
	public String nachname;
	public double geburtsjahr;
	
	public Person(String vorname, String nachname, int geburtsjahr);
	vorname=vorn;
	nachname=nachn;
	geburtsjahr=geburtsj;
	
	public static void main(String[] args) {

		person1 = new Person("Mad", "Max", 1995);
		person2 = new Person("Hans", "Wurst", 1980);

		System.out.println(person1.vorname + person1.nachname + "ist " + (2016 - person1.geburtsjahr) + " Jahre alt.");
		System.out.println(person2.vorname + person2.nachname + "ist " + (2016 - person2.geburtsjahr) + " Jahre alt.");

	}
}}