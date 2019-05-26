public class Movie  {
    public static final int  CHILDRENS = 2;
    public static final int  REGULAR = 0;
    public static final int  NEW_RELEASE = 1;

    private String _title;
    private Price _price;

    public Movie(String name, int priceCode) {
        _title = name;
        setPriceCode(priceCode);

    }

    public int getPriceCode() {
        return _price.getPriceCode();
    }


    public void setPriceCode(int newPrice) {
        switch (newPrice) {
            case REGULAR:
                _price = new RegularPrice();
                break;
            case CHILDRENS:
                _price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                _price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    public String getTitle(){
        return _title;
    }

    int getPoints(int dayRented) {
        int points = 1;

        // add bonus for a two day new release rental
        if ((getPriceCode() == NEW_RELEASE) && dayRented > 1)
            points++;
        // show figures for this rental
        return points;
    }

    double getCharge(int daysRented) {
        return _price.getCharge(daysRented);
    }
}
