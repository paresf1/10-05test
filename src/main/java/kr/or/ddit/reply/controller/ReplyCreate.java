package kr.or.ddit.reply.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.model.MemberVo;
import kr.or.ddit.model.ReplyVo;
import kr.or.ddit.reply.service.ReplyService;
import kr.or.ddit.reply.service.ReplyServiceI;

/**
 * Servlet implementation class ReplyCreate
 */
@WebServlet("/ReplyCreate")
public class ReplyCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private static final Logger logger = LoggerFactory.getLogger(ReplyCreate.class);
	ReplyServiceI replyService;
	@Override
		public void init() throws ServletException {
			replyService = new ReplyService();
		}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String reply_content = request.getParameter("reply_content");
		int board_seq = Integer.parseInt(request.getParameter("board_seq"));
		MemberVo vo = (MemberVo)request.getSession().getAttribute("memberVo");
		
		logger.debug(reply_content);
		logger.debug(vo.getUser_id());
		logger.debug("{}", board_seq);
		ReplyVo rv = new ReplyVo();
		rv.setReply_content(reply_content);
		rv.setBoard_seq(board_seq);
		rv.setUser_id(vo.getUser_id());
		
		int result = replyService.setReply(rv);
		logger.debug("{}",result);
		response.sendRedirect(request.getContextPath()+  "/BoardContent?board_seq=" + board_seq);
	}

}
