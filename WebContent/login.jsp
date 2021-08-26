<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<html>
<head>
<%
   String CONTEXT_PATH = request.getContextPath();
   String contextName = request.getContextPath();
   String jspBasePath = contextName + "/";
   String imgPath = jspBasePath + "images";
%>
<title>PGI 설문조사</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
   content="width=device-width, initial-scale=1, user-scalable=no" />
   <meta http-equiv="Pragma" content="no-cache" />
<link rel="stylesheet" href="assets/css/main.css" />
<noscript>
<link rel="stylesheet" href="assets/css/noscript.css" />
</noscript>
<style>
.field{margin-bottom:0.3rem;}
</style>
<script language="javascript">
   function f_submit() {

      var form = document.fm;

      if (form.user.value == "") {
         alert("이메일 주소를 기입해 주세요");
         form.user.focus();
         return;
      }
      if (form.pass.value == "") {
         alert("비밀번호를 기입해 주세요");
         form.pass.focus();
         return;
      }
      form.submit();
   }
</script>
<script type="text/javascript">
   function join() {
      location.href = "member?command=member_write_form";
   }
</script>

</head>
<body class="is-preload">
      <!-- Intro -->
      <div id="intro">
      
         <form name="fm" method=post action="member">
         
            <input type="hidden" name="command" value="login"> <span
               class="mb-3" style="font-size: 2.5em;">Login</span>
               
               
            <div class="form-group">


               <input name="user" id="logid" type="text" class="login_form" placeholder="Enter email" size="30">
               
                  <script>
                     document.getElementById("logid").focus();
                  </script>
               
               
               <label for="exampleInputPassword1"></label>
               <input name="pass" type="password" class="login-form"  placeholder="Password">
               
               <label for="exampleInputPassword1"></label>
                                                                                                                                                   

            <div class="row">
            
            <div class="col-6 col-12-small ">
               <div class="field">
                     <input type="button" class="login_submit fit" onclick="javascript:f_submit()" value="로그인">
               </div>
            </div>


            <div class="col-6 col-12-small ">
               <div class="field">                  
                     <input type="button" class="login_submit fit" onclick="javascript:join()" value="회원가입">
               </div>
            </div>
            
            </div>
            <hr>
            
         <div class="row">
         
            <div class="col-12 col-12-small">
            
            <a href="home"><input type="button" class="login_submit primary fit" value="메인 화면으로 이동"></a>
               
            </div>

         </div>
            </div>
            
         </form>
         
         <!-- 메인화면으로 이동하는 버튼 -->
         
<!--          <div id="header">
            <a href="home" class="button primary fit">메인 화면으로 이동</a>
         </div> 
-->
         
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