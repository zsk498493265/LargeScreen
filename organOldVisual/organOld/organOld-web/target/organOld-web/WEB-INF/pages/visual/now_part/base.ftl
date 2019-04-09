<!DOCTYPE html>
<html>

<head>
<#include "../head.ftl" />
    <script src="../../../static/js/chart_part.js"></script>
    <script src="/static/js/visual/mapData.js"></script>
</head>

<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-6">
            <div class="row" align="center">
                <div class="col-lg-12">
                    <div class="row">
                        <div class="col-lg-12">
                            <p class="map_title" onclick="location.href='/visual/now/part/oldman'" style="cursor: pointer;font-size:30px;position: relative;top:15px">古美路街道老人数量分布热力图</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <#include "map.ftl"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row" style="position: relative;right: 5px;top:5px">
            <#--<#include "table.ftl"/>-->
            </div>
        </div>
        <div class="col-lg-6" style="position: relative;top: 15px;right:10px">
            <div class="row" >
                <div class="col-lg-6 box">
                    <div class="zz"></div>
                    <div id="zbPie" class="tu"></div>
                </div>
                <div class="col-lg-6 box line">
                    <div class="zz"></div>
                    <div id="numLine" class="tu"></div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 box">
                    <div class="zz"></div>
                    <div id="hjPie" class="tu"></div>
                </div>
                <div class="col-lg-6 box line">
                    <div class="zz"></div>
                    <div id="hjLine" class="tu"></div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 box">
                    <div class="zz"></div>
                    <div id="sexPie" class="tu"></div>
                </div>
                <div class="col-lg-6 box line">
                    <div class="zz"></div>
                    <div id="sexLine" class="tu"></div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 box">
                    <div class="zz"></div>
                    <div id="ageBar" class="tu"></div>
                </div>
                <div class="col-lg-6 box line">
                    <div class="zz"></div>
                    <div id="ageLine" class="tu"></div>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        var tu_w,tu_h;
        if(winWidth>=1700){
            //家里电脑的分辨率
            tu_w=winWidth/4.5;
            tu_h=winHeight/4.37;
        }else if(winWidth<=1400 && winWidth>=1000){
            tu_w=winWidth/4.5;
            tu_h=winHeight/4.37;
        }else if(winWidth>1400 && winWidth<1700){
            tu_w=winWidth/4.5;
            tu_h=winHeight/4.37;

        }
        $(".tu").css('width',tu_w);
        $(".tu").css( 'height', tu_h);

        var numLine = echarts.init(document.getElementById('numLine'));
        var ageBar = echarts.init(document.getElementById('ageBar'));
        var ageLine = echarts.init(document.getElementById('ageLine'));
        var sexLine = echarts.init(document.getElementById('sexLine'));
        var hjLine = echarts.init(document.getElementById('hjLine'));
        var sexPie= echarts.init(document.getElementById('sexPie'));
        var hjPie= echarts.init(document.getElementById('hjPie'));
        var zbPie= echarts.init(document.getElementById('zbPie'));
    </script>
</div>


