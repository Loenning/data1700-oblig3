drop table if exists tickets;
CREATE TABLE tickets
(
    id        INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    film      VARCHAR(50)  NOT NULL,
    antall    INT          NOT NULL CHECK (antall >= 0),
    fornavn   VARCHAR(50)  NOT NULL,
    etternavn VARCHAR(50)  NOT NULL,
    telefonnr VARCHAR(20)  NOT NULL,
    epost     VARCHAR(100) NOT NULL
);

drop table if exists users;
CREATE TABLE users
(
    userid   INT AUTO_INCREMENT NOT NULL,
    username varchar(255) not null,
    password varchar(255) not null,
    primary key (userid)
);
