CREATE TABLE customer (
    id SERIAL PRIMARY KEY,
    email varchar(45) NOT NULL,
    pwd varchar(200) NOT NULL,
    role varchar(45) NOT NULL
);

INSERT INTO customer (email, pwd, role)
VALUES ('johndoe@example.com', '54321', 'admin');
