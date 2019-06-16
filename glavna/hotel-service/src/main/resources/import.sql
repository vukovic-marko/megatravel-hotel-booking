insert into authority (id, name) values (1, 'ADMIN');
insert into authority (id, name) values (2, 'AGENT');
insert into authority (id, name) values (3, 'KRAJNJI');

insert into administrator (id_korisnika, email, lozinka, ime, prezime, uloga) values (1, 'admin', 'lgJQcCz05yTeNzg0SKjTcO3Nku07zTf6KscCBud5PKUx3PgmJ5SPq', 'Admin', 'Admin', 0);
insert into administrator_authority (user_id, authority_id) values (1, 1);