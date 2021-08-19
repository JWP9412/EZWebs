[JSpring22a]
- 스프링을 이용한 JDBC 연동
- 멤버조회

(설정파일)
1. 스프링의 JDBC 연동
	- JdbcTemplate 사용하여 데이터베이스 처리
2. web.xml
	- 톰캣이 웹 환경설정을 읽어서 처리
3. action-servlet.xml
	- 스프링에서 빈(bean) 설정
4. action-datSource.xml
	- 스프링의 JDBC 설정
5. jdbc.properties
	- 데이터베이스 연결 정보
6. action-service.xml
	- 서비스 빈 설정

(처리순서)
1. memberController
2. memberService
3. memberDAO
4. dataSource


(데이터베이스 테이블)
CREATE TABLE T_MEMBER
(
	ID VARCHAR(10) PRIMARY KEY,
	PWD VARCHAR(30),
	NAME VARCHAR(30),
	EMAIL VARCHAR(50),
	JOINDATE DATE DEFAULT SYSDATE
);

[실행]
http:localhost:8090/JSpring22a/member/listMembers.do