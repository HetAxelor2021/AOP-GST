package com.axelor.data;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.axelor.data.csv.CSVImporter;
import com.axelor.demo.db.repo.ContacttRepository;
import com.axelor.inject.Beans;
import com.axelor.test.GuiceModules;
import com.axelor.test.GuiceRunner;


@RunWith(GuiceRunner.class)
@GuiceModules(DataModule.class)
public class CSVDataTest{
	

	
	@Test
	public void testImport()  throws IOException{
		Importer importer = new CSVImporter("src/main/resources/data-demo/input-config.xml", "src/main/resources/data-demo/input");
		importer.run();
		Beans.get(ContacttRepository.class).all().fetch().stream().forEach(contact->System.err.println(contact.getTitle()));
//		Beans.get(ContacttRepository.class).all().fetch().stream()
//		.forEach(student->System.err.println(student.getFullName()+"\t" +student.getTitle()+"\t"+
//		student.getCircles() +"\t"+student.getDepartments()+"\t"+student.getDemoO2M()+"\t"+student.getDemoO2O()+"\t"+ student.getDemoM2M()));
		
		
	}
	
	
}


