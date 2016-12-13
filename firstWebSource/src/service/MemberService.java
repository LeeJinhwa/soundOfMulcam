package service;

import dao.MemberDAO;
import vo.MemberVo;

public class MemberService {
	private MemberService() {
	}

	private static MemberService instance = new MemberService();

	public static MemberService getInstance() { // static�� �Ⱥ��̸� �� �ٸ� Ŭ�������� ȣ���� ��
												// ������ �𸣰���
		return instance;
	}

	private MemberDAO dao = MemberDAO.getInstance();

	// ���̹� ���̵����� �ƴ��� üũ�� �� ���ԵǾ� �ִ� ���̵����� �ƴ��� üũ
	// String savedMember = "blet357@naver.com";
	// int nv = savedMember.indexOf("@");
	// String checkNv = savedMember.substring(nv);
	//
	// if(checkNv.equals("@naver.com")){
	// System.out.println(checkNv);
	// }else{
	// System.out.println("ffff");
	// }
	// }

	public String joinCheck(String id) {
		String anotherJoin = "@naver.com";
		MemberVo savedMember = dao.select(id);
		int nv = id.indexOf("@");
		String checkNv = id.substring(nv);

		if (savedMember != null) {
			return "alreadyJoin";
		} else {
			if (checkNv.equals(anotherJoin)) {
				return "joinToNaver";
			} else {
				return "joinPossible";
			}
		}
	}

	public boolean join(MemberVo member) {
		MemberVo savedMember = dao.select(member.getId());
		if (savedMember != null) {
			return false;
		} else {
			int result = dao.insertMember(member);
			if (result == 1) {
				return true;
			} else {
				return false;
			}
		}
	}

	public boolean login(String id, String password) {
		MemberVo savedMember = dao.select(id);
		if (savedMember != null && savedMember.getPassword().equals(password)) {
			return true;
		} else {
			return false;
		}

	}
	
	public MemberVo loginUserInfo(String id, String password){
		MemberVo loginUserObject = dao.select(id); 
		return loginUserObject;
	}
}
