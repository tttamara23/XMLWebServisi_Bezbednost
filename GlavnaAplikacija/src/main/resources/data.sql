insert into Korisnik (DTYPE, ime, prezime, email, kontakt, role, lozinka) values 
	('Administrator', 'KorisnikAdminIme', 'KorisnikAdminPrezime', 'markovuckovic1808@gmail.com', '123456', 'ADMIN', 'Admin1234++');
insert into Korisnik (DTYPE, ime, prezime, email, kontakt, role, lozinka, blokiran) values 
	('KrajnjiKorisnik', 'Smiljana', 'Dragoljevic', 'smiljana@gmail.com', '123456', 'REGISTERED', 'Smiljana1234++', false);
insert into Korisnik (DTYPE, ime, prezime, email, kontakt, role, lozinka, poslovni_maticni_broj) values 
	('Agent', 'Marko', 'Vuckovic', 'marko@gmail.com', '123456', 'AGENT', 'Marko1234++', '1234567');
	
insert into Smestaj (naziv, tip, kategorija, lokacija, opis) values 
	('Stay Hybrid Hostel', 'Hostel', 0, 'Solun', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.');
insert into Smestaj (naziv, tip, kategorija, lokacija, opis) values 
	('Mandrino Hotel', 'Hostel', 0, 'Solun', 'opis...');
insert into Smestaj (naziv, tip, kategorija, lokacija, opis) values 
	('Hotel Aleksandar', 'Hotel', 0, 'Novi Sad', 'opis...');
insert into Smestaj (naziv, tip, kategorija, lokacija, opis) values 
	('Hotel Vojvodina', 'Hotel', 0, 'Novi Sad', 'opis...');
insert into Smestaj (naziv, tip, kategorija, lokacija, opis) values 
	('Hotel Sheraton', 'Hotel', 0, 'Novi Sad', 'opis...');
insert into Smestaj (naziv, tip, kategorija, lokacija, opis) values 
	('Hotel Centar', 'Hotel', 0, 'Novi Sad', 'opis...');
insert into Smestaj (naziv, tip, kategorija, lokacija, opis) values 
	('HotelPrag', 'Hotel', 0, 'Prag', 'opis...');
insert into Smestaj (naziv, tip, kategorija, lokacija, opis) values 
	('HotelRim', 'Hotel', 0, 'Rim', 'opis...');
	
insert into Ponuda(datum_od, datum_do, cena, broj_lezaja, broj_slobodnih_ponuda, id_smestaj) values
	('2018-11-28 21:00:00', '2018-11-29 21:00:00', 100, 2, 3, 1);
insert into Ponuda(datum_od, datum_do, cena, broj_lezaja, broj_slobodnih_ponuda, id_smestaj) values
	('2018-11-23 21:00:00', '2018-11-29 21:00:00', 100, 2, 3, 1);
insert into Ponuda(datum_od, datum_do, cena, broj_lezaja, broj_slobodnih_ponuda, id_smestaj) values
	('2018-11-25 21:00:00', '2018-11-29 21:00:00', 100, 2, 3, 1);
insert into Ponuda(datum_od, datum_do, cena, broj_lezaja, broj_slobodnih_ponuda, id_smestaj) values
	('2018-11-15 21:00:00', '2018-11-29 21:00:00', 100, 2, 3, 1);
insert into Ponuda(datum_od, datum_do, cena, broj_lezaja, broj_slobodnih_ponuda, id_smestaj) values
	('2018-01-28 21:00:00', '2018-01-29 21:00:00', 100, 3, 4, 1);
	
insert into Ponuda(datum_od, datum_do, cena, broj_lezaja, broj_slobodnih_ponuda, id_smestaj) values
	('2018-01-28 21:00:00', '2018-01-29 21:00:00', 100, 1, 1, 2);
	
insert into Komentar(datum_komentara,objavljen, opis) values ('2018-01-28 21:00:00',false,'Dobar kom');
	
	
