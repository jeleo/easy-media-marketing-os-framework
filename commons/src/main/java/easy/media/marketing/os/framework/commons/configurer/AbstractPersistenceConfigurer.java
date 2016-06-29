package easy.media.marketing.os.framework.commons.configurer;

import java.util.Properties;
import java.util.logging.Level;
import javax.sql.DataSource;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.eclipse.persistence.config.TargetDatabase;
import org.eclipse.persistence.jpa.PersistenceProvider;
import org.eclipse.persistence.logging.SessionLog;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.DefaultPersistenceUnitManager;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaDialect;

public abstract class AbstractPersistenceConfigurer {
	protected LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();

		factory.setDataSource(dataSource);
		factory.setPersistenceProvider(new PersistenceProvider());
		factory.setJpaDialect(new EclipseLinkJpaDialect());
		factory.setJpaProperties(this.jpaProperties());
		factory.setPersistenceUnitName(this.getPersistenceName());

		this.customizeEntityManagerFactory(factory);

		return factory;
	}

	protected String getPersistenceName() {
		return DefaultPersistenceUnitManager.ORIGINAL_DEFAULT_PERSISTENCE_UNIT_NAME;
	}

	protected void customizeEntityManagerFactory(LocalContainerEntityManagerFactoryBean factory) {
	}

	protected void customizeJpaProperties(Properties properties) {
	}

	private Properties jpaProperties() {
		Properties properties = new Properties();

		properties.setProperty(PersistenceUnitProperties.WEAVING, "static");
		properties.setProperty(PersistenceUnitProperties.LOGGING_CONNECTION, "false");
		properties.setProperty(PersistenceUnitProperties.LOGGING_PARAMETERS, "true");
		properties.setProperty(PersistenceUnitProperties.LOGGING_EXCEPTIONS, "true");
		properties.setProperty(PersistenceUnitProperties.LOGGING_SESSION, "false");
		properties.setProperty(PersistenceUnitProperties.LOGGING_TIMESTAMP, "false");
		properties.setProperty(PersistenceUnitProperties.LOGGING_LEVEL, "OFF");// change it to SEVERE for printing sql
		properties.setProperty(PersistenceUnitProperties.TARGET_DATABASE, TargetDatabase.MySQL);
		properties.setProperty(PersistenceUnitProperties.CACHE_SHARED_DEFAULT, "false");
		properties.setProperty(PersistenceUnitProperties.CATEGORY_LOGGING_LEVEL_ + SessionLog.SQL,
				Level.FINE.toString());

		this.customizeJpaProperties(properties);

		return properties;
	}
}
