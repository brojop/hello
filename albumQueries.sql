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
Select COUNT(*) from Musician;

-- 7. Write a (nested) query to list the oldest album(s) in the database.
Select * from Album where year = 
(Select MIN(year) from Album);

-- 8. Write a query to find the total running time (in seconds) of all 
--    tracks on the album *Rain Dogs* by Tom Waits
Select SUM(trackLength) from AlbumSong
where AlbumSong.albumId = 5;

-- Join Queries 
-- ------------

-- 9. Write a query list all albums in the database along with the album's
--    band, but only include the album title, year and band name.
Select a.title, a.year, b.name from Album a join Band b on b.bandId = a.bandId;

-- 10. Write a query that lists all albums and all tracks on the albums 
--     for the band Nirvana.
Select b.bandId, b.name, a.albumId, a.title, a.year, a.number, b.bandId, sa.albumSongId, 
sa.trackNumber, sa.trackLength, sa.albumID, s.songId, sa.songId, 
s.title from Album a join Band b on b.bandId = a.bandId
join AlbumSong sa on sa.albumId = a.albumId join Song s on s.songId = sa.songId
where b.name = 'Nirvana';

-- 11. Write a query that list all bands along with all their albums in 
--     the database *even if they do not have any*.
Select Band.name, Album.title, Album.year
from Album
Inner Join Band on Album.bandId = Band.bandId;

-- Grouped Join Queries 
-- --------------------

-- 12. Write a query list all bands along with a *count* of how many albums
--     they have in the database (as you saw in the previous query, some should
--     have zero).
Select b.name, count(albumId) as numAlbums
from Album
a right join Band b on 
a.bandId = b.bandId group by b.bandId;

-- 13. Write a query that lists all albums in the database along with the
--     number of tracks on them.
Select a.title, COUNT(t.trackLength) as 
numTracks
From Album a left JOIN AlbumSong t ON 
a.albumId = t.albumId GROUP BY a.albumId;

-- 14. Write the same query, but limit it to albums which have 12 or more
--     tracks on them.
Select a.title, COUNT(t.trackLength) as 
numTracks
From Album a JOIN AlbumSong t ON 
a.albumId = t.albumId GROUP BY a.albumId
HAVING COUNT(*) >= 12;


-- 15. Write a query to find all musicians that are not in any bands.
Select * From Musician m left JOIN BandMember b on
m.musicianId = b.musicianId group by m.musicianId
Having isnull(b.bandId);



-- 16. Write a query to find all musicians that are in more than one bands
Select m.firstName, m.lastName , COUNT(b.musicianId) as 
bandNum
From Musician m JOIN BandMember b ON 
m.musicianId = b.musicianId GROUP BY m.musicianId
HAVING COUNT(*) > 1;

;