package com.axelor.gst.service;

import java.math.BigDecimal;

import com.axelor.gst.db.InvoiceLine;
import com.axelor.gst.db.repo.InvoiceLineRepository;
import com.axelor.inject.Beans;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.axelor.rpc.Context;

public class GstCalculationImpl implements GstCalculation{
	
	

	@Override
	public BigDecimal netAmountCalc(int qty, BigDecimal price) {
		// TODO Auto-generated method stub
		
		return price.multiply(BigDecimal.valueOf(qty));
	}

	@Override
	public BigDecimal gstRateCalc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal igstCalc() {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public BigDecimal sgstCalc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal cgstCalc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal grossAmountCalc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void allGstCalculation(int qty, BigDecimal price) {
		// TODO Auto-generated method stub
	
		
		
	}

}
