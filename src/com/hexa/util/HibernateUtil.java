package com.hexa.util;



import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static SessionFactory sfac;
	
	static {
		ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		MetadataSources msources = new MetadataSources(registry);
		Metadata md = msources.buildMetadata();
		sfac = md.buildSessionFactory();
	}
	public static SessionFactory getSessionFactory() {
		return sfac;
	}
}





