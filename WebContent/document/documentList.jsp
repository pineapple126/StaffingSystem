<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>人事管理系统 ——文档管理</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
	<meta http-equiv="description" content="This is my page" />
	<link href="../css/css.css" type="text/css" rel="stylesheet" />
	<link href="../css/pager.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript" src="../js/jquery-1.11.0.js"></script>
    <script type="text/javascript" src="../js/jquery-migrate-1.2.1.js"></script>
	<link href="../js/ligerUI/skins/Aqua/css/ligerui-dialog.css" rel="stylesheet" type="text/css" />  
	<script src="../js/ligerUI/js/core/base.js" type="text/javascript"></script>
	<script src="../js/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
	<script src="../js/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script>
	<script src="../js/ligerUI/js/plugins/ligerResizable.js" type="text/javascript"></script>
	<script type="text/javascript">
	    $(function(){
	    	
	    	var boxs = $("input[type='checkbox'][id^='box_']");
	    	/** 给全选按钮绑定点击事件  */
	    	$("#checkAll").click(function(){
	    		// this是checkAll  this.checked是true
	    		// 所有数据行的选中状态与全选的状态一致
	    		boxs.attr("checked",this.checked);
	    	})
	    	
	    	/** 给每个数据行绑定点击事件：判断如果数据行都选中全选也应该选中，反之  */
	    	boxs.click(function(event){
	    		/** 去掉复选按钮的事件传播：点击复选会触发行点击：因为复选在行中 */
	    		event.stopPropagation();
	    		
	    		/** 判断当前选中的数据行有多少个  */
	    		var checkedBoxs = boxs.filter(":checked");
	    		/** 判断选中的总行数是否等于总行数：以便控制全选按钮的状态   */
	    		$("#checkAll").attr("checked",checkedBoxs.length == boxs.length);
	    	})
	    	
	    	/** 给数据行绑定鼠标覆盖以及鼠标移开事件  */
	    	$("tr[id^='data_']").hover(function(){
	    		$(this).css("backgroundColor","#eeccff");
	    	},function(){
	    		$(this).css("backgroundColor","#ffffff");
	    	}).click(function(){
	    		/** 控制该行是否需要被选中 */
	    		/** 获取此行的复选框id */
	    		var checkboxId = this.id.replace("data_","box_");
	    		
	    		/** 触发本行的复选点击 */
	    		$("#"+checkboxId).trigger("click");
	    	})
	    	
	    	/** 删除员工绑定点击事件 */
	 	   $("#delete").click(function(){
	 		   /** 获取到用户选中的复选框  */
	 		   var checkedBoxs = boxs.filter(":checked");
	 		   if(checkedBoxs.length < 1){
	 			   $.ligerDialog.error("请选择一个需要删除的文档！");
	 		   }else{
	 			   /** 得到用户选中的所有的需要删除的ids */
	 			   var ids = checkedBoxs.map(function(){
	 				   return this.value;
	 			   })
	 			   
	 			   $.ligerDialog.confirm("确认要删除吗?","删除文档",function(r){
	 				   if(r){
	 					   // alert("删除："+ids.get());
	 					   // 发送请求
	 					  // window.location = "${ctx }/document/removeDocument?ids=" + ids.get();
	 				   }
	 			   });
	 		   }
	 	   })
	    	
	    	/** 下载文档功能 */
	    	$("a[id^='down_']").click(function(){
	    		/** 得到需要下载的文档的id */
	    		var id = this.id.replace("down_","");
	    		/** 下载该文档 */
	    		//window.location = ""+id;
	    	})
	    	
	    	
	    	
	    })
	    
	    function down(id){
	    	$("a[id='down_"+id+"']").trigger("click");
	    }
	    
	</script>
</head>
<body>
	<!-- 导航 -->
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
	  	<tr><td height="10"></td></tr>
	  	<tr>
	    	<td width="15" height="32"><img src="../images/main_locleft.gif" width="15" height="32"></td>
			<td class="main_locbg font2"><img src="../images/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：文档管理 &gt; 文档查询</td>
			<td width="15" height="32"><img src="../images/main_locright.gif" width="15" height="32"></td>
	  	</tr>
	</table>
	
	<table width="100%" height="90%" border="0" cellpadding="5" cellspacing="0" class="main_tabbor">
	  	<!-- 查询区  -->
	  	<tr valign="top">
	    	<td height="30">
	    		<form id="searchForm" action="DocumentListServlet" method="post">
	    			<input id="currentPage" style="display: none;" type="text" name="currentPage" />
	    			<table width="100%" border="0" cellpadding="0" cellspacing="10" class="main_tab">
			    		<tr>
				  			<td class="fftd">
				  	
					    		<table width="100%" border="0" cellpadding="0" cellspacing="0">
						  			<tr>
						    			<td class="font3">
						    				标题：<input type="text" name="title" value="${param.title}" />
						    				<input type="submit"  value="搜索"/>
						    				<input type="button" id="delete" value="删除">
						    			</td>
						  			</tr>
								</table>
					
				  			</td>
						</tr>
			  		</table>
	    		</form>
		  		
			</td>
	  	</tr>
	  
	  	<!-- 数据展示区 -->
	  	<tr valign="top">
	    	<td height="20">
			  	<table width="100%" border="1" cellpadding="5" cellspacing="0" style="border:#c2c6cc 1px solid; border-collapse:collapse;">
			    	<tbody>
			    		<tr class="main_trbg_tit" align="center">
			      			<td><input type="checkbox" id="checkAll"></td>
				  			<td>标题</td>
				  			<td>创建时间</td>
				  			<td>创建人</td>
				  			<td>描述</td>
				  	
				  			<td>操作</td>
				  
				  			<td>下载</td>
						</tr>
				
						<c:forEach items="${pageResult.list}" var="document">
							<tr ondblclick="down(7);" class="main_trbg" align="center" id="data_0" style="background-color: rgb(255, 255, 255);">
								<td><input type="checkbox" id="box_0" value="${document.id}"></td>
							 	<td>${document.title}</td>
							 	<td>${document.createdate}</td>
							  	<td>${document.loginname}</td>
							  	<td>${document.remark}</td>
							  	
							 	<td align="center" width="40px;">
							 		<a href="EditDocumentServlet?id=${document.id}">
										<img title="修改" src="../images/update.gif">
									</a>
							  	</td>
							  
							  	<td align="center" width="40px;">
							  		<a href="../DownloadServlet?filename=${document.filepath}" id="down_7">
										<img width="20" height="20" title="下载" src="../images/downLoad.png">
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
	  	   		<table width="100%" align="center" style="font-size:13px;" class="flickr">
	  	   			<tbody>
	  	   				<tr>
	  	   					<td style="COLOR: #0061de; MARGIN-RIGHT: 3px; PADDING-TOP: 2px; TEXT-DECORATION: none">
	  	   						<c:if test="${pageResult.currentPage > 1}">
	  	 							<span onclick="gotoPage(${pageResult.currentPage-1})">上一页</span>
	  	 						</c:if>
	  	 						
	  	 						<span class="current">${pageResult.currentPage}</span>
	  	 						
	  	 						<c:if test="${pageResult.currentPage < pageResult.totalPage }">
	  	 							<span onclick="gotoPage(${pageResult.currentPage+1})">下一页</span>
	  	 						</c:if>

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