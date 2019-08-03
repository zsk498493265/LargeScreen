<style>
    @media only screen and (min-width: 6000px){
        .organOldman_tu{
            padding-top: 5%;
            padding-bottom: 2%;
        }
    }

    /*#child_organOldman p{*/
        /*padding-left: 5px !important;*/
        /*padding-top: 5px!important;*/
        /*margin: 0 !important;*/
    /*}*/

    #child_organOldman .box{
        height: 123px !important;

    }
    /*#child_organOldman p{*/
        /*position: relative!important;*/
        /*bottom: 40px!important;*/

    /*}*/
    .xx{
        position: relative!important;
        bottom:60px!important;
    }
    .xx_title{
        position: relative!important;
        bottom:50px!important;
    }
    .aa{
        position: relative!important;
        bottom:50px!important;
    }
    .bb{
        position: relative!important;
        bottom:50px!important;
    }
    .cc{
        position: relative!important;
        bottom:110px!important;
    }
    .cc_title{
        position: relative!important;
        bottom:100px!important;
    }
    .dd{
        position: relative!important;
        bottom:155px!important;
    }
    .dd_title{
        position: relative!important;
        bottom:145px!important;
    }
    /*#child_organOldman .col-lg-3{*/
        /*position: relative;*/
        /*//right: 12px;*/
    /*}*/
</style>
<div id="child_organOldman" style="display: none">
    <div class="row box" style="height: ">
        <div class="zz"></div>
        <p class="title" onclick="change('child_organOldman','child_organ')" style="font-size: 20px;padding: 5px;">辖区内养老院床位数总和</p>
        <div class="col-lg-3">
            <div id="organOldman_jg_sub_pie" style="position:relative;bottom: 10px" class="organOldman_tu"></div>
        </div>
        <div class="col-lg-3">
            <div id="organOldman_jg_sex_pie" style="position:relative;bottom: 10px" class="organOldman_tu"></div>
        </div>
        <div class="col-lg-3">
            <div id="organOldman_jg_age_bar" style="position:relative;bottom: 10px" class="organOldman_tu"></div>
        </div>
        <div class="col-lg-3">
            <div id="organOldman_jg_sub_wl" style="position:relative;bottom: 10px" class="organOldman_tu"></div>
        </div>
    </div>
    <div class="row box">
        <div class="zz"></div>
        <p class="title xx_title" style="font-size: 20px;padding: 5px">上海闵行区平阳敬老院</p>
        <div class="col-lg-3">
            <div id="organOldman_jg_1_pie" class="organOldman_tu xx"></div>
        </div>
        <div class="col-lg-3">
            <div id="organOldman_jg_1_sex" class="organOldman_tu xx"></div>
        </div>
        <div class="col-lg-3">
            <div id="organOldman_jg_1_age" class="organOldman_tu xx"></div>
        </div>
        <div class="col-lg-3">
            <div id="organOldman_jg_1_wl" class="organOldman_tu xx"></div>
        </div>
    </div>
    <div class="row box">
        <div class="zz"></div>
        <p class="title cc_title" style="font-size: 20px;padding: 5px">上海闵行区古美敬老院</p>
        <div class="col-lg-3">
            <div id="organOldman_jg_2_pie" class="organOldman_tu cc"></div>
        </div>
        <div class="col-lg-3">
            <div id="organOldman_jg_2_sex" class="organOldman_tu cc"></div>
        </div>
        <div class="col-lg-3">
            <div id="organOldman_jg_2_age" class="organOldman_tu cc"></div>
        </div>
        <div class="col-lg-3">
            <div id="organOldman_jg_2_wl" class="organOldman_tu cc"></div>
        </div>
    </div>
    <div class="row box">
        <div class="zz"></div>
        <p class="title dd_title" style="font-size: 20px;padding: 5px">上海闵行区莲花敬老院</p>
        <div class="col-lg-3">
            <div id="organOldman_jg_3_pie" class="organOldman_tu dd"></div>
        </div>
        <div class="col-lg-3">
            <div id="organOldman_jg_3_sex" class="organOldman_tu dd"></div>
        </div>
        <div class="col-lg-3">
            <div id="organOldman_jg_3_age" class="organOldman_tu dd"></div>
        </div>
        <div class="col-lg-3">
            <div id="organOldman_jg_3_wl" class="organOldman_tu dd"></div>
        </div>
    </div>
