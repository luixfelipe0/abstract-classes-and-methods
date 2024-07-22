package Entities;

public class Company extends TaxPayer{

    public Integer numberOfEmployees;

    public Company(String name, Double annualIncome, Integer numberOfEmployees) {
        super(name, annualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    public Integer getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(Integer numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public Double totalTax() {
        Double totalTax =
                (getNumberOfEmployees() > 10) ?
                getAnnualIncome() * 0.14 :
                getAnnualIncome() * 0.16;

        return totalTax;
    }
}
