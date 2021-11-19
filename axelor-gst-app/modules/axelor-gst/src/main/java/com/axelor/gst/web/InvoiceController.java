package com.axelor.gst.web;

import java.math.BigDecimal;
import java.util.List;

import com.axelor.gst.db.Address;
import com.axelor.gst.db.City;
import com.axelor.gst.db.Company;
import com.axelor.gst.db.Invoice;
import com.axelor.gst.db.InvoiceLine;
import com.axelor.gst.db.Product;
import com.axelor.gst.db.State;
import com.axelor.gst.db.repo.AddressRepository;
import com.axelor.gst.db.repo.CityRepository;
import com.axelor.gst.db.repo.InvoiceLineRepository;
import com.axelor.gst.db.repo.InvoiceRepository;
import com.axelor.gst.service.GstCalculation;
import com.axelor.inject.Beans;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.axelor.rpc.Context;

public class InvoiceController {
	public void allGstCalculation(ActionRequest request, ActionResponse response) {

		Context context = request.getContext();
		
		InvoiceLine invoiceLine = context.asType(InvoiceLine.class);
		
		if(invoiceLine.getId() != null) {
			invoiceLine = Beans.get(InvoiceLineRepository.class).find(invoiceLine.getId());
		}
		Invoice invoice = context.getParent().asType(Invoice.class);
		if(invoice.getId() != null) {
			invoice = Beans.get(InvoiceRepository.class).find(invoice.getId());
		}
		
		Address address = invoice.getCompany().getAddress();
//		String stateName = address.get

		
		System.out.println("hello we are in all gst calculation" + invoiceLine.toString());
//		System.out.println("qty: "+qty+ " price"+price );
		
		GstCalculation gstCalculation = Beans.get(GstCalculation.class);
		
		BigDecimal netAmount = gstCalculation.netAmountCalc(invoiceLine.getQty(),invoiceLine.getPrice());
		BigDecimal gstRate = invoiceLine.getGstRate();
//		if()
//		if() {
//			gstCalculation.igstCalc(netAmount,gstRate);
//			
//		}
		
	}
	
	public void cityData(ActionRequest request, ActionResponse response) {
		Context context= request.getContext();
		

		
		
		
		
		
		City city = context.asType(City.class);
//		Address address = context.asType(Address.class);
//		
	
		  if(city.getId() != null) { city = Beans.get(CityRepository.class).find(city.getId()); }
		 
		
		System.out.println("hello in city: "+city.toString());
		String cityName = city.getName();
		String stateName= city.getState();
		String countryName = city.getCountry();
		
		
		Address address =context.getParent().asType(Address.class); 
		
		if(address.getId() != null) {
			address = Beans.get(AddressRepository.class).find(address.getId());
		}
		
		address.getState().setName(stateName);
		System.out.println("state name after changes: "+address.getState());
		
		
		System.out.println("r");
		System.out.println(context.getClass());
	
//		response.setValue(state);
	
		
//		System.out.println("response.getData: "+response.setV);
		System.out.println("response.getclass: "+address.getState().toString());
		State state = address.getState();
		
		
	}
	
	public void statusValueProvider(ActionRequest request, ActionResponse response) {
		Context context = request.getContext();
		
		Invoice invoice = context.asType(Invoice.class);
		int ans= 0;
		if(invoice.getId() != null) {
			invoice = Beans.get(InvoiceRepository.class).find(invoice.getId());
		}
		System.out.println("hello we are in invoicecontroller "+invoice.getStatus());
		if(invoice.getStatus().equals("draft")) {
			System.out.println("draft: " );	
			
			ans =  1;
		}
		if(invoice.getStatus().equals("validated")) {
			System.out.println("validated: " );
			ans =  2;
		}
		if(invoice.getStatus().equals("paid")) {
			System.out.println("paid: " );
			ans =  3;
		}
		if(invoice.getStatus().equals("cancelled")) {
			System.out.println("cancelled: " );
			ans =  4;
		}
		
		response.setValue("statusValue", ans);

	}
	
	public void itemNameMaker(ActionRequest request, ActionResponse response) {
		
		Context context = request.getContext();
		
		InvoiceLine invoiceLine = context.asType(InvoiceLine.class);
		
		Product product = invoiceLine.getProduct();
		
		response.setValue("gstRate",product.getGstRate());
		
		String itemName ="["+product.getCode().toString()+"] "+product.getName().toString();
		System.out.println(itemName);
		response.setValue("item", itemName);
//		return itemName;
		
	
		
	}
	
	public void invoiceListCalc(ActionRequest request, ActionResponse response) {
		Context context = request.getContext();
		
		Invoice invoice = context.asType(Invoice.class);
		
//		if(invoice.getId() != null) {
//			invoice = Beans.get(InvoiceRepository.class).find(invoice.getId());
//		}
		
		BigDecimal netAmount = new BigDecimal("0.0");
		BigDecimal netIGST = new BigDecimal("0.0");
		BigDecimal netCGST = new BigDecimal("0.0");
		BigDecimal netSGST = new BigDecimal("0.0");
		BigDecimal grossAmount = new BigDecimal("0.0");
		System.out.println("hello we are in invoiceListCalc");
		List<InvoiceLine> invoiceItemList = invoice.getInvoiceItemsList();
		for(int i=0;i<invoiceItemList.size();i++) {
				System.out.println(invoiceItemList.get(i).getNetAmount()+" : "+ invoiceItemList.get(i).getIgst()+" : "+invoiceItemList.get(i).getCgst()+" : "+invoiceItemList.get(i).getSgst()+" : "+invoiceItemList.get(i).getGrossAmount());
				netAmount = netAmount.add( invoiceItemList.get(i).getNetAmount());
				netIGST = netIGST.add(invoiceItemList.get(i).getIgst());
				netCGST = netCGST.add(invoiceItemList.get(i).getCgst());
				netSGST = netSGST.add(invoiceItemList.get(i).getSgst());
				grossAmount = grossAmount.add(invoiceItemList.get(i).getGrossAmount());
				System.out.println("netAmount: "+netAmount+"\n netIGST: "+netIGST+" \n netCGST: "+netCGST+" \n netSGST: "+netSGST+" \n grossAmount: "+grossAmount);
		}
		System.out.println("netAmount: "+netAmount+"\n netIGST: "+netIGST+" \n netCGST: "+netCGST+" \n netSGST: "+netSGST+" \n grossAmount: "+grossAmount);
		response.setValue("netAmount",netAmount);
		response.setValue("netIGST", netIGST);
		response.setValue("netCGST", netSGST);
		response.setValue("grossAmount", grossAmount);
		
	}
	
	
}
























