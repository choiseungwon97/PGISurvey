<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>PGI 설문조사</title>
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

		<!-- Intro -->
		<div id="intro">

			<h1>
				HANNAM<br /> UNIVERSITY
			</h1>

			<p>
				 직업 및 직무에 관한 설문조사입니다.<br>성심성의껏 설문해주세요
			</p>

			<!--아래화살표 버튼-->
			<!-- <ul class="actions">
				<li><a href="#header"
					class="button icon solid solo fa-arrow-down scrolly">로그인 화면으로
						이동</a></li>
			</ul> -->
		</div>

		<!-- Header -->
		<header id="header">
			<a href="member?command=login_form" class="logo">인적 글로브 목록 <br>
				직업/ 직무 설문조사
			</a>
		</header>

		<!-- Nav -->
		<nav id="nav">
			<ul class="links">
            <li class="active" style="background-color:white;"><font color="black">&nbsp;&nbsp;Main&nbsp;&nbsp;</font></li>
         </ul>
		</nav>

		<!-- Main -->
		<div id="main">
					
			<section class="posts">
								<article>
									<header>
										<h2>직업 및 직무<br />선호도 설문조사</h2>
									</header> 
									<div class="image fit"><img src="images/occupation.png" alt="" /></div>
									<p>108 가지의 다양한 직업과 40가지 직무에 대한 선호도 및 수행 능력 설문 조사입니다. </p>
									
								</article>
								<article>
									<header>
										<h2>직무에 대한<br />
										 선호도 및 능력 설문 결과</h2>
									</header>
									<div class="image fit"><img src="images/result.png" alt="" /></div>
									<p>설문조사를 통한 결과로 그래프를 통해 사용자의 기본 관심 분야와 관련 직업군을 알려줍니다.</p>
									
								</article>
			</section>
			<!-- Featured Post -->
			<form name="fm" method="post" action="member">
				<article class="post featured">
					<ul class="actions special">
						<li><a href="member?command=login_form" class="button" >로그인</a></li>
						<li><a href="member?command=member_write_form" class="button">회원가입</a></li>
					</ul>

				</article>
			</form>
		</div>

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


</html>