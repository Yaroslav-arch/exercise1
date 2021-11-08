CREATE TABLE IF NOT EXISTS actors
(
    id SERIAL PRIMARY KEY,
    name_id VARCHAR(50)
    );

CREATE TABLE IF NOT EXISTS directors
(
    id SERIAL PRIMARY KEY,
    name_id VARCHAR(50)
    );

CREATE TABLE IF NOT EXISTS users
(
    id SERIAL PRIMARY KEY,
    nickname VARCHAR(50)
    );

CREATE TABLE IF NOT EXISTS movies
(
    id SERIAL PRIMARY KEY,
    name_id VARCHAR(50),
    duration INTEGER,
    actors_id INTEGER REFERENCES actors,
    directors_id INTEGER REFERENCES directors,
    users_id INTEGER REFERENCES users
    );

CREATE TABLE IF NOT EXISTS genres
(
    id SERIAL PRIMARY KEY,
    name_id VARCHAR(50),
    movies_id INTEGER REFERENCES movies
    );


INSERT INTO actors (id, name_id) VALUES (1, 'Keanu Reeves'), (2,'Hugo Weaving');
INSERT INTO directors (id,name_id) VALUES (1, 'Wachowski bros');
INSERT INTO users (id,nickname) VALUES (1, 'user777');
INSERT INTO movies (id, name_id, duration, actors_id, directors_id, users_id)
VALUES (1, 'Matrix', 90, (1, 2), 1, 1), (2,'John Wick', 100, 1, 1, 1);
INSERT INTO genres (id, name_id, movies_id) VALUES (1,'action', (1, 2);