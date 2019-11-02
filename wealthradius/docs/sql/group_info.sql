
SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `group_info`
-- ----------------------------
DROP TABLE IF EXISTS `group_info`;
CREATE TABLE `group_info` (
  `group_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL COMMENT '产品id',
  `sponsor_user_id` int(11) NOT NULL COMMENT '发起人id',
  `group_state` varchar(1) NOT NULL COMMENT '拼团状态（拼团中0、完成拼团1、拼团失败2）',
  `group_num` int(2) NOT NULL COMMENT '拼团规模（人数)',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `pay_date` datetime DEFAULT NULL COMMENT ' 拼团开始时间（支付成功时间)',
  `comments` varchar(60) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

SET FOREIGN_KEY_CHECKS = 1;
