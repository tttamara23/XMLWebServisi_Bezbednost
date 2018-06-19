insert into role (name) values ('REGISTERED');
insert into role (name) values ('ADMIN');
insert into role (name) values ('AGENT');

--ADMIN
insert into permission (name) values ('INSERT_AGENT');
insert into permission (name) values ('INSERT_TIP_SMESTAJA');
insert into permission (name) values ('INSERT_KATEGORIJA_SMESTAJA');
insert into permission (name) values ('INSERT_DODATNA_USLUGA');
insert into permission (name) values ('GET_USERS');
insert into permission (name) values ('BLOCK_UNBLOCK_USER');
insert into permission (name) values ('DELETE_USER');
insert into permission (name) values ('DELETE_TIP_SMESTAJA');
insert into permission (name) values ('DELETE_KATEGORIJA_SMESTAJA');
insert into permission (name) values ('DELETE_DODATNA_USLUGA');
insert into permission (name) values ('UPDATE_TIP_SMESTAJA');
insert into permission (name) values ('UPDATE_KATEGORIJA_SMESTAJA');
insert into permission (name) values ('UPDATE_DODATNA_USLUGA');
insert into permission (name) values ('GET_ALL_COMMENTS');
insert into permission (name) values ('PUBLISH_COMMENTS');

INSERT INTO role_permission (role_id, permission_id) values (2, 1);
INSERT INTO role_permission (role_id, permission_id) values (2, 2);
INSERT INTO role_permission (role_id, permission_id) values (2, 3);
INSERT INTO role_permission (role_id, permission_id) values (2, 4);
INSERT INTO role_permission (role_id, permission_id) values (2, 5);
INSERT INTO role_permission (role_id, permission_id) values (2, 6);
INSERT INTO role_permission (role_id, permission_id) values (2, 7);
INSERT INTO role_permission (role_id, permission_id) values (2, 8);
INSERT INTO role_permission (role_id, permission_id) values (2, 9);
INSERT INTO role_permission (role_id, permission_id) values (2, 10);
INSERT INTO role_permission (role_id, permission_id) values (2, 11);
INSERT INTO role_permission (role_id, permission_id) values (2, 12);
INSERT INTO role_permission (role_id, permission_id) values (2, 13);
INSERT INTO role_permission (role_id, permission_id) values (2, 14);
INSERT INTO role_permission (role_id, permission_id) values (2, 15);

--ADMIN I KRAJNJI KORISNICI
insert into permission (name) values ('GET_TIP_SMESTAJA');
insert into permission (name) values ('GET_KATEGORIJA_SMESTAJA');
insert into permission (name) values ('GET_DODATNA_USLUGA');

INSERT INTO role_permission (role_id, permission_id) values (1, 16);
INSERT INTO role_permission (role_id, permission_id) values (1, 17);
INSERT INTO role_permission (role_id, permission_id) values (1, 18);
INSERT INTO role_permission (role_id, permission_id) values (2, 16);
INSERT INTO role_permission (role_id, permission_id) values (2, 17);
INSERT INTO role_permission (role_id, permission_id) values (2, 18);

--KRAJNJI KORISNIK I AGENT
insert into permission (name) values ('GET_CHATS');
insert into permission (name) values ('SEND_MESSAGE');
insert into permission (name) values ('GET_MESSAGES');
insert into permission (name) values ('SEEN_MESSAGES');
insert into permission (name) values ('GET_SMESTAJ');
insert into permission (name) values ('GET_VLASNIK_SMESTAJ');

INSERT INTO role_permission (role_id, permission_id) values (1, 19);
INSERT INTO role_permission (role_id, permission_id) values (1, 20);
INSERT INTO role_permission (role_id, permission_id) values (1, 21);
INSERT INTO role_permission (role_id, permission_id) values (1, 22);
INSERT INTO role_permission (role_id, permission_id) values (1, 23);
INSERT INTO role_permission (role_id, permission_id) values (1, 24);
INSERT INTO role_permission (role_id, permission_id) values (3, 19);
INSERT INTO role_permission (role_id, permission_id) values (3, 20);
INSERT INTO role_permission (role_id, permission_id) values (3, 21);
INSERT INTO role_permission (role_id, permission_id) values (3, 22);
INSERT INTO role_permission (role_id, permission_id) values (3, 23);
INSERT INTO role_permission (role_id, permission_id) values (3, 24);

--KRAJNJI KORISNIK
insert into permission (name) values ('GET_PUBLISHED_COMMENTS');
insert into permission (name) values ('ADD_COMMENT');
insert into permission (name) values ('ADD_RATING');
insert into permission (name) values ('GET_PONUDA');
insert into permission (name) values ('SEARCH_PONUDA');
insert into permission (name) values ('GET_PONUDA_USLUGA');
insert into permission (name) values ('CREATE_RESERVATIONS');
insert into permission (name) values ('CANCEL_RESERVATIONS');
insert into permission (name) values ('GET_IMAGES');
insert into permission (name) values ('GET_RESERVATIONS');
insert into permission (name) values ('CHECK_RESERVATIONS');

