<%@ page contentType= "text/html;charset=euc-kr" %>
<%@ page import = "java.io.*" %>
<%@ page import = "java.util.*" %>

<%
String jspBasePath = "/mis/jsp/";
String imgPath = jspBasePath + "/images";
%>

<%! int year;
	int month;
	int date;
	int dayofweek;  //첫번째 날의 요일
	int days;  //그달의 날짜수
	int nowyear; //현재의 년도
	int nowmonth;  //현재의 월
	int nowdate;  //현재의 일
	String nowweek;  //현재의 요일
	
%>

<%    
/**********          현재 년월일시를 구한다.                **********/
/**********          처음 불러올때 이값을 사용한다.          **********/
	Calendar now = Calendar.getInstance();
	year =now.get(Calendar.YEAR);
	month = now.get(Calendar.MONTH)+1;
	date = now.get(Calendar.DATE);
	dayofweek = now.get(Calendar.DAY_OF_WEEK);
	nowyear = year;
	nowmonth = month;
	nowdate = date;
/**********          년 월 값을 받는다.                    **********/


/**********          년 월을 변경했을때 사용하다.          **********/
	String reqyear = request.getParameter("year");
	String reqmonth = request.getParameter("month");
	String reqdate = request.getParameter("date");
		
//	String strGubun = CommonUtil.encodeHTMLSpecialChar(request.getParameter("f"), 24); 
	String strGubun =request.getParameter("f"); 
/**********          받은 값을 mode에따라 처리를 한다.                      **********/
/**********          처음 시작하면 reqyear, reqmonth는 null 이므로          **********/
	int curyear;
	int curmonth;
	int curdate;
	int curdayofweek;

	if ( (reqyear == null || reqyear.equals("") || reqyear.equals("null")) && (reqmonth == null || reqmonth.equals("") || reqmonth.equals("null")) ){
		curyear = year;
		curmonth = month-1;
		curdate = nowdate;
	}else{
			curyear = Integer.parseInt(reqyear);
			curmonth = Integer.parseInt(reqmonth)-1;
			curdate = Integer.parseInt(reqdate);
	}
	
/**********          값을 받아서 세팅을 한다.          **********/
/**********          원하는 년,월,일을 설정!          **********/
	now.set(Calendar.YEAR,curyear);	
	now.set(Calendar.MONTH,curmonth);
	now.set(Calendar.DATE,1);

	
/**********          세팅된 내용의 년,월,일을 얻어 온다.          **********/
	year =now.get(Calendar.YEAR);//년도
	month = now.get(Calendar.MONTH)+1;//월
	date = now.get(Calendar.DATE);//날짜
	int blank = now.get(Calendar.DAY_OF_WEEK);//요일

