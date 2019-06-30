package tim23.searchservice;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tim23.searchservice.model.Rezervacija;
import tim23.searchservice.model.Soba;
import tim23.searchservice.repository.SearchRepository;

@Service
public class SearchService {
	
	@Autowired
	SearchRepository sr;
  
	    public List<Soba> fuzzySearch(String brojkreveta,String grad,String p, String k,String tipSmestaja,String kategorija,ArrayList<String> listaUsluga) throws ParseException {
	    	if(tipSmestaja==null)
	    		tipSmestaja="";
	    	if(kategorija==null)
	    		kategorija="";	
	    	if(tipSmestaja.equals("undefined"))
	    		tipSmestaja="";
	    	if(kategorija.equals("undefined"))
	    		kategorija="";	
	    	
	    	
	        	String []prviDatum = p.split("/");
		       String []drugiDatum = k.split("/");
		       
		       String pocetak = prviDatum[2]+"-"+prviDatum[0]+"-"+prviDatum[1];
		       String kraj = drugiDatum[2]+"-"+drugiDatum[0]+"-"+drugiDatum[1];
		       java.util.Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(pocetak);  
		       
		       java.util.Date date2=new SimpleDateFormat("yyyy-MM-dd").parse(kraj);  
		       
	    	SessionFactory sf = new Configuration().configure().buildSessionFactory();
	    	Session session = sf.openSession();
	    	session.beginTransaction();

	    	Query first = session.createQuery("select s.idSoba from Soba s left outer join Adresa a on a.id = s.adresa left outer join TipSmestaja t on t.idTipa = s.tipSmestaja left outer join KategorijaSmestaja k on k.id = s.kategorijaSmestaja where t.naziv like '%"+tipSmestaja+"%' and k.naziv like '%"+kategorija+"%'  and a.grad = :grd  and s.brojKreveta >= "+Integer.parseInt(brojkreveta))
	        		.setParameter("grd", grad);
    
       Query half = session.createQuery("from Rezervacija");
       
       
       Query second = session.createQuery("select r.soba from Rezervacija r left outer join Soba s on s.idSoba = r.soba where (r.datumDolaska > :dd and r.datumOdlaska > :do and r.datumDolaska > :do and r.datumOdlaska> :dd) or (r.datumDolaska < :dd and r.datumOdlaska < :do and r.datumDolaska < :do and r.datumOdlaska< :dd)")
     		.setParameter("dd", date1).setParameter("do", date2);
       
	   	List<Integer> list = new LinkedList<>();
	   	HashSet<Integer> kojeNemajuRez = new HashSet<>();
	    list = first.list();
	    List<Rezervacija> sveRezervacije = half.list();
	    List<Soba> list2 = new LinkedList<>();
	    HashSet<Integer>list3 = new HashSet<>();		  
	    List<Soba> listSoba = new LinkedList<>();	
            
	    if(sveRezervacije!=null || sveRezervacije.size()!=0) {
	        int flag=0;
	        for(int i=0;i<list.size();i++) {
	    	flag = 0;
	    	for(int j=0;j<sveRezervacije.size();j++) {
	    		if(list.get(i)==sveRezervacije.get(j).getIdSobe().getIdSoba()) {
	    			flag=1;
	    		}
	    	}
	    	if(flag == 0)//dodaj ako nemaju nijednu rezervaciju
	    		kojeNemajuRez.add(list.get(i));//presek prvog upita i onih koje nemaju rez
	    	
	    }
	    
	    
	    list2 = second.list();
	    System.out.println("list1: "+list.size() + " list2: "+list2.size());
	   	
	    
	    for(int i=0;i<list.size();i++) {
		   for(int j=0;j<list2.size();j++) {			   
			   if(list2.get(j)!=null) {
			       if(list.get(i)==list2.get(j).getIdSoba()) {                        			   
 				         list3.add(list.get(i));
			   }
			   
		    }
			   
		 }

	  }
	    
	    for(Integer po:kojeNemajuRez)
	    	list3.add(po);
	    }
	    else
	    {
	    	for(int i=0;i<list.size();i++) {
	    		list3.add(list.get(i));
	    	}
	    }
	    
	    if(listaUsluga.size()!=0) {
	      for(Integer inti :list3) {
	    	  String query3 = "select d.naziv from DodatneUsluge d left outer join SobeDodatneUsluge sdu on d.id = sdu.dodatnaUsluga where sdu.soba ="+inti;	
	         Query uslugeQ = session.createQuery(query3);
	         List<String>du = uslugeQ.list();
	         int velicina = listaUsluga.size();
	         int brojac = 0;
	         for(int i=0;i<du.size();i++) {
	        	for(int j=0;j<listaUsluga.size();j++) {
	        		if(du.get(i).equals(listaUsluga.get(j))) {
	        			brojac++;
	        		}
	        	}
	        	 
	         }
	         if(velicina == brojac) {
	             if(sr.getByIdSoba(inti).isOdobreno())
	        	 listSoba.add(sr.getByIdSoba(inti));
	         
	         }
	  }
	    }else {
	    	for(Integer i:list3) {
	    		listSoba.add(sr.getByIdSoba(i));
	    	}
	    }
	   session.getTransaction().commit();
	  
	    	session.close();
	    	
	   
        
	    	return listSoba;
	    }

		
}
