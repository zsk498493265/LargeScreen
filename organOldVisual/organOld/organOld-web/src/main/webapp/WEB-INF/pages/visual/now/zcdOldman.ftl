<style>
    @media only screen and (min-width: 6000px){
        .zcdOldman_tu{
            padding-top: 5%;
            padding-bottom: 2%;
        }
    }
    #child_zcdOldman .box{
        height: 123px !important;

    }
</style>
<div id="child_zcdOldman" style="display: none">
    <div class="row box">
        <div class="zz"></div>
        <p class="title" onclick="change('child_zcdOldman','child_organ')" style="font-size: 20px;padding: 5px;">助餐点床位数总和</p>
        <div class="col-lg-3">
            <div id="zcdOldman_jg_sub_pie" style="position:relative;bottom: 10px"class="zcdOldman_tu"></div>
        </div>
        <div class="col-lg-3">
            <div id="zcdOldman_jg_sex_pie" style="position:relative;bottom: 10px"class="zcdOldman_tu"></div>
        </div>
        <div class="col-lg-3">
            <div id="zcdOldman_jg_age_bar" style="position:relative;bottom: 10px"class="zcdOldman_tu"></div>
        </div>
        <div class="col-lg-3">
            <div id="zcdOldman_jg_sub_wl" style="position:relative;bottom: 10px"class="zcdOldman_tu"></div>
        </div>
    </div>
    <div class="row box">
        <div class="zz"></div>
        <p class="title xx_title" style="font-size: 20px;padding: 5px">平吉助餐点</p>
        <div class="col-lg-3">
            <div id="zcdOldman_jg_1_pie" class="zcdOldman_tu xx"></div>
        </div>
        <div class="col-lg-3">
            <div id="zcdOldman_jg_1_sex" class="zcdOldman_tu xx"></div>
        </div>
        <div class="col-lg-3">
            <div id="zcdOldman_jg_1_age" class="zcdOldman_tu xx"></div>
        </div>
        <div class="col-lg-3">
            <div id="zcdOldman_jg_1_wl" class="zcdOldman_tu xx"></div>
        </div>
    </div>
    <div class="row box">
        <div class="zz" ></div>
        <p class="title cc_title" style="font-size: 20px;padding: 5px">平南助餐点</p>
        <div class="col-lg-3">
            <div id="zcdOldman_jg_2_pie" class="zcdOldman_tu cc"></div>
        </div>
        <div class="col-lg-3">
            <div id="zcdOldman_jg_2_sex" class="zcdOldman_tu cc"></div>
        </div>
        <div class="col-lg-3">
            <div id="zcdOldman_jg_2_age" class="zcdOldman_tu cc"></div>
        </div>
        <div class="col-lg-3">
            <div id="zcdOldman_jg_2_wl" class="zcdOldman_tu cc"></div>
        </div>
    </div>
    <div class="row box">
        <div class="zz"></div>
        <p class="title dd_title" style="font-size: 20px;padding: 5px">古美助餐点</p>
        <div class="col-lg-3">
            <div id="zcdOldman_jg_3_pie" class="zcdOldman_tu dd"></div>
        </div>
        <div class="col-lg-3">
            <div id="zcdOldman_jg_3_sex" class="zcdOldman_tu dd"></div>
        </div>
        <div class="col-lg-3">
            <div id="zcdOldman_jg_3_age" class="zcdOldman_tu dd"></div>
        </div>
        <div class="col-lg-3">
            <div id="zcdOldman_jg_3_wl" class="zcdOldman_tu dd"></div>
        </div>
    </div>
