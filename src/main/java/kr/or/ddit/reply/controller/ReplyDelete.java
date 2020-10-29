package kr.or.ddit.reply.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.reply.service.ReplyService;
import kr.or.ddit.reply.service.ReplyServiceI;

/**
 * Servlet implementation class ReplyDelete
 */
@WebServlet("/ReplyDelete")
public class ReplyDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(ReplyDelete.class);
	ReplyServiceI replyService;
	@Override
	public void init() throws ServletException {
		replyService = new ReplyService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int reply_seq = Integer.parseInt(request.getParameter("reply_seq"));
		int board_seq = Integer.parseInt(request.getParameter("board_seq"));
		
		logger.debug("reply_seq{}",reply_seq);
		int delete = replyService.deleteReply(reply_seq);
		
		logger.debug("댓글삭제댓글삭제댓글삭제{}",delete);
		
		response.sendRedirect(request.getContextPath() + "/BoardContent?board_seq="+board_seq);
	}


}
