/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50162
Source Host           : 127.0.0.1:3306
Source Database       : blog

Target Server Type    : MYSQL
Target Server Version : 50162
File Encoding         : 65001

Date: 2016-10-19 16:04:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_articles`
-- ----------------------------
DROP TABLE IF EXISTS `t_articles`;
CREATE TABLE `t_articles` (
  `articleId` varchar(17) NOT NULL,
  `name` varchar(50) NOT NULL,
  `content` text,
  `createTime` varchar(12) DEFAULT NULL,
  `updateTime` varchar(12) DEFAULT NULL,
  `tips` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`articleId`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_articles
-- ----------------------------
INSERT INTO `t_articles` VALUES ('100', '利用Nginx解决Ajax跨域问题', '使用Nginx代理服务器方式解决实际开发中Ajax请求的跨域问题\r\n\r\n这是最简单的解决方案示例，具体开发中可以根据不同的需求在此基础上去实现更加贴合开发需求的解决方案。\r\n\r\n提要：在实际开发中，由于前后端分离的需要，将后台web应用部署到服务器（Tomcat为例），而前端页面不与web应用耦合，另外部署到其他节点（本例中采用Nginx部署）这样就让后台专注于对外提供API接口，而在前端页面可以通过Ajax调用API接口获取相关的服务。前后端分离的好处就不过多赘述，主要简单介绍在这个过程中的ajax请求的跨域问题。\r\n\r\n原理：就是利用了Nginx作为代理服务器，将所有的请求啊应用部署地址啊等等等等都proxy到Nginx这里，也就是说这样一来就相当于前后端虽然部署的位置不同，但是经过代理服务器这么一折腾，就不属于跨域调用啦！\r\n\r\n下面开始吧！\r\n\r\n1. 关于web项目（项目命名为：chats-web）开发（主要关注注解@RequestMapping的value值）\r\n\r\n在开发web项目过程中，我采用了Spring+SpringMVC+Mybatis框架。通过SpringMVC的控制器设计api接口。 具体APIs接口示例代码如下：\r\n\r\n    @RequestMapping(\"/test.json\")\r\n    public @ResponseBody APIResult test(HttpServletRequest req, HttpServletResponse rsp) {\r\n        APIResult result = APIResult.prepare();\r\n        Map<String, String> map = new HashMap<>();\r\n        map.put(\"name\", \"DavidBeckham\");\r\n        map.put(\"age\", \"35\");\r\n        map.put(\"team\", \"Man United\");\r\n        map.put(\"time\", new Date().toString());\r\n        return map != null ? result.ok(map) : result.error(\"failure..\");\r\n    }\r\n2. 关于前端项目（项目命名为：portal）开发（主要关注Ajax请求的URL参数）\r\n\r\n在portal项目开发中，主要是使用HTML+JS/jQuery开发。其中一个页面的调用设计如下：\r\n\r\nfunction ajaxReq() {           \r\n        var url=\"/chats-web/test.json\";\r\n        var oData = document.getElementById(\'data\');\r\n        $.getJSON(url, function (json) {                                \r\n            oData.innerHTML = \"name:\" + json.result.name + \"; team:\" + json.result.team;\r\n        });\r\n}\r\n通过上述的前后端项目开发，如果将两个项目分离部署，显然存在一个ajax请求的跨域问题。有一种解决方法是JSONP，但是这个方法的缺点是只能使用GET的请求方式。\r\n\r\n于是所以我们采用另外的一种解决方案：代理服务器解决方案（在此使用Nginx作为代理服务器）。\r\n\r\n3. 关于Nginx配置部署chats-web应用和portal应用并且解决Ajax跨域问题的方法\r\n\r\n3.1 chats-web应用部署\r\n\r\n我们将chats-web应用部署在tomcat服务器的8080端口，使用war部署就行啦。\r\n\r\n3.2 portal应用部署\r\n\r\nportal应用就是静态页面而已，通过调用api接口去渲染页面。所以将portal项目放在一个本地目录中。本例中放在：/home/hankchan101/html/chats-portal中。 注意index页面实际目录为：/home/hankchan101/html/chats-portal/portal/index.html。\r\n\r\n3.3 配置Nginx\r\n\r\n完成两个项目的部署之后，就可以开始配置Nginx的配置文件啦。 nginx.conf配置文件关键内容如下：\r\n\r\n#配置反向代理的地址\r\nupstream chats-web {\r\n    server 192.168.154.162:8080;\r\n}       \r\n\r\nserver {\r\nlisten   80;\r\nserver_name  192.168.154.162;                       \r\n    root /home/hankchan101/html/chats-portal;   \r\n\r\n    #将所有请求都转到portal项目所在路径\r\n    location / {  \r\n        root /home/hankchan101/html/chats-portal;  \r\n    }\r\n\r\n    #将/chats-web开头的请求（API接口调用的请求）配置反向代理\r\n    location /chats-web {       \r\n        proxy_pass http://chats-web;          \r\n    }\r\n    #略\r\n    #略\r\n}\r\nBingo！最简单的示例解决方案完成！\r\n\r\n虽然现在看起来很简单，其实也是费了不少时间Google了好久爬了好半天坑才解决的。总算是对自己有个交代哈哈哈', '201610162300', '201610162300', '测试格式的文章');
INSERT INTO `t_articles` VALUES ('101', '测试文章', '这是一个测试文章内容', '201610171015', '201610171015', '无');
INSERT INTO `t_articles` VALUES ('123', 'biaotiya', 'neirongya', '20161018', '20161018', 'null');
INSERT INTO `t_articles` VALUES ('201210', 'testTitle', 'Text', '201210', '201210', 'null');
INSERT INTO `t_articles` VALUES ('201211', 'testTitle', 'Text', '201210', '201210', 'null');
INSERT INTO `t_articles` VALUES ('404', 'test', 'test', '201210', '201210', 'null');
