<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String contextName = request.getContextPath();
	String jspBasePath = contextName + "/";
	String imgPath = contextName + "/images";
	String formAction = contextName + "/";
%>
<html>
<head>
<script src="js/html2canvas.js"></script>
<script src="js/jspdf.min.js"></script>
<title>PGI 설문조사</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
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
<noscript>
	<link rel="stylesheet" href="assets/css/noscript.css" />
</noscript>
</head>
<script type="text/javascript">
	window.history.forward();
	function noBack() {
		var example_value = "_$tag________________________";
		if (example_value == '') {
			location.href = "/PGI_SURVEY";
		}
		window.history.forward();
	}

	function f_check() {
		var example_value = "_$tag________________________";
		if (example_value == '') {
			location.href = "/PGI_SURVEY";
		}
	}

	function f_logout() {
		location.href = "member?command=logout";
	}

	var _gaq = _gaq || [];
	_gaq.push([ '_setAccount', 'UA-23019901-1' ]);
	_gaq.push([ '_setDomainName', "bootswatch.com" ]);
	_gaq.push([ '_setAllowLinker', true ]);
	_gaq.push([ '_trackPageview' ]);

	(function() {
		var ga = document.createElement('script');
		ga.type = 'text/javascript';
		ga.async = true;
		ga.src = ('https:' == document.location.protocol ? 'https://ssl'
				: 'http://www')
				+ '.google-analytics.com/ga.js';
		var s = document.getElementsByTagName('script')[0];
		s.parentNode.insertBefore(ga, s);
	})();
</script>

<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.bundle.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"></script>

<style>
canvas {
	-moz-user-select: none;
	-webkit-user-select: none;
	-ms-user-select: none;
}

.max-small {
	width: auto;
	height: auto;
	max-width: 300px;
	max-height: 300px;
}
</style>
<body class="is-preload">

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Header -->
		<header id="header">
			<a class="logo">설문 결과</a>
		</header>

		<!-- Nav -->
		<nav id="nav">


			<ul class="links">
				<li class="active" style="background-color: white;"><font
					color="black">&nbsp;&nbsp;설문 결과&nbsp;&nbsp;</font></li>
			</ul>




			<ul class="actions">
				<li>
					<button type="button" class="button small" id="savePdf" style=background-color:white>PDF
						저장</button>
				</li> &nbsp;&nbsp;&nbsp;
			</ul>




			<ul class="actions">
				<c:if test="${memberId ne ''}">
					<li><a href="javascript:f_logout();" class="button small" style=background-color:white >로그아웃</a></li>
				</c:if>
			</ul>
		</nav>

		<!-- pdf캡쳐 시작점 -->
		<div id="pdfDiv">
			<!-- Main -->
			<div id="main">
				<!-- Post -->
				<section class="post">
					<div style="margin: auto; text-align: center;">
						<header>
							<font color="black" size="6px">인적 글로브 목록  직업/직무 설문조사 </font>
						</header>
					</div>
					<br>
					<div class="table-wrapper">
					
					<br>
<br>
<div>
								<article class="post featured">
									<header class="major">
										<span class="date"> <b>직무 선호 결과</b> </span>
									</header>
								</article>
							</div>
						
						<canvas id="likeChart"></canvas>
						<div class="row">

							<div class="span6" style="width: 99%; float: left;">

								<table id="tbl1">
									<thead>
										<tr>
											<th></th>
										</tr>
										<tr style="text-align: center;">
											<th class="ns">순위</th>
											<th class="ns">직업</th>
											<th class="ns">점수</th>

										</tr>
									</thead>


									<c:forEach var="like" items="${LBresultList}"
										varStatus="status">

										<tr style="text-align: center;">

											<td class="ns">${status.count}</td>
											<td class="ns">${like.name}</td>
											<td class="ns">${like.value}</td>


										</tr>
									</c:forEach>
								</table>
							</div>

						</div>

						<br>
<br>
<div>
								<article class="post featured">
									<header class="major">
										<span class="date"> <b>직무 수행 능력 결과</b> </span>
									</header>
								</article>
							</div>

						
						<canvas id="myCarrerChart"></canvas>
						<div class="row">

							<div class="span6" style="width: 99%; float: left;">

								<table id="tbl1">
									<thead>
										<tr>
											<th></th>
										</tr>
										<tr style="text-align: center;">
											<th class="ns">순위</th>
											<th class="ns">직업</th>
											<th class="ns">점수</th>

										</tr>
									</thead>
									<c:forEach var="competence" items="${CBresultList}"
										varStatus="status">
										<tr style="text-align: center;">
											<td class="ns">${status.count}</td>
											<td class="ns">${competence.name}</td>
											<td class="ns">${competence.value}</td>
										</tr>
									</c:forEach>
								</table>
							</div>



						</div>
						<br>
