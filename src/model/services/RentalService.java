package model.services;

import javax.swing.border.MatteBorder;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {
	
	private Double pricePreday;
	private double pricePerHour;
	
	private TaxService taxService;

	public RentalService() {
		
	}
	
	public RentalService(Double pricePreday, double pricePerHour, TaxService taxService) {
		
		this.pricePreday = pricePreday;
		this.pricePerHour = pricePerHour;
		this.taxService = taxService;
	}

	public Double getPricePreday() {
		return pricePreday;
	}

	public void setPricePreday(Double pricePreday) {
		this.pricePreday = pricePreday;
	}

	public double getPricePerHour() {
		return pricePerHour;
	}

	public void setPricePerHour(double pricePerHour) {
		this.pricePerHour = pricePerHour;
	}

	public TaxService getTaxService() {
		return taxService;
	}

	public void setTaxService(BrasilTaxService taxService) {
		this.taxService = taxService;
	}
	
	public void processInvoice(CarRental carRental) {
		long t1 = carRental.getStart().getTime();
		long t2 = carRental.getFinish().getTime();
		double hours = (double)(t2-t1)/1000/60/60;
		
		double basicPaymente;
		
		if(hours <= 12.0) {
			 basicPaymente = Math.ceil(hours) * pricePerHour;
		}else {
			basicPaymente = Math.ceil(hours/24)* pricePreday;
		}
		
		double tax = taxService.tax(basicPaymente);
		
		carRental.setInvoice(new Invoice(basicPaymente, tax));
	}
	
	

}
