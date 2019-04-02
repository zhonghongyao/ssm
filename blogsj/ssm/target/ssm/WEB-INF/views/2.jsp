<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>echars map</title>
    <!-- 引入echarts.js的js -->
    <script src="<%=basePath%>static/js/echarts.min.js"></script>
</head>
<body>
<!-- 创建一个DOM -->
<div id="div" style="width:1000px;height:400px;"></div>
<script type="text/javascript">
    //获取DOM
    var myecharts=echarts.init(document.getElementById("div"));
    var option=({
        title:{
            text:'饼形图',//主标题文本，支持\n换行
            subtext: 'from United Nations, Total population, both sexes combined, as of 1 July (thousands)',//副文本
            sublink : 'http://esa.un.org/wpp/Excel-Data/population.htm',//副文本链接
            left:'center',//离容器左侧的距离
            top:'top'//距离容器上测的距离
        },
        backgroundColor: '#2c343c',//背景颜色
        textStyle: {
            color: 'rgba(255, 255, 255, 0.3)'//文字的颜色
        },
        series : [
            {
                name: '访问来源',
                type: 'pie',//每个系列，通过type决定自己的系列型号
                radius: '55%',
                data:[
                    {value:400, name:'搜索引擎'},
                    {value:335, name:'直接访问'},
                    {value:310, name:'邮件营销'},
                    {value:274, name:'联盟广告'},
                    {value:235, name:'视频广告'}
                ],
                roseType: 'angle',

                itemStyle: {//图形样式 normal，emphasis
                    emphasis: {
                        shadowBlur: 200,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                },
                label: {//饼形图上的文本标签
                    normal: {
                        textStyle: {
                            color: 'rgba(255, 255, 255, 0.3)'
                        }
                    }
                },
                labelLine: {//标签的视觉引导线
                    normal: {
                        lineStyle: {
                            color: 'rgba(255, 255, 255, 0.3)'
                        }
                    }
                }

            }
        ]
    });
    myecharts.setOption(option);
</script>

</body>
</html>