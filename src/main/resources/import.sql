INSERT INTO category_table (id,name) values (1, 'Fiction');
INSERT INTO category_table (id,name) values (2, 'Science');
INSERT INTO category_table (id,name) values (3, 'Thriller');
INSERT INTO category_table (id,name) values (4, 'Mystery');
INSERT INTO category_table (id,name) values (5, 'General');

INSERT INTO role_table (id,name) values (1, 'Admin');
INSERT INTO role_table (id,name) values (2, 'User');


INSERT INTO book (book_id,title,author,category_Id) values (1,'Da Vinci Code,The','Brown, Dan',3);
INSERT INTO book (book_id,title,author,category_Id) values (2,'Harry Potter and the Deathly Hallows','Rowling, J.K.',1);
INSERT INTO book (book_id,title,author,category_Id) values (3,'Harry Potter and the Philosopher''s Stone','Rowling, J.K.',1);
INSERT INTO book (book_id,title,author,category_Id) values (4,'Harry Potter and the Order of the Phoenix','Rowling, J.K.',1);
INSERT INTO book (book_id,title,author,category_Id) values (5,'Lovely Bones,The','Sebold, Alice',5);

INSERT INTO user (user_id,user_name,password, role_id) values (1, 'saurabh57','password',2); 

INSERT INTO user_activity_log (log_id,user_id,book_id,borrow_date,return_date,charge) values(1,1,1,2021-04-10,NULL,0);
INSERT INTO user_activity_log (log_id,user_id,book_id,borrow_date,return_date,charge) values(2,1,2,2021-05-01,NULL,0);
INSERT INTO user_activity_log (log_id,user_id,book_id,borrow_date,return_date,charge) values(3,1,3,2021-05-12,NULL,0);