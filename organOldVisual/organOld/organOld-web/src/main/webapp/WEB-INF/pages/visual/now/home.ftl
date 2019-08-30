<#--<!DOCTYPE html>-->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<#include "../head_part.ftl" />
<#--<script src="/static/js/chart_part.js"></script>-->


</head>

<body style="margin-top: 0.7%">
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-3" style="position: relative;right: 80px">
            <div class="row">
                <div class="col-lg-12" >
                    <#include "news.ftl" />
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12" id="label">
                    <#include "label.ftl" />
                </div>
            </div>
        </div>
        <div class="col-lg-3" style="position: relative;right:30px;margin-top:30px" align="center">
            <div class="row">
                <div class="col-lg-12" id="map" style="position: relative;right:19.6px">
                    <#include "map.ftl" />
                    <#--<#include "heatmap.js" />-->
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12" id="table" style="position: relative;top:-54px;left:20px">
                    <#include "table.ftl" />
                </div>
            </div>
        </div>
        <div class="col-lg-6" style="position: relative;left:10px">
            <div class="row">
                <div class="col-lg-6"  id="total" style="margin-top: 1%;margin-bottom: 1%;">
                    <#include "total.ftl" />
                </div>
                <div class="col-lg-6" id="oldman" style="margin-top: 1%;margin-bottom: 1%;position: relative;left: 1%">
                    <#include "oldman.ftl" />
                    <#include "base.ftl" />
                    <#include "family.ftl" />
                    <#include "economic.ftl" />
                    <#include "health.ftl" />
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6" id="organ" >
                    <#include "organ.ftl" />
                    <#include "homeOldman.ftl" />
                    <#include "organOldman.ftl" />
                    <#include "zcdOldman.ftl" />
                    <#include "zzOldman.ftl" />
                    <#include "rzzxOldman.ftl" />
                    <#include "chx.ftl" />
                    <#include "znh.ftl" />
                    <#include "jjys.ftl" />
                    <#include "jjbc.ftl" />
                </div>
                <div class="col-lg-6" id="finish" style="position: relative;left: 1%">
                    <#include "finish.ftl" />
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    function downloadJSAtOnload() {
        var element = document.createElement("script");
        element.src = "heatmap.js";
        document.body.appendChild(element);
    }
    if (window.addEventListener)
        window.addEventListener("load", downloadJSAtOnload, false);
    else if (window.attachEvent)
        window.attachEvent("onload", downloadJSAtOnload);
    else window.onload = downloadJSAtOnload;
