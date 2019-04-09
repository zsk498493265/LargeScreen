<!DOCTYPE html>
<html>
<head>
<#include "../head.ftl" />
    <style>
        @media only screen and (min-width: 1700px){
            .map_title{
                font-size: 28px;
                color: white;
            }

            .title{
                text-align: center;
                font-size: 20px;
                font-weight: bold;
            }
            .secTitle{
                text-align: center;
                font-size: 20px;
                font-weight: bold;
                margin-top: 10px;
            }
            .label{
                font-size: 18px;
                padding:10px!important;
                margin: 5px!important;
                line-height: 3!important;
            }
            .select{
                opacity: 0.5;
            }
            .qk{
                font-size: 18px;
                background-color:#6cbdfc ;
                padding:2px 8px;
                color: white;
                border: none;
                border-radius: 10px;
                margin-bottom: 10px;
                position: fixed;
                bottom: 5%;
                left:3%
            }
            .qk_1{
                font-size: 18px;
                padding:2px 8px;
                color: white;
                border: none;
                border-radius: 10px;
                margin: 10px;
                width: 100%;
            }
            .bl{
                display: inline-block;
                line-height: 1!important;
            }
        }

        @media only screen and (min-width: 1300px) and ( max-width: 1400px){
            .map_title{
                font-size: 28px;
                color: white;
            }

            .title{
                text-align: center;
                font-size: 12px;
                font-weight: bold;
            }
            .secTitle{
                text-align: center;
                font-size: 20px;
                font-weight: bold;
                margin-top: 10px;
            }
            .label{
                font-size: 10px;
                padding:8px!important;
                margin: 3px!important;
                line-height: 3!important;
            }
            .select{
                opacity: 0.5;
            }
            .qk{
                font-size: 11px;
                background-color:#6cbdfc ;
                padding:3px 8px;
                color: white;
                border: none;
                border-radius: 10px;
                margin-bottom: 10px;
                position: fixed;
                bottom: 5%;
                left:3%
            }
            .qk_1{
                font-size: 10px;
                padding:3px 10px;
                color: white;
                border: none;
                border-radius: 10px;
                margin: 5px;
                width: 100%;
            }
            .bl{
                display: inline-block;
                line-height: 1!important;
            }
        }

        @media only screen and (min-width: 1401px) and ( max-width: 1699px){
            .map_title{
                font-size: 28px;
                color: white;
            }

            .title{
                text-align: center;
                font-size: 12px;
                font-weight: bold;
            }
            .secTitle{
                text-align: center;
                font-size: 20px;
                font-weight: bold;
                margin-top: 10px;
            }
            .label{
                font-size: 10px;
                padding:8px!important;
                margin: 3px!important;
                line-height: 3!important;
            }
            .select{
                opacity: 0.5;
            }
            .qk{
                font-size: 11px;
                background-color:#6cbdfc ;
                padding:3px 8px;
                color: white;
                border: none;
                border-radius: 10px;
                margin-bottom: 10px;
                position: fixed;
                bottom: 5%;
                left:3%
            }
            .qk_1{
                font-size: 10px;
                padding:3px 10px;
                color: white;
                border: none;
                border-radius: 10px;
                margin: 5px;
                width: 100%;
            }
            .bl{
                display: inline-block;
                line-height: 1!important;
            }
        }


        .color_1{
            background-color:#6cbdfc!important;;
        }
        .color_2{
            background-color:#dc88a9!important;;
        }
        .color_4{
            background-color:#48e8dc!important;;
        }
        .color_5{
            background-color:yellowgreen!important;;
        }
        .color_6{
            background-color:orange!important;;
        }
        .color_7{
            background-color:rgb(139, 182, 93)!important;;
        }
        #label3{
            display: none;
            margin-top: 10%;
        }
    </style>
</head>

<body>



