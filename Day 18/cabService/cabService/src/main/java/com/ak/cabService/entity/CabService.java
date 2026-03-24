package com.ak.cabService.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class CabService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @OneToOne(cascade = CascadeType.ALL)
    Employee employee;
    @OneToOne(cascade = CascadeType.ALL)
    Cab cab;

    LocalDateTime pickupDate;
    String pickupAddress;
    String dropAddress;

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Cab getCab() {
        return cab;
    }

    public void setCab(Cab cab) {
        this.cab = cab;
    }

    public LocalDateTime getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(LocalDateTime pickupDate) {
        this.pickupDate = pickupDate;
    }

    public String getPickupAddress() {
        return pickupAddress;
    }

    public void setPickupAddress(String pickupAddress) {
        this.pickupAddress = pickupAddress;
    }

    public String getDropAddress() {
        return dropAddress;
    }

    public void setDropAddress(String dropAddress) {
        this.dropAddress = dropAddress;
    }

    @Override
    public String toString() {
        return "CabService{" +
                "id=" + id +
                ", employee=" + employee +
                ", cab=" + cab +
                ", pickupDate=" + pickupDate +
                ", pickupAddress='" + pickupAddress + '\'' +
                ", dropAddress='" + dropAddress + '\'' +
                '}';
    }
}
