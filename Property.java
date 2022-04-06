package company;

public class Property {

    private String name;
    private String city;
    private String owner;
    private double rentalAmount;
    private Plot plot;


    public Property() {

    }

    public Property(Property property) {
        this.name= property.name;
        this.city= property.city;
        this.rentalAmount= property.rentalAmount;
        this.owner= property.owner;
        this.plot= new Plot(property.plot.getX(), property.plot.getY()
        , property.plot.getWidth(), property.plot.getLength());

            }

    public Property(String name, String city, double rentalAmount, String owner) {
        this.name = name;
        this.city = city;
        this.rentalAmount = rentalAmount;
        this.owner = owner;
        Plot plot= new Plot(0,0,1,1);
    }

    public Property(String name, String city, double rentalAmount, String owner, int x, int y,
                    int width, int length) {
        this.name = name;
        this.city = city;
        this.rentalAmount = rentalAmount;
        this.owner = owner;
        this.plot= new Plot(x,y,width,length);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getRentalAmount() {
        return rentalAmount;
    }

    public void setRentalAmount(double rentalAmount) {
        this.rentalAmount = rentalAmount;
    }

    public Plot getPlot() {
        return plot;
    }

    public void setPlot(Plot plot) {
        this.plot = plot;
    }

    public boolean overlaps(Plot plot){
        return true;

    }

    public boolean encompassses(Plot plot){
        return true;

    }

    @Override
    public String toString() {
        return "Property{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", owner='" + owner + '\'' +
                ", rentalAmount=" + rentalAmount +
                '}';
    }
}
