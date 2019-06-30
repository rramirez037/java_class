
/* delete tables if they exist already - ensuring a clean db*/
DROP TABLE IF EXISTS stocks.person_stock CASCADE;
DROP TABLE IF EXISTS stocks.company CASCADE;
DROP TABLE IF EXISTS stocks.person CASCADE;


/* creates a table to store a list of stock companies */
CREATE TABLE stocks.company
(
  symbol VARCHAR(5) PRIMARY KEY NOT NULL,
  company_name VARCHAR(20) NOT NULL
);

/** creates a table to store a list of people */
CREATE TABLE stocks.person
(
  ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(256) NOT NULL,
  last_name VARCHAR(256) NOT NULL,
  birth_date DATETIME NOT NULL
);

/** A list of people and their stock interest */
CREATE TABLE stocks.person_stock
(
  ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  person_id INT NOT NULL,
  company_id VARCHAR(5) NOT NULL,
  FOREIGN KEY (person_id) REFERENCES person (ID),
  FOREIGN KEY (company_id) REFERENCES company (symbol)
);

/** now add some sample data */

INSERT INTO stocks.company (symbol,company_name) VALUES ('AAPL', 'APPLE INC');
INSERT INTO stocks.company (symbol,company_name) VALUES ('GOOG', 'GOOGLE INC');
INSERT INTO stocks.company (symbol,company_name) VALUES ('NKE', 'NIKE INC');
INSERT INTO stocks.company (symbol,company_name) VALUES ('AMZN', 'AMAZON INC');
INSERT INTO stocks.company (symbol,company_name) VALUES ('SBUX', 'STARBUCKS CORP');
INSERT INTO stocks.company (symbol,company_name) VALUES ('WMT', 'WALMART INC');
INSERT INTO stocks.company (symbol,company_name) VALUES ('TMUS', 'T-MOBILE US INC');

INSERT INTO stocks.person (first_name,last_name,birth_date) VALUES ('Drew', 'Hope', '1999/10/10');
INSERT INTO stocks.person (first_name,last_name,birth_date) VALUES ('Lang', 'Heckman', '1959/11/11');
INSERT INTO stocks.person (first_name,last_name,birth_date) VALUES ('Lucy', 'Jones', '2010/1/1');
INSERT INTO stocks.person (first_name,last_name,birth_date) VALUES ('Stew', 'Hammer', '1990/3/28');
INSERT INTO stocks.person (first_name,last_name,birth_date) VALUES ('Dan', 'Lane', '1986/4/18');

INSERT INTO stocks.person_stock (ID, person_id, company_id) VALUES (1, 1, 'GOOG');
INSERT INTO stocks.person_stock (ID, person_id, company_id) VALUES (2, 1, 'AAPL');
INSERT INTO stocks.person_stock (ID, person_id, company_id) VALUES (3, 2, 'AAPL');
INSERT INTO stocks.person_stock (ID, person_id, company_id) VALUES (4, 3, 'AAPL');
INSERT INTO stocks.person_stock (ID, person_id, company_id) VALUES (5, 3, 'NKE');
INSERT INTO stocks.person_stock (ID, person_id, company_id) VALUES (6, 3, 'AMZN');
INSERT INTO stocks.person_stock (ID, person_id, company_id) VALUES (7, 4, 'TMUS');

