INSERT INTO actors (name_id) VALUES ('Keanu Reeves'), ('Hugo Weaving');
INSERT INTO directors (name_id) VALUES ('Wachowski bros');
INSERT INTO users (nickname) VALUES ('user777');
INSERT INTO movies (name_id, duration) VALUES ('Matrix', 90), ('John Wick', 100);
INSERT INTO genres (name_id) VALUES ('action');
INSERT INTO acted_in (movie_id, actor_id) VALUES (1,1), (1,2), (2,1);
INSERT INTO movies_of_genre (genre_id, movie_id) VALUES (1,1), (1,2);