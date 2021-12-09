package com.axelor.data;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.axelor.data.csv.CSVImporter;
import com.axelor.gst.db.repo.AddressRepository;
import com.axelor.inject.Beans;
import com.axelor.test.GuiceModules;
import com.axelor.test.GuiceRunner;

@RunWith(GuiceRunner.class)
@GuiceModules(DataModule.class)
public class CSVDataTest {
	@Test
	public void testImport() throws IOException{
		Beans.get(AddressRepository.class).all().fetch().stream().forEach(address -> System.err.println(address.getType()+" : "+address.getLine1()+" : "+address.getLine2()+" : "+address.getCity()+" : "+address.getState()+" : "+address.getCountry()+" : "+address.getPinCode()));
//		Beans.get()
		Importer importer = new CSVImporter("src/main/resources/data-demo/input-config.xml","src/main/resources/data-demo/input");
		importer.run();
//		Beans.get();
		Beans.get(AddressRepository.class).all().fetch().stream().forEach(address -> System.err.println(address.getType()+" : "+address.getLine1()+" : "+address.getLine2()+" : "+address.getCity()+" : "+address.getState()+" : "+address.getCountry()+" : "+address.getPinCode()));
		System.err.println("///////////////////////////////////////////////////////////");
		
		
	}
	
}