</div>
<script type="text/javascript">
    var zcdOldman_tu_w,zcdOldman_tu_h;
    var zcdOldman_width=$("#organ").width();
    if(winWidth>=1900){
        zcdOldman_tu_w=zcdOldman_width/4;
        zcdOldman_tu_h=winHeight/12.6;
    }else if(winWidth<=1400 && winWidth>=1300){
        oldman_tu_w=winWidth/4.5;
        oldman_tu_h=winHeight/4.1;
    }

    $(".zcdOldman_tu").css('width',zcdOldman_tu_w);
    $(".zcdOldman_tu").css( 'height', zcdOldman_tu_h*1.5);

    var zcdOldman_jg_sub_pie = echarts.init(document.getElementById('zcdOldman_jg_sub_pie'));
    var zcdOldman_jg_sub_wl= echarts.init(document.getElementById('zcdOldman_jg_sub_wl'));
    var zcdOldman_jg_1_pie= echarts.init(document.getElementById('zcdOldman_jg_1_pie'));
    var zcdOldman_jg_1_wl = echarts.init(document.getElementById('zcdOldman_jg_1_wl'));
    var zcdOldman_jg_2_pie= echarts.init(document.getElementById('zcdOldman_jg_2_pie'));
    var zcdOldman_jg_2_wl = echarts.init(document.getElementById('zcdOldman_jg_2_wl'));
    var zcdOldman_jg_3_pie= echarts.init(document.getElementById('zcdOldman_jg_3_pie'));
    var zcdOldman_jg_3_wl = echarts.init(document.getElementById('zcdOldman_jg_3_wl'));

    var zcdOldman_jg_sex_pie = echarts.init(document.getElementById('zcdOldman_jg_sex_pie'));
    var zcdOldman_jg_age_bar = echarts.init(document.getElementById('zcdOldman_jg_age_bar'));
    var zcdOldman_jg_1_age = echarts.init(document.getElementById('zcdOldman_jg_1_age'));
    var zcdOldman_jg_1_sex = echarts.init(document.getElementById('zcdOldman_jg_1_sex'));
    var zcdOldman_jg_2_age = echarts.init(document.getElementById('zcdOldman_jg_2_age'));
    var zcdOldman_jg_2_sex = echarts.init(document.getElementById('zcdOldman_jg_2_sex'));
    var zcdOldman_jg_3_age = echarts.init(document.getElementById('zcdOldman_jg_3_age'));
    var zcdOldman_jg_3_sex = echarts.init(document.getElementById('zcdOldman_jg_3_sex'));
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
    // var zcdOldman_option_sub_pie = chartPie(title_text,legend_data,series);
    //
    // title_text="";
    // legend_data=[];
    // series=[
    //     {
    //         name:'未来空余',
    //         type:'pie',
    //         radius: ['50%', '65%'],
    //         avoidLabelOverlap: false,
    //         label: {
    //             normal : {
    //                 position:"center",
    //                 formatter: '{a}\n{c}',
    //                 textStyle : {
    //                     fontWeight : 'normal',
    //                     fontSize : 18,
    //                     color:"#f2f989"
    //                 }
    //             }
    //         },
    //         data:[
    //             {value:40, name:'未来空余'}
    //         ]
    //     }
    // ];
    // // var zcdOldman_option_sub_wl = chartPie(title_text,legend_data,series);
    // var zcdOldman_option_sub_wl = gauge(title_text);
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
    // var zcdOldman_option_1_pie = chartPie(title_text,legend_data,series);
    //
    // title_text="";
    // legend_data=[];
    // series=[
    //     {
    //         name:'未来空余',
    //         type:'pie',
    //         radius: ['50%', '65%'],
    //         avoidLabelOverlap: false,
    //         label: {
    //             normal : {
    //                 position:"center",
    //                 formatter: '{a}\n{c}',
    //                 textStyle : {
    //                     fontWeight : 'normal',
    //                     fontSize : 18,
    //                     color:"#f2f989"
    //                 }
    //             }
    //         },
    //         data:[
    //             {value:40, name:'未来空余'}
    //         ]
    //     }
    // ];
    // var zcdOldman_option_1_wl = gauge(title_text);
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
    // var zcdOldman_option_2_pie = chartPie(title_text,legend_data,series);
    //
    // title_text="";
    // legend_data=[];
    // series=[
    //     {
    //         name:'未来空余',
    //         type:'pie',
    //         radius: ['50%', '65%'],
    //         avoidLabelOverlap: false,
    //         label: {
    //             normal : {
    //                 position:"center",
    //                 formatter: '{a}\n{c}',
    //                 textStyle : {
    //                     fontWeight : 'normal',
    //                     fontSize : 18,
    //                     color:"#f2f989"
    //                 }
    //             }
    //         },
    //         data:[
    //             {value:40, name:'未来空余'}
    //         ]
    //     }
    // ];
    // var zcdOldman_option_2_wl = gauge(title_text);
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
    // var zcdOldman_option_3_pie = chartPie(title_text,legend_data,series);
    //
    // title_text="";
    // legend_data=[];
    // series=[
    //     {
    //         name:'未来空余',
    //         type:'pie',
    //         radius: ['50%', '65%'],
    //         avoidLabelOverlap: false,
    //         label: {
    //             normal : {
    //                 position:"center",
    //                 formatter: '{a}\n{c}',
    //                 textStyle : {
    //                     fontWeight : 'normal',
    //                     fontSize : 18,
    //                     color:"#f2f989"
    //                 }
    //             }
    //         },
    //         data:[
    //             {value:40, name:'未来空余'}
    //         ]
    //     }
    // ];
    // var zcdOldman_option_3_wl = gauge(title_text);
    //
    // zcdOldman_jg_sub_pie.setOption(zcdOldman_option_sub_pie);
    // zcdOldman_jg_sub_wl.setOption(zcdOldman_option_sub_wl);
    // zcdOldman_jg_1_pie.setOption(zcdOldman_option_1_pie);
    // zcdOldman_jg_1_wl.setOption(zcdOldman_option_1_wl);
    // zcdOldman_jg_2_pie.setOption(zcdOldman_option_2_pie);
    // zcdOldman_jg_2_wl.setOption(zcdOldman_option_2_wl);
    // zcdOldman_jg_3_pie.setOption(zcdOldman_option_3_pie);
    // zcdOldman_jg_3_wl.setOption(zcdOldman_option_3_wl);
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
    // var zcdOldman_option_jg_sex_pie = chartPie(title_text,legend_data,series);
    // zcdOldman_jg_sex_pie.setOption(zcdOldman_option_jg_sex_pie);
    // zcdOldman_jg_sex_pie.on('legendselectchanged',function (params){
    //     var name = params.name;
    //     if(name=="男"){
    //         sex=2;
    //     }else if(name=="女"){
    //         sex=1;
    //     }
    //     table.fnFilter();
    //     getNumOfJw();
    //     //getAgeAndSex();
    //
    // } );
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
    // var zcdOldman_option_jg_1_sex = chartPie(title_text,legend_data,series);
    // zcdOldman_jg_1_sex.setOption(zcdOldman_option_jg_1_sex);
    // zcdOldman_jg_1_sex.on('legendselectchanged',function (params){
    //     var name = params.name;
    //     if(name=="男"){
    //         sex=2;
    //     }else if(name=="女"){
    //         sex=1;
    //     }
    //     table.fnFilter();
    //     getNumOfJw();
    //     //getAgeAndSex();
    //
    // } );
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
    // var zcdOldman_option_jg_2_sex = chartPie(title_text,legend_data,series);
    // zcdOldman_jg_2_sex.setOption(zcdOldman_option_jg_2_sex);
    // zcdOldman_jg_2_sex.on('legendselectchanged',function (params){
    //     var name = params.name;
    //     if(name=="男"){
    //         sex=2;
    //     }else if(name=="女"){
    //         sex=1;
    //     }
    //     table.fnFilter();
    //     getNumOfJw();
    //     //getAgeAndSex();
    //
    // } );
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
    // var zcdOldman_option_jg_3_sex = chartPie(title_text,legend_data,series);
    // zcdOldman_jg_3_sex.setOption(zcdOldman_option_jg_3_sex);
    // zcdOldman_jg_3_sex.on('legendselectchanged',function (params){
    //     var name = params.name;
    //     if(name=="男"){
    //         sex=2;
    //     }else if(name=="女"){
    //         sex=1;
    //     }
    //     table.fnFilter();
    //     getNumOfJw();
    //     //getAgeAndSex();
    //
    // } );
    //
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
    // var zcdOldman_option_jg_age_bar=chartBar(title_text,legend_data,yAxis_data,series);
    // zcdOldman_jg_age_bar.setOption(zcdOldman_option_jg_age_bar);
    // zcdOldman_jg_age_bar.on('legendselectchanged',function (params){
    //     var name = params.name;
    //     if(name=="男"){
    //         sex=2;
    //     }else if(name=="女"){
    //         sex=1;
    //     }
    //     table.fnFilter();
    //     getNumOfJw();
    //     //getAgeAndSex();
    //
    // } );
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
    // var zcdOldman_option_jg_1_age=chartBar(title_text,legend_data,yAxis_data,series);
    // zcdOldman_jg_1_age.setOption(zcdOldman_option_jg_1_age);
    // zcdOldman_jg_1_age.on('legendselectchanged',function (params){
    //     var name = params.name;
    //     if(name=="男"){
    //         sex=2;
    //     }else if(name=="女"){
    //         sex=1;
    //     }
    //     table.fnFilter();
    //     getNumOfJw();
    //     //getAgeAndSex();
    //
    // } );
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
    // var zcdOldman_option_jg_2_age=chartBar(title_text,legend_data,yAxis_data,series);
    // zcdOldman_jg_2_age.setOption(zcdOldman_option_jg_2_age);
    // zcdOldman_jg_2_age.on('legendselectchanged',function (params){
    //     var name = params.name;
    //     if(name=="男"){
    //         sex=2;
    //     }else if(name=="女"){
    //         sex=1;
    //     }
    //     table.fnFilter();
    //     getNumOfJw();
    //     //getAgeAndSex();
    //
    // } );
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
    // var zcdOldman_option_jg_3_age=chartBar(title_text,legend_data,yAxis_data,series);
    // zcdOldman_jg_3_age.setOption(zcdOldman_option_jg_3_age);
    // zcdOldman_jg_3_age.on('legendselectchanged',function (params){
    //     var name = params.name;
    //     if(name=="男"){
    //         sex=2;
    //     }else if(name=="女"){
    //         sex=1;
    //     }
    //     table.fnFilter();
    //     getNumOfJw();
    //     //getAgeAndSex();
    //
    // } );
    //line1
    zcdOldman_jg_sub_pie.on('legendselectchanged', function (params) {
        var name=params.name;
        zcdOldman_jg_sub_pie.dispatchAction({
            type: 'legendSelect',
            name: name
        });

    });

    zcdOldman_jg_sex_pie.on('legendselectchanged', function (params) {
        var name=params.name;
        zcdOldman_jg_sex_pie.dispatchAction({
            type: 'legendSelect',
            name: name
        });

    });

    zcdOldman_jg_age_bar.on('legendselectchanged', function (params) {
        var name=params.name;
        zcdOldman_jg_age_bar.dispatchAction({
            type: 'legendSelect',
            name: name
        });

    });

    zcdOldman_jg_sub_wl.on('legendselectchanged', function (params) {
        var name=params.name;
        zcdOldman_jg_sub_wl.dispatchAction({
            type: 'legendSelect',
            name: name
        });

    });
    //line2
    zcdOldman_jg_1_pie.on('legendselectchanged', function (params) {
        var name=params.name;
        zcdOldman_jg_1_pie.dispatchAction({
            type: 'legendSelect',
            name: name
        });

    });
    zcdOldman_jg_1_sex.on('legendselectchanged', function (params) {
        var name=params.name;
        zcdOldman_jg_1_sex.dispatchAction({
            type: 'legendSelect',
            name: name
        });

    });
    zcdOldman_jg_1_age.on('legendselectchanged', function (params) {
        var name=params.name;
        zcdOldman_jg_1_age.dispatchAction({
            type: 'legendSelect',
            name: name
        });

    });
    zcdOldman_jg_1_wl.on('legendselectchanged', function (params) {
        var name=params.name;
        zcdOldman_jg_1_wl.dispatchAction({
            type: 'legendSelect',
            name: name
        });

    });
    //line3
    zcdOldman_jg_2_pie.on('legendselectchanged', function (params) {
        var name=params.name;
        zcdOldman_jg_2_pie.dispatchAction({
            type: 'legendSelect',
            name: name
        });

    });
    zcdOldman_jg_2_sex.on('legendselectchanged', function (params) {
        var name=params.name;
        zcdOldman_jg_2_sex.dispatchAction({
            type: 'legendSelect',
            name: name
        });

    });
    zcdOldman_jg_2_age.on('legendselectchanged', function (params) {
        var name=params.name;
        zcdOldman_jg_2_age.dispatchAction({
            type: 'legendSelect',
            name: name
        });

    });
    zcdOldman_jg_2_wl.on('legendselectchanged', function (params) {
        var name=params.name;
        zcdOldman_jg_2_wl.dispatchAction({
            type: 'legendSelect',
            name: name
        });

    });
    //line4
    zcdOldman_jg_3_pie.on('legendselectchanged', function (params) {
        var name=params.name;
        zcdOldman_jg_3_pie.dispatchAction({
            type: 'legendSelect',
            name: name
        });

    });
    zcdOldman_jg_3_sex.on('legendselectchanged', function (params) {
        var name=params.name;
        zcdOldman_jg_3_sex.dispatchAction({
            type: 'legendSelect',
            name: name
        });

    });
    zcdOldman_jg_3_age.on('legendselectchanged', function (params) {
        var name=params.name;
        zcdOldman_jg_3_age.dispatchAction({
            type: 'legendSelect',
            name: name
        });

    });
    zcdOldman_jg_3_wl.on('legendselectchanged', function (params) {
        var name=params.name;
        zcdOldman_jg_3_wl.dispatchAction({
            type: 'legendSelect',
            name: name
        });

    });

</script>