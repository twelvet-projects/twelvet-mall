DROP DATABASE IF EXISTS `twelvet-goods`;

CREATE DATABASE `twelvet-goods` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

USE `twelvet-goods`;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`
(
    `goods_id`       bigint(20)                                               NOT NULL AUTO_INCREMENT,
    `goods_name`     varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL DEFAULT '' COMMENT '商品名称',
    `shop_id`        bigint(20)                                               NULL     DEFAULT NULL COMMENT '店铺id',
    `original_price` decimal(15, 2)                                           NULL     DEFAULT 0.00 COMMENT '原价',
    `price`          decimal(15, 2)                                           NULL     DEFAULT NULL COMMENT '现价',
    `brief`          varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL     DEFAULT '' COMMENT '简要描述,卖点等',
    `content`        text CHARACTER SET utf8 COLLATE utf8_general_ci          NULL COMMENT '详细描述',
    `pic`            varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL     DEFAULT NULL COMMENT '商品主图',
    `imgs`           varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '商品图片，以,分割',
    `status`         int(1)                                                   NULL     DEFAULT 0 COMMENT '1:下架,-1:表示删除,0:表示正常状态',
    `category_id`    bigint(20) UNSIGNED                                      NULL     DEFAULT NULL COMMENT '商品分类',
    `sold_num`       int(11)                                                  NULL     DEFAULT NULL COMMENT '销量',
    `total_stocks`   int(11)                                                  NULL     DEFAULT 0 COMMENT '总库存',
    `created_time`   datetime                                                 NULL     DEFAULT NULL COMMENT '创建时间',
    `updated_time`   datetime                                                 NULL     DEFAULT NULL COMMENT '更新时间',
    `version`        int(11)                                                  NULL     DEFAULT NULL COMMENT '版本 乐观锁',
    PRIMARY KEY (`goods_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '商品表'
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for goods_sku
-- ----------------------------
DROP TABLE IF EXISTS `goods_sku`;
CREATE TABLE `goods_sku`
(
    `sku_id`         bigint(20) UNSIGNED                                     NOT NULL AUTO_INCREMENT COMMENT '单品ID',
    `goods_id`       bigint(20) UNSIGNED                                     NOT NULL COMMENT '商品ID',
    `original_price` decimal(15, 2)                                          NULL     DEFAULT NULL COMMENT '原价',
    `price`          decimal(15, 2)                                          NULL     DEFAULT NULL COMMENT '价格',
    `stocks`         int(11)                                                 NOT NULL COMMENT '商品在付款减库存的状态下，该sku上未付款的订单数量',
    `actual_stocks`  int(11)                                                 NULL     DEFAULT NULL COMMENT '实际库存',
    `pic`            varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT 'sku图片',
    `sku_name`       varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT 'sku名称',
    `goods_name`     varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL     DEFAULT NULL COMMENT '商品名称',
    `is_delete`      tinyint(2)                                              NULL     DEFAULT NULL COMMENT '0 正常 1 已被删除',
    `created_time`   datetime                                                NULL     DEFAULT NULL COMMENT '创建时间',
    `updated_time`   datetime                                                NULL     DEFAULT NULL COMMENT '更新时间',
    `version`        int(11)                                                 NOT NULL DEFAULT 0 COMMENT '版本号',
    PRIMARY KEY (`sku_id`) USING BTREE,
    INDEX `goods_id` (`goods_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '单品SKU表'
  ROW_FORMAT = DYNAMIC;
