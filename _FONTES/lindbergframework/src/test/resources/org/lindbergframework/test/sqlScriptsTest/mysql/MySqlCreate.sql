DELIMITER $$$

DROP TABLE IF EXISTS `person` $$$

CREATE
  TABLE person
  (
    id  NUMERIC NOT NULL PRIMARY KEY ,
    nickname        VARCHAR(50),
    profession   VARCHAR(50),
    street         VARCHAR(50),
    addres_num      NUMERIC,
    birth_date date)$$$



DROP PROCEDURE IF EXISTS `findPerson` $$$

Create procedure `findPerson`(pid numeric, out nick varchar(50))
begin
   select nickname into nick from person where id = pid;
end $$$


DROP PROCEDURE IF EXISTS `out3NickPersons` $$$

Create procedure `out3NickPersons`(pid1 numeric,pid2 numeric,pid3 numeric,out nick1 varchar(50), out nick2 varchar(50), out nick3 varchar(50))
begin
   select nickname into nick1 from person where id = pid1;
   select nickname into nick2 from person where id = pid2;
   select nickname into nick3 from person where id = pid3;
end $$$


DROP FUNCTION IF EXISTS `findPersonNickFunc` $$$

Create function `findPersonNickFunc`(pid numeric) returns varchar(50)
begin
   declare nick varchar(50);
   select nickname into nick from person where id = pid;
   return nick;
end $$$

DROP PROCEDURE IF EXISTS `updatePersonNickNameBirthDate` $$$

Create procedure `updatePersonNickNameBirthDate`(pid numeric,pnickname varchar(50), pbirth_date date)
begin
   update person set nickname = pnickname, birth_date = pbirth_date where id = pid;
end $$$

DROP FUNCTION IF EXISTS `updatePersonNickBirthDateFunc` $$$

Create function `updatePersonNickBirthDateFunc`(pid numeric,pnickname varchar(50), pbirth_date date) returns date
begin
   update person set nickname = pnickname, birth_date = pbirth_date where id = pid;
   return pbirth_date;
end $$$

