package tim23.searchservice;

import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import tim23.searchservice.model.*;
import tim23.searchservice.repository.DodatneUslugeRepository;
import tim23.searchservice.repository.SearchRepository;
import tim23.searchservice.repository.SobeDodatneUslugeRepository;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.internal.SessionFactoryBuilderImpl;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.search.annotations.Factory;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
@Service
public class SearchService {
  
	    public List<Soba> fuzzySearch(String searchTerm,String term2,String Klima) {
	
	    	SessionFactory sf = new Configuration().configure().buildSessionFactory();
	    	Session session = sf.openSession();
	    	session.beginTransaction();
	    	
	 	   Query query = session.createQuery("select s.idSoba from Soba s left outer join SobeDodatneUsluge on s.idSoba = id_sobe left outer join DodatneUsluge d on id_dodatneusluge = d.id  where d.naziv='Klima'"); 

	   		
	    List<Integer> list = new LinkedList<>();
	    list = query.list();
	    List<Soba> listSoba = new LinkedList<>();
	    
	  for(int i=0;i<list.size();i++) {
	 	   Query query2 = session.createQuery("from Soba where idSoba="+list.get(i)); 
           List <Soba> privremena = query2.list();
           for(int j=0;j<privremena.size();j++)
        	   listSoba.add(privremena.get(j));
	   				  
	  }
	   session.getTransaction().commit();
	  
	    	session.close();
	    	if(list!=null)
	    	System.out.println(listSoba.get(0).toString());
	

	    	return listSoba;
	    }
}
