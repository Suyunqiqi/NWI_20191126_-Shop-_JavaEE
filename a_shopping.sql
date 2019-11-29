/*
SQLyog Ultimate v11.11 (32 bit)
MySQL - 5.7.18 : Database - a_shopping
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`a_shopping` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `a_shopping`;

/*Table structure for table `cart` */

DROP TABLE IF EXISTS `cart`;

CREATE TABLE `cart` (
  `cid` int(20) NOT NULL AUTO_INCREMENT,
  `uid` int(20) NOT NULL,
  `createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `cart` */

insert  into `cart`(`cid`,`uid`,`createtime`) values (1,1,'2019-11-28 15:58:49');

/*Table structure for table `cartlist` */

DROP TABLE IF EXISTS `cartlist`;

CREATE TABLE `cartlist` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `cid` int(20) NOT NULL,
  `pid` int(20) NOT NULL,
  `num` int(20) NOT NULL,
  `totalprice` decimal(20,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `cartlist` */

insert  into `cartlist`(`id`,`cid`,`pid`,`num`,`totalprice`) values (1,1,6,1,NULL),(2,1,7,1,NULL);

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cateid` int(11) NOT NULL,
  `name` varchar(45) COLLATE utf8_bin NOT NULL,
  `price` decimal(20,2) NOT NULL,
  `img` varchar(500) COLLATE utf8_bin DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `dicount` decimal(10,2) DEFAULT '1.00',
  `detail` varchar(500) COLLATE utf8_bin DEFAULT NULL,
  `totop` int(11) NOT NULL DEFAULT '0',
  `aa` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `product` */

insert  into `product`(`id`,`cateid`,`name`,`price`,`img`,`quantity`,`dicount`,`detail`,`totop`,`aa`) values (6,0,'手机',3220.00,NULL,521,1.00,NULL,1,NULL),(7,0,'平板',8750.00,NULL,23,1.00,NULL,1,NULL),(8,0,'电脑',6140.50,NULL,68,1.00,NULL,1,NULL);

/*Table structure for table `sq_user` */

DROP TABLE IF EXISTS `sq_user`;

CREATE TABLE `sq_user` (
  `uid` int(10) NOT NULL AUTO_INCREMENT,
  `uacc` varchar(50) NOT NULL,
  `upwd` varchar(50) NOT NULL,
  `uname` varchar(50) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `sq_user` */

insert  into `sq_user`(`uid`,`uacc`,`upwd`,`uname`) values (1,'wdf','235','王得发'),(2,'wwj','982','王忘杰');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
