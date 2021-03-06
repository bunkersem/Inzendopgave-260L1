CREATE TABLE IF NOT EXISTS users (
  id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(200) NOT NULL,
  pwd VARCHAR(200) NOT NULL,
  email VARCHAR(200) NOT NULL
);

CREATE TABLE IF NOT EXISTS travels(
  id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  htmlContent TEXT NOT NULL,
  imageUrl TEXT NOT NULL,
  hotelId INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS hotels(
  id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(200) NOT NULL
);

CREATE TABLE IF NOT EXISTS brochures (
  id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  type VARCHAR(200) NOT NULL,
  destination VARCHAR(200) NOT NULL,
  contactName VARCHAR(200) NOT NULL,
  contactAdress VARCHAR(200) NOT NULL,
  contactPostalCode VARCHAR(200) NOT NULL,
  contactPlaceofResidence VARCHAR(200) NOT NULL,
  contactPhone VARCHAR(200) NOT NULL,
  contactMobilePhone VARCHAR(200) NOT NULL,
  email VARCHAR(200) NOT NULL,
  remarks VARCHAR(800) NOT NULL,
  contactCanCallback BOOL NOT NULL
);

CREATE TABLE IF NOT EXISTS reservations (
  id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  userId INTEGER NOT NULL,
  travelId INTEGER NOT NULL
)