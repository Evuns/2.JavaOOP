package WorkingWithAbstraction.Lab.HotelReservation;

public class PriceCalculator {

    public String calculator(Reservation reservation) {
        double basePrice = reservation.getPricePerDay() * reservation.getDays() * reservation.getSeason().getMultiplier();
        double priceWithDiscount = basePrice - basePrice * reservation.getDiscountType().getDiscount();
        return String.format("%.2f",priceWithDiscount);
    }
}