<br>
<div>
								<article class="post featured">
									<header class="major">
										<span class="date"> <b>설문결과 상세설명</b> </span>
									</header>
								</article>
							</div>



						
						<table>
							<colgroup>
								<col width="8%">
								<col width="50%">
							</colgroup>
							
							
							<tr>
									<th class="ns" style="text-align: center;">분야</th>

									<th class="ns" style="text-align: center;">설명</th>

								</tr>
							
							<tr>
								<td class="ns" style="text-align: center;">사회적 촉진</td>
								<td class="ns">이 척도는 정보를 영업, 지원, 지식 제공, 또는 그러한 서비스의 운영을 통해
									다른 사람들과 일하는 것에 대한 관심을 측정합니다. <br> 이 척도에서 높은 점수를받은 직업의 예로는
									<b>사회 복지 국장, 인사 부장, 홍보</b> <br>
								</td>
							</tr>
							<tr>
								<td class="ns" style="text-align: center;">관리</td>
								<td class="ns">이 척도가 높은 사람은 비즈니스 또는 조직의 주요 활동을 관리하고 계획하는 데
									관심이 있습니다. <br>정보 처리, 문제 해결 및 의사 결정, 예측 및 사전 계획, 다른 사람과의 의사
									소통, 다른 사람의 조직, 조정 및 감독, 설득과 같은 활동이 포함됩니다. 이 척도에서 높은 점수를받은 직업의
									예로는 <b>사무실 관리자, 백화점 관리자, 영업 사무원, 영업 관리자 및 호텔 관리자</b>가 있습니다.<br>

								</td>
							</tr>

							<tr>
								<td class="ns" style="text-align: center;">비즈니스 세부 정보</td>
								<td class="ns">이 척도에서 높은 점수를받은 사람들의 관심사는 회계, 평가, 추정, 조언 및
									예산 책정 등 입니다.<br> <b>재무 분석가, 은행 심사관, 비용 산정 관 및 공인 회계사</b>와
									같은 직업이 이 분야와 관련이 있습니다.<br>
								</td>
							<tr>
								<td class="ns" style="text-align: center;">데이터 처리</td>
								<td class="ns">이 척도는 데이터 분석 및 해석과 기술적 문제를 명확히하고 해결하기위한 수학 및
									시스템 사용에 대한 관심도를 나타냅니다 . <br> 이 척도에서 높은 점수를받은 직업의 예로는 <b>전기
										기술자, 컴퓨터 전기 엔지니어, 컴퓨터 프로그래머 및 마이크로 일렉트로닉스 기술자</b>가 있습니다.<br>
								</td>
							</tr>

							<tr>
								<td class="ns" style="text-align: center;">기계</td>
								<td class="ns">이 척도는 기계 작동 방식을 이해하고 기계를 설계, 설치 및 유지 관리하는 것에
									대한 관심도를 나타냅니다. <br> 기계에는 공작 기계에 대한 대형 엔진이 포함됩니다. 직업의 예로는 <b>비행기
										기계공, 자동차 기계공, 항공 공학 기술자, 화학 엔지니어 및 기계공</b>이 있습니다. <br>
								</td>
							</tr>
							<tr>
								<td class="ns" style="text-align: center;">자연/야외</td>
								<td class="ns">이 분야는 생명 과학에 대한 지식을 식물과 동물에 적용하는 것과 관련되어
									있으며, <br> 관련된 직업은 <b>생태 학자, 산림 관리인, 해양 학자, 자연 주의자, 물고기
										및 게임 감시인, 수의사</b>등이 해당됩니다. <br>
								</td>
							</tr>
							<tr>
								<td class="ns" style="text-align: center;">예술</td>
								<td class="ns">이 척도는 <b>조각가, 음악가, 작곡가, 시인, 극작가 및 작가</b>와 같은
									직업에서 표현되는 시각, 공연 및 문학 예술에 대한 관심을 측정합니다.
								</td>
							</tr>
							<tr>
								<td class="ns" style="text-align: center;">도움</td>
								<td class="ns">이 척도는 모든 연령대의 사람들과의 관계를 돕는데 대한 관심도를 나타냅니다. <br>
									이 척도가 높은 사람들은 가르치고, 제공하고, 지원하고, 상담하는 것을 좋아하며, 직업으로 <b>언어
										치료사, 학교 카운슬러, 사회 복지사, 보육사, 가족 치료사 및 교육 심리학자</b>가 있습니다. <br>
								</td>
							</tr>



						</table>
					</div>
			</div>
		</div>
	</div>

	<div id="copyright">
		<ul>
			<li><a href="http://www.hannam.ac.kr/main/">한남대학교</a></li>
			<li><a href="http://gitb.hannam.ac.kr/main/">글로벌IT경영전공</a></li>
		</ul>
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
	var ctx = document.getElementById('likeChart');

	var data_car = new Array();

	<c:forEach items="${LBresultList}" var="like">
	data_car.push("${like.value}");
	</c:forEach>

	var myRadarJobChart = new Chart(ctx,
			{
				type : 'radar',
				data : {
					labels : [ '관리', '기술직', '도움', '사회봉사', '상업', '예술', '자연/야외',
							'정보처리' ],
					datasets : [ {
						label : '선호도',
						borderColor : [ 'rgba(54, 162, 235, 1)' ],
						backgroundColor : [ 'rgba(54, 162, 235, 0.2)' ],
						pointBackgroundColor : [ 'rgba(54, 162, 235, 1)' ],
						data : data_car
					//[ 6, 13, 9, 14, 9, 8, 8, 10 ]
					} ]
				},

				options : {
					legend : {
						position : 'top',
					},
					title : {
						display : true,
						text : '직무에 대한 선호'
					},
					scale : {
						beginAtZero : true,
						ticks : {
							suggestedMin : 1,
							suggestedMax : 35
						}
					}
				}

			});
