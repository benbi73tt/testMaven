package ru.madbrains.simpleList;

public class Cars{

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() { return name;}

    public void setName(String name) {
        this.name = name;
    }

    private String age;
    private String name;
    private float price;

    public Cars(String name, String age, float price) {
        this.name = name;
        this.age = age;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Cars {" +
                "name = '" + name + '\'' +
                ", age = '" + age + '\'' +
                ", price = " + price +
                "}";
    }
}

