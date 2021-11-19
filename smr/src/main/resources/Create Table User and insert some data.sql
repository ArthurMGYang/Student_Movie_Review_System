-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
	`school` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '35b9529f89cfb9b848060ca576237e17', '8O+vDNr2sI3N82BI31fu1A==','12312312312', 'evan_nightly@163.com','University of Glasgow');
INSERT INTO `user` VALUES ('2', 'test', '85087738b6c1e1d212683bfafc163853', 'JBba3j5qRykIPJQYTNNH9A==','12312312312', '123@123.com', 'BUPT');
INSERT INTO `user` VALUES ('3', 'editor', '8583a2d965d6159edbf65c82d871fa3e', 'MZTe7Qwf9QgXBXrZzTIqJQ==','13313331333','133@133.com' ,'UoG');