package com.spring.ex03;

public class MemberDAOImpl implements MemberDAO {
	@Override
	public void listMembers() {
		System.out.println("MemberDAO.listMembers()  메서드 호출");
		System.out.println("회원정보를 조회합니다.");
	}
}
