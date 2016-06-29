package easy.media.marketing.os.framework.commons.configurer;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

public class MasterPersistenceConfigurer extends AbstractPersistenceConfigurer {
	public static final String PERSISTENCE_UNIT_NAME = "master";
	public static final String TRANSACTION_MANAGER_NAME = "masterTransactionManager";
	public static final String ENTITY_MANAGER_FACTORY_NAME = "masterEntityManagerFactory";

	@Bean(name = ENTITY_MANAGER_FACTORY_NAME)
	@Override
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		return super.entityManagerFactory(dataSource);
	}

	@Bean(name = TRANSACTION_MANAGER_NAME)
	public JpaTransactionManager masterTransactionManager(
			@Qualifier(ENTITY_MANAGER_FACTORY_NAME) EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}

	@Override
	protected String getPersistenceName() {
		return PERSISTENCE_UNIT_NAME;
	}

	@Override
	protected void customizeJpaProperties(Properties props) {
		// set this property value to CREATE_OR_EXTEND for auto create tables
		props.setProperty(PersistenceUnitProperties.DDL_GENERATION, PersistenceUnitProperties.CREATE_OR_EXTEND);
	}
}
