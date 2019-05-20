<style>
    @media only screen and (min-width: 6000px){
        .base_tu,.base_tu_big{
            padding-top: 5%;
            padding-bottom: 2%;
        }
    }
</style>
<div id="child_base" style="display: none">
    <div class="row" >
        <div class="col-lg-6 box">
            <div class="zz"></div>
            <div id="base_zbPie" class="base_tu"></div>
        </div>
        <div class="col-lg-6 box line"style="margin-left: -5px">
            <div class="zz"></div>
            <div id="base_numLine" class="base_tu"></div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-6 box" style="margin-top: -5px">
            <div class="zz"></div>
            <div id="base_hjPie" class="base_tu"></div>
        </div>
        <div class="col-lg-6 box" style="margin-top: -5px">
            <div class="zz"></div>
            <div id="base_hjLine" class="base_tu"></div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-6 box">
            <div class="zz"></div>
            <div id="base_sexPie" class="base_tu"></div>
        </div>
        <div class="col-lg-6 box line"style="margin-left: -5px">
            <div class="zz"></div>
            <div id="base_sexLine" class="base_tu"></div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-6 box" style="margin-top: -5px">
            <div class="zz"></div>
            <div id="base_ageBar" class="base_tu_age"></div>
        </div>
        <div class="col-lg-6 box"style="margin-top: -5px">
            <div class="zz"></div>
            <div id="base_ageLine" class="base_tu"></div>
        </div>
    </div>
</div>
<script type="text/javascript">
    var base_tu_w,base_tu_h;
    var base_width=$("#total").width();
    if(winWidth>=1900){
        base_tu_w=base_width/2.2;
        base_tu_h=winHeight/8.8;
    }else if(winWidth<=1400 && winWidth>=1300){
        oldman_tu_w=winWidth/4.5;
        oldman_tu_h=winHeight/4.1;
    }

    $(".base_tu").css('width',base_tu_w/0.95);
    $(".base_tu").css( 'height', base_tu_h);

    $(".base_tu_age").css('width',base_tu_w/0.95);
    $(".base_tu_age").css( 'height', base_tu_h);

    var base_numLine = echarts.init(document.getElementById('base_numLine'));
    var base_ageBar = echarts.init(document.getElementById('base_ageBar'));
    var base_ageLine = echarts.init(document.getElementById('base_ageLine'));
    var base_sexLine = echarts.init(document.getElementById('base_sexLine'));
    var base_hjLine = echarts.init(document.getElementById('base_hjLine'));
    var base_sexPie= echarts.init(document.getElementById('base_sexPie'));
    var base_hjPie= echarts.init(document.getElementById('base_hjPie'));
    var base_zbPie= echarts.init(document.getElementById('base_zbPie'));
