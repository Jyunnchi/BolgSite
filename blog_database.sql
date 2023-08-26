/*
 Navicat MySQL Data Transfer

 Source Server         : BolgDatabase
 Source Server Type    : MySQL
 Source Server Version : 80032 (8.0.32)
 Source Host           : localhost:3306
 Source Schema         : blog_database

 Target Server Type    : MySQL
 Target Server Version : 80032 (8.0.32)
 File Encoding         : 65001

 Date: 26/08/2023 14:02:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for articles
-- ----------------------------
DROP TABLE IF EXISTS `articles`;
CREATE TABLE `articles`  (
  `aid` int NOT NULL AUTO_INCREMENT COMMENT '文章id',
  `uid` int NULL DEFAULT NULL COMMENT '用户id',
  `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文章标题',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '文章内容',
  `publish_time` datetime NULL DEFAULT NULL COMMENT '发表时间',
  `likes` int NULL DEFAULT 0,
  `favorites` int NULL DEFAULT 0,
  `comments` int NULL DEFAULT NULL COMMENT '评论数',
  PRIMARY KEY (`aid`) USING BTREE,
  INDEX `fk_uid`(`uid` ASC) USING BTREE,
  CONSTRAINT `fk_uid` FOREIGN KEY (`uid`) REFERENCES `users` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of articles
-- ----------------------------
INSERT INTO `articles` VALUES (2, 15, '初めての文章を発表する！', '初めまして！今回のテーマはこちら～チャンチャン！\nJyunnchiの初めてのウェブサイトで発表したブログだ！\nぜひぜひ応援してください！', '2023-08-16 03:02:03', 1, 1, NULL);
INSERT INTO `articles` VALUES (9, 24, 'ブログの始め方をプロが丁寧に解説！|初心者でも稼げるようになろう！', 'はじめまして。ブログを書いて生計を立てているヒトデといいます！このページでは収益100万円以上を継続し続け2016年の9月にブログ収益月100万円を突破して以来、今この記事を書いている2023年4月現在まで、6年以上ブログ収益100万円以上を継続し続け、最高収益は月2500万円。累計ブログ収益は5億円を突破して29歳でFIREを達成しました現在の発行部数は5.8万部とブログノウハウ本で最も売れています！そして、2021年8月、当サイトhitodeblogはなんと翔泳社さんから書籍化。重版を重ねてベストセラー1位。現在の発行部数は5.8万部とブログノウハウ本で最も売れていますブログの始め方をプロが丁寧に解説！|初心者でも稼げるようになろう！はじめまして。ブログを書いて生計を立てているヒトデといいます！このページでは「ブログの始め方」を何処よりもわかりやすく、丁寧に、初心者の方でも全く問題ないように解説しますすぐに本題に入りたい方は下記ボタンから、気になる項目をクリック（タップ）してください2016年の9月にブログ収益月100万円を突破して以来、今この記事を書いている2023年4月現在まで、6年以上ブログ収益100万円以上を継続し続け、最高収益は月2500万円。累計ブログ収益は5億円を突破して29歳でFIREを達成しました', '2023-08-17 10:08:03', 3, 6, NULL);
INSERT INTO `articles` VALUES (10, 28, '舔狗日记', '8月19日 晴 文静不当舔狗\n今天中午吃了饺子，你猜是什么馅？\n对啦！为你沦陷！QwQ', '2023-08-19 10:12:53', 3, 4, NULL);
INSERT INTO `articles` VALUES (11, 30, '深入了解 OkHttp 协议：优雅的网络请求框架', '在现代移动应用和网络开发中，网络请求是不可或缺的一部分。为了实现高效、可靠的网络通信，开发人员需要依赖于强大的网络请求库。OkHttp 是一个广泛应用于 Android 和 Java 开发领域的开源网络请求框架，它以其简洁、易用和高性能的特点而闻名。本文将深入探讨 OkHttp 协议的工作原理、核心功能和优势。\nOkHttp 是一个基于 HTTP/1.1 和 HTTP/2 协议的 Java 库，它构建在 Java 的标准网络\nAPI（java.net）之上，并提供了更高级的抽象和功能。OkHttp 的设计目标是提供简洁的 API，同时保持高性能和可靠性。网络请求\n                                                                 OkHttp 提供了简洁的 API，使开发人员能够轻松地执行 GET、POST、PUT、DELETE 等常见的 HTTP 请求。它支持同步和异步请求，并提供了丰富的参数配置选项。\n                                                                 \n                                                                 连接池和请求复用\n                                                                 OkHttp 通过连接池管理网络连接，实现了连接的复用，从而提高了性能。它可以自动为多个请求共享同一个连接，减少了连接的建立和关闭次数。\n                                                                 \n                                                                 响应缓存\n                                                                 OkHttp 提供了内置的响应缓存功能，可以自动缓存服务器的响应结果，并在下次相同请求发生时返回缓存的响应，减少了对服务器的重复请求，提升了用户体验和网络效率。\n                                                                 \n                                                                 拦截器\n                                                                 OkHttp 的拦截器机制允许开发人员在请求和响应的处理过程中进行自定义操作，如添加请求头、修改请求参数、记录日志等。这种灵活性使开发人员能够轻松地扩展和定制网络请求的行为。\n                                                                 \n                                                                 WebSocket 支持\n                                                                 除了常见的 HTTP 请求，OkHttp 还提供了对 WebSocket 协议的支持，使开发人员能够实现实时通信和推送功能。高性能\n                                                                                                                               OkHttp 采用了异步和非阻塞的设计，能够有效地利用底层网络资源，提供出色的性能和吞吐量。\n                                                                                                                               \n                                                                                                                               简洁易用\n                                                                                                                               OkHttp 的 API 设计简洁明了，易于上手。开发人员可以通过链式调用配置请求参数，并使用回调或协程等方式处理响应结果。\n                                                                                                                               \n                                                                                                                               可定制性\n                                                                                                                               OkHttp 提供了丰富的配置选项和扩展点，使开发人员能够根据实际需求进行灵活定制，满足各种复杂的网络请求场景。\n                                                                                                                               \n                                                                                                                               良好的兼容性\n                                                                                                                               OkHttp 兼容性良好，支持 Android、Java 等多个平台，并与各种主流的网络协议和库无缝集成，如 HTTP/2、WebSocket、Retrofit 等。\n                                                                                                                       \n                                              ', '2023-08-21 02:11:36', 3, 2, NULL);

-- ----------------------------
-- Table structure for comments
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments`  (
  `cid` int NOT NULL AUTO_INCREMENT,
  `aid` int NULL DEFAULT NULL,
  `uid` int NULL DEFAULT NULL,
  `comment_time` datetime NULL DEFAULT NULL,
  `likes` int NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE,
  INDEX `fk_comment_aid`(`aid` ASC) USING BTREE,
  INDEX `fk_comment_uid`(`uid` ASC) USING BTREE,
  CONSTRAINT `fk_comment_aid` FOREIGN KEY (`aid`) REFERENCES `articles` (`aid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_comment_uid` FOREIGN KEY (`uid`) REFERENCES `users` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comments
-- ----------------------------
INSERT INTO `comments` VALUES (1, 11, 24, '2023-08-21 14:14:20', 0, '本当にいいブログだねえ！！！愛してるぞ！！！');
INSERT INTO `comments` VALUES (2, 11, 24, '2023-08-23 13:10:06', 0, 'What a wonderful Blog!!!');
INSERT INTO `comments` VALUES (3, 10, 24, '2023-08-25 01:15:49', 0, '真是一篇好文章！！！');
INSERT INTO `comments` VALUES (4, 10, 24, '2023-08-25 01:15:55', 0, '大力推荐！！！');
INSERT INTO `comments` VALUES (5, 10, 24, '2023-08-25 01:16:00', 0, '本当にいいブログだねえ');
INSERT INTO `comments` VALUES (6, 11, 24, '2023-08-25 10:21:27', 0, '大力推荐！！！');
INSERT INTO `comments` VALUES (7, 9, 24, '2023-08-25 16:02:02', 0, '本当にいいブログだねえ');
INSERT INTO `comments` VALUES (8, 11, 15, '2023-08-25 18:07:18', 0, 'What a wonderful Blog!!!');
INSERT INTO `comments` VALUES (9, 9, 31, '2023-08-25 22:16:12', 0, 'What a wonderful Blog!!!');

-- ----------------------------
-- Table structure for favorites
-- ----------------------------
DROP TABLE IF EXISTS `favorites`;
CREATE TABLE `favorites`  (
  `faid` int NOT NULL AUTO_INCREMENT,
  `aid` int NULL DEFAULT NULL,
  `uid` int NULL DEFAULT NULL,
  `favorite_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`faid`) USING BTREE,
  UNIQUE INDEX `aid`(`aid` ASC, `uid` ASC) USING BTREE,
  INDEX `fk_favorite_uid`(`uid` ASC) USING BTREE,
  CONSTRAINT `fk_favorite_aid` FOREIGN KEY (`aid`) REFERENCES `articles` (`aid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_favorite_uid` FOREIGN KEY (`uid`) REFERENCES `users` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of favorites
-- ----------------------------
INSERT INTO `favorites` VALUES (1, 9, 24, '2023-08-18 11:00:47');
INSERT INTO `favorites` VALUES (3, 7, 24, '2023-08-18 08:43:58');
INSERT INTO `favorites` VALUES (6, 8, 24, '2023-08-18 08:56:45');
INSERT INTO `favorites` VALUES (8, 2, 24, '2023-08-18 09:02:41');
INSERT INTO `favorites` VALUES (9, 6, 24, '2023-08-18 09:36:59');
INSERT INTO `favorites` VALUES (10, 9, 15, '2023-08-18 09:40:21');
INSERT INTO `favorites` VALUES (13, 10, 28, '2023-08-19 10:13:02');
INSERT INTO `favorites` VALUES (14, 10, 29, '2023-08-21 01:24:43');
INSERT INTO `favorites` VALUES (15, 9, 30, '2023-08-21 02:11:11');
INSERT INTO `favorites` VALUES (16, 10, 24, '2023-08-25 10:17:55');
INSERT INTO `favorites` VALUES (17, 11, 24, '2023-08-25 10:20:57');
INSERT INTO `favorites` VALUES (18, 11, 15, '2023-08-25 06:07:31');
INSERT INTO `favorites` VALUES (19, 10, 35, '2023-08-25 10:21:19');
INSERT INTO `favorites` VALUES (20, 9, 35, '2023-08-25 10:26:54');

-- ----------------------------
-- Table structure for follows
-- ----------------------------
DROP TABLE IF EXISTS `follows`;
CREATE TABLE `follows`  (
  `fid` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `followed_id` int NOT NULL COMMENT '被关注的人id',
  `following_id` int NOT NULL COMMENT '关注人id',
  PRIMARY KEY (`fid`) USING BTREE,
  INDEX `fk_followed_id`(`followed_id` ASC) USING BTREE,
  INDEX `fk_following_id`(`following_id` ASC) USING BTREE,
  CONSTRAINT `fk_followed_id` FOREIGN KEY (`followed_id`) REFERENCES `users` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_following_id` FOREIGN KEY (`following_id`) REFERENCES `users` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of follows
-- ----------------------------

-- ----------------------------
-- Table structure for likes
-- ----------------------------
DROP TABLE IF EXISTS `likes`;
CREATE TABLE `likes`  (
  `lid` int NOT NULL AUTO_INCREMENT,
  `aid` int NOT NULL,
  `uid` int NULL DEFAULT NULL,
  `like_time` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`lid`) USING BTREE,
  UNIQUE INDEX `aid`(`aid` ASC, `uid` ASC) USING BTREE,
  INDEX `uid_fk`(`uid` ASC) USING BTREE,
  CONSTRAINT `aid_fk` FOREIGN KEY (`aid`) REFERENCES `articles` (`aid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `uid_fk` FOREIGN KEY (`uid`) REFERENCES `users` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of likes
-- ----------------------------
INSERT INTO `likes` VALUES (1, 11, 24, '2023-08-25 09:38:02');
INSERT INTO `likes` VALUES (4, 10, 24, '2023-08-25 09:51:48');
INSERT INTO `likes` VALUES (6, 9, 24, '2023-08-25 09:56:06');
INSERT INTO `likes` VALUES (7, 10, 35, '2023-08-25 10:21:16');
INSERT INTO `likes` VALUES (8, 9, 35, '2023-08-25 10:26:52');
INSERT INTO `likes` VALUES (9, 2, 35, '2023-08-25 10:27:23');
INSERT INTO `likes` VALUES (10, 11, 15, '2023-08-25 10:36:45');
INSERT INTO `likes` VALUES (11, 10, 15, '2023-08-25 10:36:54');
INSERT INTO `likes` VALUES (12, 9, 15, '2023-08-25 10:37:04');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `uid` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `uname` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `pwd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
  `nickname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '昵称',
  `register_time` datetime NULL DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`uid`) USING BTREE,
  UNIQUE INDEX `uname`(`uname` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (15, 'Kisaragi', 'af948382c8d1883b5740478047f0396f', NULL, '2023-08-15 22:35:06');
INSERT INTO `users` VALUES (24, 'admin', 'af948382c8d1883b5740478047f0396f', NULL, '2023-08-16 22:05:43');
INSERT INTO `users` VALUES (25, 'wxb', 'de8f31d48ae40b3e2585b4c092d84860', NULL, '2023-08-18 12:35:37');
INSERT INTO `users` VALUES (26, '文静不当舔狗', 'd192cec0c217f6192edfd84bfc19fb34', NULL, '2023-08-19 22:09:16');
INSERT INTO `users` VALUES (28, '文静不当舔狗哦！', '13b24800d542955354b1f811bd9276c5', NULL, '2023-08-19 22:10:24');
INSERT INTO `users` VALUES (29, 'Jyunnchi', 'af948382c8d1883b5740478047f0396f', NULL, '2023-08-21 13:24:13');
INSERT INTO `users` VALUES (30, 'LiangYuyue', 'de8f31d48ae40b3e2585b4c092d84860', NULL, '2023-08-21 14:10:47');
INSERT INTO `users` VALUES (31, 'guest', 'de8f31d48ae40b3e2585b4c092d84860', NULL, '2023-08-25 22:14:59');
INSERT INTO `users` VALUES (34, 'newnew', 'de8f31d48ae40b3e2585b4c092d84860', NULL, '2023-08-25 22:19:25');
INSERT INTO `users` VALUES (35, 'DD', 'de8f31d48ae40b3e2585b4c092d84860', NULL, '2023-08-25 22:20:57');

SET FOREIGN_KEY_CHECKS = 1;
