package com.axelor.data;

import java.io.IOException;

import org.junit.Test;

import com.axelor.data.csv.CSVImporter;
import com.axelor.demo.db.repo.ContacttRepository;
import com.axelor.inject.Beans;

public class CSVDataTest extends AbstractTest {
	@Test
	public void testDefault() throws IOException{
	
		Beans.get(ContacttRepository.class).all().fetch().stream().forEach(contact->System.err.println(contact.getFullName()+"---"+contact.getTitle()));
		//Importer importer = new CSVImporter("data/input-config.xml","data/csv");
		//importer.run();
		Beans.get(ContacttRepository.class).all().fetch().stream().forEach(contact->System.err.println(contact.getTitle()));
	}
	
	@Test
	public void testMulti() throws IOException {
//		Importer importer = new CSVImporter("data/input-multi-con")
	}
}


