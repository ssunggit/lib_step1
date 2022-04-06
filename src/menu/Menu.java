package menu;

import java.util.Scanner;

import VO.UserVO;
import util.BookImpl;
import util.UserImpl;

public class Menu {
	Scanner sc = new Scanner(System.in);
	BookImpl book = new BookImpl();
	UserImpl userImpl = new UserImpl();
	
	public void menu() {
		while (true) {
			System.out.println("===============<Welcome To Library>===============");
			System.out.println("반갑습니다. 도서관리 프로그램입니다. 이용하실 서비스의 번호를 입력해주세요.");
			System.out.println("1. 회원가입\t 2. 로그인\t 3. 종료\t");
			System.out.print("=> ");
			int userChoice = Integer.parseInt(sc.nextLine());
			if (userChoice == 1) {
				userImpl.join();
			} else if (userChoice == 2) {
				userImpl.login();
				
			} else {
				// 브레이크하는 순간 새로운 userImpl, BookImpl 생성되어 관리자로 책추가한거 다사라짐 
				// -> 해결하기
				System.out.println("도서관 프로그램을 중단하겠습니다!!");
				break;
			}
		}

	}
	
	// 관리자 메뉴
	public void adminMenu(UserVO user) {
		while (true) {
			System.out.println(user.getName() + "님 이용하실 서비스의 번호를 입력해주세요.");
			System.out.println("1. 도서리스트 출력\t 2. 도서추가\t 3. 도서정보변경 \t 4. 도서 삭제\t 5. 종료");
			System.out.print("=> ");
			int userChoice = Integer.parseInt(sc.nextLine());

			if (userChoice == 1) {
				book.showBookList();
			} else if (userChoice == 2) {
				book.bookAdd();
			} else if (userChoice == 3) {
				//일단 킵 
				System.out.println("일단 킵");
				book.bookUpdate();
			} else if (userChoice == 4) {
				book.bookDel();
			}else {
				System.out.println("도서관 프로그램을 중단하겠습니다!!");
				break;
			}
		}
	}
	
	// 일반 사용자 메뉴
	public void userMenu(UserVO loginUser) {
		
		while (true) {
			System.out.println(loginUser.getName() + "님 이용하실 서비스의 번호를 입력해주세요.");
			System.out.println("1. 전체 책 조회 \t 2. 대여\t 3. 반납\t 4. 내 도서이력 조회\t 5. 종료");
			System.out.print("=> ");
			int userChoice = Integer.parseInt(sc.nextLine());

			if (userChoice == 1) {
				book.showBookList();
			} else if (userChoice == 2) {
				book.rental();
			} else if (userChoice == 3) {
				book.back();
			} else if (userChoice == 4) {
				book.myRentalCheck(loginUser);
			} else {
				System.out.println("도서관 프로그램을 중단하겠습니다!!");
				break;
			}
		}
	}
}