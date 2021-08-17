[MVC]

MVC(Model View Control)

(흐름)
1. 웹브라우저

2. DispatcherServlet
	- 클라이언트의 요청을 받아서 컨트롤러를 선택하여 클라이언트 요청을 전달
	- 컨트롤러가 반환한 값을 View에 전달하여 알맞은 응답을 생성
	
3. ViewResolver
	- 컨트롤러의 처리 결과를 전달 할 뷰를 지정
	
4. Controller
	- 클라이언트의 요청을 처리한 후 그 결과를 DispatcherServlet에 전달
	
5. View
	- 컨트롤러의 처리 결과 화면을 생성
	
6. HandlerMapping
	- 클라이언트가 요청한 URL을 처리할 컨트롤러를 지정
	
7. MoelAndView
	- 컨트롤러가 처리한 결과 및 뷰 선택에 필요한 정보를 저장
	
(처리흐름) ★ 무적권 중요 ★
1. 브라우저 DispatcherServlet에 URL로 접근하여 정보 요청
2. HandlerMapping에서 해당 요청에 대해 매핑된 컨트롤러가 있는지 요청
3. 매핑된 컨트롤러에 대해서 처리 요청
4. 컨트롤러가 웹브라우저의 요청을 처리한 결과와 View 이름을 ModelAndView에 저장해서 DispatcherServlet으로 반환
5. DispatcherServlet에서는 컨트롤러에서 보내온 View이름을 ViewResolver로 보내 해당 View를 요청
6. ViewResolver는 요청한 View를 보냄
7. View의 처리 결과를 DispatcherServlet으로 보냄
8. DispatcherServlet은 최종 결과를 브라우저로 전송




	