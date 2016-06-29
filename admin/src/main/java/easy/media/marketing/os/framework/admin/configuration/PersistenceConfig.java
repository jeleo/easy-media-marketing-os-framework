package easy.media.marketing.os.framework.admin.configuration;

import easy.media.marketing.os.framework.admin.entity.Entities;
import easy.media.marketing.os.framework.admin.query.Queries;
import easy.media.marketing.os.framework.admin.repository.Repositories;
import easy.media.marketing.os.framework.commons.configurer.MasterPersistenceConfigurer;
import easy.media.marketing.os.framework.commons.configurer.Slave0PersistenceConfigurer;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

@Configuration
@EnableJpaAuditing
public class PersistenceConfig {

    @EnableJpaRepositories(
            transactionManagerRef = MasterPersistenceConfigurer.TRANSACTION_MANAGER_NAME,
            entityManagerFactoryRef = MasterPersistenceConfigurer.ENTITY_MANAGER_FACTORY_NAME,
            basePackageClasses = Repositories.class)
    public static class MasterConfigurer extends MasterPersistenceConfigurer {
        @Override
        protected void customizeEntityManagerFactory(LocalContainerEntityManagerFactoryBean factory) {
            factory.setPackagesToScan(Entities.class.getPackage().getName());
        }
    }

    @EnableJpaRepositories(
            transactionManagerRef = Slave0PersistenceConfigurer.TRANSACTION_MANAGER_NAME,
            entityManagerFactoryRef = Slave0PersistenceConfigurer.ENTITY_MANAGER_FACTORY_NAME,
            basePackageClasses = Queries.class)
    public static class Slave0Configurer extends Slave0PersistenceConfigurer {
        @Override
        protected void customizeEntityManagerFactory(LocalContainerEntityManagerFactoryBean factory) {
            factory.setPackagesToScan(Queries.class.getPackage().getName());
        }
    }

    @Bean(destroyMethod = "close")
    public DataSource jdbcDataSource(@Value("${jdbc.url}") String url, @Value("${jdbc.driver}") String driver,
                                     @Value("${jdbc.user}") String user, @Value("${jdbc.secret}") String secret,
                                     @Value("${jdbc.validation}") String validation) {
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(secret);
        dataSource.setTestOnBorrow(true);
        dataSource.setValidationQuery(validation);

        return dataSource;
    }

}
