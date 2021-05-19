package ua.alevel.lesson24;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HibernateSessionFactory {

    public static SessionFactory getSessionFactory() {
        try {
            //Create registry
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();

            //Create MetadataSources
            MetadataSources sources = new MetadataSources(serviceRegistry);

            //Create Metadata
            Metadata metadata = sources.getMetadataBuilder().build();

            //Create SessionFactory
            return metadata.getSessionFactoryBuilder().build();
        } catch (Throwable e) {
            System.err.println("Failed to create sessionFactory object" + e);
            throw new ExceptionInInitializerError(e);
        }
    }
}
