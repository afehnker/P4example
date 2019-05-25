
import java.util.Enumeration;
import java.util.Vector;

class Customer {
    private String _name;
    private Vector<Rental> _rentals = new Vector<Rental>();
    private double totalAmount = 0;
    private int frequentRenterPoints = 0;

    public Customer(String name) {
        _name = name;
    };

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    };

    public double getOwed() {
        return totalAmount;
    }

    public int getPoints() {
        return frequentRenterPoints;
    }

    public void update() {
        frequentRenterPoints = 0;
        totalAmount = 0;
        Enumeration<Rental> rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {

            Rental each = (Rental) rentals.nextElement();
            // determine amounts for each line

            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
                frequentRenterPoints++;

            totalAmount += each._movie.amountFor(each);
        }

    }
}
