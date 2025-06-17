#######################################
# phonebook 만들기
#######################################

-- ----------------------------------------------------
# phonebook 계정에서 실행
-- ----------------------------------------------------
-- db 선택
use phonebook_db;

-- 테이블 생성
create table person(
		person_id    int                primary key   auto_increment,
        name          varchar(30)   not null,
		hp      		  varchar(20),
        company     varchar(20)
);


-- 테이블 삭제
drop table person;

-- 테이블 조회
select * from person;



select	person_id
			,name
            ,hp
            ,company
from person
order by person_id desc;

-- 등록
insert into person
values(null, '정우성', '010-9090-8989', '02-437-9576')
;

insert into person
values(null, '이효리', '010-2222-2222', '02-222-2222')
;

insert into person
values(null, '이상순', '010-3333-3333', '02-333-3333')
;

-- 수정
update person
set name = '정재형',
	 hp = '010-1111-1111',
     company = '02-111-1111'
where person_id = 1
;

-- 삭제
delete from  person
where person_id = 1
;
