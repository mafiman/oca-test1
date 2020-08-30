/**
 * BMIRechner Konsoleneingabe
 * Diese KLasse enthält alle Methoden und Objekte 
 * zur Berechnung und Klassifizierung des BMI
 */
package aufgabe1Tests;

import java.util.Scanner;

/**
 * @author martin
 *
 */
public class BMIRechner_2 {

	private int iHeigth = 0;
	private double dWeight = 0;
	private int iAge = 0;
	private int iBMI = 0;

	/**
	 * @return Groesse des Benutzers
	 */
	public int getiHeigth() {
		return iHeigth;
	}

	/**
	 * @param iHeigth Die Groesse des Bneutzers setzen
	 */
	public void setiHeigth(int iHeigth) {
		this.iHeigth = iHeigth;
	}

	/**
	 * @return Das Gewicht des Benutzers.
	 */
	public double getdWeight() {
		return dWeight;
	}

	/**
	 * @param dWeight Das Gewicht des Benutzers setzen
	 */
	public void setdWeight(double dWeight) {
		this.dWeight = dWeight;
	}

	/**
	 * @return the iAge Das Alter des Benutzers
	 */
	public int getiAge() {
		return iAge;
	}

	/**
	 * @param iAge Das Alter des Benutzers setzen.
	 */
	public void setiAge(int iAge) {
		this.iAge = iAge;
	}

	/**
	 * Fragt den Benutzer nach Daten und füllt erkannte Daten in
	 * Klasseninstanzobjekte. Gefüllt werden iAge, iHeigth, dWeight
	 * 
	 * @return 0 alles ok -1 zu Jung -2 Alter nicht erkannt -3 Grösse nicht erkannt
	 *         -4 Gewicht nicht erkannt
	 */
	public int InputDialog() {
		// Input scanner generieren
		Scanner sInput = new Scanner(System.in);
		String sInputString;

		int iRetVal = 0;

		System.out.println("Dieses Programm berechnet deinen BMI aus den Eingaben.");
		System.out.println("Bitte dein Alter in Jahren angeben:");
		sInputString = sInput.nextLine();
		try {
			iAge = Integer.parseUnsignedInt(sInputString);

			if (iAge < 19) {
				System.out.println("Bei einem Alter unter 19 Jahren macht das Berechnen des BMI");
				System.out.println("noch keinen Sinn. Du wächst noch und kannst dich später damit befassen.");
				iRetVal = -1;
			}
		} catch (Exception e) {
			System.err.println("Beim Eingeben deines Alters ist ein Fehler aufgetreten.");
			System.err.println("Bitte gib das Alter in Jahren als ganze Zahl an.");
			iAge = 0;
			iRetVal = -2;
		}
		if (iRetVal == 0) {
			System.out.println("Bitte deine Gr�sse in Zentimetern als ganze Zahl angeben:");
			sInputString = sInput.nextLine();
			try {
				iHeigth = Integer.parseInt(sInputString);
				
			} catch (Exception e) {
				System.err.println("Beim Eingeben deiner Groesse ist ein Fehler aufgetreten.");
				System.err.println("Bitte gib deine Groesse in cm als ganze Zahl an.");
				iRetVal = -3;
			}
		}
		if (iRetVal == 0) {
			System.out.println("Bitte dein Gewicht in KG angeben:");
			sInputString = sInput.nextLine();
			try {
				dWeight = Double.parseDouble(sInputString);
			} catch (Exception e) {
				System.err.println("Beim Eingeben deines Gewichts ist ein Fehler aufgetreten.");
				System.err.println("Bitte gib dein Gewicht in Kilogramm als Zahl mit einem \".\" an.");
				iRetVal = -4;
			}
		}
		sInput.close();
		return iRetVal;
	}

	/**
	 * Berechnet den BMI nach dem die Werte eingegeben worden sind.
	 * 
	 * @return bmi Wert, -1 bei Groessenproblem, -2 bei Gewichtsproblem
	 */
	public int bmiCalculate() {
		int iRetVal = 0;
		// Sicherheitsabfragen
		if (iHeigth <= 0 || iHeigth < 120 || iHeigth > 240) {
			iRetVal = -1;
		}
		if (dWeight <= 0) {
			iRetVal = -2;
		}
		if (iRetVal == 0) {
			double dHeigth = iHeigth / 100.0;
			double dBMI = (dWeight / (dHeigth * dHeigth));
			iRetVal = (int) Math.ceil(dBMI);
		}
		
		this.iBMI = iRetVal;
		return iRetVal;
	}

	/**
	 * Berechnet den Altersbereich in dem sich das angegebene Alter befindet.
	 * 
	 * @param iAge
	 * @return Altersbereich für BMI Berechnung. 0 ist zu jung...
	 */
	private int iAgeRange(int iAge) {
		int iRetVal = 0;
		if (iAge >= 19 && iAge <= 24) {
			iRetVal = 1;
		}
		if (iAge >= 25 && iAge <= 34) {
			iRetVal = 2;
		}
		if (iAge >= 35 && iAge <= 44) {
			iRetVal = 3;
		}
		if (iAge >= 45 && iAge <= 54) {
			iRetVal = 4;
		}
		if (iAge >= 55 && iAge <= 64) {
			iRetVal = 5;
		}
		if (iAge > 64) {
			iRetVal = 6;
		}

		return iRetVal;
	}

	/**
	 * Berechnet aus dem BMI Wert ob der ok ist.
	 * 
	 * @return <0 BMI zu gering, besser zunehmen, 0 Idealbereich, >0 bitte im Auge
	 *         behalten
	 * @return
	 */
	public int bmiEvaluate() {
		int iRetVal = 0;
		int iBMIRange = iAgeRange(iAge);

		int iUnterGrenze = 0;
		int iOberGrenze = 0;

		switch (iBMIRange) {
		case 0:
			// Zu jung um getestet zu werden.
			iUnterGrenze = 0;
			iOberGrenze = 0;
			break;
		case 1:
			iUnterGrenze = 19;
			iOberGrenze = 24;
			break;
		case 2:
			iUnterGrenze = 20;
			iOberGrenze = 25;
			break;
		case 3:
			iUnterGrenze = 21;
			iOberGrenze = 26;
			break;
		case 4:
			iUnterGrenze = 22;
			iOberGrenze = 27;
			break;
		case 5:
			iUnterGrenze = 23;
			iOberGrenze = 28;
			break;
		case 6:
			iUnterGrenze = 24;
			iOberGrenze = 29;
			break;
		default:
			// keine Ahnung, zur Sicherheit...
			iUnterGrenze = 0;
			iOberGrenze = 0;
			break;
		}
		if (iUnterGrenze > 0) {
			if (iBMI < iUnterGrenze) {
				// zu niedrig
				iRetVal = -1;
			}
			if (iBMI >= iUnterGrenze && iBMI <= iOberGrenze) {
				// ideal
				iRetVal = 0;
			}
			if (iBMI > iOberGrenze) {
				// zu hoch
				iRetVal = 1;
			}
		} else {
			System.err.println("Achtung, Problem den Wert einzustufen.");
		}
		return iRetVal;
	}

}
