package model.entities;

public class Invoice {
	private Double basicPaymente;
	private double tax;
	
	public Invoice() {}

	public Invoice(Double basicPaymente, double tax) {
		super();
		this.basicPaymente = basicPaymente;
		this.tax = tax;
	}

	public Double getBasicPaymente() {
		return basicPaymente;
	}

	public void setBasicPaymente(Double basicPaymente) {
		this.basicPaymente = basicPaymente;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}
	
	public double getTotalPayment() {
		return getBasicPaymente()+getTax();
	}

}
