<#--<style>-->
<#--@media only screen and (min-width: 6000px){-->
<#--#map p{-->
<#--font-size: 70px;-->
<#--text-align: center;-->
<#--}-->
<#--#map img{-->
<#--width: 55%;-->
<#--}-->
<#--}-->

<#--</style>-->
<#--<div class="row">-->
<#--<div class="col-lg-12">-->
<#--<p>古美街道分布图</p>-->
<#--</div>-->
<#--</div>-->
<#--<div class="row">-->
<#--<div class="col-lg-12" align="center">-->
<#--<img src="/static/img/map/3.png">-->
<#--</div>-->
<#--</div>-->
<#--//old-->
<style>
    @media only screen and (min-width: 6000px){
        #map p{
            font-size: 70px;
            text-align: center;
        }
        #map img{
            width: 55%;
        }
    }

</style>
<style type="text/css">
    ul,li{list-style: none;margin:0;padding:0;float:left;}
    html{height:100%}
    body{height:100%;margin:0px;padding:0px;font-family:"微软雅黑";}
    #container{height:650px;width:100%;}
    #r-result{width:100%;}
    .BMap_cpyCtrl {display:none;}
    .anchorBL{display:none;}
    .BMap_stdMpPan {background-position:0px 0px !important;}
    /*.BMap_button {background-position:0px px !important;}*/
    .BMap_stdMpZoomIn {background-position:-8px -57px !important;}
    .BMap_stdMpZoomOut {background-position:-9px -293px !important;}


