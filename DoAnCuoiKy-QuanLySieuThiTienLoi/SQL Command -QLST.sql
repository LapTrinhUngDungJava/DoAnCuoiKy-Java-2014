
/*CSDL do an cuoi ky: Quan Ly chuoi sieu thi tien loi*/
/*
CREATE TABLE user_account(
 ma_user varchar(10) primary key, --Ma nhan vien(ten dang nhap): admin, mod,v.v...
 mat_khau varchar(20),
 ten_user varchar(20),
 email_user varchar(40),
 dia_chi_user varchar(300),
 phone_user varchar(20),
 avatar_user varchar(300), --Duong dan den hinh anh luu tren server.
 cmnd_user varchar(30),
 ngay_sinh date,
 gioi_tinh varchar(1), -- 1:Male ; 0:Femal
 type_login_user varchar(1), -- A: Admin or M: Mod or N: normal user;
 type_live_user varchar(1) -- 1: live; 0: Die
);

Insert into user_account values('ADSOFT01','123abc','Py Skys','universestartheky22@gmail.com',
'Lac Long Quan, Q.11 ,TP.HCM','0929287038','','','1992-05-03','1','A','1');
Insert into user_account values('MOSOFT01','123abc','Lê Hoa`ng Phu´','promax_crazy01@yahoo.com',
'Long An - Viet Nam','0929287038','','','1992-05-03','1','M','1');
Insert into user_account values('NV001','123abc','Duong Tha´i Cuo`ng','abc@yahoo.com',
'Viê?t Nam','','','','1992-01-01','0','N','1');
Insert into user_account values('NV002','123abc','Not only Demo','demo@yahoo.com',
'Viê?t Nam','0929287038,','','','1992-01-01','0','N','1');
Insert into user_account values('NV003','123abc','Die Die','demo@yahoo.com',
'Viê?t Nam','0929287038,','','','1992-01-01','0','N','0');
*/

select * from user_account;
--drop table user_account;