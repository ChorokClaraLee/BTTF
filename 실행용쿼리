/*
 *	전체 실행용 쿼리
 *	Alt + X
 * 
 */
DROP SEQUENCE css_seq;
DROP SEQUENCE css_reply_seq;
DROP SEQUENCE ann_seq;


CREATE SEQUENCE css_seq
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE css_reply_seq
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE ann_seq
START WITH 1
INCREMENT BY 1;

SELECT * FROM user_all ;

-- 0. 권한 테이블
CREATE TABLE authority(
authority_code		number(1) DEFAULT 1 PRIMARY KEY ,
						CONSTRAINT authority_check check (authority_code BETWEEN 0 AND 1),
authority_name 		varchar2(100) DEFAULT 'admin' unique
);
--DROP TABLE authority;

DROP TABLE announcements;
--SELECT * FROM announcements;

INSERT INTO announcements VALUES (ann_seq.nextval, '테스트', 'test', 'admin', 1, sysdate);

-- 회원관리 테이블
CREATE TABLE user_all(
user_id 			varchar2(100) PRIMARY KEY,
user_pw 			varchar2(100) NOT NULL,
user_name 			varchar2(100) NOT NULL,
user_phone 			varchar2 (11) NOT NULL,
user_email			varchar2(100) NOT NULL,
main_language 		varchar2(100),
-- user_ava(0)인 경우 사용 불가, (1)인 경우 사용 가능
user_available		number(1) DEFAULT 1 CONSTRAINT user_ava check (user_available BETWEEN 0 AND 1),
user_reported 		number(1),
post_id				number(10),
reply_id			number(10),
user_regdate		DATE default sysdate,
authority_code 		number(1) DEFAULT 1,
					CONSTRAINT authority_code_fk FOREIGN KEY(authority_code) REFERENCES authority(authority_code)
);

-- 명예의 전당 테이블
CREATE TABLE honorary(
user_id				varchar2(100) PRIMARY KEY,
					CONSTRAINT honorary_fk FOREIGN KEY(user_id) REFERENCES user_all(user_id),
post_recommend 		varchar2(5)
);

--1. 오라클 게시판
CREATE TABLE oracle(
post_id 			number(10) PRIMARY KEY,
post_subject 		varchar2(200) NOT NULL,
post_contents 		varchar2(4000) NOT NULL,
user_id				varchar2(100),
					CONSTRAINT oracle_hono FOREIGN KEY(user_id) REFERENCES honorary(user_id),
					CONSTRAINT oracle_user FOREIGN KEY(user_id) REFERENCES user_all(user_id),
-- post_ava(0)인 경우 사용 불가, (1)인 경우 사용 가능
post_available		number(1) DEFAULT 1 CONSTRAINT oracle_ava check (post_available BETWEEN 0 AND 1),
writer				varchar2(100) ,
post_rec			varchar2(5),
post_vcount 		number(5) DEFAULT 1,
post_regdate 		DATE DEFAULT SYSDATE,
post_reported		NUMBER(1) DEFAULT 0 CONSTRAINT ora_reported check (post_reported BETWEEN 0 AND 1)
);

--1-1. 오라클 댓글
CREATE TABLE reply_oracle(
reply_id			number(10) PRIMARY KEY,
reply_contents		varchar2(1000) NOT NULL,
user_id				varchar2(100),
replyer				varchar2(100) ,
reply_regdate		DATE DEFAULT SYSDATE,
post_id				NUMBER(10) NOT NULL,
					CONSTRAINT rep_oracle FOREIGN KEY(post_id) REFERENCES oracle(post_id) ON DELETE cascade
);

