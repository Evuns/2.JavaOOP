package interfacesAbstraction.lab.carShopExtended;

public class Audi extends CarImpl implements Rentable {

    private Integer minRentDay;
    private Double pricePerDay;

    public Audi(String model, String color, Integer horsepower, String countryProduced, Integer minRentDay, Double pricePerDay) {
        super(model, color, horsepower, countryProduced);
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }

    public  String toString(){
        String format = "Minimum rental period of %d days. Price per day %f";
        return String.format(format, this.minRentDay, this.pricePerDay);
    }

    @Override
    public Integer getMinRentDay() {
        return this.minRentDay;
    }

    @Override
    public Double getPricePerDay() {
        return this.pricePerDay;
    }
}
