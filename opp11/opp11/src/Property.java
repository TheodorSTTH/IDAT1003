public class Property {
    private int municipalityNumber;
    private String municipalityName;
    private int lotNumber; //gnr gårdsnummer
    private int sectionNumber; //bnr
    private String name;
    private double area;
    private String nameOfOwner;

    public Property(int municipalityNumber, String municipalityName, int lotNumber, int sectionNumber, String name, double area, String nameOfOwner) {
        this.municipalityNumber = municipalityNumber;
        this.municipalityName = municipalityName;
        this.lotNumber = lotNumber;
        this.sectionNumber = sectionNumber;
        this.name = name;
        this.area = area;
    }

    public String getId() {
        return municipalityNumber + "-" + lotNumber + "/" + sectionNumber;
    }

    public int getMunicipalityNumber() {
        return municipalityNumber;
    }
    
    public String getMunicipalityName() {
        return municipalityName;
    }
    
    public int getLotNumber() {
        return lotNumber;
    }
    
    public int getSectionNumber() {
        return sectionNumber;
    }
    
    public String getName() {
        return name;
    }
    
    public double getArea() {
        return area;
    }
    public void setArea(double area) {
        this.area = area; // in case someone builds something new or buys land
    }
    
    public String getNameOfOwner() {
        return nameOfOwner;
    }
    public void setNameOfOwner(String nameOfOwner) {
        this.nameOfOwner = nameOfOwner; // in case owner changes
    }

    @Override
    public String toString() {
        return "Property ID: " + getId() + "\n" +
            "Municipality Number: " + this.municipalityNumber + "\n" +
            "Municipality Name: " + this.municipalityName + "\n" +
            "Lot Number: " + this.lotNumber + "\n" +
            "Section Number: " + this.sectionNumber + "\n" +
            "Name: " + this.name + "\n" +
            "Area: " + this.area + "\n" +
            "Owner's Name: " + this.nameOfOwner + "\n";
    }
}
