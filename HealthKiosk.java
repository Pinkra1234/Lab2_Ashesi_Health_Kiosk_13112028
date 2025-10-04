//This program is to imitate a self-service kiosk for the Ashesi Health Centre.
import java.util.Random;
import java.util.Scanner;
public class HealthKiosk {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Self-Service Health Kiosk!!");

//Task 1
        System.out.print("Enter service code (P/L/T/C): ");
        char serviceCode = input.next().charAt(0);
        switch (serviceCode) {
            case 'p':
                System.out.print("Go to: Pharmacy Desk");
                break;
            case 'l':
                System.out.print("Go to: Laboratory Desk");
                break;
            case 't':
                System.out.print("Go To: Triage Desk");
                break;
            case 'c':
                System.out.print("Go to: Counseling Desk");
                break;
            default:
                System.out.print("Invalid Service Code");
        }
//Task 2
        System.out.println(" ");
        System.out.print("Kindly Enter Health Metric: ");
        System.out.println(" ");
        System.out.println("1. BMI");
        System.out.println("2. Dosage round-up");
        System.out.println("3. Trig helper");
        System.out.print("Choose your preferred choice(1/2/3): ");
        int options = input.nextInt();


        double round = 0;
        switch (options) {
            case 1:
                System.out.print("Weight in kilograms: ");
                double weight = input.nextDouble();
                System.out.print("Height in metres: ");
                double height = input.nextDouble();

                double BMI = weight / Math.pow(height, 2);
                round = Math.round(BMI * 10) / 10.0;
                if (round < 18.5) {
                    System.out.println("BMI: " + round + ", Category: Underweight");
                } else if (round >= 18.5 && round <= 24.9) {
                    System.out.println("BMI: " + round + ", Category: Normal");
                } else if (round >= 25.0 && round <= 29.9) {
                    System.out.println("BMI: " + round + ", Category: Overweight");
                } else if (round >= 30) {
                    System.out.println("BMI: " + round + ", Category: Obese");
                } else {
                    System.out.println();
                }
                break;

            case 2:
                System.out.print("Enter your required dosage (mg): ");
                double dosage = input.nextDouble();
                int tablets = (int) (Math.ceil(dosage / 250.0));
                System.out.print("Tablets needed: " + tablets);
                break;
            case 3:
                System.out.print("Kindly enter the angle: ");
                double degrees = input.nextDouble();
                double rad = Math.toRadians(degrees);
                double sine = (Math.round(Math.sin(rad) * 1000) / 1000.0);
                double cosine = (Math.round(Math.cos(rad) * 1000) / 1000.0);
                System.out.print(" The sin of the angle: " + sine);
                System.out.print(" The cos of the angle: " + cosine);
                break;
            default:
                System.out.println("No option like that available");
        }
//Task 3
        System.out.println(" ");
        Random number = new Random();
        char letter = (char) ('A' + number.nextInt(26));
        String code = "" + letter + (3 + (int) (Math.random() * 7)) + (3 + (int) (Math.random() * 7)) + (3 + (int) (Math.random() * 7)) + (3 + (int) (Math.random() * 7));
        System.out.println("Short code: " + code);
        if (code.length() == 5 && Character.isLetter(code.charAt(0)) && (Character.isDigit(code.charAt(1)) && Character.isDigit(code.charAt(2)) && Character.isDigit(code.charAt(3)) && Character.isDigit(code.charAt(4))) ){
            System.out.print("ID OK");
        } else if (!(Character.isLetter(code.charAt(0)))) {
            System.out.println("Invalid code:first char must be a letter");
        } else if (!(Character.isDigit(code.charAt(1)) && Character.isDigit(code.charAt(2)) && Character.isDigit(code.charAt(3)) && Character.isDigit(code.charAt(4)))) {
            System.out.println("Invalid: last 4 must be digits");
        } else {
            System.out.println("Invalid length");
        }




//Task4
        input.nextLine();
        System.out.print(" Kindly Enter your first name: ");
        String name = input.nextLine();
        char first = Character.toUpperCase(name.charAt(0));
        System.out.print("Base code = " + first);
        System.out.println(" ");
        char shiftedLetter = (char) ('A' + (first - 'A' + 2) % 26);
        System.out.println("Shifted letter of the base = " + shiftedLetter);
        String lastTwo = code.substring(code.length() - 2);
        System.out.println("Last two characters for ID (Task 3): " + lastTwo);
        double bmi = round;
        int metric = (int) Math.round(bmi);
        String displayCode = shiftedLetter + lastTwo + "-" + metric;
        System.out.println("Display code: " + displayCode);

//Task5
        String summary = "";
        switch (serviceCode) {
            case 'P':
                System.out.println("Summary: PHARMACY | ID = " + code + "| Code = " + displayCode);
                break;
            case 'T':
                System.out.println("Summary: TRIAGE | ID = " + code + "BMI = " + round + "| Code = " + displayCode);
                break;
            case 'L':
                System.out.println("Summary: LABORATORY | ID = " + code + "| Code = " + displayCode);
                break;
            case 'C':
                System.out.println("Summary: COUNSELING | ID = " + code + "| Code = " + displayCode);
                break;
            default:
                System.out.println("No known summary");
        }
    }
}