--2. java 게시판
CREATE TABLE java(
post_id 			number(10) PRIMARY KEY,
post_subject 		varchar2(200) NOT NULL,
post_contents 		varchar2(4000) NOT NULL,
user_id				varchar2(100),
					CONSTRAINT java_hono FOREIGN KEY(user_id) REFERENCES honorary(user_id),
					CONSTRAINT java_user FOREIGN KEY(user_id) REFERENCES user_all(user_id),
post_available		number(1) DEFAULT 1 CONSTRAINT java_ava check (post_available BETWEEN 0 AND 1),
writer				varchar2(100) ,
post_rec			varchar2(5),
post_vcount 		number(5) DEFAULT 1,
post_regdate 		DATE DEFAULT SYSDATE,
post_reported		NUMBER(1) DEFAULT 0 CONSTRAINT java_reported check (post_reported BETWEEN 0 AND 1)
);

--2-1. java 댓글
CREATE TABLE reply_java(
reply_id			number(10) PRIMARY KEY,
reply_contents		varchar2(1000) NOT NULL,
user_id				varchar2(100),
replyer				varchar2(100) ,
reply_regdate		DATE DEFAULT SYSDATE,
post_id				NUMBER(10) NOT NULL,
					CONSTRAINT rep_java FOREIGN KEY(post_id) REFERENCES java(post_id) ON DELETE cascade
);

--3. jsp 게시판
CREATE TABLE jsp(
post_id 			number(10) PRIMARY KEY,
post_subject 		varchar2(200) NOT NULL,
post_contents 		varchar2(4000) NOT NULL,
user_id				varchar2(100),
					CONSTRAINT jsp_hono FOREIGN KEY(user_id) REFERENCES honorary(user_id),
					CONSTRAINT jsp_user FOREIGN KEY(user_id) REFERENCES user_all(user_id),
post_available		number(1) DEFAULT 1 CONSTRAINT jsp_ava check (post_available BETWEEN 0 AND 1),
writer				varchar2(100) ,
post_rec			varchar2(5),
post_vcount 		number(5) DEFAULT 1,
post_regdate 		DATE DEFAULT SYSDATE,
post_reported		NUMBER(1) DEFAULT 0 CONSTRAINT jsp_reported check (post_reported BETWEEN 0 AND 1)
);

--3-1. jsp 댓글
CREATE TABLE reply_jsp(
reply_id			number(10) PRIMARY KEY,
reply_contents		varchar2(1000) NOT NULL,
user_id				varchar2(100),
replyer				varchar2(100) ,
reply_regdate		DATE DEFAULT SYSDATE,
post_id				NUMBER(10) NOT NULL,
					CONSTRAINT rep_jsp FOREIGN KEY(post_id) REFERENCES jsp(post_id) ON DELETE cascade
);

--4. spring 게시판
CREATE TABLE spring(
post_id 			number(10) PRIMARY KEY,
post_subject 		varchar2(200) NOT NULL,
post_contents 		varchar2(4000) NOT NULL,
user_id				varchar2(100),
					CONSTRAINT spring_hono FOREIGN KEY(user_id) REFERENCES honorary(user_id),
					CONSTRAINT spring_user FOREIGN KEY(user_id) REFERENCES user_all(user_id),
post_available		number(1) DEFAULT 1 CONSTRAINT spring_ava check (post_available BETWEEN 0 AND 1),
writer				varchar2(100) ,
post_rec			varchar2(5),
post_vcount 		number(5) DEFAULT 1,
post_regdate 		DATE DEFAULT SYSDATE,
post_reported		NUMBER(1) DEFAULT 0 CONSTRAINT spring_reported check (post_reported BETWEEN 0 AND 1)
);

--4-1. spring 댓글
CREATE TABLE reply_spring(
reply_id			number(10) PRIMARY KEY,
reply_contents		varchar2(1000) NOT NULL,
user_id				varchar2(100),
replyer				varchar2(100) ,
reply_regdate		DATE DEFAULT SYSDATE,
post_id				NUMBER(10) NOT NULL,
					CONSTRAINT rep_spring FOREIGN KEY(post_id) REFERENCES spring(post_id) ON DELETE cascade
);