</script>

<script>
	var ctx = document.getElementById('myCarrerChart');

	var data_car = new Array();

	<c:forEach items="${CBresultList}" var="competence">
	data_car.push("${competence.value}");
	</c:forEach>

	var myRadarCarrerChart = new Chart(ctx,
			{
				type : 'radar',
				data : {
					labels : [ '관리', '기술직', '도움', '사회봉사', '상업', '예술', '자연/야외',
							'정보처리' ],
					datasets : [ {
						label : '수행 능력',
						borderColor : [ 'rgba(75, 192, 192, 1)' ],
						backgroundColor : [ 'rgba(75, 192, 192, 0.2)' ],
						pointBackgroundColor : [ 'rgba(75, 192, 192, 1)' ],
						data : data_car
					//[ 6, 13, 9, 14, 9, 8, 8, 10 ]
					} ]
				},

				options : {
					legend : {
						position : 'top',
					},
					title : {
						display : true,
						text : '직무 수행 능력'
					},
					scale : {
						beginAtZero : true,
						ticks : {
							suggestedMin : 1,
							suggestedMax : 35
						}
					}
				}

			});
</script>

<script>
	$(document).ready(
			function() {
				$('#savePdf').click(
						function() { // pdf저장 button id

							html2canvas($('#pdfDiv')[0]).then(
									function(canvas) { //저장 영역 div id

										// 캔버스를 이미지로 변환
										var imgData = canvas
												.toDataURL('image/png');

										var imgWidth = 190; // 이미지 가로 길이(mm) / A4 기준 210mm
										var pageHeight = imgWidth * 1.414; // 출력 페이지 세로 길이 계산 A4 기준
										var imgHeight = canvas.height
												* imgWidth / canvas.width;
										var heightLeft = imgHeight;
										var margin = 10; // 출력 페이지 여백설정
										var doc = new jsPDF('p', 'mm');
										var position = 0;

										// 첫 페이지 출력
										doc.addImage(imgData, 'PNG', margin,
												position, imgWidth, imgHeight);
										heightLeft -= pageHeight;

										// 한 페이지 이상일 경우 루프 돌면서 출력
										while (heightLeft >= 20) {
											position = heightLeft - imgHeight;
											doc.addPage();
											doc.addImage(imgData, 'PNG', 0,
													position, imgWidth,
													imgHeight);
											heightLeft -= pageHeight;
										}

										// 파일 저장
										doc.save('survey_result.pdf');

									});

						});

			})
</script>


</html>