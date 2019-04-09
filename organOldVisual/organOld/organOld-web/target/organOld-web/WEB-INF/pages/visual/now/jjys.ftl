<style>
    @media only screen and (min-width: 6000px){
        .jjys_tu{
            padding-top: 5%;
            padding-bottom: 2%;
        }
    }
</style>
<div id="child_jjys" style="display: none">
    <div class="row" >
        <div class="col-lg-6 box">
            <div class="zz"></div>
            <div id="jjys_jt_ys_num_pie" class="jjys_tu"></div>
        </div>
        <div class="col-lg-6 box" >
            <div class="zz"></div>
            <div id="jjys_jt_ys_sex_pie" class="jjys_tu"></div>
        </div>
    </div>
    <div class="row" >
        <div class="col-lg-6 box">
            <div class="zz"></div>
            <div id="jjys_jt_ys_pq_bar" class="jjys_tu"></div>
        </div>
        <div class="col-lg-6 box" >
            <div class="zz"></div>
            <div id="jjys_jt_ys_age_bar" class="jjys_tu"></div>
        </div>
    </div>
</div>

<script type="text/javascript">
    var jjys_tu_w,jjys_tu_h;
    var jjys_width=$("#organ").width();
    if(winWidth>=1900){
        jjys_tu_w=jjys_width/2.2;
        jjys_tu_h=winHeight/4.4;
    }else if(winWidth<=1400 && winWidth>=1300){
        oldman_tu_w=winWidth/4.5;
        oldman_tu_h=winHeight/4.1;
    }
    $(".jjys_tu").css('width',jjys_tu_w/0.95);
    $(".jjys_tu").css( 'height',jjys_tu_h);

    var jjys_jt_ys_age_bar = echarts.init(document.getElementById('jjys_jt_ys_age_bar'));
    var jjys_jt_ys_pq_bar = echarts.init(document.getElementById('jjys_jt_ys_pq_bar'));
    var jjys_jt_ys_sex_pie = echarts.init(document.getElementById('jjys_jt_ys_sex_pie'));
    var jjys_jt_ys_num_pie = echarts.init(document.getElementById('jjys_jt_ys_num_pie'));
</script>

<script>
    title.text="人数占比容";
    title.link="javascript: change('child_jjys','child_organ')";
//    title_text="人数占比";
    legend_data=[{name:'已参加',textStyle:{color:legend_color,fontSize:18}},{name:'未参加',textStyle:{color:legend_color,fontSize:18}}];
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
                {value:1360, name:'未参加'},
                {value:234, name:'已参加'}
            ]
        }
    ];
    var jjys_option_jt_ys_num= chartPieClick(title,legend_data,series);
    jjys_jt_ys_num_pie.setOption(jjys_option_jt_ys_num);


    title_text="性别";
    legend_data=[{name:'男',textStyle:{color:legend_color,fontSize:18}},{name:'女',textStyle:{color:legend_color,fontSize:18}}];
    series=[{
        name: '老人性别',
        type: 'pie',
        radius : '45%',
        label : {
            normal : {
                formatter: '{d}%\n({c})',
                textStyle : {
                    fontWeight : 'normal',
                    fontSize : 8
                }
            }
        },
        center: ['50%', '50%'],
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
    var jjys_option_jt_ys_sex_pie = chartPie(title_text,legend_data,series);
    jjys_jt_ys_sex_pie.setOption(jjys_option_jt_ys_sex_pie);


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
    var jjys_option_jt_ys_age_bar=chartBar(title_text,legend_data,yAxis_data,series);
    jjys_jt_ys_age_bar.setOption(jjys_option_jt_ys_age_bar);


    //pq=>huji
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
    var jjys_option_jt_ys_pq_bar = chartPie(title_text,legend_data,series);
    jjys_jt_ys_pq_bar.setOption(jjys_option_jt_ys_pq_bar);


</script>