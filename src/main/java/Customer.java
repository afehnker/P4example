
import java.util.Enumeration;
import java.util.Vector;

import java.util.Enumeration;
import java.util.Vector;

class Customer {
    private String _name;
    private Vector<Rental> _rentals = new Vector<Rental>();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    public double getOwed() {
        double totalAmount = 0;
        Enumeration<Rental> rentals = _rentals.elements();

        while (rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) rentals.nextElement();
            // determine amounts for each line
            switch (each.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.getDaysRented() > 2)
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += each.getDaysRented() * 3;
                    break;
                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if (each.getDaysRented() > 3)
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    break;
            }

            // show figures for this rental
            totalAmount += thisAmount;
        }
        return totalAmount;
    }

    public int getPoints() {
        int frequentRenterPoints = 0;
        Enumeration<Rental> rentals = _rentals.elements();

        while (rentals.hasMoreElements()) {

            Rental each = (Rental) rentals.nextElement();

            // add frequent renter points
            frequentRenterPoints++;

            // add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
                frequentRenterPoints++;
            // show figures for this rental
        }
        return frequentRenterPoints;
    }




}