package com.axelor.data;




import com.axelor.db.EntityHelper;
import com.axelor.db.JPA;
import com.axelor.meta.db.MetaSequence;
import com.axelor.meta.db.repo.MetaSequenceRepository;
import com.axelor.test.GuiceModules;
import com.axelor.test.GuiceRunner;
import javax.inject.Inject;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(GuiceRunner.class)
@GuiceModules(DataModule.class)
public abstract class AbstractTest {

  protected final Logger log = LoggerFactory.getLogger(EntityHelper.getEntityClass(this));

  @Inject private MetaSequenceRepository sequences;

  private static boolean checked;

  @Before
  public void ensureSequence() {

  }
}