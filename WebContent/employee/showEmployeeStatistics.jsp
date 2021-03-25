<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>人事管理系统——添加员工</title>
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
	<script language="javascript" type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
	
	<script src="../js/highcharts/highcharts.js"></script>
	<script src="../js/highcharts/modules/exporting.js"></script>
	<script src="../js/highcharts/modules/export-data.js"></script>
	
</head>
<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
  		<tr>
  			<td height="10"></td>
		</tr>
  		<tr>
    		<td width="15" height="32"><img src="../images/main_locleft.gif" width="15" height="32"></td>
			<td class="main_locbg font2"><img src="../images/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：员工管理  &gt; 员工统计</td>
			<td width="15" height="32"><img src="../images/main_locright.gif" width="15" height="32"></td>
  		</tr>
	</table>
	<table width="100%" height="90%" border="0" cellpadding="5" cellspacing="0" class="main_tabbor">
  		<tbody>
  			<tr valign="top">
    			<td>
		  			<table width="100%" border="0" cellpadding="0" cellspacing="10" class="main_tab">
		    			<tbody>
							<tr>
								<td class="font3 fftd">
	    							<table>
							    		<tbody>
											<div id="container" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>
											<script type="text/javascript">

												var data = ${levelPercentageJson};
												
											
												Highcharts.chart('container', {
												    chart: {
												        plotBackgroundColor: null,
												        plotBorderWidth: null,
												        plotShadow: false,
												        type: 'pie'
												    },
												    title: {
												        text: '员工薪资统计'
												    },
												    tooltip: {
												        pointFormat: '{series.name}: <b>{point.percentage:.2f}%</b>'
												    },
												    plotOptions: {
												        pie: {
												            allowPointSelect: true,
												            cursor: 'pointer',
												            dataLabels: {
												                enabled: true,
												                format: '<b>{point.name}</b>: {point.percentage:.2f} %',
												                style: {
												                    color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
												                }
												            }
												        }
												    },
												    series: [{
														name: '百分比',
												        colorByPoint: true,
												        data: data
												    }]
												});
											</script>
 		
		    							</tbody>
	    							</table>
	    						</td>
    						</tr>
							<tr>
								<td class="main_tdbor"></td>
							</tr>
						</tbody>
					</table>
		 
				</td>
  			</tr>
		</tbody>
	</table>
	<div style="height:10px;"></div>
</body>
</html>