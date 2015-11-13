package joseph.peterson.myNewHibernate.src;

import joseph.peterson.myNewHibernate.src.PhoneNumber;
import joseph.peterson.myNewHibernate.src.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

//this file is like an extention to the User.java file. It allows hibernate to talk to the database.
public class HibernateConfig

{

	private SessionFactory sessionFactory;

    public HibernateConfig() {
        Configuration config = new Configuration();

        config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

        config.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");

        //change the next line of code to match your MySQL URL and port

        config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/test");

        //change the next two lines of code to match your MySQL user name and password.

        config.setProperty("hibernate.connection.username", "jpeter89");

        config.setProperty("hibernate.connection.password", "J3221ca!");

        //change the pool size to reflect how many users you expect your application to have initially

        config.setProperty("hibernate.connection.pool_size", "1");

        config.setProperty("hibernate.connection.autocommit", "true");

        config.setProperty("hibernate.cache.provider_class", "org.hibernate.cache.NoCacheProvider");

		/*
		 * un-comment the next line of code if you want to be able to drop and recreate tables for your data classes listed below.  This is generally a bad idea for security reasons.
		 */

        //config.setProperty("hibernate.hbm2ddl.auto", "create-drop");

        config.setProperty("hibernate.show_sql", "true");

        config.setProperty("hibernate.transaction.factory_class", "org.hibernate.transaction.JDBCTransactionFactory");

        config.setProperty("hibernate.current_session_context_class", "thread");

		/*
		 *  Add your classes here that you want to match your database tables
		 *  The example has a User and a PhoneNumber class.
		 */

        config.addAnnotatedClass(User.class);

        config.addAnnotatedClass(PhoneNumber.class);
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();

        sessionFactory = config.buildSessionFactory(serviceRegistry);
    }

    public  Session getCurrentSession() {

        return sessionFactory.getCurrentSession();

    }

}
