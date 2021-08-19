[JSpring23b]


(마이바티스)
- http://www.mybatis.org : mybatis-3.4.6.zip
- JDBC를 보완
- 참고 : 하이버네이트(비슷한 프레임워크)
- 환경 설정 파일과 쿼리를 별도의 xml 파일로 설정
- 자바코드와 쿼리를 분리
- 데이터소스(DataSource), 트랜젝션 처리 기능 제공
	
(예제구성)
- mybatis.SqlMapConfig.xml : 마이바티스 관련 정보
- mybatis.mappers.member.xml : 회원 정보 SQL

(예제1 실행)
멤버 리스트 조회 : http://localhost:8090/JSpring23b/mem.do


(예제2 실행)
멤버 이름 조회 : http://localhost:8090/JSpring23b/mem2.do

(예제3 실행)
검색 : 전체, 아이디, 패스워드
http://localhost:8090/JSpring23b/test02/search.jsp
	-> http://localhost:8090/JSpring23b/mem3.do
	
(예제4 실행)
멤버조회 : http://localhost:8090/JSpring23b/mem4.jsp
멤버등록 : http://localhost:8090/JSpring23b/test03/memberForm.jsp	
멤버수정 : http://localhost:8090/JSpring23b/test03/modMember.jsp
(member.xml: foreachInsert)
INSERT ALL 
	INTO t_member(id, pwd, name, email) VALUES  ('4001','4001', '사공공일', '4001@member.com')
	INTO t_member(id, pwd, name, email) VALUES  ('4002','4002', '사공공이', '4002@member.com')
	INTO t_member(id, pwd, name, email) VALUES  ('4003','4003', '사공공삼', '4003@member.com')
	INTO t_member(id, pwd, name, email) VALUES  ('4004','4004', '사공공사', '4004@member.com')
    
    SELECT * FROM DUAL;
	
	