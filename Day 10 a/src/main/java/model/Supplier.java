package model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Supplier {

	@Id
	@SequenceGenerator(name = "supplier_seq", sequenceName = "supplier_seq", allocationSize = 1, initialValue = 101)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplier_seq")
	@JoinColumn(name = "Sid")
	int Sid;

	public String getSname() {
		return Sname;
	}

	public void setSname(String sname) {
		Sname = sname;
	}

	public String getSrank() {
		return Srank;
	}

	public void setSrank(String srank) {
		Srank = srank;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	String Sname, Srank, city;

	@ManyToMany
	@JoinTable(name = "SupplyTable", joinColumns = { @JoinColumn(name = "Sid") }, inverseJoinColumns = {
			@JoinColumn(name = "Itemid") })
	List<Item> items;

}
