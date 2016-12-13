package service;

import java.util.List;

import dao.CommentDAO;
import dao.FileDao;
import vo.CommentPageVO;
import vo.CommentVO;

public class CommentService {
	private static CommentService instance;

	public static CommentService getInstance() {

		if (instance == null)
			instance = new CommentService();
		return instance;
	}

	private CommentService() {
	}

	///////////////////////////////////////////////////////////////

	// // �� �Խñ� ���� ��ȸ
	// int articleTotalCount = dao.selectArticleCount();

//	final int PAGE_PER_COUNT = 10;

	public CommentPageVO makePage(int musicNum) {
		FileDao dao = FileDao.getInstance();
		// int startRow = (currentPage - 1) * PAGE_PER_COUNT;
		// int endRow = startRow + PAGE_PER_COUNT;
		List<CommentVO> commentList = dao.selectCommentList(musicNum);

		// ������ �� �ڸ�Ʈ ���� ��ȸ
		// int commentTotalCount = dao.selectCommentCount(musicNum);

		// �� �������� ���
		// int totalPage = commentTotalCount / PAGE_PER_COUNT;
		// if (commentTotalCount % PAGE_PER_COUNT != 0)
		// totalPage++;

		// // ������ �ϴ��� ���������� ���
		// int startPage = (currentPage - 1) / 10 * 10 + 1;

		// // ������ �ϴ��� �������� ���
		// int endPage = startPage + 9;
		// if (endPage > totalPage)
		// endPage = totalPage;

		return new CommentPageVO(commentList);

	}

	// �� ����
	synchronized public int insert(CommentVO comment) {
		int result = 0;
		FileDao dao = FileDao.getInstance();
		if (dao.insert(comment) > 0) {
			result = dao.updateInitgrp(selectMaxInsertNum());
		} else {
			result = 0;
		}
		return result;
	}

	synchronized public int selectMaxInsertNum() {
		FileDao dao = FileDao.getInstance();
		int result = dao.selectMaxInsertNum();
		return result;
	}

	// ��� ����
	public int insertReply(CommentVO replyComment, int parentCommentNum) {
		FileDao dao = FileDao.getInstance();
		int result = dao.insertReplyComment(replyComment, parentCommentNum);
		return result;
	}

	// // password�� �˻��� �Ŀ� �����ϱ⸦ �����ϴ� �޼ҵ�
	// public int modify(ArticleVO article) {
	// BoardDAO dao = BoardDAO.getInstance();
	// int result = 0;
	//
	// ArticleVO original = dao.selectArticle(article.getArticleId());
	// if (article.getPassword().equals(original.getPassword())) {
	// result = dao.update(article);
	// }
	// return result;
	// }
	//
	// // password�� �˻��� �Ŀ� �����ϱ⸦ �����ϴ� �޼ҵ�
	// public int remove(int articleId, String password) {
	// BoardDAO dao = BoardDAO.getInstance();
	// int result = 0;
	//
	// ArticleVO original = dao.selectArticle(articleId);
	// if (password.equals(original.getPassword())) {
	// result = dao.delete(articleId);
	// }
	// return result;
	// }

}
