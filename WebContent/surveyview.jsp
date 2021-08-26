<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>PGI 설문조사</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
</head>

<style>
table {
	width: 100%;
	background-color: #f1f1f2;
}
table > thead > tr > th {
	z-index:100;
	font-weight: 400;
	color: #fff;
	border-bottom: 1px solid rgba(0, 0, 0, 0.12);
	
}
table > tbody > tr > td {
	z-index:1;
	text-align: center;
	border-bottom: 1px solid rgba(0, 0, 0, 0.12);
	
}
.container {
	height: 500px;
	overflow: auto;
	
}
.fixedHeader {
	position: sticky;
	background-color: gray;
	top: 0;
}
</style> 

<script type="text/javascript">
	function modify_click(url_param) {

		var isCheck = false;

		for (j = 1; j <= 40; j++) {

			isCheck = check_radio('L' + j);
			if (!isCheck) {
				break;
			}
		}

		if (isCheck) {

			for (j = 1; j <= 40; j++) {

				isCheck = check_radio('C' + j);
				if (!isCheck) {
					break;
				}
			}

		}

		if (isCheck) {

			if (confirm('설문조사를 완료 하시겠습니까?')) {

				location.replace(url_param);

			} else {

				return false;
			}

		} else {

			return false;
		}

	}

	function check_radio(RadioName) {
		var isCheck = false;
		for (var i = 0; i < document.fm[RadioName].length; i++) {

			if (document.fm[RadioName][i].checked == true) {
				isCheck = true;
				break;
			}
		}

		if (isCheck) {

			return true;

		} else {

			alert('선택하지 않은 문항이 있습니다.');
			document.fm[RadioName][0].focus();
			return false;
		}
	}

	function f_logout() {
		if (confirm('설문을 종료하고 나가시겠습니까? 기존의 설문은 삭제됩니다.')) {

		location.href = "member?command=ing_logout";
		

		}
		
	}

	window.history.forward();
	function noBack() {
		var example_value = "<c:out value='${memberId}' />";
		if (example_value == '') {
			location.href = "/PGI_SURVEY";
		}
		window.history.forward();
	}
</script>





<body class="is-preload" onload="noBack();"
	onpageshow="if(event.persisted) noBack();" onunload="">

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Header -->
		<header id="header">
			<a href="#" class="logo">HANNAM<br/> UNIVERSITY
			</a>
		</header>

		<!-- Nav -->
		<nav id="nav">
			<ul class="links">
            <li class="active" style="background-color:white;"><font color="black">&nbsp;&nbsp;40직무 능력 설문&nbsp;&nbsp;</font></li>
         </ul>
			<ul class="actions">
				<c:if test="${memberId ne ''}">
					<li><a href="javascript:f_logout();" class="button small" style=background-color:white>로그아웃</a></li>
				</c:if>
			</ul>
		</nav>

		<!-- Main -->
		<div id="main">

			<!-- Post -->
			<section class="post">
				<!-- Table -->
				<form name="fm" method="post" action="occupation"
					onsubmit="return modify_click(this);">
					<input type="hidden" name="command" value="occupation_lc_write">

					<h3>2. 40가지 직무에 대한 선호도/수행 능력 설문조사</h3>

					
						다음은 40가지의 직무에 대한 선호도를 나열하고 있습니다. 각 직무에 대한 여러분의 선호에 따라 1부터 7까지의 점수를 선택하세요.
					<br> 활동에 대한 선호는 1 = "완전히 싫어함"에서 7 =
						"매우 좋아함"까지 점수를 매겨 이러한 활동을 얼마나 좋아하거나 싫어하는 지에 대한 생각을 표시하십시오.
				<div class='container'>
						<table>
						<thead>
							<tr>
                        		<th class='fixedHeader'><br>NO</th>
                        		<th class='fixedHeader'><br>직무에 대한 선호</th>
                        		<th class='fixedHeader'>완전히<br>싫어함<br>(1)</th>
                        		<th class='fixedHeader'><br>싫어함<br>(2)</th>
                        		<th class='fixedHeader'>약간<br>싫어함<br>(3)</th>
                        		<th class='fixedHeader'>보통<br>이다<br>(4)</th>
                        		<th class='fixedHeader'>약간<br>좋아함<br>(5)</th>
                        		<th class='fixedHeader'><br>좋아함<br>(6)</th>
                        		<th class='fixedHeader'>매우<br>좋아함<br>(7)</th>
                     		</tr>
                           </thead>
							

							<c:forEach var="occDesc" items="${surveyList}" varStatus="status">
								<tr>
									<td style="text-align: center">${status.count}</td>
									<td style="text-align: center">${occDesc.occName}</td>

									<td style="text-align: center"><input
										name="L${occDesc.occNumber}" type="radio"
										id="demo-priority-low1 ${occDesc.occNumber}" value="1" /><label
										for="demo-priority-low1 ${occDesc.occNumber}"></label></td>


									<td style="text-align: center"><input
										name="L${occDesc.occNumber}" type="radio"
										id="demo-priority-low2 ${occDesc.occNumber}" value="2" /><label
										for="demo-priority-low2 ${occDesc.occNumber}"></label></td>

									<td style="text-align: center"><input
										name="L${occDesc.occNumber}"
										id="demo-priority-low3 ${occDesc.occNumber}" type="radio"
										value="3" /><label
										for="demo-priority-low3 ${occDesc.occNumber}"></label></td>

									<td style="text-align: center"><input
										name="L${occDesc.occNumber}"
										id="demo-priority-low4 ${occDesc.occNumber}" type="radio"
										value="4" /><label
										for="demo-priority-low4 ${occDesc.occNumber}"></label></td>

									<td style="text-align: center"><input
										name="L${occDesc.occNumber}"
										id="demo-priority-low5 ${occDesc.occNumber}" type="radio"
										value="5" /><label
										for="demo-priority-low5 ${occDesc.occNumber}"></label></td>

									<td style="text-align: center"><input
										name="L${occDesc.occNumber}"
										id="demo-priority-low6 ${occDesc.occNumber}" type="radio"
										value="6" /><label
										for="demo-priority-low6 ${occDesc.occNumber}"></label></td>

									<td style="text-align: center"><input
										name="L${occDesc.occNumber}"
										id="demo-priority-low7 ${occDesc.occNumber}" type="radio"
										value="7" /><label
										for="demo-priority-low7 ${occDesc.occNumber}"></label></td>
								</tr>
							</c:forEach>
						</table>
					</div>
					
					다음은 40가지의 직무에 대한 수행 능력을 나열하고 있습니다. 각 직무에 대한 여러분의 선호에 따라 1부터 7까지의 점수를 선택하세요.
					<br> 활동 수행
						능력은 1 = "전혀 가능하지 않음"에서 7 = "매우 가능함"까지 점수로 매겨 이러한 활동을 얼마나 가능한지 불가능 한지에 대한 생각을 표시하십시오.
						
