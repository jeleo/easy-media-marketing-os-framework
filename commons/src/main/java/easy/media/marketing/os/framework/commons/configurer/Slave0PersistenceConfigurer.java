package easy.media.marketing.os.framework.commons.configurer;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

public class Slave0PersistenceConfigurer extends AbstractPersistenceConfigurer {
	public static final String PERSISTENCE_UNIT_NAME = "slave0";
	public static final String TRANSACTION_MANAGER_NAME = "slave0TransactionManager";
	public static final String ENTITY_MANAGER_FACTORY_NAME = "slave0EntityManagerFactory";

	@Bean(name = ENTITY_MANAGER_FACTORY_NAME)
	@Override
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		return super.entityManagerFactory(dataSource);
	}

	@Bean(name = TRANSACTION_MANAGER_NAME)
	public JpaTransactionManager slave0TransactionManager(
			@Qualifier(ENTITY_MANAGER_FACTORY_NAME) EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}

	@Override
	protected String getPersistenceName() {
		return PERSISTENCE_UNIT_NAME;
	}
}
