import static org.junit.Assert.*;

import org.formation.spring.config.ProxiBanqueConfig;
import org.formation.spring.dao.IDaoClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ProxiBanqueConfig.class)
public class TestCoucheDao {
	@Autowired
	private IDaoClient daoClient;

	@Test
	public void testInjection1() {

		Assert.notNull(daoClient);

	}

}
