package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Item {

	@Id
	@SequenceGenerator(name = "supplier_seq", sequenceName = "supplier_seq", allocationSize = 1, initialValue = 101)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplier_seq")
	@JoinColumn(name = "Itemid")
	int Itemid;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	String name, type;

}
