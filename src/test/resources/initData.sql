INSERT INTO actor (id, actor_name) VALUES (1, 'Keanu Reeves'), (2,'Hugo Weaving');
INSERT INTO director (id,director_name) VALUES (1, 'Wachowski bros');
INSERT INTO users (id,nickname) VALUES (1, 'user777');
INSERT INTO movie (id, movie_name, duration)
VALUES (1, 'Matrix', 90), (2,'John Wick', 100);
INSERT INTO genre (id, genre_name) VALUES (1,'action');
INSERT INTO acted_in (movie_id, actor_id) VALUES (1,1), (1,2), (2,1);
INSERT INTO movies_of_genre (genre_id, movie_id) VALUES (1,1), (1,2);