</div>
<script src="../../../static/js/echarts.js"></script>
<script type="text/javascript">
    var organOldman_tu_w,organOldman_tu_h;
    var organOldman_width=$("#organ").width();
    if(winWidth>=1900){
        organOldman_tu_w=organOldman_width/4;
        // organOldman_tu_h=winHeight/10.05;
        organOldman_tu_h=winHeight/12.6;
    }else if(winWidth<=1400 && winWidth>=1300){
        oldman_tu_w=winWidth/4.5;
        oldman_tu_h=winHeight/4.1;

    }

    $(".organOldman_tu").css('width',organOldman_tu_w);
    $(".organOldman_tu").css( 'height', organOldman_tu_h*1.5);

    var organOldman_jg_sub_pie = echarts.init(document.getElementById('organOldman_jg_sub_pie'));
    var organOldman_jg_sub_wl= echarts.init(document.getElementById('organOldman_jg_sub_wl'));
    var organOldman_jg_1_pie= echarts.init(document.getElementById('organOldman_jg_1_pie'));
    var organOldman_jg_1_wl = echarts.init(document.getElementById('organOldman_jg_1_wl'));
    var organOldman_jg_2_pie= echarts.init(document.getElementById('organOldman_jg_2_pie'));
    var organOldman_jg_2_wl = echarts.init(document.getElementById('organOldman_jg_2_wl'));
    var organOldman_jg_3_pie= echarts.init(document.getElementById('organOldman_jg_3_pie'));
    var organOldman_jg_3_wl = echarts.init(document.getElementById('organOldman_jg_3_wl'));

    var organOldman_jg_sex_pie = echarts.init(document.getElementById('organOldman_jg_sex_pie'));
    var organOldman_jg_age_bar = echarts.init(document.getElementById('organOldman_jg_age_bar'));
    var organOldman_jg_1_age = echarts.init(document.getElementById('organOldman_jg_1_age'));
    var organOldman_jg_1_sex = echarts.init(document.getElementById('organOldman_jg_1_sex'));
    var organOldman_jg_2_age = echarts.init(document.getElementById('organOldman_jg_2_age'));
    var organOldman_jg_2_sex = echarts.init(document.getElementById('organOldman_jg_2_sex'));
    var organOldman_jg_3_age = echarts.init(document.getElementById('organOldman_jg_3_age'));
    var organOldman_jg_3_sex = echarts.init(document.getElementById('organOldman_jg_3_sex'));
</script>


