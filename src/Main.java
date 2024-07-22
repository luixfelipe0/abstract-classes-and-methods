import Entities.Company;
import Entities.Individual;
import Entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();

        List<TaxPayer> taxPayers = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            System.out.println("Tax payer #" + i + " data: ");
            System.out.print("Individual or company (i/c)?");
            char taxPayer = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Annual income: ");
            Double income = sc.nextDouble();

            if(taxPayer == 'i') {
                System.out.print("Health expenditures: ");
                Double healthExpenditures = sc.nextDouble();
                taxPayers.add(new Individual(name, income, healthExpenditures));
            } else {
                System.out.println("Number of employees: ");
                Integer numberOfEmployees = sc.nextInt();
                taxPayers.add(new Company(name, income, numberOfEmployees));
            }
        }

        System.out.println();
        System.out.println("TAXES PAID: ");

        Double sum = 0.0;

        for(TaxPayer payer : taxPayers) {
            Double totalTax = payer.totalTax();
            sum += totalTax;
            System.out.println(payer.getName() + " $ " + totalTax);
        }

        System.out.println();
        System.out.printf("TOTAL TAXES: %.2f $ ", sum);
    }
}