[트랜젝션 처리]

(CUST_ACCOUNT)
CREATE TABLE CUST_ACCOUNT
(
	ACCOUNTNO VARCHAR2(20) PRIMARY KEY,
	CUSTNAME VARCHAR2(30),
	BALANCE NUMBER(20,4)
);

(실행)
http://localhost:8090/JSpring25a/account/sendMoney.do

(트랜젝션)

@Transactional(propagation=Propagation.REQUIRED)
class AccountService{
}

(Propagation 옵션)
1. REQUIRED
	- 디폴트
	- 트랜젝션이 필요
	- 진행중인 트랜젝션이 있는 경우 트랜젝션을 사용
	- 트랜젝션이 없으면 새로운 트랜젝션을 생성
	
2. MANDATORY
	- 트랜젝션이 필요
	- 진행 중인 트랜젝션이 없는 경우 예외 발생
	
3. REQUIRES_NEW
	- 항상 새로운 트랜젝션 생성
	- 진행 트랜잭션이 있다면 기존 트랜젝션을 중단 시키고 새로운 트랜젝션을 시작
	- 새로운 트랜젝션이 종료되면 기존 트랜잭션을 계속 진행

4. SUPPORTS
	- 트랜젝션이 필요 없음
	- 진행중인 트랜젝션이 있는 경우 해당 트랜젝션을 사용
	
5. NO_SUPPORTS
	- 트랜젝션이 필요 없음
	- 진행중인 트랜젝션이 있는 경우 기존 트랜젝션을 중단시킨 후 해당 메소드를 실행
	- 메서드 실행이 종료되면 기존 트랜젝션 계속 진행
	
6. NEVER
	- 트랜젝션 필요 없음
	- 진행 중인 트랜젝션이 있는 경우 예외 발생
	
	
	
	
	