package com.axelor.data;

import com.axelor.app.AppModule;
import com.axelor.auth.AuthModule;
import com.axelor.db.JpaModule;
import com.google.inject.AbstractModule;

import net.sf.ehcache.CacheManager;

public class DataModule extends AbstractModule {
	@Override
	protected void configure() {
		if(CacheManager.ALL_CACHE_MANAGERS.size() > 0) {
			CacheManager.getInstance().shutdown();
		}
		
		install(new JpaModule("testUnit",true,true));
		install(new AuthModule());
		install(new AppModule());
		
	}
}
