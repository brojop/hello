-- Computer Science II
-- Lab 7.0 - Structured Query Language I
-- Queries
--
-- Name(s): Brandon Rojop
--
-- 
--
-- For each question, write an SQL query to get the specified result. You
-- are highly encouraged to use a GUI SQL tool such as MySQL Workbench and
-- keep track of your queries in an SQL script so that lab instructors can
-- verify your work. If you do, write your queries in the script file
-- provided rather than hand-writing your queries here.

-- Simple Queries 
-- --------------

-- 1. List all albums in the database.
Select * from Album;

-- 2. List all albums in the database from newest to oldest.
Select * from Album
Order by year;

-- 3. List all bands in the database that begin with "The".
Select * From Band
Where name like 'The%';

-- 4. List all songs in the database in alphabetic order.
Select * from Song
Order By title;

-- 5. Write a query that gives just the albumId of the album "Nevermind".
Select albumId from Album
where title = 'Nevermind';


-- Simple Aggregate Queries 
-- ------------------------

-- 6. Write a query to determine how many musicians are in the database.
Select COUNT (musicianId) 
From Musician;

-- 7. Write a (nested) query to list the oldest album(s) in the database.

-- 8. Write a query to find the total running time (in seconds) of all 
--    tracks on the album *Rain Dogs* by Tom Waits
Select Sum (trackLength) from albumSong
where title = 'Rain Dogs';

-- Join Queries 
-- ------------

-- 9. Write a query list all albums in the database along with the album's
--    band, but only include the album title, year and band name.

-- 10. Write a query that lists all albums and all tracks on the albums 
--     for the band Nirvana.

-- 11. Write a query that list all bands along with all their albums in 
--     the database *even if they do not have any*.

-- Grouped Join Queries 
-- --------------------

-- 12. Write a query list all bands along with a *count* of how many albums
--     they have in the database (as you saw in the previous query, some should
--     have zero).

-- 13. Write a query that lists all albums in the database along with the
--     number of tracks on them.

-- 14. Write the same query, but limit it to albums which have 12 or more
--     tracks on them.

-- 15. Write a query to find all musicians that are not in any bands.

-- 16. Write a query to find all musicians that are in more than one band.


