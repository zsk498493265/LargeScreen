<style>
    @media only screen and (min-width: 6000px){
        .znh_tu,.znh_tu_big{
            padding-top: 5%;
            padding-bottom: 2%;
        }
    }
</style>
<div id="child_znh" style="display: none">
    <div class="row">
        <div class="col-lg-6 box"  align="center">
            <div class="zz"></div>
            <div id="znh_zn_num_pie" class="znh_tu_big"></div>
        </div>
        <div class="col-lg-6 box">
            <div class="zz"></div>
            <div id="znh_zn_pie" class="znh_tu_big"></div>
        </div>
    </div>
    <div class="row">
    <div class="col-lg-4 box">
        <div class="zz"></div>
        <div id="znh_zn_pq_bar" class="znh_tu"></div>
    </div>
    <div class="col-lg-4 box">
        <div class="zz"></div>
        <div id="znh_zn_sex_pie" class="znh_tu"></div>
    </div>
    <div class="col-lg-4 box">
        <div class="zz"></div>
        <div id="znh_zn_age_bar" class="znh_tu"></div>
    </div>
</div>
</div>
<script type="text/javascript">
    var znh_tu_w,znh_tu_h,znh_tu_big_w,znh_tu_big_h;
    var znh_width=$("#organ").width();

    if(winWidth>=1900){
        znh_tu_w=znh_width/3.2;
        znh_tu_h=winHeight/4.4;
        znh_tu_big_w=znh_width/2.2;
        znh_tu_big_h=winHeight/4.4;
    }else if(winWidth<=1400 && winWidth>=1300){
        znh_tu_w=winWidth/4.5;
        znh_tu_h=winHeight/4.1;
        znh_tu_big_w=winWidth/4.5;
        znh_tu_big_h=winHeight/2.2;
    }

    $(".znh_tu_big").css('width',znh_tu_big_w/0.95);
    $(".znh_tu_big").css( 'height', znh_tu_big_h);
    $(".znh_tu").css('width',znh_tu_w);
    $(".znh_tu").css( 'height', znh_tu_h);
    var znh_zn_num_pie = echarts.init(document.getElementById('znh_zn_num_pie'));
    var znh_zn_pie = echarts.init(document.getElementById('znh_zn_pie'));
    var znh_zn_age_bar= echarts.init(document.getElementById('znh_zn_age_bar'));
    var znh_zn_pq_bar= echarts.init(document.getElementById('znh_zn_pq_bar'));
    var znh_zn_sex_pie= echarts.init(document.getElementById('znh_zn_sex_pie'));
</script>
<script>
    title.text="人数占比";
    title.link="javascript: change('child_znh','child_organ')";
//    title_text="人数占比";
    legend_data=[{name:'已使用的重点老人',textStyle:{color:legend_color,fontSize:18}},{name:'未使用的重点老人',textStyle:{color:legend_color,fontSize:18}}];
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
                {value:1360, name:'未使用的重点老人'},
                {value:234, name:'已使用的重点老人'}
            ]
        }
    ];
    var znh_option_zn_num_pie = chartPieClick(title,legend_data,series);
    znh_zn_num_pie.setOption(znh_option_zn_num_pie);

    znh_zn_num_pie.on('legendselectchanged', function (params) {
        var name = params.name;
        if(name=="未使用的重点老人"){
            zhujie = 1;
        }else if(name=="已使用的重点老人"){
            sixthTypeArray.push(5,127,128,130,131);
        }
        table.fnFilter();
        getNumOfJw();
        //getAgeAndSex();
        getNumOfJw();
        //getAgeAndSex();
    });

    title_text="各类产品服务人数";
    legend_data=[{name:'安康通',textStyle:{color:legend_color,fontSize:18}},{name:'康乐福',textStyle:{color:legend_color,fontSize:18}},{name:'智能设备3',textStyle:{color:legend_color,fontSize:18}}];
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
            {value:476, name:'安康通'},
            {value:376, name:'康乐福'},
            {value:376, name:'智能设备3'}
        ],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }];
    var znh_option_zn_pie = chartPie(title_text,legend_data,series);
    znh_zn_pie.setOption(znh_option_zn_pie);

    znh_zn_pie.on('legendselectchanged', function (params) {
        var name = params.name;
        if(name=="安康通"){
            forthTypeArray.push(17);
        }else if(name=="康乐福"){
            forthTypeArray.push(18);
        }
        table.fnFilter();
        getNumOfJw();
        //getAgeAndSex();
    });

    title_text="总服务人数性别";
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
            {value:476, name:'男'},
            {value:376, name:'女'}
        ],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }];
    var znh_option_zn_sex_pie = chartPie(title_text,legend_data,series);
    znh_zn_sex_pie.setOption(znh_option_zn_sex_pie);

    znh_zn_sex_pie.on('legendselectchanged', function (params) {
        var name = params.name;
        if(name=="男"){
            sex=2;
        }else if(name=="女"){
            sex=1;
        }
        table.fnFilter();
        getNumOfJw();
        //getAgeAndSex();
    });

    title_text='总服务人数年龄';
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
                    fontSize:18
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
                    color:series_color_2,
                    fontSize:18
                }
            },
            data: [7,34,134,234]
        }
    ];
    var znh_option_zn_age_bar=chartBar(title_text,legend_data,yAxis_data,series);
    znh_zn_age_bar.setOption(znh_option_zn_age_bar);

    znh_zn_age_bar.on('legendselectchanged', function (params) {
        var name = params.name;
        if(name=="男"){
            sex=2;
        }else if(name=="女"){
            sex=1;
        }
        table.fnFilter();
        getNumOfJw();
        //getAgeAndSex();
    });

    // //片区人数分布
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
    //                 position: 'right',
    //                 position: 'right',
    //                 textStyle:{
    //                     fontSize:20
    //                 }
    //             }
    //         },
    //         itemStyle:{
    //             normal: {
    //                 color:series_color_1,
    //                 fontSize:18
    //             }
    //         },
    //         data: [67,134,234,534,263,231]
    //     }
    // ];
    // var znh_option_zn_pq_bar=chartBar(title_text,legend_data,yAxis_data,series);
    //=> renkou =>huji
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
    var znh_option_zn_pq_bar = chartPie(title_text,legend_data,series);
    znh_zn_pq_bar.setOption(znh_option_zn_pq_bar);

    znh_zn_pq_bar.on('legendselectchanged', function (params) {
        var name = params.name;
        if(name=="户籍"){
            census.push(12);
        }else if(name=="非户籍"){
           census.push(13,14);
        }
        table.fnFilter();
        getNumOfJw();
        //getAgeAndSex();
    });


</script>