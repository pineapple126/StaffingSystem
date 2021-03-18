<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>人事管理系统 ——用户管理</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
	<meta http-equiv="description" content="This is my page" />
	<link href="../css/css.css" type="text/css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="../js/ligerUI/skins/Aqua/css/ligerui-dialog.css"/>
	<link href="../js/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="../js/jquery-1.11.0.js"></script>
    <script type="text/javascript" src="../js/jquery-migrate-1.2.1.js"></script>
	<script src="../js/ligerUI/js/core/base.js" type="text/javascript"></script>
	<script src="../js/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script> 
	<script src="../js/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
	<script src="../js/ligerUI/js/plugins/ligerResizable.js" type="text/javascript"></script>
	<link href="../css/pager.css" type="text/css" rel="stylesheet" />
	
	<script type="text/javascript">
		$(function(){
	 	   	/** 获取上一次选中的部门数据 */
	 	    var boxs  = $("input[type='checkbox'][id^='box_']");
	 	   
	 	  	/** 给数据行绑定鼠标覆盖以及鼠标移开事件  */
	    	$("tr[id^='data_']").hover(function(){
	    		$(this).css("backgroundColor","#eeccff");
	    	},function(){
	    		$(this).css("backgroundColor","#ffffff");
	    	})
	    
	    	
	 	    /** 删除员工绑定点击事件 */
	 	    $("#delete").click(function(){
	 		   	/** 获取到用户选中的复选框  */
	 		   	var checkedBoxs = boxs.filter(":checked");
	 		   	if(checkedBoxs.length < 1){
	 			   	$.ligerDialog.error("请选择一个需要删除的用户！");
	 		   	}else{
	 			   	/** 得到用户选中的所有的需要删除的ids */
	 			   	var ids = checkedBoxs.map(function(){
	 				   	return this.value;
	 			   	})
	 			   
	 			   	$.ligerDialog.confirm("确认要删除吗?","删除用户",function(r){
	 				   	if(r){
	 					   	// alert("删除："+ids.get());
	 					   	// 发送请求
	 					  	// window.location = "${ctx }/user/removeUser?ids=" + ids.get();
	 				   	}
	 			   	});
	 		   	}
	 	   	})
	    })

	</script>
