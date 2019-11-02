SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `order_info`
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL COMMENT ' 产品id',
  `start_date` date DEFAULT NULL COMMENT '起息时间',
  `end_date` date DEFAULT NULL COMMENT ' 到期时间(0点)',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `pay_amount` decimal(10,0) NOT NULL COMMENT '支付金额',
  `buy_unit` int(6) NOT NULL COMMENT '购买份数',
  `pay_date` datetime DEFAULT NULL COMMENT '购买时间',
  `buy_type` varchar(1) NOT NULL COMMENT '购买方式（0单独购买、拼团1）',
  `group_id` int(11) DEFAULT NULL COMMENT '拼团id',
  `pay_state` varchar(1) NOT NULL DEFAULT '0' COMMENT '支付状态（支付中0、支付成功1、支付失败2）',
  `order_state` varchar(1) NOT NULL DEFAULT '0' COMMENT ' 订单状态（等待支付0、计息中1、已退出2）',
  `estimated_earnings` decimal(8,2) DEFAULT NULL COMMENT '预计到期收益',
  `reward_income` decimal(8,2) DEFAULT NULL COMMENT '奖励收益',
  `actual_earnings` decimal(8,2) DEFAULT NULL COMMENT '实际退出收益',
  `exit_time` datetime DEFAULT NULL COMMENT '退出时间',
  `comments` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

SET FOREIGN_KEY_CHECKS = 1;
