CREATE TABLE `movie`(
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`cover` VARCHAR(255) DEFAULT '',
	`title` VARCHAR(255) NOT NULL DEFAULT '',
	`director` VARCHAR(255) DEFAULT '',
	`starring` VARCHAR(255) DEFAULT '',
	`date`  VARCHAR(20) DEFAULT '',
	`public_resource` VARCHAR(255) DEFAULT '',
	`categoryID` INT(11) DEFAULT NULL,
	PRIMARY KEY(`id`),
	KEY `fk_movie_category_on_categoryID` (`categoryID`),
	CONSTRAINT `fk_movie_category_on_categoryID` FOREIGN KEY (`categoryID`) REFERENCES `category` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
)ENGINE=INNODB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8;

INSERT INTO `movie` (`id`, `cover`, `title`, `director`, `starring`, `date`, `public_resource`, `categoryID`) VALUES (1, 'https://i.loli.net/2021/10/21/1RVQGw7hc8WPoKS.jpg', 'Rick and Morty', 'Dan Harmon, Justin Roiland', 'Justin Roiland, Chris Parnell, Spencer Grammer', '2013 - now',NULL, 1);
INSERT INTO `movie` (`id`, `cover`, `title`, `director`, `starring`, `date`, `public_resource`, `categoryID`) VALUES (2, 'https://i.loli.net/2021/10/21/LdZ1Bch9KgDEupf.png', 'Spider-Man: Into the Spider-Verse', 'Bob Persichetti, Peter Ramsey, Rodney Rothman', 'Shameik Moore, Jake Johnson, Hailee Steinfeld', '2018', NULL, 1); 
INSERT INTO `movie` (`id`, `cover`, `title`, `director`, `starring`, `date`, `public_resource`, `categoryID`) VALUES (3, 'https://i.loli.net/2021/10/21/2VwUgAFvlze85XM.jpg', 'Inside Out', 'Pete Docter, Ronnie Del Carmen', 'Amy Poehler, Bill Hader, Lewis Black', '2015', NULL, 1); 
INSERT INTO `movie` (`id`, `cover`, `title`, `director`, `starring`, `date`, `public_resource`, `categoryID`) VALUES (4, 'https://i.loli.net/2021/10/21/5pmudEXysjO7YaQ.jpg', 'Pacific Rim', 'Guillermo del Toro', 'Idris Elba, Charlie Hunnam, Rinko Kikuchi', '2013',  NULL, 2);
INSERT INTO `movie` (`id`, `cover`, `title`, `director`, `starring`, `date`, `public_resource`, `categoryID`) VALUES (5, 'https://i.loli.net/2021/10/21/B7Sh2CFpEdgXGwn.jpg', 'Inception', 'Christopher Nolan', 'Leonardo DiCaprio, Joseph Gordon-Levitt, Elliot Page', '2010',  NULL, 2);
INSERT INTO `movie` (`id`, `cover`, `title`, `director`, `starring`, `date`, `public_resource`, `categoryID`) VALUES (6, 'https://i.loli.net/2021/10/21/1i4tudn3SeMQWUk.jpg', 'Her', 'Spike Jonze', 'Joaquin Phoenix, Amy Adams, Scarlett Johansson(Voice)', '2013', NULL, 2);
INSERT INTO `movie` (`id`, `cover`, `title`, `director`, `starring`, `date`, `public_resource`, `categoryID`) VALUES (7, 'https://i.loli.net/2021/10/21/m6zPvFIjQV9Ma3U.jpg', 'Catwalk: Tales from the Cat Show Circuit', 'Aaron Hancox, Michael McNamara', 'Kim Langille, Seamus, Bobby', '2018', NULL, 3);
INSERT INTO `movie` (`id`, `cover`, `title`, `director`, `starring`, `date`, `public_resource`, `categoryID`) VALUES (8, 'https://i.loli.net/2021/10/21/ZnpHTDMjzryOCk8.jpg', 'The Social Dilemma', 'Jeff Oriowski', 'Tristan Harris, Jeff Seibert, Beiley Richardson', '2020',NULL, 3);
INSERT INTO `movie` (`id`, `cover`, `title`, `director`, `starring`, `date`, `public_resource`, `categoryID`) VALUES (9, 'https://i.loli.net/2021/10/21/vdNjfRgh7iB1kL4.jpg', 'Honeyland', 'Tamara Kotevska, Ljubomir Stefanov', 'Hatidze Muratova, Nazif Muratova, Hussein Sam', '2019',  NULL, 3);
INSERT INTO `movie` (`id`, `cover`, `title`, `director`, `starring`, `date`, `public_resource`, `categoryID`) VALUES (10,'https://i.loli.net/2021/10/21/AoK9fMJkRgZxHeu.jpg', 'The Shining', 'Stanley Kubrick', 'Jack Nicholson, Shelley Duvall, Danny Lloyd', '1980', NULL, 4);
INSERT INTO `movie` (`id`, `cover`, `title`, `director`, `starring`, `date`, `public_resource`, `categoryID`) VALUES (11,'https://i.loli.net/2021/10/21/AeFM849sifojZId.jpg', 'It', 'Andy Muschietti', 'Bill Skarsgård, Jaeden Martell, Finn Wolfhard', '2017', NULL, 4);
INSERT INTO `movie` (`id`, `cover`, `title`, `director`, `starring`, `date`, `public_resource`, `categoryID`) VALUES (12,'https://i.loli.net/2021/10/21/mY9tIkuNJ2hBHqe.jpg', 'Saw', 'James Wan', 'Cary Elwes, Leigh Whannell, Danny Glover', '2004', NULL, 4);
INSERT INTO `movie` (`id`, `cover`, `title`, `director`, `starring`, `date`, `public_resource`, `categoryID`) VALUES (13,'https://i.loli.net/2021/10/21/xeGsfjnwYAy4P59.jpg', 'City Lights', 'Charles Chaplin', 'Charles Chaplin', '1931',  NULL, 5);
INSERT INTO `movie` (`id`, `cover`, `title`, `director`, `starring`, `date`, `public_resource`, `categoryID`) VALUES (14,'https://i.loli.net/2021/10/21/Z5R6qsHvQJErj9k.jpg', 'Monty Python and the Holy Grail','Terry Gilliam, Terry Jones','Graham Chapman, John Cleese, Eric Idle', '1975', NULL, 5);
INSERT INTO `movie` (`id`, `cover`, `title`, `director`, `starring`, `date`, `public_resource`, `categoryID`) VALUES (15,'https://i.loli.net/2021/10/21/tz17PyhwqfpoUlv.jpg', 'Airplane!','Jim Abrahams, David Zucker, Jerry Zucker','Robert Hays, Julie Hagerty, Leslie Nielsen', '1980', NULL, 5);
INSERT INTO `movie` (`id`, `cover`, `title`, `director`, `starring`, `date`, `public_resource`, `categoryID`) VALUES (16,'https://i.loli.net/2021/10/21/gwB8dArQW2tejJ9.jpg', 'Titanic','James Cameron','Leonardo DiCaprio,Kate Winslet, Billy Zane', '1997', NULL, 6);
INSERT INTO `movie` (`id`, `cover`, `title`, `director`, `starring`, `date`, `public_resource`, `categoryID`) VALUES (17,'https://i.loli.net/2021/10/21/oWcPhVnUx1yZ6Xp.jpg', 'Before Sunrise','Richard Linklater', 'Ethan Hawke, Julie Delpy, Andrea Eckert', '1995', NULL, 6);
INSERT INTO `movie` (`id`, `cover`, `title`, `director`, `starring`, `date`, `public_resource`, `categoryID`) VALUES (18,'https://i.loli.net/2021/10/21/Et1g3Uy7pH6ochF.jpg', 'Eternal Sunshine of the Spotless Mind','Michel Gondry', 'Jim Carrey, Kate Winslet, Tom Wilknson', '2004', NULL, 6);