--5. html 게시판
CREATE TABLE html(
post_id 			number(10) PRIMARY KEY,
post_subject 		varchar2(200) NOT NULL,
post_contents 		varchar2(4000) NOT NULL,
user_id				varchar2(100),
					CONSTRAINT html_hono FOREIGN KEY(user_id) REFERENCES honorary(user_id),
					CONSTRAINT html_user FOREIGN KEY(user_id) REFERENCES user_all(user_id),
post_available		number(1) DEFAULT 1 CONSTRAINT html_ava check (post_available BETWEEN 0 AND 1),
writer				varchar2(100) ,
post_rec			varchar2(5),
post_vcount 		number(5) DEFAULT 1,
post_regdate 		DATE DEFAULT SYSDATE,
post_reported		NUMBER(1) DEFAULT 0 CONSTRAINT html_reported check (post_reported BETWEEN 0 AND 1)
);

--5-1. html 댓글
CREATE TABLE reply_html(
reply_id			number(10) PRIMARY KEY,
reply_contents		varchar2(1000) NOT NULL,
user_id				varchar2(100),
replyer				varchar2(100) ,
reply_regdate		DATE DEFAULT SYSDATE,
post_id				NUMBER(10) NOT NULL,
					CONSTRAINT rep_html FOREIGN KEY(post_id) REFERENCES html(post_id) ON DELETE cascade
);

--6. css 게시판
CREATE TABLE css(
post_id 			number(10) PRIMARY KEY,
post_subject 		varchar2(200) NOT NULL,
post_contents 		varchar2(4000) NOT NULL,
user_id				varchar2(100),
					CONSTRAINT css_hono FOREIGN KEY(user_id) REFERENCES honorary(user_id),
					CONSTRAINT css_user FOREIGN KEY(user_id) REFERENCES user_all(user_id),
post_available		number(1) DEFAULT 1 CONSTRAINT css_ava check (post_available BETWEEN 0 AND 1),
writer				varchar2(100) ,
post_rec			varchar2(5),
post_vcount 		number(5) DEFAULT 1,
post_regdate 		DATE DEFAULT SYSDATE,
--신고된 게시글
post_reported		NUMBER(1) DEFAULT 0 CONSTRAINT css_reported check (post_reported BETWEEN 0 AND 1)
);

--6-1. css 댓글
CREATE TABLE reply_css(
reply_id			number(10) PRIMARY KEY,
reply_contents		varchar2(1000) NOT NULL,
user_id				varchar2(100),
replyer				varchar2(100) ,
reply_regdate		DATE DEFAULT SYSDATE,
post_id				NUMBER(10) NOT NULL,
					CONSTRAINT rep_css FOREIGN KEY(post_id) REFERENCES css(post_id)
					ON DELETE cascade
);


--7. javascript 게시판
CREATE TABLE javascript(
post_id 			number(10) PRIMARY KEY,
post_subject 		varchar2(200) NOT NULL,
post_contents 		varchar2(4000) NOT NULL,
user_id				varchar2(100) ,
					CONSTRAINT js_hono FOREIGN KEY(user_id) REFERENCES honorary(user_id),
					CONSTRAINT js_user FOREIGN KEY(user_id) REFERENCES user_all(user_id),
post_available		number(1) DEFAULT 1 CONSTRAINT js_ava check (post_available BETWEEN 0 AND 1),
writer				varchar2(100) ,
post_rec			varchar2(5),
post_vcount 		number(5) DEFAULT 1,
post_regdate 		DATE DEFAULT SYSDATE,
post_reported		NUMBER(1) DEFAULT 0 CONSTRAINT js_reported check (post_reported BETWEEN 0 AND 1)
);

--7-1. javascript 댓글
CREATE TABLE reply_javascript(
reply_id			number(10) PRIMARY KEY,
reply_contents		varchar2(1000) NOT NULL,
user_id				varchar2(100),
replyer				varchar2(100) ,
reply_regdate		DATE DEFAULT SYSDATE,
post_id				NUMBER(10) NOT NULL,
					CONSTRAINT rep_js FOREIGN KEY(post_id) REFERENCES javascript(post_id) ON DELETE cascade
);


