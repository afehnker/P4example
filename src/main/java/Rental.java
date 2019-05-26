class Rental {
    Movie _movie;
    private int _daysRented;

    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

    double getCharge() {
        double thisAmount = 0;
        switch (_movie.getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (getDaysRented() > 2)
                    thisAmount += (_daysRented - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                thisAmount += _daysRented * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (getDaysRented() > 3)
                    thisAmount += (_daysRented - 3) * 1.5;
                break;
        }
        return thisAmount;
    }

    int getFrequentRenterPoints() {
        // add frequent renter points
        int points = 1;

        // add bonus for a two day new release rental
        if ((_movie.getPriceCode() == Movie.NEW_RELEASE) && _daysRented > 1)
            points++;
        // show figures for this rental
        return points;
    }
}