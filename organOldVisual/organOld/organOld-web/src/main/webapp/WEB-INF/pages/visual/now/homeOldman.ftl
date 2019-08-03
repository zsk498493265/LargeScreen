<style>
    @media only screen and (min-width: 6000px){
        .homeOldman_tu,.homeOldman_tu_big{
            padding-top: 5%;
            padding-bottom: 2%;
        }
    }
</style>
<div id="child_homeOldman" style="display: none">
    <div class="row" >
        <div class="col-lg-6 box"  align="center" style="height: 246px">
            <div class="zz"></div>
            <div id="homeOldman_jj_pie" class="homeOldman_tu_big"></div>
        </div>
        <div class="col-lg-6">
            <div class="row">
                <div class="col-lg-12 box">
                    <div class="zz"></div>
                    <div id="homeOldman_pq_bar" class="homeOldman_tu"></div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12 box" style="height:124px">
                    <div class="zz"></div>

                    <div id="homeOldman_sex_pie" class="homeOldman_tu"></div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-6 box">
            <div class="zz"></div>
            <div id="homeOldman_num_pie" class="homeOldman_tu_big"></div>
        </div>
        <div class="col-lg-6 box">
            <div class="zz"></div>
            <div id="homeOldman_age_bar" class="homeOldman_tu_big"></div>
        </div>
    </div>
</div>
<script type="text/javascript">
    var homeOldman_tu_w,homeOldman_tu_h,homeOldman_tu_big_w,homeOldman_tu_big_h;
    var homeOldman_width=$("#organ").width();
    if(winWidth>=1900){
        homeOldman_tu_w=homeOldman_width/2.2;
        homeOldman_tu_h=winHeight/8.85;
        homeOldman_tu_big_w=homeOldman_width/2.2;
        homeOldman_tu_big_h=winHeight/4.4;
    }else if(winWidth<=1400 && winWidth>=1300){
        oldman_tu_w=winWidth/4.5;
        oldman_tu_h=winHeight/4.1;
    }

    $(".homeOldman_tu_big").css('width',homeOldman_tu_big_w/0.95);
    $(".homeOldman_tu_big").css( 'height', homeOldman_tu_big_h);
    $(".homeOldman_tu").css('width',homeOldman_tu_w/0.95);
    $(".homeOldman_tu").css( 'height', homeOldman_tu_h);

    var homeOldman_num_pie=echarts.init(document.getElementById('homeOldman_num_pie'));
    var homeOldman_pq_bar=echarts.init(document.getElementById('homeOldman_pq_bar'));
    var homeOldman_jj_pie = echarts.init(document.getElementById('homeOldman_jj_pie'));
    var homeOldman_age_bar= echarts.init(document.getElementById('homeOldman_age_bar'));
    var homeOldman_sex_pie= echarts.init(document.getElementById('homeOldman_sex_pie'));
