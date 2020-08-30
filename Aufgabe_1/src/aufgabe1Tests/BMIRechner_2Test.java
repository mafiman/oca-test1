/**
 * BMIRechner Konsoleneingabe
 * Benutzt die Klasse BMIRechner_2 für die Details
 */
package aufgabe1Tests;

/**
 * @author martin
 *
 */
public class BMIRechner_2Test {

	public static void main(String[] args) {

		int bmiValue = 0;

		BMIRechner_2 bmiRechner_2 = new BMIRechner_2();

		// Werte holen
		int iInputDialogOK = bmiRechner_2.InputDialog();

		if (iInputDialogOK != 0) {
			System.out.println("Bei der Eingabe gab es ein Problem, keine BMI Berechnung.");
		} else {

			// iHeigth, dWeight werden intern in bmiRechner_2 gehalten
			bmiValue = bmiRechner_2.bmiCalculate();
			if (bmiValue == -1) {
				System.out.println("Es gab ein Problem mit deiner Groesse, bitte ");
				System.out.println("gib die Werte in Zahlen ohne Masseinheit an. ZBsp Groesse: 158 ");
			} else if (bmiValue == -2) {
				System.out.println("Es gab ein Problemmit deinem Gewicht, bitte ");
				System.out.println("gib die Werte in Zahlen ohne Masseinheit an. ZBsp Gewicht: 70.5");
			} else if (bmiValue == 0) {
				System.out.println("Es gab ein Problem bei der Berechnung, bitte ");
				System.out.println("gib die Werte in Zahlen ohne Masseinheit an."); 
				System.out.println("ZBsp Groesse: 158 Gewicht: 70.5");
			} else {
				System.out.println("Dein BMI ist " + bmiValue);

				if (bmiRechner_2.getiAge() < 19) {
					System.out.println("Du bist zu jung um eingestuft zu werden, ");
				} else {
					// Werte werden in BMIRechner_2 gekapselt gehalten - bmiValue, iAge
					int iBmiEvaluate = bmiRechner_2.bmiEvaluate();
					if (iBmiEvaluate < 0) {
						System.out.println("Bitte achte auf deine Ernaehrung, dein BMI Wert ist ");
						System.out.println("fuer deine Altersgruppe zu niedrig.");
					} else if (iBmiEvaluate == 0) {
						System.out.println("Dein BMI Wert ist für deine Altersgruppe ideal.");
						System.out.println("Du solltest trotzdem auf eine gesunde Ernährung achten.");
					} else if (iBmiEvaluate > 0) {
						System.out.println("Bitte achte auf deine Ernaehrung, dein BMI Wert ist ");
						System.out.println("für deine Altersgruppe zu hoch.");
					}

				} // end bmiEvaluate

			} // end bmiValue berechnet
		} // end Input war nicht ok, keine BMI Berechnung

	}// end main

}
