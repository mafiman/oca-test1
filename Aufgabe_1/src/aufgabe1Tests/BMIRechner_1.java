/**
 * BMIRechner Konsoleneingabe
 * Alles geschieht in einer Klasse, statische Variablen und Zugriff ist private.
 * Git online test.
 */
package aufgabe1Tests;

import java.util.Scanner;

/**
 * @author martin
 *
 */
public class BMIRechner_1 {

	private static int iHeigth = 0;
	private static double dWeight = 0;
	private static int iAge = 0;

	public static void main(String[] args) {

		int bmiValue = 0;

		// Werte holen
		int iInputDialogOK = InputDialog();

		if (iInputDialogOK != 0) {
			System.out.println("Bei der Eingabe gab es ein Problem, keine BMI Berechnung.");
		} else {

			bmiValue = bmiCalculate(iHeigth, dWeight);
			if (bmiValue == -1) {
				System.out.println("Es gab ein Problem mit deiner Groesse, bitte ");
				System.out.println("gib die Werte in Zahlen an. ZBsp Groesse: 158 ");
			} else if (bmiValue == -2) {
				System.out.println("Es gab ein Problemmit deinem Geweicht, bitte ");
				System.out.println("gib die Werte in Zahlen an. ZBsp Gewicht: 70.5");
			} else if (bmiValue == 0) {
				System.out.println("Es gab ein Problem bei der Berechnung, bitte ");
				System.out.println("gib die Werte in Zahlen an. ZBsp Groesse: 158 Gewicht: 70.5");
			} else {
				System.out.println("Dein BMI ist " + bmiValue);

				if (iAge < 19) {
					System.out.println("Du bist zu jung um eingestuft zu werden, ");
				} else {
					int iBmiEvaluate = bmiEvaluate(bmiValue, iAge);

					if (iBmiEvaluate < 0) {
						System.out.println("Bitte achte auf deine Ern�hrung, dein BMI Wert ist ");
						System.out.println("f�r deine Altersgruppe zu niedrig.");
					} else if (iBmiEvaluate == 0) {
						System.out.println("Dein BMI Wert ist f�r deine Altersgruppe ideal.");
						System.out.println("Du solltest trotzdem auf eine gesunde Ern�hrung achten.");
					} else if (iBmiEvaluate > 0) {
						System.out.println("Bitte achte auf deine Ern�hrung, dein BMI Wert ist ");
						System.out.println("f�r deine Altersgruppe zu hoch.");
					}

				} // end bmiEvaluate

			} // end bmiValue berechnet
		} // end Input war nicht ok, keine BMI Berechnung

	}// end main

	/**
	 * Fragt den Benutzer nach Daten und füllt erkannte Daten in
	 * Klasseninstanzobjekte. Gefüllt werden iAge, iHeigth, dWeight
	 * 
	 * @return 0 alles ok -1 zu Jung -2 Alter nicht erkannt -3 Grösse nicht erkannt
	 *         -4 Gewicht nicht erkannt
	 */

	private static int InputDialog() {// Input scanner generieren
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
	 * 
	 * @param iHeigth Groesse in cm
	 * @param dWeight Gewicht in KG
	 * @return >0 BMI, -1 Probleme mit der Grösse, -2 Probleme mit dem Gewicht.
	 */
	private static int bmiCalculate(int iHeigth, double dWeight) {
		int iRetVal = 0;
		// Sicherheitsabfragen
		if (iHeigth <= 0 || iHeigth <120 || iHeigth>240) {
			iRetVal=-1;
		}
		if (dWeight <= 0 ) {
			iRetVal=-2;
		}
		if (iRetVal == 0) {
			double dHeigth = iHeigth / 100.0;
			double dBMI = (dWeight / (dHeigth * dHeigth));
			iRetVal = (int) Math.ceil(dBMI);
		}
		return iRetVal;
	}

	/**
	 * Berechnet den Altersbereich in dem sich das angegebene Alter befindet.
	 * 
	 * @param iAge
	 * @return Altersbereich für BMI Berechnung. 0 ist zu jung...
	 */
	private static int iAgeRange(int iAge) {
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
	 * @param iBMI
	 * @param iAge
	 * @return <0 BMI zu gering, besser zunehmen, 0 Idealbereich, >0 bitte im Auge
	 *         behalten
	 */
	private static int bmiEvaluate(int iBMI, int iAge) {
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