<script>
    // title_text="";
    // legend_data=[{name:'已入住',textStyle:{color:legend_color,fontSize:18}},{name:'剩余',textStyle:{color:legend_color,fontSize:18}}];
    // series=[{
    //     name: '老人户籍',
    //     type: 'pie',
    //     radius : '55%',
    //     center: ['48%', '50%'],
    //     label : {
    //         normal : {
    //             formatter: '{d}%\n({c})',
    //             textStyle : {
    //                 fontWeight : 'normal',
    //                 fontSize : 20
    //             }
    //         }
    //     },
    //     data:[
    //         {value:476, name:'已入住'},
    //         {value:376, name:'剩余'}
    //     ],
    //     itemStyle: {
    //         emphasis: {
    //             shadowBlur: 10,
    //             shadowOffsetX: 0,
    //             shadowColor: 'rgba(0, 0, 0, 0.5)'
    //         }
    //     }
    // }];
    // var organOldman_option_sub_pie = chartPie(title_text,legend_data,series);
    //
    // title_text="";
    // var organOldman_option_sub_wl = gauge(title_text);
    //
    // title_text="";
    // legend_data=[{name:'已入住',textStyle:{color:legend_color,fontSize:18}},{name:'剩余',textStyle:{color:legend_color,fontSize:18}}];
    // series=[{
    //     name: '老人户籍',
    //     type: 'pie',
    //     radius : '55%',
    //     center: ['48%', '50%'],
    //     label : {
    //         normal : {
    //             formatter: '{d}%\n({c})',
    //             textStyle : {
    //                 fontWeight : 'normal',
    //                 fontSize : 20
    //             }
    //         }
    //     },
    //     data:[
    //         {value:476, name:'已入住'},
    //         {value:376, name:'剩余'}
    //     ],
    //     itemStyle: {
    //         emphasis: {
    //             shadowBlur: 10,
    //             shadowOffsetX: 0,
    //             shadowColor: 'rgba(0, 0, 0, 0.5)'
    //         }
    //     }
    // }];
    // var organOldman_option_1_pie = chartPie(title_text,legend_data,series);
    //
    //
    // var organOldman_option_1_wl = gauge(title_text);
    // title_text="";
    // legend_data=[{name:'已入住',textStyle:{color:legend_color,fontSize:18}},{name:'剩余',textStyle:{color:legend_color,fontSize:18}}];
    // series=[{
    //     name: '老人户籍',
    //     type: 'pie',
    //     radius : '55%',
    //     center: ['48%', '50%'],
    //     label : {
    //         normal : {
    //             formatter: '{d}%\n({c})',
    //             textStyle : {
    //                 fontWeight : 'normal',
    //                 fontSize : 20
    //             }
    //         }
    //     },
    //     data:[
    //         {value:476, name:'已入住'},
    //         {value:376, name:'剩余'}
    //     ],
    //     itemStyle: {
    //         emphasis: {
    //             shadowBlur: 10,
    //             shadowOffsetX: 0,
    //             shadowColor: 'rgba(0, 0, 0, 0.5)'
    //         }
    //     }
    // }];
    // var organOldman_option_2_pie = chartPie(title_text,legend_data,series);
    //
    // var organOldman_option_2_wl = gauge(title_text);
    //
    // title_text="";
    // legend_data=[{name:'已入住',textStyle:{color:legend_color,fontSize:18}},{name:'剩余',textStyle:{color:legend_color,fontSize:18}}];
    // series=[{
    //     name: '老人户籍',
    //     type: 'pie',
    //     radius : '55%',
    //     center: ['48%', '50%'],
    //     label : {
    //         normal : {
    //             formatter: '{d}%\n({c})',
    //             textStyle : {
    //                 fontWeight : 'normal',
    //                 fontSize : 20
    //             }
    //         }
    //     },
    //     data:[
    //         {value:476, name:'已入住'},
    //         {value:376, name:'剩余'}
    //     ],
    //     itemStyle: {
    //         emphasis: {
    //             shadowBlur: 10,
    //             shadowOffsetX: 0,
    //             shadowColor: 'rgba(0, 0, 0, 0.5)'
    //         }
    //     }
    // }];
    // var organOldman_option_3_pie = chartPie(title_text,legend_data,series);
    //
    // var organOldman_option_3_wl = gauge(title_text);
    //
    // organOldman_jg_sub_pie.setOption(organOldman_option_sub_pie);
    // organOldman_jg_sub_wl.setOption(organOldman_option_sub_wl);
    // organOldman_jg_1_pie.setOption(organOldman_option_1_pie);
    // organOldman_jg_1_wl.setOption(organOldman_option_1_wl);
    // organOldman_jg_2_pie.setOption(organOldman_option_2_pie);
    // organOldman_jg_2_wl.setOption(organOldman_option_2_wl);
    // organOldman_jg_3_pie.setOption(organOldman_option_3_pie);
    // organOldman_jg_3_wl.setOption(organOldman_option_3_wl);
    //
    // //性别饼图
    // title_text="性别";
    // legend_data=[{name:'男',textStyle:{color:legend_color,fontSize:18}},{name:'女',textStyle:{color:legend_color,fontSize:18}}];
    // series=[{
    //     name: '老人性别',
    //     type: 'pie',
    //     radius : '55%',
    //     label : {
    //         normal : {
    //             formatter: '{d}%\n({c})',
    //             textStyle : {
    //                 fontWeight : 'normal',
    //                 fontSize : 20
    //             }
    //         }
    //     },
    //     center: ['48%', '50%'],
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
    // var organOldman_option_jg_sex_pie = chartPie(title_text,legend_data,series);
    // organOldman_jg_sex_pie.setOption(organOldman_option_jg_sex_pie);
    // //性别饼图
    // title_text="性别";
    // legend_data=[{name:'男',textStyle:{color:legend_color,fontSize:18}},{name:'女',textStyle:{color:legend_color,fontSize:18}}];
    // series=[{
    //     name: '老人性别',
    //     type: 'pie',
    //     radius : '55%',
    //     label : {
    //         normal : {
    //             formatter: '{d}%\n({c})',
    //             textStyle : {
    //                 fontWeight : 'normal',
    //                 fontSize : 20
    //             }
    //         }
    //     },
    //     center: ['48%', '50%'],
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
    // var organOldman_option_jg_1_sex = chartPie(title_text,legend_data,series);
    // organOldman_jg_1_sex.setOption(organOldman_option_jg_1_sex);
    // //性别饼图
    // title_text="性别";
    // legend_data=[{name:'男',textStyle:{color:legend_color,fontSize:18}},{name:'女',textStyle:{color:legend_color,fontSize:18}}];
    // series=[{
    //     name: '老人性别',
    //     type: 'pie',
    //     radius : '55%',
    //     label : {
    //         normal : {
    //             formatter: '{d}%\n({c})',
    //             textStyle : {
    //                 fontWeight : 'normal',
    //                 fontSize : 20
    //             }
    //         }
    //     },
    //     center: ['48%', '50%'],
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
    // var organOldman_option_jg_2_sex = chartPie(title_text,legend_data,series);
    // organOldman_jg_2_sex.setOption(organOldman_option_jg_2_sex);
    // //性别饼图
    // title_text="性别";
    // legend_data=[{name:'男',textStyle:{color:legend_color,fontSize:18}},{name:'女',textStyle:{color:legend_color,fontSize:18}}];
    // series=[{
    //     name: '老人性别',
    //     type: 'pie',
    //     radius : '55%',
    //     label : {
    //         normal : {
    //             formatter: '{d}%\n({c})',
    //             textStyle : {
    //                 fontWeight : 'normal',
    //                 fontSize : 20
    //             }
    //         }
    //     },
    //     center: ['48%', '50%'],
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
    // var organOldman_option_jg_3_sex = chartPie(title_text,legend_data,series);
    // organOldman_jg_3_sex.setOption(organOldman_option_jg_3_sex);
    //
    // title_text='年龄';
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
    //
    //             }
    //         },
    //         itemStyle:{
    //             normal: {
    //                 color:series_color_1
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
    //                 color:series_color_2
    //             }
    //         },
    //         data: [7,34,134,234]
    //     }
    // ];
    // var organOldman_option_jg_age_bar=chartBar(title_text,legend_data,yAxis_data,series);
    // organOldman_jg_age_bar.setOption(organOldman_option_jg_age_bar);
    // title_text='年龄';
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
    //                 color:series_color_1
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
    //                 color:series_color_2
    //             }
    //         },
    //         data: [7,34,134,234]
    //     }
    // ];
    // var organOldman_option_jg_1_age=chartBar(title_text,legend_data,yAxis_data,series);
    // organOldman_jg_1_age.setOption(organOldman_option_jg_1_age);
    // title_text='年龄';
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
    //                 color:series_color_1
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
    //                 color:series_color_2
    //             }
    //         },
    //         data: [7,34,134,234]
    //     }
    // ];
    // var organOldman_option_jg_2_age=chartBar(title_text,legend_data,yAxis_data,series);
    // organOldman_jg_2_age.setOption(organOldman_option_jg_2_age);
    // title_text='年龄';
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
    //                 color:series_color_1
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
    //                 color:series_color_2
    //             }
    //         },
    //         data: [7,34,134,234]
    //     }
    // ];
    // var organOldman_option_jg_3_age=chartBar(title_text,legend_data,yAxis_data,series);
    // organOldman_jg_3_age.setOption(organOldman_option_jg_3_age);

    //line1
    organOldman_jg_sub_pie.on('legendselectchanged', function (params) {
        var name=params.name;
        organOldman_jg_sub_pie.dispatchAction({
            type: 'legendSelect',
            name: name
        });

    });

    organOldman_jg_sex_pie.on('legendselectchanged', function (params) {
        var name=params.name;
        organOldman_jg_sex_pie.dispatchAction({
            type: 'legendSelect',
            name: name
        });

    });

    organOldman_jg_age_bar.on('legendselectchanged', function (params) {
        var name=params.name;
        organOldman_jg_age_bar.dispatchAction({
            type: 'legendSelect',
            name: name
        });

    });

    organOldman_jg_sub_wl.on('legendselectchanged', function (params) {
        var name=params.name;
        organOldman_jg_sub_wl.dispatchAction({
            type: 'legendSelect',
            name: name
        });

    });
    //line2
    organOldman_jg_1_pie.on('legendselectchanged', function (params) {
        var name=params.name;
        organOldman_jg_1_pie.dispatchAction({
            type: 'legendSelect',
            name: name
        });

    });
    organOldman_jg_1_sex.on('legendselectchanged', function (params) {
        var name=params.name;
        organOldman_jg_1_sex.dispatchAction({
            type: 'legendSelect',
            name: name
        });

    });
    organOldman_jg_1_age.on('legendselectchanged', function (params) {
        var name=params.name;
        organOldman_jg_1_age.dispatchAction({
            type: 'legendSelect',
            name: name
        });

    });
    organOldman_jg_1_wl.on('legendselectchanged', function (params) {
        var name=params.name;
        organOldman_jg_1_wl.dispatchAction({
            type: 'legendSelect',
            name: name
        });

    });
    //line3
    organOldman_jg_2_pie.on('legendselectchanged', function (params) {
        var name=params.name;
        organOldman_jg_2_pie.dispatchAction({
            type: 'legendSelect',
            name: name
        });

    });
    organOldman_jg_2_sex.on('legendselectchanged', function (params) {
        var name=params.name;
        organOldman_jg_2_sex.dispatchAction({
            type: 'legendSelect',
            name: name
        });

    });
    organOldman_jg_2_age.on('legendselectchanged', function (params) {
        var name=params.name;
        organOldman_jg_2_age.dispatchAction({
            type: 'legendSelect',
            name: name
        });

    });
    organOldman_jg_2_wl.on('legendselectchanged', function (params) {
        var name=params.name;
        organOldman_jg_2_wl.dispatchAction({
            type: 'legendSelect',
            name: name
        });

    });
    //line4
    organOldman_jg_3_pie.on('legendselectchanged', function (params) {
        var name=params.name;
        organOldman_jg_3_pie.dispatchAction({
            type: 'legendSelect',
            name: name
        });

    });
    organOldman_jg_3_sex.on('legendselectchanged', function (params) {
        var name=params.name;
        organOldman_jg_3_sex.dispatchAction({
            type: 'legendSelect',
            name: name
        });

    });
    organOldman_jg_3_age.on('legendselectchanged', function (params) {
        var name=params.name;
        organOldman_jg_3_age.dispatchAction({
            type: 'legendSelect',
            name: name
        });

    });
    organOldman_jg_3_wl.on('legendselectchanged', function (params) {
        var name=params.name;
        organOldman_jg_3_wl.dispatchAction({
            type: 'legendSelect',
            name: name
        });

    });

</script>