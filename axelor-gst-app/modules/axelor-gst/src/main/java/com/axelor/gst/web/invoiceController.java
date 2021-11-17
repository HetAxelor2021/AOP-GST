package com.axelor.gst.web;

import java.math.BigDecimal;

import com.axelor.gst.db.InvoiceLine;
import com.axelor.gst.db.repo.InvoiceLineRepository;
import com.axelor.gst.service.GstCalculation;
import com.axelor.inject.Beans;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.axelor.rpc.Context;

public class invoiceController {
	public void allGstCalculation(ActionRequest request, ActionResponse response) {

		Context context = request.getContext();
		
		InvoiceLine invoiceLine = context.asType(InvoiceLine.class);
		
		if(invoiceLine.getId() != null) {
			invoiceLine = Beans.get(InvoiceLineRepository.class).find(invoiceLine.getId());
		}
		
		
		System.out.println("hello we are in all gst calculation" + invoiceLine.toString());
//		System.out.println("qty: "+qty+ " price"+price );
		
		
		Beans.get(GstCalculation.class).allGstCalculation(invoiceLine.getQty(), invoiceLine.getPrice());
		
	}
}
