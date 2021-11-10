DROP TABLE IF EXISTS "genreNeo4js", "movieNeo4js", "users", "directors", "actorNeo4js";

CREATE TABLE IF NOT EXISTS actorNeo4js
(
    id BIGINT PRIMARY KEY,
    name_id VARCHAR(50)
    );

CREATE TABLE IF NOT EXISTS directors
(
    id BIGINT PRIMARY KEY,
    name_id VARCHAR(50)
    );

CREATE TABLE IF NOT EXISTS users
(
    id BIGINT PRIMARY KEY,
    nickname VARCHAR(50)
    );

CREATE TABLE IF NOT EXISTS movieNeo4js
(
    id BIGINT PRIMARY KEY,
    name_id VARCHAR(50),
    duration INTEGER,
    actors_id INTEGER REFERENCES actorNeo4js,
    directors_id INTEGER REFERENCES directors,
    users_id INTEGER REFERENCES users
    );

CREATE TABLE IF NOT EXISTS genreNeo4js
(
    id BIGINT PRIMARY KEY,
    name_id VARCHAR(50),
    movies_id INTEGER REFERENCES movieNeo4js
    );


INSERT INTO actorNeo4js (id, name_id) VALUES (1, 'Keanu Reeves'), (2,'Hugo Weaving');
INSERT INTO directors (id,name_id) VALUES (1, 'Wachowski bros');
INSERT INTO users (id,nickname) VALUES (1, 'user777');
INSERT INTO movieNeo4js (id, name_id, duration, actors_id, directors_id, users_id)
VALUES (1, 'Matrix', 90, 1, 1, 1), (2,'John Wick', 100, 1, 1, 1);
INSERT INTO genreNeo4js (id, name_id, movies_id) VALUES (1,'action', 1);