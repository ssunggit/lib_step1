package util;

import VO.UserVO;

public interface Book {
	// 사용자
	public void rental();

	public void back();

	public void myRentalCheck(UserVO loginUser);

	// 관리자
	public void showBookList();

	public void bookAdd();

	public void bookUpdate();

	public void bookDel();

}
