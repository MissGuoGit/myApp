/*
Navicat MySQL Data Transfer

Source Server         : myconn
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : xiaoyixiao

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-11-28 16:51:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cmmemberid` varchar(255) DEFAULT NULL,
  `cmtime` varchar(255) DEFAULT NULL,
  `cmdetail` varchar(255) DEFAULT NULL,
  `cmlikecount` varchar(255) DEFAULT NULL,
  `cmname` varchar(255) DEFAULT NULL,
  `cmheadpicture` varchar(255) DEFAULT NULL,
  `cmttid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('28', '52', '2019-11-28 08:46:28', '路遥知马力，日久见人心', '85', '你牛逼你赢了', '20191128090900022.png', '17');
INSERT INTO `comment` VALUES ('29', '52', '2019-11-28 08:54:05', '生日快乐呀，千玺欧巴', '21', '兜兜揣着小千', '20191128090900037.png', '20');
INSERT INTO `comment` VALUES ('30', '52', '2019-11-28 08:55:07', '啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊', '27', '想养只黑猫叫警长', '20191128090900054.png', '20');
INSERT INTO `comment` VALUES ('31', '52', '2019-11-28 08:55:34', '啊啊啊啊啊啊啊啊啊啊，哥哥，我来啦，好想你', '89', '千玺我爱你', '20191128091000015.png', '20');
INSERT INTO `comment` VALUES ('32', '52', '2019-11-28 08:55:59', ' 鬼知道做阿玺的粉丝有多不容易 上一秒:啊啊啊啊啊啊啊发7000万福利 下一秒:？？？这不是六周年牵其他小姑娘的那个视频呢？敷衍？？？ 在下一秒:啊啊啊啊啊啊卧槽牵的是我们他太会了吧啊啊啊啊啊 ​​​', '62', '报告老师这里有只喵', '20191128091000035.png', '20');
INSERT INTO `comment` VALUES ('33', '52', '2019-11-28 08:56:35', ':天哪，那个往别人身上点火的真的太残忍了。怎么能下去手。一群恶魔', '54', '超级酸妞妞', '20191128090900022.png', '19');
INSERT INTO `comment` VALUES ('34', '52', '2019-11-28 08:56:52', '选举的结果大家都知道了，民心所向！说明绝大多数香港人还是看得清的。', '42', '***当事人', '20191128090900054.png', '19');
INSERT INTO `comment` VALUES ('35', '52', '2019-11-28 08:57:12', '这个逻辑有点问题，有些东西不让你知道', '92', '略略略', '20191128091100002.png', '19');
INSERT INTO `comment` VALUES ('36', '52', '2019-11-28 08:57:48', '看着这个视频，好想拉住他啊，告诉他别跑了，千万不要再跑了……但是现实很无力', '62', '一个北啊', '20191128091000045.png', '18');
INSERT INTO `comment` VALUES ('37', '52', '2019-11-28 08:58:03', '女朋友本来要和他步入婚姻的殿堂，他过几天还要去当伴郎的，现在让他的家人怎么办', '74', '小样贩卖机', '20191128091100002.png', '18');
INSERT INTO `comment` VALUES ('38', '52', '2019-11-28 08:58:24', '超负荷工作每个行业都存在，希望大家透过这件悲剧，看清本质。社会的快节奏，逼着我们每个人牺牲健康工作，但工作相比身体还是身体更重要。也希望国家出台相关政策，对于这种不合理的工作制度，予以制止。', '96', '你你你清醒一点', '20191128091100032.png', '18');
INSERT INTO `comment` VALUES ('39', '52', '2019-11-28 08:58:47', '半夜一两点录节目跑步，省级电台，竟然没有应急措施和设备，昏倒后黄金四分钟的急救常识不懂？出了问题一团乱麻，浙江卫视难辞其咎', '15', '今天又可爱了吗', '20191128091100056.png', '18');
INSERT INTO `comment` VALUES ('40', '52', '2019-11-28 09:00:14', '慢一点喜欢，慢一点认识一个人，慢一点谈恋爱，是对双方的尊重和负责。 随随便便开始一段关系，最后也只会随随便便地收场，还会带着一身伤痕。 说的再好听，都不如实际的行动来得可靠，“路遥知马力，日久见人心”说的正是这个道理。 你可以很快就喜欢上一个人，但一定要慢一点开展关系。', '38', '呼呼', '20191128091100032.png', '17');
INSERT INTO `comment` VALUES ('41', '52', '2019-11-28 09:00:26', '好巧哦，我也是', '97', '考试不过不改名', '20191128091100032.png', '16');
INSERT INTO `comment` VALUES ('42', '52', '2019-11-28 09:00:43', '最近一直起不来，还好有个人跟我一样', '36', '我和一烊千洗', '20191128091100056.png', '16');
INSERT INTO `comment` VALUES ('43', '52', '2019-11-28 09:19:09', '也许就是昨天会议上批评你的老板', '25', '蜻蜓队长', '20191128091100002.png', '31');
INSERT INTO `comment` VALUES ('44', '52', '2019-11-28 09:19:26', '好事不留名，事了拂衣去，这才是真正的慈善家', '85', '傻逼玩意', '20191128091700001.png', '31');
INSERT INTO `comment` VALUES ('45', '52', '2019-11-28 09:19:46', '这种应该是生意人，捐款越来越多，说明生意变好了。心存善念，必有好报。', '17', '是他是他就是他', '20191128091800003.png', '31');
INSERT INTO `comment` VALUES ('46', '52', '2019-11-28 09:20:02', '人家每次都用不同的名字就是不想被发现  别调查了。录音也别放了吧', '58', '滴滴滴滴滴滴', '20191128091100056.png', '31');
INSERT INTO `comment` VALUES ('47', '52', '2019-11-28 09:20:59', '加油，奥利给', '64', '无事不登三宝殿', '20191128091700001.png', '30');
INSERT INTO `comment` VALUES ('48', '52', '2019-11-28 09:21:27', '我长这么英俊，还是要感谢爸妈，要不是他们给了我脑子，我也不敢在这胡思乱想', '19', '有钱耶波儿', '20191128091100032.png', '30');
INSERT INTO `comment` VALUES ('49', '52', '2019-11-28 09:21:37', '我长这么英俊，还是要感谢爸妈，要不是他们给了我脑子，我也不敢在这胡思乱想', '27', '最后一张改名卡', '20191128091100002.png', '30');
INSERT INTO `comment` VALUES ('50', '52', '2019-11-28 09:21:48', '感谢父母给了我一个好胃口，要不我也不能干啥啥不行，吃饭第一名啊！【骄傲脸】', '34', '羡羡三岁哦', '20191128091800003.png', '30');
INSERT INTO `comment` VALUES ('51', '52', '2019-11-28 09:22:05', '感谢我女朋友送我的绿帽子', '95', '阿宁小天使', '20191128091100002.png', '30');
INSERT INTO `comment` VALUES ('52', '52', '2019-11-28 09:22:27', '[感谢你伴我岁岁又年年\n再感谢你陪我拥抱了寒夜\n最后感谢你手捧着银河拭去我泪眼\n\n今天感恩节，大家有没有最想感谢的人呢？\n', '45', '行为艺术', '20191128090900054.png', '30');

-- ----------------------------
-- Table structure for `eatwhat`
-- ----------------------------
DROP TABLE IF EXISTS `eatwhat`;
CREATE TABLE `eatwhat` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '对应的id',
  `eatimg` varchar(255) DEFAULT NULL COMMENT '吃啥的图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of eatwhat
-- ----------------------------
INSERT INTO `eatwhat` VALUES ('8', '20191128152934285.jpg');
INSERT INTO `eatwhat` VALUES ('9', '20191128152956386.jpg');
INSERT INTO `eatwhat` VALUES ('10', '20191128153005055.jpg');
INSERT INTO `eatwhat` VALUES ('11', '20191128153013564.jpg');
INSERT INTO `eatwhat` VALUES ('12', '20191128153022670.jpg');
INSERT INTO `eatwhat` VALUES ('13', '20191128153044793.jpg');
INSERT INTO `eatwhat` VALUES ('14', '20191128153056135.jpg');
INSERT INTO `eatwhat` VALUES ('15', '20191128153107730.jpg');
INSERT INTO `eatwhat` VALUES ('16', '20191128153123135.jpg');
INSERT INTO `eatwhat` VALUES ('17', '20191128153132098.jpg');
INSERT INTO `eatwhat` VALUES ('18', '20191128153145865.jpg');
INSERT INTO `eatwhat` VALUES ('19', '20191128153155761.jpg');
INSERT INTO `eatwhat` VALUES ('20', '20191128153206704.jpg');
INSERT INTO `eatwhat` VALUES ('21', '20191128153216946.jpg');

-- ----------------------------
-- Table structure for `hheasy`
-- ----------------------------
DROP TABLE IF EXISTS `hheasy`;
CREATE TABLE `hheasy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `HHtitle` varchar(255) DEFAULT NULL,
  `HHwriter` varchar(255) DEFAULT NULL,
  `HHcontains1` varchar(255) DEFAULT NULL,
  `HHtime` varchar(255) DEFAULT NULL,
  `imgurl` longtext,
  `HHtypeid` varchar(11) DEFAULT NULL,
  `HHcontains2` varchar(255) DEFAULT NULL,
  `HHcontains3` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hheasy
-- ----------------------------
INSERT INTO `hheasy` VALUES ('18', '高手过招，充满了火 药味儿', '笑哈哈', '', '2019-11-07', '20191128153502421.gif', '1', '', '');
INSERT INTO `hheasy` VALUES ('19', '岛国的榨汁机', '笑哈哈', '', '2019-11-16', '20191128153556648.gif', '1', '', '');
INSERT INTO `hheasy` VALUES ('20', '我命由我不由天', '深井冰', '', '2019-11-23', '20191128153628246.gif', '1', '', '');
INSERT INTO `hheasy` VALUES ('21', '宝宝乖', '哈哈笑', '', '2019-11-11', '20191128153756359.gif', '1', '', '');
INSERT INTO `hheasy` VALUES ('22', '这创意，我服，这个人，我XX！', '哈哈哈', '', '2019-11-16', '20191128153909759.gif', '1', '', '');
INSERT INTO `hheasy` VALUES ('23', '女票质疑男友的爱', '笑哈哈', '一对情侣在山中被野人抓住说：“你们吃掉对方的大便就放了你们。”情侣做到了，归途中女票大哭，男友问其原因。女票伤心的说：“你不爱我，不然你不会拉那么多。', '2019-11-15', '20191128154724756.gif', '2', '', '');
INSERT INTO `hheasy` VALUES ('24', '捡钱', '笑哈哈', '哥们儿我骑自行车回家，突然看到路上有一块钱，就下车去捡。刚抬头发现前方地上又有一块钱。直到捡了五块钱，没了，回头一瞅，自行车没了。', '2019-11-09', '20191128154901536.jpg', '2', '', '');
INSERT INTO `hheasy` VALUES ('25', '减肥', '笑哈哈', '这几天公司的妹子们都陷入减肥的痛苦中，有一妹子说：我觉得减肥是世界上最反人类的事情，你不吃饭吧就饿得想打人，吃了饭吧又想打自己。', '2019-11-03', '20191128155129134.jpg', '2', '', '');
INSERT INTO `hheasy` VALUES ('26', '你根本不懂', '笑哈哈', '  大学时，宿舍楼是一个局域网，很多人联机玩CS，以此为背景。有个人，起的名字叫陈小二，玩的很好，把对手打的很惨。游戏里不断显示出字幕： 陈小二用手枪杀了XXX 陈小二用刀捅死了XXX …… 谁知对方有个人怒了，改名为“他爹”。 一声枪响，字幕显示： 陈小二用狙击枪杀s了他爹…… 打这以后再打CS的时候，字幕不断出现： 陈小二用刀捅死了他爷爷 陈小二炸死了他姨姥姥 陈小二用手枪杀s了他二大爷........', '2019-11-07', '', '3', ' 最近有点干燥，去卫生间拉了半天也没拉出来，这是来了一个人，就听那边哗哗啦啦的很顺畅，我说：“哥们真羡慕你啊，拉的那么爽！那哥们来了句：“爽个B啊，劳资裤子还没来得急脱呢....”', '老师：“小明，假如我现在给你90元，然后你再去小红借10元，这样的话你共有多少钱？”小明：“0元。”老师气愤：“你丫根本就不懂数学！”小明：“老师，你根本不懂小红！！！！！”');
INSERT INTO `hheasy` VALUES ('27', '驾驶员的职业素养', '深井冰', '我是一个驾驶员，连着开车开了14个小时，累得不行了，下班回家就做了公交，不知不叫就睡着了，我睡觉的时候，公交车突然来了个急刹车，我被惊醒，非常熟练的做出了手握方向盘、右手换挡、右脚踩刹车的动作，把旁边坐着的哥们吓傻了都。。。。。', '2019-11-16', '', '3', '四个人由于打麻将打的太入迷了，以至于厨房着火了他们都没注意，邻居以为家里没人就报了119。消防人员赶到后大声的向屋里喊：“里面有没有人啊~！有多少人啊！！？？”正好一个人出牌：“四万！” 　　消防人员：“死了多少人啊~！” 　　又一个人出牌：“两万！” 　　消防人员大惊失色问：“那其他的人怎么样了啊！？” 　　只听屋里哗啦一声，接着传来一声大喊：“胡啦！”', '朋友接到心爱已久的女神电话，接通后女神说自己家里出事了，然后就一个劲儿的哭，也不说话。朋友安慰了三两句后见女神还是哭，于是gc部分来了 　　我玩完没想到他华丽丽地说：“你看你这样一直不说话，我就不浪费话费了啊，我先挂了啊。。。” 　　次奥~！！活该一辈子用手！');
INSERT INTO `hheasy` VALUES ('28', '惊呆了', '哈哈哈', '某个星期天很无聊，寝室里和几个哥们讨论什么话才能体现出咱们男人的霸气，大家七嘴八舌的讨论着，突然老四说出了一句直到现在还能令我颤抖不已的话：“TMD，咱就不能买个大点的套子吗~！？”记得当时全寝室的人都呆了...........', '2019-11-03', '', '3', '未婚妻在树下足足等了30分钟，未婚夫才赶来。她不高兴地问：“除了闹钟不响、电梯失灵、隧道堵车等理由外，你还能说出什么新的迟到的理由吗？”未婚夫想了想，说：“你来得太早了。', '坐在价值千万的车上，司机开着车飞奔着，我却无心欣赏沿途的风景。思绪万千，人活着到底是为了什么？财富真的那么重要吗？为什么自己会焦急，会忧虑。正沉思着，一抬头：我靠，地铁又坐过站了');

-- ----------------------------
-- Table structure for `music`
-- ----------------------------
DROP TABLE IF EXISTS `music`;
CREATE TABLE `music` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '图片和video对应的id',
  `picture` longtext COMMENT '歌曲对应的图片',
  `music` varchar(255) DEFAULT NULL COMMENT '对应的歌曲',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of music
-- ----------------------------
INSERT INTO `music` VALUES ('1', '20191120155357449.jpg', '相关的音乐1');
INSERT INTO `music` VALUES ('2', '20191120155357449.jpg', '相关的音乐2');
INSERT INTO `music` VALUES ('3', '20191120155357449.jpg', '相关的音乐3');
INSERT INTO `music` VALUES ('4', '20191120155357449.jpg', null);
INSERT INTO `music` VALUES ('5', '20191120155357449.jpg', null);
INSERT INTO `music` VALUES ('6', '20191120155357449.jpg', null);
INSERT INTO `music` VALUES ('7', '20191120155357449.jpg', null);

-- ----------------------------
-- Table structure for `schoolnews`
-- ----------------------------
DROP TABLE IF EXISTS `schoolnews`;
CREATE TABLE `schoolnews` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NewsTittle` varchar(255) DEFAULT NULL,
  `NewsAuthor` varchar(255) DEFAULT NULL,
  `NewsTime` varchar(255) DEFAULT NULL,
  `NewsContains` longtext,
  `NewsTypes` varchar(255) DEFAULT NULL,
  `imgurl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of schoolnews
-- ----------------------------
INSERT INTO `schoolnews` VALUES ('1', '标题1', '作者1', '2019/11/10', '会等深V服务岗佛前', '加分活动', '');
INSERT INTO `schoolnews` VALUES ('2', '标题2', '作者2', '2019/11/14', '岗瓦电源管委会短发还不好说i', '就业创业', null);
INSERT INTO `schoolnews` VALUES ('4', '山地独活改', '地衣', '2019-11-10', '华星化工常规是建行卡比较恐怖就恐怖', '1', null);
INSERT INTO `schoolnews` VALUES ('6', '111111', '1111111', '2019-11-23', '11111111111111', '就业创业', '20191121090156257.gif');

-- ----------------------------
-- Table structure for `schoolusers`
-- ----------------------------
DROP TABLE IF EXISTS `schoolusers`;
CREATE TABLE `schoolusers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `newuser` varchar(255) DEFAULT NULL,
  `usersid` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `useremail` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of schoolusers
-- ----------------------------
INSERT INTO `schoolusers` VALUES ('1', null, null, null, null);
INSERT INTO `schoolusers` VALUES ('2', '11', '22', '22', '33455@qq.com');
INSERT INTO `schoolusers` VALUES ('3', '11', '22', '22', '33455@qq.com');
INSERT INTO `schoolusers` VALUES ('4', '11', '22', '22', '33455@qq.com');
INSERT INTO `schoolusers` VALUES ('5', null, '11', '22', null);
INSERT INTO `schoolusers` VALUES ('6', null, '11', '22', null);
INSERT INTO `schoolusers` VALUES ('7', null, '11', '22', null);
INSERT INTO `schoolusers` VALUES ('8', null, '11', '22', null);
INSERT INTO `schoolusers` VALUES ('9', null, '22', '22', null);
INSERT INTO `schoolusers` VALUES ('10', null, '22', '22', null);
INSERT INTO `schoolusers` VALUES ('11', null, '11', '22', null);
INSERT INTO `schoolusers` VALUES ('12', '11', '2333', '22', '');
INSERT INTO `schoolusers` VALUES ('13', '123456', '123456', '123456', '123@qq.com');

-- ----------------------------
-- Table structure for `sw`
-- ----------------------------
DROP TABLE IF EXISTS `sw`;
CREATE TABLE `sw` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `swname` varchar(255) DEFAULT NULL,
  `swdescribe` varchar(255) DEFAULT NULL,
  `swplace` varchar(255) DEFAULT NULL,
  `swtel` varchar(255) DEFAULT NULL,
  `swqq` varchar(255) DEFAULT NULL,
  `swpicture` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sw
-- ----------------------------
INSERT INTO `sw` VALUES ('7', '钥匙', '一串钥匙，共有5把，今天早上拾到', '食堂', '1365553337666', '6491379491', '20191128093900022.png');
INSERT INTO `sw` VALUES ('8', '眼镜', '一副超级炫酷的眼镜，左边红色镜片，右边蓝色镜片，系我从未见过的船新款式', '操场', '158467349154', '369258144', '20191128094100037.png');
INSERT INTO `sw` VALUES ('9', '书', '小说听雪楼，封面有些烂掉了，子页有些发黄', '图书馆', '14725836694', '654987321', '20191128094200032.png');
INSERT INTO `sw` VALUES ('10', '水杯', '一个不锈钢水杯，上面刻有英文字母ZBL', '教室1203', '1472356942554', '246579813', '20191128094400004.png');

-- ----------------------------
-- Table structure for `sz`
-- ----------------------------
DROP TABLE IF EXISTS `sz`;
CREATE TABLE `sz` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `szname` varchar(255) DEFAULT NULL,
  `szdescribe` varchar(255) DEFAULT NULL,
  `szplace` varchar(255) DEFAULT NULL,
  `sztel` varchar(255) DEFAULT NULL,
  `szqq` varchar(255) DEFAULT NULL,
  `szpicture` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sz
-- ----------------------------
INSERT INTO `sz` VALUES ('7', '口红', '型号阿玛尼500，才用了一次 ，有好心人拾到请联系我', '教学楼6楼', '142555788787', '5484979494', '20191128095900058.png');
INSERT INTO `sz` VALUES ('8', '篮球', '用了很久了，表皮有些磨损', '厕所', '2584693572955', '55723655555', '20191128100100039.png');
INSERT INTO `sz` VALUES ('9', '', '', '', '', '', '20191128112700026.png');

-- ----------------------------
-- Table structure for `tbkuaidi`
-- ----------------------------
DROP TABLE IF EXISTS `tbkuaidi`;
CREATE TABLE `tbkuaidi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kuaididian` varchar(11) DEFAULT NULL,
  `ldh` varchar(255) DEFAULT NULL,
  `ceng` varchar(255) DEFAULT NULL,
  `zhongxing` varchar(255) DEFAULT NULL,
  `daxing` varchar(255) DEFAULT NULL,
  `jiawei` varchar(255) DEFAULT NULL,
  `tjtime` varchar(255) DEFAULT NULL,
  `islq` varchar(255) DEFAULT NULL,
  `iswc` varchar(255) DEFAULT NULL,
  `jifen` varchar(255) DEFAULT NULL,
  `meberid` varchar(255) DEFAULT NULL,
  `isfabu` varchar(255) DEFAULT NULL,
  `pingjia` varchar(255) DEFAULT NULL,
  `pxjf` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbkuaidi
-- ----------------------------
INSERT INTO `tbkuaidi` VALUES ('1', '1', '1', '1', '1', '1', '1', '1', '0', '2', '1', '1', '1', '1', '36.0');
INSERT INTO `tbkuaidi` VALUES ('4', '九栋1号店天天', 'C1', '1', '重型', '小型', '2', '2019-11-27 11:01', '0', '1', '32', '1', '1', null, '36.0');
INSERT INTO `tbkuaidi` VALUES ('5', '九栋1号店天天', 'C1', '1', '重型', '小型', '2', '2019-11-27 11:01', '1', '1', '232', '1', '1', null, '36.0');
INSERT INTO `tbkuaidi` VALUES ('6', '九栋1号店天天', 'C1', '1', '轻型', '小型', '', '2019-11-27 11:14', '1', '1', '11', '1', '1', null, '36.0');
INSERT INTO `tbkuaidi` VALUES ('7', '九栋1号店天天', 'C1', '1', '轻型', '小型', '', '2019-11-27 16:36', '0', '1', '2', '1', '1', null, '36.0');
INSERT INTO `tbkuaidi` VALUES ('8', '九栋1号店天天', 'C9', '1', '轻型', '小型', '2', '2019-11-27 16:39', '0', '1', '2', '1', '1', null, '36.0');
INSERT INTO `tbkuaidi` VALUES ('9', '九栋1号店天天', 'C6', '1', '重型', '大型', '2', '2019-11-28 09:33', '0', '1', '2', '1', '1', null, '36.0');
INSERT INTO `tbkuaidi` VALUES ('10', '九栋2号店', 'C1', '1', '重型', '小型', '，', '2019-11-28 09:34', '0', '1', '12', '1', '1', null, '36.0');

-- ----------------------------
-- Table structure for `tbtask`
-- ----------------------------
DROP TABLE IF EXISTS `tbtask`;
CREATE TABLE `tbtask` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `zhuti` varchar(255) DEFAULT NULL,
  `neirong` varchar(255) DEFAULT NULL,
  `shijian` varchar(255) DEFAULT NULL,
  `jifen` varchar(255) DEFAULT NULL,
  `islq` varchar(255) DEFAULT NULL,
  `iswc` varchar(255) DEFAULT NULL,
  `isfabu` varchar(255) DEFAULT NULL,
  `meberid` varchar(255) DEFAULT NULL,
  `necheng` varchar(255) DEFAULT NULL,
  `pingjia` varchar(255) DEFAULT NULL,
  `pxjf` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbtask
-- ----------------------------
INSERT INTO `tbtask` VALUES ('105', '晚上陪跑', '七点钟就开射手', '2019-11-27 11:00:32', '11', '1', '1', '1', '1', null, null, '40.0');
INSERT INTO `tbtask` VALUES ('106', '早上陪吃饭', '小笼包煎饺', '2019-11-27 11:01:03', '26', '0', '3', '1', '1', null, '哈哈哈呵呵呵', '40.0');
INSERT INTO `tbtask` VALUES ('107', '划划水就', '嘎嘎', '2019-11-27 11:04:18', '14', '0', '1', '1', '1', null, null, '40.0');
INSERT INTO `tbtask` VALUES ('108', '他刚刚', '好噶嘎嘎嘎', '2019-11-27 11:04:47', '11', '1', '3', '1', '1', null, null, '40.0');
INSERT INTO `tbtask` VALUES ('109', '的吗瞎喊', '除恶卡', '2019-11-27 11:05:35', '12', '1', '1', '1', '1', null, '发个', '40.0');
INSERT INTO `tbtask` VALUES ('110', '不会吧', '哈哈哈', '2019-11-27 16:22:54', '0', '0', '3', '1', '1', null, null, '40.0');

-- ----------------------------
-- Table structure for `tt`
-- ----------------------------
DROP TABLE IF EXISTS `tt`;
CREATE TABLE `tt` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ttmemberid` varchar(255) DEFAULT NULL,
  `ttname` varchar(255) DEFAULT NULL,
  `ttheadpicture` varchar(255) DEFAULT NULL,
  `tttime` varchar(255) DEFAULT NULL,
  `ttcontent` varchar(255) DEFAULT NULL,
  `ttdymaicpicture` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tt
-- ----------------------------
INSERT INTO `tt` VALUES ('16', '12', '邹博伦', '肖战', '2019-11-28 08:35:09', '早上好冷啊，完全起不来，想要睡到自然醒！！！', '20191128083500009.png');
INSERT INTO `tt` VALUES ('17', '12', '郭玲', '肖战', '2019-11-28 08:45:45', '与君远相知，不道云海深\n前面一句是什么来着？', '20191128084500045.png');
INSERT INTO `tt` VALUES ('18', '12', '陈熙文', '肖战', '2019-11-28 08:51:57', '【所有的离开都猝不及防，我们永远不知道明天和意外哪一个先来】2019所有的离开都猝不及防，无论花样年华还是桑榆暮景。最好的年华或定格在荧幕上、亦或尚未开始。2019，高以翔、具荷拉、崔雪莉...已经有很多明星、艺人和艺术家离开了我们。人生短似梦，匆匆告别后珍惜当下', '20191128085100057.png');
INSERT INTO `tt` VALUES ('19', '12', '陈跃', '肖战', '2019-11-28 08:52:48', '【#香港超5800人涉威胁公共安全被捕#】今日，香港保安局局长李家超表示，6月9日至11月21日，警方在大型公众活动中共拘捕超5800人，其中923人已被立案控告。另外，有超过2600人受伤送医，其中超过470人为警务人员。李家超强调，香港市民有表达意见、言论及集会的自由，但必须和平守法。', '20191128085200048.png');
INSERT INTO `tt` VALUES ('20', '12', '彭玲玲', '肖战', '2019-11-28 08:53:39', '祝千玺@TFBOYS-易烊千玺 19岁生日快乐 开心每一天！ ', '20191128085300039.png');
INSERT INTO `tt` VALUES ('30', '12', '彭秋铭', '肖战', '2019-11-28 09:17:01', '#感恩节#今天感恩节，我的最大愿望，就是父母身体健康', '20191128091700001.png');
INSERT INTO `tt` VALUES ('31', '12', '王磊', '肖战', '2019-11-28 09:18:03', '#神秘人21年捐款1155万# 既然人家不肯露面，还是不要去打扰了，尊重别人的选择，他看到新闻，也许只是会心的一笑，这么有善心的人，应该是一个有故事且又淡泊名利的人！ ​', '20191128091800003.png');
