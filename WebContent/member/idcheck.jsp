<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE HTML>
<!--
   Massively by HTML5 UP
   html5up.net | @ajlkn
   Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>

<head>

<title>PGI 설문조사</title>

<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />

<link rel="stylesheet" href="assets/css/main.css" />


</head>



<body>

	<!-- Wrapper -->
	<div>
		<!-- 회원가입 -->
		<!-- Footer -->
		<footer id="footer">

			<section>

				<h2>Email 중복확인</h2>

				<form action="member" method="get" name="fm">

					<input type="hidden" name="command" value="member_Id_Check">
					<!-- <div id="main"> -->





					<div>

						<div class="field">

							<label for="memberId">EMAIL</label>

							<div class="row">

								<div class="col-8 col-8-small">
									<input type=text name="memberId" value="${memberId}">
								</div>

								<div class="col-2 col-2-small">
									<input type=submit value="중복 체크"> <br>
								</div>

							</div>
						</div>

						<div class="field">
							<hr>
							<div class="row">

								<c:if test="${result == 1}">
									<div class="col-8 col-8-small">
										<script type="text/javascript">
											opener.document.frm.memberId.value = "";
										</script>

										${memberId}는 이미 사용 중인 EMAIL입니다.
										<div class="col-2 col-2-small"></div>

									</div>
								</c:if>


								<c:if test="${result==-1}">
									<div class="col-8 col-8-small">${memberId}는 사용 가능한
										EMAIL입니다.</div>

									<div class="col-2 col-2-small">
										<input type="button" value="사용" class="cancel"
											onclick="idok('${memberId}')">
									</div>

								</c:if>

							</div>

						</div>


						<div id="msg"></div>

						<div></div>

					</div>


				</form>

			</section>

		</footer>
	</div>



	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery.scrollex.min.js"></script>
	<script src="assets/js/jquery.scrolly.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>
</body>

<script>
	function idok(memberId) {
		opener.fm.memberId.value = document.fm.memberId.value;
		opener.fm.memberId.value = document.fm.memberId.value;
		opener.fm.reid.value = document.fm.memberId.value;
		self.close();
	}
</script>

</html>