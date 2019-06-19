package tim23.searchservice;

import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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
  
	    public List<Soba> fuzzySearch(String brojkreveta,String drzava,String grad, String ulicaibroj,Date pocetak, Date kraj,String klima,String wifi) {
	
	    	SessionFactory sf = new Configuration().configure().buildSessionFactory();
	    	Session session = sf.openSession();
	    	session.beginTransaction();
	    
	    	
	    //  Query queryAdresaAndBrKreveta = session.createQuery("select s.idSoba from Soba s left outer join SobeDodatneUsluge on s.idSoba = id_sobe left outer join DodatneUsluge d on id_dodatneusluge = d.id left outer join Adresa a on s.adresa = a.id  where a.drzava = :drzava and a.grad = :grad and d.naziv= :klima and a.ulicaIBroj = :uib").setParameter("drzava", drzava).setParameter("grad", grad).setParameter("uib", ulicaibroj).setParameter("klima", klima);	
	 	//   Query query = session.createQuery("select s.idSoba from Soba s left outer join SobeDodatneUsluge on s.idSoba = id_sobe left outer join DodatneUsluge d on id_dodatneusluge = d.id  where d.naziv='Klima'"); 
        Query first = session.createQuery("select s.idSoba from Soba s left outer join Adresa a on a.id = s.adresa where a.drzava = 'seb' and a.grad = 'ns' and a.ulicaIBroj = 'u'");
        	//	.setParameter("drz", drzava).setParameter("grd", grad).setParameter("uib", ulicaibroj);
  //     Query second = session.createQuery("select s.idSoba from Soba s left outer join Rezervacija r on r.soba = s.idSoba where (r.datumDolaska > :dd and r.datumOdlaska > :do) or (r.datumDolaska < :dd and r.datumOdlaska < :do)")
     //  		.setParameter("dd", pocetak).setParameter("do", kraj);
	   		
	/*    List<Integer> list = new LinkedList<>();
	    list = first.list();
	    List<Integer> list2 = new LinkedList<>();
	    list2 = second.list();
	    List<Integer> list3 = new LinkedList<>();*/
	    List<Soba> listSoba = new LinkedList<>();	    
	 /*  for(int i=0;i<list.size();i++) {
		   for(int j=0;j<list2.size();j++) {
			   if(list.get(i)==list2.get(j))
				   list3.add(list.get(i));
		   }
	   }
	    
	  for(int i=0;i<list3.size();i++) {
	 	   Query query2 = session.createQuery("from Soba where idSoba="+list3.get(i)); 
           List <Soba> privremena = query2.list();
           for(int j=0;j<privremena.size();j++)
        	   listSoba.add(privremena.get(j));
	   				  
	  }
	   session.getTransaction().commit();
	  
	    	session.close();
	    	if(list!=null)
	    	System.out.println(listSoba.get(0).toString());
	
*/
	    	return listSoba;
	    }
}
