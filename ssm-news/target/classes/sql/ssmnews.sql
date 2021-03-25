show tables ;

#########
# 角色表 #
#########
create table role(
                     roleId int primary key comment '角色id',
                     roleName varchar(20) comment '角色名称'
)comment '角色表';

insert into role
values (1, '管理员'),
       (2, '信息员');

select *
from role;

#########
# 用户表 #
#########
create table user(
                     userId int primary key auto_increment comment '用户id',
                     userName varchar(20) comment '用户名',
                     loginName varchar(20) comment '登陆账号',
                     password varchar(20) comment '密码',
                     tel varchar(50) comment '联系电话',
                     registerTime datetime comment '注册时间',
                     status char(1) comment '注册状态，1：未启用；2：已启用；3：被禁用',
                     roleId int comment '角色id，外键',
                     foreign key (roleId) references role(roleId)
)comment '用户表';

insert into user(userName, loginName, password, tel, registerTime, status, roleId)
VALUES ('李华', 'lihua', '123456', '13677778888', now(), '2', '1');

select * from user;

#############
# 新闻类别表 #
############
create table category(
                         categoryId int primary key comment '类别id',
                         categoryName varchar(20) comment '类别名称'
)comment '新闻类别表';

insert into category
values (1, '今日头条'),
       (2, '综合资讯'),
       (3, '国际新闻'),
       (4, '国内新闻');

select * from category;

#########
# 新闻表 #
#########

create table news(
                     newsId int primary key auto_increment comment '新闻id',
                     title varchar(60) comment '信息标题',
                     contentTitle varchar(120) comment '信息内容标题',
                     titlePicUrl varchar(120) comment '标题信息图（路径）',
                     content text comment '信息内容',
                     contextAbstract varchar(300) comment '内容摘要',
                     keywords varchar(100) comment '关键词',
                     author varchar(30) comment '作者/来源',
                     publishTime datetime comment '发布时间',
                     clicks int comment '浏览次数',
                     publishStatus char(1) comment '发布状态，1：发布；2：撤稿',
                     categoryId int comment '信息类别，外键',
                     userId int comment '发布用户id',
                     foreign key (categoryId) references category(categoryId),
                     foreign key (userId) references user(userId)
)comment '新闻表';

select * from news;