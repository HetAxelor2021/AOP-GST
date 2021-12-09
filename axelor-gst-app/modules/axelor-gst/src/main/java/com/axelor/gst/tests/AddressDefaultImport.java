package com.axelor.gst.tests;

import java.util.Map;

import com.axelor.gst.db.Address;

public class AddressDefaultImport {
	
	public void defaultType(Map<String,Object> context) {
		boolean validateAddress = false;
		context.put("validateAddress",validateAddress);
		System.err.println("hello we are in default type");
	}
	
	public Object updateAddress(Object bean, Map<String, Object> values) {
		assert bean instanceof Address;
		
//		values.get("validateAddress");
		Address address = (Address)bean;
		if(address.getType() == null || address.getType().equals("")) {
			address.setType("default");
		}
		System.err.println("hello we are in update Address");
		values.put("validateAddress",true);
		return address;
		
	}
}
