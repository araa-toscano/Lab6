package Server.Characteristics;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Set all Values in the collection
 */
public class Person implements Serializable {

    private int id;
    private String name;
    private Coordinates coordinates;
    private LocalDate creationDate;
    private float height;
    private String passportID;
    private Color hairColor;
    private Country nationality;
    private Location location;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
        creationDate = LocalDate.now();

    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public String getPassportID() {
        return passportID;
    }

    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }

    public Color getHairColor() {
        return hairColor;
    }

    public void setHairColor(Color hairColor) {
        this.hairColor = hairColor;
    }

    public Country getNationality() {
        return nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Person(int id, String name, Coordinates coordinates, LocalDate creationDate, float height, String passportID, Color hairColor, Country nationality, Location location) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.height = height;
        this.passportID = passportID;
        this.hairColor = hairColor;
        this.nationality = nationality;
        this.location = location;
    }

    public Person(){
    }


    @Override
    public String toString() {
        return "Id: "+ id+", Name: "+name + ", Coordinates: "+coordinates+", Height:  " + height +", Date: "+creationDate+", Passport: "+passportID +
                ", Hair Color: "+hairColor+", Country: " +nationality+", Location: "+location;
    }
}
