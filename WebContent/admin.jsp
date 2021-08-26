<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Pragma" content="no-cache" />
<!--반응형웹-->
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" /> 

<title>PGI 설문조사</title>
<link rel="stylesheet" href="assets/css/main.css" />
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet">
<style>
.ns {
	font-family: 'Noto Sans KR', sans-serif;
}
</style>
</head>

<script type="text/javascript">
	window.history.forward();
	function noBack() {
		var example_value = "<c:out value='${memberId}' />";
		if (example_value == '') {
			location.href = "/PGI_SURVEY";
		}
		window.history.forward();
	}

	function f_check() {
		var example_value = "<c:out value='${memberId}' />";
		if (example_value == '') {
			location.href = "/PGI_SURVEY";
		}
	}

	function f_logout() {
		location.href = "member?command=logout";
	}

	function f_108_download() {
		location.href = "occupation?command=excel108";
	}

	function f_l40_download() {
		location.href = "occupation?command=excell40";
	}

	function f_c40_download() {
		location.href = "occupation?command=excelc40";
	}
</script>
<!--뒤로가기 없앰-->
<body class="is-preload" onload="noBack();" onpageshow="if(event.persisted) noBack();" onunload="">

	<!-- Wrapper -->
	<div id="wrapper" class="fade-in">
		<!-- Header -->
		<header id="header">
			<div class="logo">HANNAM<br>UNIVERSITY</div>
		</header>
		<!-- Nav -->
		<nav id="nav">
			<ul class="links">
            <li class="active" style="background-color:white;"><font color="black">&nbsp;&nbsp;관리자 페이지&nbsp;&nbsp;</font></li>
         </ul>
			<ul class="actions">
				<c:if test="${memberId ne ''}">
					<li><a href="javascript:f_logout();" class="button small" style=background-color:white>로그아웃</a></li>
				</c:if>
			</ul>
		</nav>

		<!-- Main -->
		<div id="main">
			<article>
            <h2>직업 척도 설문</h2>
            <h4>
               사용자들이 설문한 결과입니다. <br> 총 3가지 설문을 통해 나온 결과값이며 각각의 설문에 대해 몇 명의
               사용자가 설문을 완료했는지 알 수 있습니다.<br> 각각의 설문 결과를 엑셀 파일로 필요시 밑의 버튼을 통해
               다운로드가 가능합니다.
            </h4>
         </article>
					<div class="table-wrapper">
						<table style="text-align:center;">
						<thead>
							<tr>
								<th style="text-align:center;">108개의 직업에 관한 설문 사용자 수</th>
								<th style="text-align:center;">활동에 대한 설문 사용자 수</th>
								<th style="text-align:center;">활동을 수행 능력 설문 사용자 수</th>
							</tr>
							</thead>
							<tr>
								<td>${occup_108}</td>
								<td>${occup_l40}</td>
								<td>${occup_c40}</td>
							</tr>
						</table>
						</div>
						<div class="row">
						<div class="col-12 col-12-small col-12-xsmall">
						<h3>직업 척도 설문 결과 엑셀 다운로드</h3>
						</div>
						<div class="col-12 col-12-small col-12-xsmall">
						<ul class="actions">
						<li><a href="#" class="button" onclick="f_108_download();">108개의 직업에 관한 선호도</a></li>
						<li><a href="#" class="button" onclick="f_l40_download();">활동에 대한 선호도</a></li>
						<li><a href="#" class="button" onclick="f_c40_download();">활동을 수행할 수 있는 능력</a></li>
						</ul>
						</div>
						</div>
			</div>
		<!-- 		</div> -->


		<div id="copyright">
			<ul>
				<li><a href="http://www.hannam.ac.kr/main/">한남대학교</a></li>
				<li><a href="http://gitb.hannam.ac.kr/main/">글로벌IT경영전공</a></li>
			</ul>
		</div>


	</div>

	<!-- Scripts -->
	<!-- <script src="html5up-massively/assets/js/jquery.min.js"></script>
	<script src="html5up-massively/assets/js/jquery.scrollex.min.js"></script>
	<script src="html5up-massively/assets/js/jquery.scrolly.min.js"></script>
	<script src="html5up-massively/assets/js/browser.min.js"></script>
	<script src="html5up-massively/assets/js/breakpoints.min.js"></script>
	<script src="html5up-massively/assets/js/util.js"></script>
	<script src="html5up-massively/assets/js/main.js"></script>
 -->
</body>
</html>