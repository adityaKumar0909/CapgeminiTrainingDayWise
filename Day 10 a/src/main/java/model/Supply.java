package model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Supply {

	@Id
	@SequenceGenerator(name = "supplier_seq", sequenceName = "supplier_seq", allocationSize = 1, initialValue = 101)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplier_seq")
	int billno;

	@ManyToOne
	@JoinColumn(name = "Sid", nullable = false)
	Supplier supplier;

	@ManyToOne
	@JoinColumn(name = "Itemid", nullable = false)
	Item item;

	Date datesupply;

	double price;

	int quantity;

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Date getDatesupply() {
		return datesupply;
	}

	public void setDatesupply(String datesupply) {
		this.datesupply = Date.valueOf(datesupply);
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
