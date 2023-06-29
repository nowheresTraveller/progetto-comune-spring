package com.example.progettocomune.config;


import com.example.progettocomune.db.dao.impl.CittadinoDaoImpl;
import com.example.progettocomune.db.dao.impl.DipendenteDaoImpl;
import com.example.progettocomune.db.dao.interfaces.CittadinoDao;
import com.example.progettocomune.db.dao.interfaces.DipendenteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.example.progettocomune.controller")
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
public class Config implements WebMvcConfigurer {


    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver= new InternalResourceViewResolver();
        //il metodo 'setPrefix("...")' indica al resolver dove sono le view
        resolver.setPrefix("/templates/");
        //il metodo 'setSuffix("...")' indica il formato dei file da prendere nella folder delle view
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/static/css/**").addResourceLocations("/resources/static/css/");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    public DataSource getDbConnection(Environment env) {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(env.getRequiredProperty("db.driver"));
        ds.setUrl(env.getRequiredProperty("db.url"));
        ds.setUsername(env.getRequiredProperty("db.user"));
        ds.setPassword(env.getRequiredProperty("db.password"));
        return ds;
    }

    @Bean
    @Autowired
    public LocalContainerEntityManagerFactoryBean getEntityManager(Environment env) {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL);
        //permette di aggiornare la struttura delle tabelle del db in base all'implementazioni delle classi entity
        adapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(getDbConnection(env));
        factory.setJpaVendorAdapter(adapter);
        //Specifico il package dove sono contenute le classi Entity
        factory.setPackagesToScan("com.example.progettocomune.db.entity");
        return factory;
    }

    //Restituisce un oggetto che permette di compiere le transazioni
    @Bean
    @Autowired
    public PlatformTransactionManager getTransactionManager(LocalContainerEntityManagerFactoryBean managerFactory) {
        JpaTransactionManager jtm = new JpaTransactionManager(managerFactory.getObject());
        return jtm;
    }

    @Bean
    public CittadinoDao getCittadinoDao(){
        return new CittadinoDaoImpl();
    }

    @Bean
    public DipendenteDao getDipendenteDao(){
        return new DipendenteDaoImpl();
    }

}
