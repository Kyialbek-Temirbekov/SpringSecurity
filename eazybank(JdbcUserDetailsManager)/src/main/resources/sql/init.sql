CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR NOT NULL,
    password VARCHAR NOT NULL,
    enabled INT NOT NULL
);

CREATE TABLE authorities (
    id SERIAL PRIMARY KEY,
    username VARCHAR NOT NULL,
    authority VARCHAR NOT NULL
);

INSERT INTO users (username, password, enabled) VALUES ('happy', '12345', 1);
INSERT INTO authorities (username, authority) VALUES ('happy', 'write');
