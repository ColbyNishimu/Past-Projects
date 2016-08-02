DELIMITER //

DROP PROCEDURE IF EXISTS add_movie;
CREATE PROCEDURE add_movie(IN firstname VARCHAR(25),IN lastname VARCHAR(25), IN genre VARCHAR(25), IN mtitle VARCHAR(25), IN myear VARCHAR(25), IN mdirector VARCHAR(25), OUT message VARCHAR(100)
)
BEGIN
	DECLARE sid INT DEFAULT 0;
	DECLARE gid INT DEFAULT 0;
	DECLARE mid INT DEFAULT 0;
	DECLARE EXIT HANDLER FOR SQLEXCEPTION
	SELECT 'Database error occured. Movie cannot be added' INTO message;
	
	SELECT 'variable declaration success' INTO message;
	
	SELECT id INTO sid
	FROM stars
	WHERE first_name = firstname AND last_name = lastname;
	SELECT id INTO gid
	FROM genres
	WHERE name = genre;
	SELECT id INTO mid
	FROM movies
	WHERE title = mtitle AND year = myear AND director = mdirector;
	
	IF mid = 0 THEN
	INSERT INTO movies (title, year, director) VALUES(mtitle, myear, mdirector);
	SELECT id INTO mid
	FROM movies
	WHERE title = mtitle AND year = myear AND director = mdirector;
	END IF;
	
	IF sid = 0 THEN
	INSERT INTO stars (first_name, last_name) VALUES(firstname, lastname);
	SELECT id INTO sid
	FROM stars
	WHERE first_name = firstname AND last_name = lastname;
	INSERT INTO stars_in_movies (star_id, movie_id) VALUES(sid, mid);
	END IF;
	
	IF gid = 0 THEN
	INSERT INTO genres (name) VALUES(genre);
	SELECT id INTO gid
	FROM genres
	WHERE name = genre;
	INSERT INTO genres_in_movies (genre_id, movie_id) VALUES(gid, mid);
	END IF;
	SELECT 'Movie has successfully been added!' INTO message;
	
	
END//

DELIMITER ;