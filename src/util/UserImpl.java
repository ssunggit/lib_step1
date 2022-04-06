package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import VO.UserVO;
import menu.Menu;

public class UserImpl implements User {
	Scanner sc = new Scanner(System.in);
	
	public List<UserVO> userArr = new ArrayList<>();
	// 로그인한 유저의 아이디
	public static String loginUserID;

	// 관리자 추가
	public UserImpl() {
		UserVO user = new UserVO();
		user.setName("관리자");
		user.setPhone("01012345678");
		user.setId("admin");
		user.setPw("0000");
		userArr.add(user);
	}

	@Override
	public void join() {
		UserVO user = new UserVO();
		System.out.println("===================<  회원가입  >===================");

		System.out.print("#. 이름 : ");
		user.setName(sc.nextLine());

		System.out.print("#. 전화번호 : ");
		user.setPhone(sc.nextLine());

		System.out.print("#. 아이디 : ");
		user.setId(sc.nextLine());

		System.out.print("#. 비밀번호 : ");
		user.setPw(sc.nextLine());

		userArr.add(user);

	}

	@Override
	public void login() {

		System.out.print("ID를 입력하세요 : ");
		String inputId = sc.nextLine();

		System.out.print("PW를 입력하세요 : ");
		String inputPw = sc.nextLine();

		int test = 0;
		
		for (int i = 0; i < userArr.size(); i++) {
			if (inputId.equals(userArr.get(i).getId()) && inputPw.equals(userArr.get(i).getPw())) {
				test = 1;
				System.out.println(userArr.get(i).getName() + " 님 로그인에 성공하였습니다. ");
				UserVO loginUser = userArr.get(i);
				loginUserID = userArr.get(i).getId();
				Menu m = new Menu();
				// 관리자는 관리자메뉴로 이동
				if (loginUserID.equals("admin")) {
					m.adminMenu(loginUser);
				} else {
					// 일반사용자는 일반메뉴로 이동
					m.userMenu(loginUser);
				}
			}

		}

		if (test == 0) {
			System.out.println("로그인에 실패하였습니다.");
		}

	}

	// 종료로 처리하거나 로그아웃
	@Override
	public void logout() {

	}

	@Override
	public void userUpdate() {

	}

	@Override
	public void userDelete() {

	}

}
