<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <style>
        #box{ float:left;width:49%;border:1px solid #000}
        #div{ float:left;width:49%;border:1px solid #000}
        #main{ float:left;width:49%;border:1px solid #000}
        #Redis{ float:left;width:49%;border:1px solid #000}
    </style>
    <meta charset="utf-8" />
    <title>ECharts-基本线性图及其配置要求</title>
    <!-- ECharts单文件引入 -->
    <%--<script src="http://echarts.baidu.com/build/dist/echarts-all.js"></script>--%>
    <script src="<%=basePath%>static/js/echarts.min.js"></script>
    <script src="<%=basePath%>static/js/jquery-2.1.1.min.js"></script>
    <script src="<%=basePath%>static/js/echarts.js"></script>
</head>
<body bgcolor="#deb887">
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="box" style="height:300px;width: 600px;padding: 20px"></div>
<div id="div" style="width:600px;height:300px;padding: 20px"></div>
<div id="main" style="width: 600px;height:300px;padding: 20px"></div>
<div id="Redis" style="width: 600px;height:300px;padding: 20px"></div>





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
            }
            ]
        };


        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    }


</script>

<script type="text/javascript">

    $(function () {

        $.ajax({
            url:"<%=basePath%>word/countOther",
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

                        wordCount.push(data.result[i].count);
                    }
                    div(wordName,wordCount);

                }
                else
                {
                    var emptyDataLabel= "<p class='emptyechart'>占用空间统计暂无数据！</p>";
                    $('#div').append(emptyDataLabel);
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



    //


    $(function () {

        $.ajax({
            url:"<%=basePath%>word/wordLine",
            type:"post",
            data:{},
            success:function(data){


                var wordName=[];
                var wordCount=[];
                $('#main').empty();
                if(data.code==0)
                {

                    for(var i=0;i<data.result.length;i++){
                        wordName.push(data.result[i].wordLine);

                        wordCount.push(data.result[i].charCount);
                    }
                    box(wordName,wordCount);

                }
                else
                {
                    var emptyDataLabel= "<p class='emptyechart'>占用空间统计暂无数据！</p>";
                    $('#box').append(emptyDataLabel);
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


    $(function () {

        $.ajax({
            url:"<%=basePath%>word/timeCount",
            type:"post",
            data:{},
            success:function(data){


                var wordName=[];
                var wordCount=[];
                $('#main').empty();
                if(data.code==0)
                {

                    for(var i=0;i<data.result.length;i++){
                        wordName.push(data.result[i].wordLine);

                        wordCount.push(data.result[i].charCount);
                    }
                    Redis(wordName,wordCount);

                }
                else
                {
                    var emptyDataLabel= "<p class='emptyechart'>占用空间统计暂无数据！</p>";
                    $('#Redis').append(emptyDataLabel);
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



<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    function Redis(wordName,wordCount) {
        var myChart = echarts.init(document.getElementById('Redis'));

        // 指定图表的配置项和数据
        var data = [
            [wordName],
            [wordCount]];

        option = {
            backgroundColor: new echarts.graphic.RadialGradient(0.3, 0.3, 0.8, [{
                offset: 0,
                color: '#f7f8fa'
            }, {
                offset: 1,
                color: '#cdd0d5'
            }]),
            title: {
                text: '统计各个功能的消耗时间'
            },
            legend: {
                right: 10,
                data: ['高频词', '行数']
            },
            xAxis: {
                splitLine: {
                    lineStyle: {
                        type: 'dashed'
                    }
                }
            },
            yAxis: {
                splitLine: {
                    lineStyle: {
                        type: 'dashed'
                    }
                },
                scale: true
            },
            series: [{
                name: '高频词',
                data: data[0],
                type: 'scatter',
                symbolSize: function (data) {
                    return Math.sqrt(data[2]) / 5e2;
                },
                label: {
                    emphasis: {
                        show: true,
                        formatter: function (param) {
                            return param.data[3];
                        },
                        position: 'top'
                    }
                },
                itemStyle: {
                    normal: {
                        shadowBlur: 10,
                        shadowColor: 'rgba(120, 36, 50, 0.5)',
                        shadowOffsetY: 5,
                        color: new echarts.graphic.RadialGradient(0.4, 0.3, 1, [{
                            offset: 0,
                            color: 'rgb(251, 118, 123)'
                        }, {
                            offset: 1,
                            color: 'rgb(204, 46, 72)'
                        }])
                    }
                }
            }, {
                name: '行数',
                data: data[1],
                type: 'scatter',
                symbolSize: function (data) {
                    return Math.sqrt(data[2]) / 5e2;
                },
                label: {
                    emphasis: {
                        show: true,
                        formatter: function (param) {
                            return param.data[3];
                        },
                        position: 'top'
                    }
                },


            }]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    }

</script>


<script>
    // 获取到这个DOM节点，然后初始化

    function box(wordLine,charCount) {
        var myChart = echarts.init(document.getElementById("box"));
        var option = {
            // 标题
            title: {
                text: '文本行数和字符数',
                subtext: ''
            },
            tooltip: {
                trigger: 'axis'
            },
            //图例名
            legend: {
                data:['文本行数','字符数']
            },
            grid: {
                left: '3%',   //图表距边框的距离
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            //工具框，可以选择
            toolbox: {
                feature: {
                    saveAsImage: {}
                }
            },
            //x轴信息样式
            xAxis: {
                type: 'category',
                boundaryGap: false,
                data: ['12-01','12-02','12-03','12-04','12-05','12-05','12-06','12-07','12-08','12-09','12-10','12-11','12-12','12-13'],
                //坐标轴颜色
                axisLine:{
                    lineStyle:{
                        color:'red'
                    }
                },
                //x轴文字旋转
                axisLabel:{
                    rotate:30,
                    interval:0
                },
            },

            yAxis : [
                {
                    type : 'value',
                    axisLabel : {
                        formatter: '{value} '
                    }
                }
            ],
            series: [
                //虚线
                {
                    name:'文本行数',
                    type:'line',
                    symbolSize:4,   //拐点圆的大小
                    color:['red'],  //折线条的颜色
                    data:[wordLine],
                    smooth:false,   //关键点，为true是不支持虚线的，实线就用true
                    itemStyle:{
                        normal:{
                            lineStyle:{
                                width:2,
                                type:'dotted'  //'dotted'虚线 'solid'实线
                            }
                        }
                    }
                },
                //实线
                {
                    name:'字符数',
                    type:'line',
                    symbol:'circle',
                    symbolSize:4,
                    itemStyle:{
                        normal:{
                            color:'red',
                            borderColor:'red'  //拐点边框颜色
                        }
                    },
                    data:[charCount]
                }



    ]
    };

        myChart.setOption(option);




    }

    //..............
    function div(wordName,wordCount) {
        var myecharts=echarts.init(document.getElementById("div"));
        var option=({
            title:{
                text:'饼形图',//主标题文本，支持\n换行
                subtext: '统计除冠词，介词，代词之外的高频词',//副文本
                sublink : '',//副文本链接
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



                        {value:wordCount, name:wordName},

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
    }

</script>


</body>
</html>