</script>
<script>
    title.text="老\n人\n比\n例";
    //title.link="javascript: change('child_base','child_oldman')";
    legend_data=[{name:'老人',textStyle:{color:legend_color,fontSize:18}},{name:'非老人',textStyle:{color:legend_color,fontSize:18}}];
    series=[
        {
            name:'',
            type:'pie',
            radius: ['50%', '70%'],
            avoidLabelOverlap: false,
            label: {
                normal : {
                    formatter: '{d}%\n({c})',
                    textStyle : {
                        fontWeight : 100,
                        fontSize : 26
                    }
                }
            },
            data:[
                {value:15360, name:'非老人'},
                {value:4310, name:'老人'}
            ]
        }
    ];
    var base_option_zb_pie = chartPieClick(title,legend_data,series);
    base_zbPie.setOption(base_option_zb_pie);

    title_text='老人数量变化趋势';
    legend_data=[{name:'老人',textStyle:{color:legend_color,fontSize:18}},{name:'总人口',textStyle:{color:legend_color,fontSize:18}}];
    xAxis_data=['10月','11月','12月','1月','2月'];
    series=[
        {
            name: '老人',
            type: 'line',
            itemStyle:{
                normal: {
                    lineStyle:{
                        width:1,
                        color:series_color_1
                    },
                    label : {
                        show: true
                    },
                    color:series_color_1

                },
            },
            label:{
                normal:{
                    textStyle:{
                        fontSize:20
                    }

                }

            },
            markLine: {
                itemStyle: {
                    normal: {lineStyle: {type: 'solid', color: 'orange'}, label: {show: true, position: 'left', textStyle:{color:'red',fontSize:20}}}
                },
                large: true,
                symbol:"diamond",
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
                            coord: [2, 0]
                        },
                        {
                            coord: [2, 220]
                        }
                    ]
                ]
            },
            symbolSize: 8,//拐点大小
            data: [210,215,{

                value : 220,

                symbol: 'circle', // 数据级个性化拐点图形

                symbolSize : 20,

                hoverAnimation :true,
                label:{
                    show:true,
                    fontSize:18
                },
                itemStyle:{

                    normal:{
                        color:'white'
                    }}},225,230]
        },
        {
            name: '总人口',
            type: 'line',
            itemStyle:{
                normal: {
                    lineStyle:{
                        width:1,
                        color:series_color_1
                    },
                    label : {
                        show: true
                    },
                    color:"yellow"
                }
            },
            label:{
                normal:{
                    textStyle:{
                        fontSize:20
                    }

                }

            },
            markLine: {
                itemStyle: {
                    normal: {lineStyle: {type: 'solid', color: 'orange'}, label: {show: true, position: 'left', textStyle:{color:'red',fontSize:20}}}
                },
                large: true,
                symbol:"diamond",
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
                            coord: [2, 0]
                        },
                        {
                            coord: [2, 420]
                        }
                    ]
                ]
            },
            symbolSize: 8,//拐点大小
            data: [410,415,{

                value : 420,

                symbol: 'circle', // 数据级个性化拐点图形

                symbolSize : 20,

                hoverAnimation :true,
                label:{
                    show:true,
                    fontSize:18
                },
                itemStyle:{

                    normal:{
                        color:'white'
                    }}},425,430]
        }
    ];
    var base_option_num_line = chartLine(title_text,legend_data,xAxis_data,series);


    // title_text="户籍分布饼图";
    // legend_data=[{name:'户籍',textStyle:{color:legend_color,fontSize:18}},{name:'非户籍',textStyle:{color:legend_color,fontSize:18}}];
    // series=[{
    //     name: '老人户籍',
    //     type: 'pie',
    //     radius : '55%',
    //     center: ['48%', '60%'],
    //     label : {
    //         normal : {
    //             formatter: '{d}%\n({c})',
    //             textStyle : {
    //                 fontWeight : 100,
    //                 fontSize : 26
    //             }
    //         }
    //     },
    //     data:[
    //         {value:476, name:'户籍'},
    //         {value:376, name:'非户籍'}
    //     ],
    //     itemStyle: {
    //         emphasis: {
    //             shadowBlur: 10,
    //             shadowOffsetX: 0,
    //             shadowColor: 'rgba(0, 0, 0, 0.5)'
    //         }
    //     }
    // }];
    // var base_option_area_pie = chartPie(title_text,legend_data,series);
    //
    // title_text='户籍占比趋势图';
    // legendData=['户籍','非户籍'];
    // name1='户籍',name2='非户籍';
    // var base_option_area_line=toolTip(title_text,legendData,name1,name2);
    //
    //
    // title_text="性别分布饼图";
    // legend_data=[{name:'男',textStyle:{color:legend_color,fontSize:18}},{name:'女',textStyle:{color:legend_color,fontSize:18}}];
    // series=[{
    //     name: '老人性别',
    //     type: 'pie',
    //     radius : '55%',
    //     label : {
    //         normal : {
    //             formatter: '{d}%\n({c})',
    //             textStyle : {
    //                 fontWeight : 100,
    //                 fontSize : 26
    //             }
    //         }
    //     },
    //     center: ['48%', '60%'],
    //     data:[
    //         {value:476, name:'男'},
    //         {value:376, name:'女'}
    //     ],
    //     itemStyle: {
    //         emphasis: {
    //             shadowBlur: 10,
    //             shadowOffsetX: 0,
    //             shadowColor: 'rgba(0, 0, 0, 0.5)'
    //         }
    //     }
    // }];
    // var base_option_sex_pie = chartPie(title_text,legend_data,series);
    //
    // title_text='性别占比趋势图';
    // legendData=['男','女'];
    // name1='女',name2='女';
    // var base_option_sex_line=toolTip(title_text,legendData,name1,name2);
    //
    //
    //
    // //    年龄分布柱状图
    // title_text='年龄分布柱状图';
    // legend_data=[
    //     {
    //         name:'男',
    //         textStyle:{
    //             color:'#fff',
    //             fontSize:18
    //         }
    //     },
    //     {
    //         name:'女',
    //         textStyle:{
    //             color:'#fff',
    //             fontSize:18
    //
    //         }}
    // ];
    // yAxis_data=['90-   ','80-90','70-80','60-70'];
    // series=[
    //     {
    //         name: '男',
    //         type: 'bar',
    //         stack: '总量',
    //         label: {
    //             normal: {
    //                 show: true,
    //                 position: 'insideLeft',
    //                 textStyle:{
    //                     fontSize:20
    //                 }
    //             }
    //         },
    //         itemStyle:{
    //             normal: {
    //                 color:series_color_1,
    //                 fontSize:26
    //             }
    //         },
    //         data: [67,134,234,534]
    //     },
    //     {
    //         name: '女',
    //         type: 'bar',
    //         stack: '总量',
    //         label: {
    //             normal: {
    //                 show: true,
    //                 position: 'insideRight',
    //                 textStyle:{
    //                     fontSize:20
    //                 }
    //             }
    //         },
    //         itemStyle:{
    //             normal: {
    //                 color:series_color_2,
    //
    //             }
    //         },
    //         data: [7,34,134,234]
    //     }
    // ];
    // var base_option_age_bar=chartBar(title_text,legend_data,yAxis_data,series);
    //
    //
    // title_text='年龄占比趋势图';
    // legend_data=[{name:'60-70',textStyle:{color:legend_color}},{name:'70-80',textStyle:{color:legend_color}},
    //     {name:'80-90',textStyle:{color:legend_color}},{name:'90-   ',textStyle:{color:legend_color}}];
    // var base_option_age_line=toolTipMulti(title_text,legend_data);
    //
    //
    //
    // base_numLine.setOption(base_option_num_line);
    // base_hjPie.setOption(base_option_area_pie);
    // base_hjLine.setOption(base_option_area_line);
    // base_sexPie.setOption(base_option_sex_pie);
    // base_sexLine.setOption(base_option_sex_line);
    // base_ageBar.setOption(base_option_age_bar);
    // base_ageLine.setOption(base_option_age_line);

</script>