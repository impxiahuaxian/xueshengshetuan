/*
Navicat MySQL Data Transfer

Source Server         : localhost_3323
Source Server Version : 50022
Source Host           : localhost:3323
Source Database       : shetuan

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2015-10-15 14:35:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_admin`
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `userId` int(11) NOT NULL auto_increment,
  `userName` varchar(255) default NULL,
  `userPw` varchar(255) default NULL,
  PRIMARY KEY  (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', 'a', 'a');

-- ----------------------------
-- Table structure for `t_baoming`
-- ----------------------------
DROP TABLE IF EXISTS `t_baoming`;
CREATE TABLE `t_baoming` (
  `id` int(11) NOT NULL auto_increment,
  `huodong_id` int(11) default NULL,
  `sheyuan_id` int(255) default NULL,
  `lianxifangshi` varchar(255) default NULL,
  `beizhu` varchar(255) default NULL,
  `baomingshi` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_baoming
-- ----------------------------
INSERT INTO `t_baoming` VALUES ('1', '2', '2', '13222222222', '我想参加', '2015-10-19 22:05');

-- ----------------------------
-- Table structure for `t_huodong`
-- ----------------------------
DROP TABLE IF EXISTS `t_huodong`;
CREATE TABLE `t_huodong` (
  `id` int(11) NOT NULL auto_increment,
  `shetuan_id` int(11) default NULL,
  `biaoti` varchar(50) default NULL,
  `neirong` varchar(255) default NULL,
  `shijian` varchar(255) default NULL,
  `didian` varchar(255) default NULL,
  `lianxiren` varchar(255) default NULL,
  `lianxihua` varchar(255) default NULL,
  `fujian` varchar(255) default NULL,
  `fujianYuanshiming` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_huodong
-- ----------------------------
INSERT INTO `t_huodong` VALUES ('2', '2', '参加市文艺团的文艺演出', '参加市文艺团的文艺演出', '2015-10-19', '市立大剧院', '李工仁', '13222222222', '/upload/1395140469593.zip', '附件.zip');
INSERT INTO `t_huodong` VALUES ('3', '2', '2015元旦校区双节棍比赛', '2015元旦校区双节棍比赛', '2015-10-19', '本校体育场', '李光亮', '13222222222', '/upload/1395140469593.zip', '附件.zip');
INSERT INTO `t_huodong` VALUES ('6', '2', '翻绳之松树叶', '一、唱团歌：《翻花绳》<br />\r\n<wbr></wbr>二、复习：高压线塔、降落伞、、魔法扫把。<br />\r\n<wbr></wbr>三、学习：松树叶<br />\r\n四、欣赏儿歌：能干的扫帚', '2015-10-19', '本校体育场', '孙德胜', '13222222222', '/upload/1395140469593.zip', '附件.zip');
INSERT INTO `t_huodong` VALUES ('7', '2', '翻绳之嘴巴', '一、唱团歌：《翻花绳》<br />\r\n二、复习：高压线塔、降落伞、、魔法扫把、松树叶<br />\r\n三、学习：翻嘴巴<br />', '2015-10-19', '本校体育场', '孙德胜', '13222222222', '', '');
INSERT INTO `t_huodong` VALUES ('8', '2', '翻绳之五角星', '一唱团歌：《翻花绳》<br />\r\n二、复习：高压线塔、降落伞、、魔法扫把、松树叶嘴巴。<br />\r\n三、学习翻五角星。<br />', '2015-10-19', '本校体育场', '孙德胜', '13222222222', '', '');

-- ----------------------------
-- Table structure for `t_liuyan`
-- ----------------------------
DROP TABLE IF EXISTS `t_liuyan`;
CREATE TABLE `t_liuyan` (
  `id` int(11) NOT NULL,
  `neirong` varchar(500) default NULL,
  `liuyanshi` varchar(55) default NULL,
  `sheyuanId` int(11) default NULL,
  `huifu` varchar(500) default NULL,
  `huifushi` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_liuyan
-- ----------------------------
INSERT INTO `t_liuyan` VALUES ('1', '11111111111', '2015-10-19 17:17', '2', '', '');
INSERT INTO `t_liuyan` VALUES ('2', '1饿的人人人人人人人人人人人人人人人人', '2015-10-19 22:05', '2', '111111111', '2015-10-19 22:05');

-- ----------------------------
-- Table structure for `t_shetuan`
-- ----------------------------
DROP TABLE IF EXISTS `t_shetuan`;
CREATE TABLE `t_shetuan` (
  `id` int(11) NOT NULL auto_increment,
  `mingcheng` varchar(255) default NULL,
  `jieshao` varchar(5000) default NULL,
  `lishijian` varchar(255) default NULL,
  `fuzeren` varchar(255) default NULL,
  `loginname` varchar(255) default NULL,
  `loginpw` varchar(255) default NULL,
  `del` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_shetuan
-- ----------------------------
INSERT INTO `t_shetuan` VALUES ('2', '吉他协会', '吉他协会成立于2001年，是一个老牌社团，现有会员73人。在院学生活动中心配有专业的音乐器材，而且拥有一个属于会员自己的乐队。每年都会有很多吉他爱好者报名加入，由是来自北京现代音乐学院的赵小明老师传授专业的吉他知识及弹奏技能培训。本协会的特色活动是&ldquo;摇滚之夜&rdquo;、&ldquo;疯狂弹唱&rdquo;等', '2001-12-12', '李光明', 'liguang', '000000', 'no');
INSERT INTO `t_shetuan` VALUES ('3', '美食DIY协会', '<p align=\"left\">美食DIY协会成立于2009年，现有会员162人。本协会以其独特的活动方式为更多的同学提供了解美食，自己动手制作美食的机会。平日协会开展一些视屏教学和美食研制等活动，其中以&quot;巧食巧客&quot;美食制作最具特色。为学生的个性张扬、突出潜能开发等方面提供了广阔的舞台和展现自我的机会。<wbr></wbr></p>', '2009-12-01', '王刚海', 'wanggan', '000000', 'no');
INSERT INTO `t_shetuan` VALUES ('4', '动漫协会', '<p align=\"left\">动漫协会成立于2006年，是一个人气社团，现在会员有144人。协会会员聚在一起写剧本、彩排，定期举办漫画展览会、cosplay等活动，并在活动中不断完善自身，不断健全社团风气。曾代表学校多次参加校外比赛以及国际动漫节等活动，cosplay每次都能引来观众们的注目。本协会为一群爱好动漫的朋友们开创了一片天地，为有才的朋友提供各种机会。</p>', '2006-12-01', '张大海', 'zhangha', '000000', 'no');
INSERT INTO `t_shetuan` VALUES ('5', '反邪教协会', '<p align=\"left\">反邪教协会成立于2004年，协会会员以反邪教为主要学习目标。积极学习理论知识，并参加实践活动。平日里协会主要以开讲座、上课等一些基本教育。当然本协会也有属于自己的特色活动，如理论知识大比拼、教育讲座等。</p>', '2004-12-01', '李三明', 'lisanm', '000000', 'no');
INSERT INTO `t_shetuan` VALUES ('6', '邓小平研究协会', '<p align=\"left\">邓小平研究协于建校的第二年(2001年)成立，协会会员以邓小平理论、&ldquo;三个代表&rdquo;重要思想、科学发展观为指导思想，以理论研究为阵地，时事政治为依托，用中国特色社会主义理论体系武装自己。平时，协会主要以展开学术研究、理论知识、社会实践、座谈研讨为主要形式展开社团活动，从而加强校内学生的思想道德建设。</p>', '2003-12-01', '赵明明', 'zhaomin', '000000', 'no');
INSERT INTO `t_shetuan` VALUES ('7', '书法协会', '<p align=\"left\">书法协会成立于2003年，现有会员64人。协会的点点墨香带你畅游中国悠久文字的乐趣，这里的滴滴情谊也撑起你我友谊的蓝天。会员们可以在这里享受书画练习、书画展演等乐趣，&ldquo;高校书画展&rdquo;是文人书画家的殿堂，这里汇集着众多的精英们，可以陶冶人的情操，汇集着众人们的智慧。</p>', '2005-12-01', '王明举', 'wangmin', '000000', 'no');
INSERT INTO `t_shetuan` VALUES ('8', '旅游协会', '<p align=\"left\">旅游协会成立于2003年，现有会员138人。会员们通过对世界各地旅游名景进行宣传介绍展示，旅游人文讲座来丰富自己的业余生活，并组织会员进行一些&ldquo;短途旅行&rdquo;、&ldquo;素质拓展&rdquo;、&ldquo;攀登高峰&rdquo;等会员们喜闻乐见的活动，在学生心目中具有一定的影响力。</p>', '2006-12-01', '孙武斌', 'sunwum', '000000', 'no');

-- ----------------------------
-- Table structure for `t_sheyuan`
-- ----------------------------
DROP TABLE IF EXISTS `t_sheyuan`;
CREATE TABLE `t_sheyuan` (
  `id` int(11) NOT NULL,
  `shetuan_id` int(11) default NULL,
  `xuehao` varchar(50) default NULL,
  `xingming` varchar(50) default NULL,
  `xingbie` varchar(50) default NULL,
  `nianling` varchar(50) default NULL,
  `banji` varchar(50) default NULL,
  `loginpw` varchar(255) default NULL,
  `del` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sheyuan
-- ----------------------------
INSERT INTO `t_sheyuan` VALUES ('2', '2', '2015001', '刘三', '男', '21', '计算机专业一班', '000000', 'no');
INSERT INTO `t_sheyuan` VALUES ('3', '2', '2015002', '赵刚', '男', '23', '计算机专业一班', '000000', 'no');
INSERT INTO `t_sheyuan` VALUES ('4', '2', '2', '2', '男', '2', '2', '000000', 'yes');

-- ----------------------------
-- Table structure for `t_xinwen`
-- ----------------------------
DROP TABLE IF EXISTS `t_xinwen`;
CREATE TABLE `t_xinwen` (
  `id` int(11) NOT NULL auto_increment,
  `shetuan_id` int(11) default NULL,
  `biaoti` varchar(50) default NULL,
  `neirong` varchar(5000) default NULL,
  `shijian` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_xinwen
-- ----------------------------
INSERT INTO `t_xinwen` VALUES ('2', '2', '我校举办第二届(2015年)“棋王”争霸赛', '&ldquo;楚河汉界一线分，炮马兵将格中行&rdquo;，象棋和五子棋作为中国传统文化项目具有独特的魅力，在小小的棋盘上调兵遣将、指点江山凝聚了下棋者极大地智慧。　2013年11月14日，我们迎来了第二届(2013年)棋王争霸赛。本次比赛由校团委主办、校社团联合会、棋艺协会承办，本次比赛共分为三个棋种：象棋、五子棋、跳棋，共吸引了300多位同学参赛。学校党委书记覃建琪观看了比赛，给队员带上了温馨的祝福。<br />\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 此次大赛分为团体赛和个人赛，两项比赛同时进行。比赛正式开始，在裁判长解说完比赛规则后，选手们很快进入了状态，聚精会神的端坐在棋前。似乎任何凡尘琐事都与其无关，其已置身事外。无论团体或个人赛，都让我们看得惊叹：原来下棋也能下到如此境界，谁也不知道下一步棋会往哪儿走；但是选手们却泰然自若，丝毫不受对方影响，集中精力的奋战着。经过激烈的&ldquo;战争&rdquo;，剩下二分之一的选手们晋级到了下一轮的决赛。<br />\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 据悉，第二届(2013年)棋王争霸赛将陆续开展五子棋、跳棋比赛。我校社团联合会也将组织各个社团在近期举办精品社团展示活动，更多精彩社团活动，敬请期待吧！<br />\r\n<br />', '2015-10-19 16:52');
INSERT INTO `t_xinwen` VALUES ('3', '2', '我校第十届校园科技文化艺术节隆重开幕', '<p>科技创造奇迹，文化承载希望，艺术放飞理想。为营造浓厚的校园科技文化艺术氛围，5月13日晚，以&ldquo;同铸复兴路，共圆中国梦&rdquo;为主题的第十届校园科技文化艺术节在足球场开幕。学校党委书记覃建琪，副校长廖庆智、莫创才以及各中层部门负责人、相关企业代表和全校师生共6000人参加了开幕式。党委书记覃建琪，宣布第十届校园科技文化艺术节开幕。&ldquo;朝起早，夜眠迟，老易至，惜此时&hellip;&hellip;&rdquo;身着古代汉服的学生，化身为古代中国摇头晃脑的学生，在老夫子的带领下诵读国学经典《弟子规》，重温简单而深刻的教导，指导石化学子规范言行方。&ldquo;这是我的梦，这也是我的梦，这是我们的中国梦&hellip;&hellip;&rdquo;师生共同演绎，激情洋溢、饱含感情地朗诵《中国梦》，传递出了石化师生谨记历史、筑造中国梦、共铸辉煌明天的心声。</p>\r\n<p>侯舒琦同学演唱的《说唱脸谱》，时而尽显大气，时而俏皮可爱，时而欢快动听，听起来朗朗上口，亦歌亦戏，现场的观众感受到了京剧唱腔与流行音乐旋律的巧妙结合。《苗族健身操》给晚会带来了浓浓地民族风，为晚会锦上添花。身着亮丽耀眼苗族家服装的姑娘们，舞动着矫健柔和的身姿，跳着欢快活泼的舞蹈，别具风情，一出场就引起观众一阵喝彩。小组朗诵《石化起航》以饱含对学校、老师、同学的一片深情与祝福，道出了莘莘石化学子把学习工作与学校的示范校建设紧密联系在一起，不断开拓进取，扬帆起航，共同谱写石化新的华章。《羽&middot;翼服装秀展示》的服装设计体现了环保的理念，展示了各异的折扇造型，变化多端的结构，精心设计的线条，细致的分割妩媚感。这是信息与服务应用技术系服装设计与制作专业的学生所设计的服装，体现了丰富的层次感和传统的文化底蕴。<br />\r\n&nbsp;</p>', '2015-10-19 16:52');
INSERT INTO `t_xinwen` VALUES ('4', '2', '第四届学生社团联合会才艺展示晚会成功举行', '<p>2013年12月10日晚，由我校团委主办，学生社团联合会和各学生社团共同承办的第四届学生社团联合会才艺展示晚会在学校足球场隆重举行。学校党委书记副书记纪委书记蒋祖国，副校长莫创</p>\r\n<p>才等学校领导，学校各中层部门领导，以及现场近5000名师生共同观看晚会。<br />\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 广西机电职业学院、广西理工学校、广西轻工高级技工学校、广西纺织工业学校、广西华侨学校、广西银行学校、广西交通运输学校、南宁技工学校、中南理工职业技术学校 等兄弟</p>\r\n<p>院校的师生代表60多人到晚会现场指导。<br />\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 晚会始终将&ldquo;才艺展示&rdquo;的精神内涵贯穿全场，融合了各个社团的特色并兼顾专业学习。在吉它协会《 只有音乐才是我的解药 》的激情演绎中拉开帷幕，唱出青春无悔，弹奏美丽</p>\r\n<p>人生，点燃了晚会的热烈气氛。随之，由校记者团的记者表演的小品《新闻乱播》，用一种幽默诙谐的视角生动诠释一种另类新闻联播，让观众捧腹喷饭，笑不拢嘴。手工社和礼韵模特社表</p>\r\n<p>演的《茉莉花》集结由全区模特大赛一二等奖获得者担当模特的同学，展示富有创意搭配的服装和手艺作品，散发一种时尚与自然，青春与活力的清新气息。<br />\r\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 晚会上，广播站同学表演《新广播体操》，健美操协会同学表演《活力无限》，书画协会同学表演《书画表演》，电影协会同学演泽了《荆轲刺秦王前传》，吾道社同学表演《跆拳道</p>\r\n<p>》，校学生会演唱了《父亲》，化学系学生会同学表演小品《心理健康医生》，英语协会同学表演歌伴舞《power dance》，拳击社表演《拳皇》，摄影协会同学演唱了《我们都是好孩子》赢</p>\r\n<p>得现场观众的阵阵掌声。紧接着，街舞社选送的街舞《Craeg tempo》，在最炫的舞蹈，富有节奏感的爆点，将晚会推向高潮，晚会最后由美之声声乐协会小合唱《孤独的牧羊人》拉下帷幕，</p>\r\n<p>题材乐观积极向上，唱出了广西石化高级技工学校学生社团联合会学生干部团结友爱的品质。随后主持人宣布晚会落幕，观众在依依不舍中离场。</p>', '2015-10-19 16:53');
INSERT INTO `t_xinwen` VALUES ('6', '2', '33333333', '333333333333333333333333', '2015-10-20 14:33');
