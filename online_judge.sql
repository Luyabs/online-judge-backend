/*
 Navicat Premium Data Transfer

 Source Server         : HuaweiECS-abs
 Source Server Type    : MySQL
 Source Server Version : 80032
 Source Host           : 124.70.195.38:3306
 Source Schema         : online_judge

 Target Server Type    : MySQL
 Target Server Version : 80032
 File Encoding         : 65001

 Date: 19/08/2023 12:30:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for edit_record
-- ----------------------------
DROP TABLE IF EXISTS `edit_record`;
CREATE TABLE `edit_record`  (
  `edit_record_id` bigint NOT NULL COMMENT '修改记录id',
  `user_id` bigint NULL DEFAULT NULL COMMENT '修改者id',
  `original_problem_id` bigint NULL DEFAULT NULL COMMENT '原始题目id',
  `change_action` int NOT NULL COMMENT '修改行为',
  `edit_problem_id` bigint NULL DEFAULT NULL COMMENT '修改的临时题目id',
  `is_admin` tinyint(1) NOT NULL COMMENT '是否由管理员修改',
  `status` int NOT NULL COMMENT '修改状态',
  `verify_message` varchar(512) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '审核附加信息',
  `update_time` datetime NULL DEFAULT NULL COMMENT '题目信息更新时间',
  `insert_time` datetime NULL DEFAULT NULL COMMENT '题目新增时间',
  PRIMARY KEY (`edit_record_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `original_problem_id`(`original_problem_id`) USING BTREE,
  INDEX `edit_problem_id`(`edit_problem_id`) USING BTREE,
  CONSTRAINT `edit_record_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE SET NULL ON UPDATE RESTRICT,
  CONSTRAINT `edit_record_ibfk_2` FOREIGN KEY (`original_problem_id`) REFERENCES `problem` (`problem_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `edit_record_ibfk_4` FOREIGN KEY (`edit_problem_id`) REFERENCES `problem` (`problem_id`) ON DELETE SET NULL ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of edit_record
-- ----------------------------
INSERT INTO `edit_record` VALUES (1673358525570592769, 1, 1670833048821948417, 3, 1673358525486706689, 1, 3, '', '2023-06-26 23:52:32', '2023-06-26 23:52:17');
INSERT INTO `edit_record` VALUES (1673358535146188801, 1, 5, 3, 1673358535079079938, 1, 3, '', '2023-06-26 23:52:30', '2023-06-26 23:52:19');
INSERT INTO `edit_record` VALUES (1673358542272311298, 1, 3, 3, 1673358542272311297, 1, 3, '', '2023-06-26 23:52:34', '2023-06-26 23:52:21');
INSERT INTO `edit_record` VALUES (1673358666239160322, 1, 1672588588812017666, 3, 1673358666172051457, 1, 3, '', '2023-06-26 23:53:07', '2023-06-26 23:52:50');
INSERT INTO `edit_record` VALUES (1673358923530350594, 1, 5, 3, 1673358923463241730, 1, 3, '', '2023-06-26 23:54:00', '2023-06-26 23:53:52');
INSERT INTO `edit_record` VALUES (1673359378125795329, 1, 5, 3, 1673359378058686465, 1, 3, '', '2023-06-26 23:55:47', '2023-06-26 23:55:40');
INSERT INTO `edit_record` VALUES (1673359385268695042, 1, 1670833048821948417, 3, 1673359385201586178, 1, 3, '', '2023-06-26 23:56:23', '2023-06-26 23:55:42');
INSERT INTO `edit_record` VALUES (1673359922806501377, 1, 3, 3, 1673359922739392513, 1, 1, NULL, '2023-06-26 23:57:50', '2023-06-26 23:57:50');
INSERT INTO `edit_record` VALUES (1673365260297363458, 1, 1670833048821948417, 3, 1673365260100231169, 1, 1, NULL, '2023-06-27 00:19:02', '2023-06-27 00:19:02');
INSERT INTO `edit_record` VALUES (1673365260616130561, 1, 1670833048821948417, 3, 1673365260519661569, 1, 2, '非常好', '2023-06-28 00:46:34', '2023-06-27 00:19:02');
INSERT INTO `edit_record` VALUES (1673370351502962689, 1, 1672583479537410049, 3, 1673370351247110145, 1, 1, NULL, '2023-06-27 00:39:16', '2023-06-27 00:39:16');
INSERT INTO `edit_record` VALUES (1673370370863869953, 1, 1673370370834509826, 1, NULL, 1, 1, NULL, '2023-06-27 00:39:21', '2023-06-27 00:39:21');
INSERT INTO `edit_record` VALUES (1673370782861963266, 1, 1672588588812017666, 3, 1673370782836797442, 1, 1, NULL, '2023-06-27 00:40:59', '2023-06-27 00:40:59');
INSERT INTO `edit_record` VALUES (1673371013431242754, 1, 1673371013368328193, 1, NULL, 1, 3, 'adsasasadasdas', '2023-06-27 23:49:46', '2023-06-27 00:41:54');
INSERT INTO `edit_record` VALUES (1673371163427942401, 1, 1672648023722848257, 3, 1673371163402776577, 1, 2, '', '2023-08-19 12:22:34', '2023-06-27 00:42:30');
INSERT INTO `edit_record` VALUES (1673371277001306113, 1, 1, 3, 1673371276980334594, 1, 2, '', '2023-06-27 23:59:11', '2023-06-27 00:42:57');
INSERT INTO `edit_record` VALUES (1673371469435973634, 1, 5, 3, 1673371469419196417, 1, 3, '', '2023-06-27 00:46:36', '2023-06-27 00:43:43');
INSERT INTO `edit_record` VALUES (1673371541255041025, 1, 1673342568176074754, 3, 1673371541229875202, 1, 3, '', '2023-06-27 01:05:37', '2023-06-27 00:44:00');
INSERT INTO `edit_record` VALUES (1673371553200418818, 1, 1673195029881004034, 3, 1673371553179447297, 1, 2, '', '2023-06-27 00:46:34', '2023-06-27 00:44:03');
INSERT INTO `edit_record` VALUES (1673371565141602305, 1, 1673356632605700098, 3, 1673371565108047874, 1, 1, NULL, '2023-06-27 00:44:06', '2023-06-27 00:44:06');
INSERT INTO `edit_record` VALUES (1673371624876879874, 1, 1672990219188408321, 3, 1673371624864296961, 1, 3, '', '2023-06-27 00:46:32', '2023-06-27 00:44:20');
INSERT INTO `edit_record` VALUES (1673371637480763394, 1, 1672590413531439105, 3, 1673371637459791873, 1, 3, '', '2023-06-27 00:46:38', '2023-06-27 00:44:23');
INSERT INTO `edit_record` VALUES (1673722716395450369, 1, 1, 3, 1673722716328341506, 1, 2, '1231313', '2023-06-27 23:59:32', '2023-06-27 23:59:27');
INSERT INTO `edit_record` VALUES (1673733883432054786, 1, 5, 3, 1673733883369140225, 1, 2, '好！', '2023-06-28 00:44:10', '2023-06-28 00:43:49');
INSERT INTO `edit_record` VALUES (1673734018950017025, 1, 5, 3, 1673734018882908161, 1, 2, '', '2023-06-28 00:44:28', '2023-06-28 00:44:21');
INSERT INTO `edit_record` VALUES (1673962696984289282, 1, 4, 3, 1673962696854265857, 1, 2, 'ASD', '2023-06-28 15:53:30', '2023-06-28 15:53:02');
INSERT INTO `edit_record` VALUES (1673962779284922370, 1, 5, 3, 1673962779263950849, 1, 2, '', '2023-06-28 15:53:28', '2023-06-28 15:53:22');
INSERT INTO `edit_record` VALUES (1674079374744035330, 1, 1674079374622400513, 1, NULL, 1, 2, NULL, '2023-06-28 23:36:40', '2023-06-28 23:36:40');
INSERT INTO `edit_record` VALUES (1674271631398178817, 1, 4, 3, 1674271631217823746, 1, 2, NULL, '2023-06-29 12:20:38', '2023-06-29 12:20:38');
INSERT INTO `edit_record` VALUES (1674272023930507266, 1, 5, 3, 1674272023867592706, 1, 2, NULL, '2023-06-29 12:22:12', '2023-06-29 12:22:12');
INSERT INTO `edit_record` VALUES (1674272131514404866, 1, 5, 3, 1674272131388575745, 1, 2, NULL, '2023-06-29 12:22:37', '2023-06-29 12:22:37');
INSERT INTO `edit_record` VALUES (1674792772026040321, 1, 1, 3, 1674792771724050433, 1, 2, NULL, '2023-06-30 22:51:28', '2023-06-30 22:51:28');
INSERT INTO `edit_record` VALUES (1675199822266875905, 1, 1675199822233321474, 1, NULL, 1, 2, NULL, '2023-07-02 01:48:56', '2023-07-02 01:48:56');
INSERT INTO `edit_record` VALUES (1684105313323409410, 1, 1, 3, 1684105313113694210, 1, 2, NULL, '2023-07-26 15:36:11', '2023-07-26 15:36:11');
INSERT INTO `edit_record` VALUES (1684106280286588929, 1, 1, 3, 1684106280198508545, 1, 2, NULL, '2023-07-26 15:40:01', '2023-07-26 15:40:01');
INSERT INTO `edit_record` VALUES (1684106470213099522, 1, 1, 3, 1684106470078881794, 1, 2, NULL, '2023-07-26 15:40:46', '2023-07-26 15:40:46');
INSERT INTO `edit_record` VALUES (1684107356373094402, 1, 1, 3, 1684107356167573506, 1, 2, NULL, '2023-07-26 15:44:18', '2023-07-26 15:44:18');
INSERT INTO `edit_record` VALUES (1688944111392010241, 1, 1688944111228432385, 1, NULL, 1, 2, NULL, '2023-08-09 00:03:50', '2023-08-09 00:03:50');
INSERT INTO `edit_record` VALUES (1688944178156941314, 1, 1688944178001752066, 1, NULL, 1, 2, NULL, '2023-08-09 00:04:06', '2023-08-09 00:04:06');
INSERT INTO `edit_record` VALUES (1688944179197128705, 1, 1688944179062910978, 1, NULL, 1, 2, NULL, '2023-08-09 00:04:06', '2023-08-09 00:04:06');
INSERT INTO `edit_record` VALUES (1688944180988096513, 1, 1688944180195373058, 1, NULL, 1, 2, NULL, '2023-08-09 00:04:06', '2023-08-09 00:04:06');
INSERT INTO `edit_record` VALUES (1688945261084291073, 1673589238114926594, 1688945260954267649, 1, NULL, 0, 2, '必须通过！', '2023-08-09 00:11:23', '2023-08-09 00:08:24');
INSERT INTO `edit_record` VALUES (1688948450051371010, 1673589238114926594, 1688948449900376065, 1, NULL, 0, 2, '写的一般', '2023-08-09 00:23:10', '2023-08-09 00:21:04');
INSERT INTO `edit_record` VALUES (1688948462839803905, 1673589238114926594, 1688948462709780481, 1, NULL, 0, 3, '', '2023-08-13 23:38:51', '2023-08-09 00:21:07');
INSERT INTO `edit_record` VALUES (1688948484318834689, 1673589238114926594, 1688948484184616961, 1, NULL, 0, 3, '', '2023-08-13 23:38:43', '2023-08-09 00:21:12');
INSERT INTO `edit_record` VALUES (1688948496448761857, 1673589238114926594, 1688948496318738433, 1, NULL, 0, 1, NULL, '2023-08-09 00:21:15', '2023-08-09 00:21:15');
INSERT INTO `edit_record` VALUES (1688948512034795522, 1673589238114926594, 1688948511862829058, 1, NULL, 0, 1, NULL, '2023-08-09 00:21:19', '2023-08-09 00:21:19');
INSERT INTO `edit_record` VALUES (1688948512953348098, 1673589238114926594, 1688948512823324674, 1, NULL, 0, 2, '', '2023-08-13 23:37:19', '2023-08-09 00:21:19');
INSERT INTO `edit_record` VALUES (1688948527100735489, 1673589238114926594, 1688948526970712066, 1, NULL, 0, 2, '', '2023-08-13 23:41:03', '2023-08-09 00:21:23');
INSERT INTO `edit_record` VALUES (1688948547526995969, 1673589238114926594, 1688948547392778242, 1, NULL, 0, 2, '', '2023-08-13 23:37:27', '2023-08-09 00:21:28');
INSERT INTO `edit_record` VALUES (1691135828940369921, 1, 1691135828684517378, 1, NULL, 1, 2, NULL, '2023-08-15 01:12:56', '2023-08-15 01:12:56');
INSERT INTO `edit_record` VALUES (1691136745819377666, 1, 1691136745550942209, 1, NULL, 1, 2, NULL, '2023-08-15 01:16:35', '2023-08-15 01:16:35');
INSERT INTO `edit_record` VALUES (1691136801175801857, 1, 1691136800982863873, 1, NULL, 1, 2, NULL, '2023-08-15 01:16:48', '2023-08-15 01:16:48');
INSERT INTO `edit_record` VALUES (1691136831278321665, 1, 1691136831081189377, 1, NULL, 1, 2, NULL, '2023-08-15 01:16:55', '2023-08-15 01:16:55');

-- ----------------------------
-- Table structure for problem
-- ----------------------------
DROP TABLE IF EXISTS `problem`;
CREATE TABLE `problem`  (
  `problem_id` bigint NOT NULL COMMENT '题目id',
  `user_id` bigint NULL DEFAULT NULL COMMENT '作者id',
  `title` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '题目标题',
  `content` varchar(512) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '题目内容',
  `type` int NOT NULL COMMENT '题目类型',
  `attempt_num` int NULL DEFAULT 0 COMMENT '总尝试次数',
  `success_num` int NULL DEFAULT 0 COMMENT '总通过次数',
  `difficulty` int NOT NULL COMMENT '难度',
  `runtime_limit` double NULL DEFAULT NULL COMMENT '运行时间限制',
  `memory_limit` double NULL DEFAULT NULL COMMENT '运行内存限制',
  `status` tinyint(1) NULL DEFAULT 0 COMMENT '状态',
  `update_time` datetime NULL DEFAULT NULL COMMENT '题目信息更新时间',
  `insert_time` datetime NULL DEFAULT NULL COMMENT '题目新增时间',
  PRIMARY KEY (`problem_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `problem_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE SET NULL ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of problem
-- ----------------------------
INSERT INTO `problem` VALUES (1, 1, '三数之和a', '输出 a + b + c的值', 2, 14, 6, 3, 512, 256, 1, '2023-08-13 17:47:12', NULL);
INSERT INTO `problem` VALUES (2, 2, 'p2', 'p222', 2, 41, 4, 3, NULL, NULL, 1, '2023-06-26 01:14:16', NULL);
INSERT INTO `problem` VALUES (3, 2, 'p3', 'p333', 2, 41, 8, 3, NULL, NULL, 2, '2023-06-26 23:57:50', NULL);
INSERT INTO `problem` VALUES (4, 1, 'DQL测试题', '请查询 test 表中所有字段与记录', 1, 13, 4, 3, NULL, NULL, 1, '2023-06-29 14:56:52', '2023-06-28 12:10:59');
INSERT INTO `problem` VALUES (5, 1, 'DML测试题', 'test 表有两个字段 [id (integer), name(varchar)], 请从表中删去所有id >= 5, id <= 7的记录', 1, 41, 8, 2, 256, 0, 1, '2023-06-29 12:22:37', NULL);
INSERT INTO `problem` VALUES (1670830942656331778, 1, '两数之和', '给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。你可以按任意顺序返回答案。', 2, 0, 8, 1, 128, 128, 1, '2023-06-20 00:28:34', '2023-06-20 00:28:34');
INSERT INTO `problem` VALUES (1670833048821948417, 1668866635752132610, '两数之和', '给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。你可以按任意顺序返回答案。', 2, 32, 5, 1, 128, 128, 1, '2023-07-01 17:58:40', '2023-06-20 00:36:56');
INSERT INTO `problem` VALUES (1672583479537410049, 1668866635752132610, '最长回文子串', '给你一个字符串 S，找到 S 中最长的回文子串。如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。', 2, 0, 0, 2, 128, 128, 2, '2023-06-27 00:39:16', '2023-06-24 20:32:31');
INSERT INTO `problem` VALUES (1672588588812017666, 1668866635752132610, '最长回文子串', '给你一个字符串 w，找到 w 中最长的回文子串。如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。', 2, 0, 0, 1, 128, 128, 2, '2023-06-27 00:40:59', '2023-06-24 20:52:49');
INSERT INTO `problem` VALUES (1672590413531439105, 1668866635752132610, '最长回文子串', '给你一个字符串 d，找到 d 中最长的回文子串。如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。', 2, 0, 0, 2, 128, 128, 3, '2023-06-27 00:46:38', '2023-06-24 21:00:04');
INSERT INTO `problem` VALUES (1672648023722848257, 1668866635752132610, '最长回文子串P123', '给你一个字符串 P，找到 P 中最长的回文子串。如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。', 2, 0, 0, 2, 128, 128, 1, '2023-08-19 12:22:35', '2023-06-25 00:49:00');
INSERT INTO `problem` VALUES (1672986745580322818, 2, '你好啊', '啊', 2, 0, 0, 2, 1, 2, 1, '2023-06-26 23:43:23', '2023-06-25 23:14:57');
INSERT INTO `problem` VALUES (1672990219188408321, 1668866635752132610, '最长回文子串K', '给你一个字符串 K，找到 K 中最长的回文子串。如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。', 2, 0, 0, 2, 128, 128, 3, '2023-06-27 00:46:32', '2023-06-25 23:28:46');
INSERT INTO `problem` VALUES (1673195029881004034, 1668866635752132610, '最长回文子串P', '给你一个字符串 P，找到 P 中最长的回文子串。如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。', 2, 0, 0, 2, 128, 128, 1, '2023-06-27 00:46:34', '2023-06-26 13:02:36');
INSERT INTO `problem` VALUES (1673342568176074754, 1, '最长回文子串yzx', '给你一个字符串 Y，找到 Y 中最长的回文子串。如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。', 2, 0, 0, 2, 128, 128, 3, '2023-06-27 01:05:37', '2023-06-26 22:48:52');
INSERT INTO `problem` VALUES (1673356632605700098, 1, '最长回文子串y', '给你一个字符串 Y，找到 Y 中最长的回文子串。如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。', 2, 0, 0, 2, 128, 128, 2, '2023-06-27 00:44:05', '2023-06-26 23:44:45');
INSERT INTO `problem` VALUES (1673357578240897026, 1, '1233', '123', 1, 41, 8, 2, 1, 0, 4, '2023-06-26 23:48:31', '2023-06-26 23:48:31');
INSERT INTO `problem` VALUES (1673357578429640705, 1, '1233', '123', 1, 41, 8, 2, 1, 0, 4, '2023-06-26 23:48:31', '2023-06-26 23:48:31');
INSERT INTO `problem` VALUES (1673357801155571714, 1, '1233', '12345', 1, 41, 8, 2, 1, 0, 4, '2023-06-26 23:49:24', '2023-06-26 23:49:24');
INSERT INTO `problem` VALUES (1673357885100371969, 1, '1233', '12345', 1, 41, 8, 2, 1, 0, 4, '2023-06-26 23:49:44', '2023-06-26 23:49:44');
INSERT INTO `problem` VALUES (1673357896378855425, 1668866635752132610, '最长回文子串', '给你一个字符串 S，找到 S 中最长的回文子串。如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。', 2, 0, 0, 2, 128, 128, 4, '2023-06-26 23:49:47', '2023-06-26 23:49:47');
INSERT INTO `problem` VALUES (1673357909561552898, 1668866635752132610, '最长回文子串', '给你一个字符串 w，找到 w 中最长的回文子串。如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。', 2, 0, 0, 1, 128, 128, 4, '2023-06-26 23:49:50', '2023-06-26 23:49:50');
INSERT INTO `problem` VALUES (1673358525486706689, 1668866635752132610, '两数之和', '给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。你可以按任意顺序返回答案。', 2, 31, 4, 1, 128, 128, 4, '2023-06-26 23:52:17', '2023-06-26 23:52:17');
INSERT INTO `problem` VALUES (1673358535079079938, 1, '1233', '12345', 1, 41, 8, 2, 1, 0, 4, '2023-06-26 23:52:19', '2023-06-26 23:52:19');
INSERT INTO `problem` VALUES (1673358542272311297, 2, 'p3', 'p333', 2, 41, 8, 1, NULL, NULL, 4, '2023-06-26 23:52:21', '2023-06-26 23:52:21');
INSERT INTO `problem` VALUES (1673358666172051457, 1668866635752132610, '最长回文子串', '给你一个字符串 w，找到 w 中最长的回文子串。如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。', 2, 0, 0, 1, 128, 128, 4, '2023-06-26 23:52:50', '2023-06-26 23:52:50');
INSERT INTO `problem` VALUES (1673358923463241730, 1, '1233', '12345', 1, 41, 8, 2, 1, 0, 4, '2023-06-26 23:53:52', '2023-06-26 23:53:52');
INSERT INTO `problem` VALUES (1673359378058686465, 1, '1233', '12345', 1, 41, 8, 2, 1, 0, 4, '2023-06-26 23:55:40', '2023-06-26 23:55:40');
INSERT INTO `problem` VALUES (1673359385201586178, 1668866635752132610, '两数之和', '给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。你可以按任意顺序返回答案。', 2, 31, 4, 1, 128, 128, 4, '2023-06-26 23:55:42', '2023-06-26 23:55:42');
INSERT INTO `problem` VALUES (1673359922739392513, 2, 'p3', 'p333', 2, 41, 8, 1, NULL, NULL, 4, '2023-06-26 23:57:50', '2023-06-26 23:57:50');
INSERT INTO `problem` VALUES (1673365260100231169, 1668866635752132610, '两数之和', '给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。你可以按任意顺序返回答案。', 2, 31, 4, 1, 128, 128, 4, '2023-06-27 00:19:02', '2023-06-27 00:19:02');
INSERT INTO `problem` VALUES (1673365260519661569, 1668866635752132610, '两数之和', '给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。你可以按任意顺序返回答案。', 2, 31, 4, 1, 128, 128, 4, '2023-06-27 00:19:02', '2023-06-27 00:19:02');
INSERT INTO `problem` VALUES (1673370351247110145, 1668866635752132610, '最长回文子串', '给你一个字符串 S，找到 S 中最长的回文子串。如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。', 2, 0, 0, 2, 128, 128, 4, '2023-06-27 00:39:16', '2023-06-27 00:39:16');
INSERT INTO `problem` VALUES (1673370370834509826, 1, '三数之和', 'a+b+c', 2, 0, 0, 1, 16, 32, 2, '2023-06-27 00:39:21', '2023-06-27 00:39:21');
INSERT INTO `problem` VALUES (1673370782836797442, 1668866635752132610, '最长回文子串', '给你一个字符串 w，找到 w 中最长的回文子串。如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。', 2, 0, 0, 1, 128, 128, 4, '2023-06-27 00:40:59', '2023-06-27 00:40:59');
INSERT INTO `problem` VALUES (1673371013368328193, 1, '两数之和', '给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。你可以按任意顺序返回答案。', 2, 0, 0, 1, 12, 23, 3, '2023-06-27 23:49:46', '2023-06-27 00:41:54');
INSERT INTO `problem` VALUES (1673371163402776577, 1668866635752132610, '最长回文子串P123', '给你一个字符串 P，找到 P 中最长的回文子串。如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。', 2, 0, 0, 2, 128, 128, 4, '2023-06-27 00:42:30', '2023-06-27 00:42:30');
INSERT INTO `problem` VALUES (1673371276980334594, 1, 'p1', 'p111', 2, 10, 3, 2, NULL, 123, 4, '2023-06-27 00:42:57', '2023-06-27 00:42:57');
INSERT INTO `problem` VALUES (1673371469419196417, 1, '1233', '12345', 1, 41, 8, 2, 1, 0, 4, '2023-06-27 00:43:43', '2023-06-27 00:43:43');
INSERT INTO `problem` VALUES (1673371541229875202, 1, '最长回文子串yzx', '给你一个字符串 Y，找到 Y 中最长的回文子串。如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。', 2, 0, 0, 2, 128, 128, 4, '2023-06-27 00:44:00', '2023-06-27 00:44:00');
INSERT INTO `problem` VALUES (1673371553179447297, 1668866635752132610, '最长回文子串P', '给你一个字符串 P，找到 P 中最长的回文子串。如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。', 2, 0, 0, 2, 128, 128, 4, '2023-06-27 00:44:03', '2023-06-27 00:44:03');
INSERT INTO `problem` VALUES (1673371565108047874, 1, '最长回文子串y', '给你一个字符串 Y，找到 Y 中最长的回文子串。如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。', 2, 0, 0, 2, 128, 128, 4, '2023-06-27 00:44:06', '2023-06-27 00:44:06');
INSERT INTO `problem` VALUES (1673371624864296961, 1668866635752132610, '最长回文子串K', '给你一个字符串 K，找到 K 中最长的回文子串。如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。', 2, 0, 0, 2, 128, 128, 4, '2023-06-27 00:44:20', '2023-06-27 00:44:20');
INSERT INTO `problem` VALUES (1673371637459791873, 1668866635752132610, '最长回文子串', '给你一个字符串 d，找到 d 中最长的回文子串。如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。', 2, 0, 0, 2, 128, 128, 4, '2023-06-27 00:44:23', '2023-06-27 00:44:23');
INSERT INTO `problem` VALUES (1673722716328341506, 1, 'p11', 'p111', 2, 10, 3, 2, NULL, 123, 4, '2023-06-27 23:59:26', '2023-06-27 23:59:26');
INSERT INTO `problem` VALUES (1673733883369140225, 1, '1233', '12345', 1, 41, 8, 2, 1, 0, 4, '2023-06-28 00:43:49', '2023-06-28 00:43:49');
INSERT INTO `problem` VALUES (1673734018882908161, 1, '1233', '12345', 1, 41, 8, 2, 1, 0, 4, '2023-06-28 00:44:21', '2023-06-28 00:44:21');
INSERT INTO `problem` VALUES (1673958792220577794, 1, '原神', '原神原神原神原神原神原神原神原神原神', 1, 0, 0, 2, 127, 128, 4, '2023-06-28 15:37:31', '2023-06-28 15:37:31');
INSERT INTO `problem` VALUES (1673961688114847745, 1, '原神222', '原神原神原神原神原神原神原神原神原神', 1, 0, 0, 2, 127, 128, 4, '2023-06-28 15:49:02', '2023-06-28 15:49:02');
INSERT INTO `problem` VALUES (1673962696854265857, 1, '测试用的SQL题', '测试用的SQL题', 1, 0, 0, 3, NULL, NULL, 4, '2023-06-28 15:53:02', '2023-06-28 15:53:02');
INSERT INTO `problem` VALUES (1673962779263950849, 1, '1233', '12345', 1, 41, 8, 2, 1, 0, 4, '2023-06-28 15:53:22', '2023-06-28 15:53:22');
INSERT INTO `problem` VALUES (1674079374622400513, 1, '最长回文子串y', '给你一个字符串 Y，找到 Y 中最长的回文子串。如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。', 2, 0, 0, 2, 128, 128, 1, '2023-06-28 23:36:40', '2023-06-28 23:36:40');
INSERT INTO `problem` VALUES (1674271631217823746, 1, '测试用的SQL题 (DQL)', '测试用的SQL题', 1, 5, 2, 3, NULL, NULL, 4, '2023-06-29 12:20:38', '2023-06-29 12:20:38');
INSERT INTO `problem` VALUES (1674272023867592706, 1, '测试用的SQL题 (DML)', '12345', 1, 41, 8, 2, 1, 0, 4, '2023-06-29 12:22:12', '2023-06-29 12:22:12');
INSERT INTO `problem` VALUES (1674272131388575745, 1, 'DML测试题', 'test 表有两个字段 [id (integer), name(varchar)], 请从表中删去所有id >= 5, id <= 7', 1, 41, 8, 2, 256, 0, 4, '2023-06-29 12:22:37', '2023-06-29 12:22:37');
INSERT INTO `problem` VALUES (1674792771724050433, 1, 'p11', 'p111', 2, 10, 3, 2, NULL, 123, 4, '2023-06-30 22:51:28', '2023-06-30 22:51:28');
INSERT INTO `problem` VALUES (1675199822233321474, 1, '最长回文子串yqqq', '给你一个字符串 Yqqq，找到 Y 中最长的回文子串。如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。', 2, 0, 0, 2, 1280, 1280, 1, '2023-07-02 01:48:56', '2023-07-02 01:48:56');
INSERT INTO `problem` VALUES (1684105313113694210, 1, '三数之和', '输出 a + b + c的值', 2, 13, 5, 3, NULL, 256, 4, '2023-06-30 23:16:50', NULL);
INSERT INTO `problem` VALUES (1684106280198508545, 1, '三数之和abc', '输出 a + b + c的值', 2, 13, 5, 3, 512, 256, 4, '2023-06-30 23:16:50', NULL);
INSERT INTO `problem` VALUES (1684106470078881794, 1, '三数之和cba', '输出 a + b + c的值', 2, 13, 5, 3, 512, 256, 4, '2023-06-30 23:16:50', NULL);
INSERT INTO `problem` VALUES (1684107356167573506, 1, '三数之和c', '输出 a + b + c的值', 2, 13, 5, 3, 512, 256, 4, '2023-06-30 23:16:50', NULL);
INSERT INTO `problem` VALUES (1688944111228432385, 1, '最长回文子串yqqq2', '给你一个字符串 Yqqq，找到 Y 中最长的回文子串。如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。', 2, 0, 0, 2, 1280, 1280, 1, '2023-08-09 00:03:50', '2023-08-09 00:03:50');
INSERT INTO `problem` VALUES (1688944178001752066, 1, '最长回文子串yqqq2', '给你一个字符串 Yqqq，找到 Y 中最长的回文子串。如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。', 2, 0, 0, 2, 1280, 1280, 1, '2023-08-09 00:04:06', '2023-08-09 00:04:06');
INSERT INTO `problem` VALUES (1688944179062910978, 1, '最长回文子串yqqq2', '给你一个字符串 Yqqq，找到 Y 中最长的回文子串。如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。', 2, 0, 0, 2, 1280, 1280, 1, '2023-08-09 00:04:06', '2023-08-09 00:04:06');
INSERT INTO `problem` VALUES (1688944180195373058, 1, '最长回文子串yqqq2', '给你一个字符串 Yqqq，找到 Y 中最长的回文子串。如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。', 2, 0, 0, 2, 1280, 1280, 1, '2023-08-09 00:04:06', '2023-08-09 00:04:06');
INSERT INTO `problem` VALUES (1688945260954267649, 1673589238114926594, '最长回文子串yqqq丁真', '给你一个字符串 Yqqq，找到 Y 中最长的回文子串。如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。', 2, 0, 0, 2, 1280, 1280, 1, '2023-08-09 00:11:23', '2023-08-09 00:08:24');
INSERT INTO `problem` VALUES (1688948449900376065, 1673589238114926594, '最长回文子串——丁真1', '给你一个字符串 Yqqq，找到 Y 中最长的回文子串。如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。', 2, 0, 0, 2, 1280, 1280, 1, '2023-08-09 00:23:10', '2023-08-09 00:21:04');
INSERT INTO `problem` VALUES (1688948462709780481, 1673589238114926594, '最长回文子串——丁真2', '给你一个字符串 Yqqq，找到 Y 中最长的回文子串。如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。', 2, 0, 0, 2, 1280, 1280, 3, '2023-08-13 23:38:51', '2023-08-09 00:21:07');
INSERT INTO `problem` VALUES (1688948484184616961, 1673589238114926594, '最长回文子串——丁真3', '给你一个字符串 Yqqq，找到 Y 中最长的回文子串。如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。', 2, 0, 0, 2, 1280, 1280, 3, '2023-08-13 23:38:43', '2023-08-09 00:21:12');
INSERT INTO `problem` VALUES (1688948496318738433, 1673589238114926594, '最长回文子串——丁真4', '给你一个字符串 Yqqq，找到 Y 中最长的回文子串。如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。', 2, 0, 0, 2, 1280, 1280, 2, '2023-08-09 00:21:15', '2023-08-09 00:21:15');
INSERT INTO `problem` VALUES (1688948511862829058, 1673589238114926594, '最长回文子串——丁真5', '给你一个字符串 Yqqq，找到 Y 中最长的回文子串。如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。', 2, 0, 0, 2, 1280, 1280, 2, '2023-08-09 00:21:19', '2023-08-09 00:21:19');
INSERT INTO `problem` VALUES (1688948512823324674, 1673589238114926594, '最长回文子串——丁真5', '给你一个字符串 Yqqq，找到 Y 中最长的回文子串。如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。', 2, 0, 0, 2, 1280, 1280, 1, '2023-08-13 23:37:19', '2023-08-09 00:21:19');
INSERT INTO `problem` VALUES (1688948526970712066, 1673589238114926594, '最长回文子串——丁真6', '给你一个字符串 Yqqq，找到 Y 中最长的回文子串。如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。', 2, 0, 0, 2, 1280, 1280, 1, '2023-08-13 23:41:03', '2023-08-09 00:21:23');
INSERT INTO `problem` VALUES (1688948547392778242, 1673589238114926594, '最长回文子串——丁真7', '给你一个字符串 Yqqq，找到 Y 中最长的回文子串。如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。', 2, 0, 0, 2, 1280, 1280, 1, '2023-08-13 23:37:27', '2023-08-09 00:21:28');
INSERT INTO `problem` VALUES (1691135828684517378, 1, '最长回文子串——丁真7', '给你一个字符串 Yqqq，找到 Y 中最长的回文子串。如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。', 2, 0, 0, 2, 1280, 1280, 1, '2023-08-15 01:12:56', '2023-08-15 01:12:56');
INSERT INTO `problem` VALUES (1691136745550942209, 1, '最长回文子串——丁真7', '给你一个字符串 Yqqq，找到 Y 中最长的回文子串。如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。', 2, 0, 0, 2, 1280, 1280, 1, '2023-08-15 01:16:35', '2023-08-15 01:16:35');
INSERT INTO `problem` VALUES (1691136800982863873, 1, '最长回文子串——丁真7', '给你一个字符串 Yqqq，找到 Y 中最长的回文子串。如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。', 2, 0, 0, 2, 1280, 1280, 1, '2023-08-15 01:16:48', '2023-08-15 01:16:48');
INSERT INTO `problem` VALUES (1691136831081189377, 1, '最长回文子串——丁真7', '给你一个字符串 Yqqq，找到 Y 中最长的回文子串。如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。', 2, 0, 0, 2, 1280, 1280, 1, '2023-08-15 01:16:55', '2023-08-15 01:16:55');

-- ----------------------------
-- Table structure for problem_tag
-- ----------------------------
DROP TABLE IF EXISTS `problem_tag`;
CREATE TABLE `problem_tag`  (
  `problem_tag_id` bigint NOT NULL COMMENT '此关系的id',
  `problem_id` bigint NULL DEFAULT NULL COMMENT '题目id',
  `tag_id` bigint NULL DEFAULT NULL COMMENT '标签id',
  `update_time` datetime NULL DEFAULT NULL COMMENT '题目信息更新时间',
  `insert_time` datetime NULL DEFAULT NULL COMMENT '题目新增时间',
  PRIMARY KEY (`problem_tag_id`) USING BTREE,
  INDEX `problem_id`(`problem_id`) USING BTREE,
  INDEX `tag_id`(`tag_id`) USING BTREE,
  CONSTRAINT `problem_tag_ibfk_1` FOREIGN KEY (`problem_id`) REFERENCES `problem` (`problem_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `problem_tag_ibfk_2` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`tag_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of problem_tag
-- ----------------------------

-- ----------------------------
-- Table structure for submission
-- ----------------------------
DROP TABLE IF EXISTS `submission`;
CREATE TABLE `submission`  (
  `submission_id` bigint NOT NULL COMMENT '提交记录id',
  `user_id` bigint NULL DEFAULT NULL COMMENT '提交用户id',
  `problem_id` bigint NULL DEFAULT NULL COMMENT '题目id',
  `language` int NOT NULL COMMENT '语言',
  `code` varchar(2048) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '提交代码',
  `code_result` varchar(2048) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '代码执行结果',
  `is_debug` tinyint(1) NOT NULL COMMENT '是否是调试',
  `is_success` tinyint(1) NULL DEFAULT NULL COMMENT '是否运行成功',
  `error_type` varchar(1024) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '错误类型',
  `pass_test_case_num` int NULL DEFAULT NULL COMMENT '通过的测试用例数',
  `runtime` double NULL DEFAULT NULL COMMENT '代码执行时间',
  `memory` double NULL DEFAULT NULL COMMENT '代码消耗内存',
  `update_time` datetime NULL DEFAULT NULL COMMENT '提交记录更新时间',
  `insert_time` datetime NULL DEFAULT NULL COMMENT '提交记录新增时间',
  PRIMARY KEY (`submission_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `problem_id`(`problem_id`) USING BTREE,
  CONSTRAINT `submission_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE SET NULL ON UPDATE RESTRICT,
  CONSTRAINT `submission_ibfk_2` FOREIGN KEY (`problem_id`) REFERENCES `problem` (`problem_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '语言' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of submission
-- ----------------------------
INSERT INTO `submission` VALUES (1673968427515084802, 1, 5, 1, 'update test set name = \'丁真\' where id <=3', NULL, 1, 1, NULL, 1, NULL, NULL, '2023-06-28 16:15:49', '2023-06-28 16:15:49');
INSERT INTO `submission` VALUES (1673970314184232962, 1, 5, 1, 'update test set name = \'丁真\' where id <=3', NULL, 1, 1, NULL, 1, NULL, NULL, '2023-06-28 16:23:18', '2023-06-28 16:23:18');
INSERT INTO `submission` VALUES (1674079558865645569, 1, 1674079374622400513, 2, 'class Solution {public:string longestPalindrome(string s) {vector<vector<int>> dp(s.size(), vector<int>(s.size(), 0));int maxlenth = 0;int left = 0;int right = 0;for (int i = s.size() - 1; i >= 0; i--) {for (int j = i; j < s.size(); j++) {if (s[i] == s[j] && (j - i <= 1 || dp[i + 1][j - 1])) {dp[i][j] = true;}}}return s.substr(left, maxlenth);}};', NULL, 0, NULL, NULL, NULL, NULL, NULL, '2023-06-28 23:37:24', '2023-06-28 23:37:24');
INSERT INTO `submission` VALUES (1674083286961455106, 1, 5, 1, 'select * from test', NULL, 1, 0, '[测试用例异常] 该OUTPUT语句应为DQL', NULL, 395, NULL, '2023-06-28 23:52:13', '2023-06-28 23:52:13');
INSERT INTO `submission` VALUES (1674083711966085121, 1, 4, 2, 'select * from test', NULL, 1, NULL, NULL, NULL, NULL, NULL, '2023-06-28 23:53:55', '2023-06-28 23:53:55');
INSERT INTO `submission` VALUES (1674083728000909314, 1, 4, 2, 'select * from test', NULL, 1, NULL, NULL, NULL, NULL, NULL, '2023-06-28 23:53:58', '2023-06-28 23:53:58');
INSERT INTO `submission` VALUES (1674083755859476481, 1, 4, 1, 'select * from test', NULL, 1, 1, NULL, 2, 391, NULL, '2023-06-28 23:54:05', '2023-06-28 23:54:05');
INSERT INTO `submission` VALUES (1674084013326823426, 1, 4, 1, 'select * from user', NULL, 1, 0, 'Time Limit: 1024.0', NULL, NULL, NULL, '2023-06-28 23:55:06', '2023-06-28 23:55:06');
INSERT INTO `submission` VALUES (1674084039893544962, 1, 4, 1, 'select * from user', NULL, 1, 0, 'Time Limit: 1024.0', NULL, NULL, NULL, '2023-06-28 23:55:13', '2023-06-28 23:55:13');
INSERT INTO `submission` VALUES (1674084105165303809, 1, 4, 1, 'select * frm user', NULL, 1, 0, 'Time Limit: 1024.0', NULL, NULL, NULL, '2023-06-28 23:55:28', '2023-06-28 23:55:28');
INSERT INTO `submission` VALUES (1674084125050499074, 1, 4, 1, 'select * frm user', NULL, 1, 0, 'Time Limit: 1024.0', NULL, NULL, NULL, '2023-06-28 23:55:33', '2023-06-28 23:55:33');
INSERT INTO `submission` VALUES (1674084916268199937, 1, 4, 1, 'select * frm user', NULL, 1, 0, 'Time Limit: 1024.0', NULL, NULL, NULL, '2023-06-28 23:58:42', '2023-06-28 23:58:42');
INSERT INTO `submission` VALUES (1674084936124035073, 1, 4, 1, 'select * frm user', NULL, 1, 0, 'Time Limit: 1024.0', NULL, NULL, NULL, '2023-06-28 23:58:46', '2023-06-28 23:58:46');
INSERT INTO `submission` VALUES (1674085329449086978, 1, 4, 1, 'select * from user', NULL, 1, 0, 'Time Limit: 1024.0', NULL, NULL, NULL, '2023-06-29 00:00:20', '2023-06-29 00:00:20');
INSERT INTO `submission` VALUES (1674085365524295682, 1, 4, 1, 'select * from user', NULL, 1, 0, 'Runtime Limit: 1024.0', NULL, NULL, NULL, '2023-06-29 00:00:29', '2023-06-29 00:00:29');
INSERT INTO `submission` VALUES (1674085373455724546, 1, 4, 1, 'select * from user', NULL, 1, 0, 'Runtime Limit: 1024.0', NULL, NULL, NULL, '2023-06-29 00:00:31', '2023-06-29 00:00:31');
INSERT INTO `submission` VALUES (1674085392862769153, 1, 4, 1, 'select * from user', NULL, 1, 0, 'Runtime Limit: 1024.0', NULL, NULL, NULL, '2023-06-29 00:00:35', '2023-06-29 00:00:35');
INSERT INTO `submission` VALUES (1674085461599023105, 1, 4, 1, 'select * from user', NULL, 1, 0, 'Runtime Limit: 1024.0', NULL, NULL, NULL, '2023-06-29 00:00:52', '2023-06-29 00:00:52');
INSERT INTO `submission` VALUES (1674085577449893890, 1, 4, 1, 'select * from user', NULL, 1, 0, 'Runtime Limit: 1024.0', NULL, NULL, NULL, '2023-06-29 00:01:19', '2023-06-29 00:01:19');
INSERT INTO `submission` VALUES (1674085659826024449, 1, 4, 1, 'select * from test', NULL, 1, 1, NULL, 2, 399, NULL, '2023-06-29 00:01:39', '2023-06-29 00:01:39');
INSERT INTO `submission` VALUES (1674085675642744833, 1, 4, 1, 'select * from test', NULL, 1, 0, 'Runtime Limit: 1024.0', NULL, NULL, NULL, '2023-06-29 00:01:43', '2023-06-29 00:01:43');
INSERT INTO `submission` VALUES (1674085685927178241, 1, 4, 1, 'select * from test', NULL, 1, 0, 'Runtime Limit: 1024.0', NULL, NULL, NULL, '2023-06-29 00:01:45', '2023-06-29 00:01:45');
INSERT INTO `submission` VALUES (1674085709952151554, 1, 4, 1, 'select * from test where id = 1', NULL, 1, 0, 'Runtime Limit: 1024.0', NULL, NULL, NULL, '2023-06-29 00:01:51', '2023-06-29 00:01:51');
INSERT INTO `submission` VALUES (1674085888532983810, 1, 4, 1, 'select * from test where id = 1', NULL, 1, 0, 'Wrong Answer', 0, 478, NULL, '2023-06-29 00:02:33', '2023-06-29 00:02:33');
INSERT INTO `submission` VALUES (1674085917935054850, 1, 4, 1, 'select * from test where id = 1', NULL, 1, 0, 'Wrong Answer', 0, 390, NULL, '2023-06-29 00:02:41', '2023-06-29 00:02:41');
INSERT INTO `submission` VALUES (1674085942765334529, 1, 4, 1, 'select * from test where id = ', NULL, 1, 0, 'Runtime Limit: 1024.0', NULL, NULL, NULL, '2023-06-29 00:02:46', '2023-06-29 00:02:46');
INSERT INTO `submission` VALUES (1674086144473608193, 1, 4, 1, 'select * from test where id = ', NULL, 1, 0, 'Runtime Limit: 1024.0', NULL, NULL, NULL, '2023-06-29 00:03:35', '2023-06-29 00:03:35');
INSERT INTO `submission` VALUES (1674087097872461825, 1, 4, 1, 'select * from test where id = ', NULL, 1, 0, ' bad SQL grammar [select * from test where id = ]', NULL, NULL, NULL, '2023-06-29 00:07:22', '2023-06-29 00:07:22');
INSERT INTO `submission` VALUES (1674087128016924674, 1, 4, 1, 'select * from test where id = ', NULL, 1, 0, ' bad SQL grammar [select * from test where id = ]', NULL, NULL, NULL, '2023-06-29 00:07:29', '2023-06-29 00:07:29');
INSERT INTO `submission` VALUES (1674087147574964226, 1, 4, 1, 'select * from test where id = 1', NULL, 1, 0, 'Wrong Answer', 0, 405, NULL, '2023-06-29 00:07:34', '2023-06-29 00:07:34');
INSERT INTO `submission` VALUES (1674087183771807746, 1, 4, 1, 'select * from test2', NULL, 1, 0, ' bad SQL grammar [select * from test2]', NULL, NULL, NULL, '2023-06-29 00:07:42', '2023-06-29 00:07:42');
INSERT INTO `submission` VALUES (1674087280945442818, 1, 4, 1, 'select * from test2', NULL, 1, 0, ' bad SQL grammar [select * from test2]', NULL, NULL, NULL, '2023-06-29 00:08:05', '2023-06-29 00:08:05');
INSERT INTO `submission` VALUES (1674087303598878721, 1, 4, 1, 'select * from test where id =', NULL, 1, 0, ' bad SQL grammar [select * from test where id =]', NULL, NULL, NULL, '2023-06-29 00:08:11', '2023-06-29 00:08:11');
INSERT INTO `submission` VALUES (1674087375107567617, 1, 4, 1, 'select * from test where id 123', NULL, 1, 0, ' bad SQL grammar [select * from test where id 123]', NULL, NULL, NULL, '2023-06-29 00:08:28', '2023-06-29 00:08:28');
INSERT INTO `submission` VALUES (1674087500739629058, 1, 4, 1, 'select * from test where id 123', NULL, 1, 0, ' bad SQL grammar [select * from test where id 123]', NULL, NULL, NULL, '2023-06-29 00:08:58', '2023-06-29 00:08:58');
INSERT INTO `submission` VALUES (1674087931079413762, 1, 4, 1, 'select * from test where id 123', NULL, 1, 0, '语法错误: PreparedStatementCallback; bad SQL grammar [select * from test where id 123]; nested exception is java.sql.SQLSyntaxErrorException: ', NULL, NULL, NULL, '2023-06-29 00:10:40', '2023-06-29 00:10:40');
INSERT INTO `submission` VALUES (1674088080908341249, 1, 4, 1, 'select * from test where id 123', NULL, 1, 0, '语法错误: check the manual that corresponds to your MySQL server version for the right syntax to use near \'123\' at line 1', NULL, NULL, NULL, '2023-06-29 00:11:16', '2023-06-29 00:11:16');
INSERT INTO `submission` VALUES (1674088112919269377, 1, 4, 1, 'select * from test where id === 123', NULL, 1, 0, '语法错误: check the manual that corresponds to your MySQL server version for the right syntax to use near \'=== 123\' at line 1', NULL, NULL, NULL, '2023-06-29 00:11:24', '2023-06-29 00:11:24');
INSERT INTO `submission` VALUES (1674088147136401410, 1, 4, 1, 'select * from test whee id = 123', NULL, 1, 0, '语法错误: check the manual that corresponds to your MySQL server version for the right syntax to use near \'id = 123\' at line 1', NULL, NULL, NULL, '2023-06-29 00:11:32', '2023-06-29 00:11:32');
INSERT INTO `submission` VALUES (1674088227922890754, 1, 4, 1, 'select * from test order by id = 123', NULL, 1, 1, NULL, 2, 429, NULL, '2023-06-29 00:11:51', '2023-06-29 00:11:51');
INSERT INTO `submission` VALUES (1674088491807526913, 1, 4, 1, 'select * from test order by 123', NULL, 1, 0, '语法错误: PreparedStatementCallback; bad SQL grammar [select * from test order by 123]; nested exception is java.sql.SQLSyntaxErrorException: Unknown column \'123\' in \'order clause\'', NULL, NULL, NULL, '2023-06-29 00:12:54', '2023-06-29 00:12:54');
INSERT INTO `submission` VALUES (1674088677908795394, 1, 4, 1, 'select * from test order by 123', NULL, 1, 0, '语法错误:  bad SQL grammar [select * from test order by 123]; nested exception is java.sql.SQLSyntaxErrorException: Unknown column \'123\' in \'order clause\'', NULL, NULL, NULL, '2023-06-29 00:13:39', '2023-06-29 00:13:39');
INSERT INTO `submission` VALUES (1674088709483515906, 1, 4, 1, 'select * from tes', NULL, 1, 0, '语法错误:  bad SQL grammar [select * from tes]; nested exception is java.sql.SQLSyntaxErrorException: Table \'judge.tes\' doesn\'t exist', NULL, NULL, NULL, '2023-06-29 00:13:46', '2023-06-29 00:13:46');
INSERT INTO `submission` VALUES (1674088764948992001, 1, 4, 1, 'select * from test', NULL, 1, 1, NULL, 2, 393, NULL, '2023-06-29 00:13:59', '2023-06-29 00:13:59');
INSERT INTO `submission` VALUES (1674088894511042561, 1, 4, 1, 'select * from test where id in (select * from test)', NULL, 1, 0, '语法错误:  bad SQL grammar [select * from test where id in (select * from test)]; nested exception is java.sql.SQLException: Operand should contain 1 column(s)', NULL, NULL, NULL, '2023-06-29 00:14:30', '2023-06-29 00:14:30');
INSERT INTO `submission` VALUES (1674088945757048833, 1, 4, 1, 'select * from test where id in (select id from test)', NULL, 1, 1, NULL, 2, 403, NULL, '2023-06-29 00:14:42', '2023-06-29 00:14:42');
INSERT INTO `submission` VALUES (1674089121208979457, 1, 4, 1, 'select * from test t1 join test t2 on t1.id = t2.id', NULL, 1, 0, 'Wrong Answer', 0, 387, NULL, '2023-06-29 00:15:24', '2023-06-29 00:15:24');
INSERT INTO `submission` VALUES (1674089166062866433, 1, 4, 1, 'select * from test t1 join test t2 on t1.id = t2.id join test t2 on t1.id = t2.id', NULL, 1, 0, '语法错误:  bad SQL grammar [select * from test t1 join test t2 on t1.id = t2.id join test t2 on t1.id = t2.id]; nested exception is java.sql.SQLSyntaxErrorException: Not unique table/alias: \'t2\'', NULL, NULL, NULL, '2023-06-29 00:15:35', '2023-06-29 00:15:35');
INSERT INTO `submission` VALUES (1674089202423287809, 1, 4, 1, 'select * from test t1 join test t2 on t1.id = t2.id join test t3 on t1.id = t3.id', NULL, 1, 0, 'Wrong Answer', 0, NULL, NULL, '2023-06-29 00:15:44', '2023-06-29 00:15:44');
INSERT INTO `submission` VALUES (1674092159453745154, 1, 4, 1, 'insert into test values(1, \'2\')', NULL, 1, 0, 'Wrong Answer', 0, 426, NULL, '2023-06-29 00:27:29', '2023-06-29 00:27:29');
INSERT INTO `submission` VALUES (1674092185361960962, 1, 5, 1, 'insert into test values(1, \'2\')', NULL, 1, 0, 'Wrong Answer', 0, 429, NULL, '2023-06-29 00:27:35', '2023-06-29 00:27:35');
INSERT INTO `submission` VALUES (1674092227309195265, 1, 5, 1, 'select * from', NULL, 1, 0, '[测试用例异常] 该OUTPUT语句应为DQL', NULL, NULL, NULL, '2023-06-29 00:27:45', '2023-06-29 00:27:45');
INSERT INTO `submission` VALUES (1674092666549293058, 1, 5, 1, 'select * from', NULL, 1, 0, 'Wrong Answer', 0, NULL, NULL, '2023-06-29 00:29:30', '2023-06-29 00:29:30');
INSERT INTO `submission` VALUES (1674092731221266433, 1, 5, 1, 'select * from', NULL, 1, 0, 'Wrong Answer', 0, NULL, NULL, '2023-06-29 00:29:45', '2023-06-29 00:29:45');
INSERT INTO `submission` VALUES (1674092749885919234, 1, 5, 1, 'select * from', NULL, 1, 0, 'Wrong Answer', 0, NULL, NULL, '2023-06-29 00:29:49', '2023-06-29 00:29:49');
INSERT INTO `submission` VALUES (1674092773415964674, 1, 5, 1, 'select * from test', NULL, 1, 0, 'Wrong Answer', 0, 391, NULL, '2023-06-29 00:29:55', '2023-06-29 00:29:55');
INSERT INTO `submission` VALUES (1674092866663731201, 1, 4, 1, 'select * from test', NULL, 1, 1, NULL, 2, 395, NULL, '2023-06-29 00:30:17', '2023-06-29 00:30:17');
INSERT INTO `submission` VALUES (1674092891993133058, 1, 4, 1, 'select * from test1', NULL, 1, 0, '语法错误:  bad SQL grammar [select * from test1]; nested exception is java.sql.SQLSyntaxErrorException: Table \'judge.test1\' doesn\'t exist', NULL, NULL, NULL, '2023-06-29 00:30:23', '2023-06-29 00:30:23');
INSERT INTO `submission` VALUES (1674092940055662594, 1, 4, 1, 'insert into * from test1', NULL, 1, 0, 'Wrong Answer', 0, NULL, NULL, '2023-06-29 00:30:35', '2023-06-29 00:30:35');
INSERT INTO `submission` VALUES (1674092993059082241, 1, 4, 1, 'insert into test1 values(1, \'2\')', NULL, 1, 0, 'Wrong Answer', 0, NULL, NULL, '2023-06-29 00:30:47', '2023-06-29 00:30:47');
INSERT INTO `submission` VALUES (1674093128841285633, 1, 4, 1, 'insert into test1 values(1, \'2\')', NULL, 1, 0, 'Wrong Answer', 0, NULL, NULL, '2023-06-29 00:31:20', '2023-06-29 00:31:20');
INSERT INTO `submission` VALUES (1674093135984185346, 1, 4, 1, 'insert into test1 values(1, \'2\')', NULL, 1, 0, 'Wrong Answer', 0, NULL, NULL, '2023-06-29 00:31:21', '2023-06-29 00:31:21');
INSERT INTO `submission` VALUES (1674097619133124609, 1, 4, 1, 'select * from test', NULL, 1, 1, NULL, 2, 391, NULL, '2023-06-29 00:49:10', '2023-06-29 00:49:10');
INSERT INTO `submission` VALUES (1674097684656541697, 1, 4, 1, 'select * from test', NULL, 1, 1, NULL, 2, 441, NULL, '2023-06-29 00:49:26', '2023-06-29 00:49:26');
INSERT INTO `submission` VALUES (1674097731829878786, 1, 4, 1, 'select * from test', NULL, 1, 0, 'Wrong Answer', 1, 387, NULL, '2023-06-29 00:49:37', '2023-06-29 00:49:37');
INSERT INTO `submission` VALUES (1674097734925275137, 1, 4, 1, 'select * from test', NULL, 1, 0, 'Runtime Limit: 1024.0', 2, NULL, NULL, '2023-06-29 00:49:38', '2023-06-29 00:49:38');
INSERT INTO `submission` VALUES (1674097735374065666, 1, 4, 1, 'select * from test', NULL, 1, 0, '语法错误:  bad SQL grammar [select * from test]; nested exception is java.sql.SQLSyntaxErrorException: Table \'judge.test\' doesn\'t exist', NULL, NULL, NULL, '2023-06-29 00:49:38', '2023-06-29 00:49:38');
INSERT INTO `submission` VALUES (1674097738486239234, 1, 4, 1, 'select * from test', NULL, 1, 0, 'Runtime Limit: 1024.0', 2, NULL, NULL, '2023-06-29 00:49:39', '2023-06-29 00:49:39');
INSERT INTO `submission` VALUES (1674097741543886849, 1, 4, 1, 'select * from test', NULL, 1, 0, 'Runtime Limit: 1024.0', 2, NULL, NULL, '2023-06-29 00:49:39', '2023-06-29 00:49:39');
INSERT INTO `submission` VALUES (1674097744098217985, 1, 4, 1, 'select * from test', NULL, 1, 0, '语法错误:  bad SQL grammar [select * from test]; nested exception is java.sql.SQLSyntaxErrorException: Table \'judge.test\' doesn\'t exist', NULL, NULL, NULL, '2023-06-29 00:49:40', '2023-06-29 00:49:40');
INSERT INTO `submission` VALUES (1674097750704246785, 1, 4, 1, 'select * from test', NULL, 1, 0, 'Runtime Limit: 1024.0', 2, NULL, NULL, '2023-06-29 00:49:42', '2023-06-29 00:49:42');
INSERT INTO `submission` VALUES (1674097843419336705, 1, 4, 1, 'select * from test', NULL, 1, 0, 'Runtime Limit: 1024.0', 2, NULL, NULL, '2023-06-29 00:50:04', '2023-06-29 00:50:04');
INSERT INTO `submission` VALUES (1674097979423838210, 1, 4, 1, 'select * from test', NULL, 1, 0, 'Runtime Limit: 1024.0', 2, NULL, NULL, '2023-06-29 00:50:36', '2023-06-29 00:50:36');
INSERT INTO `submission` VALUES (1674098408765378562, 1, 4, 1, 'select * from test', NULL, 1, 0, 'Runtime Limit: 1024.0', 2, NULL, NULL, '2023-06-29 00:52:19', '2023-06-29 00:52:19');
INSERT INTO `submission` VALUES (1674098524154875905, 1, 4, 1, 'select * from test', NULL, 1, 0, 'Runtime Limit: 1024.0', 2, NULL, NULL, '2023-06-29 00:52:46', '2023-06-29 00:52:46');
INSERT INTO `submission` VALUES (1674100520836517889, 1, 4, 1, 'select * from test', NULL, 1, 0, 'Runtime Limit: 1024.0', 2, NULL, NULL, '2023-06-29 01:00:42', '2023-06-29 01:00:42');
INSERT INTO `submission` VALUES (1674100536946839553, 1, 4, 1, 'select * from test', NULL, 1, 0, 'Runtime Limit: 1024.0', 2, NULL, NULL, '2023-06-29 01:00:46', '2023-06-29 01:00:46');
INSERT INTO `submission` VALUES (1674100866694631426, 1, 4, 1, 'select * from test', NULL, 1, 0, 'Runtime Limit: 1024.0', 2, NULL, NULL, '2023-06-29 01:02:05', '2023-06-29 01:02:05');
INSERT INTO `submission` VALUES (1674100883589287937, 1, 4, 1, 'select * from test', NULL, 1, 0, 'Runtime Limit: 1024.0', 2, NULL, NULL, '2023-06-29 01:02:09', '2023-06-29 01:02:09');
INSERT INTO `submission` VALUES (1674100973544525826, 1, 4, 1, 'select * from test', NULL, 1, 0, 'Runtime Limit: 1024.0', 2, NULL, NULL, '2023-06-29 01:02:30', '2023-06-29 01:02:30');
INSERT INTO `submission` VALUES (1674101138137403394, 1, 4, 1, 'select * from test', NULL, 1, 1, NULL, 2, 387, NULL, '2023-06-29 01:03:09', '2023-06-29 01:03:09');
INSERT INTO `submission` VALUES (1674101190784307201, 1, 4, 1, 'select * from test', NULL, 1, 1, NULL, 2, 379, NULL, '2023-06-29 01:03:22', '2023-06-29 01:03:22');
INSERT INTO `submission` VALUES (1674101348511109121, 1, 4, 1, 'select * from test', NULL, 1, 1, NULL, 2, 385, NULL, '2023-06-29 01:03:59', '2023-06-29 01:03:59');
INSERT INTO `submission` VALUES (1674252006904160257, 1, 4, 1, 'insert into test1 values(1, \'2\')', NULL, 1, 0, 'Wrong Answer', 0, NULL, NULL, '2023-06-29 11:02:39', '2023-06-29 11:02:39');
INSERT INTO `submission` VALUES (1674252079985713154, 1, 4, 1, 'select * f', NULL, 1, 0, '语法错误:  bad SQL grammar [select * f]; nested exception is java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'f\' at line 1', NULL, NULL, NULL, '2023-06-29 11:02:57', '2023-06-29 11:02:57');
INSERT INTO `submission` VALUES (1674252093592035330, 1, 4, 1, 'select * f', NULL, 1, 0, '语法错误:  bad SQL grammar [select * f]; nested exception is java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'f\' at line 1', NULL, NULL, NULL, '2023-06-29 11:03:00', '2023-06-29 11:03:00');
INSERT INTO `submission` VALUES (1674252115150757890, 1, 4, 1, 'select * from test', NULL, 1, 0, 'Runtime Limit: 1024.0', 2, NULL, NULL, '2023-06-29 11:03:05', '2023-06-29 11:03:05');
INSERT INTO `submission` VALUES (1674252623500402690, 1, 4, 1, 'select * from test', NULL, 1, 0, 'Runtime Limit: 1024.0', 2, NULL, NULL, '2023-06-29 11:05:06', '2023-06-29 11:05:06');
INSERT INTO `submission` VALUES (1674253231687065601, 1, 4, 1, 'select * from test', NULL, 1, 0, '超时', NULL, NULL, NULL, '2023-06-29 11:07:31', '2023-06-29 11:07:31');
INSERT INTO `submission` VALUES (1674253247092744193, 1, 4, 1, 'select * from test', NULL, 1, 0, '超时', NULL, NULL, NULL, '2023-06-29 11:07:35', '2023-06-29 11:07:35');
INSERT INTO `submission` VALUES (1674253264373276674, 1, 4, 1, 'select * from test1', NULL, 1, 0, '超时', NULL, NULL, NULL, '2023-06-29 11:07:39', '2023-06-29 11:07:39');
INSERT INTO `submission` VALUES (1674253438445281282, 1, 4, 1, 'select * from test1', NULL, 1, 0, '语法错误:  bad SQL grammar [select * from test1]; nested exception is java.sql.SQLSyntaxErrorException: Table \'judge.test1\' doesn\'t exist', NULL, NULL, NULL, '2023-06-29 11:08:21', '2023-06-29 11:08:21');
INSERT INTO `submission` VALUES (1674253911776681986, 1, 4, 1, 'select * from test1', NULL, 1, 0, '语法错误:  bad SQL grammar [select * from test1]; nested exception is java.sql.SQLSyntaxErrorException: Table \'judge.test1\' doesn\'t exist', NULL, -1, NULL, '2023-06-29 11:10:13', '2023-06-29 11:10:13');
INSERT INTO `submission` VALUES (1674253924544143362, 1, 4, 1, 'select * from test1', NULL, 1, 0, '语法错误:  bad SQL grammar [select * from test1]; nested exception is java.sql.SQLSyntaxErrorException: Table \'judge.test1\' doesn\'t exist', NULL, -1, NULL, '2023-06-29 11:10:16', '2023-06-29 11:10:16');
INSERT INTO `submission` VALUES (1674253942957137922, 1, 4, 1, 'select * from test1', NULL, 1, 0, '语法错误:  bad SQL grammar [select * from test1]; nested exception is java.sql.SQLSyntaxErrorException: Table \'judge.test1\' doesn\'t exist', NULL, -1, NULL, '2023-06-29 11:10:21', '2023-06-29 11:10:21');
INSERT INTO `submission` VALUES (1674254533758410753, 1, 4, 1, 'select * from test ordery by', NULL, 1, 0, '语法错误:  bad SQL grammar [select * from test ordery by]; nested exception is java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'by\' at line 1', NULL, -1, NULL, '2023-06-29 11:12:42', '2023-06-29 11:12:42');
INSERT INTO `submission` VALUES (1674254593191698434, 1, 4, 1, 'select * from test', NULL, 1, 1, NULL, 2, 405, NULL, '2023-06-29 11:12:56', '2023-06-29 11:12:56');
INSERT INTO `submission` VALUES (1674254683029495810, 1, 4, 1, 'select * from test', NULL, 1, 0, '运行超时 Runtime Limit: 10.0', NULL, NULL, NULL, '2023-06-29 11:13:17', '2023-06-29 11:13:17');
INSERT INTO `submission` VALUES (1674256142529847297, 1, 4, 1, 'select * from test', NULL, 1, 1, NULL, 2, 407, NULL, '2023-06-29 11:19:05', '2023-06-29 11:19:05');
INSERT INTO `submission` VALUES (1674256152281604097, 1, 4, 1, 'select * from test', NULL, 1, 1, NULL, 2, 389, NULL, '2023-06-29 11:19:08', '2023-06-29 11:19:08');
INSERT INTO `submission` VALUES (1674256259018252290, 1, 4, 1, 'select * from test', NULL, 0, 1, NULL, 2, 403, NULL, '2023-06-29 11:19:33', '2023-06-29 11:19:33');
INSERT INTO `submission` VALUES (1674256271555026946, 1, 4, 1, 'select * from test', NULL, 0, 1, NULL, 2, 425, NULL, '2023-06-29 11:19:36', '2023-06-29 11:19:36');
INSERT INTO `submission` VALUES (1674256325015625729, 1, 4, 1, 'select * from test1', NULL, 0, 0, '语法错误:  bad SQL grammar [select * from test1]; nested exception is java.sql.SQLSyntaxErrorException: Table \'judge.test1\' doesn\'t exist', NULL, -1, NULL, '2023-06-29 11:19:49', '2023-06-29 11:19:49');
INSERT INTO `submission` VALUES (1674257720406040578, 1, 4, 1, 'select * from test1', NULL, 0, 0, '语法错误:  bad SQL grammar [select * from test1]; nested exception is java.sql.SQLSyntaxErrorException: Table \'judge.test1\' doesn\'t exist', NULL, -1, NULL, '2023-06-29 11:25:21', '2023-06-29 11:25:21');
INSERT INTO `submission` VALUES (1674257749891997697, 1, 4, 1, 'select * from test1', NULL, 1, 0, '语法错误:  bad SQL grammar [select * from test1]; nested exception is java.sql.SQLSyntaxErrorException: Table \'judge.test1\' doesn\'t exist', NULL, -1, NULL, '2023-06-29 11:25:28', '2023-06-29 11:25:28');
INSERT INTO `submission` VALUES (1674257765457059842, 1, 4, 1, 'select * from test', NULL, 1, 0, 'Wrong Answer', 1, 423, NULL, '2023-06-29 11:25:32', '2023-06-29 11:25:32');
INSERT INTO `submission` VALUES (1674258236372541442, 1, 4, 1, 'select * from test', NULL, 1, 1, NULL, 1, 415, NULL, '2023-06-29 11:27:24', '2023-06-29 11:27:24');
INSERT INTO `submission` VALUES (1674258682206085122, 1, 4, 1, 'select * from test', NULL, 1, 1, NULL, 1, 427, NULL, '2023-06-29 11:29:11', '2023-06-29 11:29:11');
INSERT INTO `submission` VALUES (1674258727550705666, 1, 4, 1, 'select * from test', NULL, 1, 1, NULL, 1, 416, NULL, '2023-06-29 11:29:22', '2023-06-29 11:29:22');
INSERT INTO `submission` VALUES (1674258744722186242, 1, 4, 1, 'select * from test1', NULL, 1, 0, '语法错误:  bad SQL grammar [select * from test1]; nested exception is java.sql.SQLSyntaxErrorException: Table \'judge.test1\' doesn\'t exist', NULL, -1, NULL, '2023-06-29 11:29:26', '2023-06-29 11:29:26');
INSERT INTO `submission` VALUES (1674258796219850754, 1, 4, 1, 'select * from test1', NULL, 1, 0, '语法错误:  bad SQL grammar [select * from test1]; nested exception is java.sql.SQLSyntaxErrorException: Table \'judge.test1\' doesn\'t exist', NULL, -1, NULL, '2023-06-29 11:29:38', '2023-06-29 11:29:38');
INSERT INTO `submission` VALUES (1674260833980506114, 1, 4, 1, '1', NULL, 1, 0, '只允许提交DQL与DML语句', NULL, NULL, NULL, '2023-06-29 11:37:44', '2023-06-29 11:37:44');
INSERT INTO `submission` VALUES (1674260857527328769, 1, 4, 1, '1', NULL, 1, 0, '只允许提交DQL与DML语句', NULL, NULL, NULL, '2023-06-29 11:37:49', '2023-06-29 11:37:49');
INSERT INTO `submission` VALUES (1674260916901896194, 1, 4, 1, 'select 8 from test', NULL, 1, 0, 'Wrong Answer (passed: 0/3)', 0, 405, NULL, '2023-06-29 11:38:04', '2023-06-29 11:38:04');
INSERT INTO `submission` VALUES (1674260996409122817, 1, 4, 1, 'select * from test', NULL, 1, 1, NULL, 1, 389, NULL, '2023-06-29 11:38:22', '2023-06-29 11:38:22');
INSERT INTO `submission` VALUES (1674261693154320385, 1, 4, 1, 'select * from test', NULL, 1, 0, 'Wrong Answer (passed: 0/1)', 0, NULL, NULL, '2023-06-29 11:41:09', '2023-06-29 11:41:09');
INSERT INTO `submission` VALUES (1674261801321226242, 1, 4, 1, 'select * from test', NULL, 1, 0, 'Wrong Answer (passed: 0/1)', 0, NULL, NULL, '2023-06-29 11:41:34', '2023-06-29 11:41:34');
INSERT INTO `submission` VALUES (1674261853011828738, 1, 4, 1, 'select * from test', NULL, 1, 0, 'Wrong Answer (passed: 0/1)', 0, NULL, NULL, '2023-06-29 11:41:47', '2023-06-29 11:41:47');
INSERT INTO `submission` VALUES (1674262157883203586, 1, 4, 1, 'select * from test', NULL, 1, 1, NULL, 1, 398, NULL, '2023-06-29 11:42:59', '2023-06-29 11:42:59');
INSERT INTO `submission` VALUES (1674262185162956801, 1, 4, 1, 'select * from test', NULL, 1, 1, NULL, 1, 392, NULL, '2023-06-29 11:43:06', '2023-06-29 11:43:06');
INSERT INTO `submission` VALUES (1674262233422618625, 1, 4, 1, 'select 1 from test', NULL, 1, 0, 'Wrong Answer (passed: 0/1)', 0, 406, NULL, '2023-06-29 11:43:17', '2023-06-29 11:43:17');
INSERT INTO `submission` VALUES (1674262267702665218, 1, 4, 1, 'select 1 from test f', NULL, 1, 0, 'Wrong Answer (passed: 0/1)', 0, 409, NULL, '2023-06-29 11:43:26', '2023-06-29 11:43:26');
INSERT INTO `submission` VALUES (1674262326481641473, 1, 4, 1, 'select 1 from test where', NULL, 1, 0, '语法错误:  bad SQL grammar [select 1 from test where]; nested exception is java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'\' at line 1', NULL, -1, NULL, '2023-06-29 11:43:40', '2023-06-29 11:43:40');
INSERT INTO `submission` VALUES (1674264560451837954, 1, 4, 1, '1', NULL, 1, 0, '只允许提交DQL与DML语句', NULL, NULL, NULL, '2023-06-29 11:52:32', '2023-06-29 11:52:32');
INSERT INTO `submission` VALUES (1674264570459447298, 1, 4, 1, '1', NULL, 1, 0, '只允许提交DQL与DML语句', NULL, NULL, NULL, '2023-06-29 11:52:35', '2023-06-29 11:52:35');
INSERT INTO `submission` VALUES (1674265233016872961, 1, 4, 1, '', NULL, 1, 0, '只允许提交DQL与DML语句', NULL, NULL, NULL, '2023-06-29 11:55:13', '2023-06-29 11:55:13');
INSERT INTO `submission` VALUES (1674265408166813698, 1, 4, 1, '', NULL, 1, 0, '只允许提交DQL与DML语句', NULL, NULL, NULL, '2023-06-29 11:55:54', '2023-06-29 11:55:54');
INSERT INTO `submission` VALUES (1674265555441410049, 1, 4, 1, '1', NULL, 1, 0, '只允许提交DQL与DML语句', NULL, NULL, NULL, '2023-06-29 11:56:29', '2023-06-29 11:56:29');
INSERT INTO `submission` VALUES (1674265576324849666, 1, 4, 1, '1', NULL, 1, 0, '只允许提交DQL与DML语句', NULL, NULL, NULL, '2023-06-29 11:56:34', '2023-06-29 11:56:34');
INSERT INTO `submission` VALUES (1674265679571836929, 1, 4, 1, '1', NULL, 1, 0, '只允许提交DQL与DML语句', NULL, NULL, NULL, '2023-06-29 11:56:59', '2023-06-29 11:56:59');
INSERT INTO `submission` VALUES (1674265727110078465, 1, 4, 1, 'select 1 from test', NULL, 1, 0, 'Wrong Answer (passed: 0/1)', 0, 417, NULL, '2023-06-29 11:57:10', '2023-06-29 11:57:10');
INSERT INTO `submission` VALUES (1674265744231227394, 1, 4, 1, 'select 1 from test1', NULL, 1, 0, '运行超时 Runtime Limit: 1024.0 ms', NULL, NULL, NULL, '2023-06-29 11:57:14', '2023-06-29 11:57:14');
INSERT INTO `submission` VALUES (1674265769661292546, 1, 4, 1, 'select 1 from test 1', NULL, 1, 0, '运行超时 Runtime Limit: 1024.0 ms', NULL, NULL, NULL, '2023-06-29 11:57:20', '2023-06-29 11:57:20');
INSERT INTO `submission` VALUES (1674265813315608577, 1, 4, 1, 'select 1 from test order ', NULL, 1, 0, '运行超时 Runtime Limit: 1024.0 ms', NULL, NULL, NULL, '2023-06-29 11:57:31', '2023-06-29 11:57:31');
INSERT INTO `submission` VALUES (1674265974729203713, 1, 4, 1, 'select 1 frm test ', NULL, 1, 0, '运行超时 Runtime Limit: 1024.0 ms', NULL, NULL, NULL, '2023-06-29 11:58:09', '2023-06-29 11:58:09');
INSERT INTO `submission` VALUES (1674266005934825474, 1, 4, 1, 'select  frm test ', NULL, 1, 0, '运行超时 Runtime Limit: 1024.0 ms', NULL, NULL, NULL, '2023-06-29 11:58:17', '2023-06-29 11:58:17');
INSERT INTO `submission` VALUES (1674266349251104770, 1, 4, 1, 'select  * from test ', NULL, 1, 1, NULL, 1, 413, NULL, '2023-06-29 11:59:39', '2023-06-29 11:59:39');
INSERT INTO `submission` VALUES (1674266446949027841, 1, 4, 1, 'select * from test', NULL, 1, 1, NULL, 1, 442, NULL, '2023-06-29 12:00:02', '2023-06-29 12:00:02');
INSERT INTO `submission` VALUES (1674266468042182657, 1, 4, 1, 'select 1 from test', NULL, 1, 0, 'Wrong Answer (passed: 0/1)', 0, 431, NULL, '2023-06-29 12:00:07', '2023-06-29 12:00:07');
INSERT INTO `submission` VALUES (1674266490456543234, 1, 4, 1, 'select  from test', NULL, 1, 0, '语法错误:  bad SQL grammar [select  from test]; nested exception is java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'from test\' at line 1', NULL, -1, NULL, '2023-06-29 12:00:12', '2023-06-29 12:00:12');
INSERT INTO `submission` VALUES (1674266605812486145, 1, 4, 1, 'sel', NULL, 1, 0, '只允许提交DQL与DML语句', NULL, NULL, NULL, '2023-06-29 12:00:40', '2023-06-29 12:00:40');
INSERT INTO `submission` VALUES (1674266630739234818, 1, 4, 1, 'select from', NULL, 1, 0, '语法错误:  bad SQL grammar [select from]; nested exception is java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'from\' at line 1', NULL, -1, NULL, '2023-06-29 12:00:46', '2023-06-29 12:00:46');
INSERT INTO `submission` VALUES (1674266678369751042, 1, 4, 1, 'select from', NULL, 1, 0, '语法错误:  bad SQL grammar [select from]; nested exception is java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'from\' at line 1', NULL, -1, NULL, '2023-06-29 12:00:57', '2023-06-29 12:00:57');
INSERT INTO `submission` VALUES (1674266747726761985, 1, 4, 1, 'select from', NULL, 1, 0, '运行超时 Runtime Limit: 1024.0 ms', NULL, NULL, NULL, '2023-06-29 12:01:14', '2023-06-29 12:01:14');
INSERT INTO `submission` VALUES (1674266764940185601, 1, 4, 1, 'select from', NULL, 1, 0, '运行超时 Runtime Limit: 1024.0 ms', NULL, NULL, NULL, '2023-06-29 12:01:18', '2023-06-29 12:01:18');
INSERT INTO `submission` VALUES (1674266801678094337, 1, 4, 1, 'select * from test', NULL, 1, 0, '运行超时 Runtime Limit: 1024.0 ms', NULL, NULL, NULL, '2023-06-29 12:01:27', '2023-06-29 12:01:27');
INSERT INTO `submission` VALUES (1674266812725891073, 1, 4, 1, 'select * from test', NULL, 1, 0, '运行超时 Runtime Limit: 1024.0 ms', NULL, NULL, NULL, '2023-06-29 12:01:29', '2023-06-29 12:01:29');
INSERT INTO `submission` VALUES (1674266824914538498, 1, 4, 1, 'select * from test', NULL, 1, 0, '运行超时 Runtime Limit: 1024.0 ms', NULL, NULL, NULL, '2023-06-29 12:01:32', '2023-06-29 12:01:32');
INSERT INTO `submission` VALUES (1674266834376888322, 1, 4, 1, 'select * from test', NULL, 1, 0, '运行超时 Runtime Limit: 1024.0 ms', NULL, NULL, NULL, '2023-06-29 12:01:34', '2023-06-29 12:01:34');
INSERT INTO `submission` VALUES (1674266844309000193, 1, 4, 1, 'select * from test', NULL, 1, 0, '运行超时 Runtime Limit: 1024.0 ms', NULL, NULL, NULL, '2023-06-29 12:01:37', '2023-06-29 12:01:37');
INSERT INTO `submission` VALUES (1674266853872013314, 1, 4, 1, 'select * from test', NULL, 1, 0, '运行超时 Runtime Limit: 1024.0 ms', NULL, NULL, NULL, '2023-06-29 12:01:39', '2023-06-29 12:01:39');
INSERT INTO `submission` VALUES (1674266870686978050, 1, 4, 1, 'select * from test', NULL, 1, 0, '运行超时 Runtime Limit: 1024.0 ms', NULL, NULL, NULL, '2023-06-29 12:01:43', '2023-06-29 12:01:43');
INSERT INTO `submission` VALUES (1674266879109140482, 1, 4, 1, 'select * from test', NULL, 1, 0, '运行超时 Runtime Limit: 1024.0 ms', NULL, NULL, NULL, '2023-06-29 12:01:45', '2023-06-29 12:01:45');
INSERT INTO `submission` VALUES (1674266887887818753, 1, 4, 1, 'select * from test', NULL, 1, 0, '运行超时 Runtime Limit: 1024.0 ms', NULL, NULL, NULL, '2023-06-29 12:01:47', '2023-06-29 12:01:47');
INSERT INTO `submission` VALUES (1674266961774678018, 1, 4, 1, 'select * from test', NULL, 1, 0, '运行超时 Runtime Limit: 1024.0 ms', NULL, NULL, NULL, '2023-06-29 12:02:05', '2023-06-29 12:02:05');
INSERT INTO `submission` VALUES (1674266971635486722, 1, 4, 1, 'select * from test', NULL, 1, 0, '运行超时 Runtime Limit: 1024.0 ms', NULL, NULL, NULL, '2023-06-29 12:02:07', '2023-06-29 12:02:07');
INSERT INTO `submission` VALUES (1674267011720450049, 1, 4, 1, 'select * from test1', NULL, 1, 0, '运行超时 Runtime Limit: 1024.0 ms', NULL, NULL, NULL, '2023-06-29 12:02:17', '2023-06-29 12:02:17');
INSERT INTO `submission` VALUES (1674267308035444737, 1, 4, 1, 'select * from test1', NULL, 1, 0, '语法错误:  bad SQL grammar [select * from test1]; nested exception is java.sql.SQLSyntaxErrorException: Table \'judge.test1\' doesn\'t exist', NULL, -1, NULL, '2023-06-29 12:03:27', '2023-06-29 12:03:27');
INSERT INTO `submission` VALUES (1674267325169176578, 1, 4, 1, 'select * from test', NULL, 1, 1, NULL, 1, 422, NULL, '2023-06-29 12:03:31', '2023-06-29 12:03:31');
INSERT INTO `submission` VALUES (1674267339291398146, 1, 4, 1, 'select * from test', NULL, 1, 1, NULL, 1, 414, NULL, '2023-06-29 12:03:35', '2023-06-29 12:03:35');
INSERT INTO `submission` VALUES (1674267351475851265, 1, 4, 1, 'select * from test', NULL, 1, 1, NULL, 1, 412, NULL, '2023-06-29 12:03:38', '2023-06-29 12:03:38');
INSERT INTO `submission` VALUES (1674267364788572162, 1, 4, 1, 'select * from test', NULL, 1, 1, NULL, 1, 412, NULL, '2023-06-29 12:03:41', '2023-06-29 12:03:41');
INSERT INTO `submission` VALUES (1674267380882116609, 1, 4, 1, 'select  from test', NULL, 1, 0, '语法错误:  bad SQL grammar [select  from test]; nested exception is java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'from test\' at line 1', NULL, -1, NULL, '2023-06-29 12:03:45', '2023-06-29 12:03:45');
INSERT INTO `submission` VALUES (1674267396166160386, 1, 4, 1, 'select  from test', NULL, 1, 0, '运行超时 Runtime Limit: 1024.0 ms', NULL, NULL, NULL, '2023-06-29 12:03:48', '2023-06-29 12:03:48');
INSERT INTO `submission` VALUES (1674267410124804098, 1, 4, 1, 'select  from test', NULL, 1, 0, '运行超时 Runtime Limit: 1024.0 ms', NULL, NULL, NULL, '2023-06-29 12:03:52', '2023-06-29 12:03:52');
INSERT INTO `submission` VALUES (1674267423844372482, 1, 4, 1, 'select 1 from test', NULL, 1, 0, '运行超时 Runtime Limit: 1024.0 ms', NULL, NULL, NULL, '2023-06-29 12:03:55', '2023-06-29 12:03:55');
INSERT INTO `submission` VALUES (1674267436611833858, 1, 4, 1, 'select 1 from test', NULL, 1, 0, '运行超时 Runtime Limit: 1024.0 ms', NULL, NULL, NULL, '2023-06-29 12:03:58', '2023-06-29 12:03:58');
INSERT INTO `submission` VALUES (1674267461035266050, 1, 4, 1, 'select 1 from test', NULL, 1, 0, '运行超时 Runtime Limit: 1024.0 ms', NULL, NULL, NULL, '2023-06-29 12:04:04', '2023-06-29 12:04:04');
INSERT INTO `submission` VALUES (1674267592769966081, 1, 4, 1, 'select 1 from test', NULL, 1, 0, '运行超时 Runtime Limit: 1024.0 ms', NULL, NULL, NULL, '2023-06-29 12:04:35', '2023-06-29 12:04:35');
INSERT INTO `submission` VALUES (1674267687829671937, 1, 4, 1, 'select 1 from test', NULL, 1, 0, 'Wrong Answer (passed: 0/1)', 0, 385, NULL, '2023-06-29 12:04:58', '2023-06-29 12:04:58');
INSERT INTO `submission` VALUES (1674267713180045313, 1, 4, 1, 'select * from test', NULL, 1, 1, NULL, 1, 525, NULL, '2023-06-29 12:05:04', '2023-06-29 12:05:04');
INSERT INTO `submission` VALUES (1674267732033441794, 1, 4, 1, 'select  from test', NULL, 1, 0, '语法错误:  bad SQL grammar [select  from test]; nested exception is java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'from test\' at line 1', NULL, -1, NULL, '2023-06-29 12:05:08', '2023-06-29 12:05:08');
INSERT INTO `submission` VALUES (1674267741776809986, 1, 4, 1, 'select  from test', NULL, 1, 0, '语法错误:  bad SQL grammar [select  from test]; nested exception is java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'from test\' at line 1', NULL, -1, NULL, '2023-06-29 12:05:11', '2023-06-29 12:05:11');
INSERT INTO `submission` VALUES (1674267750282858497, 1, 4, 1, 'select  from test', NULL, 1, 0, '语法错误:  bad SQL grammar [select  from test]; nested exception is java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'from test\' at line 1', NULL, -1, NULL, '2023-06-29 12:05:13', '2023-06-29 12:05:13');
INSERT INTO `submission` VALUES (1674267778078511106, 1, 4, 1, 'select 1 from test', NULL, 1, 0, 'Wrong Answer (passed: 0/1)', 0, 414, NULL, '2023-06-29 12:05:19', '2023-06-29 12:05:19');
INSERT INTO `submission` VALUES (1674267794184638465, 1, 4, 1, 'select  from test', NULL, 1, 0, '运行超时 Runtime Limit: 1024.0 ms', NULL, NULL, NULL, '2023-06-29 12:05:23', '2023-06-29 12:05:23');
INSERT INTO `submission` VALUES (1674267810622115842, 1, 4, 1, 'select  from test', NULL, 1, 0, '运行超时 Runtime Limit: 1024.0 ms', NULL, NULL, NULL, '2023-06-29 12:05:27', '2023-06-29 12:05:27');
INSERT INTO `submission` VALUES (1674270233168220162, 1, 4, 1, 'select  from test', NULL, 1, 0, '语法错误:  bad SQL grammar [select  from test]; nested exception is java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'from test\' at line 1', NULL, -1, NULL, '2023-06-29 12:15:05', '2023-06-29 12:15:05');
INSERT INTO `submission` VALUES (1674270246921342978, 1, 4, 1, 'select  from test', NULL, 1, 0, '语法错误:  bad SQL grammar [select  from test]; nested exception is java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'from test\' at line 1', NULL, -1, NULL, '2023-06-29 12:15:08', '2023-06-29 12:15:08');
INSERT INTO `submission` VALUES (1674270263555952642, 1, 4, 1, 'select 1  from test', NULL, 1, 0, 'Wrong Answer (passed: 0/1)', 0, 416, NULL, '2023-06-29 12:15:12', '2023-06-29 12:15:12');
INSERT INTO `submission` VALUES (1674270286154862593, 1, 4, 1, 'select 1  from test', NULL, 1, 0, 'Wrong Answer (passed: 0/1)', 0, 422, NULL, '2023-06-29 12:15:17', '2023-06-29 12:15:17');
INSERT INTO `submission` VALUES (1674270308099461121, 1, 4, 1, 'select  from test', NULL, 1, 0, '语法错误:  bad SQL grammar [select  from test]; nested exception is java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'from test\' at line 1', NULL, -1, NULL, '2023-06-29 12:15:23', '2023-06-29 12:15:23');
INSERT INTO `submission` VALUES (1674270319235338242, 1, 4, 1, 'select  from test', NULL, 1, 0, '语法错误:  bad SQL grammar [select  from test]; nested exception is java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'from test\' at line 1', NULL, -1, NULL, '2023-06-29 12:15:25', '2023-06-29 12:15:25');
INSERT INTO `submission` VALUES (1674270327087075329, 1, 4, 1, 'select  from test', NULL, 1, 0, '运行超时 Runtime Limit: 1024.0 ms', NULL, NULL, NULL, '2023-06-29 12:15:27', '2023-06-29 12:15:27');
INSERT INTO `submission` VALUES (1674270345009336322, 1, 4, 1, 'select  from test', NULL, 1, 0, '运行超时 Runtime Limit: 1024.0 ms', NULL, NULL, NULL, '2023-06-29 12:15:31', '2023-06-29 12:15:31');
INSERT INTO `submission` VALUES (1674270720391155714, 1, 4, 1, 'select  from test', NULL, 1, 0, '语法错误:  bad SQL grammar [select  from test]; nested exception is java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'from test\' at line 1', NULL, -1, NULL, '2023-06-29 12:17:01', '2023-06-29 12:17:01');
INSERT INTO `submission` VALUES (1674270741568196610, 1, 4, 1, 'select  from test', NULL, 1, 0, '语法错误:  bad SQL grammar [select  from test]; nested exception is java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'from test\' at line 1', NULL, -1, NULL, '2023-06-29 12:17:06', '2023-06-29 12:17:06');
INSERT INTO `submission` VALUES (1674270753320636418, 1, 4, 1, 'select  from test', NULL, 1, 0, '语法错误:  bad SQL grammar [select  from test]; nested exception is java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'from test\' at line 1', NULL, -1, NULL, '2023-06-29 12:17:09', '2023-06-29 12:17:09');
INSERT INTO `submission` VALUES (1674270768277524482, 1, 4, 1, 'select  from test', NULL, 1, 0, '语法错误:  bad SQL grammar [select  from test]; nested exception is java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'from test\' at line 1', NULL, -1, NULL, '2023-06-29 12:17:12', '2023-06-29 12:17:12');
INSERT INTO `submission` VALUES (1674270805195788290, 1, 4, 1, 'select 1 from test', NULL, 1, 0, 'Wrong Answer (passed: 0/1)', 0, -1, NULL, '2023-06-29 12:17:21', '2023-06-29 12:17:21');
INSERT INTO `submission` VALUES (1674270816444911618, 1, 4, 1, 'select 1 from test', NULL, 1, 0, 'Wrong Answer (passed: 0/1)', 0, -3, NULL, '2023-06-29 12:17:24', '2023-06-29 12:17:24');
INSERT INTO `submission` VALUES (1674270830424526849, 1, 4, 1, 'select from test', NULL, 1, 0, '语法错误:  bad SQL grammar [select from test]; nested exception is java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'from test\' at line 1', NULL, -1, NULL, '2023-06-29 12:17:27', '2023-06-29 12:17:27');
INSERT INTO `submission` VALUES (1674270847675699202, 1, 4, 1, 'select from test', NULL, 1, 0, '语法错误:  bad SQL grammar [select from test]; nested exception is java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'from test\' at line 1', NULL, -1, NULL, '2023-06-29 12:17:31', '2023-06-29 12:17:31');
INSERT INTO `submission` VALUES (1674270856752173058, 1, 4, 1, 'select from test', NULL, 1, 0, '语法错误:  bad SQL grammar [select from test]; nested exception is java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'from test\' at line 1', NULL, -1, NULL, '2023-06-29 12:17:33', '2023-06-29 12:17:33');
INSERT INTO `submission` VALUES (1674270865514074114, 1, 4, 1, 'select from test', NULL, 1, 0, '语法错误:  bad SQL grammar [select from test]; nested exception is java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'from test\' at line 1', NULL, -1, NULL, '2023-06-29 12:17:35', '2023-06-29 12:17:35');
INSERT INTO `submission` VALUES (1674270873453891586, 1, 4, 1, 'select from test', NULL, 1, 0, '语法错误:  bad SQL grammar [select from test]; nested exception is java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'from test\' at line 1', NULL, -1, NULL, '2023-06-29 12:17:37', '2023-06-29 12:17:37');
INSERT INTO `submission` VALUES (1674270907532611585, 1, 4, 1, 'select 1  from test', NULL, 1, 0, 'Wrong Answer (passed: 0/1)', 0, 0, NULL, '2023-06-29 12:17:45', '2023-06-29 12:17:45');
INSERT INTO `submission` VALUES (1674271141956456450, 1, 4, 1, '', NULL, 1, 0, '只允许提交DQL与DML语句', NULL, NULL, NULL, '2023-06-29 12:18:41', '2023-06-29 12:18:41');
INSERT INTO `submission` VALUES (1674271146557607938, 1, 4, 1, '1', NULL, 1, 0, '只允许提交DQL与DML语句', NULL, NULL, NULL, '2023-06-29 12:18:42', '2023-06-29 12:18:42');
INSERT INTO `submission` VALUES (1674271194234261505, 1, 4, 1, 'select 1 from t', NULL, 1, 0, '语法错误:  bad SQL grammar [select 1 from t]; nested exception is java.sql.SQLSyntaxErrorException: Table \'judge.t\' doesn\'t exist', NULL, -1, NULL, '2023-06-29 12:18:54', '2023-06-29 12:18:54');
INSERT INTO `submission` VALUES (1674271214727630849, 1, 4, 1, 'select 1 from test', NULL, 1, 0, 'Wrong Answer (passed: 0/1)', 0, 0, NULL, '2023-06-29 12:18:59', '2023-06-29 12:18:59');
INSERT INTO `submission` VALUES (1674271272978124801, 1, 4, 1, 'select 1 from test', NULL, 1, 0, 'Wrong Answer (passed: 0/1)', 0, 1, NULL, '2023-06-29 12:19:13', '2023-06-29 12:19:13');
INSERT INTO `submission` VALUES (1674271284587958273, 1, 4, 1, 'select 1 from test', NULL, 0, 0, 'Wrong Answer (passed: 0/2)', 0, -4, NULL, '2023-06-29 12:19:15', '2023-06-29 12:19:15');
INSERT INTO `submission` VALUES (1674273248981860354, 1, 4, 1, '1', NULL, 1, 0, '只允许提交DQL与DML语句', NULL, NULL, NULL, '2023-06-29 12:27:04', '2023-06-29 12:27:04');
INSERT INTO `submission` VALUES (1674274454865231873, 1, 1670833048821948417, 2, '1', NULL, 1, NULL, NULL, NULL, NULL, NULL, '2023-06-29 12:31:51', '2023-06-29 12:31:51');
INSERT INTO `submission` VALUES (1674274461739696130, 1, 1670833048821948417, 2, '1', NULL, 1, NULL, NULL, NULL, NULL, NULL, '2023-06-29 12:31:53', '2023-06-29 12:31:53');
INSERT INTO `submission` VALUES (1674274464424050690, 1, 1670833048821948417, 2, '1', NULL, 1, NULL, NULL, NULL, NULL, NULL, '2023-06-29 12:31:53', '2023-06-29 12:31:53');
INSERT INTO `submission` VALUES (1674274466386984962, 1, 1670833048821948417, 2, '1', NULL, 1, NULL, NULL, NULL, NULL, NULL, '2023-06-29 12:31:54', '2023-06-29 12:31:54');
INSERT INTO `submission` VALUES (1674274468555440130, 1, 1670833048821948417, 2, '1', NULL, 1, NULL, NULL, NULL, NULL, NULL, '2023-06-29 12:31:54', '2023-06-29 12:31:54');
INSERT INTO `submission` VALUES (1674274473395666946, 1, 1670833048821948417, 2, '1', NULL, 1, NULL, NULL, NULL, NULL, NULL, '2023-06-29 12:31:56', '2023-06-29 12:31:56');
INSERT INTO `submission` VALUES (1674274477870989314, 1, 1670833048821948417, 2, '1', NULL, 1, NULL, NULL, NULL, NULL, NULL, '2023-06-29 12:31:57', '2023-06-29 12:31:57');
INSERT INTO `submission` VALUES (1674274479599042561, 1, 1670833048821948417, 2, '1', NULL, 1, NULL, NULL, NULL, NULL, NULL, '2023-06-29 12:31:57', '2023-06-29 12:31:57');
INSERT INTO `submission` VALUES (1674277018574831617, 1, 4, 1, '', NULL, 1, 0, '只允许提交DQL与DML语句', NULL, NULL, NULL, '2023-06-29 12:42:02', '2023-06-29 12:42:02');
INSERT INTO `submission` VALUES (1674277021984800770, 1, 4, 1, '', NULL, 0, 0, '只允许提交DQL与DML语句', NULL, NULL, NULL, '2023-06-29 12:42:03', '2023-06-29 12:42:03');
INSERT INTO `submission` VALUES (1674277025625456641, 1, 4, 1, '', NULL, 0, 0, '只允许提交DQL与DML语句', NULL, NULL, NULL, '2023-06-29 12:42:04', '2023-06-29 12:42:04');
INSERT INTO `submission` VALUES (1674277111407362050, 1, 4, 1, 'ok', NULL, 0, 0, '只允许提交DQL与DML语句', NULL, NULL, NULL, '2023-06-29 12:42:25', '2023-06-29 12:42:25');
INSERT INTO `submission` VALUES (1674277792721715201, 1, 4, 1, 'select * from test', NULL, 1, 1, NULL, 1, 308, NULL, '2023-06-29 12:45:07', '2023-06-29 12:45:07');
INSERT INTO `submission` VALUES (1674277847792926722, 1, 4, 1, 'select * from test', NULL, 1, 1, NULL, 1, 2, NULL, '2023-06-29 12:45:20', '2023-06-29 12:45:20');
INSERT INTO `submission` VALUES (1674277864297512962, 1, 4, 1, 'select * from test', NULL, 1, 1, NULL, 1, 0, NULL, '2023-06-29 12:45:24', '2023-06-29 12:45:24');
INSERT INTO `submission` VALUES (1674277875223674882, 1, 4, 1, 'select * from test', NULL, 1, 1, NULL, 1, 0, NULL, '2023-06-29 12:45:27', '2023-06-29 12:45:27');
INSERT INTO `submission` VALUES (1674277893254987778, 1, 4, 1, 'select * from test', NULL, 1, 1, NULL, 1, 1, NULL, '2023-06-29 12:45:31', '2023-06-29 12:45:31');
INSERT INTO `submission` VALUES (1674277938452807682, 1, 4, 1, 'select 1 from test', NULL, 1, 0, 'Wrong Answer (passed: 0/1)', 0, 2, NULL, '2023-06-29 12:45:42', '2023-06-29 12:45:42');
INSERT INTO `submission` VALUES (1674277961232072706, 1, 4, 1, 'select * from test', NULL, 1, 1, NULL, 1, 0, NULL, '2023-06-29 12:45:47', '2023-06-29 12:45:47');
INSERT INTO `submission` VALUES (1674277983466078209, 1, 4, 1, 'select * from test', NULL, 1, 1, NULL, 1, 2, NULL, '2023-06-29 12:45:52', '2023-06-29 12:45:52');
INSERT INTO `submission` VALUES (1674278002227200002, 1, 4, 1, 'select * from test', NULL, 0, 1, NULL, 2, 1, NULL, '2023-06-29 12:45:57', '2023-06-29 12:45:57');
INSERT INTO `submission` VALUES (1674278292288487426, 1, 4, 1, 'select * from test', NULL, 1, 1, NULL, 1, 30, NULL, '2023-06-29 12:47:06', '2023-06-29 12:47:06');
INSERT INTO `submission` VALUES (1674278303306924034, 1, 4, 1, 'select * from test', NULL, 1, 1, NULL, 1, 1, NULL, '2023-06-29 12:47:09', '2023-06-29 12:47:09');
INSERT INTO `submission` VALUES (1674278325595455490, 1, 4, 1, 'select * from test', NULL, 1, 1, NULL, 1, 1, NULL, '2023-06-29 12:47:14', '2023-06-29 12:47:14');
INSERT INTO `submission` VALUES (1674278341575753729, 1, 4, 1, 'select * from test', NULL, 1, 1, NULL, 1, 1, NULL, '2023-06-29 12:47:18', '2023-06-29 12:47:18');
INSERT INTO `submission` VALUES (1674278352573218817, 1, 4, 1, 'select * from test', NULL, 1, 1, NULL, 1, 1, NULL, '2023-06-29 12:47:20', '2023-06-29 12:47:20');
INSERT INTO `submission` VALUES (1674278527496732673, 1, 4, 1, 'select * from test', NULL, 1, 1, NULL, 1, 414, NULL, '2023-06-29 12:48:02', '2023-06-29 12:48:02');
INSERT INTO `submission` VALUES (1674278551643275265, 1, 4, 1, 'select * from test', NULL, 1, 1, NULL, 1, 2, NULL, '2023-06-29 12:48:08', '2023-06-29 12:48:08');
INSERT INTO `submission` VALUES (1674278589165518850, 1, 4, 1, 'select * from test', NULL, 0, 1, NULL, 2, 2, NULL, '2023-06-29 12:48:17', '2023-06-29 12:48:17');
INSERT INTO `submission` VALUES (1674278642793889794, 1, 4, 1, 'select  student from test', NULL, 0, 0, '语法错误:  bad SQL grammar [select  student from test]; nested exception is java.sql.SQLSyntaxErrorException: Unknown column \'student\' in \'field list\'', NULL, -1, NULL, '2023-06-29 12:48:30', '2023-06-29 12:48:30');
INSERT INTO `submission` VALUES (1674278993479712769, 1, 4, 1, 'select * from test', NULL, 1, 1, NULL, 1, 39, NULL, '2023-06-29 12:49:53', '2023-06-29 12:49:53');
INSERT INTO `submission` VALUES (1674279015248150529, 1, 4, 1, 'select 1 from test', NULL, 1, 0, 'Wrong Answer (passed: 0/1)', 0, -3, NULL, '2023-06-29 12:49:58', '2023-06-29 12:49:58');
INSERT INTO `submission` VALUES (1674279075016982530, 1, 4, 1, 'select 1 from test', NULL, 1, 0, 'Wrong Answer (passed: 0/1)', 0, 1, NULL, '2023-06-29 12:50:13', '2023-06-29 12:50:13');
INSERT INTO `submission` VALUES (1674279096953192449, 1, 4, 1, 'select * from test', NULL, 1, 1, NULL, 1, 0, NULL, '2023-06-29 12:50:18', '2023-06-29 12:50:18');
INSERT INTO `submission` VALUES (1674279112971239425, 1, 4, 1, 'select * from test', NULL, 1, 1, NULL, 1, 2, NULL, '2023-06-29 12:50:22', '2023-06-29 12:50:22');
INSERT INTO `submission` VALUES (1674279832688640002, 1, 4, 1, 'select * from test', NULL, 1, 1, NULL, 1, 36, NULL, '2023-06-29 12:53:13', '2023-06-29 12:53:13');
INSERT INTO `submission` VALUES (1674301485829177345, 1, 4, 1, 'select 1 from test', '[[1], [1], [1], [1], [1], [1]]', 1, 0, 'Wrong Answer (passed: 0/1)\n', 0, 387, NULL, '2023-06-29 14:19:16', '2023-06-29 14:19:16');
INSERT INTO `submission` VALUES (1674301945969491970, 1, 4, 1, 'select 1 from test', '[[1], [1], [1], [1], [1], [1]]', 1, 0, 'Wrong Answer (passed: 0/1)\n', 0, 37, NULL, '2023-06-29 14:21:06', '2023-06-29 14:21:06');
INSERT INTO `submission` VALUES (1674302068736770050, 1, 4, 1, 'select 1 from test', '[[1], [1], [1], [1], [1], [1]]', 1, 0, 'Wrong Answer (passed: 0/1)\n', 0, 2, NULL, '2023-06-29 14:21:35', '2023-06-29 14:21:35');
INSERT INTO `submission` VALUES (1674303104331399170, 1, 4, 1, 'select 1 from test', '[1]\n[1]\n[1]\n[1]\n[1]\n[1]\n', 1, 0, 'Wrong Answer (passed: 0/1)\n', 0, 380, NULL, '2023-06-29 14:25:42', '2023-06-29 14:25:42');
INSERT INTO `submission` VALUES (1674303326520459265, 1, 4, 1, 'select 1 from test', '[1]\n[1]\n[1]\n[1]\n[1]\n[1]\n', 1, 0, 'Wrong Answer (passed: 0/1)\n', 0, -3, NULL, '2023-06-29 14:26:35', '2023-06-29 14:26:35');
INSERT INTO `submission` VALUES (1674303537712054274, 1, 4, 1, 'select 1 from test', '[1]\n[1]\n[1]\n[1]\n[1]\n[1]\n', 1, 0, 'Wrong Answer (passed: 0/1)\n', 0, 3, NULL, '2023-06-29 14:27:25', '2023-06-29 14:27:25');
INSERT INTO `submission` VALUES (1674303661003620354, 1, 4, 1, 'select 1 from user', NULL, 1, 0, '语法错误:  bad SQL grammar [select 1 from user]; nested exception is java.sql.SQLSyntaxErrorException: Table \'judge.user\' doesn\'t exist', NULL, -1, NULL, '2023-06-29 14:27:55', '2023-06-29 14:27:55');
INSERT INTO `submission` VALUES (1674303702204268546, 1, 4, 1, 'select 1 from test', '[1]\n[1]\n[1]\n[1]\n[1]\n[1]\n', 1, 0, 'Wrong Answer (passed: 0/1)\n', 0, 1, NULL, '2023-06-29 14:28:04', '2023-06-29 14:28:04');
INSERT INTO `submission` VALUES (1674303853975158785, 1, 4, 1, 'select * from test', '[1, a]\n[2, b]\n[3, c]\n[4, d]\n[5, e]\n[6, f]\n', 1, 1, NULL, 1, 1, NULL, '2023-06-29 14:28:41', '2023-06-29 14:28:41');
INSERT INTO `submission` VALUES (1674304045680017409, 1, 4, 1, 'SELECT * FROM TEST', NULL, 1, 0, '语法错误:  bad SQL grammar [SELECT * FROM TEST]; nested exception is java.sql.SQLSyntaxErrorException: Table \'judge.TEST\' doesn\'t exist', NULL, 1, NULL, '2023-06-29 14:29:26', '2023-06-29 14:29:26');
INSERT INTO `submission` VALUES (1674304095160221698, 1, 4, 1, 'SELECT * FROM test', '[1, a]\n[2, b]\n[3, c]\n[4, d]\n[5, e]\n[6, f]\n', 1, 1, NULL, 1, 0, NULL, '2023-06-29 14:29:38', '2023-06-29 14:29:38');
INSERT INTO `submission` VALUES (1674304753456234497, 1, 4, 1, 'SELeCT * FrOm TeSt', '[1, a]\n[2, b]\n[3, c]\n[4, d]\n[5, e]\n[6, f]\n', 1, 1, NULL, 1, 415, NULL, '2023-06-29 14:32:15', '2023-06-29 14:32:15');
INSERT INTO `submission` VALUES (1674305613779288066, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 385, NULL, '2023-06-29 14:35:40', '2023-06-29 14:35:40');
INSERT INTO `submission` VALUES (1674305646427750401, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 0, NULL, '2023-06-29 14:35:48', '2023-06-29 14:35:48');
INSERT INTO `submission` VALUES (1674306507715493890, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 377, NULL, '2023-06-29 14:39:13', '2023-06-29 14:39:13');
INSERT INTO `submission` VALUES (1674306514644484097, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 1, NULL, '2023-06-29 14:39:15', '2023-06-29 14:39:15');
INSERT INTO `submission` VALUES (1674306523448328194, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, -1, NULL, '2023-06-29 14:39:17', '2023-06-29 14:39:17');
INSERT INTO `submission` VALUES (1674306528796065793, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 0, NULL, '2023-06-29 14:39:18', '2023-06-29 14:39:18');
INSERT INTO `submission` VALUES (1674306533623709697, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 0, NULL, '2023-06-29 14:39:19', '2023-06-29 14:39:19');
INSERT INTO `submission` VALUES (1674306539680284673, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 1, NULL, '2023-06-29 14:39:21', '2023-06-29 14:39:21');
INSERT INTO `submission` VALUES (1674306543945891842, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, -1, NULL, '2023-06-29 14:39:22', '2023-06-29 14:39:22');
INSERT INTO `submission` VALUES (1674306551793434625, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 1, NULL, '2023-06-29 14:39:24', '2023-06-29 14:39:24');
INSERT INTO `submission` VALUES (1674306556457500674, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 2, NULL, '2023-06-29 14:39:25', '2023-06-29 14:39:25');
INSERT INTO `submission` VALUES (1674306560505004034, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 0, NULL, '2023-06-29 14:39:26', '2023-06-29 14:39:26');
INSERT INTO `submission` VALUES (1674306570596499458, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 1, NULL, '2023-06-29 14:39:28', '2023-06-29 14:39:28');
INSERT INTO `submission` VALUES (1674306580641857538, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 2, NULL, '2023-06-29 14:39:31', '2023-06-29 14:39:31');
INSERT INTO `submission` VALUES (1674306586320945153, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, -1, NULL, '2023-06-29 14:39:32', '2023-06-29 14:39:32');
INSERT INTO `submission` VALUES (1674306611121864706, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, -2, NULL, '2023-06-29 14:39:38', '2023-06-29 14:39:38');
INSERT INTO `submission` VALUES (1674306616738037762, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, -1, NULL, '2023-06-29 14:39:39', '2023-06-29 14:39:39');
INSERT INTO `submission` VALUES (1674306621196582914, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, -2, NULL, '2023-06-29 14:39:40', '2023-06-29 14:39:40');
INSERT INTO `submission` VALUES (1674306627668393985, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 1, NULL, '2023-06-29 14:39:42', '2023-06-29 14:39:42');
INSERT INTO `submission` VALUES (1674306653660495874, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 0, NULL, '2023-06-29 14:39:48', '2023-06-29 14:39:48');
INSERT INTO `submission` VALUES (1674306673252089857, 1, 4, 1, 'SELeCT 1 FrOm TeSt', '1	\n1	\n1	\n1	\n1	\n1	\n', 1, 0, 'Wrong Answer (passed: 0/1)\n', 0, 5, NULL, '2023-06-29 14:39:53', '2023-06-29 14:39:53');
INSERT INTO `submission` VALUES (1674306684102754306, 1, 4, 1, 'SELeCT 1 FrOm TeSt', '1	\n1	\n1	\n1	\n1	\n1	\n', 1, 0, 'Wrong Answer (passed: 0/1)\n', 0, 1, NULL, '2023-06-29 14:39:55', '2023-06-29 14:39:55');
INSERT INTO `submission` VALUES (1674306699105779714, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, -1, NULL, '2023-06-29 14:39:59', '2023-06-29 14:39:59');
INSERT INTO `submission` VALUES (1674306894862336001, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 424, NULL, '2023-06-29 14:40:46', '2023-06-29 14:40:46');
INSERT INTO `submission` VALUES (1674306902047178753, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 39, NULL, '2023-06-29 14:40:47', '2023-06-29 14:40:47');
INSERT INTO `submission` VALUES (1674306906736410625, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 38, NULL, '2023-06-29 14:40:48', '2023-06-29 14:40:48');
INSERT INTO `submission` VALUES (1674306911102681090, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 38, NULL, '2023-06-29 14:40:49', '2023-06-29 14:40:49');
INSERT INTO `submission` VALUES (1674306915276013570, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 38, NULL, '2023-06-29 14:40:50', '2023-06-29 14:40:50');
INSERT INTO `submission` VALUES (1674306919671644161, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 39, NULL, '2023-06-29 14:40:51', '2023-06-29 14:40:51');
INSERT INTO `submission` VALUES (1674306925346537474, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 38, NULL, '2023-06-29 14:40:53', '2023-06-29 14:40:53');
INSERT INTO `submission` VALUES (1674306930488754178, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 38, NULL, '2023-06-29 14:40:54', '2023-06-29 14:40:54');
INSERT INTO `submission` VALUES (1674306934376873986, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 39, NULL, '2023-06-29 14:40:55', '2023-06-29 14:40:55');
INSERT INTO `submission` VALUES (1674307036583673857, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 39, NULL, '2023-06-29 14:41:19', '2023-06-29 14:41:19');
INSERT INTO `submission` VALUES (1674307042514419713, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 38, NULL, '2023-06-29 14:41:21', '2023-06-29 14:41:21');
INSERT INTO `submission` VALUES (1674307098437074946, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 39, NULL, '2023-06-29 14:41:34', '2023-06-29 14:41:34');
INSERT INTO `submission` VALUES (1674307103398936578, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 38, NULL, '2023-06-29 14:41:35', '2023-06-29 14:41:35');
INSERT INTO `submission` VALUES (1674307108885086210, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 38, NULL, '2023-06-29 14:41:37', '2023-06-29 14:41:37');
INSERT INTO `submission` VALUES (1674307114463510529, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 38, NULL, '2023-06-29 14:41:38', '2023-06-29 14:41:38');
INSERT INTO `submission` VALUES (1674307376620093441, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 78, NULL, '2023-06-29 14:42:40', '2023-06-29 14:42:40');
INSERT INTO `submission` VALUES (1674307385130336258, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 38, NULL, '2023-06-29 14:42:42', '2023-06-29 14:42:42');
INSERT INTO `submission` VALUES (1674307389874094082, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 39, NULL, '2023-06-29 14:42:44', '2023-06-29 14:42:44');
INSERT INTO `submission` VALUES (1674307393925791745, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 40, NULL, '2023-06-29 14:42:44', '2023-06-29 14:42:44');
INSERT INTO `submission` VALUES (1674307483390296065, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 386, NULL, '2023-06-29 14:43:06', '2023-06-29 14:43:06');
INSERT INTO `submission` VALUES (1674307490138931202, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 0, NULL, '2023-06-29 14:43:07', '2023-06-29 14:43:07');
INSERT INTO `submission` VALUES (1674307494253543425, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 1, NULL, '2023-06-29 14:43:08', '2023-06-29 14:43:08');
INSERT INTO `submission` VALUES (1674307498112303106, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, -1, NULL, '2023-06-29 14:43:09', '2023-06-29 14:43:09');
INSERT INTO `submission` VALUES (1674307504143712257, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 1, NULL, '2023-06-29 14:43:11', '2023-06-29 14:43:11');
INSERT INTO `submission` VALUES (1674307508509982721, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 21, NULL, '2023-06-29 14:43:12', '2023-06-29 14:43:12');
INSERT INTO `submission` VALUES (1674307740631154690, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 390, NULL, '2023-06-29 14:44:07', '2023-06-29 14:44:07');
INSERT INTO `submission` VALUES (1674307745710456833, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 1, NULL, '2023-06-29 14:44:08', '2023-06-29 14:44:08');
INSERT INTO `submission` VALUES (1674307750944948226, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 0, NULL, '2023-06-29 14:44:10', '2023-06-29 14:44:10');
INSERT INTO `submission` VALUES (1674307755579654146, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 0, NULL, '2023-06-29 14:44:11', '2023-06-29 14:44:11');
INSERT INTO `submission` VALUES (1674307761137106946, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 1, NULL, '2023-06-29 14:44:12', '2023-06-29 14:44:12');
INSERT INTO `submission` VALUES (1674307767210459138, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 0, NULL, '2023-06-29 14:44:13', '2023-06-29 14:44:13');
INSERT INTO `submission` VALUES (1674307771249573889, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 0, NULL, '2023-06-29 14:44:14', '2023-06-29 14:44:14');
INSERT INTO `submission` VALUES (1674307989844115458, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 385, NULL, '2023-06-29 14:45:07', '2023-06-29 14:45:07');
INSERT INTO `submission` VALUES (1674308002049540097, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 0, NULL, '2023-06-29 14:45:09', '2023-06-29 14:45:09');
INSERT INTO `submission` VALUES (1674308011658690561, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 0, NULL, '2023-06-29 14:45:12', '2023-06-29 14:45:12');
INSERT INTO `submission` VALUES (1674308020743553026, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 0, NULL, '2023-06-29 14:45:14', '2023-06-29 14:45:14');
INSERT INTO `submission` VALUES (1674308029325099010, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 1, NULL, '2023-06-29 14:45:16', '2023-06-29 14:45:16');
INSERT INTO `submission` VALUES (1674308040314175489, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 0, NULL, '2023-06-29 14:45:19', '2023-06-29 14:45:19');
INSERT INTO `submission` VALUES (1674308383211110401, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 424842800000, NULL, '2023-06-29 14:46:40', '2023-06-29 14:46:40');
INSERT INTO `submission` VALUES (1674308394057580546, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 37227400000, NULL, '2023-06-29 14:46:43', '2023-06-29 14:46:43');
INSERT INTO `submission` VALUES (1674308399216574465, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 38316900000, NULL, '2023-06-29 14:46:44', '2023-06-29 14:46:44');
INSERT INTO `submission` VALUES (1674308583275216897, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 418396700000000, NULL, '2023-06-29 14:47:28', '2023-06-29 14:47:28');
INSERT INTO `submission` VALUES (1674308588228689921, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 36730400000000, NULL, '2023-06-29 14:47:29', '2023-06-29 14:47:29');
INSERT INTO `submission` VALUES (1674308592892755970, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 37193100000000, NULL, '2023-06-29 14:47:30', '2023-06-29 14:47:30');
INSERT INTO `submission` VALUES (1674308688661299201, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 36527100000000, NULL, '2023-06-29 14:47:53', '2023-06-29 14:47:53');
INSERT INTO `submission` VALUES (1674308694730457089, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 37104600000000, NULL, '2023-06-29 14:47:55', '2023-06-29 14:47:55');
INSERT INTO `submission` VALUES (1674308762279723009, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 432.8124, NULL, '2023-06-29 14:48:11', '2023-06-29 14:48:11');
INSERT INTO `submission` VALUES (1674308770190180354, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 37.7486, NULL, '2023-06-29 14:48:13', '2023-06-29 14:48:13');
INSERT INTO `submission` VALUES (1674308777865756674, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 38.4868, NULL, '2023-06-29 14:48:14', '2023-06-29 14:48:14');
INSERT INTO `submission` VALUES (1674308782588542977, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 37.9571, NULL, '2023-06-29 14:48:16', '2023-06-29 14:48:16');
INSERT INTO `submission` VALUES (1674308798191353857, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 37.5724, NULL, '2023-06-29 14:48:19', '2023-06-29 14:48:19');
INSERT INTO `submission` VALUES (1674308857033244674, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 37.0997, NULL, '2023-06-29 14:48:33', '2023-06-29 14:48:33');
INSERT INTO `submission` VALUES (1674308867825188865, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 37.3028, NULL, '2023-06-29 14:48:36', '2023-06-29 14:48:36');
INSERT INTO `submission` VALUES (1674308940067880961, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 37.9622, NULL, '2023-06-29 14:48:53', '2023-06-29 14:48:53');
INSERT INTO `submission` VALUES (1674309249586544641, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 422.9684, NULL, '2023-06-29 14:50:07', '2023-06-29 14:50:07');
INSERT INTO `submission` VALUES (1674309256658141185, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 37.7864, NULL, '2023-06-29 14:50:09', '2023-06-29 14:50:09');
INSERT INTO `submission` VALUES (1674309261083131906, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 37.3095, NULL, '2023-06-29 14:50:10', '2023-06-29 14:50:10');
INSERT INTO `submission` VALUES (1674309600918224898, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 38.0978, NULL, '2023-06-29 14:51:31', '2023-06-29 14:51:31');
INSERT INTO `submission` VALUES (1674309608837070850, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 38.5666, NULL, '2023-06-29 14:51:33', '2023-06-29 14:51:33');
INSERT INTO `submission` VALUES (1674309614734262273, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 37.3569, NULL, '2023-06-29 14:51:34', '2023-06-29 14:51:34');
INSERT INTO `submission` VALUES (1674309619935199234, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 38.2159, NULL, '2023-06-29 14:51:35', '2023-06-29 14:51:35');
INSERT INTO `submission` VALUES (1674309625467486209, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 39.0136, NULL, '2023-06-29 14:51:37', '2023-06-29 14:51:37');
INSERT INTO `submission` VALUES (1674309724465643521, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 36.4719, NULL, '2023-06-29 14:52:00', '2023-06-29 14:52:00');
INSERT INTO `submission` VALUES (1674309735593132033, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 37.2083, NULL, '2023-06-29 14:52:03', '2023-06-29 14:52:03');
INSERT INTO `submission` VALUES (1674309742564065282, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 38.0592, NULL, '2023-06-29 14:52:04', '2023-06-29 14:52:04');
INSERT INTO `submission` VALUES (1674309749157511169, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 38.1731, NULL, '2023-06-29 14:52:06', '2023-06-29 14:52:06');
INSERT INTO `submission` VALUES (1674309753280512002, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 39.8215, NULL, '2023-06-29 14:52:07', '2023-06-29 14:52:07');
INSERT INTO `submission` VALUES (1674309759039291394, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 37.0849, NULL, '2023-06-29 14:52:08', '2023-06-29 14:52:08');
INSERT INTO `submission` VALUES (1674309765972475906, 1, 4, 1, 'SELeCT * FrOm TeSt', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 38.2269, NULL, '2023-06-29 14:52:10', '2023-06-29 14:52:10');
INSERT INTO `submission` VALUES (1674310689537245186, 1, 4, 1, 'SELeCT 1 FrOm TeSt', '1	\n1	\n1	\n1	\n1	\n1	\n', 1, 0, 'Wrong Answer (passed: 0/1)\n', 0, 36.1366, NULL, '2023-06-29 14:55:50', '2023-06-29 14:55:50');
INSERT INTO `submission` VALUES (1674310702464090114, 1, 4, 1, 'SELeCT 1 FrOm TeSt', '1	\n1	\n1	\n1	\n1	\n1	\n', 0, 0, 'Wrong Answer (passed: 0/2)\n', 0, 38.2553, NULL, '2023-06-29 14:55:53', '2023-06-29 14:55:53');
INSERT INTO `submission` VALUES (1674310880361299970, 1, 4, 1, 'SELeCT 1 FrOm TeSt', '1	\n1	\n1	\n1	\n1	\n1	\n', 1, 0, 'Wrong Answer (passed: 0/1)\n', 0, 35.8056, NULL, '2023-06-29 14:56:36', '2023-06-29 14:56:36');
INSERT INTO `submission` VALUES (1674310889001566209, 1, 4, 1, 'SELeCT 1 FrOm TeSt', '1	\n1	\n1	\n1	\n1	\n1	\n', 1, 0, 'Wrong Answer (passed: 0/1)\n', 0, 36.1638, NULL, '2023-06-29 14:56:38', '2023-06-29 14:56:38');
INSERT INTO `submission` VALUES (1674310940218212353, 1, 4, 1, 'SELeCT 1 FrOm TeSt', '1	\n1	\n1	\n1	\n1	\n1	\n', 1, 0, 'Wrong Answer (passed: 0/1)', 0, 36.5514, NULL, '2023-06-29 14:56:50', '2023-06-29 14:56:50');
INSERT INTO `submission` VALUES (1674310949554733057, 1, 4, 1, 'SELeCT 1 FrOm TeSt', '1	\n1	\n1	\n1	\n1	\n1	\n', 0, 0, 'Wrong Answer (passed: 0/2)', 0, 39.4657, NULL, '2023-06-29 14:56:52', '2023-06-29 14:56:52');
INSERT INTO `submission` VALUES (1674652323453865986, 1, 4, 1, 'select * from test1', NULL, 1, 0, '语法错误:  bad SQL grammar [select * from test1]; nested exception is java.sql.SQLSyntaxErrorException: Table \'judge.test1\' doesn\'t exist', NULL, 0, NULL, '2023-06-30 13:33:22', '2023-06-30 13:33:22');
INSERT INTO `submission` VALUES (1674652351345987585, 1, 4, 1, 'select * from test', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 33.3979, NULL, '2023-06-30 13:33:29', '2023-06-30 13:33:29');
INSERT INTO `submission` VALUES (1674652583597182978, 1, 4, 1, 'select * from test', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 30.0855, NULL, '2023-06-30 13:34:24', '2023-06-30 13:34:24');
INSERT INTO `submission` VALUES (1674652614047830018, 1, 4, 1, 'select * from test1', NULL, 1, 0, '语法错误:  bad SQL grammar [select * from test1]; nested exception is java.sql.SQLSyntaxErrorException: Table \'judge.test1\' doesn\'t exist', NULL, 0, NULL, '2023-06-30 13:34:31', '2023-06-30 13:34:31');
INSERT INTO `submission` VALUES (1674656717889081346, 1, 4, 1, 'select * from test1', NULL, 1, 0, '运行超时 Runtime Limit: 1024.0 ms', NULL, NULL, NULL, '2023-06-30 13:50:50', '2023-06-30 13:50:50');
INSERT INTO `submission` VALUES (1674656871878758401, 1, 4, 1, 'select * from test1', NULL, 1, 0, '运行超时 Runtime Limit: 1024.0 ms', NULL, NULL, NULL, '2023-06-30 13:51:27', '2023-06-30 13:51:27');
INSERT INTO `submission` VALUES (1674656889931042818, 1, 4, 1, 'select * from test', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 32934300, NULL, '2023-06-30 13:51:31', '2023-06-30 13:51:31');
INSERT INTO `submission` VALUES (1674656930255081474, 1, 4, 1, 'select * from test', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 32860700, NULL, '2023-06-30 13:51:40', '2023-06-30 13:51:40');
INSERT INTO `submission` VALUES (1674657228436541442, 1, 4, 1, 'select * from test', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 32.4126, NULL, '2023-06-30 13:52:52', '2023-06-30 13:52:52');
INSERT INTO `submission` VALUES (1674657245415084033, 1, 4, 1, 'select * from test', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 32.7889, NULL, '2023-06-30 13:52:56', '2023-06-30 13:52:56');
INSERT INTO `submission` VALUES (1674657257268187137, 1, 4, 1, 'select * from test', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 31.7247, NULL, '2023-06-30 13:52:58', '2023-06-30 13:52:58');
INSERT INTO `submission` VALUES (1674657270425718785, 1, 4, 1, 'select * from test', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 32.5401, NULL, '2023-06-30 13:53:02', '2023-06-30 13:53:02');
INSERT INTO `submission` VALUES (1674657284858318850, 1, 4, 1, 'select * from test', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 32.3041, NULL, '2023-06-30 13:53:05', '2023-06-30 13:53:05');
INSERT INTO `submission` VALUES (1674657289291698177, 1, 4, 1, 'select * from test', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 32.2551, NULL, '2023-06-30 13:53:06', '2023-06-30 13:53:06');
INSERT INTO `submission` VALUES (1674657310460350466, 1, 4, 1, 'select * from testd', NULL, 1, 0, '运行超时 Runtime Limit: 1024.0 ms', NULL, NULL, NULL, '2023-06-30 13:53:11', '2023-06-30 13:53:11');
INSERT INTO `submission` VALUES (1674657323269754881, 1, 4, 1, 'select * from testd', NULL, 1, 0, '运行超时 Runtime Limit: 1024.0 ms', NULL, NULL, NULL, '2023-06-30 13:53:14', '2023-06-30 13:53:14');
INSERT INTO `submission` VALUES (1674657444090875906, 1, 4, 1, 'select * from testd', NULL, 1, 0, '运行超时 Runtime Limit: 1024.0 ms', NULL, NULL, NULL, '2023-06-30 13:53:43', '2023-06-30 13:53:43');
INSERT INTO `submission` VALUES (1674657716238290946, 1, 4, 1, 'select * from testd', NULL, 1, 0, '运行超时 Runtime Limit: 1024.0 ms', NULL, NULL, NULL, '2023-06-30 13:54:48', '2023-06-30 13:54:48');
INSERT INTO `submission` VALUES (1674657762274971650, 1, 4, 1, 'select * from testd', NULL, 1, 0, '运行超时 Runtime Limit: 1024.0 ms', NULL, NULL, NULL, '2023-06-30 13:54:59', '2023-06-30 13:54:59');
INSERT INTO `submission` VALUES (1674658026230910978, 1, 4, 1, 'select * from testd', NULL, 1, 0, '运行超时 Runtime Limit: 1024.0 ms', NULL, NULL, NULL, '2023-06-30 13:56:02', '2023-06-30 13:56:02');
INSERT INTO `submission` VALUES (1674658727849889794, 1, 4, 1, 'select * from testd', NULL, 1, 0, '运行超时 Runtime Limit: 1024.0 ms', NULL, NULL, NULL, '2023-06-30 13:58:49', '2023-06-30 13:58:49');
INSERT INTO `submission` VALUES (1674658912638341122, 1, 4, 1, 'select * from testd', NULL, 1, 0, '运行超时 Runtime Limit: 1024.0 ms', NULL, NULL, NULL, '2023-06-30 13:59:33', '2023-06-30 13:59:33');
INSERT INTO `submission` VALUES (1674658920313917441, 1, 4, 1, 'select * from testd', NULL, 1, 0, '运行超时 Runtime Limit: 1024.0 ms', NULL, NULL, NULL, '2023-06-30 13:59:35', '2023-06-30 13:59:35');
INSERT INTO `submission` VALUES (1674659070365143041, 1, 4, 1, 'select * from testd', NULL, 1, 0, '运行超时 Runtime Limit: 1024.0 ms', NULL, NULL, NULL, '2023-06-30 14:00:11', '2023-06-30 14:00:11');
INSERT INTO `submission` VALUES (1674659861687701506, 1, 4, 1, 'select * from testd', NULL, 1, 0, '111', NULL, NULL, NULL, '2023-06-30 14:03:19', '2023-06-30 14:03:19');
INSERT INTO `submission` VALUES (1674660153036640257, 1, 4, 1, 'select * from testd', NULL, 1, 0, '语法错误:  bad SQL grammar [select * from testd]; nested exception is java.sql.SQLSyntaxErrorException: Table \'judge.testd\' doesn\'t exist', NULL, -0.000001, NULL, '2023-06-30 14:04:29', '2023-06-30 14:04:29');
INSERT INTO `submission` VALUES (1674660163086192642, 1, 4, 1, 'select * from testd', NULL, 1, 0, '语法错误:  bad SQL grammar [select * from testd]; nested exception is java.sql.SQLSyntaxErrorException: Table \'judge.testd\' doesn\'t exist', NULL, -0.000001, NULL, '2023-06-30 14:04:31', '2023-06-30 14:04:31');
INSERT INTO `submission` VALUES (1674660179951489026, 1, 4, 1, 'select * from test', '1	a	\n2	b	\n3	c	\n4	d	\n5	e	\n6	f	\n', 1, 1, NULL, 1, 53.4155, NULL, '2023-06-30 14:04:35', '2023-06-30 14:04:35');
INSERT INTO `submission` VALUES (1674660201287913474, 1, 4, 1, 'select 1 from test', '1	\n1	\n1	\n1	\n1	\n1	\n', 1, 0, 'Wrong Answer (passed: 0/1)', 0, 33.8224, NULL, '2023-06-30 14:04:40', '2023-06-30 14:04:40');
INSERT INTO `submission` VALUES (1674660541173338114, 1, 4, 1, 'select 1 from test', '1	\n1	\n1	\n1	\n1	\n1	\n', 1, 0, 'Wrong Answer (passed: 0/1)', 0, 31.8807, NULL, '2023-06-30 14:06:01', '2023-06-30 14:06:01');
INSERT INTO `submission` VALUES (1674660554431533058, 1, 4, 1, 'select 1 from test', '1	\n1	\n1	\n1	\n1	\n1	\n', 1, 0, 'Wrong Answer (passed: 0/1)', 0, 38.6036, NULL, '2023-06-30 14:06:05', '2023-06-30 14:06:05');
INSERT INTO `submission` VALUES (1674660566150418434, 1, 4, 1, 'select 1 from test', '1	\n1	\n1	\n1	\n1	\n1	\n', 1, 0, 'Wrong Answer (passed: 0/1)', 0, 31.6984, NULL, '2023-06-30 14:06:07', '2023-06-30 14:06:07');
INSERT INTO `submission` VALUES (1674660683519627265, 1, 4, 1, 'select 1 from test', '1	\n1	\n1	\n1	\n1	\n1	\n', 1, 0, 'Wrong Answer (passed: 0/1)', 0, 32.1774, NULL, '2023-06-30 14:06:35', '2023-06-30 14:06:35');
INSERT INTO `submission` VALUES (1674660692201836546, 1, 4, 1, 'select 1 from test', '1	\n1	\n1	\n1	\n1	\n1	\n', 1, 0, 'Wrong Answer (passed: 0/1)', 0, -0.000001, NULL, '2023-06-30 14:06:37', '2023-06-30 14:06:37');
INSERT INTO `submission` VALUES (1674660708077277186, 1, 4, 1, 'select 1 from test', '1	\n1	\n1	\n1	\n1	\n1	\n', 1, 0, 'Wrong Answer (passed: 0/1)', 0, 31.5128, NULL, '2023-06-30 14:06:41', '2023-06-30 14:06:41');
INSERT INTO `submission` VALUES (1674660718491734018, 1, 4, 1, 'select 1 from test', '1	\n1	\n1	\n1	\n1	\n1	\n', 1, 0, 'Wrong Answer (passed: 0/1)', 0, 31.4293, NULL, '2023-06-30 14:06:44', '2023-06-30 14:06:44');
INSERT INTO `submission` VALUES (1674660799194337282, 1, 4, 1, 'select 1 from test', '1	\n1	\n1	\n1	\n1	\n1	\n', 1, 0, 'Wrong Answer (passed: 0/1)', 0, -0.000001, NULL, '2023-06-30 14:07:03', '2023-06-30 14:07:03');
INSERT INTO `submission` VALUES (1674660974843400193, 1, 4, 1, 'select 1 from test', '1	\n1	\n1	\n1	\n1	\n1	\n', 1, 0, 'Wrong Answer (passed: 0/1)', 0, 31.9445, NULL, '2023-06-30 14:07:45', '2023-06-30 14:07:45');
INSERT INTO `submission` VALUES (1674660988579745794, 1, 4, 1, 'select 1 from test', '1	\n1	\n1	\n1	\n1	\n1	\n', 1, 0, 'Wrong Answer (passed: 0/1)', 0, 32.4653, NULL, '2023-06-30 14:07:48', '2023-06-30 14:07:48');
INSERT INTO `submission` VALUES (1674661237125812226, 1, 4, 1, 'select 1 from test', NULL, 1, 0, '运行超时 Runtime Limit: 1.0 ms', NULL, NULL, NULL, '2023-06-30 14:08:47', '2023-06-30 14:08:47');
INSERT INTO `submission` VALUES (1674661247330553857, 1, 4, 1, 'select 1 from test', NULL, 1, 0, '运行超时 Runtime Limit: 1.0 ms', NULL, NULL, NULL, '2023-06-30 14:08:50', '2023-06-30 14:08:50');
INSERT INTO `submission` VALUES (1674661334970535938, 1, 4, 1, 'select 1 from test', '1	\n1	\n1	\n1	\n1	\n1	\n', 1, 0, 'Wrong Answer (passed: 0/1)', 0, 31.6952, NULL, '2023-06-30 14:09:11', '2023-06-30 14:09:11');
INSERT INTO `submission` VALUES (1674661351869386754, 1, 4, 1, 'select 1 from test', NULL, 1, 0, '运行超时 Runtime Limit: 38.0 ms', NULL, NULL, NULL, '2023-06-30 14:09:15', '2023-06-30 14:09:15');
INSERT INTO `submission` VALUES (1674796004550967298, 1, 1, 2, 'public class HelloWorld {\npublic static int add(int a, int b, int c) {\nreturn a + b + c;\n}\n\npublic static void main(String[] args) {\n// get param from args\nint a = Integer.parseInt(args[0]);\nint b = Integer.parseInt(args[1]);\nint c = Integer.parseInt(args[2]);\nint res = add(a, b, c);\nSystem.out.println(res);\n}\n}', '6\r\n', 1, 0, 'Wrong Answer (passed: 1/1)', NULL, 349.9586, NULL, '2023-06-30 23:04:18', '2023-06-30 23:04:18');
INSERT INTO `submission` VALUES (1674796207513337858, 1, 1, 2, 'public class HelloWorld {\npublic static int add(int a, int b, int c) {\nreturn a + b + c;\n}\n\npublic static void main(String[] args) {\n// get param from args\nint a = Integer.parseInt(args[0]);\nint b = Integer.parseInt(args[1]);\nint c = Integer.parseInt(args[2]);\nint res = add(a, b, c);\nSystem.out.println(res);\n}\n}', '6\r\n', 1, 0, 'Wrong Answer (passed: 1/1)', NULL, 182.1893, NULL, '2023-06-30 23:05:07', '2023-06-30 23:05:07');
INSERT INTO `submission` VALUES (1674796222080155649, 1, 1, 2, 'public class HelloWorld {\npublic static int add(int a, int b, int c) {\nreturn a + b + c;\n}\n\npublic static void main(String[] args) {\n// get param from args\nint a = Integer.parseInt(args[0]);\nint b = Integer.parseInt(args[1]);\nint c = Integer.parseInt(args[2]);\nint res = add(a, b, c);\nSystem.out.println(res);\n}\n}', '6\r\n', 1, 0, 'Wrong Answer (passed: 1/1)', NULL, 254.9595, NULL, '2023-06-30 23:05:10', '2023-06-30 23:05:10');
INSERT INTO `submission` VALUES (1674796588968509441, 1, 1, 2, 'public class HelloWorld {\npublic static int add(int a, int b, int c) {\nreturn a + b + c;\n}\n\npublic static void main(String[] args) {\n// get param from args\nint a = Integer.parseInt(args[0]);\nint b = Integer.parseInt(args[1]);\nint c = Integer.parseInt(args[2]);\nint res = add(a, b, c);\nSystem.out.println(res);\n}\n}', '6\r\n', 1, 0, 'Wrong Answer (passed: 1/1)', NULL, 399.468, NULL, '2023-06-30 23:06:38', '2023-06-30 23:06:38');
INSERT INTO `submission` VALUES (1674796603715682306, 1, 1, 2, 'public class HelloWorld {\npublic static int add(int a, int b, int c) {\nreturn a + b + c;\n}\n\npublic static void main(String[] args) {\n// get param from args\nint a = Integer.parseInt(args[0]);\nint b = Integer.parseInt(args[1]);\nint c = Integer.parseInt(args[2]);\nint res = add(a, b, c);\nSystem.out.println(res);\n}\n}', '15\r\n', 0, 1, NULL, 2, 374.4701, NULL, '2023-06-30 23:06:41', '2023-06-30 23:06:41');
INSERT INTO `submission` VALUES (1674799088962437121, 1, 1, 2, 'public class HelloWorld {\npublic static int add(int a, int b, int c) {\nreturn a + b + c;\n}\n\npublic static void main(String[] args) {\n// get param from args\nint a = Integer.parseInt(args[0]);\nint b = Integer.parseInt(args[1]);\nint c = Integer.parseInt(args[2]);\nint res = add(a, b, c);\nSystem.out.println(res);\n}\n}', '15\r\n', 0, 1, NULL, 2, 182.3449, NULL, '2023-06-30 23:16:34', '2023-06-30 23:16:34');
INSERT INTO `submission` VALUES (1674799113612361730, 1, 1, 2, 'public class HelloWorld {\npublic static int add(int a, int b, int c) {\nreturn a + b + c;\n}\n\npublic static void main(String[] args) {\n// get param from args\nint a = Integer.parseInt(args[0]);\nint b = Integer.parseInt(args[1]);\nint c = Integer.parseInt(args[2]);\nint res = add(a, b, c);\nSystem.out.println(res);\n}\n}', '6\r\n', 1, 1, NULL, 1, 223.0403, NULL, '2023-06-30 23:16:40', '2023-06-30 23:16:40');
INSERT INTO `submission` VALUES (1674799157862268930, 1, 1, 2, 'public class HelloWorld {\npublic static int add(int a, int b, int c) {\nreturn a + b + 3;\n}\n\npublic static void main(String[] args) {\n// get param from args\nint a = Integer.parseInt(args[0]);\nint b = Integer.parseInt(args[1]);\nint c = Integer.parseInt(args[2]);\nint res = add(a, b, c);\nSystem.out.println(res);\n}\n}', '12\r\n', 0, 0, 'Wrong Answer (passed: 1/2)', NULL, 388.7006, NULL, '2023-06-30 23:16:50', '2023-06-30 23:16:50');
INSERT INTO `submission` VALUES (1674809758311272450, 1, 1, 2, 'public class HelloWorld {\n	public static Object undefined(Object object) {\n\n\n	}\n\n	public static void main(String[] args) {\n\n\n	}\n}', NULL, 1, 0, '[编译失败] Javabf069d140826105.java:10: error: missing return statement\n	}\n	^\n1 error\n', NULL, NULL, NULL, '2023-06-30 23:58:58', '2023-06-30 23:58:58');
INSERT INTO `submission` VALUES (1675080076661735425, 1, 1, 2, 'public class HelloWorld {\npublic static int add(int a, int b, int c) {\nreturn a + b + c;\n}\n\npublic static void main(String[] args) {\n// get param from args\nint a = Integer.parseInt(args[0]);\nint b = Integer.parseInt(args[1]);\nint c = Integer.parseInt(args[2]);\nint res = add(a, b, c);\nSystem.out.println(res);\n}\n}', '6\r\n', 1, 1, NULL, 1, 137.0975, NULL, '2023-07-01 17:53:06', '2023-07-01 17:53:06');
INSERT INTO `submission` VALUES (1675080771783737346, 1, 1670833048821948417, 2, 'public class HelloWorld {\npublic static int add(int a, int b) {\nreturn a + b;\n}\n\npublic static void main(String[] args) {\n// get param from args\nint a = Integer.parseInt(args[0]);\nint b = Integer.parseInt(args[1]);\nint res = add(a, b, );\nSystem.out.println(res);\n}\n}', NULL, 1, 0, '[编译失败] Java41fc3057f9a2a1d.java:24: 错误: 非法的表达式开始\r\nint res = add(a, b, );\r\n                    ^\r\n1 个错误\r\n', NULL, NULL, NULL, '2023-07-01 17:55:52', '2023-07-01 17:55:52');
INSERT INTO `submission` VALUES (1675080810002235393, 1, 1670833048821948417, 2, 'public class HelloWorld {\npublic static int add(int a, int b) {\nreturn a + b;\n}\n\npublic static void main(String[] args) {\n// get param from args\nint a = Integer.parseInt(args[0]);\nint b = Integer.parseInt(args[1]);\nint res = add(a, b);\nSystem.out.println(res);\n}\n}', NULL, 1, 0, 'Wrong Answer (passed: 0/1)', NULL, NULL, NULL, '2023-07-01 17:56:01', '2023-07-01 17:56:01');
INSERT INTO `submission` VALUES (1675080837323931650, 1, 1670833048821948417, 2, 'public class HelloWorld {\npublic static int add(int a, int b) {\nreturn a + b;\n}\n\npublic static void main(String[] args) {\n// get param from args\nint a = Integer.parseInt(args[0]);\nint b = Integer.parseInt(args[1]);\nint res = add(a, b);\nSystem.out.println(res);\n}\n}', NULL, 1, 0, 'Wrong Answer (passed: 0/1)', NULL, NULL, NULL, '2023-07-01 17:56:08', '2023-07-01 17:56:08');
INSERT INTO `submission` VALUES (1675080904902557698, 1, 1670833048821948417, 2, 'public class HelloWorld {\npublic static int add(int a, int b) {\nreturn a + b;\n}\n\npublic static void main(String[] args) {\n// get param from args\nint a = Integer.parseInt(args[0]);\nint b = Integer.parseInt(args[1]);\nint res = add(a, b);\nSystem.out.println(res);\n}\n}', NULL, 1, 0, 'Wrong Answer (passed: 0/1)', NULL, NULL, NULL, '2023-07-01 17:56:24', '2023-07-01 17:56:24');
INSERT INTO `submission` VALUES (1675081410265858049, 1, 1670833048821948417, 2, 'public class HelloWorld {\npublic static int add(int a, int b, int c) {\nreturn a + b + c;\n}\n\npublic static void main(String[] args) {\n// get param from args\nint a = Integer.parseInt(args[0]);\nint b = Integer.parseInt(args[1]);\nint c = Integer.parseInt(args[2]);\nint res = add(a, b, c);\nSystem.out.println(res);\n}\n}', NULL, 1, 0, 'Wrong Answer (passed: 0/1)', NULL, NULL, NULL, '2023-07-01 17:58:24', '2023-07-01 17:58:24');
INSERT INTO `submission` VALUES (1675081459104333825, 1, 1670833048821948417, 2, 'public class HelloWorld {\npublic static int add(int a, int b) {\nreturn a + b;\n}\n\npublic static void main(String[] args) {\n// get param from args\nint a = Integer.parseInt(args[0]);\nint b = Integer.parseInt(args[1]);\nint res = add(a, b);\nSystem.out.println(res);\n}\n}', '4\r\n', 1, 1, NULL, 1, 124.1003, NULL, '2023-07-01 17:58:36', '2023-07-01 17:58:36');
INSERT INTO `submission` VALUES (1675081476628135938, 1, 1670833048821948417, 2, 'public class HelloWorld {\npublic static int add(int a, int b) {\nreturn a + b;\n}\n\npublic static void main(String[] args) {\n// get param from args\nint a = Integer.parseInt(args[0]);\nint b = Integer.parseInt(args[1]);\nint res = add(a, b);\nSystem.out.println(res);\n}\n}', '3\r\n', 0, 1, NULL, 4, 136.7962, NULL, '2023-07-01 17:58:40', '2023-07-01 17:58:40');
INSERT INTO `submission` VALUES (1675094900359675905, 1, 4, 2, 'public class HelloWorld {\n	public static Object undefined(Object object) {\n\n\n	}\n\n	public static void main(String[] args) {\n\n\n	}\n}', NULL, 1, 0, '[编译失败] Java33b8518eb084dc3.java:8: 警告: [removal] java.lang 中的 SecurityManager 已过时, 且标记为待删除\r\n    System.setSecurityManager(new SecurityManager() {\r\n                                  ^\r\nJava33b8518eb084dc3.java:8: 警告: [removal] System 中的 setSecurityManager(SecurityManager) 已过时, 且标记为待删除\r\n    System.setSecurityManager(new SecurityManager() {\r\n          ^\r\nJava33b8518eb084dc3.java:19: 错误: 缺少返回语句\r\n	}\r\n	^\r\n1 个错误\r\n2 个警告\r\n', NULL, NULL, NULL, '2023-07-01 18:52:01', '2023-07-01 18:52:01');
INSERT INTO `submission` VALUES (1675094920559443969, 1, 4, 2, 'public class HelloWorld {\n	public static Object undefined(Object object) {\n\n\n	}\n\n	public static void main(String[] args) {\n\n\n	}\n}', NULL, 1, 0, '[编译失败] Javae67ced8bbe3b39c.java:8: 警告: [removal] java.lang 中的 SecurityManager 已过时, 且标记为待删除\r\n    System.setSecurityManager(new SecurityManager() {\r\n                                  ^\r\nJavae67ced8bbe3b39c.java:8: 警告: [removal] System 中的 setSecurityManager(SecurityManager) 已过时, 且标记为待删除\r\n    System.setSecurityManager(new SecurityManager() {\r\n          ^\r\nJavae67ced8bbe3b39c.java:19: 错误: 缺少返回语句\r\n	}\r\n	^\r\n1 个错误\r\n2 个警告\r\n', NULL, NULL, NULL, '2023-07-01 18:52:05', '2023-07-01 18:52:05');
INSERT INTO `submission` VALUES (1675094938234241026, 1, 4, 2, 'public class HelloWorld {\n	public static Object undefined(Object object) {\n\n\n	}\n\n	public static void main(String[] args) {\n\n\n	}\n}', NULL, 1, 0, '[编译失败] Java5f577257fcc5cd9.java:8: 警告: [removal] java.lang 中的 SecurityManager 已过时, 且标记为待删除\r\n    System.setSecurityManager(new SecurityManager() {\r\n                                  ^\r\nJava5f577257fcc5cd9.java:8: 警告: [removal] System 中的 setSecurityManager(SecurityManager) 已过时, 且标记为待删除\r\n    System.setSecurityManager(new SecurityManager() {\r\n          ^\r\nJava5f577257fcc5cd9.java:19: 错误: 缺少返回语句\r\n	}\r\n	^\r\n1 个错误\r\n2 个警告\r\n', NULL, NULL, NULL, '2023-07-01 18:52:10', '2023-07-01 18:52:10');
INSERT INTO `submission` VALUES (1675095053401440258, 1, 4, 2, 'public class HelloWorld {\n	public static Object undefined(Object object) {\n\n\n	}\n\n	public static void main(String[] args) {\n\n\n	}\n}', NULL, 1, 0, '[编译失败] Javadc42b9e9f5693b6.java:8: 警告: [removal] java.lang 中的 SecurityManager 已过时, 且标记为待删除\r\n    System.setSecurityManager(new SecurityManager() {\r\n                                  ^\r\nJavadc42b9e9f5693b6.java:8: 警告: [removal] System 中的 setSecurityManager(SecurityManager) 已过时, 且标记为待删除\r\n    System.setSecurityManager(new SecurityManager() {\r\n          ^\r\nJavadc42b9e9f5693b6.java:19: 错误: 缺少返回语句\r\n	}\r\n	^\r\n1 个错误\r\n2 个警告\r\n', NULL, NULL, NULL, '2023-07-01 18:52:37', '2023-07-01 18:52:37');
INSERT INTO `submission` VALUES (1675095074473623554, 1, 4, 2, 'public class HelloWorld {\n	public static Object undefined(Object object) {\n\n\n	}\n\n	public static void main(String[] args) {\n\n\n	}\n}', NULL, 1, 0, '[编译失败] Java3313118c08503c6.java:8: 警告: [removal] java.lang 中的 SecurityManager 已过时, 且标记为待删除\r\n    System.setSecurityManager(new SecurityManager() {\r\n                                  ^\r\nJava3313118c08503c6.java:8: 警告: [removal] System 中的 setSecurityManager(SecurityManager) 已过时, 且标记为待删除\r\n    System.setSecurityManager(new SecurityManager() {\r\n          ^\r\nJava3313118c08503c6.java:19: 错误: 缺少返回语句\r\n	}\r\n	^\r\n1 个错误\r\n2 个警告\r\n', NULL, NULL, NULL, '2023-07-01 18:52:42', '2023-07-01 18:52:42');
INSERT INTO `submission` VALUES (1675095427659186177, 1, 4, 2, 'public class HelloWorld {\n	public static Object undefined(Object object) {\n\n\n	}\n\n	public static void main(String[] args) {\n\n\n	}\n}', NULL, 1, 0, '\r\n    System.setSecurityManager(new SecurityManager() {\r\n          ^\r\nJava4cadbb053fb5603.java:19: 错误: 缺少返回语句\r\n	}\r\n	^\r\n1 个错误\r\n2 个警告\r\n', NULL, NULL, NULL, '2023-07-01 18:54:06', '2023-07-01 18:54:06');
INSERT INTO `submission` VALUES (1675095635830882306, 1, 4, 2, 'public class HelloWorld {\n	public static Object undefined(Object object) {\n\n\n	}\n\n	public static void main(String[] args) {\n\n\n	}\n}', NULL, 1, 0, '\r\n    System.setSecurityManager(new SecurityManager() {\r\n          ^\r\nJava9104d177975e59a.java:19: 错误: 缺少返回语句\r\n	}\r\n	^\r\n1 个错误\r\n2 个警告\r\n', NULL, NULL, NULL, '2023-07-01 18:54:56', '2023-07-01 18:54:56');
INSERT INTO `submission` VALUES (1675095643087028225, 1, 4, 2, 'public class HelloWorld {\n	public static Object undefined(Object object) {\n\n\n	}\n\n	public static void main(String[] args) {\n\n\n	}\n}', NULL, 1, 0, '\r\n    System.setSecurityManager(new SecurityManager() {\r\n          ^\r\nJava3a3cbcdeadb7dc2.java:19: 错误: 缺少返回语句\r\n	}\r\n	^\r\n1 个错误\r\n2 个警告\r\n', NULL, NULL, NULL, '2023-07-01 18:54:58', '2023-07-01 18:54:58');
INSERT INTO `submission` VALUES (1675095663379070977, 1, 4, 2, 'public class HelloWorld {\n	public static Object undefined(Object object) {\n\n\n	}\n\n	public static void main(String[] args) {\n\n\n	}\n}', NULL, 1, 0, '\r\n    System.setSecurityManager(new SecurityManager() {\r\n          ^\r\nJava37b5a54b92971b4.java:19: 错误: 缺少返回语句\r\n	}\r\n	^\r\n1 个错误\r\n2 个警告\r\n', NULL, NULL, NULL, '2023-07-01 18:55:03', '2023-07-01 18:55:03');
INSERT INTO `submission` VALUES (1675095729007345665, 1, 4, 2, 'public class HelloWorld {\n	public static Object undefined(Object object) {\n\n\n	}\n\n	public static void main(String[] args) {\n\n\n	}\n}', NULL, 1, 0, '[编译失败] Java381a4900db6411c.java:8: 警告: [removal] java.lang 中的 SecurityManager 已过时, 且标记为待删除\r\n    System.setSecurityManager(new SecurityManager() {\r\n                                  ^\r\nJava381a4900db6411c.java:8: 警告: [removal] System 中的 setSecurityManager(SecurityManager) 已过时, 且标记为待删除\r\n    System.setSecurityManager(new SecurityManager() {\r\n          ^\r\nJava381a4900db6411c.java:19: 错误: 缺少返回语句\r\n	}\r\n	^\r\n1 个错误\r\n2 个警告\r\n', NULL, NULL, NULL, '2023-07-01 18:55:18', '2023-07-01 18:55:18');
INSERT INTO `submission` VALUES (1675186387726368770, 1, 1, 2, 'public class HelloWorld {\npublic static int add(int a, int b, int c) {\nreturn a + b + c;\n}\n\npublic static void main(String[] args) {\n// get param from args\nint a = Integer.parseInt(args[0]);\nint b = Integer.parseInt(args[1]);\nint c = Integer.parseInt(args[2]);\nint res = add(a, b, c);\nSystem.out.println(res);\n}\n}', '6\n', 1, 1, NULL, 1, 111.118104, NULL, '2023-07-02 00:55:33', '2023-07-02 00:55:33');
INSERT INTO `submission` VALUES (1675186592991412225, 1, 1, 2, 'public class HelloWorld {\npublic static int add(int a, int b, int c) {\nreturn a + b + c;\n}\n\npublic static void main(String[] args) {\n// get param from args\nint a = Integer.parseInt(args[0]);\nint b = Integer.parseInt(args[1]);\nint c = Integer.parseInt(args[2]);\nint res = add(a, b, c);\nRuntime.getRuntime().exec(\"ping baidu.com\");\nSystem.out.println(res);\n}\n}', NULL, 1, 0, '[编译失败] Java706239d011a9345.java:8: warning: [removal] SecurityManager in java.lang has been deprecated and marked for removal\n    System.setSecurityManager(new SecurityManager() {\n                                  ^\nJava706239d011a9345.java:8: warning: [removal] setSecurityManager(SecurityManager) in System has been deprecated and marked for removal\n    System.setSecurityManager(new SecurityManager() {\n          ^\nJava706239d011a9345.java:26: error: unreported exception IOException; must be caught or declared to be thrown\nRuntime.getRuntime().exec(\"ping baidu.com\");\n                         ^\n1 error\n2 warnings\n', NULL, NULL, NULL, '2023-07-02 00:56:22', '2023-07-02 00:56:22');
INSERT INTO `submission` VALUES (1675187384808898562, 1, 1, 2, 'public class HelloWorld {\npublic static int add(int a, int b, int c) {\nreturn a + b + c;\n}\n\npublic static void main(String[] args) {\n// get param from args\nint a = Integer.parseInt(args[0]);\nint b = Integer.parseInt(args[1]);\nint c = Integer.parseInt(args[2]);\nint res = add(a, b, c);\ntry {\nRuntime.getRuntime().exec(\"ping baidu.com\");\n} catch (Exception e) {e.printStackTrace();}\nSystem.out.println(res);\n}\n}', 'you cannot use danger system call function\n6\n', 1, 0, 'Wrong Answer (passed: 0/1)', NULL, 105.128696, NULL, '2023-07-02 00:59:31', '2023-07-02 00:59:31');
INSERT INTO `submission` VALUES (1690661258560311298, 1, 1, 2, 'public class HelloWorld {\npublic static int add(int a, int b, int c) {\nreturn a + b + c;\n}\n\npublic static void main(String[] args) {\n// get param from args\nint a = Integer.parseInt(args[0]);\nint b = Integer.parseInt(args[1]);\nint c = Integer.parseInt(args[2]);\nint res = add(a, b, c);\nSystem.out.println(res);\n}\n}', '6\n', 1, 1, NULL, 1, 123.532035, NULL, '2023-08-13 17:47:10', '2023-08-13 17:47:10');
INSERT INTO `submission` VALUES (1690661268978962434, 1, 1, 2, 'public class HelloWorld {\npublic static int add(int a, int b, int c) {\nreturn a + b + c;\n}\n\npublic static void main(String[] args) {\n// get param from args\nint a = Integer.parseInt(args[0]);\nint b = Integer.parseInt(args[1]);\nint c = Integer.parseInt(args[2]);\nint res = add(a, b, c);\nSystem.out.println(res);\n}\n}', '15\n', 0, 1, NULL, 2, 106.961607, NULL, '2023-08-13 17:47:12', '2023-08-13 17:47:12');

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`  (
  `tag_id` bigint NOT NULL COMMENT '标签id',
  `type` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '标签类型',
  `name` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '标签名',
  `update_time` datetime NULL DEFAULT NULL COMMENT '题目信息更新时间',
  `insert_time` datetime NULL DEFAULT NULL COMMENT '题目新增时间',
  PRIMARY KEY (`tag_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tag
-- ----------------------------

-- ----------------------------
-- Table structure for test_case
-- ----------------------------
DROP TABLE IF EXISTS `test_case`;
CREATE TABLE `test_case`  (
  `test_case_id` bigint NOT NULL COMMENT '测试用例id',
  `problem_id` bigint NULL DEFAULT NULL COMMENT '题目id',
  `input` varchar(512) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '测试语句',
  `output` varchar(512) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '预期输出结果',
  `description` varchar(512) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '测试描述',
  `is_prehandle` tinyint(1) NULL DEFAULT 0 COMMENT '是否为预处理语句',
  `is_posthandle` tinyint(1) NULL DEFAULT 0 COMMENT '是否为后置处理语句',
  `t_order` int NULL DEFAULT 0 COMMENT '测试用例顺序',
  `update_time` datetime NULL DEFAULT NULL COMMENT '题目信息更新时间',
  `insert_time` datetime NULL DEFAULT NULL COMMENT '题目新增时间',
  PRIMARY KEY (`test_case_id`) USING BTREE,
  INDEX `problem_id`(`problem_id`) USING BTREE,
  CONSTRAINT `test_case_ibfk_1` FOREIGN KEY (`problem_id`) REFERENCES `problem` (`problem_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test_case
-- ----------------------------
INSERT INTO `test_case` VALUES (1673017487323299842, 1672648023722848257, 'babad', 'bab', ' aba 同样是符合题意的答案。', 0, 0, 0, '2023-06-26 01:20:14', '2023-06-26 01:17:07');
INSERT INTO `test_case` VALUES (1673176001598816257, 1670833048821948417, '1\n2', '3', '1+2=3', 0, 0, 1, '2023-07-01 17:58:01', '2023-06-26 11:47:00');
INSERT INTO `test_case` VALUES (1673186946622541825, 1670833048821948417, '2\n2', '4', '2+2=4', 0, 0, 5, '2023-07-01 17:57:57', '2023-06-26 12:30:29');
INSERT INTO `test_case` VALUES (1673327054315061249, 1670833048821948417, '1\n2', '3', '1+2=3', 0, 0, 0, '2023-07-01 17:58:07', '2023-06-26 21:47:13');
INSERT INTO `test_case` VALUES (1673327151815852033, 1670833048821948417, '1\n2', '3', '1+2=3', 0, 0, 0, '2023-07-01 17:58:13', '2023-06-26 21:47:37');
INSERT INTO `test_case` VALUES (1673914009365045249, 4, 'insert into test (id, name) values (7, \'g\'), (8, \'h\'), (9, \'i\'); ', 'select * from test;', '正式测试用例', 0, 0, 5, '2023-06-28 15:05:21', '2023-06-28 12:39:34');
INSERT INTO `test_case` VALUES (1673914035625582594, 4, '', 'select * from test;', '正式测试用例', 0, 0, 6, '2023-06-28 14:35:49', '2023-06-28 12:39:41');
INSERT INTO `test_case` VALUES (1673914540728836098, 4, 'insert into test (id, name) \nvalues (1, \'a\'), (2, \'b\'), (3, \'c\');\ninsert into test (id, name) \nvalues (4, \'d\'), (5, \'e\'), (6, \'f\');', '', '插完数据 不测试', 1, 0, 1, '2023-06-28 14:34:11', '2023-06-28 12:41:41');
INSERT INTO `test_case` VALUES (1673914566750298113, 4, 'drop table if exists test;\ncreate table test (\n    id integer,\n    name varchar(30)\n);', '', '建表', 1, 0, 2, '2023-06-28 15:04:54', '2023-06-28 12:41:47');
INSERT INTO `test_case` VALUES (1673914819465502721, 4, 'drop table test;', '', '后置删表', 0, 1, 8, '2023-06-28 15:05:57', '2023-06-28 12:42:47');
INSERT INTO `test_case` VALUES (1673914819465502722, 5, '', '3', '正式测试用例', 0, 0, 6, '2023-06-28 14:35:49', '2023-06-28 12:39:41');
INSERT INTO `test_case` VALUES (1673914819465502723, 5, 'insert into test (id, name) \nvalues (1, \'a\'), (2, \'b\'), (3, \'c\');\ninsert into test (id, name) \nvalues (4, \'d\'), (5, \'e\'), (6, \'f\');', '', '插完数据 不测试', 1, 0, 1, '2023-06-28 14:34:11', '2023-06-28 12:41:41');
INSERT INTO `test_case` VALUES (1673914819465502724, 5, 'drop table if exists test;\ncreate table test (\n    id integer,\n    name varchar(30)\n);', '', '建表', 1, 0, 2, '2023-06-28 15:04:54', '2023-06-28 12:41:47');
INSERT INTO `test_case` VALUES (1673914819465502725, 5, 'drop table test;', '', '后置删表', 0, 1, 8, '2023-06-28 15:05:57', '2023-06-28 12:42:47');
INSERT INTO `test_case` VALUES (1674792827856420865, 1, '1\n2\n3', '6', '1 + 2 + 3 = 6', 0, 0, 0, '2023-06-30 22:51:41', '2023-06-30 22:51:41');
INSERT INTO `test_case` VALUES (1674792880381689857, 1, '4\n5\n6', '15', '', 0, 0, 0, '2023-06-30 22:51:53', '2023-06-30 22:51:53');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` bigint NOT NULL COMMENT '用户id',
  `role` int NOT NULL COMMENT '角色',
  `username` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '账户名',
  `password` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户登录密码',
  `nickname` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '昵称',
  `introduction` varchar(256) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '个人简介',
  `is_banned` tinyint(1) NULL DEFAULT 0 COMMENT '是否被封禁',
  `update_time` datetime NULL DEFAULT NULL COMMENT '用户信息更新时间',
  `insert_time` datetime NULL DEFAULT NULL COMMENT '用户加入时间',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 2, 'admin', 'e10adc3949ba59abbe56e057f20f883e', 'adminimda', 'ad', 0, '2023-06-14 12:26:27', '2023-06-14 12:26:24');
INSERT INTO `user` VALUES (2, 1, 'u1', 'e10adc3949ba59abbe56e057f20f883e', 'u1', 'us1', 0, '2023-08-13 17:46:23', '2023-06-14 12:26:28');
INSERT INTO `user` VALUES (3, 1, 'u3', 'e10adc3949ba59abbe56e057f20f883e', '', 'us3', 1, '2023-06-21 22:13:11', '2023-06-14 13:24:15');
INSERT INTO `user` VALUES (1668865201446965250, 1, 'u4', 'e10adc3949ba59abbe56e057f20f883e', 'u444', NULL, 1, '2023-06-26 12:38:12', '2023-06-14 14:17:25');
INSERT INTO `user` VALUES (1668866635752132610, 1, '丁真', 'e10adc3949ba59abbe56e057f20f883e', '珍珠', '纯真', 0, '2023-06-26 23:56:57', '2023-06-14 14:23:07');
INSERT INTO `user` VALUES (1671350080449286146, 1, 'u444', 'e10adc3949ba59abbe56e057f20f883e', 'u444', NULL, 0, '2023-06-25 23:05:48', '2023-06-21 10:51:26');
INSERT INTO `user` VALUES (1673589238114926594, 1, '理塘丁真', 'e10adc3949ba59abbe56e057f20f883e', '丁真', '理塘丁真', 0, '2023-06-27 15:09:03', '2023-06-27 15:09:03');
INSERT INTO `user` VALUES (1673590258341625857, 1, '理塘甲真', 'e10adc3949ba59abbe56e057f20f883e', '理塘丁真', '历史的画卷总是在前后相继中铺展，时代的华章总是在接续奋斗中书写。为了建成社会主义现代化强国、实现中华民族伟大复兴这', 0, '2023-06-27 15:13:06', '2023-06-27 15:13:06');
INSERT INTO `user` VALUES (1673590794705027074, 1, '理塘丁真1', 'e10adc3949ba59abbe56e057f20f883e', '丁真', '坚持好、运用好贯穿其中的立场观点方法。我们要大力弘扬理论联系实际的马克思主义学风，用党的创新理论武装头脑、指导实践、推动工作', 0, '2023-06-27 15:15:14', '2023-06-27 15:15:14');
INSERT INTO `user` VALUES (1673591182602649602, 1, '理塘丁真2', 'e10adc3949ba59abbe56e057f20f883e', '丁真', '我们要牢牢把握新时代新征程党的中心任务，提出', 0, '2023-06-27 15:16:46', '2023-06-27 15:16:46');
INSERT INTO `user` VALUES (1673591553169408002, 1, '理塘丁真3', 'e10adc3949ba59abbe56e057f20f883e', '丁真', '观点方法。我们要大力弘扬理论联系实际的马克思主义学风，用党的创新理论武装头脑、指导实践、推动工作', 0, '2023-06-27 15:18:15', '2023-06-27 15:18:15');
INSERT INTO `user` VALUES (1673596646618939394, 1, '理塘丁真8', 'e10adc3949ba59abbe56e057f20f883e', '丁真', '我们要牢牢把握新时代新征程党的中心任务，提出新的思路、新的战略、新的举措，继续统筹推进‘五位一体’总体布局、协调推进‘四个全面’战略布局，踔厉奋发、勇毅前行、团结奋斗，奋力谱写全面建设社会主义现代化国家崭新篇章', 0, '2023-06-27 15:38:29', '2023-06-27 15:38:29');

SET FOREIGN_KEY_CHECKS = 1;
