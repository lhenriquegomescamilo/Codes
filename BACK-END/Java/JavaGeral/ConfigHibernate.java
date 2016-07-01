/*
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-configuration PUBLIC
		"-//Hibernate/Hibernate Configuration DTD 3.0//EN"
		"http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd">

<hibernate-configuration>
	<session-factory>
		<property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
		
		<property name="hibernate.connection.password">senha</property>
		
		<property name="hibernate.connection.url">jdbc:mysql://localhost:3306/testes</property>
		
		<property name="hibernate.connection.username">root</property>
		
		<property name="hibernate.dialect">org.hibernate.dialect.MySQL5Dialect</property>
		
		<property name="hibernate.show_sql">true</property>
		
		<property name="hibernate.format_sql">false</property>
		
		<property name="hbm2ddl.auto">create</property>
		
	</session-factory>
</hibernate-configuration>

*/
package br.com.sistema.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
	//private static final SessionFactory sessionFactory = buildSessionFactory();
	private static final SessionFactory sessionFactory;
	
	//Cria uma sessionFactory a partir do hibernate.cfg.xml
		static {
			try{
				sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().configure().build()).buildMetadata().buildSessionFactory();
			}catch(Throwable e){
				System.err.println("Falha ao criar SessionFactory: " + e.getMessage());
				throw new ExceptionInInitializerError(e);
			}
		}
		
	/*
	private static SessionFactory buildSessionFactory(){
		try{
			//Cria um sessionFactory a partir do Hibernate.cfg.xml
			Configuration configuration = new Configuration();
			configuration.configure();
			
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			
			SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			
			return sessionFactory;
		}catch(Throwable e){
			System.err.println("Falha ao criar SessionFactory: " + e.getMessage());
			throw new ExceptionInInitializerError(e);
		}
	}
	*/
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
