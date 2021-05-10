package com.company.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

;

/**
 * Класс объектов, которые содержаться в коллекции
 */
public class Ticket implements Comparable, Serializable {
    private String owner;
    private long id;
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private Timestamp creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private double price; //Значение поля должно быть больше 0
    private TicketType type; //Поле может быть null
    private Person person; //Поле может быть null

    public Ticket() {
    }

    public Ticket(String name, Coordinates coordinates, Float price, TicketType type, Person person) {
        this.name = name;
        this.coordinates = coordinates;
        if (!(price < 0)) this.price = price;
        else throw new IllegalArgumentException("Значение price должно быть >0");
        this.type = type;
        this.person = person;
        this.creationDate = new Timestamp(new Date().getTime());
    }

    public Ticket(String name, Coordinates coordinates, double price, TicketType type, Person person, Timestamp timestamp) {
        this.name = name;
        this.coordinates = coordinates;
        if (!(price < 0)) this.price = price;
        else throw new IllegalArgumentException("Значение price должно быть >0");
        this.type = type;
        this.person = person;
        this.creationDate = timestamp;
    }

    public Ticket(String name, Coordinates coordinates, double price, Person person, Timestamp timestamp) {
        this.name = name;
        this.coordinates = coordinates;
        if (!(price < 0)) this.price = price;
        else throw new IllegalArgumentException("Значение price должно быть >0");
        this.person = person;
        this.creationDate = timestamp;
    }

    public Ticket(String name, Coordinates coordinates, double price, TicketType type, Timestamp timestamp) {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = null;

        dateFormat = new SimpleDateFormat();
        System.out.println("Constructor 1: " + dateFormat.format(currentDate));
        this.name = name;
        this.coordinates = coordinates;
        if (!(price < 0)) this.price = price;
        else throw new IllegalArgumentException("Значение price должно быть >0");
        this.type = type;
        this.creationDate = timestamp;
    }

    public Ticket(String name, Coordinates coordinates, double price, Timestamp timestamp) {
        this.name = name;
        this.coordinates = coordinates;
        if (!(price < 0)) this.price = price;
        else throw new IllegalArgumentException("Значение price должно быть >0");
        Date currentDate = new Date();
        this.creationDate = timestamp;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setid(long id) {
        this.id = id;
    }

    public long getid() {
        return id;
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

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public TicketType getType() {
        return type;
    }

    public void setType(TicketType type) {
        this.type = type;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Ticket))
            throw new IllegalArgumentException("Объект класса Ticket можно сравнить только с объектами этого класса ");
        else {
            Ticket t = (Ticket) o;
            if (t.getType() != null && this.getType() != null) {
                if (this.getType().compareTo(t.type) != 0) return this.getType().compareTo(t.type);
                else return Long.compare(this.id, t.id);
            } else if (t.getType() == null) return -1;
            else return 1;
        }
    }


    @Override
    public String toString() {
        return "Ticket: id: " + this.id +
                " name:'" + name + '\'' +
                ";coordinates:" + coordinates +
                ";creationDate:" + creationDate +
                ";price:" + price +
                ";type:" + type +
                ";person:" + person + ";owner:" + owner +
                "\n";
    }
}
