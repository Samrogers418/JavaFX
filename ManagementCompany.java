package company;

import java.util.ArrayList;
import java.util.List;

public class ManagementCompany {

//    name, tax Id, management fee, MAX_PROPERTY (a constant set to 5)
//    and an array named properties of Property objects of size MAX_PROPERTY,
//    as well as two constants MGMT_WIDTH and MGMT_DEPTH, both set to 10;
//    an attribute plot of type Plot

    private String name;
    private String taxId;
    private double managementFee;
    private final int MAX_PROPERTY =5;
    private final int MGMT_WIDTH=10;
    private final int MGMT_DEPTH=10;
    private Plot plot;
    List<Property> properties;

    public ManagementCompany(){
        this.name="";
        this.taxId="";
        this.managementFee=0.00;
        this.plot= new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
        properties= new ArrayList<>();
    }

    public ManagementCompany(String name, String taxId, double managementFee) {
        this.name = name;
        this.taxId = taxId;
        this.managementFee = managementFee;
        this.plot= new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
        properties= new ArrayList<>();

    }

    public ManagementCompany(String name, String taxId, double managementFee, int x, int y,
                             int width, int length) {
        this.name = name;
        this.taxId = taxId;
        this.managementFee = managementFee;
        this.plot = new Plot(x, y, width, length);
        properties= new ArrayList<>();

    }

    public ManagementCompany(ManagementCompany otherManagementCompany){
        this.name = otherManagementCompany.name;
        this.taxId = otherManagementCompany.taxId;
        this.managementFee = otherManagementCompany.managementFee;
        this.plot = new Plot(otherManagementCompany.plot.getX(),otherManagementCompany.plot.getY(),
                otherManagementCompany.plot.getLength(), otherManagementCompany.plot.getWidth());
        properties= new ArrayList<>();

    }

    public int addProperty( Property property){

        if(properties.size()>=MAX_PROPERTY) return -1;
        if(property==null) return -2;
        if(!this.plot.encompasses(property.getPlot())) return -3;

        for(Property p:properties){

            Plot plot1= p.getPlot();
            Plot plot2= property.getPlot();
          if(plot1.overlaps(plot2)) return -4;// means property already exists in the list

        }

        Property property1= new Property(property.getName(),property.getCity()
                ,property.getRentalAmount(),property.getOwner(),property.getPlot().getX(),
                property.getPlot().getY(),property.getPlot().getWidth(), property.getPlot().getLength()
                );

        properties.add(property1);

        //list 0,1,2,3,4

        return  properties.indexOf(property1);

    }

    public int addProperty(String name, String city, double rent, String owner){
        Property property= new Property(name, city, rent, owner);

        if(properties.size()>=MAX_PROPERTY) return -1;
        if(property==null) return -2;
        if(!this.plot.encompasses(property.getPlot())) return -3;

        for(Property p:properties){

            Plot plot1= p.getPlot();
            Plot plot2= property.getPlot();
            if(plot1.overlaps(plot2)) return -4;// means property already exists in the list

        }

        properties.add(property);
        return properties.indexOf(property);

    }
    public int addProperty(String name, String city, double rent, String owner,
                           int x, int y, int length, int width){

        Property property= new Property(name, city, rent, owner, x,  y,  length,  width);

        if(properties.size()>=MAX_PROPERTY) return -1;
        if(property==null) return -2;
        if(!this.plot.encompasses(property.getPlot())) return -3;

        for(Property p:properties){

            Plot plot1= p.getPlot();
            Plot plot2= property.getPlot();
            if(plot1.overlaps(plot2)) return -4;// means property already exists in the list

        }

        properties.add(property);
        return properties.indexOf(property);

    }

    public double totalRent(){

        double totalRent=0.00;

        for(Property p: properties){

            totalRent +=p.getRentalAmount();
        }

        return totalRent;
    }

    private int maxRentalPropertyIndex(){
        double maxRent= 0.00;
        int maxIndex= -1;
      for(Property p: properties){

         if(p.getRentalAmount() > maxRent){
             maxRent= p.getRentalAmount();
             maxIndex= properties.indexOf(p);
         }
      }
      return maxIndex;
    }

    public double maxRentProp(){
        int x= this.maxRentalPropertyIndex();
        Property p= properties.get(x);
        return p.getRentalAmount();

    }



    @Override
    public String toString() {
        System.out.println(" List of the properties for " + this.name+ " , taxID:"+ this.taxId);
        StringBuilder str= new StringBuilder();

        for(Property p: properties){

                str.append("Property Name : "+ p.getName()+ "\n")
                        .append(" Located in : "+ p.getCity()+ "\n")
                        .append(" Belonging to : "+ p.getOwner() +"\n")
                        .append(" Rental Amount : "+ p.getRentalAmount()+ "\n");


      }

        str.append("Total management fee: "+ this.managementFee);

        return str.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public double getManagementFee() {
        return managementFee;
    }

    public void setManagementFee(double managementFee) {
        this.managementFee = managementFee;
    }

    public int getMAX_PROPERTY() {
        return MAX_PROPERTY;
    }

    public int getMGMT_WIDTH() {
        return MGMT_WIDTH;
    }

    public int getMGMT_DEPTH() {
        return MGMT_DEPTH;
    }

    public Plot getPlot() {
        return plot;
    }

    public void setPlot(Plot plot) {
        this.plot = plot;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }
}
