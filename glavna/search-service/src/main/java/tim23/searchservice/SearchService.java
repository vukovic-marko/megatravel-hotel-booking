package tim23.searchservice;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.xml.crypto.Data;

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

import com.fasterxml.jackson.core.format.DataFormatDetector;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
@Service
public class SearchService {
	
	@Autowired
	SearchRepository sr;
  
	    public List<Soba> fuzzySearch(String brojkreveta,String drzava,String grad, String ulicaibroj,String p, String k,String tipSmestaja,String[] listaUsluga) throws ParseException {
	    	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-dd-MM");
	    	java.util.Date pocetak = sdf1.parse(p);
	       	java.util.Date kraj = sdf1.parse(k);
		       
	    	SessionFactory sf = new Configuration().configure().buildSessionFactory();
	    	Session session = sf.openSession();
	    	session.beginTransaction();

       Query first = session.createQuery("select s.idSoba from Soba s left outer join Adresa a on a.id = s.adresa left outer join TipSmestaja t on t.idTipa = s.tipSmestaja where t.naziv like :ts and a.drzava = :drz and a.grad = :grd and a.ulicaIBroj = :uib and s.brojKreveta > "+Integer.parseInt(brojkreveta))
        		.setParameter("drz", drzava).setParameter("grd", grad).setParameter("uib", ulicaibroj).setParameter("ts", "%" +tipSmestaja+ "%");
       Query second = session.createQuery("select r.soba from Rezervacija r left outer join Soba s on s.idSoba = r.soba where (r.datumDolaska > :dd and r.datumOdlaska > :do and r.datumDolaska > :do and r.datumOdlaska> :dd) or (r.datumDolaska < :dd and r.datumOdlaska < :do and r.datumDolaska < :do and r.datumOdlaska< :dd)")
     		.setParameter("dd", pocetak).setParameter("do", kraj);
       
	   	List<Integer> list = new LinkedList<>();
	    list = first.list();
	    List<Soba> list2 = new LinkedList<>();
	    list2 = second.list();
	    System.out.println("list1: "+list.size() + " list2: "+list2.size());
	    HashSet<Integer>list3 = new HashSet<>();		  
	    List<Soba> listSoba = new LinkedList<>();	
	   	
	    
	    for(int i=0;i<list.size();i++) {
		   for(int j=0;j<list2.size();j++) {			   
			   if(list2.get(j)!=null) {
			       if(list.get(i)==list2.get(j).getIdSoba()) {                        			   
 				         list3.add(list.get(i));
			   }
			   
		    }
			   
		 }

	  }
	    
	    if(listaUsluga.length!=0) {
	      for(Integer inti :list3) {
	    	  String query3 = "select d.naziv from DodatneUsluge d left outer join SobeDodatneUsluge sdu on d.id = sdu.dodatnaUsluga where sdu.soba ="+inti;	
	         Query uslugeQ = session.createQuery(query3);
	         List<String>du = uslugeQ.list();
	         int velicina = listaUsluga.length;
	         int brojac = 0;
	         for(int i=0;i<du.size();i++) {
	        	for(int j=0;j<listaUsluga.length;j++) {
	        		if(du.get(i).equals(listaUsluga[j])) {
	        			brojac++;
	        		}
	        	}
	        	 
	         }
	         if(velicina == brojac)
	        	 listSoba.add(sr.getByidSoba(inti));
	        
	  }
	    }else {
	    	for(int i=0;i<list3.size();i++) {
	    		listSoba.add(sr.getByidSoba(i));
	    	}
	    }
	   session.getTransaction().commit();
	  
	    	session.close();
	    	
	   

	    	return listSoba;
	    }

		
}
