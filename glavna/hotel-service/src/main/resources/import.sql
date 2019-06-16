delete from administrator_authority where (user_id = 1);
delete from agent_authority where (user_id = 1);
delete from krajnji_korisnik_authority where (user_id = 1);

delete from authority where (id = 1);
delete from authority where (id = 2);
delete from authority where (id = 3);

insert into authority (id, name) values (1, 'ADMIN');
insert into authority (id, name) values (2, 'AGENT');
insert into authority (id, name) values (3, 'KRAJNJI');

-- Lozinke su hesovane pomocu BCrypt algoritma https://www.dailycred.com/article/bcrypt-calculator


-- lozinka: admin
insert into administrator (id_korisnika, email, lozinka, ime, prezime, uloga) values (1, 'admin', '$2a$04$1B8pqTQWYCGcnYQ/MusPROWXKthEV3dFEgnqInbNg2P9Ka9DSKICG', 'Admin', 'Admin', 0);
insert into administrator_authority (user_id, authority_id) values (1, 1);

-- lozinka: agent
insert into agent (id_korisnika, email, lozinka, ime, prezime, uloga) values (1, 'agent', '$2a$04$kZNiJiEcwn6iS9sC6bUx6el2yF9GhuajI9J/Y.gcjX0iOna143Ghq', 'Agent', 'Agent', 1);
insert into agent_authority (user_id, authority_id) values (1, 2);

-- lozinka: korisnik
insert into krajnji_korisnik (id_korisnika, email, lozinka, ime, prezime, uloga) values (1, 'korisnik', '$2a$04$dRHKIvyyAUAaYUpuSYHGCezbyOyvYTcd8Ny2XJZokX0ykntxIyZte', 'Korisnik', 'Korisnik', 2);
insert into krajnji_korisnik_authority (user_id, authority_id) values (1, 3);