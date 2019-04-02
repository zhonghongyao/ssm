<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
     <title>头部</title>

	<link rel="stylesheet" href="<%=basePath %>static/css/common.css">
	<link rel="stylesheet" href="<%=basePath %>static/css/header.css">
	<link rel="stylesheet" href="<%=basePath %>static/layui/css/layui.css">

	<script type="text/javascript" src="<%=basePath%>static/js/jquery-2.1.1.min.js"></script>
</head>
<body>
<div class="header clearfix">
		<div class="h_lo fl">
			<img src="<%=basePath%>static/image/logo2.png" alt="" >
			<span>IDFS</span>
		</div>
		<ul class="h_nav fl clearfix">
			<li class="fl">
				<a href="<%=basePath %>action/home.action">首页</a>
			</li>
			<li class="fl">
				<a href="<%=basePath %>action/retrieval.action">数据检索</a>
			</li>
			<li class="fl">
				<a href="<%=basePath %>action/storage.action">桶管理</a>
			</li>
			<!-- 管理员特有功能 -->
			<c:if test="${user.user_type==1}">
			<li class="fl">
				<a href="<%=basePath %>action/user.action">人员管理</a>
			</li>
			</c:if>
		</ul>
		<ul class="layui-nav h_inout fr" style="background-color:transparent;">
			<li class="layui-nav-item" lay-unselect="" style="line-height:52px;">
				<a href="javascript:;">
					<img src="<%=basePath %>static/image/touxiang.png" class="layui-nav-img">
					<c:if test="${user!= null}">
					${user.user_name }
					</c:if>
					<c:if test="${user== null}">
					未登录
					</c:if>
					</a>
				<dl class="layui-nav-child" style="top:55px;">
					<dd><a href="javascript:;" id="updatePwd">修改密码</a></dd>
					<dd><a href="<%=basePath %>user/loginOut">退出</a></dd>
				</dl>
			</li>
		</ul>
		
		
	</div>
		<script>
			//修改密码、退出
			layui.use('element', function(){
				var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块

				//监听导航点击
				element.on('nav(demo)', function(elem){
					//console.log(elem)
					layer.msg(elem.text());
				});
			});
		</script>
		<script>
					layui.use('layer', function(){
						var layer = layui.layer;
						$('#updatePwd').on('click',function(){
							layer.open({
								id:'',
								title:'修改密码',
								type:0,
								area:'485px',
								btn:['确认','取消'],
								yes:function(){
									var newpwd=$("#newpwd").val();
									var twopwd=$("#twopwd").val();
									if(newpwd==""|| newpwd == "请输入新密码")
									{
									alert("请输入新密码");
									return;
									}
									if(twopwd==""|| twopwd == "请输入确认密码")
									{
									alert("请输入确认密码");
									return;
									}
									if(twopwd!=newpwd)
									{
									alert("请检查：两次密码输入不一致！");
									return;
									}
									$.ajax({
										url:"<%=basePath%>user/update",
										type:"post",
										data:{user_name:'${user.user_name}',pwd:newpwd},
										success:function(data){
											if(data.code==0)
											{
											 alert("修改密码成功");//应调转登录页
											 layer.closeAll();
											 location.href='<%=basePath %>user/loginOut';
											}	
											else
												alert(data.message);
										}
									})
								
								},
								content:'<div class="layui-form-item"><label class="layui-form-label">新密码</label><div class="layui-input-block">'+
     									'<input type="password" required  lay-verify="required" placeholder="请输入新密码" autocomplete="off" class="layui-input" id="newpwd"></div></div>'+
     									'<div class="layui-form-item"><label class="layui-form-label">确认密码</label><div class="layui-input-block">'+
     									'<input type="password" required  lay-verify="required" placeholder="请输入确认密码" autocomplete="off" class="layui-input" id="twopwd"></div></div>'
							});
						});
						
					});
		</script>
</body>
</html>