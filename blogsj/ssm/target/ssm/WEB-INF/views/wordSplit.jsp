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

    <script src="<%=basePath%>static/js/jquery-2.1.1.min.js"></script>
    <script src="<%=basePath%>static/js/echarts.js"></script>


    <title>Insert title here</title>
</head>
<body>

<div id="main" style="width: 600px;height:400px;"></div>
<div id="circle" style="width:400px;height:400px;" align="right"></div>


</body>

<script type="text/javascript">
    alert("哈哈");
    $(function () {

        $.ajax({
            url:"<%=basePath%>word/count",
            type:"post",
            data:{},
            success:function(data){


                var wordName=[];
                var wordCount=[];
                $('#main').empty();
                if(data.code==0)
                {

                    for(var i=0;i<data.result.length;i++){
                        wordName.push(data.result[i].word);
                        var serie={"name":data.result[i].name,"value":data.result[i].count};
                        wordCount.push(serie);
                    }
                    Charts(wordName,wordCount);
                    circle();
                }
                else
                {
                    var emptyDataLabel= "<p class='emptyechart'>占用空间统计暂无数据！</p>";
                    $('#main').append(emptyDataLabel);
                }

            },
            //测试bug
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert("错误");
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            },
        })


    })
    </script>




<script >
    function Charts(wordName,wordCount) {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

        // 指定图表的配置项和数据
        var option = {
            title: {
                text: '单词词频统计项目'
            },
            tooltip: {},
            legend: {
                data:['词频量']
            },
            xAxis: {
                data: wordName
            },
            yAxis: {},
            series: [{
                name: '词频量',
                type: 'bar',
                data: wordCount
            }]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    }

function circle(){
    option = {
        backgroundColor: '#2c343c',

        title: {
            text: 'Customized Pie',
            left: 'center',
            top: 20,
            textStyle: {
                color: '#ccc'
            }
        },

        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },

        visualMap: {
            show: false,
            min: 80,
            max: 600,
            inRange: {
                colorLightness: [0, 1]
            }
        },
        series : [
            {
                name:'访问来源',
                type:'pie',
                radius : '55%',
                center: ['50%', '50%'],
                data:[
                    {value:335, name:'直接访问'},
                    {value:310, name:'邮件营销'},
                    {value:274, name:'联盟广告'},
                    {value:235, name:'视频广告'},
                    {value:400, name:'搜索引擎'}
                ].sort(function (a, b) { return a.value - b.value; }),
                roseType: 'radius',
                label: {
                    normal: {
                        textStyle: {
                            color: 'rgba(255, 255, 255, 0.3)'
                        }
                    }
                },
                labelLine: {
                    normal: {
                        lineStyle: {
                            color: 'rgba(255, 255, 255, 0.3)'
                        },
                        smooth: 0.2,
                        length: 10,
                        length2: 20
                    }
                },
                itemStyle: {
                    normal: {
                        color: '#c23531',
                        shadowBlur: 200,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                },

                animationType: 'scale',
                animationEasing: 'elasticOut',
                animationDelay: function (idx) {
                    return Math.random() * 200;
                }
            }
        ]
    };
}


</script>
</html>