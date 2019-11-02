SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `product_info`
-- ----------------------------
DROP TABLE IF EXISTS `product_info`;
CREATE TABLE `product_info` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '产品id',
  `product_name` varchar(60) NOT NULL COMMENT '产品名称',
  `date_type` varchar(1) NOT NULL COMMENT '时间类型(0天 1 月 2年)',
  `closed_period` int(4) NOT NULL COMMENT '封闭期',
  `rate` decimal(4,2) NOT NULL COMMENT 'rate',
  `offering_amount` decimal(10,0) NOT NULL COMMENT '总发售金额(元)',
  `sale_type` varchar(1) NOT NULL DEFAULT '0' COMMENT '销售方式 （0 按份数）',
  `amount_per_unit` decimal(6,0) NOT NULL DEFAULT '50' COMMENT '每份金额（50)',
  `sale_state` varchar(1) NOT NULL COMMENT '销售状态（0销售中 1  售罄）',
  `create_date` datetime NOT NULL,
  `provider_name` varchar(50) NOT NULL COMMENT '商家名称',
  `provider_id` int(11) DEFAULT NULL COMMENT '商家id',
  `interest_rule_id` int(11) DEFAULT NULL COMMENT ' 计息规则id',
  `reward_rule_id` int(11) DEFAULT NULL COMMENT '奖励规则id',
  `comments` varchar(60) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

SET FOREIGN_KEY_CHECKS = 1;
