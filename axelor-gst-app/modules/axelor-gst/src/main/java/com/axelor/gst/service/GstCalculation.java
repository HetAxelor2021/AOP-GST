package com.axelor.gst.service;

import java.math.BigDecimal;

import com.axelor.meta.CallMethod;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;

public interface GstCalculation {
	
	@CallMethod
	public void allGstCalculation(int qty, BigDecimal price);
	
	
	
	public BigDecimal netAmountCalc(int qty, BigDecimal price);
	
	
	public BigDecimal gstRateCalc() ;
	
	
	public BigDecimal igstCalc();
	
	
	public BigDecimal sgstCalc();
	
	
	public BigDecimal cgstCalc();
	
	
	public BigDecimal grossAmountCalc();
}
