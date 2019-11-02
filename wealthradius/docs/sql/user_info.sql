SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `mobile_no` varchar(13) DEFAULT NULL COMMENT '手机号',
  `password` varchar(64) DEFAULT NULL,
  `salt` varchar(32) DEFAULT NULL,
  `nick_name` varchar(64) NOT NULL,
  `create_date` datetime NOT NULL,
  `face_sign_info` varchar(128) DEFAULT NULL,
  `face_recognition_date` datetime DEFAULT NULL,
  `invite_code` int(11) DEFAULT NULL,
  `comments` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

SET FOREIGN_KEY_CHECKS = 1;
