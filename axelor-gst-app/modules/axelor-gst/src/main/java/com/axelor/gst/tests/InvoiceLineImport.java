package com.axelor.gst.tests;

import java.io.File;
import java.util.Map;

import com.axelor.gst.db.Invoice;
import com.axelor.gst.db.InvoiceLine;
import com.axelor.gst.db.Product;
import com.axelor.gst.db.repo.InvoiceRepository;
import com.axelor.inject.Beans;
import com.axelor.meta.MetaFiles;
import com.google.common.io.Resources;

public class InvoiceLineImport {
	
	
	
	
	public Object updateInvoiceLineData(Object bean, Map<String, Object> values) {
		assert bean instanceof InvoiceLine;
		
		InvoiceLine il = (InvoiceLine) bean;
		
		il.setHsbn(il.getProduct().getHsbn()); 
		il.setItem("["+il.getProduct().getCode()+"] "+il.getProduct().getName());
		il.setPrice(il.getProduct().getSalePrice());
		System.out.println(values.get("reference")+"helllo hii byy");
		Long invoiceId = Long.parseLong(values.get("id")+"");
		Invoice invoice = Beans.get(InvoiceRepository.class).find(invoiceId);
		il.setInvoice(invoice);
		System.err.println(invoice+"invoice");
		System.err.println(il.toString()+ "::::::"+values.get("id"));
//		Invoice = 
		return il;
	}
	
	public Object updateProductData(Object bean, Map<String,Object> values) {
		assert bean instanceof Product;
		
		Product product = (Product) bean;
		
		try {
			String image = (String) values.get("image");
			String dirPath = values.get("__path__").toString();
			File file = new File(dirPath,image);
			Beans.get(MetaFiles.class).upload(file);
		}catch(Exception e) {
			e.printStackTrace();
		}
		product.setGstRate(product.getCategory().getGstRate());
		
		
//		product.getImage().setFilePath();
//		
		System.err.println(values.get("__path__")+"path");
		return product;
		
	}
}
