use mybatis;

insert  into `user`(`id`,`username`,`birthday`,`sex`,`address`) 
values (1,'arvin',NULL,'2',NULL),
(10,'tom','2014-07-10','1','BJ'),
(16,'jerry',NULL,'1','HN'),
(22,'tonny',NULL,'1','SD'),
(24,'jessica',NULL,'1','SX'),
(25,'siemens',NULL,'1','DL'),
(26,'ken',NULL,NULL,NULL);

insert  into `orders`(`id`,`user_id`,`number`,`createtime`,`note`) 
values (3,1,'1000010','2015-02-04 13:22:35',NULL),
(4,1,'1000011','2015-02-03 13:22:41',NULL),
(5,10,'1000012','2015-02-12 16:13:23',NULL);

insert  into `items`(`id`,`name`,`price`,`detail`,`pic`,`createtime`) 
values (1,'thinkpad',3000.0,'good',NULL,'2019-08-03 13:22:53'),
(2,'tv',6000.0,'good',NULL,'2019-08-01 13:22:57'),
(3,'phone',90000.0,'good',NULL,'2019-08-06 13:23:02');

insert  into `orderdetail`(`id`,`orders_id`,`items_id`,`items_num`) 
values (1,3,1,1),(2,3,2,3),(3,4,3,4),(4,4,2,3);




