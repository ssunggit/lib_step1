package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import VO.BookVO;
import VO.UserVO;

public class BookImpl implements Book {
	Scanner sc = new Scanner(System.in);
	public List<BookVO> bookList = new ArrayList<>();

	// test 도서(기본도서)
	public BookImpl() {
		BookVO book = new BookVO();
		book.setId(0);
		book.setRental(false);
		book.setAuthor("test");
		book.setTitle("test");
		book.setPublisher("test");
		bookList.add(book);
	}

	@Override
	public void rental() {
		System.out.print("대여할 도서의 이름을 입력하세요 : ");
		String inputTitle = sc.nextLine();
		for (int i = 0; i < bookList.size(); i++) {
			if (inputTitle.equals(bookList.get(i).getTitle())) {
				if (bookList.get(i).getRental() == true) {
					System.out.println("검색하신 [" + bookList.get(i).getTitle() + "] 책은 대여 중입니다.");

				} else {
					System.out.println("검색하신 [" + bookList.get(i).getTitle() + "] 책이 있습니다.");
					System.out.println(" [" + bookList.get(i).getTitle() + "] 책을 대여하시겠습니까?(y/n)");
					String yesNo = sc.nextLine();

					if (yesNo.equals("y") || yesNo.equals("Y")) {

						bookList.get(i).setRental(true);
						bookList.get(i).setUserId(UserImpl.loginUserID);
					}
				}
			} else {
				System.out.println("검색하신 [" + inputTitle + "] 책이 없습니다.");
			}
		}
	}

	@Override
	public void back() {

	}

	@Override
	public void myRentalCheck(UserVO loginUser) {
		// loginUser.getId() == loginUserID 같다
		System.out.println(loginUser.getName() + "님의 대여목록");
		if (bookList.size() > 0) {
			for (int i = 0; i < bookList.size(); i++) {
				if (UserImpl.loginUserID.equals(bookList.get(i).getUserId())) {
					System.out.print("[" + (i + 1) + "]  ");
					System.out.println(bookList.get(i).getTitle());
				}
			}
		}else {
			System.out.println("대여목록이 없습니다.");
		}
	}

	@Override
	public void showBookList() {
		System.out.println("<도서리스트 출력>");
		for (int i = 0; i < bookList.size(); i++) {
			System.out.println("[" + (i + 1) + "번 도서]");
			System.out.println("[제목]" + bookList.get(i).getTitle());
			System.out.println("[글쓴이]" + bookList.get(i).getAuthor());
			System.out.println("[출판사]" + bookList.get(i).getPublisher());
			System.out.println("---------------------------------");
		}
	}

	// 관리자 기능
	@Override
	public void bookAdd() {
		BookVO book = new BookVO();
		// 메뉴로 접근하는 사용자가 오로지 관리자이기 때문에 if문 없어도 됨
		if (UserImpl.loginUserID.equals("admin")) {
			System.out.println("<도서등록>");

			// id 자동생성
			book.setId(bookList.size());

			// 대여여부 false
			book.setRental(false);

			System.out.print("책 제목을 입력해주세요 : ");
			book.setTitle(sc.nextLine());

			System.out.print("지은이를 입력해주세요 : ");
			book.setAuthor(sc.nextLine());

			System.out.print("출판사를 입력해주세요 : ");
			book.setPublisher(sc.nextLine());

			bookList.add(book);
		}
	}

	// 일단 킵
	@Override
	public void bookUpdate() {

	}

	@Override
	public void bookDel() {
		System.out.println("<도서리스트 출력>");
		for (int i = 0; i < bookList.size(); i++) {
			System.out.print("[" + (i + 1) + "]  ");
			System.out.println(bookList.get(i).getTitle());
		}

		System.out.print("삭제할 책의 번호를 입력해주세요 : ");
		int delBook = Integer.parseInt(sc.nextLine()) - 1;

		bookList.remove(delBook);

		System.out.println("< 변경된 도서리스트 출력>");
		for (int i = 0; i < bookList.size(); i++) {
			System.out.print("[" + (i + 1) + "]  ");
			System.out.println(bookList.get(i).getTitle());
		}

	}

}