<div class="container-fluid">
    <div class="row" style="position: relative;left: 2%">
        <div class="col-lg-2" id="label1">
            <div class="row">
                <div class="col-lg-10">
                    <div class="row box" style="position: relative;top: 10px">
                        <div class="zz"></div>
                        <div class="row" style="border-bottom: 1px solid white;margin: 0!important;">
                            <div class="col-lg-5">
                                <p class="title" style="margin-top: 15%;">老 人 身 份</p>
                            </div>
                            <div class="col-lg-7" >
                                <div class="row">
                                    <div class="col-lg-12">
                                        <button class="qk_1 color_1" onclick="label3Show(1)">基  本  情  况</button>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <button class="qk_1 color_1" onclick="label3Show(2)">家  庭  结  构</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row" style="border-bottom: 1px solid white;margin: 0!important;">
                            <div class="col-lg-5">
                                <p class="title" style="margin-top: 20%;">老 有 所 养</p>
                            </div>
                            <div class="col-lg-7">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <button class="qk_1 color_2" onclick="label3Show(3)">机 构 养 老</button>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <button class="qk_1 color_2" onclick="label3Show(4)">社  区 养 老</button>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <button class="qk_1 color_2" onclick="label3Show(5)">经 济 条 件</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row" style="border-bottom: 1px solid white;margin: 0!important;">
                            <div class="col-lg-5">
                                <p class="title" style="margin-top: 50%;" >老 有 所 医</p>
                            </div>
                            <div class="col-lg-7">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <button class="qk_1 color_4" onclick="label3Show(6)">慢 病</button>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <button class="qk_1 color_4" onclick="label3Show(7)">长 护 险</button>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-lg-12">
                                        <button class="qk_1 color_4" onclick="label3Show(8)">失 能 情 况</button>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <button class="qk_1 color_4" onclick="label3Show(9)">智 力</button>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <button class="qk_1 color_4" onclick="label3Show(10)">视 力</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row" style="border-bottom: 1px solid white;margin: 0!important;">
                            <div class="col-lg-5">
                                <p class="title" style="margin-top: 5%;">老 有 所 为</p>
                            </div>
                            <div class="col-lg-7">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <button class="qk_1 color_5" onclick="label3Show(11)">志 愿 者</button>
                                    </div>
                                </div>

                            </div>
                        </div>
                        <div class="row" style="border-bottom: 1px solid white;margin: 0!important;">
                            <div class="col-lg-5">
                                <p class="title" style="margin-top: 5%;">老 有 所 学</p>
                            </div>
                            <div class="col-lg-7">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <button class="qk_1 color_6" onclick="label3Show(12)">学 校</button>
                                    </div>
                                </div>

                            </div>
                        </div>
                        <div class="row" style="margin: 0!important;">
                            <div class="col-lg-5">
                                <p class="title" style="margin-top: 5%;">老 有 所 乐</p>
                            </div>
                            <div class="col-lg-7">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <button class="qk_1 color_7" onclick="label3Show(13)">俱 乐 部</button>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div class="row box" style="margin-top: 5px">
                        <div class="zz"></div>
                        <div class="col-lg-12">
                            <div class="row">
                                <div class="col-lg-12">
                                    <p class="title">所选标签</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12">
                                    <div id="selectLabel"></div>
                                </div>
                            </div>
                            <div class="row" align="center">
                                <div class="col-lg-12">
                                    <button class="qk" onclick="confirm()">确定</button>
                                    <#--<button class="qk" onclick="butt(1)">清空</button>-->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-2" id="label3"  >
            <div class="row">
                <div class="col-lg-10 box">
                    <div class="zz"></div>
                    <div id="label31" class="aa" style="display: none">
                        <span class="label color_1">男</span>
                        <span class="label color_1">女</span>
                        <span class="label color_1">60-70岁</span>
                        <span class="label color_1">70-80岁</span>
                        <span class="label color_1">90岁以上</span>
                        <span class="label color_1">东兰</span>
                        <span class="label color_1">平阳</span>
                        <span class="label color_1">古美</span>
                        <span class="label color_1">平吉</span>
                        <span class="label color_1">平南</span>
                        <span class="label color_1">古龙</span>
                        <span class="label color_1">群众</span>
                        <span class="label color_1">党员</span>
                        <span class="label color_1">户籍</span>
                        <span class="label color_1">非户籍</span>
                        <span class="label color_1">人户分离</span>
                    </div>
                    <div id="label32" class="aa" style="display: none">
                        <span class="label color_1">纯老</span>
                        <span class="label color_1">独居</span>
                        <span class="label color_1">孤老</span>
                        <span class="label color_1">一老养一老</span>
                        <span class="label color_1">失独家庭</span>
                        <span class="label color_1">三支人员</span>
                        <span class="label color_1">离休干部</span>
                        <span class="label color_4">独生子女家庭</span>
                        <span class="label color_4">军属</span>
                        <span class="label color_4">烈士家庭</span>
                        <span class="label color_4">离休干部</span>
                        <span class="label color_4">侨属</span>
                    </div>
                    <div id="label33" class="aa" style="display: none">
                        <span class="label color_2">东兰养老院</span>
                        <span class="label color_2">古美养老院</span>
                        <span class="label color_2">平阳养老院</span>
                    </div>
                    <div id="label34" class="aa" style="display: none">
                        <span class="label color_2">东兰长者照护之家</span>
                        <span class="label color_2">古美长者照护之家</span>
                        <span class="label color_2">平阳长者照护之家</span>
                        <span class="label color_2">东兰日照中心</span>
                        <span class="label color_2">古美日照中心</span>
                        <span class="label color_2">平阳日照中心</span>
                        <span class="label color_2">东兰助餐点</span>
                        <span class="label color_2">古美助餐点</span>
                        <span class="label color_2">平阳助餐点</span>
                    </div>
                    <div id="label35" class="aa" style="display: none">
                        <span class="label color_2">帮困人员</span>
                        <span class="label color_2">低保</span>
                        <span class="label color_2">城乡居民养老保险</span>
                        <span class="label color_2">医疗救助金</span>
                        <span class="label color_2">城镇居民基本医疗保险</span>
                    </div>
                    <div id="label36" class="aa" style="display: none">
                        <span class="label color_2">有慢病</span>
                        <span class="label color_2">有失能情况</span>
                        <span class="label color_2">有药物反应</span>
                        <span class="label color_2">有恶性肿瘤史</span>
                        <span class="label color_2">有骨折史</span>
                        <span class="label color_2">有残疾史</span>
                    </div>
                    <div id="label37" class="aa" style="display: none">
                        <span class="label color_4">2-3级</span>
                        <span class="label color_4">4级</span>
                        <span class="label color_4">5级</span>
                        <span class="label color_4">6级</span>
                        <span class="label color_4">7级</span>
                    </div>
                    <div id="label38" class="aa" style="display: none">
                        <span class="label color_5">助餐</span>
                        <span class="label color_5">助洁</span>
                        <span class="label color_5">助急</span>
                        <span class="label color_5">助浴</span>
                        <span class="label color_5">助行</span>
                        <span class="label color_5">康复辅助</span>
                        <span class="label color_5">助医</span>
                        <span class="label color_5">相谈</span>
                        <span class="label color_5">洗涤</span>
                        <span class="label color_5">生活护理</span>
                    </div>
                    <div id="label39" class="aa" style="display: none">
                        <span class="label color_4">痴呆</span>
                        <span class="label color_4">智障</span>
                        <span class="label color_4">正常</span>
                    </div>
                    <div id="label310" class="aa" style="display: none">
                        <span class="label color_4">失明</span>
                        <span class="label color_4">有光感</span>
                        <span class="label color_4">有障碍</span>
                        <span class="label color_4">正常</span>
                    </div>
                    <div id="label311" class="aa" style="display: none">
                        <span class="label color_5">志愿者</span>
                    </div>
                    <div id="label312" class="aa" style="display: none">
                        <span class="label color_6">老年大学</span>
                        <span class="label color_6">老年培训中心</span>
                    </div>
                    <div id="label313" class="aa" style="display: none">
                        <span class="label color_7">老年俱乐部</span>
                        <span class="label color_7">老年艺术中心</span>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-2"style="position: relative;top: 10px">
            <div class="row">
                <div class="col-lg-12 box" align="center">
                    <div class="zz"></div>
                    <div id="ageBar" class="tu"></div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12 box" align="center" >
                    <div class="zz"></div>
                    <div id="sexPie" class="tu"></div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12 box" align="center">
                    <div class="zz"></div>
                    <div id="hjPie" class="tu"></div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12 box" align="center">
                    <div class="zz"></div>
                    <div id="pqBar" class="tu"></div>
                </div>
            </div>
        </div>
        <div class="col-lg-7" style="position: relative;left: 5px">
            <div class="row" align="center">
                <div class="col-lg-12">
                    <#include "map-label.ftl"/>
                </div>
            </div>

            <div class="row">
            <#--<#include "table.ftl"/>-->
            </div>
        </div>
    </div>
    <script type="text/javascript">
        var tu_w,tu_h;
        if(winWidth>=1700){
            //家里电脑的分辨率
            tu_w=winWidth/8.2;
            tu_h=winHeight/4.2;
        }else if(winWidth<=1400 && winWidth>=1300){
            tu_w=winWidth/8.2;
            tu_h=winHeight/4.2;
        }else if(winWidth>1400 && winWidth<1700){
            tu_w=winWidth/8.2;
            tu_h=winHeight/4.2;
        }
        $(".tu").css('width',tu_w);
        $(".tu").css( 'height', tu_h);

        var ageBar = echarts.init(document.getElementById('ageBar'));
        var sexPie= echarts.init(document.getElementById('sexPie'));
        var pqBar= echarts.init(document.getElementById('pqBar'));
        var hjPie= echarts.init(document.getElementById('hjPie'));
    </script>
