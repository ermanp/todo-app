insert into user(id,username,password)
values(1004,'erman','erman');

insert into user(id,username,password)
values(1005,'esra','esra');


insert into todo(id,description,target_date,is_done,user_id)
values(1001,'Learn JPA',sysdate(),false,1004);

insert into todo(id,description,target_date,is_done,user_id)
values(1002,'Learn Hibernate',sysdate(),false,1004);

insert into todo(id,description,target_date,is_done,user_id)
values(1003,'Learn Spring',sysdate(),false,1005);