/**********          년,월,일,날짜수를 출력 한다.          **********/
	if ((nowyear == year) && (nowmonth == month)){  //현재 년,월일 같을면
		curdayofweek = now.get(Calendar.DAY_OF_WEEK);
		if(reqdate == null || reqdate.equals("") || reqdate.equals("null")){
			date= nowdate;
		}else{
			date = Integer.parseInt(reqdate);
		}
		curdayofweek = (curdayofweek+((date-1)%7))%7;
	}else{
		curdayofweek = now.get(Calendar.DAY_OF_WEEK);
		if(reqdate == null || reqdate.equals("") || reqdate.equals("null")){
			date= nowdate;
		}else{
			date = Integer.parseInt(reqdate);
		}
		curdayofweek = (curdayofweek+((date-1)%7))%7;
	}
	switch (curdayofweek){
		case	1:
				nowweek = "일";
				break;
		case	2:
				nowweek = "월";
				break;
		case	3:
				nowweek = "화";
				break;
		case	4:
				nowweek = "수";
				break;
		case	5:
				nowweek = "목";
				break;
		case	6:
				nowweek = "금";
				break;
		default:
				nowweek = "토";
				break;
	}
	switch (month){
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			days = 31; break;
		case 4:
		case 6:
		case 9:
		case 11:
			days = 30; break;
		default:
			if((year % 4 ==0) &&(year % 100 !=0 ) ||(year % 400 ==0)){
				days = 29;
			}else{
				days = 28;
			}
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<title>▒▒▒ 주문관리시스템 ▒▒▒</title>
<link href="/mis/jsp/css/cal.css" rel="stylesheet" type="text/css">

<script language="javascript">
<!--
function f_Move()
{
	//var year = document.f1.calY.value;
	//var month = document.f1.calM.value;
	//location.href='./cal.jsp?year='+year+'&month='+month+'&date='+<%//=date%>+'&f=<%//=strGubun%>';
	
	document.f1.year.value = document.f1.calY.value;
	document.f1.month.value = document.f1.calM.value;
	document.f1.date.value = "<%=date%>";
	document.f1.f.value = "<%=strGubun%>";
	
	document.f1.action="cal.jsp";
	document.f1.submit();

}

function dateput(putdate) { 
	window.opener.document.forms[0].<%=strGubun%>.value = putdate;	
	window.opener.document.forms[0].<%=strGubun%>.focus();	
	window.close(); 
} 

//-->
</script>
</head>

<body>

<table border="0" cellpadding="0" cellspacing="0" width="216">

<form name="f1">
<input type="hidden" name="year" value="" />
<input type="hidden" name="month" value="" />
<input type="hidden" name="date" value="" />
<input type="hidden" name="f" value="" />

<tr>
  <td background="<%=jspBasePath%>images/common/sech_cal_img01.gif" width="216" height="52" valign="top" style="padding:14 0 0 99">
  
  <select name="calY" class="calSelect" onChange="f_Move()">
  <%
  int iYear = 1985;	//year-5;
  for(int i=iYear; i<nowyear+5; i++){%>
  <option value="<%=i%>"><%=i%></option>
  <%}%>
  </select>

  <select name="calM" class="calSelect" onChange="f_Move()">
  <%
  for(int j=1; j<13; j++){%>
  <option value="<%=j%>"><%=j%></option>
  <%}%>
  </select>
  <script>document.f1.calY.value="<%=year%>";</script>
  <script>document.f1.calM.value="<%=month%>";</script>
  </td>
</tr>
</form>
<tr>
  <td background="<%=jspBasePath%>/images/common/sech_cal_img02.gif" align="center">
  
    <table border="0" cellpadding="0" cellspacing="1" bgcolor="#efefef">
    <tr>
      <td align="center" bgcolor="#F1D6D6" class="calDate">일</td>
      <td align="center" bgcolor="#EDE8DA" class="calDate">월</td>
      <td align="center" bgcolor="#EDE8DA" class="calDate">화</td>
      <td align="center" bgcolor="#EDE8DA" class="calDate">수</td>
      <td align="center" bgcolor="#EDE8DA" class="calDate">목</td>
      <td align="center" bgcolor="#EDE8DA" class="calDate">금</td>
      <td align="center" bgcolor="#D6E6F1" class="calDate">토</td>
    </tr>
	<tr align="center"> 
	
				
<%	
/********** 요일만큼 공백을 위해서          **********/
	int tr=0;
	int trc=1;
	String pmonth = "";
	String pdate = "";
	String tcolor = "";
	String fcolor = "";
	for(int i=1;i<blank;i++){
			out.println("<td  bgcolor=\"#FFFFF3\" class=\"calDate\">&nbsp;</td>");
			tr++;
	}
/********** 날짜를 출력 한다.          **********/
	for (int j =1; j< days+1;j++){
		tr++;
		if(tr == 7){ tcolor = "#D6E6F1"; fcolor="#000099";} else if(tr == 1){ tcolor = "#F1D6D6"; fcolor="#CC0000";} else { tcolor = "#FFFFF3"; fcolor="#000000";}

		if(month < 10){ pmonth = "0"+Integer.toString(month); } else { pmonth = Integer.toString(month); }

		if(j < 10){ pdate = "0"+Integer.toString(j); } else { pdate = Integer.toString(j); }

			if ((nowyear == year) && (nowmonth == month) && (nowdate == j)){
				out.println("<td class=\"calDate\" bgcolor=\""+"#CCCCFF"+"\" onmouseover=this.style.backgroundColor='#FBFFB8' onmouseout=this.style.backgroundColor=''><a HREF=\"javascript:dateput(\'"+year+pmonth+pdate+"\')\"><font color=\""+fcolor+"\">"+j+"</font></a></td>");
			}else if( date == j){
				out.println("<td  class=\"calDate\" bgcolor=\""+tcolor+"\" onmouseover=this.style.backgroundColor='#FBFFB8' onmouseout=this.style.backgroundColor=''><a HREF=\"javascript:dateput(\'"+year+pmonth+pdate+"\')\"><font color=\""+fcolor+"\">"+j+"</font></a></td>");
			}else{
				out.println("<td  class=\"calDate\" bgcolor=\""+tcolor+"\" onmouseover=this.style.backgroundColor='#FBFFB8' onmouseout=this.style.backgroundColor=''><a HREF=\"javascript:dateput(\'"+year+pmonth+pdate+"\')\"><font color=\""+fcolor+"\">"+j+"</font></a></td>");
			}
			if( tr == 7){
				out.println("</tr>");
				if(j != days){
					out.println("<tr align=\"center\" height=\"24\">");
					trc++;
				}
				tr=0;				
			}
			
	}
/********** 날짜를 출력하고 나머지는 빈공백          **********/
	while(tr > 0 && tr <7){
		out.println("<td bgcolor=\"#FFFFF3\" class=\"calDate\">&nbsp;</td>");
		tr++;
	}
	if(trc<6){
%>
				<tr align="center" height="24"> 
					<td bgcolor="#FFFFF3">&nbsp;</td>
					<td bgcolor="#FFFFF3">&nbsp;</td>
					<td bgcolor="#FFFFF3">&nbsp;</td>
					<td bgcolor="#FFFFF3">&nbsp;</td>
					<td bgcolor="#FFFFF3">&nbsp;</td>
					<td bgcolor="#FFFFF3">&nbsp;</td>
					<td bgcolor="#FFFFF3">&nbsp;</td>
				</tr>
<%
	}
%>
    
    </table>
  
  </td>
</tr>
<tr>
  <td><img src="<%=jspBasePath%>images/common/sech_cal_img03.gif" width="216" height="21" border="0" alt=""></td>
</tr>
</table>


</body>
</html>
