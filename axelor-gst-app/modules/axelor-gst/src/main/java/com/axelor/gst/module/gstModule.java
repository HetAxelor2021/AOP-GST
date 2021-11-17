package com.axelor.gst.module;

import com.axelor.app.AxelorModule;
import com.axelor.gst.service.GstCalculation;
import com.axelor.gst.service.GstCalculationImpl;

public class gstModule extends AxelorModule{
	@Override
	protected void configure() {
		bind(GstCalculation.class).to(GstCalculationImpl.class);
	}

}
