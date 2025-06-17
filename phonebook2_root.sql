#######################################
# phonebook 만들기
#######################################

-- ----------------------------------------------------
# root 계정에서 실행
-- ----------------------------------------------------
-- phonebook 계정생성
create user 'phonebook'@'%' identified by 'phonebook';

-- phonebook 권한부여
grant all privileges on phonebook_db.* to 'phonebook'@'%';

-- phonebook_db 생성
create database phonebook_db
   default character set utf8mb4
    collate utf8mb4_general_ci
    default encryption='n'
   
   