package Entities;

public class Individual extends TaxPayer {

    private Double healthExpenditures;

    public Individual(String name, Double annualIncome, Double healthExpenditures) {
        super(name, annualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    public Double getHealthExpenditures() {
        return healthExpenditures;
    }

    public void setHealthExpenditures(Double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public Double totalTax() {
        Double totalTax =
                (getAnnualIncome() < 20000.0) ?
                getAnnualIncome() * 0.15 :
                getAnnualIncome() * 0.25;

        if (getHealthExpenditures() > 0.0) {
            totalTax -= getHealthExpenditures() * 0.5;
        }

        return totalTax;
    }
}
