[Expression Language] 표현언어

1. JSP에서 표현 언어를 사용하려면 Page Directive 속성에서 isELIgonored 속성을 false로 변경
	- isELIgnored="false"
	
2. 표현 언어 특징
	- 변수와 연산자를 포함
	- JSP 내장 객체에 저장된 속성이나 자바빈 속성을 출력 가능
	- JSP 페이지 생성 시 기본 설정은 표현 언어를 사용할 수 없다.
	- isELIgnored="false"
	
3. 자료형
	- 논리 : true, false
	- 정수 : +, -, 0~9로 이루어진 값
	- 실수 : 소수점 값, 지수형
	- 문자열 : 작은따옴표('문자열'), 큰따옴표('문자열")
	- 무효값 : null
	
4. 연산자
	- 산술연산자 : +, -, *, /, div, %, mod
	- 비교연산자 
		->  ==, !=, >, <, >=, <= 
		->  eq, ne, gt, lt ,ge, le
	- 논리연산자 
		->  논리곱(&&, and)
		->  논리합(||, or)
		->  부정(!, not)
	- 빈연산자(empty) : null이거나 문자열이 비어 있으면 true 반환
	- 조건연산자 : 식 ? 값1 : 값2
	