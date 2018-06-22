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
insert into Ponuda_usluga(id_ponuda, id_usluga) values (1, 3);
	
insert into Dodatne_Usluge(id,naziv) values (1, 'tv');
insert into Dodatne_Usluge(id,naziv) values (2, 'klima');
insert into Dodatne_Usluge(id,naziv) values (3, 'fen');
insert into Dodatne_Usluge(id,naziv) values (4, 'internet');

insert into Rezervacija(realizovano,datum_rezervacije,id_ponuda,id_korisnika) values (true,'2018-01-29 21:00:00',1,2);

insert into Smestaj_Vlasnik(id_smestaj,id_agent) values (1,3);

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

insert into Slika (url, id_smestaj) values ('/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxMSEhUTExMWFhUXGBgaGRgYGRcdHRgeHRsdHR4g
Gh8YHSggGh8lGxoYITEhJiktLi4uGB8zODMtOCgtLisBCgoKDg0OGxAQGy8lICYyMC0tLSstLS8t
LS0tLy0tLS0tLS0tLS0vKy0tLS0tLS0tLS0tLS0tLy0tLS0tLS0tLf/AABEIAMIBAwMBIgACEQED
EQH/xAAcAAACAgMBAQAAAAAAAAAAAAAFBgQHAAIDAQj/xABJEAACAAQEAwUEBQoEBQMFAAABAgAD
BBEFEiExBkFREyJhcYEykaGxFEJScsEHIyQzNGKC0eHwQ1OSshVzosLxY9LyFhdEk+L/xAAaAQAC
AwEBAAAAAAAAAAAAAAADBAECBQAG/8QANxEAAgECBQEGBAYBAwUAAAAAAQIAAxEEEiExQVEFEyIy
YXGBsdHwFDORocHhI0KC8RUkNENy/9oADAMBAAIRAxEAPwBqiLW4jKle24B6bn3CFerx6dM9juLy
tv7/AOUBKmqloSXa7cwNTfx/rGo+IA2nm2xNzZBeMtbxOx0krYfabf0GwgHV1Guea+p5k6nyH8oB
1GMsdEAUdefvOgiAJoLAzGJBIzHnbnqfCFHrFp34epU1qHTpC1RjCjSWtz1P4AamBlTVO/ttp0/o
NI1xCUZUx5e2ViP/AD1iMTAiSd4zToonlE9J6D1Op/lGpjUtGpaKw1jN48vG9HTTJrhJSM7n6qgk
266bDx2gxheAK75Zs5RYjMsq0wrf/MmKeylDxLE+BjpdabNtAtxYkm1rW03668rDWJyYRMyq8zLJ
RvZeccmb7i+248VUwdpUlyzmRVlW2y2mzvMzZg7OWf8AloSOsaipyuXQWc7zCWeafOY5L38iI6MC
gOZzTCpUoaoXb7dRmlIPuyV/PP4FygPSO2J18tu4ikyxayNZZYYAAkSpQCklgTd8x1tEGfPtc+sc
3lO810lIzZWYaa2FyBmOyjxNo6GACjQTafVMwAJ0X2VAAVfuqtlX0ERXm2ieuGKh/SJoQ85ad5/I
nZPjBWhopl709OJQ5TZur+Yv7P8ADeJGu0DVrU6fnMESsPnsgJXs5YJOeZ3R3gLaHXUDQ21ibSUU
kmypMqZnkUQem/qbg+EEVo5N80x2qZgvovsqeYBvZdd9RfpE+U021lyyU+zLAJ9SRb4esEWkTM6v
2qF0XT3+kjDDnCgz5yU8u+iS7Lr0GXmRobE36RMpFlSrfR5FzyeZcW8gRmv6L5xkunUNm1Lc2Ykt
7zrbw2gtIw2b2X0gFbBhZbi5F97+J0tvB1ohd5lNi6uIJyAm2pv09opcaCpTsmmd4ENdcoW21yo3
6bkwDwpg0+WQbizEe4w6ceVDOJBZSBaYBe37l/whCM8yGDIme17Lrz8vOAVNGjiDMmQb20O28d5R
hvl1ILFeY28dB8dRp4g7ERU8hK2o0J7JT/D8u9DfguIOzGmqO7VS9joO2UbEHmbEkeZ8bWZ78S/Z
tMYeoxJBvvbie8R8Py2VmykKbsQiksr6DOgG5yjvD64W3tBYrWspWltla17Agg3DAi6sp+spFiDF
zyantLLsw/AkfMEEciCOULPFnDylMw7qjMb8pLE5iTzElySW+wxzbF4Cw5E2qtMOLjeVwp58xr/U
eMN2BYqZljmtOTW/2h1/mIU6iSyMVYFWU2IO4Ij2TNKkOpsV105eI8I5WtM+rTzi3Mu/CsSWetxo
w9peh8PCJsVxguMk2nS9HFhMTkf/AOT15RYFFVrNQOh0PLmD0PjDSteTRqFvC24nePY8jBExiexk
ZGR0mUjU4tNfY5V8NPjufSB+nn8BGpaPUFyBpr1IA9SdBCh1iyqFFlE9ZzzjRzoYYKHAB9Il080t
2kwXCgWUCxN2Y6nQHRR/EIziHhWZKmBZStMVtFCglvQC5I95HPqelha9pE4ua1ZUD/1GgOW0vpuR
vr6+ENONYSJlbUFpot2jnJKHazLX3IU5JY8ZjrbnHtPTypRuiKlti2WfOPjcjsJf8KuREEwtKico
vAdJg06YgmZQko3ImTDkQgC5Kk6uABrlBgtKwaVLAzBprEXzTM0mUPEJbt5vmAgMdXrmEwzVZu0I
sZjOzzCNrZ21AtpZco8IjPO5k76nxiIyKSiTpk5cnZ3LJzRR2Uo+cuWbzPOYzHwER5lWQoX6q3yo
LKov0VdB7oiS3aYSJalyLXtsL7XOy+sSFolX9om5T/lyxmfyJ2X3GOuJcm2pnIzrDeJi4dNIzOBK
Xm0w5fh7WvLTWJtFTzvakSRIX/Mme35gm5X00MdEpZBOZneqcbW9gdQDcKBfkD6RcKTEauPpJtqZ
Al0sk91FmVLc9CiD3ajzJIPhBE08yw7aaslDtLlWBJ52trc87XvziZKWYRa6yl+zLA+LEfIDzjeX
TIhNhcndiSSfMnU++DLQ6zHxHartoDb2+v8AzI9HJSX+okgEfXmbjyG/+2JE2SX/AFrFx9nZfcND
63jdpkas23ibDxPQdT4QcIBMtq1Rzp/c6JYaARtmjkdCQQQy6FSCGGl7EHUG3XrDvhvCUpVBnEu9
gWFyqg8wMupHmdY5qgUQ2F7Pq4liBpbe8S1bUi4uNx0jlNxDOnZMxCdpZRe2Zhe9v3Rr6gxFxTFf
pFd+jhVkoCihVCrkB1Nh9ptR5jxiYssZgx2UWXw6+Wmnv6xCvnF5erQGFqFQ19OPv7EF8RzMqypd
zlXOR/ERf5CAuDt+kL5N8oIcSVKsyhTewMC8EP6QPut8oXqHxxuiG7jxb2jlI5RFxN1qp8yQ75J8
qa/0abt9a4Rj0vax5fORTnbzELeLvernjpNmf7jEYhrAGB7OvdrekcOHcX7Zik1clVKuJibZ7C2Y
DrawI5i37tmOW/LcEfh8iIQCGqwrKwStlW7OZt2oH1W5ZrbE77dYY+HMcWoU3GWcmk2Xr3TfVlHQ
ncdSed81KbhhPQUa2XRtvl/UCcY8MiwKEX7qygd7bCWzbW2Etm8EJ9iK+IIPQi4IPuIIi9nkrMQy
3UMpBBB2IOnyivOL+HGDFlF31IPOcoFzp/mqASbe2ve9oNfmFoarTv4hFShq2lMHQ+BHUcwfAw+Y
FjIS01LmW1g6/ZP8xf1EV0Db+94IYTiBkvfdG0YdR/Mf3vHI1jEKqE+JdxLvlTAwDKbgi4I5xtCh
w3iwl2Ba8ptQfs35+XUf1hvhoG8LSqB1vzPYyPIyOhZ8/cidNLcxfXoNzHejw+bPzCVLZ7DvEDur
95j3VHmRDLIwSUn1MxG8yfcf6KeWwb/9rr4jlE1yGaWpu6qy5VbKJa67rJlgSlPoT4mE5fubC5hS
YoOKyj9hG/2W/GAWOYwwmLIN2SajZlLsFO98wSxbbm1vCDSvfEpp+zJf/tEKePSGarlBFZmya25X
ZgL8h6wRvKfeZGCucQn/AMk/vO71Jy5BZU3CIAqX65VsL+O/jESZPtziWaNE/aJuU/5ad5/Jjsnx
9Il0tPMJBkSRJUaibNPf8xf2fS4MDAJ2m1Ur06Yu5tBRoJzasOyQbtM7oHodfLTWJFPSSicstZlS
/kVQedvxuD4QUShlE5mL1L8iNEHgD7IHgD6QSlpMy2uJS/Zl6fEj5AQRaJMy6/ayr5R+v0g36DMs
BUTlkrylSgAfEDLtfmBcHmI7UkhZelPIC/8AqTNx91f/AIxMk0yJcgancm5J8ydTHR3hhaIEx63a
D1D199v0kd6PP+uYzP3T7P8ApGh9bxJWyiwHlGhjenktMdUXd2Cj1O58Bv5CCAAaxO71SF/QTzMT
GisCTYg23sdvOHyi4Sp5du0Jmk8mNlJ3tlHtaAmxvtAz8oWHBZUuolgL2LBWCiw7NjY6D7LWPhcw
Lvxea/8A0OqtMsW16RWbbrbltfwvyvtfxix+Haal7NZtOo7w9o3LjqrFrlSDcFdorhjBThvGjTTN
f1Tn84PsnYOPgD4W6azWUkXEp2RiUpVcrjfnpGHGuGjNr5FSuigfnrG2bJqlxzudD4ARy/KNj/0a
n7NDaZOuo/dX6x+Nh5+ENd4pzi8tU4lMVvZlkL5KADb1Yn3woATpPS4h1ooz9ZHwKkyJmOjPr5Dl
/OMxV2dAsohmLciNLA7/AA+Ed8UzmWezsW6eHrEfAaFpYLTDd28b2H/mHLf6RPI5wSa7HW+ggPEa
FpRGdrswubcvXnHDBD+kD7rQV4sPeT7p+cB8DP6R/C34Qs4Ae00qbF6BY7kR0kNtCLjdWRW1HI9t
Mt494w7U7beYhE41TLVTD9p5vwmMImuLqJTshAzOD0jDhM8ONDqLe+DlbTPOIqJHdrJY1toJ6gcx
tmsPUelq5wnECrb6/OLCwasEwBlNmFvMGMxmai1+JqlNcp3jFw7jST0zjukC0xD/AITeP7h1seXg
L5TFZSJOQo40uDcEgqQbgqRqrAgEEagiFHEaOYrfTKQATx+tlj2Zy8yB9rqB5jXc9geLy58tXlnu
mwsd0bbI3wsee2ptd+nUDi4haNW3gb4SveL8B7J2ZATbvP3bBhpeYgGwDHKy/VNjorCywDF511Cs
9LXsysSrC11bUX10IIJBU6EMQbgxU3EeDGQxIXKARnX/ACyb2I6y2scrctVPeXWCLSa1K3iE0wLE
uzbI5/Nn/pPUeEOWG4s1PM7zFpLWuL3y6WDL4WABA5RXUqVdGb7JUf6r6fAmDWB4lcCTMP3CeX7p
/D3dIIjTPqhlOdN+Zb6sCARqCLgjmIyEOTXVEoZJc9kVdlshtz+spMZBsxlvx1Lm8hzJgAjbDaeY
82UwU5M6HMdAQGGovv6RMlUznvS5IlqNe1nnW3ULsPBgL+UQqnGaaTMDtOmVU4EFQvshtrjkTyvq
TCwHJjVXFIQVTxH0+sk0rZq6pPPIV95/pEeqoZhdu2qOyQ+zLl6zGHO9tQCb6ajwiDw686rqpry1
ZQ1+0A9oG+gvuNb9NoYkpllkqBZr96+9/HmT4mGETOPSYNWocK9+bAe3xkCloll27CSFt9eZ3m9B
sPh5RKajDazGL+B2H8Ist/G1/GO7PGSZbObIGcjcKpYjzCjSDBFWINWq1T4d/TeYGA2jVmjaoltL
YI6sjEXAYEEjna+/pBLh2dSo7vVMgCqpQPsTc3IU+0RYcja8SzgC4k4fCtVrCk3hJ6yFQ4fOnayp
bMD9a1l/1NYH0hjoOCzvPmfwy/xZhr6AQx4Tikupl9pKJKXKgkWvboDraEr8qFTMMyRIR2VXVsyg
kKdfrAb+RhU1WbSelp9l4XDp3jeL3+kF448qXWGRJIaXkU3Dl7NrmBJJ5W05GDXBFHnnmYfZlDT7
zXA/6c/vEJ9DhqyjmzFmtboPQRZnBdKUpgx3mkv/AA6BfeoDfxRdiypYxLCJSr43vKY8I1+Mg8X4
v2VXQrfQTCzeTfmxf0Z4ZMQpVnSnlN7Lqyn1FoB8QUlAJoqKt1zBVCq76WUkiyLq2pPWD/bLlz3G
W182wt1uYWnoxubynsPzBTLfR5TGWw8VNv78okZb/L8I6cTVkj/iBaTMV1nKufKbgOLjfbUAbcyY
0K3HMeWh9PGHabZlnjcZRFDE+l7y0sRxKVIGadMSWOWYgX8gdT6RUTVazq6qmIbozEqdRcXFjrry
iHMweZMmFps4vf6xJZyPEt/WCFHQJL9gG53JOsBp02BuZo9odpUqtIovMlCPRAPFcU76ypZuxYAk
db7CDjCxt0090MK4JsJh1KLIoY8xZ4rbvp938YE4Ef0j+E/hBTio/nF+7+JgTgf6/wDhP4QpU/Mm
1hx/2vwjnSbjzhe/KHRDttBvnPqWJPxJg/S7jzEa8YyQ07/V847EGySOydGc+0q2QhLBRvc29IPY
LirSn8Ry6xwoaK1YiHmWt/pMdsVwtl7yjr6Qq5B0PM3KgDASz8IxJZihlOvyiLiNG8h2q6ZMwb9o
kcnXmyjkd7jx84rzh3iBpL3I7vOLYwqvWYodDCQLYZ/QwDLm0beTcHxBJqqyNmR7lW5nS5Vujrrc
cxr1jbGsMWeh7oLBWC32IYWKv1QkKSN7qpBBAIW66nNE7VElS1O5Bnyl3lm9xNl22sdfC3lZopK5
XQMGBBF1YbOL7jp0I5HwOmojB1uIWjV1yNvKnxPCzTypw+oZsoAE95DlmEo/iNCG2ZSGG5ABXi6e
JcCWoQkKC9rEE27RQb5b/VYG5VvqknkzA1U2AOHIzqJdzkY6swG4yLc5l2YG1jz2vxFjaUrUgt2n
eRxI6qAyKxAtmN7nzjI41XD01WIUy2WwIJdEJBAIursCp12MZHZjFvw6HW0Zp+BTZnfxCqyjfskO
vqBoPQHziTgM2mWcJVPJAsrEzG1c28eQ9fSE3EcaZ73NhEngmpvUORykub+qwOmzMw4gKtM90x4A
9hGXhKqaSJ88ZQDNVCTvmy30ANzpBrFayVNyOqZWyXmM17kne/IAW+PnCtw0/tra47RjfkO6B7z+
EF8JBExROIy9qmp2yZxe5O+l735e+H0PgBmfXJLGkOcu/wDHSN+BcMqUE2puBbME2sBrd+e2uXTT
foJGHcZUXfRfzUuWBl7oUP8AcVdfhfWGgrcG4uD6gg/MQJXhijH/AONK9Vv84VZyxuZ6ahhUoKFp
AevrK84z4oSrmyFlK2WW5OY2BbNYaAbCw5xHqpCuMrdb+UM3GmE09MiTpaLLJcIwUWBBBINuRBG4
5b8oXTDFEDKZ53thnWuCdDbQiPfAskJRqBtmmW/1EfhCt+UM3r6cdJd/i/8AKGTh7FJEiilmbNRN
ZvtEXP519hufQQj8S4vLqq9HlElFl5bkEXIzkkA6273OAjzzZrtbA6nXL/E60tOZsxJY+uyrpvqd
T6C59IfcV4mpKUFWmrmUWEtdW02Fht01tFdzZQYEa68xuPKINHw7mUuSzIu7Cyyxy7zsco94g1YE
mZPZWJWijAAlieBeRKSmNSzzZjG5YknmSdTqfOJeLU82bkBnkykUKA7GyBRYWG23OM4dqknTxIVQ
ksLMYnMATkQtuQQoJHtG+kC+KXzTJYUKQVuOz7ZlJvyaYB2m3tKoXWB3QC28OFxLMamay9N51nrI
p8hbO7EB00IBFyAw6i4Ouu0dpHEMvJmfRrmyrrp8onYzh0qbIkMHmGbLpJMsSwoADqCTnZtTq1rK
OW8A6PhpjrMbL4DU+/YfGJUvwIKumH/9j3+P0kmnx1pswKCstOZY6nwF9LwTxWr7KUzA6kWXzP8A
TWOdLhUmXsoJHNtf6CA3E1eGdZanMQNl1NzysP71i5JVTeK06dOtWVaY0G844CVWekxyAFObXmRt
8dfSDUvGRMnJKli+ZwC7aAC+p9Bc3PSFmow2eFzsuQXAs3ta+A2ghwrgyzZpeb30lLnIbZjsosNN
9fSAhiBpNKrRpOc7m4HHEzierlPOPZMGUCw1B5m23haBuCfr/wCFvwiZxTSjtbr3TlG0CsNmkT5e
tr6HyijE5tZNJVah4Oke6Q6jzEMPEmC51E6W2dD7diCUcGzC+wsbix6WJHdITTjMmXu4JHJdT/KD
8jFnp5jVVORNp55vMQcyRY7+zMG2u4AB5EEezC0B2ce5cmoLA6Xi3JobV9K1tGex6EWb8QR5i3Iw
3cW8M9hdkuZTEkfukkaHw3sf7PWdhastNVynV5QdXdreywGVtvZPI3+yA2wIsGfKWYpBAZWHoQYA
aQK2m8F0nzRhlHn7UEbW+Zglw3jhkOUJ0BsR5c47YRJAnTxyBHzMBsYpSsxmXfMfnFalMFdZnhi1
Zk6WtLZo8QzAMpB+IPgeogXYUTZlzGjdrsBq1LMP1l/cO1tiCQb7FO4Zx/L3WOnyh2k4gLbBlYEM
p1DA7gwlTLUGsdpd9d9420VSHFja9gdNmB2ZeqkW8r2PImtMCnntJyWGWWbDTlmIF+tgAAd7WGwF
jlJUfRCg7Q/RGJ7KYdTTud5czqh8fAggi4H0uDtJnzz9VghGuxJY28RzVtiPEEDUQ3IIgMbULYZg
d7SdVYesxsxGpC/BQPwjINUMjMin+9DaPYKQJn06pCjXiUatIzEbknbck+UOHCuCzpCzp0yWyKZZ
CltCeex15RZuH4JIp/1UtVP2t2Pmx1iJxaLUzeKn8P5wNEsbmbGNB7hvh84n8Lj80T1mN8LQZkyW
mMqIt2Y5QNB776WtcwJ4ZH6Ovizn/qMFZNQyOryyA6G6ki4vtr4WNvWGkv3YtPL1cpxJz7X19of/
APoeZ2Ld9M9u5LFygPQk6W8lgtw7QCgkO1RMRcxBaxsi22tfdjztvp0hSreOq43VZaIdrqjN7sxI
+EAKiVUVLZ6iYxP7xufQbKPdCtmbS09KKuEoAOp/e8L8U45/xCeqJfsJWtzpmPUjlfYDe1zz00aI
bMJXZoq+26oPNja56x04go3lSKpmmDNLnrKl5GF8t3uXCklSwUaE3HSCgrTFuZk1krY9+8Giicpm
ErOmd0MWtdlQXNup6dLnwge1Wsmd2KyuzfMEZpgN0uQDcb2G/K8dcFkS59GZTTWlnt880BHJmoFA
UKQMpIOawYgAm8d6ulmTqtqtn7NzMDqqWJTLYLqRa4Ci+libxW7MbqIYpSpIBVe/p/Q1/WbcYS1E
jNKZGQTjL7RJ5Yt3SQHQIqgnfQm2gN73iFgGc0lVKIa81ZSyw18otMzvvoBoD4mDVdNaYc8wh2UH
LcKAL6mwUALc7kDXnCviOOG6XIUAq3dbyNtdSQfTziGW2rS9Kv3pIw62Hr9BC+BYc1NM7VZnfyka
BSLMLH2gb6QQrKk3MyY5Y7ZmJJPgL628BpECVihnDPKltZi2sywtr4XLb72AgRX086a/Zljm55Rl
VU631OvnytF8wA8IiWSrUbLVewHH9D+ZwxjHC7BEOxBAG5PLbeDdHVzZy3VQttGz8mG9lGvvIiBI
opVIt9C5B71unID8YlYFUsyu5+u5I5aAAfhELfNqYSt3fdXproNifpJbUF/1kxm/dByg+g39SYlU
yS5NzLRVYjV7agbWXkgt0GvMwLrqoMrZTrLtcjkDvby0PpHk+SwuqBiLDKc3ssOpJ1Gt+cWNukAq
vaxa1+Np3xenM2WVHtA3HibRpwdSuq1AYWLIthz7pN/nDrw1wujqDOJJAF1BtbwNtb9RyjnxbhUq
RkMoFb3BBJPK/M6f1ihys3rGu4r0cMSQMv76yuuIz+cH3R8zC59H7SYqXtm0v0hh4jP53+EfMwEw
/wDaJfn+ECqeaNYQlaV/SMuF8OyUIuC509o6e4aQQrKY0DvNp/ztKzFZ0vfsyDqD0tyJ9eRiRR7j
zED5uKPIragrYq0xw6HZhmPx318YtUsgEUw9apUZs5vDWF4iaQ/SKb89TTbdpL+BvfRZgHM6MAAe
RDthtcktFmSn7SkfY7mSb6huYF9CDqCNfGtHX6JeppPztLM0myjrk8D08+XO+hgvhOJfRiaim/O0
023ay/hqDoswDS59oWB5ERvNLD4juvCx8PB6ehirhrfpFR5j5mJXEvD8ySEnEZpU5VZWA2LC5Vuh
GtutvO0WilET5xOobvK3UZj8trbi1jrF0YXSJOopMuYoZGkywQefdEVZcySaK3xL+wnzhV0pTKy8
wT8TBrA8X0sT/SCnGGE9g+VQxlq0xAx8GJAJ62MJsxCrFl8IAyg6GM1EzacywabEQuZWUPLcWdD9
YeHRhyPKJ9HMEspJmPeSwIpag9P8qb0I+BWEeir8w3gvhuIIA0meM0iZbMBup5OnRh8RpEUiUNpn
1Nbqwlm4PJIlAHcFwfR2EexH4cPZ06J2naAF7P8AaGdrH3WjIezzOygaXhdxC5+UB8sm37v4rHY1
tZPP5qSJKn683U/6Rz89PGAfGkl5UlhMnNOZrEsQAPJQNhp8Y4HebfaB/wAQHUj5wRg9WsmllM4Y
qSb5bX1ZtReCNHWJNL5Se7axKnvXPwIGusKztNaTJTL3Sq5bbsTr+MGsEw95RzMwNwQVtffn5iLI
zXAG0xMRQpKrMx8RJt+sKkwu4tjE2WxQBV8faP8AT3QwGB88SZN3IBfck6n3nb0gr3tvaKYUqG1W
/QQHQy6h5qTcrMVZWBfbukHny02EM7U4vMLEt2k0zXB9kuSTfLtpmNr33gbh+MdqGsCxvoFHLxJ0
HviUizm1JVB0HePvOnwMCXKBfeN4ipW8hOUSVMmhRc2CjmdBEU15P6tC/jsv+o/heOj1EuVczB2z
27pmEkqeq8kH3QID1NazaE6dNojvTzpApQQ6jX30+/1k+opZs1CGmBL8lF/O5Ph0AiPT8PS1dToy
g3Nx3iRyzHXKed7xKwxSJevMkxMAggQMLmR+JqUiVQ2HoJzrKoS0J0AHuEDMNqu0dphNgwCpyJsS
T57wTdc2hAI6GF3Ea289FQC0tgNOpIuPw98Q5sby+GQOrKBr1hypp1cd8AgdYgVlQRLFlsrKWGXe
y2NtOoMS8RYWZeZXu23zC9rW53MQ6SX3kVmuDLBAAGgFiR4C9vdENvYS9FQFzHjiSPoomEhbrLyA
EAWzanTyt84NS5ctRLLzMt21v7KqCO94i1x5jwiG03rpAziSiZpUsoGzTGVdNsmts3mw0+6esc3h
GknDKa9TKRp8vWWpw3O7juGvLdmZSeQLE6kd0gX3B2hQx7FjUTL7Ktwo6+J87D3esL1Lh0uSci6l
R3j1Zuo8h8YmFiDqNLXJ/veKUxzGu0sWah7oaARd4j/W/wAI/GA+HftEvzPyMF+JP1v8I/GBGG/t
MvzPyMCfzQ2H/I/2/wAR9pDqPMQqYvVfpdR/zZn+4wz0248xCHxGpWqnMOc2Z/vMWrC6iLdmpmZx
G/A64yjmSxDCzKdmHQxJn07UZNTSDtKd9J0k65fA+G9jy8QYT8IxPKfDmIe8GxC3eSxuLEciOhhE
VDSazbfKaDU9+vTrI7y5ZUTpF5kmYe8Ae9LNufIPoBro2gOykP8Aw9U9hTyWziZTsoBYf4T/AFge
i5r76g6HXdAraFqRjVUYzSmuJ0g6gA76fZ38vEXglguMiQPpNMO0p5lhOkk6g2tryD20DHRgADyI
dDZhcStB1ovdttr9PeONLhsqoWrlTVDo04n4mxB5HxEVVxhwm1IWS+ZWIKNzI10YciPj8BZlPUCQ
FqacmbSTLZlHtJY8uhFyCp1NrHW1xP5QXWY9OyEMrKSCNiCYqwuJpVLZbyl0lOswDa5tDbhWFXsW
18Ih1MgdtKNjqwuD6w5UciyiKKlzrMPtCu2irCdJPyoF6RkQJz2NvL5RkMTODaTnin5QGvank6a2
eb88im/vYeUBsdxGZOo+0mtmdmOwAAAvYAD/AMxxrKGTJsZ89QR9RNT/AD+EBsYx+U8sSpaMssXs
xPP+z1iu17maz1amJKgDQG500/uNtBLCpLNtVlgA9LqAbdOl4yZXL9W7noov7zsPUxDoaJnRTPLF
raoT3R4WGh0tveCagDRQBDK3ImLVyhjc339pFLzWGuWUOp7zf+0fGB03BUmtmZy4Fhc63O+g9kb9
I6Ywk1mATbby84n0tPkQJflqepO8Vy3NjCioaSBkIBPA4/malVlplQZQOkRsQxMS0FrFjsOniYmF
Vc5A25sTvb+flEXHeHxINsxckA5iLe6KVDY2E6iinxVOvzirVVTOe8xJMe/SytgADbrrHKpl2a0c
mFoBN4qhQWEKLj0++48sogxhVfMm2BtfyP4GFG8GMDqirA+7+zFw7dYlXw6ZbhRGLHpbyLoWXNb6
gJ+J2hXwSRecCdQvePpt8YfOIVWdKWoFhmFm23HPxvC5hdNlDE6M3LwG0SLsdYAOKSMo+7/1CRaO
SS1FyqgX3IFo74dTtPmLLl94kkeXU+Q6xN4jw9ZAV5TZlGjMSACRzPQHkPCClwIolF8pI2gp0za7
qhVnG2l9BfqSdBvpDTS4jRrTOs2egnPZiut1K+yoW17KABoNoC8D0zVzMQckqTMuthubC177jfTx
MPzSHqMyGaDL9lii2v8AaUHMddLG214AzXM9DhMM1KjpueJXnDuFTKnPOIyJqAzDckk6Drr6ACOM
2S8pmEw2C2sOnjfnDTxXi6y5iyJQAWULWXa55egt63harsQzWZzoBbx/rFkY3txMfFBM5VdTz/UW
MfN5gP7iwLwz9ol+vyMT8ZqM8wkC2giBhf7TL9fkYG2rR+kLUSPQ/KPFN7S+Y+cBuL8ItNmWue+5
vbmxLW+PwgzS+0vmPnDzg+Hy55q5cxQysUuD/HYjoR1glUXWB7JF2efPk+QyEEQZwTFyhuPUQ2cW
cGNTzFI70pmIDcxobBvHx52hDxChaW3PTnCbC4ytNd0vvvLYwavVwHQi9tR+BgXieGPSOaujXMjX
7aRa4tzsPs/LyuIRcDx9pTgjTr0MWzgmKJOUOp15jpCwZsO1jqvyi7082h3/AGME4diGSW86lOaT
NUrOlc0JFr+DAbNsQLHkRtj6SEmyJkqaTKmjOAdlYNZwb6q1zqNNRrrqeOLYU9LMNXRC4N+1k7gg
72HTw5cukRrSpsvt5S55JIM2Vpmlt8ttLnQgAE6KV0VIcXECtVqYyHb5entBuJJ+dlH98f7obaNe
6IS6yWZcyUL5pbOMjcwM2xv/AOb6HWHKmcBd4ug0mbjzldb9DIVa3fPp8hGRrVXLEgC2nM9IyCfC
IZvWAzg9FT6uWqH6fV9eXxMe8QFXl04yAK5UhQNFuRa1oA4hja6gfDWDOKt3aO/2ZRPvF4WpOzA3
Fps1KbK6EknXn26bRgmMBcnSIjYlKH1x6Xg1w1wsawdtUFlk3OSWuhfqSel+fPwhpqeDaIoyrIRT
Y2bW4NtDe9zDLVjxK0Oxyy5nMU6bD1aUJizUI55QSVB5+OsA+K61ZBMqXMDvzIGgBHn7Xhy1iJXz
HpZs2WJjAyzZMpI10tt1Bidh8idXS882jE0Xt2ylZb36BtA9uhBihqsZdMAitcrtAmE1tiBDZjOM
SZsld2mjuhRy/ea2w+cATw1LZiJE/LMUlTJngKwINiAy90m+ltIM4PwlVggmTbmSzLy+7eKgyHo6
krrfiDaHAA5zOST00t5e+Pa3hxe9YdbWt8fj7oeKXAJylcxQW07za/Iax2l4QswEduhtcEy1LG40
O19R0jjC0qNYyoajCCPZ1Fo74ZhU1lMwL3FNiehi0WwCmUlT2znYhVI8PqgW36wToMFkKhVZJRW0
IY6nzvcnU9YnKd4QIz3S4vEvAcNm1KZGa0hDmdtxcaAAnc+HviEKZ2ndki5muV8bg2/reHLi+pWR
Lk0khbF2uFW9yFI95LEanexgvw/gokZpjAGdMsWP2f3Qel9zzjg1oD8BnqCn03PGvAg2dSLh1IxB
zTnsmfxI2HgBc+Yit+IcQZKdpd/1hA18NSfgPfDL+UrGiZ6yUtaWup/ebX4Ll95jhwxwe1WUn1YI
lL7EvYzfFuiaD73lvB1hDRz4lVTyr9/ObfkowyeZcxrmXTzMuuoZyL3ydBYkFvdqLixq2pSnkM9g
qS00A0Gg0A9bD1jrKItZbWHd02FuWm1trQjflSxQhZdOp9rvv5DRR6m5/hERNSo3dUifu8UJ+JC7
MTdiSSepOp+MBqyqMzTNqL2AjjWo2U5QSBYsQDZRsLnlcxAlzCL25xxJmLRw4AzcztlPPePMLH6T
L/i+Rj2Ubj3xmG/tMv8Ai+Rio3jB8rex+UdqX2l8x84feFqtO3nSyQHaxVTuQC17X3tcEjlcHY3h
DpR3l+8PnDofo2Io3ZsUqKc5TfR1KkgHTXKSLq42uR9pYM+0X7HPjeS+N5d5UoHYzk/7oUeNOETK
JmSwWlG99NU8/Dx98EqvHWmpKlTxaZ2ktle1hNFjuPqt4DRt15hX6YsBdAw1m6y3ny9QUWZpi9B+
JiVhGJPTzLA6ry6iC0qQBWVKgWAY6dNYC45R2csOesDdAV1mfnzVmQyzcHxkTVDKdRuP5xDxHDXl
OauiHe/xpHJwdyB8be7oa9wbF2ltodfnD7h2N5gHU2IhRc1BtPLIqLfff5yK/ZOgnygWlZgZkv60
lhzHoLX5gAHYEG6MKy5gcynYjY/305WgZV05DmsogBNH6+Rurg7kDmD0/HfphYkvKM2n0UsS8vnK
YgXB6rpoY06bX25mVjaf+O+9v29D/ElzJdzGRikxkGmQDK+wvg6rn27OSQD9Z+6vx39AYa3oVm11
LIb2SVU26Lcn3gRaQFtekVPPxEyK+TNtm7PW3UZDfy0JgGXKpnq8T+fTB9T8pdUtAAAAAAAABsAN
gI0qqhUUsxsAIgYdiRqUV5SlUYXvMFj6Lz872iNjvDr1CFTUMpPRQR7r/jETWBFtJTOO1Xb1E2Yu
xckfIfCLK4Kx2mlUiy5riW0sm9wxzC97iwN9rekJ2NcLT6JgWAZCdJig2/i+yfAxph0rNfoO6deZ
HL0MWAmLVxNSnUvac8McTcQ7TlMqcw5XDTQw320Iizlp7m5LN96czfCWv4xWmJ0+TLNltlK2y6Wt
axFrbEH5QW/+5Evs7vTzGncx2n5vzFySB4W06xZGymQoFcE/P7McMYxJKOlmzbBTay919W5Dvm51
18gY4cJyfoOG9tM1YyzOcH7t1X3W9SYqbGuIWqnvOQKguFSXoFB33vcnmfLlYQTxHjNp0ppNnKsA
CCUGlxvZb8oGzXMfpqqD22jjwjxC9c5MxbMqsZhGbKRdcpIDAXHeGp2hlq8XkU0lp7lQigkZQAXP
RNTm5agke6KhlUGSQZrnLf2VGo06g3zese8NYfNxGqUTWZ0SzOzEkKgI7uui3AsAPwicxtaAoVEL
ErqesuSlw9WnfS3F3MtFQH/CW1yB+8WZrnpYdbza+sWTKea3sopY+gvb12hYp8ZNbW9jJP6PI781
x/iNfuIP3b97xydIZayaioWmlQi2JLbC2o36G0RNBSCCREfhPhV5rGrrR3nYuso9Sb5nB89F9/SP
eLeNmMwUlEQ0xyEM0ahSxtZOp11bYfJc41/KE0/NIpiwlbMw9qZ6/VXw5/CNfyYYJOmzxUhVSXLD
WZtTmIt3QCAbXOpNvOOvFlFjlT4mW1htGlNISWD3ZaWLHc21Zj4k3Y+JMVhJwyZiNQ9TPZpUtm7q
KpeYVGijKL9n3QNWtrc2hs4lxmkpP2mY9RM5SyRb1VbIB4kExriPE709Cs5payZs7STJGuW+oLXU
XYLrawGoHjHQtTu2FjraBsZqAgNFKp0lSstnLtma7DUsEJu1rHVtPDaK1psGmzZplSw01gSAE2Nj
a+mgHiTaLEwPhOpqgZlS7yke5Nx+ce+pNj7F+pF/CH7CcJkUsvJJRZaDUnmbc2Y6k+JMRl1i1CnU
Ylm0HHtKJx3AnopnZErnCqWC7d4Xt42B3iJhZ/SJZ8/lDJxxWrPrJsxPZIQA9bKBfyNrwrfRe1mK
gNib69LaxXYwJZWzC+muvpHFcTkoQWmLoQSAbnfoIl4vTtLmCqkTNyzJNTX2jqrcip2sdD5wEw3h
uUGXPme5G5sN/DX4wSnU83DSzyvz9KxIdDrk5EH5X8LEbGDEm3iGkzqS0w3+FjcfvHPhnE5NfJWn
cdjUSV7tje4+1LJ9tdrqdRp4NDNQYi2fsZ4CzRsfqzB1Xx8IqifRJNRZ9M7FQcwKm0yS3pqLf3cQ
3YBxMlYBS1gVZ28uYNBMI5rf2JnVdiL2uLgVtabGGxYqeFtGlfkfp1X5/jDHiXBxnUcqokgsxQl0
5nU6r/7fd0hXlX+mVQO4Yi/WzWv6gX9YunhIfoUj7h/3GIIBXWBpKDinHpPnKvoSoDW3Zh7jG2GY
iUa3P5xaXGPDT1M6qMlQTLKNkA1bNLW5HjcX8bmKmn0huTba9/Q29ICy8GNOoPhMcqLEyCHQ2Yf3
r1EEyhdjV0YC1Cj89I+rNHMgc7/3rvX1FXFTYwZpMRZGDy2IYbERRPB7TPqIymN8jHKR1DGZ2RO6
G91PMbdbxkZLeRPAmzaQ521axsCdr2zDe14yGw56zNNKhfb9xLHqjZHPRSfgYqmmXNiUsabHcX0y
229YeauZXTEZnWXIlgElb5nI5i/si49Yratnlat8ptdCp8ja/v29Yk+Wa+IfLilPQEx4xLjYq/Y0
4DEaFr6X8Lat53A84k4PxZMzqk9bMxsNdCeljqpPLe+0JODSNQdiT8LawwYzQZ5QbW/X15eN4iwg
RjqveFuBuI947NQ0k5mGZOzY262BMUZg+LiSGDLmzW1G94tTBcSBw9pk85lCvnv9YLcH1a3vaKYM
om5tp4corHsSEqAXjXh2KLPZlbQOMo19n/yQLwGxbCzLYg6fhESjpnv3YJ1YcMHmzjnHs33FtrLv
EGZop5H8J+EkcMcLrOOefM7JRsDufftG+IcPJKYur3UeyCNXP7vh+9tHSXxDXMLIL2t32RRb1ILR
7Iw6fMYvOmm53tub8szXPMbdYtpbQS7ueW+/v2kTGp7unsrLRV5sLn+pMe4vxJ2chaWjlmXJYXdx
mvOYgZrs3IbWH9InVlBKlqzKL3BNySzEWO5OvSNeHqmXNlrLcKSpDLmGmliNPSxtbQmIsZWjVVF0
Gn397xj4HAo8PE2dOSnE4mZsC5GyZcxsbgXAyn2oTOMOIhVPZQ3ZrsXYszeOui+SgfOJfE2DVU+Y
04v2t9r7gdBYWA8NOULUzCp67yn9x190QY6a4cAA6Thmi2vyV4mHk9lzQFT6MzC3mr2/gMVpS4FP
c+wVGlyeQ5m25trt0i1+BMEk00szJcxnzMA2YAZTsLAbC5tY6+6OAhMOQX0MEyOEjV4jUT5wIlpN
soI9vKBYnqu2nPXobvwVAwW2Zib3bvEW567a9OsRqOqmMZksKBkcqXLbggMDlGvssBrbYx3E9E7q
nO/MDUnz6DzsIkRsKBJcLPFlLV1P6PIUJKNjMmMwAb90AXaw3Omu3WC07FJMhSZ06WhJN8zAa9Bf
U22hbxP8pNLL0kq849QMq+9tfcImVqlStmNpX3E2GtTT2kswYqEuRe2qhufnaBGF/tKfxfKCuPYq
aqc09lCF7d0EkDKAo1O/s39YGYT+0r5N8opzMhgArgbWMcaU95fvD5wOTGXp6uoy2ZGmzMyHY94+
4+MT6Zu8vmPnCbilZ+lT7f5sz/cYvWvYWiOBTMWEa3ojKP0zDzdf8SR06i3Tw9R0joqya2WXlLZv
8SSd1PVPX+xtArBMQKtmltZuY5HwI5iDNdhQn/pFKeyqV1Zdg/iOV/gefWBU6wJtz0+kbqUzz8D0
9/rBUiUBNJmGzuMomHQORymX0Vzb2tAx3sdWs7hitenp5PbfqWuFe1jKOYjK46XvY+NoQKepWtOR
1EqpQnMjaCZoQd9j4fODfDXEzUY7CpBmU17ai7SL7gj68vw3XlcaAp202hsLVC1f8mjEW9DHbDB+
mVRHMSj/ANAhK/KZgspZyuihWmpMz22JUpY266m/Wwhkm070jfSaYidIYd5Lg93Qgow5AbE6WOv2
lGcc1MuoSmmS2up7RfFTZbgjkw6GKkXmo/llLYlQ5GI8T87Q04NhwFiYiYzTm5BGt216/wB2+MM+
HStBFFW5mH2hWYUwBJkpbACMjoJcZDYImBrOlRx0KlzIlSGCtcF5hANrX0UX6cyIS6gZqqZ5EH3j
+UT8Ew90m9pMAVddyL7W9PWINLUgVMw2LEjugW163JNgPGB7AX6zdesatYsOFtGbDJAvbLe5HPx+
ItBnHmtLy39lSbnwBOvSBuESKhhn7kpRe7EFyPK9lB941gPxQste60yZOmMDq50A6hVsgPkvOOJ6
TqFOy2J3+Ug4hjomSUpkJ7NNWC3LTG3ubbKCdB6+WlJIY2yygo/fOvuX+fKN8PplWwA05wwUS65t
Onrb4xyoTpKYjFC+g0kCRgZb9ZMYjfKtlQ2H7uvM7n0grS4TLlAWQKSb6Cxtfmd9hbreJF7XBIGX
QW252I93vjopzAjXy6gHT3GDdyIBcQTof0kfsQvesBZV7ulzYDc89BqfCOVRLDd0m1iNRrbTY9Sb
jTTbSB+P1pUaC2nLU2IvufDSBi1iTpiFUKpm7qBibPpYtmuTcjrENZTlEsqM4z8SbU6i1r2uGGvw
/v8ACHGbhuES0UsJMvug/rGDajnle/OE3Havs1YXGYgCwsRp09whUqTkTJ9Zjmbwvy84A3hNo3gn
sp0vfrLQajksrNRVSTCAT2RcE/wWsb6cwfOBEriJQfZX1G3w1PiYruWLEHoY7Fv3ifKODQ1WipN1
0j1MxwMG2uQBudOW3jpz98NHADl5U5rWDTAR05besVLKUXt2gGtrnbzJ6RdGAU/0eRKlyyrL7Ttr
rfbLy3N/7vFhcy2Fpim+djJM2mkmYzT5SnMQyuVvpYCxNtNiene84lCrlopEpQ1h7MsA+gtpfztE
OpxlZJ7xGXpcZh4W5jy1gfX8aylU9mCT1aygeOupPpEZTHmxdEDzSvqjA6uuqJk/sTL7Ri3f7oA2
A11NgANBygzR/k9VRefUWHMKAB/qb+UaYjxwdkIH3Bc/6m/CI+BTZ9dMsO7LXV5hJY+Qvpc/DeLh
VEymq1H1C/E6QNxBIlS5zpJ/ViwXUn6ovqepuYF4P+0D7rQb4wUCrmhbADKBb7iwEwj9oH3WgLea
SL921+hjbTjvL94fOETiOmIqJzD/ADZnwdhD3R+2v3h843x3hKZU9vNkAMZc1wZY3ILE3XqfDx9I
vV8sH2WPExErqiryp3sfnDpgeMByATlYbGG7gihX/h8hGlkozVomkpJMoaWX6SZgzgA7ZCDobwKp
+DqQSkzF5UoLSla8zkKVDTWQOiy7dzLmYDmMl2uN06lMOLiazUr6rN8WwdKwAk9nPX2Zg5+Bt/Y5
dIHU+IFpgpqy0qeuiTeTjlm5EHkf7Ng4NTSpfaLNlmmOWpULMmCYXlIFtPGgIGtre6JuKcNU9TKa
TPVjLSa5Wzd7uyQQwbx18NdtIvSqOuj7/OLPgwwtx8vb0iLguMTsNdlys8ljdpN/Z6vJvprzXY+B
33x6hkpKpauSxcOLOENxcLcm2+lj3d1121EM0vh+RlVDLeYhSQUl9r3pWdnV2Ex7F1XKnd3GY8rA
KGL4caWpqBKUkByFTNo1jo1yPbC6X531hpUzmyyorvRS1Q3HB+sB17LM7ym4Ja3uhiw5e6PIQCn0
0olpigi+YtrYKwHslRpe+mm97iDdM2UWHKCphm6iZWPqq1rcEyWYyORnGPIjIZmZhKtxOodpjZmZ
tTuSfnBvgUXmTCdbLp4eUZGQt/rnqq4thzbpLSmfqPWK4x5j251+qIyMgpiyeb/bCdJ9f7p/GD0j
2B/D/wB0ZGQalvMirtPZY7q+TfNo7Up7hPgflHsZB+JWn5ov44NV+9C3hn4H5RkZCtTziaVD8n4z
VHLTBmJOnM35eMDWOpjIyBVPPG6e5mRylRkZFYYbQtw8garpwQCDMW4OoOsWTxZPZSgDEAg3AJF/
OMjINR5iWL/Ki5NNpDMPazrrz584Snck3JJOupj2Mjq+4lMB5TPItbhJAKKmsAMzXa3PvNv12Huj
2MiKPmh63kihx2P06o+8P9iwvYP+0D7rR7GQI+aS3lf2MbqT2l+8PnFh8J71H/NPzaMjIM/Ep2P5
2++sSfyoSEFXKIVQWRixAHeIPPrFVYgozWjIyE+Zr8yPROcw1PT0i1uCJrGTqSbdSYyMhXG+SUf8
wSy+EJSsJpZQxUAi4BsRexF9jFW8NzmmSK0zGL2dmGYk2JJJOvMnW8ZGQ5Q2X2iOJ/IPufnBcsfn
iORkzSR1ygEX62Oo6Qw4UO6vkPlGRkGTdpnY7/x6XxkthrGRkZBZlT//2Q==', 1);