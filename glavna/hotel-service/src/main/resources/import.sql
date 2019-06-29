delete from administrator_authority where (user_id = 1);
delete from agent_authority where (user_id = 1);
delete from krajnjikorisnik_authority where (user_id = 1);

delete from authority where (id = 1);
delete from authority where (id = 2);
delete from authority where (id = 3);

insert into authority (id, name) values (1, 'ADMIN');
insert into authority (id, name) values (2, 'AGENT');
insert into authority (id, name) values (3, 'KRAJNJI');

-- Lozinke su hesovane pomocu BCrypt algoritma https://www.dailycred.com/article/bcrypt-calculator


-- lozinka: admin
insert into administrator (idkorisnika, username, password, ime, prezime, uloga) values (1, 'admin', '$2a$04$1B8pqTQWYCGcnYQ/MusPROWXKthEV3dFEgnqInbNg2P9Ka9DSKICG', 'Admin', 'Admin', 0);
insert into administrator_authority (user_id, authority_id) values (1, 1);

-- lozinka: agent
insert into agent (idkorisnika, username, password, ime, prezime, uloga) values (1, 'agent', '$2a$04$kZNiJiEcwn6iS9sC6bUx6el2yF9GhuajI9J/Y.gcjX0iOna143Ghq', 'Agent', 'Agent', 1);
insert into agent_authority (user_id, authority_id) values (1, 2);

-- lozinka: korisnik
insert into krajnjikorisnik (idkorisnika, username, password, ime, prezime, uloga, uklonjen, blokiran) values (1, 'korisnik', '$2a$04$dRHKIvyyAUAaYUpuSYHGCezbyOyvYTcd8Ny2XJZokX0ykntxIyZte', 'Korisnik', 'Korisnik', 2, false, false);
insert into krajnjikorisnik_authority (user_id, authority_id) values (1, 3);

insert into adresa (id,grad,drzava,ulicaibroj) values (1,"Madrid","Spanija","ul2");

insert into tipsmestaja (idtipa, naziv) values (1, 'Hotel');
--ubacivanje dodatnih usluga
insert into dodatneusluge(id,naziv,cena) values (1,"Wi-Fi",200);
insert into dodatneusluge(id,naziv,cena) values (2,"Parking",300);
insert into dodatneusluge(id,naziv,cena) values (3,"Dorucak",1000);
insert into dodatneusluge(id,naziv,cena) values (4,"Polu pansion",200);
insert into dodatneusluge(id,naziv,cena) values (5,"Pansion",3000);
insert into dodatneusluge(id,naziv,cena) values (6,"All inclusive",5000);
insert into dodatneusluge(id,naziv,cena) values (7,"Kucni ljubimci",800);
insert into dodatneusluge(id,naziv,cena) values (8,"Mini kuhinja",500);
insert into dodatneusluge(id,naziv,cena) values (9,"Privatno kupatilo",500);
insert into dodatneusluge(id,naziv,cena) values (10,"Besplatno otkazivanje",0);

insert into poruka(idporuka,sadrzaj,agentprimalac,klijentposiljac)
values (1,"Proba poruka 1",1,1);
insert into poruka(idporuka,sadrzaj,agentprimalac,klijentposiljac)
values (2,"Proba poruka 2",1,1);