</script>
<script>
    title_text="人数占比";
    legend_data=[{name:'已参加的重点老人',textStyle:{color:legend_color,fontSize:18}},{name:'未参加的重点老人',textStyle:{color:legend_color,fontSize:18}}];
    series=[
        {
            name:'',
            type:'pie',
            radius: ['40%', '60%'],
            avoidLabelOverlap: false,
            label: {
                normal : {
                    formatter: '{d}%\n({c})',
                    textStyle : {
                        fontWeight : 'normal',
                        fontSize : 20
                    }
                }
            },
            data:[
                {value:1360, name:'未参加的重点老人'},
                {value:234, name:'已参加的重点老人'}
            ]
        }
    ];
    var homeOldman_option_num= chartPie(title_text,legend_data,series);
    homeOldman_num_pie.setOption(homeOldman_option_num);

    homeOldman_num_pie.on('legendselectchanged', function (params) {
        // var name = params.name;
        // if(name=="已参加的重点老人"){
        //     thirdTypeArray.push(7,8,9,10,11,12,19,14,15,16);
        // }else if(name=="未参加的重点老人"){
        //     zhucan = 1;
        // }
        // table.fnFilter();
        // //getAgeAndSex();
        // getNumOfJw();
        var name=params.name;
        homeOldman_num_pie.dispatchAction({
            type: 'legendSelect',
            name: name
        });
    });

    //片区人数分布
    // legend_data="";
    // title_text='户籍';
    // yAxis_data=['东兰','古龙','平南','平阳','平吉','古美'];
    // series=[
    //     {
    //         name: '',
    //         type: 'bar',
    //         stack: '总量',
    //         label: {
    //             normal: {
    //                 show: true,
    //                 position: 'insideLeft'
    //             }
    //         },
    //         itemStyle:{
    //             normal: {
    //                 color:series_color_1
    //             }
    //         },
    //         data: [67,134,234,534,263,231]
    //     }
    // ];
    // var homeOldman_option_pq_bar=chartBar(title_text,legend_data,yAxis_data,series);
    //=>huji
    title_text="户籍";
    legend_data=[{name:'户籍',textStyle:{color:legend_color,fontSize:18}},{name:'非户籍',textStyle:{color:legend_color,fontSize:18}}];
    series=[{
        name: '老人户籍',
        type: 'pie',
        radius : '55%',
        center: ['48%', '60%'],
        label : {
            normal : {
                formatter: '{d}%\n({c})',
                textStyle : {
                    fontWeight : 100,
                    fontSize : 26
                }
            }
        },
        data:[
            {value:6047, name:'户籍'},
            {value:1713, name:'非户籍'}
        ],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }];
    var homeOldman_option_pq_bar = chartPie(title_text,legend_data,series);
    homeOldman_pq_bar.setOption(homeOldman_option_pq_bar);

    homeOldman_pq_bar.on('legendselectchanged', function (params) {
        var name = params.name;
        if(name=="户籍"){
            census.push(12);
        }else if(name=="非户籍"){
            census.push(13,14);
        }
        table.fnFilter();
        //getAgeAndSex();
        getNumOfJw();
        homeOldman_pq_bar.dispatchAction({
            type: 'legendSelect',
            name: name
        });
    });

    //    已评级年龄分布柱状图
    title_text='年龄';
    legend_data=[
        {
            name:'男',
            textStyle:{
                color:'#fff',
                fontSize:18
            }
        },
        {
            name:'女',
            textStyle:{
                color:'#fff',
                fontSize:18
            }}
    ];
    yAxis_data=['90-   ','80-90','70-80','60-70'];
    series=[
        {
            name: '男',
            type: 'bar',
            stack: '总量',
            label: {
                normal: {
                    show: true,
                    position: 'insideLeft',
                    textStyle:{
                        fontSize:20
                    }

                }
            },
            itemStyle:{
                normal: {
                    color:series_color_1,


                }
            },
            data: [67,134,234,534]
        },
        {
            name: '女',
            type: 'bar',
            stack: '总量',
            label: {
                normal: {
                    show: true,
                    position: 'insideRight',
                    textStyle:{
                        fontSize:20
                    }
                }
            },
            itemStyle:{
                normal: {
                    color:series_color_2
                }
            },
            data: [7,34,134,234]
        }
    ];
    var homeOldman_option_age_bar=chartBar(title_text,legend_data,yAxis_data,series);
    homeOldman_age_bar.setOption(homeOldman_option_age_bar);

    homeOldman_age_bar.on('legendselectchanged', function (params) {
        var name = params.name;
        if(name=="男"){
            sex=2;
        }else if(name=="女"){
            sex=1;
        }
        table.fnFilter();
        //getAgeAndSex();
        getNumOfJw();
        homeOldman_age_bar.dispatchAction({
            type: 'legendSelect',
            name: name
        });

    });



    //性别饼图
    title_text="性别";
    legend_data=[{name:'男',textStyle:{color:legend_color,fontSize:18}},{name:'女',textStyle:{color:legend_color,fontSize:18}}];
    series=[{
        name: '老人性别',
        type: 'pie',
        radius : '55%',
        label : {
            normal : {
                formatter: '{d}%\n({c})',
                textStyle : {
                    fontWeight : 'normal',
                    fontSize : 20
                }
            }
        },
        center: ['48%', '60%'],
        data:[
            {value:238, name:'男'},
            {value:381, name:'女'}
        ],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }];
    var homeOldman_option_sex_pie = chartPie(title_text,legend_data,series);
    homeOldman_sex_pie.setOption(homeOldman_option_sex_pie);

    homeOldman_sex_pie.on('legendselectchanged', function (params) {
        var name = params.name;
        if(name=="男"){
            sex=2;
        }else if(name=="女"){
            sex=1;
        }
        table.fnFilter();
        //getAgeAndSex();
        getNumOfJw();
        var name=params.name;
        homeOldman_sex_pie.dispatchAction({
            type: 'legendSelect',
            name: name
        });
    });

    title.text="服务项目";
    title.link="javascript: change('child_homeOldman','child_organ')";
    legend_data=[{name:'助餐',textStyle:{color:legend_color,fontSize:18}},{name:'助洁',textStyle:{color:legend_color,fontSize:18}},{name:'助急',textStyle:{color:legend_color,fontSize:18}}
        ,{name:'助浴',textStyle:{color:legend_color,fontSize:18}},{name:'助行',textStyle:{color:legend_color,fontSize:18}},{name:'助医',textStyle:{color:legend_color,fontSize:18}}
        ,{name:'洗衣服',textStyle:{color:legend_color,fontSize:18}},{name:'相谈',textStyle:{color:legend_color,fontSize:18}},{name:'康复辅助',textStyle:{color:legend_color,fontSize:18}}
        ,{name:'生活护理',textStyle:{color:legend_color,fontSize:18}},{name:'其他',textStyle:{color:legend_color,fontSize:18}}];
    series=[{
        name: '老人户籍',
        type: 'pie',
        radius : '65%',
        center: ['48%', '50%'],
        label : {
            normal : {
                formatter: '{d}%\n({c})',
                textStyle : {
                    fontWeight : 'normal',
                    fontSize : 20
                }
            }
        },
        data:[
            {value:476, name:'助餐'},
            {value:376, name:'助洁'},
            {value:376, name:'助浴'},
            {value:476, name:'助行'},
            {value:376, name:'助医'},
            {value:376, name:'洗衣服'},
            {value:476, name:'相谈'},
            {value:376, name:'康复辅助'},
            {value:376, name:'生活护理'},
            {value:376, name:'其他'}
        ],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }];
    var homeOldman_option_jj_pie = chartPieClick(title,legend_data,series);
    homeOldman_jj_pie.setOption(homeOldman_option_jj_pie);

    // var thirdTypeArray1 = [];
    // function listIntersection(x, y) {
    //     var result = [];
    //     for (var i = 0; i < y.length; i++) {
    //         var temp = y[i];
    //         for (var j = 0; j < x.length; j++) {
    //             // 普通数组 (temp === clone[j])
    //             if (temp.id === x[j].id) {
    //                 result.push(temp);
    //                 break;
    //             }
    //         }
    //     }
    //     return array_remove_repeat(result);
    // }
    // function array_remove_repeat(a) { // 去重
    //     var r = [];
    //     for(var i = 0; i < a.length; i ++) {
    //         var flag = true;
    //         var temp = a[i];
    //         for(var j = 0; j < r.length; j ++) {
    //             if(temp === r[j]) {
    //                 flag = false;
    //                 break;
    //             }
    //         }
    //         if(flag) {
    //             r.push(temp);
    //         }
    //     }
    //     return r;
    // }
    //
    // homeOldman_jj_pie.on('legendselectchanged', function (params) {
    //     var name = params.name;
    //     if(name=="助餐"){
    //         thirdTypeArray1.push(7);
    //         if(thirdTypeArray != null)
    //             thirdTypeArray = listIntersection(thirdTypeArray, thirdTypeArray1);
    //         else
    //             thirdTypeArray = thirdTypeArray1;
    //     }else if(name=="助洁"){
    //         thirdTypeArray1.push(8);
    //         if(thirdTypeArray != null)
    //             thirdTypeArray = listIntersection(thirdTypeArray, thirdTypeArray1);
    //         else
    //             thirdTypeArray = thirdTypeArray1;
    //     }else if(name=="助浴"){
    //         thirdTypeArray1.push(10);
    //         if(thirdTypeArray != null)
    //             thirdTypeArray = listIntersection(thirdTypeArray, thirdTypeArray1);
    //         else
    //             thirdTypeArray = thirdTypeArray1;
    //     }else if(name=="助行"){
    //         thirdTypeArray1.push(11);
    //         if(thirdTypeArray != null)
    //             thirdTypeArray = listIntersection(thirdTypeArray, thirdTypeArray1);
    //         else
    //             thirdTypeArray = thirdTypeArray1;
    //     }else if(name=="助医"){
    //         thirdTypeArray1.push(12);
    //         if(thirdTypeArray != null)
    //             thirdTypeArray = listIntersection(thirdTypeArray, thirdTypeArray1);
    //         else
    //             thirdTypeArray = thirdTypeArray1;
    //     }else if(name=="洗衣服"){
    //         thirdTypeArray1.push(15);
    //         if(thirdTypeArray != null)
    //             thirdTypeArray = listIntersection(thirdTypeArray, thirdTypeArray1);
    //         else
    //             thirdTypeArray = thirdTypeArray1;
    //     }else if(name=="相谈"){
    //         thirdTypeArray1.push(14);
    //         if(thirdTypeArray != null)
    //             thirdTypeArray = listIntersection(thirdTypeArray, thirdTypeArray1);
    //         else
    //             thirdTypeArray = thirdTypeArray1;
    //     }else if(name=="康复辅助"){
    //         thirdTypeArray1.push(13);
    //         if(thirdTypeArray != null)
    //             thirdTypeArray = listIntersection(thirdTypeArray, thirdTypeArray1);
    //         else
    //             thirdTypeArray = thirdTypeArray1;
    //     }else if(name=="生活护理"){
    //         thirdTypeArray1.push(16);
    //         if(thirdTypeArray != null)
    //             thirdTypeArray = listIntersection(thirdTypeArray, thirdTypeArray1);
    //         else
    //             thirdTypeArray = thirdTypeArray1;
    //     }else if(name=="其他"){
    //
    //     }
    //     table.fnFilter();
    //     getNumOfJw();
    //     //getAgeAndSex();
    // });
</script>