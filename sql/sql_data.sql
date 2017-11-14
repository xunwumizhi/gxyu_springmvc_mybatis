/*
SQLyog v10.2 
MySQL - 5.1.72-community : Database - mybatis
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Data for the table `items` */

insert  into `items`(`id`,`name`,`price`,`detail`,`pic`,`createtime`) values (1,'鍙板紡鏈�',3000.0,'璇ョ數鑴戣川閲忛潪甯稿ソ锛侊紒锛侊紒',NULL,'2015-02-03 13:22:53'),(2,'绗旇鏈�',6000.0,'绗旇鏈�鑳藉ソ锛岃川閲忓ソ锛侊紒锛侊紒锛�',NULL,'2015-02-09 13:22:57'),(3,'鑳屽寘',200.0,'鍚嶇墝鑳屽寘锛屽閲忓ぇ璐ㄩ噺濂斤紒锛侊紒锛�',NULL,'2015-02-06 13:23:02');

/*Data for the table `orderdetail` */

insert  into `orderdetail`(`id`,`orders_id`,`items_id`,`items_num`) values (1,3,1,1),(2,3,2,3),(3,4,3,4),(4,4,2,3);

/*Data for the table `orders` */

insert  into `orders`(`id`,`user_id`,`number`,`createtime`,`note`) values (3,1,'1000010','2015-02-04 13:22:35',NULL),(4,1,'1000011','2015-02-03 13:22:41',NULL),(5,10,'1000012','2015-02-12 16:13:23',NULL);

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`birthday`,`sex`,`address`) values (1,'鐜嬩簲',NULL,'2',NULL),(10,'寮犱笁','2014-07-10','1','鍖椾含甯�'),(16,'寮犲皬鏄�',NULL,'1','娌冲崡閮戝窞'),(22,'闄堝皬鏄�',NULL,'1','娌冲崡閮戝窞'),(24,'寮犱笁涓�',NULL,'1','娌冲崡閮戝窞'),(25,'闄堝皬鏄�',NULL,'1','娌冲崡閮戝窞'),(26,'鐜嬩簲',NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
