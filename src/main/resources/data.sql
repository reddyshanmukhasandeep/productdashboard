USE productsdb;

INSERT INTO User (uid,user_name,password) VALUES(1,'user','pwd');
INSERT INTO User (uid,user_name,password) VALUES(2,'admin','admin');
INSERT INTO User (uid,user_name,password) VALUES(3,'sandy','sandy');
INSERT INTO User (uid,user_name,password) VALUES(4,'pwd','pwd');

INSERT INTO Products(pid,name,description,url) 
VALUES(1,"oracle","a comprehensive and fully integrated stack of cloud applications","https://www.oracle.com/webfolder/s/brand/assets/i/specimens/identity/logo/primary-badge.gif");
INSERT INTO Products(pid,name,description,url)
 VALUES(2,"google","American multinational technology company that specializes in Internet-related services and products","https://pbs.twimg.com/profile_images/972154872261853184/RnOg6UyU.jpg");
INSERT INTO Products(pid,name,description,url)
 VALUES(3,"pivotal","Pivotal Labs consulting servicesPivotal Cloud Foundry, and a group developing big data products","https://image4.owler.com/logo/pivotal_owler_20160228_012833_original.png");
 INSERT INTO Products(pid,name,description,url)
 VALUES(4,"bluemix","a cloud platform as a service developed by IBM. It supports several programming languages and services as well as integrated DevOps ","https://upload.wikimedia.org/wikipedia/commons/thumb/c/c7/IBM_Bluemix_logo.svg/1036px-IBM_Bluemix_logo.svg.png");