</style>

        <div class="row">
            <div class="col-lg-12">
                <p></p>
            </div>
        </div>
        <div class="row" style="margin-top: 30px">
            <div class="col-lg-12" align="center">
            <#--<img src="/static/img/map/3.png">-->
                <style type="text/css">
                    /*html,body{margin:0;padding:0;}*/
                    .iw_poi_title {color:#CC5522;font-size:30px;font-weight:bold;overflow:hidden;padding-right:13px;white-space:nowrap}
                    .iw_poi_content {font:25px arial,sans-serif;overflow:visible;padding-top:4px;white-space:-moz-pre-wrap;word-wrap:break-word;}

                </style>
                <script type="text/javascript" src="http://api.map.baidu.com/api?key=&v=1.1&services=true"></script>
                <script type="text/javascript" src="http://api.map.baidu.com/library/GeoUtils/1.2/docs/symbols/BMapLib.html"></script>
                <script type="text/javascript" src="http://api.map.baidu.com/library/GeoUtils/1.2/docs/symbols/src/BMapLib_GeoUtils.js.html"></script>
                <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=Lak4ThuxodnoDdL3ZrfK5t91UR4uDmGm"></script>
                <script type="text/javascript" src="http://api.map.baidu.com/library/Heatmap/2.0/src/Heatmap_min.js"></script>


                <div class="col-lg-15" style="border:#ccc solid 1px;z-index: 1;position: absolute;top: -50px" id="dituContent" align="center"></div>
                <div class="col-lg-15" style="border:#ccc solid 1px;z-index: 2;position: absolute;top: -50px" id="container" align="center"></div>
                <div style="width: 300px; height: 200px;right: 1.5%;top: -20px;position: absolute;z-index: 2;">
                    <#--<img src="/static/img/map/btn.jpg" onclick="clear_select()">-->
                    <p id="date" style="font-size: 30px" onclick="clear_select()"></p>
                </div>

                <script type="text/javascript">
                    //js获取日期
                    var now= new Date();
                    var year=now.getFullYear();
                    var month=now.getMonth();
                    var date=now.getDate();
                    document.getElementById("date").innerHTML=year+"年"+(month+1)+"月"+date+"日";
                    var dataOrgan=null;
                </script>
                <script type="text/javascript">
                    function clear_select(){
                        window.location.reload();
                        sex = 0;
                        census = [];
                        ageStart = 0;
                        ageEnd = 0;
                        family = [];
                        familyType = [];
                        economic = [];
                        oldStatus = [];
                        politicalStatusArray = [];
                        organIdArray = [];
                        secTypeArray = [];
                        thirdTypeArray = [];
                        forthTypeArray = [];
                        fifthTypeArray = [];
                        sixthTypeArray = [];
                        mapDistrict = [];
                        eyesightArray = [];
                        intelligenceArray = [];
                        health = [];
                        isMb = 0;
                        isSn = 0;
                        isYwfy = 0;
                        isExzl = 0;
                        isGz = 0;
                        isCj = 0;
                        zhucan = 0;
                        zhuji = 0;
                        zhujie = 0;
                        zhuyu = 0;
                        zhuxing = 0;
                        zhuyi = 0;
                        kangfu = 0;
                        xiangtan = 0;
                        xidi = 0;
                        shenghuo = 0;

                        getNumOfJw();
                        getAgeAndSex();
                        table.fnFilter();
                        $('.select').each(function() {
                            var cl=$(this).attr('class').split(' ')[1];
                            $(this).attr('class','label '+cl);
                        });
                        $('#selectLabel').html('');

                    }

                    show_organ_map();
                    show_heat_map();

                    function show_organ_map(){
                        // $("#dituContent").css("width",winWidth/4);
                        // $("#dituContent").css("height",winHeight/1.55);
                        // $("#dituContent").css("left",winWidth/22);
                        // $("#container").css("left",winWidth/22);
                        $("#dituContent").css("width",winWidth/4.22);
                        $("#dituContent").css("height",winHeight/1.3);
                        $("#dituContent").css("left",winWidth/70);
                        $("#container").css("left",winWidth/70);


                        //创建和初始化地图函数：
                        function initMap(){
                            createMap();//创建地图
                            setMapEvent();//设置地图事件
                            addMapControl();//向地图添加控件
                            addPolygon();//多边形覆盖物
                            addPolyline();//向地图中添加线
                            addMarker();//向地图中添加标注
                        }

                        //创建地图函数：
                        function createMap(){
                            var map = new BMap.Map("dituContent");//在百度地图容器中创建一个地图
                            var point = new BMap.Point(121.401269,31.150527);//定义一个中心点坐标
                            //var point = new BMap.Point(121.401447|31.151412);//定义一个中心点坐标
                            map.centerAndZoom(point,16);//设定地图的中心点和坐标并将地图显示在地图容器中
                            window.map = map;//将map变量存储在全局
                            //中心点
                            // map.addEventListener("click",function(e){
                            //     alert(e.point.lng+","+e.point.lat);// 单击地图获取坐标点；  
                            //     map.panTo(new BMap.Point(e.point.lng,e.point.lat));// map.panTo方法，把点击的点设置为地        图中心点  
                            // });

                        }

                        //地图事件设置函数：
                        function setMapEvent(){
                            map.enableDragging();//启用地图拖拽事件，默认启用(可不写)
                            map.enableScrollWheelZoom();//启用地图滚轮放大缩小
                            map.enableDoubleClickZoom();//启用鼠标双击放大，默认启用(可不写)
                            map.enableKeyboard();//启用键盘上下左右键移动地图
                        }

                        //地图控件添加函数：
                        function  copyOrganInfo(data) {
                            dataOrgan=data;
                        }
                        function addMapControl(){
                            //向地图中添加缩放控件
                            var ctrl_nav = new BMap.NavigationControl({anchor:BMAP_ANCHOR_BOTTOM_RIGHT,type:BMAP_NAVIGATION_CONTROL_SMALL});
                            map.addControl(ctrl_nav);
                            //向地图中添加缩略图控件
                            // var ctrl_ove = new BMap.OverviewMapControl({anchor:BMAP_ANCHOR_BOTTOM_RIGHT,isOpen:1});
                            // map.addControl(ctrl_ove);
                            //向地图中添加比例尺控件
                            // var ctrl_sca = new BMap.ScaleControl({anchor:BMAP_ANCHOR_BOTTOM_LEFT});
                            // map.addControl(ctrl_sca);
                        }

                        //标注点数组



                        $.ajax({
                            url: "/visual/data/getOrganInfo",
                            type: "get",
                            async: false,
                            success: function (result) {
                                if (result.success == true) {
                                    dataOrgan=result.data;
                                }
                            }
                        });
                        console.log(dataOrgan);
                        markerArr = [

                            {title:"古美片区",content:dataOrgan.InfoGuMeiPianQu,point:"121.412299|31.148708",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:-1},type:-1,text:dataOrgan.InfoGuMeiPianQu}
                            ,{title:"古龙片区",content:"古龙片区",point:"121.410071|31.154518",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:-2},type:-2,text:dataOrgan.InfoGuLongPianQu}
                            ,{title:"平南片区",content:"平南片区",point:"121.39965|31.157237",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:-3},type:-3,text:dataOrgan.InfoPingNanPianQu}
                            ,{title:"东兰片区",content:"东兰片区",point:"121.389302|31.158659",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:-4},type:-4,text:dataOrgan.InfoDongLanPianQu}
                            ,{title:"平吉片区",content:"平吉片区",point:"121.391242|31.150871",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:-5},type:-5,text:dataOrgan.InfoPingJiPianQu}
                            ,{title:"平阳片区",content:"平阳片区",point:"121.394333|31.140857",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:-6},type:-6,text:dataOrgan.InfoPingYangPianQu}
                            //老有所养
                            ,{title:"莲花敬老院",content:"<div style='width:720px;height: 1200px'>"+"上海市闵行区莲花敬老院，位于闵行区莲花路1115号，东近中环线，是目前市内难得的地处黄金地段，生活环境理想的老年公寓。我院占地面积4900平方米，建筑面积7480平方米，绿化面积1800平方米，拥有养老床位187张，是一所重点投资建设的集休养、医疗、康复、娱乐为一体的综合型宾馆式养老机构。"+
                                "<div style='width:720px;height: 500px'>"+
                                "<img  style='width:100%;height: 100%;'id='LianHua' src='https://organold.oss-cn-shanghai.aliyuncs.com/img/LianHua.jpeg'>"+
                                "</div>"+
                                "</div>",point:"121.402695|31.160113",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:1},
                                type:4,img:"https://organold.oss-cn-shanghai.aliyuncs.com/img/LianHua.png",text:dataOrgan.InfoLianHuaJingLaoYuan}//莲花敬老院
                            ,{title:"古美敬老院",content:"上海闵行区古美敬老院，位于闵行区虹莘路2288弄135号（平吉二村内）交通便利。房间设施设备齐全、有线电视、电扇、卫生设备、空调、呼叫装置一应齐全，院内还设有餐厅、健身房、棋牌室、阅览室等。" +
                                "  收养对象为身体健康为能自理、有困难或完全不能自理的老人，包括患有  各类老年疾病的、患有老年痴呆症及需要临终关怀的老人，为他们提供长期的 养老和日托服务，是一所集养老、康复、护理、娱乐为一体的综合型养老机构。" +
                               "已成为地区老年人不可多得的“养老福地”，入住率始终保持95%以上。"+
                                "<div style='width:720px;height: 500px'>"+
                                "<img  style='width:100%;height: 100%;'id='GuMei' src='https://organold.oss-cn-shanghai.aliyuncs.com/img/GuMeiGericomium.png'>"+
                                "</div>",type:5,point:"121.39056|31.148028",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:1},type:5,
                            img:"https://organold.oss-cn-shanghai.aliyuncs.com/img/GuMeiGericomium.png",text:dataOrgan.InfoGuMeiJingLaoYuan}
                            ,{title:"平阳敬老院",content:"上海市闵行区平阳敬老院创建于2008年12月，占地面积824平方米，总建筑面积为4997平方米，绿化面积1018平方米，" +
                                    "总投资1000多万元。院内拥有双人房（或夫妻房）、三人房和七人房共64间，共有床位200张，并有良好的设备、整洁的环境、" +
                                    "严格的管理、周到的服务、医养的融合，是上海市社会福利行业协会会员单位。\n"+
                                "<div style='width:720px;height: 500px'>"+
                                "<img  style='width:100%;height: 100%;'id='PingYang' src='https://organold.oss-cn-shanghai.aliyuncs.com/img/PingYangGerocomium.png'>"+
                                "</div>",point:"121.395161|31.140954",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:1},type:6,
                            img:"https://organold.oss-cn-shanghai.aliyuncs.com/img/PingYangGerocomium.png",text:dataOrgan.InfoPingYangJingLaoYuan}
                            ,{title:"乐健长者照护之家",content:"乐健长者照护之家",point:"121.407448|31.148538",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:2},type:1,
                                text:dataOrgan.InfoLeJianZhangZheZhaoHuZhiJia}
                            ,{title:"艾维康长者照护之家",content:"艾维康长者照护之家",point:"121.399399|31.158473",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:2},type:2,
                            text:dataOrgan.InfoAiWeiKangZhangZheZhaoHuZhiJia}
                            ,{title:"智慧坊长者照护之家",content:"古美智汇坊——平阳为老服务中心位于闵行区平阳路1526号（近虹莘路）， 2016年7月开业，建筑面积420㎡，包括18张照护床位，若干个日托服务。为面向半护理、全护理长者提供托付、照护的智慧养老场所。包含长期照护、短期照护、日托照护服务、健康管理、营养餐饮等多种为老服务，更有亲情式24小时贴心专业护理，让长者享受食、住、娱、医、养、护的一站式养老服务。" +
                                "长期照护——为中轻度失能长者进行健康生活管理，提供心理上的亲情服务，使他们拥有更有尊严的生活；" +
                                "短期照护——对处于慢性病康复期的长者进行专业护理；" +
                                "喘息照护——为长者提供超短期护理，缓解家属护理压力；" +
                                "日托服务——日托单天护理。"+
                                "<div style='width:445px;height: 335px;margin-left:20%'>"+
                                "<img  style='width:100%;height: 100%;id='ZhihuiFang' src='https://organold.oss-cn-shanghai.aliyuncs.com/img/ZhiHuiFang.jpg'>"+
                                "</div>",point:"121.407592|31.150917",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:2},type:3,
                            img:"https://organold.oss-cn-shanghai.aliyuncs.com/img/ZhiHuiFang.jpg",text:dataOrgan.InfoZhiHuiFangZhangZheZhaoHuZhiJia}//unknown
                            // ,{title:"平南长者照护之家",content:"艾为养老服务（上海）有限公司注册于上海市，注册资金500万元。公司专注于打造以日间照料、居家养老、社区机构养老三位一体的现代 社区养老模式。经营管理团队具有丰富的执业经验，与北京、重庆、成都、浙江等市区政府构建了良好的业务合作关系。 \n" +
                            //     "              公司致力于传承光大“行孝天下、大爱无疆”的孝道文化，遵循“尊老、敬老、助老、爱老”的服务宗旨，着力尊重客户需求和体验，以专业护理为基础，医养结合为核心，智能养老为方向，为广大健康、空巢、独居、失能、半失能、失智的老年人及术后病人提供一系列的养老综合服务，提供全面解决方案，帮助老人愉悦身心，益智增能，延伸生命尺度和价值。\n",type:5,point:"121.389133|31.158804",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5}}//0
                            // ,{title:"平阳长者照护之家",content:"在建",type:5,point:"121.411903|31.152524",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5}}//

                            //老有所乐?
                            ,{title:"东兰一居",content:"东兰一居"+
                                "<div style='width:720px;height: 500px;'>"+
                                "<img  style='width:100%;height: 100%;'id='DongLanFir' src='https://organold.oss-cn-shanghai.aliyuncs.com/img/DongLanFir.jpg'>"+
                                "</div>",point:"121.389133|31.158804",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:0},type:10,img:"https://organold.oss-cn-shanghai.aliyuncs.com/img/DongLanFir.jpg",text:"东兰一居"}
                            ,{title:"古龙一居",content:"古龙一居"+
                                "<div style='width:720px;height: 500px;'>"+
                                "<img  style='width:50%;height: 100%;'id='GuLongFir' src='https://organold.oss-cn-shanghai.aliyuncs.com/img/GuLongFir.png'>"+
                                "</div>",point:"121.410277|31.151814",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:0},type:8,img:"https://organold.oss-cn-shanghai.aliyuncs.com/img/GuLongFir.png",
                            text:"古龙一居"}
                            ,{title:"古美一村",content:"古美一村"+
                                "<div style='width:720px;height: 500px;'>"+
                                "<img  style='width:100%;height: 100%;'id='GuMeiFir' src='https://organold.oss-cn-shanghai.aliyuncs.com/img/GuMeiFir.png'>"+
                                "</div>",point:"121.409142|31.148518",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:0},type:7,
                            img:"https://organold.oss-cn-shanghai.aliyuncs.com/img/GuMeiFir.png",text:"古美一村"}
                            ,{title:"古龙二居",content:"古龙二居"+
                                "<div style='width:720px;height: 500px;'>"+
                                "<img  style='width:100%;height: 100%;'id='GuLongSec' src='https://organold.oss-cn-shanghai.aliyuncs.com/img/GuLongSec.png'>"+
                                "</div>",point:"121.411089|31.152975",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:0},type:8,
                            img:"https://organold.oss-cn-shanghai.aliyuncs.com/img/GuLongSec.png",text:"古龙二居"}
                            ,{title:"古龙三居",content:"古龙三居"+
                                "<div style='width:720px;height: 500px;'>"+
                                "<img  style='width:100%;height: 100%;'id='GuLongThird' src='https://organold.oss-cn-shanghai.aliyuncs.com/img/GuLongThird.png'>"+
                                "</div>",point:"121.406289|31.155351",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:0},type:8,
                            img:"https://organold.oss-cn-shanghai.aliyuncs.com/img/GuLongThird.png",text:"古龙三居"}
                            ,{title:"东兰三居",content:"东兰三居"+
                                "<div style='width:720px;height: 500px;'>"+
                                "<img  style='width:100%;height: 100%;'id='DongLanThird' src='https://organold.oss-cn-shanghai.aliyuncs.com/img/DongLanThird.png'>"+
                                "</div>",point:"121.387235|31.157819",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:0},type:10,
                            img:"https://organold.oss-cn-shanghai.aliyuncs.com/img/DongLanThird.png",text:"东兰三居"}
                            ,{title:"东兰四居",content:"东兰四居"+
                                "<div style='width:720px;height: 500px;'>"+
                                "<img  style='width:100%;height: 100%;'id='DongLanForth' src='https://organold.oss-cn-shanghai.aliyuncs.com/img/DongLanForth.jpg'>"+
                                "</div>",point:"121.388044|31.161102",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:0},type:10,
                            img:"https://organold.oss-cn-shanghai.aliyuncs.com/img/DongLanForth.jpg",text:"东兰四居"}
                            ,{title:"平吉三村",content:"平吉三村"+
                                "<div style='width:720px;height: 500px;'>"+
                                "<img  style='width:100%;height: 100%;'id='PingJiThird' src='https://organold.oss-cn-shanghai.aliyuncs.com/img/PingJiThird.png'>"+
                                "</div>",point:"121.392393|31.145568",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:0},type:11,
                            img:"https://organold.oss-cn-shanghai.aliyuncs.com/img/PingJiThird.png",text:"平吉三村"}
                            ,{title:"古龙六居",content:"古龙六居"+
                                "<div style='width:720px;height: 500px;'>"+
                                "<img  style='width:100%;height: 100%;'id='GuLongSix' src='https://organold.oss-cn-shanghai.aliyuncs.com/img/GuLongSix.png'>"+
                                "</div>",point:"121.411512|31.159194",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:0},type:8,
                            img:"https://organold.oss-cn-shanghai.aliyuncs.com/img/GuLongSix.png",text:"古龙六居"}
                            ,{title:"古美九村",content:"古美九村"+
                                "<div style='width:720px;height: 500px;'>"+
                                "<img  style='width:100%;height: 100%;'id='GuMeiNine' src='https://organold.oss-cn-shanghai.aliyuncs.com/img/GuMeiNine.jpg'>"+
                                "</div>",point:"121.411598|31.146782",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:0},type:7,
                            img:"https://organold.oss-cn-shanghai.aliyuncs.com/img/GuMeiNine.jpg",text:"古美九村"}
                            ,{title:"古美七村",content:"古美七村"+
                                "<div style='width:720px;height: 500px;'>"+
                                "<img  style='width:100%;height: 100%;'id='GuMeiSeven' src='https://organold.oss-cn-shanghai.aliyuncs.com/img/GuMeiSeven.png'>"+
                                "</div>",point:"121.41470|31.151291",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:0},type:7,
                            img:"https://organold.oss-cn-shanghai.aliyuncs.com/img/GuMeiSeven.png",text:"古美七村"}
                            ,{title:"华梅花苑",content:"华梅花苑"+
                                "<div style='width:720px;height: 500px;'>"+
                                "<img  style='width:100%;height: 100%;'id='HuaMeiHuaGarden' src='https://organold.oss-cn-shanghai.aliyuncs.com/img/HuaMeiGarden.png'>"+
                                "</div>",point:"121.410200|31.162142",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:0},type:9,
                            img:"https://organold.oss-cn-shanghai.aliyuncs.com/img/HuaMeiGarden.png",text:"华梅花苑"}
                            ,{title:"梅莲苑",content:"梅莲苑"+
                                "<div style='width:720px;height: 500px;'>"+
                                "<img  style='width:100%;height: 100%;'id='HuaMeiHuaGarden' src='https://organold.oss-cn-shanghai.aliyuncs.com/img/MeiLianGarden.png'>"+
                                "</div>",point:"121.407256|31.166000",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:0},type:9,
                            img:"https://organold.oss-cn-shanghai.aliyuncs.com/img/MeiLianGarden.png",text:"梅莲苑"}

                            ,{title:"平阳二村   ",content:"平阳二村"+
                                "<div style='width:720px;height: 500px;'>"+
                                "<img  style='width:100%;height: 100%;'id='PingYangSec' src='https://organold.oss-cn-shanghai.aliyuncs.com/img/PingYangSec.png'>"+
                                "</div>",point:"121.396912|31.143988",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:0},type:12,
                            img:"https://organold.oss-cn-shanghai.aliyuncs.com/img/PingYangSec.png",text:"平阳二村"}
                            ,{title:"平阳三村",content:"平阳三村"+
                                "<div style='width:720px;height: 500px;'>"+
                                "<img  style='width:100%;height: 100%;'id='PingYangThird' src='https://organold.oss-cn-shanghai.aliyuncs.com/img/PingYangThird.png'>"+
                                "</div>",point:"121.39388|31.139939",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:0},type:12,
                            img:"https://organold.oss-cn-shanghai.aliyuncs.com/img/PingYangThird.png",text:"平阳三村"}
                            ,{title:"万源四居",content:"万源四居"+
                                "<div style='width:720px;height: 500px;'>"+
                                "<img  style='width:100%;height: 100%;'id='WanYuanForth' src='https://organold.oss-cn-shanghai.aliyuncs.com/img/PingYangThird.png'>"+
                                "</div>",point:"121.404052|31.151059",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:0},type:9,
                            img:"https://organold.oss-cn-shanghai.aliyuncs.com/img/PingYangThird.png",text:"万源四居"}
                            ,{title:"万源一居",content:"万源一居"+
                                "<div style='width:720px;height: 500px;'>"+
                                "<img  style='width:100%;height: 100%;'id='WanYuanFir' src='https://organold.oss-cn-shanghai.aliyuncs.com/img/WanYuanFir.jpg'>"+
                                "</div>",point:"121.399151|31.153805",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:0},type:9,
                            img:"https://organold.oss-cn-shanghai.aliyuncs.com/img/WanYuanFir.jpg",text:"万源一居"}
                            ,{title:"东兰二居",content:"东兰二居"+
                                "<div style='width:720px;height: 500px;'>"+
                                "<img  style='width:100%;height: 100%;'id='DongLanSec' src='https://organold.oss-cn-shanghai.aliyuncs.com/img/DongLanSec.JPG'>"+
                                "</div>",point:"121.393436|31.157818",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:0},type:10,text:"东兰二居"}
                            ,{title:"平吉四村",content:"平吉四村",type:5,point:"121.391183|31.153482",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:0},type:11,
                            img:"https://organold.oss-cn-shanghai.aliyuncs.com/img/DongLanSec.JPG",text:"平吉四村"}
                            ,{title:"古龙四居",content:"古龙四居"+
                                "<div style='width:720px;height: 500px;'>"+
                                "<img  style='width:100%;height: 100%;'id='GuLongForth' src='https://organold.oss-cn-shanghai.aliyuncs.com/img/GuLongForth.png'>"+
                                "</div>",point:"121.412186|31.155164",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:0},
                            img:"https://organold.oss-cn-shanghai.aliyuncs.com/img/GuLongForth.png",text:"古龙四居"}
                            ,{title:"古美八村",content:"古美八村",point:"121.409878|31.145572",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:7},text:"古美八村"}
                            ,{title:"古美四村",content:"古美四村",point:"121.410402|31.148453",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:7},text:"古美四村"}
                            ,{title:"平南三居",content:"平南三居"+
                                "<div style='width:720px;height: 500px;'>"+
                                "<img  style='width:100%;height: 100%;'id='PingNanThird' src='https://organold.oss-cn-shanghai.aliyuncs.com/img/PingNanThird.png'>"+
                                "</div>",point:"121.397204|31.159934",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:0},type:9,
                            img:"https://organold.oss-cn-shanghai.aliyuncs.com/img/PingNanThird.png",text:"平南三居"}
                            ,{title:"平南一居",content:"平南一居"+
                                "<div style='width:720px;height: 500px;'>"+
                                "<img  style='width:100%;height: 100%;'id='PingNanFir' src='https://organold.oss-cn-shanghai.aliyuncs.com/img/PingNanFir.png'>"+
                                "</div>",point:"121.400571|31.160467",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:0},type:9,
                            img:"https://organold.oss-cn-shanghai.aliyuncs.com/img/PingNanFir.png",text:"平南一居"}
                            ,{title:"平阳六村",content:"平阳六村"+
                                "<div style='width:720px;height: 500px;'>"+
                                "<img  style='width:100%;height: 100%;'id='PingYangSix' src='https://organold.oss-cn-shanghai.aliyuncs.com/img/PingYangSix.png'>"+
                                "</div>",point:"121.397188|31.136772",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:0},type:12,
                            img:"https://organold.oss-cn-shanghai.aliyuncs.com/img/PingYangSix.png",text:"平阳六村"}
                            ,{title:"平阳四村",content:"平阳四村"+
                                "<div style='width:720px;height: 500px;'>"+
                                "<img  style='width:100%;height: 100%;'id='PingYangForth' src='https://organold.oss-cn-shanghai.aliyuncs.com/img/PingYangForth.png'>"+
                                "</div>",point:"121.396699|31.138846",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:0},type:12,
                            img:"https://organold.oss-cn-shanghai.aliyuncs.com/img/PingYangForth.png",text:"平阳四村"}

                            ,{title:"平阳一村",content:"平阳一村",point:"121.389500|31.141276",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:0},type:12,text:"平阳一村"}
                            ,{title:"万源三居",content:"万源三居"+
                                "<div style='width:720px;height: 500px;'>"+
                                "<img  style='width:100%;height: 100%;'id='WanYuanThird' src='https://organold.oss-cn-shanghai.aliyuncs.com/img/WanYuanThird.jpg'>"+
                                "</div>",point:"121.403865|31.152716",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5},type:9,
                            img:"https://organold.oss-cn-shanghai.aliyuncs.com/img/WanYuanThird.jpg",text:"万源三居"}
                            ,{title:"古龙五居",content:"古龙五居",point:"121.405819|31.155885",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:0},type:8,text:"古龙五居"}
                            ,{title:"平吉六村",content:"平吉六村"+
                                "<div style='width:720px;height: 500px;'>"+
                                "<img  style='width:100%;height: 100%;'id='PingJiSix' src='https://organold.oss-cn-shanghai.aliyuncs.com/img/PingJiSix.png'>"+
                                "</div>",point:"121.395925|31.148518",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:0},type:11,
                            img:"https://organold.oss-cn-shanghai.aliyuncs.com/img/PingJiSix.png",text:"平吉六村"}
                            ,{title:"华一新城",content:"华一新城"+
                                "<div style='width:720px;height: 500px;'>"+
                                "<img  style='width:100%;height: 100%;'id='HuaYi' src='https://organold.oss-cn-shanghai.aliyuncs.com/img/HuaYiNewCity.png'>"+
                                "</div>",point:"121.405043|31.162622",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:0},type:9,
                            img:"https://organold.oss-cn-shanghai.aliyuncs.com/img/HuaYiNewCity.png",text:"华一新城"}
                            ,{title:"平吉二村",content:"平吉二村"+
                                "<div style='width:720px;height: 500px;'>"+
                                "<img  style='width:100%;height: 100%;'id='PingJiSec' src='https://organold.oss-cn-shanghai.aliyuncs.com/img/PingJiSec.png'>"+
                                "</div>",point:"121.388900|31.14893",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:0},type:11,
                            img:"https://organold.oss-cn-shanghai.aliyuncs.com/img/PingJiSec.png",text:"平吉二村"}
                            ,{title:"平吉五村",content:"平吉五村",point:"121.3945|31.151394",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:0},type:11,text:"平吉五村"}
                            ,{title:"古美三村",content:"古美三村"+
                                "<div style='width:720px;height: 500px;'>"+
                                "<img  style='width:100%;height: 100%;'id='GuMeiThird' src='https://organold.oss-cn-shanghai.aliyuncs.com/img/GuMeiThird.png'>"+
                                "</div>",point:"121.408875|31.147336",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:0},type:7,
                            img:"https://organold.oss-cn-shanghai.aliyuncs.com/img/GuMeiThird.png",text:"古美三村"}
                            ,{title:"古美十村",content:"古美十村"+
                                "<div style='width:720px;height: 500px;'>"+
                                "<img  style='width:100%;height: 100%;'id='GuMeiTenth' src='https://organold.oss-cn-shanghai.aliyuncs.com/img/GuMeiTenth.png'>"+
                                "</div>",point:"121.414226|31.1478032",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:0},type:7,
                            img:"https://organold.oss-cn-shanghai.aliyuncs.com/img/GuMeiTenth.png",text:"古美十村"}
                            ,{title:"平南二居",content:"平南二居"+
                                "<div style='width:720px;height: 500px;'>"+
                                "<img  style='width:100%;height: 100%;'id='PingNanSec' src='https://organold.oss-cn-shanghai.aliyuncs.com/img/PingNanSec.png'>"+
                                "</div>",point:"121.397218|31.158308",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:0},type:9,
                            img:"https://organold.oss-cn-shanghai.aliyuncs.com/img/PingNanSec.png",text:"平南二居"}
                            ,{title:"平阳五村",content:"平阳五村"+
                                "<div style='width:720px;height: 500px;'>"+
                                "<img  style='width:100%;height: 100%;'id='PingYangFifth' src='https://organold.oss-cn-shanghai.aliyuncs.com/img/PingYangFifth.jpg'>"+
                                "</div>",point:"121.393407|31.13485",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:0},type:12,
                            img:"https://organold.oss-cn-shanghai.aliyuncs.com/img/PingYangFifth.jpg",text:"平阳五村"}
                            ,{title:"平吉一村",content:"平吉一村"+
                                "<div style='width:720px;height: 500px;'>"+
                                "<img  style='width:100%;height: 100%;'id='PingJiFir' src='https://organold.oss-cn-shanghai.aliyuncs.com/img/PingJiFir.jpg'>"+
                                "</div>",point:"121.388900|31.151069",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:0},type:11,
                            img:"https://organold.oss-cn-shanghai.aliyuncs.com/img/PingJiFir.jpg",text:"平吉一村"}
                            ,{title:"万源二居",content:"万源二居"+
                                "<div style='width:720px;height: 500px;'>"+
                                "<img  style='width:50%;height: 100%;'id='WanYuanSec' src='https://organold.oss-cn-shanghai.aliyuncs.com/img/WanYuanSec.png'>"+
                                "</div>",point:"121.401069|31.155103",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:0},type:9,
                            img:"https://organold.oss-cn-shanghai.aliyuncs.com/img/WanYuanSec.png",text:"万源二居"}

                            // {title:"古美片区",content:"古美片区",point:"121.412299|31.148708",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:-1},type:-1}
                            // ,{title:"古龙片区",content:"古龙片区",point:"121.410071|31.154518",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:-2},type:-2}
                            // ,{title:"平南片区",content:"平南片区",point:"121.39965|31.157237",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:-3},type:-3}
                            // ,{title:"东兰片区",content:"东兰片区",point:"121.389302|31.158659",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:-4},type:-4}
                            // ,{title:"平吉片区",content:"平吉片区",point:"121.391242|31.150871",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:-5},type:-5}
                            // ,{title:"平阳片区",content:"平阳片区",point:"121.394333|31.140857",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:-6},type:-6}
                            ,{title:"古美路街道办事处",content:"古美街道"+
                        "<div style='width:720px;height: 500px;'>"+
                        "<img  style='width:50%;height: 100%;'id='WanYuanSec' src='https://organold.oss-cn-shanghai.aliyuncs.com/img/WanYuanSec.png'>"+
                        "</div>",point:"121.400746|31.152942",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5,type:100},type:100,text:"古美路街道办事处"}



                            //老有所为 0

                        ];
                        //创建marker
                        function addMarker(){
                            for(var i=0;i<markerArr.length;i++){
                                var json = markerArr[i];
                                var p0 = json.point.split("|")[0];
                                var p1 = json.point.split("|")[1];
                                var point = new BMap.Point(p0,p1);
                                var iconImg = createIcon(json.icon);
                                var marker = new BMap.Marker(point,{icon:iconImg});
                                var iw = createInfoWindow(i);
                                var label = new BMap.Label(json.title,{"offset":new BMap.Size(json.icon.lb-json.icon.x+10,-20)});
                                marker.setLabel(label);
                                marker.json=json;
                                //label.hide();
                                map.addOverlay(marker);
                                label.setStyle({
                                    borderColor:"#808080",
                                    color:"#000",
                                    cursor:"pointer",
                                    maxWidth:"none",
                                    fontSize : "30px"//字体大小 　　
                                });

                                (function(){
                                   // var index = i;
                                    var _iw = createInfoWindow(i);
                                    var _marker = marker;
                                    _marker.addEventListener("click",function(){
                                        //this.openInfoWindow(_iw);
                                        $('#editModal2').modal('show');
                                        add_org_info(this.json);
                                    });
                                    _iw.addEventListener("open",function(){
                                        _marker.getLabel().hide();
                                    })
                                    _iw.addEventListener("close",function(){
                                       // _marker.getLabel().show();
                                    })
                                    label.addEventListener("click",function(){
                                        _marker.openInfoWindow(_iw);
                                    })
                                    if(!!json.isOpen){
                                        label.hide();
                                        _marker.openInfoWindow(_iw);
                                    }
                                })()
                                label.hide();
                            }
                        }
                        //创建InfoWindow
                        function createInfoWindow(i){
                            var json = markerArr[i];
                            //alert(json.title);
                            var iw = new BMap.InfoWindow("<b class='iw_poi_title' title='" + json.title + "'>" + json.title + "</b><div class='iw_poi_content' style='width:720px;height: 1500px'>"+json.content+"</div>");
                            return iw;
                        }
                        //创建一个Icon
                        function createIcon(json){
                            if(json.type==1){
                                var icon = new BMap.Icon("https://organold.oss-cn-shanghai.aliyuncs.com/img/gongyu.png", new BMap.Size(45,45),{imageOffset: new BMap.Size(-json.l,-json.t),infoWindowOffset:new BMap.Size(json.lb+5,1),offset:new BMap.Size(json.x,json.h)});
                            } else if(json.type==2)
                            var icon = new BMap.Icon("https://organold.oss-cn-shanghai.aliyuncs.com/img/zhangzhao.png", new BMap.Size(45,45),{imageOffset: new BMap.Size(-json.l,-json.t),infoWindowOffset:new BMap.Size(json.lb+5,1),offset:new BMap.Size(json.x,json.h)});
                            else if(json.type==0)
                            var icon = new BMap.Icon("https://organold.oss-cn-shanghai.aliyuncs.com/img/cun.png", new BMap.Size(45,45),{imageOffset: new BMap.Size(-json.l,-json.t),infoWindowOffset:new BMap.Size(json.lb+5,1),offset:new BMap.Size(json.x,json.h)});
                            else if(json.type==-1)
                                var icon = new BMap.Icon("https://organold.oss-cn-shanghai.aliyuncs.com/img/gumeip-s.png", new BMap.Size(200,200),{imageOffset: new BMap.Size(-json.l,-json.t),infoWindowOffset:new BMap.Size(json.lb+5,1),offset:new BMap.Size(json.x,json.h)});
                            else if(json.type==-2)
                                var icon = new BMap.Icon("https://organold.oss-cn-shanghai.aliyuncs.com/img/gulongp-s.png", new BMap.Size(200,200),{imageOffset: new BMap.Size(-json.l,-json.t),infoWindowOffset:new BMap.Size(json.lb+5,1),offset:new BMap.Size(json.x,json.h)});
                            else if(json.type==-3)
                                var icon = new BMap.Icon("https://organold.oss-cn-shanghai.aliyuncs.com/img/pingnanp-s.png", new BMap.Size(200,200),{imageOffset: new BMap.Size(-json.l,-json.t),infoWindowOffset:new BMap.Size(json.lb+5,1),offset:new BMap.Size(json.x,json.h)});
                            else if(json.type==-4)
                                var icon = new BMap.Icon("https://organold.oss-cn-shanghai.aliyuncs.com/img/donglanp-s.png", new BMap.Size(200,200),{imageOffset: new BMap.Size(-json.l,-json.t),infoWindowOffset:new BMap.Size(json.lb+5,1),offset:new BMap.Size(json.x,json.h)});
                            else if(json.type==-5)
                                var icon = new BMap.Icon("https://organold.oss-cn-shanghai.aliyuncs.com/img/pingjip-s.png", new BMap.Size(200,200),{imageOffset: new BMap.Size(-json.l,-json.t),infoWindowOffset:new BMap.Size(json.lb+5,1),offset:new BMap.Size(json.x,json.h)});
                            else if(json.type==-6)
                                var icon = new BMap.Icon("https://organold.oss-cn-shanghai.aliyuncs.com/img/pingyangp-s.png", new BMap.Size(200,200),{imageOffset: new BMap.Size(-json.l,-json.t),infoWindowOffset:new BMap.Size(json.lb+5,1),offset:new BMap.Size(json.x,json.h)});
                            else if(json.type==100)
                                var icon = new BMap.Icon("https://organold.oss-cn-shanghai.aliyuncs.com/img/star.png", new BMap.Size(45,45),{imageOffset: new BMap.Size(-json.l,-json.t),infoWindowOffset:new BMap.Size(json.lb+5,1),offset:new BMap.Size(json.x,json.h)});

                            // var icon = new BMap.Icon("http://map.baidu.com/image/us_mk_icon.png", new BMap.Size(json.w,json.h),{imageOffset: new BMap.Size(-json.l,-json.t),infoWindowOffset:new BMap.Size(json.lb+5,1),offset:new BMap.Size(json.x,json.h)})
                            //var icon = new BMap.Icon("http://api.map.baidu.com/lbsapi/creatmap/images/us_mk_icon.png", new BMap.Size(json.w,json.h),{imageOffset: new BMap.Size(-json.l,-json.t),infoWindowOffset:new BMap.Size(json.lb+5,1),offset:new BMap.Size(json.x,json.h)})

                            //var icon = new BMap.Icon("http://app.baidu.com/map/image/us_mk_icon.png", new BMap.Size(json.w,json.h),{imageOffset: new BMap.Size(-json.l,-json.t),infoWindowOffset:new BMap.Size(json.lb+5,1),offset:new BMap.Size(json.x,json.h)})
                            return icon;
                        }

                        //changeMarker
                        // var allOverlay = map.getOverlays();
                        // var len = map.getOverlays().length;
                        // var str = null;
                        //
                        // if(organMapIndex == 1) str="养老院";//老有所养
                        // else if(organMapIndex == 2) str="社区卫生站";//所医
                        // else if(organMapIndex == 3) str="助餐点";//所为
                        // else if(organMapIndex == 4) str="老年人学校";//所学
                        // else if(organMapIndex == 5) str="社区卫生站";//所乐
                        // for (var i = len; i >0; i--){
                        //     if (allOverlay[i] instanceof BMap.Marker)
                        //         if(allOverlay[i].getLabel().content.indexOf(str) == -1)
                        //         {
                        //             map.removeOverlay(map.getOverlays()[i]);
                        //
                        //         }
                        //
                        // }
                        //标注线数组
                        var plPoints = [{style:"solid",weight:4,color:"#f00",opacity:0.6,points:["121.383679|31.163464","121.388709|31.162908","121.391404|31.162629","121.393812|31.162908","121.397315|31.164043"]}
                            ,{style:"solid",weight:4,color:"#f00",opacity:0.6,points:["121.397333|31.164051","121.401106|31.16538","121.405418|31.166554","121.409226|31.168099","121.414437|31.155275","121.416296|31.150832"]}
                            ,{style:"solid",weight:4,color:"#f00",opacity:0.6,points:["121.416305|31.150917","121.415874|31.15067","121.415694|31.150516","121.416233|31.149063","121.416413|31.14829","121.416089|31.147672","121.414796|31.146436","121.410664|31.144674","121.408939|31.143593","121.406738|31.149844","121.408104|31.145826"]}
                            ,{style:"solid",weight:4,color:"#f00",opacity:0.6,points:["121.406882|31.149967","121.402723|31.147301","121.397944|31.146096","121.399848|31.138771","121.399776|31.138957"]}
                            ,{style:"solid",weight:4,color:"#f00",opacity:0.6,points:["121.399848|31.13874","121.400746|31.135247","121.399848|31.135155","121.396255|31.134196","121.396345|31.134212"]}
                            ,{style:"solid",weight:4,color:"#f00",opacity:0.6,points:["121.396381|31.134227","121.391961|31.13313"]}
                            ,{style:"solid",weight:4,color:"#f00",opacity:0.6,points:["121.391907|31.133161","121.390075|31.136499","121.38844|31.139636","121.388458|31.139636"]}
                            ,{style:"solid",weight:4,color:"#f00",opacity:0.6,points:["121.388422|31.139621","121.388206|31.140332","121.388026|31.143206","121.387119|31.153243"]}
                            ,{style:"solid",weight:4,color:"#f00",opacity:0.6,points:["121.387191|31.152996","121.385538|31.159547","121.383454|31.163379","121.383382|31.163503"]}
                        ];
                        //向地图中添加线函数
                        function addPolyline(){
                            for(var i=0;i<plPoints.length;i++){
                                var json = plPoints[i];
                                var points = [];
                                for(var j=0;j<json.points.length;j++){
                                    var p1 = json.points[j].split("|")[0];
                                    var p2 = json.points[j].split("|")[1];
                                    points.push(new BMap.Point(p1,p2));
                                }
                                var line = new BMap.Polyline(points,{strokeStyle:json.style,strokeWeight:json.weight,strokeColor:json.color,strokeOpacity:json.opacity});
                                map.addOverlay(line);
                            }
                        }
                        //添加多边形
                        function addPolygon(){
                            polygonOrg = new BMap.Polygon([
                                new BMap.Point(121.383679, 31.163464),
                                new BMap.Point(121.388709, 31.162908),
                                new BMap.Point(121.391404, 31.162629),
                                new BMap.Point(121.393812, 31.162908),

                                new BMap.Point(121.397315, 31.164043),
                                new BMap.Point(121.397333, 31.164051),
                                new BMap.Point(121.401106, 31.16538),
                                new BMap.Point(121.405418, 31.166554),
                                new BMap.Point(121.409226, 31.168099),
                                new BMap.Point(121.414437, 31.155275),
                                new BMap.Point(121.416296, 31.150832),
                                new BMap.Point(121.416305, 31.150917),

                                new BMap.Point(121.415874, 31.15067),
                                new BMap.Point(121.415694, 31.150516),
                                new BMap.Point(121.416233, 31.149063),
                                new BMap.Point(121.416413, 31.14829),
                                new BMap.Point(121.416089, 31.147672),
                                new BMap.Point(121.414796, 31.146436),
                                new BMap.Point(121.410664, 31.144674),
                                new BMap.Point(121.408939, 31.143593),
                                new BMap.Point(121.406738, 31.149844),
                                new BMap.Point(121.408104, 31.145826),
                                new BMap.Point(121.406882, 31.149967),
                                new BMap.Point(121.402723, 31.147301),
                                new BMap.Point(121.397944, 31.146096),
                                new BMap.Point(121.399848, 31.138771),

                                new BMap.Point(121.399776, 31.138957),
                                new BMap.Point(121.399848, 31.13874),
                                new BMap.Point(121.400746, 31.135247),
                                new BMap.Point(121.399848, 31.135155),
                                new BMap.Point(121.396255, 31.134196),
                                new BMap.Point(121.396345, 31.134212),
                                new BMap.Point(121.396381, 31.134227),
                                new BMap.Point(121.391961, 31.13313),
                                new BMap.Point(121.391907, 31.133161),
                                new BMap.Point(121.390075, 31.136499),
                                new BMap.Point(121.38844, 31.139636),
                                new BMap.Point(121.388458, 31.139636),
                                new BMap.Point(121.388422, 31.139621),
                                new BMap.Point(121.388206, 31.140332),
                                new BMap.Point(121.388026, 31.143206),
                                new BMap.Point(121.387119, 31.153243),

                                new BMap.Point(121.387191, 31.152996),
                                new BMap.Point(121.385538, 31.159547),
                                new BMap.Point(121.383454, 31.163379),
                                new BMap.Point(121.383382, 31.163503)


                            ], { strokeColor: getRandomColor(), strokeWeight: 3, strokeOpacity: 0.0, fillOpacity: 0.5,fillColor:"#FFFFFF" });
                            polygon_DongLan = new BMap.Polygon([
                                new BMap.Point(121.383661, 31.16351),
                                new BMap.Point(121.393865, 31.162707),
                                new BMap.Point(121.395446, 31.156217),
                                new BMap.Point(121.387038, 31.153065),

                                new BMap.Point(121.385385, 31.159987),
                                new BMap.Point(121.383661, 31.16351),
                                new BMap.Point(121.383661, 31.163448)

                            ], { strokeColor: getRandomColorDongLan(), strokeWeight: 3, strokeOpacity: 0.0, fillOpacity: 0.4,fillColor:"#DDA0DD" });
                            polygon_PingNan = new BMap.Polygon([
                                new BMap.Point(121.394656, 31.159678),
                                new BMap.Point(121.395446, 31.156217),
                                new BMap.Point(121.403567, 31.158319),
                                new BMap.Point(121.402489, 31.161532),

                                new BMap.Point(121.394656, 31.15974),


                            ], { strokeColor: getRandomColor(), strokeWeight: 3, strokeOpacity: 0.0, fillOpacity: 0.5,fillColor:"#EEAEEE" });
                            polygon_PingJi = new BMap.Polygon([
                                new BMap.Point(121.386966, 31.153189),
                                new BMap.Point(121.395446, 31.156156),
                                new BMap.Point(121.398034, 31.146266),
                                new BMap.Point(121.393219, 31.144412),

                                new BMap.Point(121.391135, 31.14367),
                                new BMap.Point(121.387973, 31.143175),
                                new BMap.Point(121.38711, 31.153127),
                                new BMap.Point(121.38711, 31.153189),


                            ], { strokeColor: getRandomColor(), strokeWeight: 3, strokeOpacity: 0.0, fillOpacity: 0.5,fillColor:"#FFD39B" });
                            polygon_PingYang = new BMap.Polygon([
                                new BMap.Point(121.38808, 31.143237),
                                new BMap.Point(121.391099, 31.143608),
                                new BMap.Point(121.397926, 31.146204),
                                new BMap.Point(121.400585, 31.135387),

                                new BMap.Point(121.391817, 31.133161),
                                new BMap.Point(121.388224, 31.140332),

                            ], { strokeColor: getRandomColor(), strokeWeight: 3, strokeOpacity: 0.0, fillOpacity: 0.5,fillColor:"#EE799F" });
                            polygon_XuHui = new BMap.Polygon([
                                new BMap.Point(121.40116, 31.165488),
                                new BMap.Point(121.405184, 31.166785),
                                new BMap.Point(121.409137, 31.168083),
                                new BMap.Point(121.41237, 31.160605),

                                new BMap.Point(121.403531, 31.158319),
                                new BMap.Point(121.401088, 31.165549),

                                new BMap.Point(121.40116, 31.165611),

                            ], { strokeColor: getRandomColor(), strokeWeight: 3, strokeOpacity: 0.0, fillOpacity: 0.5,fillColor:"#EEAEEE" });
                            polygon_WanYuan = new BMap.Polygon([
                                new BMap.Point(121.39541, 31.156341),
                                new BMap.Point(121.403459, 31.158319),
                                new BMap.Point(121.406406, 31.149789),
                                new BMap.Point(121.402309, 31.147379),

                                new BMap.Point(121.401447, 31.150655),
                                new BMap.Point(121.397135, 31.149295),

                                new BMap.Point(121.395554, 31.156341),

                            ], { strokeColor: getRandomColor(), strokeWeight: 3, strokeOpacity: 0.0, fillOpacity: 0.5,fillColor:"#EEAEEE" });
                            polygon_GuLong = new BMap.Polygon([
                                new BMap.Point(121.403459, 31.158504),
                                new BMap.Point(121.412227, 31.160667),
                                new BMap.Point(121.415676, 31.152571),
                                new BMap.Point(121.410358, 31.151396),

                                new BMap.Point(121.406334, 31.149666),
                                new BMap.Point(121.403459, 31.158442),

                                new BMap.Point(121.403531, 31.158504),

                            ], { strokeColor: getRandomColor(), strokeWeight: 3, strokeOpacity: 0.0, fillOpacity: 0.5,fillColor:"#C1FFC1" });
                            polygon_GuMei = new BMap.Polygon([
                                new BMap.Point(121.406334, 31.149789),
                                new BMap.Point(121.410933, 31.15152),
                                new BMap.Point(121.415676, 31.152633),
                                new BMap.Point(121.416395, 31.150964),

                                new BMap.Point(121.415964, 31.150778),
                                new BMap.Point(121.41582, 31.15016),

                                new BMap.Point(121.416539, 31.148182),

                                new BMap.Point(121.414958, 31.146513),
                                new BMap.Point(121.408777, 31.14367),

                                new BMap.Point(121.406478, 31.149851),

                            ], { strokeColor: getRandomColor(), strokeWeight: 3, strokeOpacity: 0.0, fillOpacity: 0.5,fillColor:"#63B8FF" });
                           // map.addOverlay(polygonOrg);
                            map.addOverlay(polygon_DongLan);
                            map.addOverlay(polygon_PingNan);
                            map.addOverlay(polygon_PingJi);
                            map.addOverlay(polygon_PingYang);
                            map.addOverlay(polygon_XuHui);
                            map.addOverlay(polygon_WanYuan);
                            map.addOverlay(polygon_GuLong);
                            map.addOverlay(polygon_GuMei);

                        }
                        function getRandomColor() {
                            //return "#" + ("00000" + ((Math.random() * 16777215 + 0.5) >> 0).toString(16)).slice(-6);
                            return "#FFFFFF";
                        }
                        function getRandomColorDongLan() {
                            //return "#" + ("00000" + ((Math.random() * 16777215 + 0.5) >> 0).toString(16)).slice(-6);
                            return "#FF3030";
                        }

                        initMap();//创建和初始化地图
                        map.setMapStyle({style:'midnight'});

                    }
                    function show_heat_map() {

                        $("#container").css("width",winWidth/4.22);
                        $("#container").css("height",winHeight/1.3);
                        var hmap = new BMap.Map("container");          // 创建地图实例
                        window.hmap=hmap;

                        var hpoint = new BMap.Point(121.401269,31.150527);
                        //var hpoint = new BMap.Point(121.401447|31.151412);
                        hmap.centerAndZoom(hpoint, 16);             // 初始化地图，设置中心点坐标和地图级别
                        hmap.enableScrollWheelZoom(); // 允许滚轮缩放

                        var jw1 = [1,2,3,13,45,59,60,113,63,66,67,84,85];
                        var jw2 = [87,88,89,90,135,97,98,99,100,101,102,103,104];
                        var jw3 = [105,106,107,108,119,120,121,122,123,124,125,126,134];
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
                                "isHealth_array":health,
                                "eyesight_array":eyesightArray,
                                "familyType_array":familyType,
                                "politicalStatus_array":politicalStatusArray,
                                "organId_array":organIdArray,
                                "secType_array":secTypeArray,
                                "thirdType_array":thirdTypeArray,
                                "forthType_array":forthTypeArray,
                                "fifthType_array" :fifthTypeArray,
                                "sixthType_array":sixthTypeArray,
                                "census_array":census,
                                "ageStart":ageStart,
                                "ageEnd":ageEnd,
                                "family_array":family,
                                "economic_array":economic,
                                "oldStatus_array":oldStatus,
                                "isVolunteer":isVolunteer,
                                "isService":isService,
                                "district_array":mapDistrict,
                                "jw_array":jw1

                            },
                            type: 'GET',
                            dataType: 'json',
                            async:false,
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
                                        {"lng":"121.392393","lat":"31.145568","count":jwData.平吉三村},
                                        {"lng":"121.411512","lat":"31.159194","count":jwData.古龙六居},
                                        {"lng":"121.411598","lat":"31.146782","count":jwData.古美九村},
                                        {"lng":"121.41470","lat":"31.151291","count":jwData.古美七村},
                                        {"lng":"121.410200","lat":"31.162142","count":jwData.华梅花苑},
                                        {"lng":"121.407256","lat":"31.166000","count":jwData.梅莲苑}
                                    ];
                                    heatPoints = heatPoints.concat(heatPoints1);
                                }
                            }
                        });
                        ajax6 = $.ajax({
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
                                "thirdType_array":thirdTypeArray,
                                "forthType_array":forthTypeArray,
                                "fifthType_array" :fifthTypeArray,
                                "sixthType_array":sixthTypeArray,
                                "census_array":census,
                                "ageStart":ageStart,
                                "ageEnd":ageEnd,
                                "family_array":family,
                                "economic_array":economic,
                                "isHealth_array":health,
                                "isVolunteer":isVolunteer,
                                "isService":isService,
                                "oldStatus_array":oldStatus,
                                "district_array":mapDistrict,
                                "jw_array":jw2

                            },
                            type: 'GET',
                            dataType: 'json',
                            async:false,
                            success: function (result) {
                                if(result.success == true){
                                    jwData = result.data;
                                    var  heatPoints2=[
                                        {"lng":"121.396912","lat":"31.143988","count":jwData.平阳二村},
                                        {"lng":"121.39388","lat":"31.139939","count":jwData.平阳三村},
                                        {"lng":"121.404052","lat":"31.151059","count":jwData.万源四居},
                                        {"lng":"121.399151","lat":"31.153805","count":jwData.万源一居},
                                        {"lng":"121.393436","lat":"31.157818","count":jwData.东兰二居},
                                        {"lng":"121.391183","lat":"31.153482","count":jwData.平吉四村},
                                        {"lng":"121.412186","lat":"31.155164","count":jwData.古龙四居},
                                        {"lng":"121.409878","lat":"31.145572","count":jwData.古美八村},
                                        {"lng":"121.410402","lat":"31.148453","count":jwData.古美四村},
                                        {"lng":"121.397204","lat":"31.159934","count":jwData.平南三居},
                                        {"lng":"121.400571","lat":"31.160467","count":jwData.平南一居},
                                        {"lng":"121.397188","lat":"31.136772","count":jwData.平阳六村},
                                        {"lng":"121.396699","lat":"31.138846","count":jwData.平阳四村}
                                    ];
                                    heatPoints=heatPoints.concat(heatPoints2);
                                    // heatmapOverlay1.show();
                                }
                            }
                        });
                        ajax7 = $.ajax({
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
                                "thirdType_array":thirdTypeArray,
                                "forthType_array":forthTypeArray,
                                "fifthType_array" :fifthTypeArray,
                                "sixthType_array":sixthTypeArray,
                                "census_array":census,
                                "ageStart":ageStart,
                                "ageEnd":ageEnd,
                                "family_array":family,
                                "economic_array":economic,
                                "isHealth_array":health,
                                "isVolunteer":isVolunteer,
                                "isService":isService,
                                "oldStatus_array":oldStatus,
                                "district_array":mapDistrict,
                                "jw_array":jw3

                            },
                            type: 'GET',
                            dataType: 'json',
                            async:false,
                            success: function (result) {
                                if(result.success == true){
                                    jwData = result.data;
                                    var  heatPoints3=[
                                        {"lng":"121.389500","lat":"31.141276","count":jwData.平阳一村},
                                        {"lng":"121.403865","lat":"31.152716","count":jwData.万源三居},
                                        {"lng":"121.405819","lat":"31.155885","count":jwData.古龙五村},
                                        {"lng":"121.395925","lat":"31.148518","count":jwData.平吉六村},
                                        {"lng":"121.405043","lat":"31.162622","count":jwData.华一新城},
                                        {"lng":"121.388900","lat":"31.14893","count":jwData.平吉二村},
                                        {"lng":"121.3945","lat":"31.151394","count":jwData.平吉五村},
                                        {"lng":"121.409875","lat":"31.147900","count":jwData.古美三村},
                                        {"lng":"121.414226","lat":"31.1478032","count":jwData.古美十村},
                                        {"lng":"121.397218","lat":"31.158308","count":jwData.平南二居},
                                        {"lng":"121.393407","lat":"31.13485","count":jwData.平阳五村},
                                        {"lng":"121.388900","lat":"31.151069","count":jwData.平吉一村},
                                        {"lng":"121.401069","lat":"31.155103","count":jwData.万源二居}
                                    ];
                                    heatPoints =  heatPoints.concat(heatPoints3);
                                    //  heatmapOverlay2.show();
                                }
                            }
                        });
                        hpoints = heatPoints;
                        // hpoints = [
                        //
                        //     {"lng":"121.389133","lat":"31.158804","count":"275"},
                        //     {"lng":"121.410277","lat":"31.151814","count":"275"},
                        //     {"lng":"121.409142","lat":"31.148518","count":"275"},
                        //     {"lng":"121.411089","lat":"31.152975","count":"275"},
                        //     {"lng":"121.406289","lat":"31.155351","count":"275"},
                        //     {"lng":"121.387235","lat":"31.157819","count":"275"},
                        //     {"lng":"121.388044","lat":"31.161102","count":"275"},
                        //     {"lng":"121.392393","lat":"31.145568","count":"275"},
                        //     {"lng":"121.411512","lat":"31.159194","count":"275"},
                        //     {"lng":"121.411598","lat":"31.146782","count":"275"},
                        //     {"lng":"121.41470","lat":"31.151291","count":"275"},
                        //     {"lng":"121.410200","lat":"31.162142","count":"275"},
                        //     {"lng":"121.407256","lat":"31.166000","count":"275"},
                        //     {"lng":"121.396912","lat":"31.143988","count":"275"},
                        //     {"lng":"121.39388","lat":"31.139939","count":"275"},
                        //     {"lng":"121.404052","lat":"31.151059","count":"275"},
                        //     {"lng":"121.399151","lat":"31.153805","count":"275"},
                        //     {"lng":"121.393436","lat":"31.157818","count":"275"},
                        //     {"lng":"121.391183","lat":"31.153482","count":"275"},
                        //     {"lng":"121.412186","lat":"31.155164","count":"275"},
                        //     {"lng":"121.409878","lat":"31.145572","count":"275"},
                        //     {"lng":"121.410402","lat":"31.148453","count":"275"},
                        //     {"lng":"121.397204","lat":"31.159934","count":"275"},
                        //     {"lng":"121.400571","lat":"31.160467","count":"275"},
                        //     {"lng":"121.397188","lat":"31.136772","count":"275"},
                        //     {"lng":"121.396699","lat":"31.138846","count":"275"},
                        //     {"lng":"121.389500","lat":"31.141276","count":"275"},
                        //     {"lng":"121.403865","lat":"31.152716","count":"275"},
                        //     {"lng":"121.405819","lat":"31.155885","count":"275"},
                        //     {"lng":"121.395925","lat":"31.148518","count":"275"},
                        //     {"lng":"121.405043","lat":"31.162622","count":"275"},
                        //     {"lng":"121.388900","lat":"31.14893","count":"275"},
                        //     {"lng":"121.3945","lat":"31.151394","count":"275"},
                        //     {"lng":"121.408875","lat":"31.147336","count":"275"},
                        //     {"lng":"121.414226","lat":"31.1478032","count":"275"},
                        //     {"lng":"121.397218","lat":"31.158308","count":"275"},
                        //     {"lng":"121.393407","lat":"31.13485","count":"275"},
                        //     {"lng":"121.388900","lat":"31.151069","count":"275"},
                        //     {"lng":"121.401069","lat":"31.155103","count":"275"}
                        //
                        //
                        // ];
                        hpointsFemale =[
                            {"lng":"121.404807","lat":"31.153621","count":"70000"},//古美一村 121.409142,31.149521
                            {"lng":"121.392015","lat":"31.139096","count":"170"},//古龙新村第一 121.407318,31.151049
                            {"lng":"121.405094","lat":"31.160605","count":"20"},//古美七村社区敬老居委会121.415072,31.151204
                            {"lng":"121.403801","lat":"31.154981","count":"52"},//古美七村居委会 121.415121,31.151302
                            {"lng":"121.390003","lat":"31.158875","count":"91"},//闵行区梅陇镇莲花公寓居委会民间组织... 121.404593,31.146951
                            {"lng":"121.413646","lat":"31.149604","count":"16"},//闵行区梅陇镇莲花公寓居委会人民调解委员会 121.404507,31.146978
                            {"lng":"121.396039","lat":"31.145463","count":"87"},//闵行区梅陇镇莲花公寓居委会红十字服务站 121.404476,31.146916
                            {"lng":"121.410125","lat":"31.143917","count":"241"},//梅陇第一居委会(梅陇镇招标投标办公室北) 121.417656,31.143836
                            {"lng":"121.388494","lat":"31.149295","count":"561"},//古美路第三居委会 121.40686,31.160799

                            {"lng":"121.414293","lat":"31.152262","count":"701"},//古美路第一居委会 121.405082,31.161101
                            {"lng":"121.387631","lat":"31.161223","count":"261"},//虹梅街道古一居委会消防联防工作站 121.40506,31.161147
                            {"lng":"121.408544","lat":"31.16419","count":"1002"},//凌云工商所-消费者权益保护梅苑二居... 121.424154,31.1468
                            {"lng":"121.388422","lat":"31.154796","count":"981"},//南方新村-第二居委会 121.402299,31.140643
                            {"lng":"121.400351","lat":"31.159246","count":"151"},//南方新村第二居委会-民间组织预警工作小组 121.402298,31.140632
                            {"lng":"121.395464","lat":"31.141136","count":"871"},//闵行区民政局敬老居委会 121.402209,31.140649
                            {"lng":"121.402363","lat":"31.153003","count":"1673"},//闵行区梅陇镇梅陇第二居委会红十字服务站 121.420877,31.141411
                            {"lng":"121.399992","lat":"31.149851","count":"163"},//平南新村第一居委会人口和家庭计划指导室 121.401021,31.160454
                        ];

                        hpointsMale=[
                            {"lng":"121.412927","lat":"31.156217","count":"166"},//梅陇第二居委会 121.421009,31.14131
                            {"lng":"121.408184","lat":"31.160296","count":"722"},//南方新村-第二居委会 121.400571,31.160467

                            {"lng":"121.404717","lat":"31.149109","count":"70"},//梅莲苑居委会(虹梅路) 121.410288,31.16443
                            {"lng":"121.397243","lat":"31.143423","count":"70"},//世纪苑居委会 121.412667,31.137388
                            {"lng":"121.408885","lat":"31.147193","count":"797"},//梅陇三村居委会 121.422597,31.141242
                            {"lng":"121.397099","lat":"31.162892","count":"761"},//平阳二村居委会 121.396912,31.143988
                            {"lng":"121.410538","lat":"31.152323","count":"176"},//长丰坊-居委会 121.423135,31.160241
                            {"lng":"121.395015","lat":"31.139528","count":"251"},//联莘居委会 121.414283,31.165271
                            {"lng":"121.414059","lat":"31.149295","count":"461"},//华东理工大学第一居委会 121.427733,31.14631
                            {"lng":"121.389266","lat":"31.153374","count":"621"},//梅莲苑居委会(漕宝路) 121.407256,31.166335
                            {"lng":"121.404933","lat":"31.152385","count":"361"},//寿昌山居委会121.427516,31.157945{"lng":"121.389374","lat":"31.148221","count":"70"},//世纪苑居委会 121.409142,31.149521
                            {"lng":"121.410754","lat":"31.160544","count":"772"},//东兰新村第二居委会 121.409989,31.133972
                        ];

                        hpointsFeiHuJi=[
                            {"lng":"121.410125","lat":"31.143917","count":"241"},//梅陇第一居委会(梅陇镇招标投标办公室北) 121.417656,31.143836
                            {"lng":"121.388494","lat":"31.149295","count":"561"},//古美路第三居委会 121.40686,31.160799
                            {"lng":"121.412927","lat":"31.156217","count":"166"},//梅陇第二居委会 121.421009,31.14131
                            {"lng":"121.408184","lat":"31.160296","count":"722"},//南方新村-第二居委会 121.400571,31.160467
                            {"lng":"121.389266","lat":"31.153374","count":"621"},//梅莲苑居委会(漕宝路) 121.407256,31.166335
                            {"lng":"121.404933","lat":"31.152385","count":"361"},//寿昌山居委会121.427516,31.157945{"lng":"121.389374","lat":"31.148221","count":"70"},//世纪苑居委会 121.409142,31.149521
                            {"lng":"121.410754","lat":"31.160544","count":"772"},//东兰新村第二居委会 121.409989,31.133972


                        ];
                        hpointsHuJi=[
                            {"lng":"121.404807","lat":"31.153621","count":"70000"},//古美一村 121.409142,31.149521
                            {"lng":"121.392015","lat":"31.139096","count":"170"},//古龙新村第一 121.407318,31.151049
                            {"lng":"121.405094","lat":"31.160605","count":"20"},//古美七村社区敬老居委会121.415072,31.151204
                            {"lng":"121.403801","lat":"31.154981","count":"52"},//古美七村居委会 121.415121,31.151302
                            {"lng":"121.390003","lat":"31.158875","count":"91"},//闵行区梅陇镇莲花公寓居委会民间组织... 121.404593,31.146951
                            {"lng":"121.413646","lat":"31.149604","count":"16"},//闵行区梅陇镇莲花公寓居委会人民调解委员会 121.404507,31.146978
                            {"lng":"121.396039","lat":"31.145463","count":"87"},//闵行区梅陇镇莲花公寓居委会红十字服务站 121.404476,31.146916
                            {"lng":"121.414293","lat":"31.152262","count":"701"},//古美路第一居委会 121.405082,31.161101
                            {"lng":"121.387631","lat":"31.161223","count":"261"},//虹梅街道古一居委会消防联防工作站 121.40506,31.161147
                            {"lng":"121.408544","lat":"31.16419","count":"1002"},//凌云工商所-消费者权益保护梅苑二居... 121.424154,31.1468
                            {"lng":"121.388422","lat":"31.154796","count":"981"},//南方新村-第二居委会 121.402299,31.140643
                            {"lng":"121.400351","lat":"31.159246","count":"151"},//南方新村第二居委会-民间组织预警工作小组 121.402298,31.140632
                            {"lng":"121.395464","lat":"31.141136","count":"871"},//闵行区民政局敬老居委会 121.402209,31.140649
                            {"lng":"121.402363","lat":"31.153003","count":"1673"},//闵行区梅陇镇梅陇第二居委会红十字服务站 121.420877,31.141411
                            {"lng":"121.399992","lat":"31.149851","count":"163"},//平南新村第一居委会人口和家庭计划指导室 121.401021,31.160454
                            {"lng":"121.404717","lat":"31.149109","count":"70"},//梅莲苑居委会(虹梅路) 121.410288,31.16443
                            {"lng":"121.397243","lat":"31.143423","count":"70"},//世纪苑居委会 121.412667,31.137388
                            {"lng":"121.408885","lat":"31.147193","count":"797"},//梅陇三村居委会 121.422597,31.141242
                            {"lng":"121.397099","lat":"31.162892","count":"761"},//平阳二村居委会 121.396912,31.143988
                            {"lng":"121.410538","lat":"31.152323","count":"176"},//长丰坊-居委会 121.423135,31.160241
                            {"lng":"121.395015","lat":"31.139528","count":"251"},//联莘居委会 121.414283,31.165271
                            {"lng":"121.414059","lat":"31.149295","count":"461"},//华东理工大学第一居委会 121.427733,31.14631


                        ];


                        if(!isSupportCanvas()){
                            alert('热力图目前只支持有canvas支持的浏览器,您所使用的浏览器不能使用热力图功能~')
                        }
                        //详细的参数,可以查看heatmap.js的文档 https://github.com/pa7/heatmap.js/blob/master/README.md
                        //参数说明如下:
                        /* visible 热力图是否显示,默认为true
                         * opacity 热力的透明度,1-100
                         * radius 势力图的每个点的半径大小
                         * gradient  {JSON} 热力图的渐变区间 . gradient如下所示
                         *  {
                                .2:'rgb(0, 255, 255)',
                                .5:'rgb(0, 110, 255)',
                                .8:'rgb(100, 0, 255)'
                            }
                            其中 key 表示插值的位置, 0~1.
                                value 为颜色值.
                         */
                        heatmapOverlay = new BMapLib.HeatmapOverlay({"radius":75});
                        hmap.addOverlay(heatmapOverlay);
                        heatmapOverlay.setDataSet({data:hpoints,max:200});

                        hmap.enableDragging();//启用地图拖拽事件，默认启用(可不写)
                        hmap.enableScrollWheelZoom();//启用地图滚轮放大缩小
                        hmap.enableDoubleClickZoom();//启用鼠标双击放大，默认启用(可不写)
                        hmap.enableKeyboard();//启用键盘上下左右键移动地图



                        //closeHeatmap();

                        //判断浏览区是否支持canvas
                        function isSupportCanvas(){
                            var elem = document.createElement('canvas');
                            return !!(elem.getContext && elem.getContext('2d'));
                        }

                        function setGradient(){
                            /*格式如下所示:
                            {
                                0:'rgb(102, 255, 0)',
                                .5:'rgb(255, 170, 0)',
                                1:'rgb(255, 0, 0)'
                            }*/
                            var gradient = {};
                            var colors = document.querySelectorAll("input[type='color']");
                            colors = [].slice.call(colors,0);
                            colors.forEach(function(ele){
                                gradient[ele.getAttribute("data-key")] = ele.value;
                            });
                            heatmapOverlay.setOptions({"gradient":gradient});
                        }

                        addHmapControl();
                        heatmapOverlay.show();

                        addPolygon();//多边形覆盖物
                        addPolyline();//向地图中添加线
                        addHmapControl();
                        //地图控件添加函数：
                        function addHmapControl(){
                            //向地图中添加缩放控件
                            var hctrl_nav = new BMap.NavigationControl({anchor:BMAP_ANCHOR_BOTTOM_RIGHT,type:BMAP_NAVIGATION_CONTROL_SMALL});
                            hmap.addControl(hctrl_nav);
                            //向地图中添加缩略图控件
                            // var hctrl_ove = new BMap.OverviewMapControl({anchor:BMAP_ANCHOR_BOTTOM_RIGHT,isOpen:1});
                            // hmap.addControl(hctrl_ove);
                            // //向地图中添加比例尺控件
                            // var hctrl_sca = new BMap.ScaleControl({anchor:BMAP_ANCHOR_BOTTOM_LEFT});
                            // hmap.addControl(hctrl_sca);
                        }

                        //标注线数组
                        var plPoints = [{style:"solid",weight:4,color:"#f00",opacity:0.6,points:["121.383679|31.163464","121.388709|31.162908","121.391404|31.162629","121.393812|31.162908","121.397315|31.164043"]}
                            ,{style:"solid",weight:4,color:"#f00",opacity:0.6,points:["121.397333|31.164051","121.401106|31.16538","121.405418|31.166554","121.409226|31.168099","121.414437|31.155275","121.416296|31.150832"]}
                            ,{style:"solid",weight:4,color:"#f00",opacity:0.6,points:["121.416305|31.150917","121.415874|31.15067","121.415694|31.150516","121.416233|31.149063","121.416413|31.14829","121.416089|31.147672","121.414796|31.146436","121.410664|31.144674","121.408939|31.143593","121.406738|31.149844","121.408104|31.145826"]}
                            ,{style:"solid",weight:4,color:"#f00",opacity:0.6,points:["121.406882|31.149967","121.402723|31.147301","121.397944|31.146096","121.399848|31.138771","121.399776|31.138957"]}
                            ,{style:"solid",weight:4,color:"#f00",opacity:0.6,points:["121.399848|31.13874","121.400746|31.135247","121.399848|31.135155","121.396255|31.134196","121.396345|31.134212"]}
                            ,{style:"solid",weight:4,color:"#f00",opacity:0.6,points:["121.396381|31.134227","121.391961|31.13313"]}
                            ,{style:"solid",weight:4,color:"#f00",opacity:0.6,points:["121.391907|31.133161","121.390075|31.136499","121.38844|31.139636","121.388458|31.139636"]}
                            ,{style:"solid",weight:4,color:"#f00",opacity:0.6,points:["121.388422|31.139621","121.388206|31.140332","121.388026|31.143206","121.387119|31.153243"]}
                            ,{style:"solid",weight:4,color:"#f00",opacity:0.6,points:["121.387191|31.152996","121.385538|31.159547","121.383454|31.163379","121.383382|31.163503"]}
                        ];
                        //向地图中添加线函数
                        function addPolyline(){
                            for(var i=0;i<plPoints.length;i++){
                                var json = plPoints[i];
                                var points = [];
                                for(var j=0;j<json.points.length;j++){
                                    var p1 = json.points[j].split("|")[0];
                                    var p2 = json.points[j].split("|")[1];
                                    points.push(new BMap.Point(p1,p2));
                                }
                                var line = new BMap.Polyline(points,{strokeStyle:json.style,strokeWeight:json.weight,strokeColor:json.color,strokeOpacity:json.opacity});
                                hmap.addOverlay(line);
                            }
                        }
                        //添加多边形
                        function addPolygon(){
                            var polygon1 = new BMap.Polygon([
                                new BMap.Point(121.383679, 31.163464),
                                new BMap.Point(121.388709, 31.162908),
                                new BMap.Point(121.391404, 31.162629),
                                new BMap.Point(121.393812, 31.162908),

                                new BMap.Point(121.397315, 31.164043),
                                new BMap.Point(121.397333, 31.164051),
                                new BMap.Point(121.401106, 31.16538),
                                new BMap.Point(121.405418, 31.166554),
                                new BMap.Point(121.409226, 31.168099),
                                new BMap.Point(121.414437, 31.155275),
                                new BMap.Point(121.416296, 31.150832),
                                new BMap.Point(121.416305, 31.150917),

                                new BMap.Point(121.415874, 31.15067),
                                new BMap.Point(121.415694, 31.150516),
                                new BMap.Point(121.416233, 31.149063),
                                new BMap.Point(121.416413, 31.14829),
                                new BMap.Point(121.416089, 31.147672),
                                new BMap.Point(121.414796, 31.146436),
                                new BMap.Point(121.410664, 31.144674),
                                new BMap.Point(121.408939, 31.143593),
                                new BMap.Point(121.406738, 31.149844),
                                new BMap.Point(121.408104, 31.145826),
                                new BMap.Point(121.406882, 31.149967),
                                new BMap.Point(121.402723, 31.147301),
                                new BMap.Point(121.397944, 31.146096),
                                new BMap.Point(121.399848, 31.138771),

                                new BMap.Point(121.399776, 31.138957),
                                new BMap.Point(121.399848, 31.13874),
                                new BMap.Point(121.400746, 31.135247),
                                new BMap.Point(121.399848, 31.135155),
                                new BMap.Point(121.396255, 31.134196),
                                new BMap.Point(121.396345, 31.134212),
                                new BMap.Point(121.396381, 31.134227),
                                new BMap.Point(121.391961, 31.13313),
                                new BMap.Point(121.391907, 31.133161),
                                new BMap.Point(121.390075, 31.136499),
                                new BMap.Point(121.38844, 31.139636),
                                new BMap.Point(121.388458, 31.139636),
                                new BMap.Point(121.388422, 31.139621),
                                new BMap.Point(121.388206, 31.140332),
                                new BMap.Point(121.388026, 31.143206),
                                new BMap.Point(121.387119, 31.153243),

                                new BMap.Point(121.387191, 31.152996),
                                new BMap.Point(121.385538, 31.159547),
                                new BMap.Point(121.383454, 31.163379),
                                new BMap.Point(121.383382, 31.163503)


                            ], { strokeColor: getRandomColor(), strokeWeight: 3, strokeOpacity: 0.0, fillOpacity: 0.5,fillColor:"#FFFFFF" });
                            hmap.addOverlay(polygon1);
                            hmap.setMapStyle({style:'midnight'});
                            //
                        }
                        function getRandomColor() {
                            //return "#" + ("00000" + ((Math.random() * 16777215 + 0.5) >> 0).toString(16)).slice(-6);
                            return "#FFFFFF";
                        }
                        heatmapOverlay.show();
                        //addHmapControl();//向地图添加控件
                    }
                </script>
            <#--heatmap-->
            </div>
        </div>