INSERT INTO role_permission (role_id, permission_id) values (1, 25);
INSERT INTO role_permission (role_id, permission_id) values (1, 26);
INSERT INTO role_permission (role_id, permission_id) values (1, 27);
INSERT INTO role_permission (role_id, permission_id) values (1, 28);
INSERT INTO role_permission (role_id, permission_id) values (1, 29);
INSERT INTO role_permission (role_id, permission_id) values (1, 30);
INSERT INTO role_permission (role_id, permission_id) values (1, 31);
INSERT INTO role_permission (role_id, permission_id) values (1, 32);
INSERT INTO role_permission (role_id, permission_id) values (1, 33);
INSERT INTO role_permission (role_id, permission_id) values (1, 34);
INSERT INTO role_permission (role_id, permission_id) values (1, 35);

insert into Korisnik (DTYPE, ime, prezime, email, kontakt, id_rola, lozinka,salt) values 
	('Administrator', 'Tamara', 'Perlinac', 'markovuckovic1808@gmail.com', '123456', 2, '4543-17-65-67-17-65-6768-17-65-67-17-65-6750-17-65-6783-34-117-17-65-67-17-65-67-17-65-67-17-65-67114-17-65-6730-17-65-67-17-65-67-17-65-6725891241-17-65-67-17-65-671244422-17-65-67','ef94e4d4a60d73cba091e97072b63c52f0e78e87d044e0c5a602f37152e43d1de638f0281dccae9097f3b001ba7b3a32b6a3863be5186c3bc072fd106a45128c');
insert into Korisnik (DTYPE, ime, prezime, email, kontakt, id_rola, lozinka, blokiran,salt) values 
	('KrajnjiKorisnik', 'Smiljana', 'Dragoljevic', 'smiljana@gmail.com', '123456', 1, '5629-17-65-67-17-65-6711017-17-65-6765-17-65-6770-17-65-67-17-65-6736124-17-65-67127-17-65-67108-17-65-67-17-65-67-17-65-6765-17-65-679838-17-65-67-17-65-6794-17-65-6766', false,'8ac017f67a75787c7b96b7d314ecd698e7d947ed3647e5cdd8528cf6644a0c9c18c39dc1062a5ebb078abceeacb149a20ea331081f95a30c0ab2f8ea56bc4a70');
insert into Korisnik (DTYPE, ime, prezime, email, kontakt, id_rola, lozinka, poslovni_maticni_broj,salt) values 
	('Agent', 'Marko', 'Vuckovic', 'marko@gmail.com', '123456', 3, '107-17-65-67418122-17-65-67-17-65-672-17-65-67-17-65-67104121-17-65-67-17-65-6766-17-65-6747-17-65-6731-17-65-6711542-17-65-6752-17-65-6775601191022848', '1234567','948b19610bfdfb85b5b540307da9dadfa37d88c03a5c2a0050492650bc6c0d31c9a3d41504c85e907a9132f800f8387eeb3de3ea585d7e5eb7c8d71cc225dcf0');
insert into Korisnik (DTYPE, ime, prezime, email, kontakt, id_rola, lozinka, poslovni_maticni_broj,salt) values 
	('Agent', 'Jelena', 'Stanarevic', 'jelena@gmail.com', '123456', 3, '90-17-65-6743-17-65-6778766626741711270-17-65-6759541-17-65-67-17-65-67112-17-65-6741-17-65-6715-37-9631-17-65-671121144091-17-65-67', '1234567','2aa3e6c6d34e6a89ce4c9b4437aca4799b7470edeea7d90430afb0ea76395f395a271fbe70e8533b42ac21bd14b305e4e4663156d4d4ac17b525108fe0754acc');
	
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
	
insert into Slika (url, id_smestaj) values ('https://t-ec.bstatic.com/images/hotel/max1024x768/109/109456311.jpg', 1);
insert into Slika (url, id_smestaj) values ('https://q-xx.bstatic.com/images/hotel/max500/109/109192645.jpg', 1);
insert into Slika (url, id_smestaj) values ('https://q-xx.bstatic.com/images/hotel/840x460/109/109192573.jpg', 1);
insert into Slika (url, id_smestaj) values ('https://media-cdn.tripadvisor.com/media/photo-s/13/22/ec/96/stay-hybrid-hostel.jpg', 1);
insert into Slika (url, id_smestaj) values ('https://aff.bstatic.com/images/hotel/max500/109/109192580.jpg', 1);

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
insert into Komentar(datum_komentara,objavljen, opis,id_autor,id_smestaja) values ('2018-05-18 21:00:00',true,'Super mesto...',2,1);
insert into Komentar(datum_komentara,objavljen, opis,id_autor,id_smestaja) values ('2018-04-23 21:00:00',true,'Bezveze komentar',2,1);
insert into Komentar(datum_komentara,objavljen, opis,id_autor,id_smestaja) values ('2017-07-08 21:00:00',true,'nfowrnfowurgnfrmcveklvnwrljvnrnvrwovnrwovnrwnvrejnvrjwbnejkbnerkjnljvnerljvnrjkvnrwjvnrwjvnverluvnreoivneriowofnwrofnrwofwrn',2,1);

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