</script>
</body>
<script>
    var oldman_base=0,error=0;
    function test(num){
        alert(num+2);
    }
    var x=0;
    function recover_pq(){
       // x+=5000;
        changeFheAll(dataR.NumDongLanAndChunLao,dataR.NumDongLanAndDuJu,dataR.NumDongLanAndShiDu,dataR.NumDongLanAndYiLiao,dataR.NumDongLanAndGuLao,dataR.NumDongLanAndSanZhi,dataR.NumDongLanAndQiTa,
            dataR.NumDongLanAndShiNeng,dataR.NumDongLanAndManBing,dataR.NumDongLanAndZhongLiu,dataR.NumDongLanAndGuZhe,dataR.NumDongLanAndShiZhi,dataR.NumDongLanAndChangHu,
            dataR.NumDongLanAndBangKun,dataR.NumDongLanAndDiBao,dataR.NumDongLanAndYangLao,dataR.NumDongLanAndYiLiao,dataR.NumDongLanAndChenZhen,
            dataR.NumDongLanAnd80Above);
        var posList = [
            'left', 'right', 'top', 'bottom',
            'inside',
            'insideTop', 'insideLeft', 'insideRight', 'insideBottom',
            'insideTopLeft', 'insideTopRight', 'insideBottomLeft', 'insideBottomRight'
        ];

        total_pqBar.configParameters = {
            rotate: {
                min: -90,
                max: 90
            },
            align: {
                options: {
                    left: 'left',
                    center: 'center',
                    right: 'right'
                }
            },
            verticalAlign: {
                options: {
                    top: 'top',
                    middle: 'middle',
                    bottom: 'bottom'
                }
            },
            position: {
                options: echarts.util.reduce(posList, function (map, pos) {
                    map[pos] = pos;
                    return map;
                }, {})
            },
            distance: {
                min: 0,
                max: 100
            }
        };

        total_pqBar.config = {
            rotate: 90,
            align: 'left',
            verticalAlign: 'middle',
            position: 'insideBottom',
            distance: 15,
            onChange: function () {
                var labelOption = {
                    normal: {
                        rotate: total_pqBar.config.rotate,
                        align: total_pqBar.config.align,
                        verticalAlign: total_pqBar.config.verticalAlign,
                        position: total_pqBar.config.position,
                        distance: total_pqBar.config.distance
                    }
                };
                total_pqBar.setOption({
                    series: [{
                        label: labelOption
                    }, {
                        label: labelOption
                    }, {
                        label: labelOption
                    }, {
                        label: labelOption
                    }]
                });
            }
        };


        var labelOption = {
            normal: {
                show: true,
                position: total_pqBar.config.position,
                distance: total_pqBar.config.distance,
                align: total_pqBar.config.align,
                verticalAlign: total_pqBar.config.verticalAlign,
                rotate: total_pqBar.config.rotate,
                formatter: '{c}',
                fontSize: 16,
                rich: {
                    name: {
                        textBorderColor: '#fff'
                    }
                }
            }
        };

        option = {
            title: {
                text:'片区老年人口分布',
                textStyle:{
                    color:'#fff',
                    fontSize:title_fontSize,
                    fontWeight:'normal'
                },
                link: "javascript: recover_pq()",
                target: "self",// 保证不会在新的窗口弹出,
                x:'0%',
                y:'0%',
            },
            color: ['#ffd289'],
            legend: {
                data: ['']
            },
            calculable: true,
            grid:  {
                top:'30%',
                bottom: '0%',
                containLabel: true
            },
            xAxis: [
                {
                    type: 'category',
                    axisTick: {show: false},
                    data: ['东兰','古龙','平南','平阳','平吉','古美'],
                    axisLine:{
                        lineStyle:{
                            color:'white',
                            fontSize: 20,
                            fontWeight:'normal',
                        }
                    },
                }
            ],
            yAxis: [
                {
                    type: 'value',
                    axisLine:{
                        lineStyle:{
                            color:'white',
                            fontSize: 20
                        }
                    },
                }
            ],
            series: [
                {
                    type: 'bar',
                    barGap: 0,
                    label: labelOption,
                    data: [dataR.NumDongLan, dataR.NumGuMei, dataR.NumPingNan+x, dataR.NumPingYang, dataR.NumPingJi,dataR.NumGuMei],
                    itemStyle: {
                        normal: {
                            barBorderRadius: 20,
                            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                                offset: 0,
                                color: '#99d9ea'
                            }, {
                                offset: 1,
                                color: 'rgba(0,188,226, 0.5)'
                            }]),
                            shadowColor: 'rgba(0, 0, 0, 0.4)',
                            shadowBlur: 20
                        }
                    },
                    barWidth:55,
                    center:['50%','65%'],

                }

            ]
        };
        //pqBar.setOption(option);
        total_pqBar.setOption(option);
    }
    function change(source,des) {
        if(des=="child_base"&&error==1)return;
        error=0;
        if(source=="child_oldman"&&des!="child_base"){
            error=1;
        }
        //
        if(source=="child_oldman"&&des=="child_base"){
            oldman_base=1-oldman_base;
            if(oldman_base==0){
                source="child_base";
                des="child_oldman";
            }
        }

        $("#"+source).hide();
        $("#"+des).show();

        if(des=="child_oldman")error=0;
       // alert(error);
    }
    function changeFheAll(numChunLao,numDuJu,numShiDu,numYiLao,numGuLao,numSanZhi,numQiTa,
                          numShiNeng,numManBing,numZhongLiu,numGuZhe,numShiZhi,numChangHu,
                          numBangKun,numDiBao,numYangLao,numYiLiao,numChenZhen,num80Above){
        //80above
        //老人占比

        //!!

        //!!


        //changechildoverall
        title.text="家庭结构";
        title.link="javascript: change('child_family','child_oldman')";
        legend_data=[{name:'纯老',textStyle:{color:legend_color,fontSize:12}},{name:'独居',textStyle:{color:legend_color,fontSize:12}}
            ,{name:'失独',textStyle:{color:legend_color,fontSize:12}},{name:'一老养一老',textStyle:{color:legend_color,fontSize:12}},
            {name:'孤老',textStyle:{color:legend_color,fontSize:12}},{name:'三支人员',textStyle:{color:legend_color,fontSize:12}},{name:'其他',textStyle:{color:legend_color,fontSize:12}}];
        series=[{
            name: '老人家庭结构',
            type: 'pie',
            radius : '45%',
            label : {
                normal : {
                    formatter: '{d}%',
                    textStyle : {
                        fontWeight : 'normal',
                        fontSize : 12
                    }
                }
            },
            center: ['48%', '60%'],
            data:[
                {value:numChunLao, name:'纯老'},
                {value:numDuJu, name:'独居'},
                {value:numShiDu, name:'失独'},
                {value:numYiLao, name:'一老养一老'},
                {value:numGuLao, name:'孤老'},
                {value:numSanZhi, name:'三支人员'},
                {value:numQiTa, name:'其他'}
            ],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            },
            labelLine:{
                normal:{
                    length:20
                }
            }
        }];
        var family_option_family_pie = chartPieClick(title,legend_data,series);
        family_familyPie.setOption(family_option_family_pie);



        title.text="经济条件";
        title.link="javascript: change('child_economic','child_oldman')";
        legend_data=[{name:'帮困',textStyle:{color:legend_color,fontSize:12}},{name:'低保',textStyle:{color:legend_color,fontSize:12}}
            ,{name:'养老保险',textStyle:{color:legend_color,fontSize:12}},{name:'医疗救助金',textStyle:{color:legend_color,fontSize:12}},
            {name:'城镇医保',textStyle:{color:legend_color,fontSize:12}},{name:'其他',textStyle:{color:legend_color,fontSize:12}}];
        series=[{
            name: '老人经济条件',
            type: 'pie',
            radius : '45%',
            label : {
                normal : {
                    formatter: '{d}%\n({c})',
                    textStyle : {
                        fontWeight : 'normal',
                        fontSize : 12
                    }
                }
            },
            center: ['48%', '60%'],
            data:[
                {value:numBangKun, name:'帮困'},
                {value:numDiBao, name:'低保'},
                {value:numYangLao, name:'养老保险'},
                {value:numYiLiao, name:'医疗救助金'},
                {value:numChenZhen, name:'城镇医保'},
                {value:numQiTa, name:'其他'}
            ],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }];
        var economic_option_economic_pie = chartPieClick(title,legend_data,series);
        economic_economicPie.setOption(economic_option_economic_pie);


        title.text="健康状态";
        title.link="javascript: change('child_health','child_oldman')";
        legend_data=[{name:'失能',textStyle:{color:legend_color,fontSize:12}},{name:'慢病',textStyle:{color:legend_color,fontSize:12}}
            ,{name:'肿瘤史',textStyle:{color:legend_color,fontSize:12}},{name:'骨折史',textStyle:{color:legend_color,fontSize:12}},
            {name:'失智',textStyle:{color:legend_color,fontSize:12}},{name:'长护险评级',textStyle:{color:legend_color,fontSize:12}},{name:'其他',textStyle:{color:legend_color,fontSize:12}}];
        series=[{
            name: '健康状态',
            type: 'pie',
            radius : '45%',
            label : {
                normal : {
                    formatter: '{d}%',
                    textStyle : {
                        fontWeight : 'normal',
                        fontSize : 12
                    }
                }
            },

            center: ['48%', '60%'],
            data:[
                {value:numShiNeng, name:'失能'},
                {value:numManBing, name:'慢病'},
                {value:numZhongLiu, name:'肿瘤史'},
                {value:numGuZhe, name:'骨折史'},
                {value:numShiZhi, name:'失智'},
                {value:numChangHu, name:'长护险评级'},
                {value:numQiTa-2, name:'其他'}
            ],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }];
        var health_option_health_pie = chartPieClick(title,legend_data,series);



        health_healthPie.setOption(health_option_health_pie);

        title.text="家庭结构";
        title.link="javascript: change('child_oldman','child_family')";
        //家庭结构
        legend_data=[{name:'纯老',textStyle:{color:legend_color,fontSize:12}},{name:'独居',textStyle:{color:legend_color,fontSize:12}}
            ,{name:'失独',textStyle:{color:legend_color,fontSize:12}},{name:'一老养一老',textStyle:{color:legend_color,fontSize:12}},
            {name:'孤老',textStyle:{color:legend_color,fontSize:12}},{name:'三支人员',textStyle:{color:legend_color,fontSize:12}},
            {name:'其他',textStyle:{color:legend_color,fontSize:12}}];
        series=[{
            name: '老人家庭结构',
            type: 'pie',
            radius : '45%',
            label : {
                normal : {
                    formatter: '{d}%',
                    textStyle : {
                        fontWeight : 'normal',
                        fontSize : 12
                    }
                }
            },
            center: ['48%', '60%'],
            data:[
                {value:numChunLao, name:'纯老'},
                {value:numDuJu, name:'独居'},
                {value:numShiDu, name:'失独'},
                {value:numYiLao, name:'一老养一老'},
                {value:numGuLao, name:'孤老'},
                {value:numSanZhi, name:'三支人员'},
                {value:numQiTa, name:'其他'}
            ],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }];


        var oldman_option_family_pie = chartPieClick(title,legend_data,series);
        oldman_familyPie.setOption(oldman_option_family_pie);

        //健康状态

        title.text="健康状态";
        title.link="javascript: change('child_oldman','child_health')";
        legend_data=[{name:'失能',textStyle:{color:legend_color,fontSize:12}},{name:'慢病',textStyle:{color:legend_color,fontSize:12}}
            ,{name:'肿瘤史',textStyle:{color:legend_color,fontSize:12}},{name:'骨折史',textStyle:{color:legend_color,fontSize:12}},
            {name:'失智',textStyle:{color:legend_color,fontSize:12}},{name:'长护险评级',textStyle:{color:legend_color,fontSize:12}},{name:'其他',textStyle:{color:legend_color,fontSize:12}}];
        series=[{
            name: '健康状态',
            type: 'pie',
            radius : '45%',
            label : {
                normal : {
                    formatter: '{d}%',
                    textStyle : {
                        fontWeight : 'normal',
                        fontSize : 12
                    }
                }
            },

            center: ['48%', '60%'],
            data:[
                {value:numShiNeng, name:'失能'},
                {value:numManBing, name:'慢病'},
                {value:numZhongLiu, name:'肿瘤史'},
                {value:numGuZhe, name:'骨折史'},
                {value:numShiZhi, name:'失智'},
                {value:numChangHu, name:'长护险评级'},
                {value:numQiTa-2, name:'其他'}
            ],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }];
        var oldman_option_health_pie = chartPieClick(title,legend_data,series);
        oldman_healthPie.setOption(oldman_option_health_pie);



        title.text="经济条件";
        title.link="javascript: change('child_oldman','child_economic')";
        legend_data=[{name:'帮困',textStyle:{color:legend_color,fontSize:12}},{name:'低保',textStyle:{color:legend_color,fontSize:12}}
            ,{name:'养老保险',textStyle:{color:legend_color,fontSize:12}},{name:'医疗救助金',textStyle:{color:legend_color,fontSize:12}},
            {name:'城镇医保',textStyle:{color:legend_color,fontSize:12}},{name:'其他',textStyle:{color:legend_color,fontSize:12}}];
        series=[{
            name: '老人经济条件',
            type: 'pie',
            radius : '45%',
            label : {
                normal : {
                    formatter: '{d}%',
                    textStyle : {
                        fontWeight : 'normal',
                        fontSize : 20
                    }
                }
            },
            center: ['48%', '60%'],
            data:[
                {value:numBangKun, name:'帮困'},
                {value:numDiBao, name:'低保'},
                {value:numYangLao, name:'养老保险'},
                {value:numYiLiao, name:'医疗救助金'},
                {value:numChenZhen, name:'城镇医保'},
                {value:numQiTa, name:'其他'}
            ],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }];
        var oldman_option_econmic_pie = chartPieClick(title,legend_data,series);
        oldman_econmicPie.setOption(oldman_option_econmic_pie);




    }
</script>
</html>