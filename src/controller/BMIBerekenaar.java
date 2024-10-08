package controller;

import java.util.Scanner;
import java.lang.Math;

/* De BMI (Body Mass Index) is een maat om te berekenen of iemand een gezond gewicht heeft.
Dit is een calculator die BMI berekend en op basis daarvan advies geeft.
Mvg, Danny Kwant */
public class BMIBerekenaar {

    // Public methoden
    public static double bmiBerekenen(double lengte, double gewicht) {
        return Math.round(gewicht / (Math.pow(lengte, 2)) * 10.0) / 10.0;
    }

    public static String bepaalCategorie(double bmi) {
        final double grensOndergewicht = 18.5;
        final double grensGezondGewicht = 25.0;
        final double grensOvergewicht = 30.0;
        final String jouwBMI = "Jouw BMI is: ";
        String bmiUitslag;

        if (bmi < grensOndergewicht) {
            bmiUitslag = jouwBMI + bmi + " en is te laag. Ga meer eten!";
            return bmiUitslag;
        } else if (bmi >= grensOndergewicht && bmi <= grensGezondGewicht) {
            bmiUitslag = jouwBMI + bmi + " en gezond! Proficiat, ga zo door! :-)";
            return bmiUitslag;
        } else if (bmi > grensGezondGewicht && bmi <= grensOvergewicht) {

            bmiUitslag = jouwBMI + bmi + " en hebt overgewicht. Het zou geen slecht idee zijn om gezonder te gaan eten en meer te bewegen";
            return bmiUitslag;
        } else {
            bmiUitslag = jouwBMI + bmi + " en hebt obesitas.\nJij moet echt gezonder gaan eten en veel meer bewegen, voordat het te laat is.";
            return bmiUitslag;
        }

    }

    public static void main(String[] args) {

        // Variabelen
        int lengteInCM;
        double lengteInM;
        double gewicht;
        double bmi;

        // initialize scanner
        Scanner scanner = new Scanner(System.in);

        // Print welkomstbericht en vraag daarna om lengte in cm op te geven
        System.out.println("De BMI (Body Mass Index) is een maat om te berekenen of iemand een gezond gewicht heeft.\nDit is een calculator die BMI berekend en op basis daarvan advies geeft.\n");
        System.out.println("Om verder te gaan, geef je lengte op in centimeters:");

        lengteInCM = scanner.nextInt();
        lengteInM = lengteInCM / 100.0; // converteer resultaat naar meters

        // Vraag gewicht in kg op
        System.out.println("Geef je gewicht op in kilogram:");

        gewicht = scanner.nextDouble();

        // Nu beide variabelen gevuld zijn, call bmiBerekenen om het BMI van de gebruiker op te slaan in variabele bmi
        bmi = bmiBerekenen(lengteInM, gewicht);

        // Print BMI gebruiker en aan de hand van de methode laat een melding zien die past bij het BMI van de gebruiker
        System.out.println(bepaalCategorie(bmi));

    }
}
