CREATE
  TABLE person
  (
    id  NUMBER NOT NULL PRIMARY KEY ,
    nickname        VARCHAR2(50),
    profession   VARCHAR2(50),
    street         VARCHAR2(50),
    addres_num      number,
    birth_date date);
    
Create or replace procedure listPersonsLikeNickname(pnick in varchar, persons out sys_refcursor) as
begin
   open persons for
   select p.*,street addres$$street, addres_num addres$$number from person p where nickname like pnick || '%';
end listPersonsLikeNickname;

Create or replace procedure out3Persons(person out sys_refcursor, person2 out sys_refcursor, person3 out sys_refcursor) as
begin
   open person for
   select p.*,street addres$$street, addres_num addres$$number from person p where id = 1;
   
   open person2 for
   select p.*,street addres$$street, addres_num addres$$number from person p where id = 2;
   
   open person3 for
   select p.*,street addres$$street, addres_num addres$$number from person p where id = 3;
end out3Persons;

Create or replace function listPersonsLikeNicknameFunc(pnick in varchar, str out varchar) return sys_refcursor is
  persons sys_refcursor;
begin 
   str := 'test';
   open persons for
   select p.*,street addres$$street, addres_num addres$$number from person p where nickname like pnick || '%';
   
   return persons;
end listPersonsLikeNicknameFunc;

Create or replace procedure updatePersonNickNameBirthDate(pid in number, pnickname in varchar, pbirth_date in date) as
begin
   update person set nickname = pnickname, birth_date = pbirth_date where id = pid;
end updatePersonNickNameBirthDate;

Create or replace function updatePersonNickBirthDateFunc(pid in number, pnickname in varchar, pbirth_date in date) return date is
begin 
   update person set nickname = pnickname, birth_date = pbirth_date where id = pid;
   
   return pbirth_date;
end updatePersonNickBirthDateFunc;

Create or replace procedure simpleProcedure as
 n number;
begin
   n:= 0;
end simpleProcedure;
