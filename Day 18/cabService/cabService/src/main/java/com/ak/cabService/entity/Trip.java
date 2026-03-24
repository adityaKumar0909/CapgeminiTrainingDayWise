package com.ak.cabService.entity;

import jakarta.persistence.*;

@Entity
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    @ManyToOne
    Employee employee;
    @OneToOne(cascade = CascadeType.ALL)
    CabService cabService;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public CabService getCabService() {
        return cabService;
    }

    public void setCabService(CabService cabService) {
        this.cabService = cabService;
    }





}
