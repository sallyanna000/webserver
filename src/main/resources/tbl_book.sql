SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tbl_book
-- ----------------------------
DROP TABLE IF EXISTS `tbl_book`;
CREATE TABLE `tbl_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `price` float(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_book
-- ----------------------------
INSERT INTO `tbl_book` VALUES ('1', 'hadoop入门实践', 'Jack', '34.50');
INSERT INTO `tbl_book` VALUES ('3', '测试update', 'OK', '65.00');
INSERT INTO `tbl_book` VALUES ('4', '这世界只有一个食堂', '张三', '14.50');