-- 8. announcements 게시판
-- 관리자 테이블과 외래키 연결
CREATE TABLE announcements(
post_id 			number(10) PRIMARY KEY,
post_subject 		varchar2(200) NOT NULL,
post_contents 		varchar2(4000) NOT NULL,
writer				varchar2(100) DEFAULT 'admin',
					CONSTRAINT ann_fk FOREIGN KEY(writer) REFERENCES authority(authority_name),
post_vcount 		number(5) DEFAULT 1,
post_regdate 		DATE DEFAULT SYSDATE
);


-- 9. 북마크
CREATE TABLE post_bookmark(
   bookmark_id number(10) PRIMARY KEY,
   user_id      varchar2(100),
   post_id      number(10),
   language_index number(10),
   CONSTRAINT bookmark_uq UNIQUE (user_id, post_id, language_index),
   CONSTRAINT user_id_fk FOREIGN KEY(user_id) REFERENCES user_all (user_id) ON DELETE CASCADE,
   CONSTRAINT oracle_post_id_fk FOREIGN KEY(post_id) REFERENCES oracle (post_id) ON DELETE CASCADE,
   CONSTRAINT java_post_id_fk FOREIGN KEY(post_id) REFERENCES java (post_id) ON DELETE CASCADE,
   CONSTRAINT jsp_post_id_fk FOREIGN KEY(post_id) REFERENCES jsp (post_id) ON DELETE CASCADE,
   CONSTRAINT spring_post_id_fk FOREIGN KEY(post_id) REFERENCES spring (post_id) ON DELETE CASCADE,
   CONSTRAINT html_post_id_fk FOREIGN KEY(post_id) REFERENCES html (post_id) ON DELETE CASCADE,
   CONSTRAINT javascript_post_id_fk FOREIGN KEY(post_id) REFERENCES javascript (post_id) ON DELETE CASCADE
);

