insert into Korisnik (DTYPE, ime, prezime, email, kontakt, role, lozinka) values 
	('Administrator', 'Tamara', 'Perlinac', 'markovuckovic1808@gmail.com', '123456', 'ADMIN', 'Admin1234++');
insert into Korisnik (DTYPE, ime, prezime, email, kontakt, role, lozinka, blokiran) values 
	('KrajnjiKorisnik', 'Smiljana', 'Dragoljevic', 'smiljana@gmail.com', '123456', 'REGISTERED', 'Smiljana1234++', false);
insert into Korisnik (DTYPE, ime, prezime, email, kontakt, role, lozinka, poslovni_maticni_broj) values 
	('Agent', 'Marko', 'Vuckovic', 'marko@gmail.com', '123456', 'AGENT', 'Marko1234++', '1234567');
insert into Korisnik (DTYPE, ime, prezime, email, kontakt, role, lozinka, poslovni_maticni_broj) values 
	('Agent', 'Jelena', 'Stanarevic', 'jelena@gmail.com', '123456', 'AGENT', 'Jelena1234++', '1234567');
	
insert into Kategorija_Smestaja(id,kategorija) values (1,'nekategorizovan');
insert into Kategorija_Smestaja(id,kategorija) values (2,'*');
insert into Kategorija_Smestaja(id,kategorija) values (3,'**');
insert into Kategorija_Smestaja(id,kategorija) values (4,'***');
insert into Kategorija_Smestaja(id,kategorija) values (5,'****');
insert into Kategorija_Smestaja(id,kategorija) values (6,'*****');

insert into Tip_Smestaja(id,naziv) values (1,'hotel');
insert into Tip_Smestaja(id,naziv) values (2,'apartman');
insert into Tip_Smestaja(id,naziv) values (3,'bad&breakfast');	
	
insert into Smestaj (naziv, id_tip_smestaja, id_kategorija_smestaja, lokacija, opis) values 
	('Stay Hybrid Hostel', 1, 1, 'Solun', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.');
insert into Smestaj (naziv, id_tip_smestaja, id_kategorija_smestaja, lokacija, opis) values 
	('Mandrino Hotel', 1, 3, 'Solun', 'opis...');
insert into Smestaj (naziv, id_tip_smestaja, id_kategorija_smestaja, lokacija, opis) values 
	('Hotel Aleksandar', 1, 4, 'Novi Sad', 'opis...');
insert into Smestaj (naziv, id_tip_smestaja, id_kategorija_smestaja, lokacija, opis) values 
	('Hotel Vojvodina', 1, 2, 'Novi Sad', 'opis...');
insert into Smestaj (naziv, id_tip_smestaja, id_kategorija_smestaja, lokacija, opis) values 
	('Hotel Sheraton', 1, 1, 'Novi Sad', 'opis...');
insert into Smestaj (naziv, id_tip_smestaja, id_kategorija_smestaja, lokacija, opis) values 
	('Hotel Centar', 1, 2, 'Novi Sad', 'opis...');
insert into Smestaj (naziv, id_tip_smestaja, id_kategorija_smestaja, lokacija, opis) values 
	('HotelPrag', 1, 1, 'Prag', 'opis...');
insert into Smestaj (naziv, id_tip_smestaja, id_kategorija_smestaja, lokacija, opis) values 
	('HotelRim', 1, 3, 'Rim', 'opis...');
	
insert into Ponuda(datum_od, datum_do, cena, broj_lezaja, broj_slobodnih_ponuda, id_smestaj) values
	('2018-11-28 21:00:00', '2018-11-29 21:00:00', 100, 2, 3, 1);
insert into Ponuda(datum_od, datum_do, cena, broj_lezaja, broj_slobodnih_ponuda, id_smestaj) values
	('2018-11-23 21:00:00', '2018-11-29 21:00:00', 300, 3, 3, 1);
insert into Ponuda(datum_od, datum_do, cena, broj_lezaja, broj_slobodnih_ponuda, id_smestaj) values
	('2018-11-25 21:00:00', '2018-11-29 21:00:00', 200, 4, 3, 1);
insert into Ponuda(datum_od, datum_do, cena, broj_lezaja, broj_slobodnih_ponuda, id_smestaj) values
	('2018-11-15 21:00:00', '2018-11-29 21:00:00', 500, 2, 3, 1);
insert into Ponuda(datum_od, datum_do, cena, broj_lezaja, broj_slobodnih_ponuda, id_smestaj) values
	('2018-01-28 21:00:00', '2018-01-29 21:00:00', 50, 3, 4, 1);
insert into Ponuda(datum_od, datum_do, cena, broj_lezaja, broj_slobodnih_ponuda, id_smestaj) values
	('2018-01-28 21:00:00', '2018-01-29 21:00:00', 120, 3, 4, 3);
	
insert into Ponuda(datum_od, datum_do, cena, broj_lezaja, broj_slobodnih_ponuda, id_smestaj) values
	('2018-01-28 21:00:00', '2018-01-29 21:00:00', 100, 1, 1, 2);
	
insert into Komentar(datum_komentara,objavljen, opis,id_autor,id_smestaja) values ('2018-01-28 21:00:00',false,'Dobar kom',2,2);

insert into Usluga(naziv) values('wifi');
insert into Usluga(naziv) values('kitchen');
insert into Usluga(naziv) values('polupansion');
insert into Ponuda_usluga(id_ponuda, id_usluga) values (1, 1);
insert into Ponuda_usluga(id_ponuda, id_usluga) values (1, 2);
insert into Ponuda_usluga(id_ponuda, id_usluga) values (1, 3);
	
insert into Dodatne_Usluge(id,naziv) values (1, 'tv');
insert into Dodatne_Usluge(id,naziv) values (2, 'klima');
insert into Dodatne_Usluge(id,naziv) values (3, 'fen');
insert into Dodatne_Usluge(id,naziv) values (4, 'internet');

insert into Rezervacija(realizovano,datum_rezervacije,id_ponuda,id_korisnika) values (true,'2018-01-29 21:00:00',1,2);

insert into Smestaj_Vlasnik(id_smestaj,id_agent) values (1,3);
insert into Smestaj_Vlasnik(id_smestaj,id_agent) values (1,4);

insert into chat () values ();
insert into chat () values ();

insert into chat_korisnik (chat_id, korisnik_id) values (1, 2);
insert into chat_korisnik (chat_id, korisnik_id) values (1, 3);

insert into chat_korisnik (chat_id, korisnik_id) values (2, 2);
insert into chat_korisnik (chat_id, korisnik_id) values (2, 1);

insert into poruka(sadrzaj, datum_slanja,id_chat,id_posiljalac,seen) values('poy','2018-06-09 18:08:10',1,2,false);
insert into poruka(sadrzaj, datum_slanja,id_chat,id_posiljalac,seen) values('poqwdqwd','2018-06-09 18:08:10',1,3,false);
insert into poruka(sadrzaj, datum_slanja,id_chat,id_posiljalac,seen) values('qkemdkq','2018-06-09 18:08:10',1,2,false);

insert into poruka(sadrzaj, datum_slanja,id_chat,id_posiljalac,seen) values('heloo','2018-06-09 18:08:10',2,2,false);
insert into poruka(sadrzaj, datum_slanja,id_chat,id_posiljalac,seen) values('cao','2018-06-09 18:08:10',2,1,false);
