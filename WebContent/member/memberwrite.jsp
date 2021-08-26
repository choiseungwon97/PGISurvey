<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>PGI 설문조사</title>

<style>
@import url(//fonts.googleapis.com/earlyaccess/jejugothic.css);

.jg {
	font-family: 'Jeju Gothic', sans-serif;
}
</style>

<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />

<link rel="stylesheet" href="assets/css/main.css" />

<noscript>
	<link rel="stylesheet" href="assets/css/noscript.css" />
</noscript>

</head>

<body class="is-preload">

	<!-- Wrapper -->
	<div id="wrapper" class="fade-in">

		<!-- Header -->
		<header id="header">
			<a href="" class="logo">Hannam <br> University</a>
		</header>


		<!-- 회원가입 -->
		<!-- Footer -->
		<footer id="footer">
			<section>
				<form name="fm" method="post" action="member">
					<input type="hidden" name="command" value="member_write">
					<div id="main">

						<div>
							<div>
								<article class="post featured">
									<header class="major">
										<span class="ns"> <b>회원 가입</b> </span>
									</header>
								</article>
							</div>

							<div class="field">



								<label for="memberId">EMAIL<span style="color:red">*</span></label>

								<div class="row">

									<div class="col-10 col-12-small">
										<input type="text" name="memberId" value="" /> <input
											type="hidden" name="reid">
									</div>
									<div class="col-2 col-12-small">

										<ul class="actions fit">
											<li><a href="#" class="button primary fit"
												onclick="idCheck()">중복확인</a></li>
										</ul>
									</div>
								</div>


							</div>

							<div class="field">
								<label for="memberPw">비밀번호<span style="color:red">*</span></label> <input type="password"
									name="memberPw" value="" />
							</div>

                            <div class="field">
								<label for="memberLName">성명(성)<span style="color:red">*</span></label> <input type="text"
									name="memberLName" value="" />
							</div>

							<div class="field">
								<label for="memberFName">성명(이름)<span style="color:red">*</span></label> <input type="text"
									name="memberFName" value="" />
							</div>

							<div class="field">
								<label for="memberAge">나이<span style="color:red">*</span></label> <input type="text"
									name="memberAge" value="" />
							</div>

							<div class="field">
								<label for="memberGender">성별<span style="color:red">*</span></label> <select class="jg"
									name="memberGender">
									<option value="">선택</option>
									<option value="M">남성</option>
									<option value="F">여성</option>
								</select>
							</div>

							<div class="field">
								<label for="memberMajor">전공</label> <input type="text"
									name="memberMajor" value="" />
							</div>

							<div class="field">
								<label for="memberJob">현재 직업</label> <input type="text"
									name="memberJob" value="" />
							</div>

							<div class="field">
								<label for="memberFjob">아버지 직업</label> <input type="text"
									name="memberFjob" value="" />
							</div>

							<div class="field">
								<label for="memberMjob">어머니 직업</label> <input type="text"
									name="memberMjob" value="" />
							</div>

							<!-- 나중에 쓸 곳 있으면 가져다 쓰세요^^
                           <div class="field">
                              <label for="message">Message</label>
                              <textarea name="message" id="message" rows="3"></textarea>
                           </div>
                           -->
							<br>
							<div>
								<div class="col-12 col-12-small">
									<ul class="actions fit">
										<li><input class="button primary fit" type="submit"
											onclick="return validation()" value="회원가입" /></li>
										<li><input class="button fit" type="submit"
											onclick="javascript:cancel_click()" value="취소" /></li>
									</ul>
								</div>

								<article class="post featured"></article>
							</div>
						</div>
					</div>
				</form>
			</section>
		</footer>

		<!-- Copyright -->
		<div id="copyright">
		<ul>
			<li><a href="http://www.hannam.ac.kr/main/">한남대학교</a></li>
			<li><a href="http://gitb.hannam.ac.kr/main/">글로벌IT경영전공</a></li>
		</ul>
	</div>

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


<script type="text/javascript">
	function move_page(val) {
		location.href = "member?command=" + val;
	}

	function f_logout() {
		location.href = "member?command=logout";
	}
</script>


<script type="text/javascript">
	function cancel_click() {

		var form = document.fm;

		form.action = "home";
		form.submit();
	}

	function validation() {

		if (document.fm.reid.value.length == 0) {
	         
	         alert("EMAIL 중복 확인을 해주세요.");
	         fm.memberId.focus();
	         return false;
	         
	      }
		if (document.fm.memberPw.value == '') {

			alert('PASSWORD를 입력해주세요');
			document.fm.memberPw.focus();
			return false;

		}
		if (document.fm.memberFName.value == '') {

			alert('이름(FIRST NAME)를 입력해주세요');
			document.fm.memberFName.focus();
			return false;

		}
		if (document.fm.memberLName.value == '') {

			alert('이름(LAST NAME)를 입력해주세요');
			document.fm.memberLName.focus();
			return false;

		}
		if (document.fm.memberAge.value == '') {
			alert('나이를 입력해주세요');
			document.fm.memberAge.focus();
			return false;

		}
		if (document.fm.memberGender.value == '') {

			alert('성별을 선택해주세요');
			document.fm.memberGender.focus();
			return false;

		}

		return true;
	}

	function idCheck() {
		if (document.fm.memberId.value == "") {
			alert('EMAIL을 입력하여 주십시오.');
			document.fm.memberId.focus();
			return;
		}
		var url = "member?command=member_Id_Check&memberId="
				+ document.fm.memberId.value;
		window
				.open(url, "_blank_1",
						"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=330");
	}
</script>




</html>