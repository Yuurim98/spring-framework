insert into user_details(id, birth_date, name)
values(1001, current_date, '홍길동');

insert into user_details(id, birth_date, name)
values(1002, current_date, '김길동');

insert into user_details(id, birth_date, name)
values(1003, current_date, '이길동');

insert into post(id, description, user_id)
values(2001, 'AWS 공부하기', 1001);

insert into post(id, description, user_id)
values(2002, 'JPA 공부하기', 1001);

insert into post(id, description, user_id)
values(2003, '김치찌개 먹기', 1002);