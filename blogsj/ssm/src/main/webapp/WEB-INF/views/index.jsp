<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="<%=basePath%>static/css/homepage.css">
	
	<script src="<%=basePath%>static/js/jquery-2.1.1.min.js"></script>
	<script src="<%=basePath%>static/js/echarts.js"></script>
	<script src="<%=basePath%>static/layui/layui.js"></script>
	<script src="<%=basePath%>static/js/less.js"></script>
	<style>
	.emptyechart{
		background:url('<%=basePath%>static/image/tishi_icon.png') no-repeat center;
		height:200px;
		line-height:200px;
		padding-left:40px;
		text-align:center;
		font-size:16px;
		color:#333;
		font-family:"微软雅黑";
	}
	</style>
  </head>
  
  <body>
    <!-- 头部开始 -->
	<jsp:include page="header.jsp"></jsp:include>
	<!-- 头部结束 -->
	
	<!-- 统计图 -->
	<div class="content" id="con">
		<ul class="data">
			<li style="background-color: #d7eced; display:none" id="all">总空间<span id="allspace"><i></i></span></li>
			<li style="background-color: #f0ddea;">总文件数<span id="count"><i></i></span></li>
			<li style="background-color: #d9e4f3;">占用空间<span id="space"><i></i></span></li>
			<li style="background-color: #ddf0dd; display:none" id="overplus">剩余空间<span id="over"><i></i></span></li>
		</ul>
		<div class="pie clearfix">
			<div class="pie_l fl" id="pie_l" ></div>
			
			<div class="pie_r fl" id="pie_r" ></div>
			
		</div>
		<div class="line" id="line"></div>
	</div>

	<script>
	$(function(){
		var user='${user.user_name}';
		if(user!="admin")
		{
			$("#overplus").hide();
			$("#all").hide();
		}else
		{
			$("#overplus").show();
			$("#all").show();
		}
		//总况
		$.ajax({
				url:"<%=basePath%>file/square",
				type:"post",
				data:{},
				success:function(data){
					console.log(data)
					if(data.code==0)
					{
					var space =  document.getElementById("space");
					var count =  document.getElementById("count");
					var all =  document.getElementById("allspace");
					var overplus =  document.getElementById("over");
					
					var disk=data.result.disk_spaceed!=null?data.result.disk_spaceed:0;
					var bars=data.result.bars!=null?data.result.bars:0;
					var alldisk=data.result.sum!=null?data.result.sum:0;
					var rSpace=data.result.residusSpaceed!=null?data.result.residusSpaceed:0;
					
					space.innerHTML = disk+"<i>GB</i>";
					count.innerHTML =bars +"<i>条</i>";
					all.innerHTML = alldisk+"<i>GB</i>";
					overplus.innerHTML =rSpace +"<i>GB</i>";
					} 
					else
						alert(data.message);
				}
			})
		//文件条数统计	
		$.ajax({
			url:"<%=basePath%>file/circleCount",
			type:"post",
			data:{},
			success:function(data){
				$('#pie_l').empty();
				console.log(data)
				if(data.code==0)
				{
					var legend=[];
					var series=[];
					for(var i=0;i<data.result.length;i++){
				 		 legend.push(data.result[i].bucket_name);
					     var serie={"name":data.result[i].bucket_name,"value":data.result[i].bars};
					     series.push(serie);
				    }
				    pieCount(legend,series)
				}
				else
				{
					var emptyDataLabel= "<p class='emptyechart'>文件条数统计暂无数据！</p>";
        			$('#pie_l').append(emptyDataLabel);
				}
			}
		})
		//占用空间统计
		$.ajax({
				url:"<%=basePath%>file/circleSpace",
				type:"post",
				data:{},
				success:function(data){
				console.log(data)
					var legend=[];
					var series=[];
					$('#pie_r').empty();
					if(data.code==0)
					{
					
						for(var i=0;i<data.result.length;i++){
					 		 legend.push(data.result[i].bucket_name);
						     var serie={"name":data.result[i].bucket_name,"value":data.result[i].disk_spaceed};
						     series.push(serie);
					    }
					    pieSpace(legend,series)
					}
					else
					{
					    var emptyDataLabel= "<p class='emptyechart'>占用空间统计暂无数据！</p>";
	        			$('#pie_r').append(emptyDataLabel);
					}
						
				}
			})

		//折线统计

		$.ajax({
			url:"<%=basePath%>file/chart",
			type:"post",
			data:{},
			success:function(data){
				$('#line').empty();
				if(data.code==0)
				{
				console.log(data)
					var legend=[];
					var series=[];
					for(var i=0;i<data.result.length;i++){
				 		 legend.push(data.result[i].create_time);
					  
					     series.push(data.result[i].bars);
				    }
				    line(legend,series);
				}
				else
				{
					var emptyDataLabel= "<p class='emptyechart'>文件条数统计暂无数据！</p>";
        			$('#line').append(emptyDataLabel);
				}

			}
		})
	})
	</script>
	
	<script>
		function pieCount(legendData,seriesData)
		{
				var pieL=echarts.init(document.getElementById('pie_l'));
				option = {
				    title : {
				        text: '条数',
				        x:'center',
				        y:'bottom'
				    },
				     tooltip : {
				        trigger: 'item',
				        formatter: "{b} <br/>{c} 条 ({d}%)",
				        extraCssText:'width:50%;height:60px;'
				    },
				    legend: {
				    	show:false,
				        orient: 'vertical',
				        left: 'left',
				        data: legendData
				    },
				    series : [
				        {
				            name: '文件条数',
				            type: 'pie',
				            radius : '65%',
				            center: ['50%', '40%'],
				            data:seriesData,
				            itemStyle: {
				                emphasis: {
				                    shadowBlur: 10,
				                    shadowOffsetX: 0,
				                    shadowColor: 'rgba(0, 0, 0, 0.5)'
				                }
				            }
				        }
				    ]
				};
				pieL.setOption(option);
			}
			
		function pieSpace(legendData,seriesData)
		{
			var pieR=echarts.init(document.getElementById('pie_r'));
			option = {
			    title : {
			        text: '空间',
			        x:'center',
			        y:'bottom'
			    },
		       tooltip : {
			        trigger: 'item',
		            formatter: "{b} <br/>{c} 条 ({d}%)",
			        extraCssText:'width:50%;height:60px;'
			    },
			    legend: {
			    	show:false,
			        orient: 'vertical',
			        left: 'left',
			        data: legendData
			    },
			    series : [
			        {
			            name: '占用空间',
			            type: 'pie',
			            radius : '65%',
			            center: ['50%', '40%'],
			            data:seriesData,
			            itemStyle: {
			                emphasis: {
			                    shadowBlur: 10,
			                    shadowOffsetX: 0,
			                    shadowColor: 'rgba(0, 0, 0, 0.5)'
			                }
			            } 
			        }
			    ]
			};
			pieR.setOption(option);
		}
			
			
		function line(xData,seriesData)
		{
			var lineT=echarts.init(document.getElementById('line'));
			option = {
				/* title: {
		            text: '文件条数统计',
		            left: 'left'
		        }, */
				tooltip : {
			        trigger: 'item',
			        formatter :'{b}<br/>{c} 条',
		    	},
		    	dataZoom: {
			        show: true,
			        start : 10
	    		},
			    xAxis: {
			        type: 'category',
			        data: xData
			    },
			    yAxis: {
			        type: 'value'
			    },
			    series: [{
			        data: seriesData,
			        type: 'line'
			    }]
			};
			lineT.setOption(option);
		}
	</script>
  </body>
</html>