</head>
<body>
	<!-- 导航 -->
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
	  	<tr><td height="10"></td></tr>
	  	<tr>
		    <td width="15" height="32"><img src="../images/main_locleft.gif" width="15" height="32"></td>
			<td class="main_locbg font2"><img src="../images/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：用户管理 &gt; 用户查询</td>
			<td width="15" height="32"><img src="../images/main_locright.gif" width="15" height="32"></td>
	  	</tr>
	</table>
	
	<table width="100%" height="90%" border="0" cellpadding="5" cellspacing="0" class="main_tabbor">
	  	<!-- 查询区  -->
	  	<tr valign="top">
	    	<td height="30">
		  		<table width="100%" border="0" cellpadding="0" cellspacing="10" class="main_tab">
		    		<tr>
			  			<td class="fftd">
			  				<form id="searchForm" action="UserListServlet" method="post">
			  					<input id="currentPage" style="display: none;" type="text" name="currentPage" />
			  					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						  			<tr>
						    			<td class="font3">
									    	用户名：<input type="text" name="username" value="${param.username}">
									    	用户状态：<select name="status">
								    			<option value="">全部</option>
												<option value="1" <c:if test="${param.status == '1'}">selected</c:if>>管理员</option>
												<option value="2" <c:if test="${param.status == '2'}">selected</c:if>>普通用户</option>
											</select>
						    	 			<input type="submit" value="搜索"/>
						    				<input id="delete" type="button" value="删除"/>
						    			</td>
						  			</tr>
								</table>
			  				</form>
			
			  			</td>
					</tr>
		  		</table>
			</td>
	  	</tr>
	  
	  	<!-- 数据展示区 -->
	  	<tr valign="top">
	    	<td height="20">
		  		<table width="100%" border="1" cellpadding="5" cellspacing="0" style="border:#c2c6cc 1px solid; border-collapse:collapse;">
		    		<tbody>
		    			<tr class="main_trbg_tit" align="center">
						  	<td><input type="checkbox" name="checkAll" id="checkAll"></td>
						  	<td>登录名</td>
						  	<td>用户名</td>
						  	<td>状态</td>
						  	<td>创建时间</td>				  	
						  	<td align="center">操作</td>
						</tr>
						
						<c:forEach items="${pageResult.list}" var="user">
							<tr id="data_0" align="center" class="main_trbg" style="background-color: rgb(255, 255, 255);">
								<td><input type="checkbox" id="box_0" value="1"></td>
					 			<td>${user.loginname}</td>
						  		<td>${user.username}</td>
						  		<td>
						  			<c:if test="${user.status == '1'}">
						  				管理员
						  			</c:if>
						  			<c:if test="${user.status == '2'}">
						  				普通用户
						  			</c:if>
						  		</td>
						  		<td>${user.createdate}</td>
									
						 		<td align="center" width="40px;">
						 			<a href="showUpdateUser.html">
										<img title="修改" src="../images/update.gif">
									</a>
						  		</td>
							</tr>
						</c:forEach>
		  			</tbody>
	  			</table>
			</td>
	  	</tr>
	  	<!-- 分页标签 -->
	  	<tr valign="top">
	  		<td align="center" class="font3">
	  	 		<table width="100%" align="center" style="font-size:13px;" class="digg">
	  	 			<tbody>
	  	 				<tr>
	  	 					<td style="COLOR: #0061de; MARGIN-RIGHT: 3px; PADDING-TOP: 2px; TEXT-DECORATION: none">
	  	 						<span onclick="gotoPage(${page.currentPage-1})">上一页</span>
	  	 						<span class="current">${pageResult.currentPage}</span>
	  	 						<span onclick="gotoPage(${page.currentPage+1})">下一页</span>
								<!-- &nbsp;跳转到&nbsp;&nbsp;<input name="currentPage" style="text-align: center;BORDER-RIGHT: #aaaadd 1px solid; PADDING-RIGHT: 5px; BORDER-TOP: #aaaadd 1px solid; PADDING-LEFT: 5px; PADDING-BOTTOM: 2px; MARGIN: 2px; BORDER-LEFT: #aaaadd 1px solid; COLOR: #000099; PADDING-TOP: 2px; BORDER-BOTTOM: #aaaadd 1px solid; TEXT-DECORATION: none" type="text" size="2" id="pager_jump_page_size"> -->
								<!-- &nbsp;<input type="button" style="text-align: center;BORDER-RIGHT: #dedfde 1px solid; PADDING-RIGHT: 6px; BACKGROUND-POSITION: 50% bottom; BORDER-TOP: #dedfde 1px solid; PADDING-LEFT: 6px; PADDING-BOTTOM: 2px; BORDER-LEFT: #dedfde 1px solid; COLOR: #0061de; MARGIN-RIGHT: 3px; PADDING-TOP: 2px; BORDER-BOTTOM: #dedfde 1px solid; TEXT-DECORATION: none" value="确定" id="pager_jump_btn"> -->
							<!-- </td> -->
	  	 				<!-- </tr> -->
	  	 				<!-- <tr align="center"> -->
	  	 					<!-- <td style="font-size:13px;"></td> -->
	  	 				<!-- </tr> -->
	  	 				<!-- <tr> -->
	  	 					<!-- <td style="COLOR: #0061de; MARGIN-RIGHT: 3px; PADDING-TOP: 2px; TEXT-DECORATION: none"> -->
	  	 						总共<font color="red"> ${pageResult.totalCount} </font>条记录，共<font color="red"> ${pageResult.totalPage} </font>页
	  	 					</td>
  	 					</tr>
	 				</tbody>
	 			</table>
	  		</td> 
  		</tr>
	</table>
	<div style="height:10px;"></div>
	
	<script type="text/javascript">
		function gotoPage(currentPage) {
			// form 表单需要传递一个展现的页码参数
			$("#currentPage").val(currentPage);
			
			// 要让搜索区域的 form 表单提交
			$("#searchForm").submit();
		}
	</script>
</body>
</html>