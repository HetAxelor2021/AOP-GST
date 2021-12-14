package com.axelor.gst.tests;

import java.util.Map;

import com.axelor.gst.db.Product;
import com.axelor.meta.MetaFiles;

public class InvoiceLineImport {
	public Object updateProductData(Object bean, Map<String,Object> values) {
		assert bean instanceof Product;
		
		Product product = (Product) bean;
		
//		product.getImage().setFilePath();
//		
		System.out.println(values.get("__path__"));
		return null;
		
	}
}