</div>

</body>
<script>
    var dataR;
    var jwData;
    var heatPoints=[];
    var la=[];
    var sex = 0;
    var census=new Array();
    var ageEnd,ageStart;
    var family=new Array(),economic=new Array();
    var health=new Array();
    var oldStatus=new Array();
    var familyType=new Array();
    var jw = [1,2,3,13,45,58,59,60,63,66,67,84,85,87,88,89,90,93,97,98,99,100,101,102,103,104,105,106,107,108,113,119,120,121,122,123,124,125,126,134,135];
    var politicalStatusArray = new Array();
    var organIdArray = new Array();
    var secTypeArray = new Array();
    var la=new Array();
    $.ajax({
        url: "/visual/data/getVisualDataApartLabel",
        type: "get",
        success: function (result) {
            if (result.success == true) {

                dataR = result.data;
                //    年龄分布柱状图
                title_text = '年龄';
                legend_data = [
                    {
                        name: '男',
                        textStyle: {
                            color: '#fff'
                        }
                    },
                    {
                        name: '女',
                        textStyle: {
                            color: '#fff'
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
                                position: 'insideLeft'
                            }
                        },
                        itemStyle: {
                            normal: {
                                color: series_color_1
                            }
                        },
                        data: [dataR.Num90AboveM, dataR.Num80To90M, dataR.Num70To80M, dataR.Num60To70M]
                    },
                    {
                        name: '女',
                        type: 'bar',
                        stack: '总量',
                        label: {
                            normal: {
                                show: true,
                                position: 'insideRight'
                            }
                        },
                        itemStyle: {
                            normal: {
                                color: series_color_2
                            }
                        },
                        data: [dataR.Num90AboveF, dataR.Num80To90F, dataR.Num70To80F, dataR.Num60To70F]
                    }
                ];
                var option_age_bar = chartBar(title_text, legend_data, yAxis_data, series);
                //性别饼图
                title_text = "性别";
                legend_data = [{name: '男', textStyle: {color: legend_color}}, {
                    name: '女',
                    textStyle: {color: legend_color}
                }];
                series = [{
                    name: '老人性别',
                    type: 'pie',
                    radius: '40%',
                    center: ['50%', '60%'],
                    label: {
                        normal: {
                            formatter: '{d}%\n({c})',
                            textStyle: {
                                fontWeight: 'normal',
                                fontSize: 8
                            }
                        }
                    },
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
                //片区人数分布
                legend_data = "";
                title_text = '片区人口';
                yAxis_data = ['东兰', '古龙', '平南', '平阳', '平吉', '古美'];
                series = [
                    {
                        name: '',
                        type: 'bar',
                        stack: '总量',
                        label: {
                            normal: {
                                show: true,
                                position: 'right',
                                textStyle: {
                                    fontSize: 8
                                }
                            }
                        },
                        itemStyle: {
                            normal: {
                                color: series_color_1
                            }
                        },
                        data: [dataR.NumDongLan, dataR.NumGuLong, dataR.NumPingNan, dataR.NumPingYang, dataR.NumPingJi, dataR.NumGuMei]
                    }
                ];
                var option_pq_bar = chartBar(title_text, legend_data, yAxis_data, series);
                title_text = "户籍";
                legend_data = [{name: '户籍', textStyle: {color: legend_color}}, {
                    name: '非户籍',
                    textStyle: {color: legend_color}
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
                                fontSize: 8
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
                var option_hj_pie = chartPie(title_text, legend_data, series);
                ageBar.setOption(option_age_bar);
                ageBar.on('legendselectchanged', function (params) {
                    var name = params.name;
                    if(name=="男"){
                        sex=2;

                    }else if(name=="女"){
                        sex=1;

                    }
                    getJwData();
                   // heatmapOverlay.setDataSet({data:heatPoints,max:200});
                });
                sexPie.setOption(option_sex_pie);
                sexPie.on('legendselectchanged', function (params) {
                    var name = params.name;
                    if(name=="男"){
                        sex=2;

                    }else if(name=="女"){
                        sex=1;

                    }
                    getJwData();
                    //heatmapOverlay.setDataSet({data:heatPoints,max:200});

                });
                pqBar.setOption(option_pq_bar);
                pqBar.on('legendselectchanged',function (params) {
                    var name = params.name;
                    if(name == "古龙")
                        mapDistrict.push(2);
                    else if(name == "东兰")
                        mapDistrict.push(3);
                    else if(name == "古美")
                        mapDistrict.push(1);
                    else if(name == "平南")
                        mapDistrict.push(6);
                    else if(name == "平阳")
                        mapDistrict.push(5);
                    else if(name == "平吉")
                        mapDistrict.push(4);
                });
                hjPie.setOption(option_hj_pie);
                hjPie.on('legendselectchanged',function(params){
                    var name=params.name;
                    if(name=="户籍"){
                        census.push(12);
                        //district.push(district_no);

                    }else if(name=="非户籍"){
                        census.push(13);
                        // district.push(district_no);

                    }
                    getJwData();
                   // heatmapOverlay.setDataSet({data:heatPoints,max:200});

                });
            }
        }
    });
</script>

<script>
    function confirm(){
        for (var index = 0; index < la.length; index++) {
            if (la[index] == "男")
                sex = 2;
            else if (la[index] == "女")
                sex = 1;
            else if (la[index] == "60-70岁") {
                ageStart = 60;
                ageEnd = 70;
            } else if (la[index] == "70-80岁") {
                ageStart = 70;
                ageEnd = 80;
            } else if (la[index] == "90岁以上") {
                ageStart = 90;
                ageEnd = 200;
            } else if (la[index] == "东兰")
            {
                mapDistrict.push(3);
            }

            else if (la[index] == "平阳")
                mapDistrict.push(5);
            else if (la[index] == "古美")
                mapDistrict.push(1);
            else if (la[index] == "平吉")
                mapDistrict.push(4);
            else if (la[index] == "平南")
                mapDistrict.push(6);
            else if (la[index] == "古龙")
                mapDistrict.push(2);
            else if (la[index] == "户籍")
                census.push(12);
            else if (la[index] == "非户籍")
                census.push(13);
            else if (la[index] == "人户分离")
                census.push(14);
            else if (la[index] == "群众")
                politicalStatusArray.push(10);
            else if (la[index] == "党员")
                politicalStatusArray.push(11);
            else if (la[index] == "正常")
                intelligenceArray.push(28);
            else if (la[index] == "痴呆")
                intelligenceArray.push(29);
            else if (la[index] == "智障")
                intelligenceArray.push(30);
            else if (la[index] == "正常")
                eyesightArray.push(31);
            else if (la[index] == "失明")
                eyesightArray.push(32);
            else if (la[index] == "有光感")
                eyesightArray.push(33);
            else if (la[index] == "有障碍")
            {   eyesightArray.push(34);
                eyesightArray.push(35);
            }
            else if (la[index] == "有慢病"){
                health.push(1);
                isMb = 1;
            }
            else if (la[index] == "有失能情况"){
                health.push(2);
                isSn = 1;
            }
            else if (la[index] == "有药物反应"){
                health.push(3);
                isYwfy = 1;
            }
            else if (la[index] == "有恶性肿瘤史"){
                health.push(4);
                isExzl = 1;
            }
            else if (la[index] == "有骨折史"){
                health.push(5);
                isGz = 1;
            }
            else if (la[index] == "有残疾史"){
                health.push(6);
                isCj = 1;
            }
            else if (la[index] == "帮困人员")
                economic.push(22);
            else if (la[index] == "低保")
                economic.push(23);
            else if (la[index] == "城乡居民养老保障")
                economic.push(24);
            else if (la[index] == "医疗救助金")
                economic.push(25);
            else if (la[index] == "城镇居民基本医疗保险")
                economic.push(26);
            else if (la[index] == "其他")
                economic.push(27);
            else if (la[index] == "纯老")
                family.push(15);
            else if (la[index] == "独居")
                family.push(16);
            else if (la[index] == "孤老")
                family.push(19);
            else if (la[index] == "一老养一老")
                family.push(17);
            else if (la[index] == "失独家庭")
                family.push(18);
            else if (la[index] == "三支人员")
                family.push(20);
            else if (la[index] == "独生子女家庭")
                familyType.push(21);
            else if (la[index] == "军属")
                familyType.push(74);
            else if (la[index] == "烈士家属")
                familyType.push(75);
            else if (la[index] == "离休干部")
                familyType.push(76);
            else if (la[index] == "侨属")
                familyType.push(77);
            else if (la[index] == "东兰养老院")
                organIdArray.push(79);
            else if (la[index] == "平阳养老院")
                organIdArray.push(114);
            else if (la[index] == "古美养老院")
                organIdArray.push(115);
            else if (la[index] == "东兰长者照护之家")
                organIdArray.push(5);
            else if (la[index] == "平阳长者照护之家")
                organIdArray.push(146);
            else if (la[index] == "东兰助餐点")
                organIdArray.push(95);
            else if (la[index] == "古美助餐点")
                organIdArray.push(117);
            else if (la[index] == "2-3级"){
                secTypeArray.push(1);
                secTypeArray.push(2);
            }
            else if (la[index] == "4级")
                secTypeArray.push(3);
            else if (la[index] == "5级")
                secTypeArray.push(4);
            else if (la[index] == "6级")
                secTypeArray.push(5);
            else if (la[index] == "7级")
                secTypeArray.push(6);
            else if (la[index] == "助餐")
            {
                zhucan = 7;
                secTypeArray.push(7);
            }
            else if (la[index] == "助洁"){
                zhujie = 8;
                secTypeArray.push(8);
            }
            else if (la[index] == "助急"){
                zhuji = 9;
                secTypeArray.push(9);
            }
            else if (la[index] == "助浴"){
                zhuyu = 10;
                secTypeArray.push(10);
            }
            else if (la[index] == "助行"){
                zhuxing = 11;
                secTypeArray.push(11);
            }
            else if (la[index] == "康复辅助"){
                kangfu = 13;
                secTypeArray.push(13);
            }
            else if (la[index] == "助医"){
                zhuyi = 12;
                secTypeArray.push(12);
            }
            else if (la[index] == "相谈"){
                xiangtan = 14;
                secTypeArray.push(14);
            }
            else if (la[index] == "洗涤"){
                xidi = 15;
                secTypeArray.push(15);
            }
            else if (la[index] == "生活护理"){
                shenghuo = 16;
                secTypeArray.push(16);
            }



        }




       // getNumOfJw();
       getAgeAndSex();
       getJwData();
        sex = 0;
        isMb = 0;
        isSn = 0;
        isYwfy = 0;
        isExzl = 0;
        isGz = 0;
        isCj = 0;
        census = [];
        ageStart = 0;
        ageEnd = 0;
        family = [];
        economic = [];
        health = [];
        oldStatus = [];
        intelligenceArray = [];
        eyesightArray = [];
        familyType = [];
        politicalStatusArray = [];
        organIdArray = [];
        secTypeArray = [];
        mapDistrict = [];
        // ageBar = echarts.init(document.getElementById('ageBar'));
        // sexPie= echarts.init(document.getElementById('sexPie'));
        // pqBar= echarts.init(document.getElementById('pqBar'));
        // hjPie= echarts.init(document.getElementById('hjPie'));
        // ageBar.setOption(option_age_bar);
        // sexPie.setOption(option_sex_pie);
        // pqBar.setOption(option_pq_bar);
        // hjPie.setOption(option_hj_pie);
    }


    function label3Show(index) {
        $("#label1").hide();
        $(".aa").css("display","none");
        $("#label3").show();
        $("#label3"+index).show();
    }

    function butter(flag) {
        sex = 0;
        census = [];
        ageStart = 0;
        ageEnd = 0;
        family = [];
        economic = [];
        health = [];
        oldStatus = [];
        politicalStatusArray = [];
        organIdArray = [];
        secTypeArray = [];
        mapDistrict = [];
        getJwData();


        // for( var index = 0; index < la.length; index ++) {
        //alert(la.length);
        $('.select').each(function() {
            var cl=$(this).attr('class').split(' ')[1];
            $(this).attr('class','label '+cl);
        });
        $('#selectLabel').html('');

        // ageBar = echarts.init(document.getElementById('ageBar'));
        // sexPie= echarts.init(document.getElementById('sexPie'));
        // pqBar= echarts.init(document.getElementById('pqBar'));
        // hjPie= echarts.init(document.getElementById('hjPie'));
        // ageBar.setOption(option_age_bar);
        // sexPie.setOption(option_sex_pie);
        // pqBar.setOption(option_pq_bar);
        // hjPie.setOption(option_hj_pie);
    }
    function getNumOfJw(){
        var jw1 = [1,2,3,13,45,59,60,113];
        var jw2 = [63,66,67,84,85,87,88,89];
        var jw3 = [90,93,97,98,99,100,101,102];
        var jw4 = [103,104,105,106,107,108,119,120];
        var jw5 = [121,122,123,124,125,126,134,135];
        ajax5 = $.ajax({
            url: "/map/jwNumTest",//这个就是请求地址对应sAjaxSource
            data : {
                "iDisplayStart" : 0,
                "iDisplayLength" : 100,
                "iSortCol_0" : 0,
                "sEcho" : 0,
                "sSortDir_0" : 0,
                "sex": sex,
                "isMb":isMb,
                "isSn":isSn,
                "isYwfy":isYwfy,
                "isExzl":isExzl,
                "isGz":isGz,
                "isCj":isCj,
                "zhucan":zhucan,
                "zhuji":zhuji,
                "zhujie" :zhujie,
                "zhuyu" : zhuyu,
                "zhuxing"  :zhuxing,
                "zhuyi"  :zhuyi,
                "kangfu"  :kangfu,
                "xiangtan" : xiangtan ,
                "xidi" : xidi,
                "shenghuo": shenghuo,
                "intelligence_array":intelligenceArray,
                "eyesight_array":eyesightArray,
                "familyType_array":familyType,
                "politicalStatus_array":politicalStatusArray,
                "organId_array":organIdArray,
                "secType_array":secTypeArray,
                "census_array":census,
                "ageStart":ageStart,
                "ageEnd":ageEnd,
                "family_array":family,
                "economic_array":economic,
                "isHealth_array":health,
                "oldStatus_array":oldStatus,
                "district_array":mapDistrict,
                "jw_array":jw1

            },
            type: 'GET',
            dataType: 'json',
            // async:false,
            success: function (result) {
                if(result.success == true){
                    jwData = result.data;
                    var heatPoints1=[
                        {"lng":"121.389133","lat":"31.158804","count":jwData.东兰一居},
                        {"lng":"121.410277","lat":"31.151814","count":jwData.古龙一居},
                        {"lng":"121.409142","lat":"31.148518","count":jwData.古美一村},
                        {"lng":"121.411089","lat":"31.152975","count":jwData.古龙二居},
                        {"lng":"121.406289","lat":"31.155351","count":jwData.古龙三居},
                        {"lng":"121.387235","lat":"31.157819","count":jwData.东兰三居},
                        {"lng":"121.388044","lat":"31.161102","count":jwData.东兰四居},
                        {"lng":"121.392393","lat":"31.145568","count":jwData.平吉三村}
                    ];
                    heatPoints = heatPoints.concat(heatPoints1);
                    heatmapOverlay.setDataSet({data:heatPoints,max:200});
                }
            }
        });
        ajax6 = $.ajax({
            url: "/map/jwNum",//这个就是请求地址对应sAjaxSource
            data : {
                "iDisplayStart" : 0,
                "iDisplayLength" : 100,
                "iSortCol_0" : 0,
                "sEcho" : 0,
                "sSortDir_0" : 0,
                "sex": sex,
                "intelligence_array":intelligenceArray,
                "eyesight_array":eyesightArray,
                "familyType_array":familyType,
                "politicalStatus_array":politicalStatusArray,
                "organId_array":organIdArray,
                "secType_array":secTypeArray,
                "census_array":census,
                "ageStart":ageStart,
                "ageEnd":ageEnd,
                "family_array":family,
                "economic_array":economic,
                "isHealth_array":health,
                "oldStatus_array":oldStatus,
                "district_array":mapDistrict,
                "jw_array":jw2

            },
            type: 'GET',
            dataType: 'json',
            // async:false,
            success: function (result) {
                if(result.success == true){
                    jwData = result.data;
                    var  heatPoints2=[
                        {"lng":"121.411512","lat":"31.159194","count":jwData.古龙六居},
                        {"lng":"121.411598","lat":"31.146782","count":jwData.古美九村},
                        {"lng":"121.41470","lat":"31.151291","count":jwData.古美七村},
                        {"lng":"121.410200","lat":"31.162142","count":jwData.华梅花苑},
                        {"lng":"121.407256","lat":"31.166000","count":jwData.梅莲苑},
                        {"lng":"121.396912","lat":"31.143988","count":jwData.平阳二村},
                        {"lng":"121.39388","lat":"31.139939","count":jwData.平阳三村},
                        {"lng":"121.404052","lat":"31.151059","count":jwData.万源四居}
                    ];
                    heatPoints=heatPoints.concat(heatPoints2);
                    heatmapOverlay.setDataSet({data:heatPoints,max:200});
                    // heatmapOverlay1.show();
                }
            }
        });
        ajax7 = $.ajax({
            url: "/map/jwNum",//这个就是请求地址对应sAjaxSource
            data : {
                "iDisplayStart" : 0,
                "iDisplayLength" : 100,
                "iSortCol_0" : 0,
                "sEcho" : 0,
                "sSortDir_0" : 0,
                "sex": sex,
                "intelligence_array":intelligenceArray,
                "eyesight_array":eyesightArray,
                "familyType_array":familyType,
                "politicalStatus_array":politicalStatusArray,
                "organId_array":organIdArray,
                "secType_array":secTypeArray,
                "census_array":census,
                "ageStart":ageStart,
                "ageEnd":ageEnd,
                "family_array":family,
                "economic_array":economic,
                "isHealth_array":health,
                "oldStatus_array":oldStatus,
                "district_array":mapDistrict,
                "jw_array":jw3

            },
            type: 'GET',
            dataType: 'json',
            //async:false,
            success: function (result) {
                if(result.success == true){
                    jwData = result.data;
                    var  heatPoints3=[
                        {"lng":"121.399151","lat":"31.153805","count":jwData.万源一居},
                        {"lng":"121.393436","lat":"31.157818","count":jwData.东兰二居},
                        {"lng":"121.391183","lat":"31.153482","count":jwData.平吉四村},
                        {"lng":"121.412186","lat":"31.155164","count":jwData.古龙四居},
                        {"lng":"121.409878","lat":"31.145572","count":jwData.古美八村},
                        {"lng":"121.410402","lat":"31.148453","count":jwData.古美四村},
                        {"lng":"121.397204","lat":"31.159934","count":jwData.平南三居},
                        {"lng":"121.400571","lat":"31.160467","count":jwData.平南一居}
                    ];
                    heatPoints =  heatPoints.concat(heatPoints3);
                    heatmapOverlay.setDataSet({data:heatPoints,max:200});
                    //  heatmapOverlay2.show();
                }
            }
        });
        ajax8 = $.ajax({
            url: "/map/jwNum",//这个就是请求地址对应sAjaxSource
            data : {
                "iDisplayStart" : 0,
                "iDisplayLength" : 100,
                "iSortCol_0" : 0,
                "sEcho" : 0,
                "sSortDir_0" : 0,
                "sex": sex,
                "intelligence_array":intelligenceArray,
                "eyesight_array":eyesightArray,
                "familyType_array":familyType,
                "politicalStatus_array":politicalStatusArray,
                "organId_array":organIdArray,
                "secType_array":secTypeArray,
                "census_array":census,
                "ageStart":ageStart,
                "ageEnd":ageEnd,
                "family_array":family,
                "economic_array":economic,
                "isHealth_array":health,
                "oldStatus_array":oldStatus,
                "district_array":mapDistrict,
                "jw_array":jw4

            },
            type: 'GET',
            dataType: 'json',
            //async:false,
            success: function (result) {
                if(result.success == true){
                    jwData = result.data;
                    var  heatPoints4=[
                        {"lng":"121.397188","lat":"31.136772","count":jwData.平阳六村},
                        {"lng":"121.396699","lat":"31.138846","count":jwData.平阳四村},
                        {"lng":"121.389500","lat":"31.141276","count":jwData.平阳一村},
                        {"lng":"121.403865","lat":"31.152716","count":jwData.万源三居},
                        {"lng":"121.405819","lat":"31.155885","count":jwData.古龙五村},
                        {"lng":"121.395925","lat":"31.148518","count":jwData.平吉六村},
                        {"lng":"121.405043","lat":"31.162622","count":jwData.华一新城},
                        {"lng":"121.388900","lat":"31.14893","count":jwData.平吉二村}
                    ];
                    heatPoints = heatPoints.concat(heatPoints4);
                    heatmapOverlay.setDataSet({data:heatPoints,max:200});
                    //  heatmapOverlay3.show();

                }
            }
        });
        ajax9 = $.ajax({
            url: "/map/jwNum",//这个就是请求地址对应sAjaxSource
            data : {
                "iDisplayStart" : 0,
                "iDisplayLength" : 100,
                "iSortCol_0" : 0,
                "sEcho" : 0,
                "sSortDir_0" : 0,
                "sex": sex,
                "intelligence_array":intelligenceArray,
                "eyesight_array":eyesightArray,
                "familyType_array":familyType,
                "politicalStatus_array":politicalStatusArray,
                "organId_array":organIdArray,
                "secType_array":secTypeArray,
                "census_array":census,
                "ageStart":ageStart,
                "ageEnd":ageEnd,
                "family_array":family,
                "economic_array":economic,
                "isHealth_array":health,
                "oldStatus_array":oldStatus,
                "district_array":mapDistrict,
                "jw_array":jw5

            },
            type: 'GET',
            dataType: 'json',
            //async:false,
            success: function (result) {
                if(result.success == true){
                    jwData = result.data;
                    var  heatPoints5=[
                        {"lng":"121.3945","lat":"31.151394","count":jwData.平吉五村},
                        {"lng":"121.408875","lat":"31.147336","count":jwData.古美三村},
                        {"lng":"121.414226","lat":"31.1478032","count":jwData.古美十村},
                        {"lng":"121.397218","lat":"31.158308","count":jwData.平南二居},
                        {"lng":"121.393407","lat":"31.13485","count":jwData.平阳五村},
                        {"lng":"121.388900","lat":"31.151069","count":jwData.平吉一村},
                        {"lng":"121.401069","lat":"31.155103","count":jwData.万源二居}
                    ];
                    heatPoints = heatPoints.concat(heatPoints5);
                    heatmapOverlay.setDataSet({data:heatPoints,max:200});
                }
            }
        });
        heatPoints = [];

    }
    function getAgeAndSex() {
      ajxa1 =  $.ajax({
            url: "/map/getSexAndAge",
            type: "get",
            data: {
                "iDisplayStart": 0,
                "iDisplayLength": 100,
                "iSortCol_0": 0,
                "sEcho": 0,
                "sSortDir_0": 0,
                "sex": sex,
                "intelligence_array":intelligenceArray,
                "eyesight_array":eyesightArray,
                "familyType_array":familyType,
                "politicalStatus_array": politicalStatusArray,
                "organId_array": organIdArray,
                "secType_array": secTypeArray,
                "census_array": census,
                "ageStart": ageStart,
                "ageEnd": ageEnd,
                "family_array": family,
                "economic_array": economic,
                "isHealth_array": health,
                "oldStatus_array": oldStatus,
                "district_array": mapDistrict
            },
            dataType: 'json',
            success: function (result) {
                if (result.success == true) {

                    dataR = result.data;
                    //    年龄分布柱状图
                    title_text = '年龄';
                    legend_data = [
                        {
                            name: '男',
                            textStyle: {
                                color: '#fff'
                            }
                        },
                        {
                            name: '女',
                            textStyle: {
                                color: '#fff'
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
                                    position: 'insideLeft'
                                }
                            },
                            itemStyle: {
                                normal: {
                                    color: series_color_1
                                }
                            },
                            data: [dataR.numOfOverNineM, dataR.numOfEightToNineM, dataR.numOfSevenToEightM, dataR.numOfSixToSevenM]
                        },
                        {
                            name: '女',
                            type: 'bar',
                            stack: '总量',
                            label: {
                                normal: {
                                    show: true,
                                    position: 'insideRight'
                                }
                            },
                            itemStyle: {
                                normal: {
                                    color: series_color_2
                                }
                            },
                            data: [dataR.numOfOverNineF, dataR.numOfEightToNineF, dataR.numOfSevenToEightF, dataR.numOfSixToSevenF]
                        }
                    ];
                    var option_age_bar = chartBar(title_text, legend_data, yAxis_data, series);
                    ageBar.setOption(option_age_bar);
                }
            }


        });
       ajax2 = $.ajax({
            url: "/chartchange/sexes",
            type: "get",
            data: {
                "iDisplayStart": 0,
                "iDisplayLength": 100,
                "iSortCol_0": 0,
                "sEcho": 0,
                "sSortDir_0": 0,
                "sex": sex,
                "intelligence_array":intelligenceArray,
                "eyesight_array":eyesightArray,
                "familyType_array":familyType,
                "politicalStatus_array": politicalStatusArray,
                "organId_array": organIdArray,
                "secType_array": secTypeArray,
                "census_array": census,
                "ageStart": ageStart,
                "ageEnd": ageEnd,
                "family_array": family,
                "economic_array": economic,
                "isHealth_array": health,
                "oldStatus_array": oldStatus,
                "district_array": mapDistrict
            },
            dataType: 'json',
            success: function (result) {
                if (result.success == true) {
                    dataR = result.data;
                    title_text = "性别";
                    legend_data = [{name: '男', textStyle: {color: legend_color}}, {
                        name: '女',
                        textStyle: {color: legend_color}
                    }];
                    series = [{
                        name: '老人性别',
                        type: 'pie',
                        radius: '40%',
                        center: ['50%', '60%'],
                        label: {
                            normal: {
                                formatter: '{d}%\n({c})',
                                textStyle: {
                                    fontWeight: 'normal',
                                    fontSize: 8
                                }
                            }
                        },
                        data: [
                            {value: dataR.numOfMale, name: '男'},
                            {value: dataR.numOfFemale, name: '女'}
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
                    sexPie.setOption(option_sex_pie);
                }
            }
        });
      ajax3 =  $.ajax({
            url: "/chartchange/census",
            type: "get",
            data: {
                "iDisplayStart": 0,
                "iDisplayLength": 100,
                "iSortCol_0": 0,
                "sEcho": 0,
                "sSortDir_0": 0,
                "sex": sex,
                "intelligence_array":intelligenceArray,
                "eyesight_array":eyesightArray,
                "familyType_array":familyType,
                "politicalStatus_array": politicalStatusArray,
                "organId_array": organIdArray,
                "secType_array": secTypeArray,
                "census_array": census,
                "ageStart": ageStart,
                "ageEnd": ageEnd,
                "family_array": family,
                "economic_array": economic,
                "isHealth_array": health,
                "oldStatus_array": oldStatus,
                "district_array": mapDistrict
            },
            dataType: 'json',
            success: function (result) {
                if (result.success == true) {
                    dataR = result.data;
                    title_text = "户籍";
                    legend_data = [{name: '户籍', textStyle: {color: legend_color}}, {
                        name: '非户籍',
                        textStyle: {color: legend_color}
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
                                    fontSize: 8
                                }
                            }
                        },
                        data: [
                            {value: dataR.numOfCensus, name: '户籍'},
                            {value: dataR.numOfNotCensus, name: '非户籍'}
                        ],
                        itemStyle: {
                            emphasis: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        }
                    }];
                    var option_hj_pie = chartPie(title_text, legend_data, series);
                    hjPie.setOption(option_hj_pie);
                }
            }
        });
       ajax4 = $.ajax({
            url: "/chartchange/district",
            type: "get",
            data: {
                "iDisplayStart": 0,
                "iDisplayLength": 100,
                "iSortCol_0": 0,
                "sEcho": 0,
                "sSortDir_0": 0,
                "sex": sex,
                "intelligence_array":intelligenceArray,
                "eyesight_array":eyesightArray,
                "familyType_array":familyType,
                "politicalStatus_array": politicalStatusArray,
                "organId_array": organIdArray,
                "secType_array": secTypeArray,
                "census_array": census,
                "ageStart": ageStart,
                "ageEnd": ageEnd,
                "family_array": family,
                "economic_array": economic,
                "isHealth_array": health,
                "oldStatus_array": oldStatus,
                "district_array": mapDistrict
            },
            dataType: 'json',
            success: function (result) {
                if (result.success == true) {
                    dataR = result.data;
                    legend_data = "";
                    title_text = '片区人口';
                    yAxis_data = ['东兰', '古龙', '平南', '平阳', '平吉', '古美'];
                    series = [
                        {
                            name: '',
                            type: 'bar',
                            stack: '总量',
                            label: {
                                normal: {
                                    show: true,
                                    position: 'right',
                                    textStyle: {
                                        fontSize: 8
                                    }
                                }
                            },
                            itemStyle: {
                                normal: {
                                    color: series_color_1
                                }
                            },
                            data: [dataR.donglan, dataR.gulong, dataR.pingnan, dataR.pingyang, dataR.pingji, dataR.gumei]
                        }
                    ];
                    var option_pq_bar = chartBar(title_text, legend_data, yAxis_data, series);
                    pqBar.setOption(option_pq_bar);
                }
            }
        });
    }
    Array.prototype.aindexOf = function(val) {
        for (var i = 0; i < this.length; i++) {
            if (this[i] == val) return i;
        }
        return -1;
    };
    Array.prototype.remove = function(val) {
        var index = this.aindexOf(val);
        if (index > -1) {
            this.splice(index, 1);
        }
    };

    $("span.label").click(
            function () {
                if($(this).attr("class").indexOf("select")>0){
                    var cl=$(this).attr("class").split(" ")[1];
                    $(this).attr("class","label "+cl);
                    var laa=$(this).text().trim();
                    $("#selectLabel span").each(function () {
                        if($(this).text().trim()==laa){
                            $("#label3").hide();
                            $("#label1").show();
                            var text = $(this).text();
                            la.remove(text);

                            $(this).remove();
                            // ageBar = echarts.init(document.getElementById('ageBar'));
                            // sexPie= echarts.init(document.getElementById('sexPie'));
                            // pqBar= echarts.init(document.getElementById('pqBar'));
                            // hjPie= echarts.init(document.getElementById('hjPie'));
                            // ageBar.setOption(option_age_bar);
                            // sexPie.setOption(option_sex_pie);
                            // pqBar.setOption(option_pq_bar);
                            // hjPie.setOption(option_hj_pie);


                            return;
                        }
                    });
                }else {

                    $(this).addClass("select");
                    var text = $(this).text();
                    var cl=$(this).attr("class").split(" ")[1];
                    $("#selectLabel").append($("<span class='bl label "+cl+"'>" + text + "</span>"));
                    la.push(text);
//             table.fnFilter();
                    $("#label3").hide();
                    $("#label1").show();

                    //alert(la.length);

                    // ageBar = echarts.init(document.getElementById('ageBar'));
                    // sexPie = echarts.init(document.getElementById('sexPie'));
                    // pqBar = echarts.init(document.getElementById('pqBar'));
                    // hjPie = echarts.init(document.getElementById('hjPie'));
                    // ageBar.setOption(option_age_bar);
                    // sexPie.setOption(option_sex_pie);
                    // pqBar.setOption(option_pq_bar);
                    // hjPie.setOption(option_hj_pie);
                }
            }
    );
</script>
<script src="/static/js/visual/mapData.js"></script>
</html>