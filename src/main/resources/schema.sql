CREATE TABLE IF NOT EXISTS ADDRESS_BOOK (
    ADDRESS_BOOK_NAME VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS CONTACT_DETAILS (
    ID INTEGER NOT NULL AUTO_INCREMENT,
    FULL_NAME VARCHAR(30) NOT NULL,
    PHONE_NUMBER VARCHAR(13) NOT NULL,
    ADDRESS_BOOK_NAME VARCHAR(30) NOT NULL,
    PRIMARY KEY (ID)
);
