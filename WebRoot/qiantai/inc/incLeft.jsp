<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 

<%
   String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <meta http-equiv="pragma" content="no-cache">
	  <meta http-equiv="cache-control" content="no-cache">
	  <meta http-equiv="expires" content="0">    
	  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	  <meta http-equiv="description" content="This is my page">
      
      
      <script type='text/javascript' src='<%=path %>/dwr/interface/loginService.js'></script>
      <script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
      <script type='text/javascript' src='<%=path %>/dwr/util.js'></script>
     
      <script type="text/javascript">
            function check()
			{                                                                                         
			     if(document.ThisForm.loginname.value=="")
				 {
				 	alert("请输入账号");
					return false;
				 }
				 if(document.ThisForm.loginpw.value=="")
				 {
				 	alert("请输入密码");
					return false;
				 }
				 document.getElementById("indicator").style.display="block";
				 loginService.login(document.ThisForm.loginname.value,document.ThisForm.loginpw.value,1,callback);
			}
		
			function callback(data)
			{
			    document.getElementById("indicator").style.display="none";
			    if(data=="no")
			    {
			        alert("账号或密码错误");
			    }
			    if(data=="yes")
			    {   
			        alert("登陆成功");
			        var url="<%=path %>/qiantai/default.jsp";
			        window.location.href=url;
			    }
			}
	        
	        
	        
	        function userLogout()
	        {
	            document.getElementById("indicator1").style.display="block";
	            loginService.userLogout(callback1);
	        }
	        function callback1(data)
			{
			    document.getElementById("indicator1").style.display="none";
			    if(data=="no")
			    {
			        alert("系统错误，请联系管理员");
			    }
			    if(data=="yes")
			    {   
			        alert("安全退出系统");
			        var url="<%=path %>/qiantai/default.jsp";
			        window.location.href=url;
			    }
			    
			}
			
			
			function c()
	        {
	           if(document.form1.goodsName.value=="")
	           {
	               alert("请输入关键字");
	               return false;
	           }
	           document.form1.submit();
	        }
	        
	        
      </script>
  </head>
  
  <body>
        <TABLE border=0 cellSpacing=0 cellPadding=0>
		        <!--  -->
		        <TR>
		          <TD height="27" style="background-image: url('<%=path %>/img/gonggao.gif'); background-repeat : repeat-xy;">
		             &nbsp;&nbsp;&nbsp;&nbsp;<font color="white" style="font-weight: 700">>>系统公告</font>
		          </TD>
		        </TR>
		        <TR>
		          <TD class=b>
		            <TABLE border=0 cellSpacing=0 cellPadding=0 width=178 align=center height=100%>
		              <TR>
		                <TD width=178 align=center>
		                    <MARQUEE onmouseover=this.stop() onmouseout=this.start() direction=up height=90 width=160 scrollAmount=3 scrollDelay=166 border="0">欢迎大家访问本网站。</MARQUEE>
		                </TD>
		              </TR>
		            </TABLE>
		         </TD>
		        </TR>
		        <tr><td height="20"></td></tr>
		        <!-- -->
		        
		        
		        <!--  
		        <TR>
		          <TD height="27" style="background-image: url('<%=path %>/img/gonggao.gif'); background-repeat : repeat-xy;">
		             &nbsp;&nbsp;&nbsp;&nbsp;<font color="white" style="font-weight: 700">>>查询</font>
		          </TD>
		        </TR>
		        <TR>
		          <TD class=b>
		            <TABLE border=0 cellSpacing=0 cellPadding=0 width=178 align=center height=100%>
		              <TR>
		                <TD width=178 align=center>
		                     <form action="<%=path %>/chongwuRes.action" name="form1" method="post">
						        <table>
						            <tr>
						                <td>
						                    <input type="text" name="mingcheng" size="14"/>
						                </td>
						                <td>
						                    <input type="button" value="查询" onclick="c()" style="border:#ccc 1px solid; background-color:#FFFFFF; font-size:12px; padding-top:3px;"/>
						                </td>
						            </tr>
						        </table>
						     </form>
		                </TD>
		              </TR>
		            </TABLE>
		         </TD>
		        </TR>
		        <tr><td height="5"></td></tr>
		         -->
		        
		        
                <!-- 
		        <TR>
		          <TD class=b vAlign=top>
		            <TABLE border=0 cellSpacing=0 cellPadding=0 width=178>
		              <TR>
				          <TD height="27" style="background-image: url('<%=path %>/img/gonggao.gif'); background-repeat : repeat-xy;">
				             &nbsp;&nbsp;&nbsp;&nbsp;<font color="white" style="font-weight: 700">>>宠物类别</font>
				          </TD>
				      </TR>
		            </TABLE>
		            <TABLE border=0 cellSpacing=3 cellPadding=3 width=178>
		              <TR>
		                <TD height=6 vAlign=middle width="100%">
		                    
		                </TD>
		              </TR>
		              <c:forEach items="${sessionScope.cateLogList}" var="catelog">
		              <TR>
		                <TD height=22 vAlign=middle width="100%">
		                    <FONT color=#ff0000><IMG src="<%=path %>/img/dot.gif" width=9 height=9>
		                       &nbsp;&nbsp;&nbsp;  
		                       <a href="<%=path %>/chongwuCatelog.action?catelogId=${catelog.catelogId}"><FONT color=#ff0000>${catelog.catelogName}</FONT></A>
		                    </FONT>
		                </TD>
		              </TR>
		              </c:forEach>
		            </TABLE>
		          </TD>
		        </TR>
		        <tr><td height="10"></td></tr>
		        -->		        
		        
		        
		        <!-- -->
		        <TR>
		          <TD class=b vAlign=top>
		            <TABLE border=0 cellSpacing=0 cellPadding=0 width=178>
		              <TR>
				          <TD height="27" style="background-image: url('<%=path %>/img/gonggao.gif'); background-repeat : repeat-xy;">
				             &nbsp;&nbsp;&nbsp;&nbsp;<font color="white" style="font-weight: 700">>>社员登陆</font>
				          </TD>
				      </TR>
		            </TABLE>
		            <TABLE border=0 cellSpacing=3 cellPadding=3 width=178 height=22>
		              <TR>
		                <TD height=22 vAlign=middle width="100%">
		                    <c:if test="${sessionScope.userType !=1}">
		                    <form action="<%=path %>/user?type=userLogin" name="ThisForm" method="post">
							      <table cellspacing="0" cellpadding="0" width="98%" align="center" border="0" height="60">
							          <tr>
							            <td align="center" colspan="2" height="10"></td>
							          </tr>
							          <tr>
							            <td align="right" width="31%" height="30" style="font-size: 11px;">学号：</td>
							            <td align="left" width="69%"><input name="loginname" type="text" style="width: 100px;"/></td>
							          </tr>
							          <tr>
							            <td align="right" height="30" style="font-size: 11px;">密码：</td>
							            <td align="left"><input type="password" style="width: 100px;" name="loginpw"/></td>
							          </tr>
							          <tr>
							            <td align="center" colspan="2" height="10"></td>
							          </tr>
							          <tr>
							            <td align="center" colspan="2" height="30">
							               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							               <input type="button" value="登  录" onclick="check()" style="border:#ccc 1px solid; background-color:#FFFFFF; font-size:12px; padding-top:3px;" />
										   &nbsp;
										   <input type="reset" value="重   置" style="border:#ccc 1px solid; background-color:#FFFFFF; font-size:12px; padding-top:3px;" />
							               &nbsp;
							               <img id="indicator" src="<%=path %>/img/loading.gif" style="display:none"/>
							            </td>
							          </tr>
							      </table>
						    </form>
						    </c:if>
						    <c:if test="${sessionScope.userType==1}">
						        <br/>
						        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎您：${sessionScope.sheyuan.xuehao }(${sessionScope.sheyuan.xingming }) &nbsp;&nbsp;&nbsp;&nbsp;
							    <a href="#" onclick="userLogout()">安全退出</a> &nbsp;&nbsp;&nbsp;&nbsp;
							    <img id="indicator1" src="<%=path %>/img/loading.gif" style="display:none"/>
							    <br/><br/><br/>
							</c:if>
		                </TD>
		              </TR>
		            </TABLE>
		          </TD>
		        </TR>
		        
		        
		        <!--  -->
		        <TR>
		          <TD height="27" style="background-image: url('<%=path %>/img/gonggao.gif'); background-repeat : repeat-xy;">
		             &nbsp;&nbsp;&nbsp;&nbsp;<font color="white" style="font-weight: 700">>>网站日历</font>
		          </TD>
		        </TR>
		        <TR>
		          <TD class=b>
		            <TABLE border=0 cellSpacing=0 cellPadding=0 width=178 align=center height=100%>
		              <TR>
		                <TD width=178 align=center>
		                     <jsp:include flush="true" page="/qiantai/rili/rili.jsp"></jsp:include>
		                </TD>
		              </TR>
		            </TABLE>
		         </TD>
		        </TR>
		        <tr><td height="5"></td></tr>
		        <!-- -->
		</TABLE> 
  </body>
</html>
