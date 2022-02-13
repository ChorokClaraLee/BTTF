<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

			<!-- 댓글 작성 form 시작 -->
								<input type="hidden" name="boardnum" value="${board.post_id }">
								<c:set var="replylist" value="${requestScope.replylist }"/>
								<div class="col-auto" style="display: flex;">
                           			<input id="reply_contents" name="reply_contents" class="form-control margin-b-50" style="width: 95%;" type="text" placeholder="댓글을 작성해보세요">
                           			<a href="javascript:document.replyForm.submit()" class="btn btn-default margin-b-50" style="height: 50px; margin-left: 20px;">댓글등록</a>
                         		</div>
			<!-- 댓글 리스트 -->
								<table border="1">
									<c:choose>
										<c:when test="${replylist != null and fn:length(replylist) > 0 }">
											<c:forEach var="reply" items="${replylist }">
												<tr>
													<% String user_id_cssview = (String) session.getAttribute("session_id"); %>
			<!-- 정상적인 접근 경로 -->
													<c:if test="${sessionScope.session_id != null }" >
														<td align="center" width="200px" >
														<p id="re_author" name="user_id" class="form-control margin-b-50" style="display:hidden;"><%= user_id_cssview %></p>
														</td>
														<td valign="top" style="padding-left: 10px;">
															<textarea id="reply${reply.reply_id }" name="reply${reply.reply_id }" 
															style="text-align:left;border:0px;width:680px;height:85px;resize:none;" readonly>${reply.reply_contents }</textarea>
															<a href="javascript:updateReply( ${reply.reply_id})">[수정]</a>
															<a href="javascript:updateReadonlyReply( ${reply.reply_id} );">[수정 하기]</a>
															<a href="javascript:deleteReply( ${reply.reply_id})">[삭제]</a>
														</td>
													</c:if>
			<!-- 비정상적인 접근 경로 -->
													<c:if test="${sessionScope.session_id == null }" >
														<td valign="top" style="padding-left: 10px;">
															<textarea id="reply${reply.reply_id }" name="reply${reply.reply_id }" 
															style="text-align:left;border:0px;width:680px;height:85px;resize:none;" readonly>${reply.reply_contents }</textarea>
															<a href="login.jsp" class="btn btn-info mt-4" id="editsubmitfail">[수정]</a>
															<a href="login.jsp" class="btn btn-info mt-4" id="editfail">[수정 하기]</a>
															<a href="login.jsp" class="btn btn-info mt-4" id="deletefail">[삭제]</a>
														</td>
													</c:if>
												</tr>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<tr>
												<td align="center">댓글이 없습니다.</td>
											</tr>
										</c:otherwise>
									</c:choose>
								</table>
			<!--reply pagination -->
								<nav aria-label="Page navigation" class="text-center">
									<ul class="pagination">
										<c:if test="${nowPage > 1 }">
											<li class="page-item">							
												<a class="page-link" href="${pageContext.request.contextPath }/pages/cssBoardView.do?page=${nowPage - 1 }">&lt;</a>
											</li>
										</c:if>
										<c:forEach var="i" begin="${startPage}" end="${endPage }">
											<c:choose>
												<c:when test="${i == nowPage }">
													<li class="page-item">
														<a class="page-link">${i }	</a>						
													</li>
												</c:when>
												<c:otherwise>
													<li class="page-item">									
														<a class="page-link" href="${pageContext.request.contextPath }/pages/cssBoardView.do?page=${i }">${i }</a>
													</li>
												</c:otherwise>
											</c:choose>
										</c:forEach>	
										<c:if test="${nowPage<totalPage }">
											<li class="page-item">
												<a class="page-link" href="${pageContext.request.contextPath }/pages/cssBoardView.do?page=${nowPage + 1 }">&gt;</a>
											</li>
										</c:if>						
									</ul>
								</nav>
			<!-- end of reply pagination -->
			
			
			