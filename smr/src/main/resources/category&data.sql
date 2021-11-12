DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
	`id` INT(11) NOT NULL,
	`name` VARCHAR(255) NOT NULL,
	PRIMARY KEY(`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO `category` (`id`, `name`) VALUES (1, 'Cartoon');
INSERT INTO `category` (`id`, `name`) VALUES (2, 'Sci-fi movie');
INSERT INTO `category` (`id`, `name`) VALUES (3, 'Documentary');
INSERT INTO `category` (`id`, `name`) VALUES (4, 'Horror');
INSERT INTO `category` (`id`, `name`) VALUES (5, 'Comedy');
INSERT INTO `category` (`id`, `name`) VALUES (6, 'Romance')