--SELECT * FROM 
--		(SELECT * FROM 
--		( SELECT ROWNUM R, D.* FROM 
--		( SELECT * FROM announcements ORDER BY post_id DESC) D)
--		 B WHERE B.R BETWEEN #{startRow} AND #{endRow}) R
--;



INSERT INTO AUTHORITY VALUES (0, 'admin');
INSERT INTO AUTHORITY VALUES (1, 'user');

INSERT INTO USER_ALL VALUES ('admin', '0001', '관리자', '01000000000', 'admin2@bttf.com', 'java',1, 0, 1, 1, sysdate, 0);
INSERT INTO USER_ALL VALUES ('pjy', '2222', '박지율', '22222222', 'pjy@bttf.com', 'spring',1, 0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('lcr', '3333', '이초록', '33333333', 'lcr@bttf.com', 'jsp',1, 0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('csi', '4444', '조선익', '44444444', 'csi@bttf.com', 'java',1, 0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('jsj', '5555', '주수진', '55555555', 'jsj@bttf.com', 'javascript',1, 0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('jjh', '6666', '정진형', '66666666', 'csy@bttf.com', 'css',1, 0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('ksk', '6666', '김선경', '66666666', 'csy@bttf.com', 'css',1, 0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('kmh', '7777', '김민혁', '77777777', 'kmh@bttf.com', 'oracle',1, 0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('dummy01', '6666', '최서연', '66666666', 'csy@bttf.com', 'css',1, 0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('dummy02', '6666', '최서연', '66666666', 'csy@bttf.com', 'css', 1,0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('dummy03', '6666', '최서연', '66666666', 'csy@bttf.com', 'css', 1,0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('dummy04', '6666', '최서연', '66666666', 'csy@bttf.com', 'css',1, 0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('dummy05', '6666', '최서연', '66666666', 'csy@bttf.com', 'css',1, 0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('dummy06', '6666', '최서연', '66666666', 'csy@bttf.com', 'css',1, 0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('dummy07', '6666', '최서연', '66666666', 'csy@bttf.com', 'css',1, 0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('dummy08', '6666', '최서연', '66666666', 'csy@bttf.com', 'css',1, 0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('dummy09', '6666', '최서연', '66666666', 'csy@bttf.com', 'css',1, 0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('dummy10', '6666', '최서연', '66666666', 'csy@bttf.com', 'css',1, 0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('dummy11', '6666', '최서연', '66666666', 'csy@bttf.com', 'css',1, 0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('dummy12', '6666', '최서연', '66666666', 'csy@bttf.com', 'css',1, 0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('dummy13', '6666', '최서연', '66666666', 'csy@bttf.com', 'css',1, 0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('dummy14', '6666', '최서연', '66666666', 'csy@bttf.com', 'css',1, 0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('dummy15', '6666', '최서연', '66666666', 'csy@bttf.com', 'css',1, 0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('dummy16', '6666', '최서연', '66666666', 'csy@bttf.com', 'css',1, 0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('dummy17', '6666', '최서연', '66666666', 'csy@bttf.com', 'css',1, 0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('dummy18', '6666', '최서연', '66666666', 'csy@bttf.com', 'css',1, 0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('dummy19', '6666', '최서연', '66666666', 'csy@bttf.com', 'css',1, 0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('dummy20', '6666', '최서연', '66666666', 'csy@bttf.com', 'css',1, 0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('dummy21', '6666', '최서연', '66666666', 'csy@bttf.com', 'css', 1,0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('dummy22', '6666', '최서연', '66666666', 'csy@bttf.com', 'css',1, 0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('dummy23', '6666', '최서연', '66666666', 'csy@bttf.com', 'css', 1,0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('dummy24', '6666', '최서연', '66666666', 'csy@bttf.com', 'css',1, 0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('dummy25', '6666', '최서연', '66666666', 'csy@bttf.com', 'css',1, 0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('dummy26', '6666', '최서연', '66666666', 'csy@bttf.com', 'css',1,0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('dummy27', '6666', '최서연', '66666666', 'csy@bttf.com', 'css',1, 0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('dummy28', '6666', '최서연', '66666666', 'csy@bttf.com', 'css', 1,0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('dummy29', '6666', '최서연', '66666666', 'csy@bttf.com', 'css', 1,0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('dummy30', '6666', '최서연', '66666666', 'csy@bttf.com', 'css', 1,0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('dummy31', '6666', '최서연', '66666666', 'csy@bttf.com', 'css', 1,0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('dummy32', '6666', '최서연', '66666666', 'csy@bttf.com', 'css', 1,0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('dummy33', '6666', '최서연', '66666666', 'csy@bttf.com', 'css', 1,0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('dummy34', '6666', '최서연', '66666666', 'csy@bttf.com', 'css', 1,0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('dummy35', '6666', '최서연', '66666666', 'csy@bttf.com', 'css', 1,0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('dummy36', '6666', '최서연', '66666666', 'csy@bttf.com', 'css', 1,0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('dummy37', '6666', '최서연', '66666666', 'csy@bttf.com', 'css', 1,0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('dummy38', '6666', '최서연', '66666666', 'csy@bttf.com', 'css', 1,0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('dummy39', '6666', '최서연', '66666666', 'csy@bttf.com', 'css', 1,0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('dummy40', '6666', '최서연', '66666666', 'csy@bttf.com', 'css', 1,0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('dummy41', '6666', '최서연', '66666666', 'csy@bttf.com', 'css', 1,0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('dummy42', '6666', '최서연', '66666666', 'csy@bttf.com', 'css', 1,0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('dummy43', '6666', '최서연', '66666666', 'csy@bttf.com', 'css', 1,0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('dummy44', '6666', '최서연', '66666666', 'csy@bttf.com', 'css', 1,0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('dummy45', '6666', '최서연', '66666666', 'csy@bttf.com', 'css', 1,0, 1, 1, sysdate, 1);
INSERT INTO USER_ALL VALUES ('dummy46', '6666', '최서연', '66666666', 'csy@bttf.com', 'css', 1,0, 1, 1, sysdate, 1);

--PARENT KEY NOT FOUND
INSERT INTO HONORARY VALUES ('pjy','1');
INSERT INTO css VALUES (css_seq.nextval, '테스트','test','pjy',1,'쓰니',3,2, sysdate, 1);



-- SELECT * FROM ANNOUNCEMENTS a ;