</body>
<script>
    $.ajax({
        url: "/visual/data/getVisualDataApartBase",
        type: "get",
        success: function (result) {
            if (result.success == true) {

                dataR = result.data;
                pieOldNum = dataR.NumOld;
                pieAllNum = dataR.NumAll;
                pieOldNum80 = dataR.NumOld80;
                title_text = "老人比例";
                legend_data = [{name: '老人', textStyle: {color: legend_color, fontSize: 18}}, {
                    name: '非老人',
                    textStyle: {color: legend_color, fontSize: 18}
                }];
                series = [
                    {
                        name: '',
                        type: 'pie',
                        radius: ['30%', '40%'],
                        avoidLabelOverlap: false,
                        label: {
                            normal: {
                                formatter: '{d}%\n({c})',
                                textStyle: {
                                    fontWeight: 'normal',
                                    fontSize: 10
                                }
                            }
                        },
                        data: [
                            {value:dataR.NumJieDaoPeople-dataR.NumOld, name:'非老人'},
                            {value:dataR.NumOld, name:'老人'}
                        ]
                    }
                ];
                //alert(dataR.NumJieDaoPeople);
                var option_zb_pie = chartPie(title_text, legend_data, series);
                zbPie.setOption(option_zb_pie);
                zbPie.on('legendselectchanged', function (params) {
                    var name = params.name;
                    if(name==">=80岁"){
                        ageStart=80;
                        ageEnd=120;

                    }else if(name=="60-80岁"){
                        ageStart=60;
                        ageEnd=80;

                    }
                    getJwData();
                    
                });

                title_text = '老人数量变化趋势';
                legend_data = [{name: '老人', textStyle: {color: legend_color, fontSize: 18}}, {
                    name: '总人口',
                    textStyle: {color: legend_color, fontSize: 18}
                }];
                xAxis_data = ['2月', '3月', '4月', '今天', '6月', '7月', '8月'];
                series = [
                    {
                        name: '老人',
                        type: 'line',
                        itemStyle: {
                            normal: {
                                lineStyle: {
                                    width: 1,
                                    color: series_color_1
                                },
                                label: {
                                    show: true
                                },
                                color: series_color_1

                            },
                        },
                        label: {
                            normal: {
                                textStyle: {
                                    fontSize: 14
                                }

                            }

                        },
                        markLine: {
                            itemStyle: {
                                normal: {
                                    lineStyle: {type: 'solid', color: 'orange'},
                                    label: {show: true, position: 'left', textStyle: {color: 'red', fontSize: 20}}
                                }
                            },
                            large: true,
                            symbol: "diamond",
                            symbolSize: 12,
                            effect: {
                                show: false,
                                loop: true,
                                period: 0,
                                scaleSize: 2,
                                color: null,
                                shadowColor: null,
                                shadowBlur: null
                            },
                            data: [
                                [
                                    {
                                        coord: [3, 0]
                                    },
                                    {
                                        coord: [3, 220]
                                    }
                                ]
                            ]
                        },
                        symbolSize: 8,//拐点大小
                        data: [210, 210, 215, {

                            value: 220,

                            symbol: 'circle', // 数据级个性化拐点图形

                            symbolSize: 20,

                            hoverAnimation: true,
                            label: {
                                show: true,
                                fontSize: 14
                            },
                            itemStyle: {

                                normal: {
                                    color: 'white'
                                }
                            }
                        }, 225, 230, 253]
                    },
                    {
                        name: '总人口',
                        type: 'line',
                        itemStyle: {
                            normal: {
                                lineStyle: {
                                    width: 1,
                                    color: series_color_1
                                },
                                label: {
                                    show: true
                                },
                                color: "yellow"
                            }
                        },
                        label: {
                            normal: {
                                textStyle: {
                                    fontSize: 16
                                }

                            }

                        },
                        markLine: {
                            itemStyle: {
                                normal: {
                                    lineStyle: {type: 'solid', color: 'orange'},
                                    label: {show: true, position: 'left', textStyle: {color: 'red', fontSize: 20}}
                                }
                            },
                            large: true,
                            symbol: "diamond",
                            symbolSize: 12,
                            effect: {
                                show: false,
                                loop: true,
                                period: 0,
                                scaleSize: 2,
                                color: null,
                                shadowColor: null,
                                shadowBlur: null
                            },
                            data: [
                                [
                                    {
                                        coord: [3, 0]
                                    },
                                    {
                                        coord: [3, 420]
                                    }
                                ]
                            ]
                        },
                        symbolSize: 8,//拐点大小
                        data: [410, 410, 415, {

                            value: 420,

                            symbol: 'circle', // 数据级个性化拐点图形

                            symbolSize: 20,

                            hoverAnimation: true,
                            label: {
                                show: true,
                                fontSize: 18
                            },
                            itemStyle: {

                                normal: {
                                    color: 'white'
                                }
                            }
                        }, 425, 430, 453]
                    }
                ];
                var option_num_line = chartLine(title_text, legend_data, xAxis_data, series);


                title_text = "户籍";
                legend_data = [{name: '户籍', textStyle: {color: legend_color, fontSize: 18}}, {
                    name: '非户籍',
                    textStyle: {color: legend_color, fontSize: 18}
                }];
                series = [{
                    name: '',
                    type: 'pie',
                    radius: '40%',
                    center: ['48%', '60%'],
                    label: {
                        normal: {
                            formatter: '{d}%\n({c})',
                            textStyle: {
                                fontWeight: 'normal',
                                fontSize: 10
                            }
                        }
                    },
                    data: [
                        {value: dataR.NumHuJi, name: '户籍'},
                        {value: dataR.NumFeiHuJi, name: '非户籍'}
                    ],
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }];
                var option_area_pie = chartPie(title_text, legend_data, series);
                //re
                title_text = '户籍占比趋势';
                legendData = ['户籍', '非户籍'];
                name1 = '户籍', name2 = '非户籍';
                var option_area_line = toolTip(title_text, legendData, name1, name2);


                title_text = "性别";
                legend_data = [{name: '男', textStyle: {color: legend_color, fontSize: 18}}, {
                    name: '女',
                    textStyle: {color: legend_color, fontSize: 18}
                }];
                series = [{
                    name: '老人性别',
                    type: 'pie',
                    radius: '40%',
                    label: {
                        normal: {
                            formatter: '{d}%\n({c})',
                            textStyle: {
                                fontWeight: 'normal',
                                fontSize: 10
                            }
                        }
                    },
                    center: ['48%', '60%'],
                    data: [
                        {value: dataR.NumMale, name: '男'},
                        {value: dataR.NumFemale, name: '女'}
                    ],
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }];
                var option_sex_pie = chartPie(title_text, legend_data, series);

                //

                // title_text='性别占比趋势图';
                // legend_data=[{name:'男',textStyle:{color:legend_color,fontSize:18}},{name:'女',textStyle:{color:legend_color,fontSize:18}}];
                // xAxis_data=['2月','3月','4月','今天','6月','7月','8月'];
                // series=[
                //     {
                //         name:'男',
                //         type:'bar',
                //         stack: '广告',
                //         data:[80, 79, 80, 74, 78, 80, 81]
                //     },
                //     {
                //         name:'女',
                //         type:'bar',
                //         stack: '广告',
                //         data:[20, 21, 20, 26, 22, 20, 19]
                //     }
                // ];
                // var option_sex_line=chartBarHei(title_text,legend_data,xAxis_data,series);
                title_text = '性别占比趋势';
                legendData = ['男', '女'];
                name1 = '男', name2 = '女';
                var option_sex_line = toolTip(title_text, legendData, name1, name2);

                //    年龄分布柱状图
                title_text = '年龄';
                legend_data = [
                    {
                        name: '男',
                        textStyle: {
                            color: '#fff',
                            fontSize: 18
                        }
                    },
                    {
                        name: '女',
                        textStyle: {
                            color: '#fff',
                            fontSize: 18

                        }
                    }
                ];
                yAxis_data = ['90-   ', '80-90', '70-80', '60-70'];
                series = [
                    {
                        name: '男',
                        type: 'bar',
                        stack: '总量',
                        label: {
                            normal: {
                                show: true,
                                position: 'insideLeft',
                                textStyle: {
                                    fontSize: 14
                                }
                            }
                        },
                        itemStyle: {
                            normal: {
                                color: series_color_1,
                                fontSize: 26
                            }
                        },
                        data: [dataR.NumAbove90M, dataR.Num80To90M, dataR.Num70To80M, dataR.Num60To70M]
                    },
                    {
                        name: '女',
                        type: 'bar',
                        stack: '总量',
                        label: {
                            normal: {
                                show: true,
                                position: 'insideRight',
                                textStyle: {
                                    fontSize: 14
                                }
                            }
                        },
                        itemStyle: {
                            normal: {
                                color: series_color_2,

                            }
                        },
                        data: [dataR.NumAbove90F, dataR.Num80To90F, dataR.Num70To80F, dataR.Num60To70F]
                    }
                ];
                var option_age_bar = chartBarFBA(title_text, legend_data, yAxis_data, series);

                // title_text='年龄占比趋势图';
                // legend_data=[{name:'60-70',textStyle:{color:legend_color,fontSize:18}},{name:'70-80',textStyle:{color:legend_color,fontSize:18}},
                //     {name:'80-90',textStyle:{color:legend_color,fontSize:18}},{name:'90-   ',textStyle:{color:legend_color,fontSize:18}}];
                // xAxis_data=['2月','3月','4月','今天','6月','7月','8月'];
                // series=[
                //     {
                //         name:'60-70',
                //         type:'bar',
                //         stack: '广告',
                //         data:[40, 37, 40, 22, 34, 40, 43]
                //     },
                //     {
                //         name:'70-80',
                //         type:'bar',
                //         stack: '广告',
                //         data:[20, 21, 20, 26, 22, 20, 19]
                //     },
                //     {
                //         name:'80-90',
                //         type:'bar',
                //         stack: '广告',
                //         data:[20, 21, 20, 26, 22, 20, 19]
                //     },
                //     {
                //         name:'90-   ',
                //         type:'bar',
                //         stack: '广告',
                //         data:[20, 21, 20, 26, 22, 20, 19]
                //     }
                // ];
                // var option_age_line=chartBarHei_1(title_text,legend_data,xAxis_data,series);
                title_text = '年龄趋势';
                legend_data = [{name: '60-70', textStyle: {color: legend_color}}, {
                    name: '70-80',
                    textStyle: {color: legend_color}
                },
                    {name: '80-90', textStyle: {color: legend_color}}, {
                        name: '90-   ',
                        textStyle: {color: legend_color}
                    }];
                var option_age_line = toolTipMultiForBaseAge(title_text, legend_data);


                numLine.setOption(option_num_line);
                hjPie.setOption(option_area_pie);
                hjPie.on('legendselectchanged',function(params){
                    var name=params.name;
                    if(name=="户籍"){
                        census.push(12);
                        //district.push(district_no);

                    }else if(name=="非户籍"){
                        census.push(13);
                        //  district.push(district_no);

                    }
                    getJwData();
                    

                });
                hjLine.setOption(option_area_line);
                sexPie.setOption(option_sex_pie);
                sexPie.on('legendselectchanged', function (params) {
                    var name = params.name;
                    if(name=="男"){
                        sex=2;

                    }else if(name=="女"){
                        sex=1;

                    }
                    getJwData();
                    

                });
                sexLine.setOption(option_sex_line);
                ageBar.setOption(option_age_bar);
                ageBar.on('legendselectchanged', function (params) {
                    var name = params.name;
                    if(name=="男"){
                        sex=2;

                    }else if(name=="女"){
                        sex=1;

                    }
                    getJwData();
                    
                });
                ageLine.setOption(option_age_line);
            }
        }
    });

</script>
</html>