package models;

public class Beneficiary {
    private String id;
    private String name;
    private int age;
    private String village;
    
    public Beneficiary(String id, String name, int age, String village) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.village = village;
    }
    
    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getVillage() { return village; }
}