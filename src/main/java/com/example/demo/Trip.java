package com.example.demo;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trip {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) private long id;

    private String destination;


    public String getDestination() { return destination; }

    public void setDestination(String destination) { this.destination = destination; }

}
