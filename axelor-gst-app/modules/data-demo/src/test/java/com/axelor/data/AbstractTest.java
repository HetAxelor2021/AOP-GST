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

    if (checked || sequences.findByName("sale.order.seq") != null) {
      return;
    }

    checked = true;

    final MetaSequence seq = new MetaSequence();
    seq.setName("sale.order.seq");
    seq.setPrefix("SO");
    seq.setPadding(5);

    JPA.runInTransaction(
        new Runnable() {

          @Override
          public void run() {
            sequences.save(seq);
          }
        });
  }
}