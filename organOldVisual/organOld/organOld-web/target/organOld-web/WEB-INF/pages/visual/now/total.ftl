<style>
    @media only screen and (min-width: 6000px){
            .total_tu,.total_tu_big{
                padding-top: 5%;
                padding-bottom: 2%;
            }
            #total .title{
                font-size: 40px;
                color: white;
                line-height: 60px;
            }
            #total .number{
                font-size: 45px;
                color: orange;
                font-weight: bold;
                padding: 20px 10px;
            }
            #total #ttt{
                margin-top: 0%
            }

    }
    @media only screen and (min-width: 1000px){
        .total_tu,.total_tu_big{
            padding-top: 1%;
            padding-bottom: 2%;
        }
        #total .title{
            font-size: 40px;
            color: white;
            line-height: 60px;
        }
       .number{
           font-size: 70px;
           color: orange!important;
           font-weight: bold;
           padding: 12px 6px;
        }
        #total #ttt{
            margin-top: 0%
        }

    }
</style>
<div id="child_total">
    <div class="row">
        <div class="col-lg-6 box total_text">
            <div class="zz"></div>
            <div  style="position:relative;top: 10px">
                <p style="text-align: center;font-size: 30px;">街道人口总数：</p>
                <p style="text-align: center;font-size: 30px;line-height: 5px"class="number" id="pNumAll"></br>16万人</p>                    <#--<p style="text-align: center" id="pNum60"><span class="title">60岁及以上老人总数：</br></span><span class="number"  id="oldNum60"><font face="STFangsong" color="yellow" style="font-size: 40px">31666</font> </span><span class="title">人</span></p>-->
                <p style="text-align: center;font-size: 30px;">60岁及以上老人总数：</p>
                <p style="text-align: center;font-size: 30px;line-height: 5px" class="number" id="pNum60"></br>31666人</p>
                <p style="text-align: center;font-size: 30px;">80岁及以上老人总数：</p>
                <p style="text-align: center;font-size: 30px;line-height: 5px" class="number" id="pNum80"></br>3783</p>
            </div>
        </div>
        <div class="col-lg-6">
            <div class="row">
                <div class="col-lg-12  box" >
                    <div class="zz"></div>
                    <div id="total_oldmanPie" class="total_tu"></div>
                </div>
            </div>
        </div>
    </div>
    <div class="row" >
        <div class="col-lg-12 box">
            <div class="zz"></div>
            <div id="total_pqBar" class="total_tu_big"></div>
        </div>
    </div>
</div>
<script>

</script>
<script type="text/javascript">
    var total_tu_w,total_tu_h,total_tu_big_w,total_tu_big_h,total_text_h;
    var total_width=$("#total").width();

    if(winWidth>=1900){
        total_tu_w=total_width/2.2;
        total_tu_h=winHeight/4.425;
        total_tu_big_w=total_width/1.0;
        total_tu_big_h=winHeight/4.4;
        total_text_h=winHeight/4.4;
    }else if(winWidth<=1400 && winWidth>=1300){
        total_tu_w=winWidth/4.5;
        total_tu_h=winHeight/4.1;
        total_tu_big_w=winWidth/2.0;
        total_tu_big_h=winHeight/2.2;
        total_text_h=winHeight/2.02;
    }
    $(".total_tu").css('width',total_tu_w/0.95);
    $(".total_tu").css( 'height', total_tu_h);
    $(".total_text").css( 'height', total_text_h);
    $(".total_tu_big").css('width',total_tu_big_w);
    $(".total_tu_big").css( 'height', total_tu_big_h);
    var total_pqBar= echarts.init(document.getElementById('total_pqBar'));
    //var total_statusPie= echarts.init(document.getElementById('total_statusPie'));
    var total_oldmanPie=echarts.init(document.getElementById('total_oldmanPie'));
    var total_zdPie=echarts.init(document.getElementById('total_zdPie'));
</script>

