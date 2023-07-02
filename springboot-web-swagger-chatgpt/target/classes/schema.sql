--1 Category and (M) Book 
DROP TABLE IF EXISTS BOOK_CATEGORY;
DROP TABLE IF EXISTS BOOKNEW;
  
CREATE TABLE BOOK_CATEGORY(
   ID INT  AUTO_INCREMENT  PRIMARY KEY,
   NAME VARCHAR(250) NOT NULL
  
);

CREATE TABLE BOOK_NEW(
   ID INT  AUTO_INCREMENT  PRIMARY KEY,
   NAME VARCHAR(250) NOT NULL,
   BOOK_CATEGORY_ID INT 
);

--1 NOTE & (M)  REMINDER
--1 USER & (M) NOTE
DROP TABLE IF EXISTS NOTE;
DROP TABLE IF EXISTS REMINDER;
DROP TABLE IF EXISTS CATEGORY;
DROP TABLE IF EXISTS USER;
-- <1 for REMINDER> and <M for USER)
CREATE TABLE NOTE(
   ID INT  AUTO_INCREMENT  PRIMARY KEY,
   NOTE_TITLE VARCHAR(250) NOT NULL,
   --USER_NOTE_ID INT
   USER_NOTE_ID VARCHAR(250) NOT NULL 
);
  --(M)
CREATE TABLE REMINDER(
   ID INT  AUTO_INCREMENT  PRIMARY KEY,
   REM_NAME VARCHAR(250) NOT NULL,
   REM_TYPE VARCHAR(250) NOT NULL,
   REM_DESC VARCHAR(250) NOT NULL,
   REM_NOTE_ID INT,
   --USER_REM_ID INT
   USER_REM_ID VARCHAR(250) NOT NULL
   
);
 --(M)
CREATE TABLE CATEGORY(
   ID INT  AUTO_INCREMENT  PRIMARY KEY,
   CAT_NAME VARCHAR(250) NOT NULL,
   --USER_CAT_ID INT
   USER_CAT_ID VARCHAR(250) NOT NULL
   
);
 -- (1)


DROP TABLE IF EXISTS CUSTOMER;
CREATE TABLE CUSTOMER(
   ID INT  AUTO_INCREMENT  PRIMARY KEY,
   NAME VARCHAR(250) NOT NULL ,
   INCOME INT,
   CREDIT_SCORE INT
);


CREATE TABLE employee(
   ID INT  AUTO_INCREMENT  PRIMARY KEY,
   name VARCHAR(250) NOT NULL ,
   email VARCHAR(250) NOT NULL ,
  headline VARCHAR(250) NOT NULL ,
  phone VARCHAR(250) NOT NULL 
);

CREATE TABLE USER(
   ID INT  AUTO_INCREMENT  PRIMARY KEY,
   NAME VARCHAR(250) NOT NULL,
   EMAIL VARCHAR(250) NOT NULL     
);