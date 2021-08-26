<%@ page language="java"
   contentType="application/vnd.ms-excel; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page import="com.survey.domain.*"%>
<%@page import="java.util.ArrayList"%>
<%
   response.setHeader("Content-Type", "application/vnd.ms-xls");
   response.setHeader("Content-Disposition", "inline; filename=Occupation_108.xls");

   ArrayList<OccupationVO> list_108 = new ArrayList<OccupationVO>();
   list_108 = (ArrayList<OccupationVO>) request.getAttribute("occup_108_excel");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<style type="text/css">
.contenthead {
   border: 1px solid black;
   background-color: #669966;
   color: white;
   border-style: dotted;
}

.content {
   border: 1px solid black;
   border-style: dotted;
}
</style>
</head>
<body>
   <table>
      <tr>

         <th scope="col" class="contenthead" style="width: 10%">No</th>
         <th scope="col" class="contenthead" style="width: 10%">ID</th>
         <%
            for (int i = 1; i <= 108; i++) {
         %>
         <th scope="col" class="contenthead" style="width: 10%">Q <%=i%></th>
         <%
            }
         %>
      </tr>

      <%
         for (int i = 0; i < list_108.size(); i++) {
      %>
      <tr align="center">
         <td class="content"><%=i + 1%></td>
         <td class="content"><%=list_108.get(i).getId()%></td>
         <%
            for (int j = 0; j < list_108.get(i).getOccValueList().size(); j++) {
         %>

         <td class="content"><%=list_108.get(i).getOccValueList().get(j).getOccValue()%></td>
         <%
            }
         %>
      </tr>
      <%
         }
      %>

   </table>
</body>
</html>