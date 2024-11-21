import java.util.ArrayList;

public class PropertyRegister {
    private final ArrayList<Property> properties;

    public PropertyRegister(ArrayList<Property> properties) {
        this.properties = properties;
    }

    public void addProperty(Property newProperty) {
        properties.add(newProperty); 
    }
    public void removeProperty(int municipalityNumber, int lotNumber, int sectionNumber) {
        this.properties.remove(getProperty(municipalityNumber, lotNumber, sectionNumber));
    }
    public int getAmountOfProperties() {
        return this.properties.size();
    }
    public Property getProperty(int municipalityNumber, int lotNumber, int sectionNumber) {
        Property out = null;
        for (Property currentProperty : properties) {
            if (currentProperty.getMunicipalityNumber() == municipalityNumber && currentProperty.getLotNumber() == lotNumber && currentProperty.getSectionNumber() == sectionNumber) {
                out = currentProperty;
            }
        }
        return out;
    }
    public double getAverageArea() {
        double areaSum = 0;
        for (Property currentProperty : properties) {
            areaSum += currentProperty.getArea();
        }
        return areaSum / getAmountOfProperties();
    }

    public ArrayList<Property> getPropertiesWithLotNumber(int lotNumber) {
        ArrayList<Property> propertiesWithLotNumber = new ArrayList<Property>();
        for (Property currentProperty : properties) {
            if (currentProperty.getLotNumber() == lotNumber) {
                propertiesWithLotNumber.add(currentProperty);
            }
        }
        return propertiesWithLotNumber;
    }

    public ArrayList<Property> getAllProperties() {
        return new ArrayList<>(properties);
    }    
}
