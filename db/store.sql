/*
Navicat MySQL Data Transfer

Source Server         : zck
Source Server Version : 50536
Source Host           : localhost:3306
Source Database       : store

Target Server Type    : MYSQL
Target Server Version : 50536
File Encoding         : 65001

Date: 2016-03-08 22:05:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('123', 'c9v013wBEiE=', '0');
INSERT INTO `account` VALUES ('3901130300', 'xlJg0jrRFIx6nDpUFXtKSQ==', '0');
INSERT INTO `account` VALUES ('456', 'kMVvfQL61Ek=', '0');

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `cartid` int(11) NOT NULL AUTO_INCREMENT,
  `productid` int(11) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cartid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES ('6', '6', '1', '123');
INSERT INTO `cart` VALUES ('9', '8', '1', '123');

-- ----------------------------
-- Table structure for categories
-- ----------------------------
DROP TABLE IF EXISTS `categories`;
CREATE TABLE `categories` (
  `categoryid` int(11) NOT NULL,
  `categoryname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`categoryid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of categories
-- ----------------------------

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection` (
  `collectionid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `productid` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`collectionid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collection
-- ----------------------------
INSERT INTO `collection` VALUES ('1', '123', '10', '2015-06-18');
INSERT INTO `collection` VALUES ('2', '123', '11', '2015-06-18');

-- ----------------------------
-- Table structure for keynumber
-- ----------------------------
DROP TABLE IF EXISTS `keynumber`;
CREATE TABLE `keynumber` (
  `keyname` varchar(255) NOT NULL,
  `keynumber` int(11) DEFAULT NULL,
  PRIMARY KEY (`keyname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of keynumber
-- ----------------------------

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `orderid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `productid` int(11) DEFAULT NULL,
  `orderdate` date DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`orderid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '456', '2', '2015-06-16', '1');
INSERT INTO `orders` VALUES ('2', '123', '1', '2015-06-18', '1');
INSERT INTO `orders` VALUES ('3', '123', '12', '2015-06-18', '1');

-- ----------------------------
-- Table structure for products
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `productid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `photo1` varchar(255) DEFAULT NULL,
  `photo2` varchar(255) DEFAULT NULL,
  `releasedate` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`productid`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of products
-- ----------------------------
INSERT INTO `products` VALUES ('1', '123', '专业课！书籍', '0', '书籍类', 'photos/6C25BB40669C4B6BB8CBBA9357FD302E_书籍.jpg', 'photos/B904C3D3DBFD4833B3CF9F3C142D8A91_书籍1.jpg', '2015-06-16 00:00:00', '0');
INSERT INTO `products` VALUES ('2', '123', '接下来分类图，最好有个人全部收了~~心塞', '20', '书籍类', 'photos/D8F96DCB9E264E07AE9C48B35AF56D48_书籍2.jpg', 'photos/24E3C7FE68E1451D821A1F1311CAD1E4_书籍3.jpg', '2015-06-17 00:00:00', '0');
INSERT INTO `products` VALUES ('3', '123', '八成新的黑色保险箱，当时三百多买的，现在90块抱走～但学姐能力有限，无法负责安装哦～有意者回帖', '100', '其他', 'photos/2D9547989D014BE68A85A21778050AC2_保险箱.jpg', 'photos/AE770D56B3C548DE83DCE54281BDE7B8_保险箱1.jpg', '2015-06-17 00:00:00', '0');
INSERT INTO `products` VALUES ('4', '123', '两把椅子，还有一把黑色的，九成新', '50', '其他', 'photos/B9522B97D2F544F08EDAA69977E41AD3_yizi.jpg', 'photos/22A3F418C9D94DC7877993520A48B775_椅子.jpg', '2015-06-17 00:00:00', '0');
INSERT INTO `products` VALUES ('5', '123', '卖车', '150', '交通工具', 'photos/F840D4AC828647E6B8405470F0E95F19_自行车.jpg', 'photos/D1FE0BD2EE0D4E01AE6E9225C5307C27_自行车1.jpg', '2015-06-17 00:00:00', '0');
INSERT INTO `products` VALUES ('6', '456', '全新卜鲁兔限量版公交卡，因为是纪念版从没用过，故20一个不打折，可收藏～', '20', '其他', 'photos/CC64BA26E31A423BA00DCAB6795BBBD3_公交卡.jpg', 'photos/D2F1BF5471074BF9947C441CD9D2D9D4_公交卡1.jpg', '2015-06-16 00:00:00', '0');
INSERT INTO `products` VALUES ('7', '123', '裤子也是全新！～30吧就，这一套一起45拿走吧', '20', '衣服类', 'photos/45844E5A43294FBF958167A0AF0CABCE_衣服.jpg', 'photos/46422629AC064889BA96C7B77E7BF49F_衣服1.jpg', '2015-06-17 00:00:00', '0');
INSERT INTO `products` VALUES ('8', '456', '25吧～搭裙子很好看 学姐因为矮了点这个长度有点尴尬', '30', '衣服类', 'photos/0C651E6D681D403D9FC970EC182B30B7_衣服2.jpg', 'photos/02E254C7703D4B41AE68AD687230E2FA_衣服3.jpg', '2015-06-17 00:00:00', '0');
INSERT INTO `products` VALUES ('9', '456', '机子原装支持拆机检验，没有修过。配件只有盒子充电器数据线没有耳机。送磨砂保护壳。', '1300', '电子产品', 'photos/E867B8B8F3954839B4ACB2AFCC880EF2_手机.jpg', 'photos/8397445A4642419F89ADBDFEFA2131A0_手机1.jpg', '2015-06-17 00:00:00', '0');
INSERT INTO `products` VALUES ('10', '456', '剩余一些电子零件，占空间又搬不走，所以收拾了一下，分了类，有需要的同学可以看一下~买的多会有优惠哟~还有赠品包哟', '5', '书籍类', 'photos/1E754DD8550B437B9C8A759100BFC1F3_电子.jpg', 'photos/E203416E030B4DA9B994995EE8F5696B_电子1.jpg', '2015-06-17 00:00:00', '0');
INSERT INTO `products` VALUES ('11', '456', '去年四月份买的电磁炉+炒锅蒸锅，另外还单独买了一个蒸锅，没用过几次~马上要走了，低价处理了，一整套170带走', '170', '电子产品', 'photos/F230AC028A2E4E93B559223DFE4971FA_电子2.jpg', 'photos/B3D359296AA54A6280B00BB691C32EBA_电子3.jpg', '2015-06-17 00:00:00', '0');
INSERT INTO `products` VALUES ('12', '456', '大四学长出 30KG哑铃 篮球', '56', '运动器械', 'photos/17AA2E1452A744AAA9EFE125A29F7BB5_运动.jpg', 'photos/0552688459AD450ABAB630308C36E6EB_运动1.jpg', '2015-06-17 00:00:00', '0');
INSERT INTO `products` VALUES ('13', '456', '物理院的学弟学妹们，快来免费领书啦。。。电信专业和应物专业的书都有，当然有些书可能会卖出去但不贵。。。', '10', '书籍类', 'photos/C39042AB21BF48178CB84F7F82FC4ED9_书籍4.jpg', 'photos/2723917AFA60410B866BF9BD30E01E73_书籍5.jpg', '2015-06-17 00:00:00', '0');
INSERT INTO `products` VALUES ('14', '123', '毕业季甩卖考研书籍（全新），数学1、英语1、政治等，以及信息院专业书籍、数电、模电等，均价2元一本。', '5', '书籍类', 'photos/9EA45F30B13444BF9F34ECF6A821C4DC_书籍6.jpg', 'photos/174230595A074A868C641506EE98DA5E_书籍7.jpg', '2015-06-17 00:00:00', '0');
INSERT INTO `products` VALUES ('15', '123', '小风扇', '20', '电子产品', 'photos/56AEA406E91F4845AFA1EE2FFD5261EC_image.jpg', null, '2015-06-17 00:00:00', '0');
INSERT INTO `products` VALUES ('16', '123', '零食，可口可味的零食', '20', '其他', 'photos/54F4AF361F81442788C0B54B63F5BB6C_IMG_1542.JPG', 'photos/CDBA7A81631B4ABD89B0E6F4B245CE64_IMG_1542.JPG', '2015-06-17 00:00:00', '0');
INSERT INTO `products` VALUES ('17', '123', '一大堆零食便宜卖了', '40', '其他', 'photos/550A1DF09E764C60B5A0805D07D4388E_IMG_1541.JPG', 'photos/262E1D814D1D4AB38676602D8B5679EC_IMG_1543.JPG', '2015-06-17 00:00:00', '0');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `username` varchar(255) NOT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phonenumber` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `regdate` date DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('123', '女', '123@132.com', '18165656562', '长沙市岳麓区', '2015-06-17');
INSERT INTO `userinfo` VALUES ('3901130300', '男', '123456789@qq.com', '12345678911', '长沙市天心区', '2015-06-18');
INSERT INTO `userinfo` VALUES ('456', '女', '100000@123.com', '12345678901', '长沙市岳麓区', '2015-06-16');