<div class='container'>
						<table>
						<thead>
							<tr>
                        		<th class='fixedHeader'><br>NO</th>
                        		<th class='fixedHeader'><br>직무 수행 능력</th>
                        		<th class='fixedHeader'>전혀가능<br>하지않음(1)</th>
                        		<th class='fixedHeader'>가능<br>하지않음(2)</th>
                        		<th class='fixedHeader'>약간가능<br>하지않음(3)</th>
                        		<th class='fixedHeader'>보통<br>이다<br>(4)</th>
                        		<th class='fixedHeader'>약간<br>가능함<br>(5)</th>
                        		<th class='fixedHeader'><br>가능함<br>(6)</th>
                        		<th class='fixedHeader'>매우<br>가능함<br>(7)</th>
                     		</tr>
							</thead>


							<c:forEach var="occDesc" items="${surveyList}" varStatus="status">
								<tr>
									<td style="text-align: center">${status.count}</td>
									<td style="text-align: center">${occDesc.occName}</td>

									<td style="text-align: center"><input
										name="C${occDesc.occNumber}" type="radio"
										id="demo-priority-lowc1 ${occDesc.occNumber}" value="1" /><label
										for="demo-priority-lowc1 ${occDesc.occNumber}"></label></td>


									<td style="text-align: center"><input
										name="C${occDesc.occNumber}" type="radio"
										id="demo-priority-lowc2 ${occDesc.occNumber}" value="2" /><label
										for="demo-priority-lowc2 ${occDesc.occNumber}"></label></td>

									<td style="text-align: center"><input
										name="C${occDesc.occNumber}"
										id="demo-priority-lowc3 ${occDesc.occNumber}" type="radio"
										value="3" /><label
										for="demo-priority-lowc3 ${occDesc.occNumber}"></label></td>

									<td style="text-align: center"><input
										name="C${occDesc.occNumber}"
										id="demo-priority-lowc4 ${occDesc.occNumber}" type="radio"
										value="4" /><label
										for="demo-priority-lowc4 ${occDesc.occNumber}"></label></td>

									<td style="text-align: center"><input
										name="C${occDesc.occNumber}"
										id="demo-priority-lowc5 ${occDesc.occNumber}" type="radio"
										value="5" /><label
										for="demo-priority-lowc5 ${occDesc.occNumber}"></label></td>

									<td style="text-align: center"><input
										name="C${occDesc.occNumber}"
										id="demo-priority-lowc6 ${occDesc.occNumber}" type="radio"
										value="6" /><label
										for="demo-priority-lowc6 ${occDesc.occNumber}"></label></td>

									<td style="text-align: center"><input
										name="C${occDesc.occNumber}"
										id="demo-priority-lowc7 ${occDesc.occNumber}" type="radio"
										value="7" /><label
										for="demo-priority-lowc7 ${occDesc.occNumber}"></label></td>
								</tr>
							</c:forEach>
						</table>
					</div>

					<div style='width: 93px; float: right; padding-top:20px;'>
						<ul class="actions">
							<li><input type="submit" class='btn' name='btn' value='완료'
								style="float: right;"></li>
						</ul>
					</div>

				</form>
			</section>
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