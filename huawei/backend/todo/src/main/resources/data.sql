insert into user(id,username,password)
values(1004,'erman','$2a$10$zTGH0tDFQLSLr94COtbLyuVTKBsUZvCoRhmW6I4VtLx94.TVDTj0i');

insert into user(id,username,password)
values(1005,'esra','esra');


insert into todo(id,description,target_date,is_done,user_id)
values(1001,'Register Component',sysdate(),false,1004);

insert into todo(id,description,target_date,is_done,user_id)
values(1002,'Dynamic Atuhentication',sysdate(),false,1004);

insert into todo(id,description,target_date,is_done,user_id)
values(1003,'Formik Operations',sysdate(),false,1005);