<script>
    //片区人数分布
    // legend_data="";
    // title_text='片区老年人口分布柱状';
    // yAxis_data=['东兰','古龙','平南','平阳','平吉','古美'];
    // series=[
    //     {
    //         name: '',
    //         type: 'bar',
    //         stack: '总量',
    //         label: {
    //             normal: {
    //                 show: true,
    //                 position: 'right',
    //                 textStyle:{
    //                     fontSize:series_lebel_fontSize
    //                 }
    //             }
    //         },
    //         itemStyle:{
    //             normal: {
    //                 color:series_color_1,
    //                 fontSize:series_item_fontSize
    //             }
    //         },
    //         data: [131,163,214,234,334,467]
    //     }
    // ];
    var pieOldNum,pieOldNum80,pieAllNum,organOldNum,familyOldNum,communityOldNum;
    // $.ajax({
    //     url : "/visual/data/getVisualData",
    //     type : "get",
    //     success : function(result) {
    //         if (result.success==true) {
    //             document.getElementById("oldNum60").innerHTML = result.data.oldNum60;
    //             document.getElementById("oldNum80").innerHTML = result.data.oldNum80;
    //             pieOldNum = result.data.oldNum;
    //             pieAllNum = result.data.allNum;
    //             pieOldNum80 = result.data.oldNum80;
    //             organOldNum = result.data.organOldNum;
    //             familyOldNum = result.data.familyOldNum;
    //             communityOldNum = result.data.communityOldNum;
    //             var dataOldStatus=[
    //                 {value:organOldNum, name:'机构养老'},
    //                 {value:communityOldNum, name:'社区养老'},
    //                 {value:familyOldNum, name:'居家养老'}
    //             ];
    //              var dataOldAndNoneOld=[
    //                 {value:pieAllNum-pieOldNum, name:'非老人'},
    //                 {value:pieOldNum, name:'老人'}
    //             ];
    //              var data80AboveAndUnder=[
    //                 {value:pieOldNum-pieOldNum80, name:'80岁以下'},
    //                 {value:pieOldNum80, name:'80岁及以上'}
    //             ];
    //
    //             var title_text="养老状态分布饼图";
    //             var legend_data=[{name:'机构养老',textStyle:{color:legend_color,fontSize:legand_fontSize}},{name:'社区养老',textStyle:{color:legend_color,fontSize:legand_fontSize}},{name:'居家养老',textStyle:{color:legend_color,fontSize:legand_fontSize}}];
    //             var series=[{
    //                 name: '老养老状态',
    //                 type: 'pie',
    //                 radius : '45%',
    //                 label : {
    //                     normal : {
    //                         formatter: '{d}%\n({c})',
    //                         textStyle : {
    //                             fontWeight : 'normal',
    //                             fontSize : series_lebel_fontSize
    //                         }
    //                     }
    //                 },
    //                 center: ['48%', '60%'],
    //                 data:dataOldStatus,
    //                 itemStyle: {
    //                     emphasis: {
    //                         shadowBlur: 10,
    //                         shadowOffsetX: 0,
    //                         shadowColor: 'rgba(0, 0, 0, 0.5)'
    //                     }
    //                 }
    //             }];
    //             var total_option_status_pie = chartPie(title_text,legend_data,series);
    //
    //             //60岁老人占比
    //             title_text="老人\n\n比例";
    //             legend_data=[{name:'老人',textStyle:{color:legend_color,fontSize:legand_fontSize}},{name:'非老人',textStyle:{color:legend_color,fontSize:legand_fontSize}}];
    //             series=[
    //                 {
    //                     name:'',
    //                     type:'pie',
    //                     radius: ['50%', '70%'],
    //                     avoidLabelOverlap: false,
    //                     label: {
    //                         normal : {
    //                             formatter: '{d}%\n({c})',
    //                             textStyle : {
    //                                 fontWeight : 'normal',
    //                                 fontSize : series_lebel_fontSize
    //                             }
    //                         }
    //                     },
    //                     data:dataOldAndNoneOld
    //                 }
    //             ];
    //             var total_option_oldman_pie = chartPieClick(title,legend_data,series);
    //             //重点老人占比
    //             title_text="80岁及\n\n以上\n\n老人比例";
    //             legend_data=[{name:'80岁及以上',textStyle:{color:legend_color,fontSize:legand_fontSize}},{name:'80岁以下',textStyle:{color:legend_color,fontSize:legand_fontSize}}];
    //             series=[
    //                 {
    //                     name:'',
    //                     type:'pie',
    //                     radius: ['50%', '70%'],
    //                     avoidLabelOverlap: false,
    //                     label: {
    //                         normal : {
    //                             formatter: '{d}%\n({c})',
    //                             textStyle : {
    //                                 fontWeight : 'normal',
    //                                 fontSize : series_lebel_fontSize
    //                             }
    //                         }
    //                     },
    //                     data:data80AboveAndUnder
    //                 }
    //             ];
    //             var total_option_zd_pie = chartPie(title_text,legend_data,series);
    //
    //             // total_pqBar.setOption(total_option_pq_bar);
                   //total_statusPie.setOption(total_option_status_pie);
    //             total_oldmanPie.setOption(total_option_oldman_pie);
    //             total_zdPie.setOption(total_option_zd_pie);
    //
    //         }
    //     }
    // });
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
        //color: ['#003366', '#006699', '#4cabce', '#e5323e'],
        title: {
            text:'片区老年人口分布',
            textStyle:{
                color:'#fff',
                fontSize:title_fontSize,
                fontWeight:100
            },
            x:'0%',
            y:'0%',
        },
        color: ['#ffd289'],
        // tooltip: {
        //     trigger: 'axis',
        //     axisPointer: {
        //         type: 'shadow'
        //     }
        // },
        legend: {
            data: ['']
        },
        // toolbox: {
        //     show: true,
        //     orient: 'vertical',
        //     left: 'right',
        //     top: 'center',
        //     feature: {
        //         mark: {show: true},
        //         dataView: {show: true, readOnly: false},
        //         magicType: {show: true, type: ['line', 'bar', 'stack', 'tiled']},
        //         restore: {show: true},
        //         saveAsImage: {show: true}
        //     }
        // },
        calculable: true,
        xAxis: [
            {
                type: 'category',
                axisTick: {show: false},
                data: ['东兰','古龙','平南','平阳','平吉','古美'],
                axisLine:{
                    lineStyle:{
                        color:'white',
                        fontSize: 20
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
                data: [320, 332, 301, 334, 390,440],
                barWidth: 20,//柱图宽度
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
                        shadowBlur: 20,
                    }
                },
                barWidth:35,

            },

        ]
    };
    //pqBar.setOption(option);
    total_pqBar.setOption(option);
</script>