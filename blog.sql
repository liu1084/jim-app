/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : blog

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2017-03-26 16:58:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for articles
-- ----------------------------
DROP TABLE IF EXISTS `articles`;
CREATE TABLE `articles` (
  `id` bigint(30) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `title` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '文章标题',
  `content` text COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '文章内容',
  `background` varchar(300) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '根据随机图片和文章内容随机生成的图片',
  `user_id` bigint(30) unsigned NOT NULL DEFAULT '1' COMMENT '用户id,因为写博客的人必须为注册用户,所以每个用户都应该有一个user_id',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '文章的状态,publish(2),draft(3),private(1),delete(0)',
  `password` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '文章的密码,默认为空',
  `sticky` int(10) NOT NULL DEFAULT '0' COMMENT '文章有时候需要置顶',
  `rating` tinyint(1) NOT NULL DEFAULT '0' COMMENT '文章的星级,可以被用户评价',
  `parent` bigint(30) NOT NULL DEFAULT '0' COMMENT '文章的父ID',
  `comment_status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否开放评论,默认为open(1),可以设置为closed(0)',
  `comment_count` int(10) NOT NULL DEFAULT '0' COMMENT '文章的评论数,后台会在特定的时间去刷新',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '文章的创建时间',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of articles
-- ----------------------------
INSERT INTO `articles` VALUES ('1', 'A article title 01', 'Quis incidunt iusto dolorem minima, non odit ipsum ab, ratione veniam eaque natus modi eius. Laudantium saepe enim, deserunt non aspernatur veritatis.', 'storage/15905ddd-fc85-4c1b-a309-8d7b169d1e9e.jpg', '1', '0', '', '0', '0', '0', '0', '0', '2016-06-05 00:00:10', '2016-06-05 00:00:10');
INSERT INTO `articles` VALUES ('2', 'A article title 02', 'Officia accusamus sunt illum cupiditate laboriosam expedita, iste ea, corrupti et ratione sed. Excepturi quibusdam vero aperiam, quia sit voluptas laudantium voluptatibus!', 'storage/15905ddd-fc85-4c1b-a309-8d7b169d1e9e.jpg', '2', '0', '', '1', '0', '0', '0', '0', '2016-06-05 01:01:21', '2016-06-05 01:01:21');
INSERT INTO `articles` VALUES ('3', 'A article title 03', 'Porro, dolorum, reiciendis. Officiis nulla adipisci sed nesciunt error sit sint eaque pariatur, officia reprehenderit eius fugit hic enim beatae obcaecati repudiandae?', 'storage/15905ddd-fc85-4c1b-a309-8d7b169d1e9e.jpg', '3', '0', '', '0', '0', '0', '0', '0', '2016-06-05 02:02:32', '2016-06-05 02:02:32');
INSERT INTO `articles` VALUES ('4', 'A article title 04', 'Temporibus, odit. A facere expedita ab non esse rerum ipsa, ut cumque neque eos et placeat deserunt. Harum mollitia non voluptatibus nisi!', 'storage/15905ddd-fc85-4c1b-a309-8d7b169d1e9e.jpg', '4', '0', '', '0', '0', '0', '0', '0', '2016-06-05 03:03:43', '2016-06-05 03:03:43');
INSERT INTO `articles` VALUES ('5', 'A article title 05', 'Quo, tempore perspiciatis quasi, explicabo molestias libero natus esse possimus, totam placeat molestiae animi similique minus deleniti. Illum odit quod, laboriosam voluptas!', 'storage/15905ddd-fc85-4c1b-a309-8d7b169d1e9e.jpg', '5', '0', '', '10', '0', '0', '0', '0', '2016-06-05 04:04:54', '2016-06-05 04:04:54');
INSERT INTO `articles` VALUES ('6', 'A article title 06', 'Dolorem, eum, harum expedita iste nihil iure vel laboriosam quaerat sed quam est necessitatibus eius, magnam id blanditiis voluptatibus cupiditate, inventore quia!', 'storage/15905ddd-fc85-4c1b-a309-8d7b169d1e9e.jpg', '6', '0', '', '0', '0', '0', '0', '0', '2016-06-05 05:05:01', '2016-06-05 05:05:01');
INSERT INTO `articles` VALUES ('7', 'A article title 07', 'Perspiciatis suscipit temporibus minus laboriosam, obcaecati ducimus eaque consequatur ex, neque distinctio necessitatibus ratione nostrum magni facilis enim doloremque repellendus at cumque?', 'storage/15905ddd-fc85-4c1b-a309-8d7b169d1e9e.jpg', '7', '0', '', '0', '0', '0', '0', '0', '2016-06-05 06:06:02', '2016-06-05 06:06:02');
INSERT INTO `articles` VALUES ('8', 'A article title 08', 'Minus, fugiat, quo. Iure rem doloribus praesentium, error quam adipisci excepturi dolor impedit tempore incidunt veniam quaerat itaque minus aliquid, odio provident?', 'storage/15905ddd-fc85-4c1b-a309-8d7b169d1e9e.jpg', '8', '0', '', '0', '0', '0', '0', '0', '2016-06-05 07:07:03', '2016-06-05 07:07:03');
INSERT INTO `articles` VALUES ('9', 'A article title 09', 'Vel eligendi inventore itaque libero sit, dolor, unde provident ullam blanditiis dignissimos, labore. Enim officiis repudiandae magni corporis incidunt soluta itaque dolorem.', 'storage/15905ddd-fc85-4c1b-a309-8d7b169d1e9e.jpg', '9', '0', '', '0', '0', '0', '0', '0', '2016-06-05 08:08:04', '2016-06-05 08:08:04');
INSERT INTO `articles` VALUES ('10', 'A article title 10', 'Maiores laudantium quas adipisci, perferendis quasi. In dicta quidem suscipit ad perspiciatis, voluptatum rerum, iste laborum dolor quisquam officia, magnam, doloremque dolores.', 'storage/15905ddd-fc85-4c1b-a309-8d7b169d1e9e.jpg', '10', '0', '', '0', '0', '0', '0', '0', '2016-06-05 09:09:19', '2016-06-05 09:09:19');
INSERT INTO `articles` VALUES ('11', 'A article title 11', 'Illo in, eius neque corporis eaque, consequatur quibusdam? Perferendis accusantium quo, suscipit, odio cupiditate ex inventore debitis quibusdam assumenda neque ut, fugit?', 'storage/15905ddd-fc85-4c1b-a309-8d7b169d1e9e.jpg', '11', '0', '', '0', '0', '0', '0', '0', '2016-06-05 10:10:10', '2016-06-05 10:10:10');
INSERT INTO `articles` VALUES ('12', 'A article title 12', 'Eveniet reprehenderit consectetur sed sequi voluptatibus, nemo hic. Hic impedit unde nesciunt quis eos obcaecati, aperiam, nam possimus quos necessitatibus voluptates ipsam.', 'storage/15905ddd-fc85-4c1b-a309-8d7b169d1e9e.jpg', '12', '0', '', '0', '0', '0', '0', '0', '2016-06-05 11:11:11', '2016-06-05 11:11:11');
INSERT INTO `articles` VALUES ('13', 'A article title 13', 'Ipsam est ipsum, totam nesciunt velit officiis tenetur sit qui, ut. Non cum nisi, saepe maxime molestiae architecto vel ducimus tenetur necessitatibus.', 'storage/15905ddd-fc85-4c1b-a309-8d7b169d1e9e.jpg', '13', '0', '', '0', '0', '0', '0', '0', '2016-06-05 12:12:12', '2016-06-05 12:12:12');
INSERT INTO `articles` VALUES ('14', 'A article title 14', 'Dolorum, animi, minima! Pariatur, repudiandae consequatur vitae reiciendis ipsa, odit nesciunt rem, nobis blanditiis minima cumque magni aperiam! Praesentium dolores, enim perferendis.', 'storage/15905ddd-fc85-4c1b-a309-8d7b169d1e9e.jpg', '14', '0', '', '0', '0', '0', '0', '0', '2016-06-05 13:13:13', '2016-06-05 13:13:13');
INSERT INTO `articles` VALUES ('15', 'A article title 15', 'Libero impedit saepe esse aliquam et reprehenderit fugiat nesciunt error optio possimus, quis, officiis, necessitatibus at commodi perspiciatis veritatis autem magnam provident.', 'storage/15905ddd-fc85-4c1b-a309-8d7b169d1e9e.jpg', '15', '0', '', '0', '0', '0', '0', '0', '2016-06-05 14:14:14', '2016-06-05 14:14:14');
INSERT INTO `articles` VALUES ('16', 'A article title 16', 'Incidunt minima corporis, enim, reprehenderit sit magni temporibus quaerat sunt delectus, ut aliquam magnam error. Minus, molestias, quaerat. Ipsa voluptate a explicabo!', 'storage/15905ddd-fc85-4c1b-a309-8d7b169d1e9e.jpg', '16', '0', '', '0', '0', '0', '0', '0', '2016-06-05 15:15:15', '2016-06-05 15:15:15');
INSERT INTO `articles` VALUES ('17', 'A article title 17', 'Earum consequatur ut recusandae maiores, placeat magni beatae perferendis repudiandae ullam reprehenderit, perspiciatis illum, sit cupiditate modi quisquam, id! Facere, a, inventore!', 'storage/15905ddd-fc85-4c1b-a309-8d7b169d1e9e.jpg', '17', '0', '', '0', '0', '0', '0', '0', '2016-06-05 16:16:16', '2016-06-05 16:16:16');
INSERT INTO `articles` VALUES ('18', 'A article title 18', 'Vitae omnis modi delectus odit incidunt voluptatum accusantium voluptatibus, dolor deserunt sapiente magni corporis, recusandae iusto sunt eveniet maxime libero adipisci doloribus!', 'storage/15905ddd-fc85-4c1b-a309-8d7b169d1e9e.jpg', '18', '0', '', '0', '0', '0', '0', '0', '2016-06-05 17:17:17', '2016-06-05 17:17:17');
INSERT INTO `articles` VALUES ('19', 'A article title 19', 'Impedit recusandae veritatis ipsum praesentium, asperiores modi sapiente mollitia fugiat aperiam, quidem, laudantium qui. Iusto minus officiis eum modi non totam voluptates!', 'storage/15905ddd-fc85-4c1b-a309-8d7b169d1e9e.jpg', '19', '0', '', '0', '0', '0', '0', '0', '2016-06-05 18:18:18', '2016-06-05 18:18:18');
INSERT INTO `articles` VALUES ('20', 'A article title 20', 'Molestiae temporibus veniam velit quas voluptatibus odit esse consequuntur exercitationem necessitatibus, optio rerum. Quisquam voluptatum autem eum nam consequatur ex ducimus, iste!', 'storage/15905ddd-fc85-4c1b-a309-8d7b169d1e9e.jpg', '20', '0', '', '0', '0', '0', '0', '0', '2016-06-05 19:19:19', '2016-06-05 19:19:19');
INSERT INTO `articles` VALUES ('21', 'A article title 21', 'Saepe sequi fugiat atque officiis asperiores est esse at laboriosam dignissimos quos, velit corporis quas enim repudiandae illum. Quia tempore soluta consectetur.', 'storage/15905ddd-fc85-4c1b-a309-8d7b169d1e9e.jpg', '21', '0', '', '0', '0', '0', '0', '0', '2016-06-05 20:20:20', '2016-06-05 20:20:20');
INSERT INTO `articles` VALUES ('22', 'A article title 22', 'Est voluptatibus enim animi atque, ea autem illo nihil consequuntur placeat nemo earum assumenda, magnam at. Assumenda libero, commodi earum quis harum.', 'storage/15905ddd-fc85-4c1b-a309-8d7b169d1e9e.jpg', '22', '0', '', '0', '0', '0', '0', '0', '2016-06-05 21:21:21', '2016-06-05 21:21:21');
INSERT INTO `articles` VALUES ('23', 'A article title 23', 'Assumenda vitae labore soluta similique sunt libero quos natus dolorem explicabo distinctio, sit dolor harum perferendis fuga molestiae inventore cumque vero. Soluta!', 'storage/15905ddd-fc85-4c1b-a309-8d7b169d1e9e.jpg', '23', '0', '', '0', '0', '0', '0', '0', '2016-06-05 22:22:22', '2016-06-05 22:22:22');
INSERT INTO `articles` VALUES ('24', 'A article title 24', 'Voluptatum quam, et corrupti delectus soluta voluptatibus minus beatae, obcaecati ad ullam eius repudiandae excepturi neque quos molestiae, modi. Nobis, illo, natus.', 'storage/15905ddd-fc85-4c1b-a309-8d7b169d1e9e.jpg', '24', '0', '', '0', '0', '0', '0', '0', '2016-06-05 23:23:23', '2016-06-05 23:23:23');
INSERT INTO `articles` VALUES ('25', 'A article title 25', 'Vitae, architecto pariatur a excepturi enim perspiciatis, expedita sequi nihil repudiandae nulla consequuntur molestiae natus quo corporis fuga aliquid laborum ipsa repellendus.', 'storage/15905ddd-fc85-4c1b-a309-8d7b169d1e9e.jpg', '25', '0', '', '0', '0', '0', '0', '0', '2016-06-05 00:24:24', '2016-06-05 00:24:24');
INSERT INTO `articles` VALUES ('26', 'A article title 26', 'Quaerat, voluptate quos ea eum illo laborum, omnis quo nesciunt debitis asperiores sint. Sit magnam dolores cumque ut ullam explicabo soluta accusamus.', 'storage/15905ddd-fc85-4c1b-a309-8d7b169d1e9e.jpg', '26', '0', '', '0', '0', '0', '0', '0', '2016-06-05 01:25:25', '2016-06-05 01:25:25');
INSERT INTO `articles` VALUES ('27', 'A article title 27', 'Enim alias cum praesentium a cupiditate soluta laborum recusandae? Dolorem dolorum ipsum similique autem! Molestiae earum sequi, a. Iste ab, nostrum corporis?', 'storage/15905ddd-fc85-4c1b-a309-8d7b169d1e9e.jpg', '27', '0', '', '0', '0', '0', '0', '0', '2016-06-05 02:26:26', '2016-06-05 02:26:26');
INSERT INTO `articles` VALUES ('28', 'test', 'test1', 'storage/15905ddd-fc85-4c1b-a309-8d7b169d1e9e.jpg', '3', '0', '', '0', '0', '0', '0', '0', '2016-10-17 15:41:29', '2016-10-17 15:41:29');
INSERT INTO `articles` VALUES ('29', 'liu1084@163.com', '开发语言搞笑图片', 'storage/15905ddd-fc85-4c1b-a309-8d7b169d1e9e.jpg', '3', '0', '', '0', '0', '0', '0', '0', '2016-10-23 01:17:25', '2016-10-23 01:17:25');
INSERT INTO `articles` VALUES ('30', 'liu1084@163.com', '习近平纪念长征讲话引起强烈反响', 'storage/15905ddd-fc85-4c1b-a309-8d7b169d1e9e.jpg', '3', '0', '', '0', '0', '0', '0', '0', '2016-10-23 02:33:16', '2016-10-23 02:33:16');
INSERT INTO `articles` VALUES ('31', 'liu1084@163.com', '习近平纪念长征讲话引起强烈反响', 'storage/15905ddd-fc85-4c1b-a309-8d7b169d1e9e.jpg', '3', '0', '', '0', '0', '0', '0', '0', '2016-10-23 02:35:13', '2016-10-23 02:35:13');
INSERT INTO `articles` VALUES ('32', 'liu1084@163.com', '习近平纪念长征讲话引起强烈反响', 'storage/15905ddd-fc85-4c1b-a309-8d7b169d1e9e.jpg', '3', '0', '', '0', '0', '0', '0', '0', '2016-10-23 02:38:07', '2016-10-23 02:38:07');
INSERT INTO `articles` VALUES ('33', 'liu1084@163.com', '习近平纪念长征讲话引起强烈反响', 'storage/15905ddd-fc85-4c1b-a309-8d7b169d1e9e.jpg', '3', '0', '', '0', '0', '0', '0', '0', '2016-10-23 02:39:08', '2016-10-23 02:39:08');
INSERT INTO `articles` VALUES ('34', 'liu1084@163.com', '习近平纪念长征讲话引起强烈反响', 'storage/15905ddd-fc85-4c1b-a309-8d7b169d1e9e.jpg', '3', '0', '', '0', '0', '0', '0', '0', '2016-10-23 02:39:25', '2016-10-23 02:39:25');
INSERT INTO `articles` VALUES ('35', 'liu1084@163.com', '习近平纪念长征讲话引起强烈反响', 'storage/15905ddd-fc85-4c1b-a309-8d7b169d1e9e.jpg', '3', '0', '', '0', '0', '0', '0', '0', '2016-10-23 02:39:55', '2016-10-23 02:39:55');
INSERT INTO `articles` VALUES ('36', 'liu1084@163.com', '习近平纪念长征讲话引起强烈反响', 'storage/15905ddd-fc85-4c1b-a309-8d7b169d1e9e.jpg', '3', '0', '', '0', '0', '0', '0', '0', '2016-10-23 02:40:27', '2016-10-23 02:40:27');

-- ----------------------------
-- Table structure for articles_metadata
-- ----------------------------
DROP TABLE IF EXISTS `articles_metadata`;
CREATE TABLE `articles_metadata` (
  `id` bigint(30) unsigned NOT NULL AUTO_INCREMENT,
  `article_id` bigint(30) unsigned NOT NULL DEFAULT '0',
  `key` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `value` text COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_articles_metadata` (`article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of articles_metadata
-- ----------------------------

-- ----------------------------
-- Table structure for comments
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
  `id` bigint(30) unsigned NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(30) unsigned NOT NULL DEFAULT '0',
  `title` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `content` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_id` bigint(30) unsigned NOT NULL DEFAULT '0',
  `status` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'publish',
  `rating` tinyint(1) NOT NULL DEFAULT '0',
  `article_id` bigint(30) unsigned NOT NULL DEFAULT '0',
  `ip_address` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `email` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `create_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of comments
-- ----------------------------
INSERT INTO `comments` VALUES ('1', '0', 'task comment 1', '/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;\r\n/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;\r\n/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;\r\n/*!40101 SET NAMES utf8 */;\r\n/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;\r\n/*!40103 SET TIME_ZONE=\'+00:00\' */;\r\n/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;\r\n/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;\r\n/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE=\'NO_AUTO_VALUE_ON_ZERO\' */;\r\n/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;\r\n\r\n...........', '1', 'publish', '0', '1', '', '', '2016-06-05 00:41:59', '2016-06-05 00:41:59');
INSERT INTO `comments` VALUES ('2', '1', 'task comment 1 - 1', 'fff', '1', 'publish', '0', '1', '', '', '2016-06-18 11:57:59', '2016-06-18 11:57:59');

-- ----------------------------
-- Table structure for comments_metadata
-- ----------------------------
DROP TABLE IF EXISTS `comments_metadata`;
CREATE TABLE `comments_metadata` (
  `id` bigint(30) unsigned NOT NULL AUTO_INCREMENT,
  `commentId` bigint(30) unsigned NOT NULL DEFAULT '1',
  `key` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `value` text COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of comments_metadata
-- ----------------------------

-- ----------------------------
-- Table structure for migrations
-- ----------------------------
DROP TABLE IF EXISTS `migrations`;
CREATE TABLE `migrations` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `migration` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `batch` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of migrations
-- ----------------------------
INSERT INTO `migrations` VALUES ('1', '2016_10_13_135549_create_sessions_table', '1');

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `description` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `status` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'open',
  `create_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES ('1', 'admin', 'admin', '1', '2016-06-05 00:39:41', '2016-06-05 00:39:41');
INSERT INTO `roles` VALUES ('2', 'user', 'my wife', '1', '2016-06-20 02:31:51', '2016-06-20 02:31:51');

-- ----------------------------
-- Table structure for sessions
-- ----------------------------
DROP TABLE IF EXISTS `sessions`;
CREATE TABLE `sessions` (
  `id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `ip_address` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_agent` text COLLATE utf8_unicode_ci,
  `payload` text COLLATE utf8_unicode_ci NOT NULL,
  `last_activity` int(11) NOT NULL,
  UNIQUE KEY `sessions_id_unique` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of sessions
-- ----------------------------

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` bigint(100) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `email` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `avatar` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'user.png',
  `nickname` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `url` varchar(300) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `remember_token` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `activation_key` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `status` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'open',
  `online_status` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'online',
  `feeling` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'liujun', '111', '', 'user.png', 'Jim', '', '', '', '1', 'online', '', '2016-06-05 10:42:38', '2016-06-05 10:42:38');
INSERT INTO `users` VALUES ('2', 'liqing', '222', '', 'user.png', 'Sunny', '', '', '', '1', 'online', '', '2016-06-05 00:42:38', '2016-06-05 00:42:38');
INSERT INTO `users` VALUES ('3', 'liujun', '$2y$10$OxQzfUmOivSzaQ.rAuaP8uLMDYVhnbDmo1Q0EGXz7CpqX5Mj42AUm', 'liu1084@163.com', 'user.png', 'Jim', '', 'gwBZTX1bhi90b9FAOhgY6bAgJ4Y1wLvj005W9IbayxS8ztSks3BsR25PArcm', 'mqauP2xiV8MRv8bRA6ENn9KryGngeXZto694CtdaH32jU2I9GjdFYJP7Efhh', '1', 'online', '', '2016-09-18 10:42:14', '2016-10-23 00:46:31');

-- ----------------------------
-- Table structure for users_metadata
-- ----------------------------
DROP TABLE IF EXISTS `users_metadata`;
CREATE TABLE `users_metadata` (
  `id` bigint(30) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(30) unsigned NOT NULL DEFAULT '1',
  `key` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `value` text COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of users_metadata
-- ----------------------------

-- ----------------------------
-- Table structure for user_meta
-- ----------------------------
DROP TABLE IF EXISTS `user_meta`;
CREATE TABLE `user_meta` (
  `id` bigint(30) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(30) NOT NULL DEFAULT '0',
  `key` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `value` varchar(300) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of user_meta
-- ----------------------------

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(30) unsigned NOT NULL,
  `role_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1');
INSERT INTO `user_role` VALUES ('2', '1', '2');
