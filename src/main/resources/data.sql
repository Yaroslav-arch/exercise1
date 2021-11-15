INSERT INTO actors (id, name_id) VALUES (1, 'Keanu Reeves'), (2,'Hugo Weaving');
INSERT INTO directors (id,name_id) VALUES (1, 'Wachowski bros');
INSERT INTO users (id,nickname) VALUES (1, 'user777');
INSERT INTO movies (id, name_id, duration)
VALUES (1, 'Matrix', 90), (2,'John Wick', 100);
INSERT INTO genres (id, name_id) VALUES (1,'action');
INSERT INTO acted_in (movie_id, actor_id) VALUES (1,1), (1,2), (2,1);
INSERT INTO movies_of_genre (genre_id, movie_id) VALUES (1,1), (1,2);