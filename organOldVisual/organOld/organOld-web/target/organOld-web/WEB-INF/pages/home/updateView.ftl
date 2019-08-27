<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <#include "../common/head.ftl" />

    <link href="/css/style.min.css?v=4.0.0" rel="stylesheet">
    <link href="/static/css/common_table.css" rel="stylesheet">
    <style>
        .bootstrap-select:not([class*="span"]):not([class*="col-"]):not([class*="form-control"]){
            width: 80% !important;
        }
    </style>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <button onclick="updateView()">更新数据</button>
                </div>
                <div class="ibox-title">
                    <form method="post" action="/visual/data/updateOrgAndNews" class="form-horizontal"  enctype="multipart/form-data">
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">机构信息</label>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">名称</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" value="" name="name"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">简介</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" value="" name="content"/>
                            </div>
                        </div>
                        <#--<div class="hr-line-dashed"></div>-->
                        <div class="form-group">
                            <label class="col-sm-2 control-label">照片</label>
                            <div class="col-sm-8">
                                <input type="file" class="form-control" value="" name="pic"/>
                            </div>
                        </div>

                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-2">
                                <button class="btn btn-primary" type="submit">提交</button>
                            </div>
                        </div>
                    </form>

                    <#--<label class="control-label"id="zc">新闻一内容更改：</label>-->
                    <#--<input id="news1_text"></input>-->
                    <#--<br>-->
                    <#--<label class="control-label"id="zc">新闻一图片更改：</label>-->
                    <#--<input type="file" id="news1_pic"></input>-->
                    <#--<button onclick="updateOrganAndNews(1)">确定更改</button>-->

                </div>
                <#--<div class="ibox-title">-->
                    <#--<label class="control-label"id="zc">新闻二内容更改：</label>-->
                    <#--<input id="news2_text"></input>-->
                    <#--<button onclick="updateOrganAndNews(2)">确定更改</button>-->
                <#--</div>-->
                <div class="ibox-title">
                    <label class="control-label"id="zc">机构介绍更改：</label>
                    <label class="control-label"id="zc">机构名：</label>
                    <select name="" id="jigou">
                        <option value="古美片区">古美片区</option>
                        <option value="古龙片区">古龙片区</option>
                        <option value="平南片区">平南片区</option>
                        <option value="东兰片区">东兰片区</option>
                        <option value="平吉片区">平吉片区</option>
                        <option value="平阳片区">平阳片区</option>
                        <option value="莲花敬老院">莲花敬老院</option>
                        <option value="古美敬老院">古美敬老院</option>
                        <option value="平阳敬老院">平阳敬老院</option>
                        <option value="乐健长者照护之家">乐健长者照护之家</option>
                        <option value="艾维康长者照护之家">艾维康长者照护之家</option>
                        <option value="智慧坊长者照护之家">智慧坊长者照护之家</option>
                        <option value="东兰一居">东兰一居</option>
                        <option value="东兰一居">东兰一居</option>
                        <option value="古龙一居">古龙一居</option>
                        <option value="古美一村">古美一村</option>
                        <option value="古龙二居">古龙二居</option>
                        <option value="古龙三居">古龙三居</option>
                        <option value="东兰三居">东兰三居</option>
                        <option value="东兰四居">东兰四居</option>
                        <option value="平吉三村">平吉三村</option>
                        <option value="古龙六居">古龙六居</option>
                        <option value="古美九村">古美九村</option>
                        <option value="古美七村">古美七村</option>
                        <option value="华梅花苑">华梅花苑</option>
                        <option value="梅莲苑">梅莲苑</option>
                        <option value="平阳二村">平阳二村</option>
                        <option value="平阳三村">平阳三村</option>
                        <option value="万源四居">万源四居</option>

                        <option value="万源一居">万源一居</option>
                        <option value="东兰二居">东兰二居</option>
                        <option value="平吉四村">平吉四村</option>
                        <option value="古龙四居">古龙四居</option>
                        <option value="古美八村">古美八村</option>
                        <option value="古美四村">古美四村</option>
                        <option value="平南三居">平南三居</option>
                        <option value="平南一居">平南一居</option>
                        <option value="平阳六村">平阳六村</option>
                        <option value="平阳四村">平阳四村</option>
                        <option value="平阳一村">平阳一村</option>
                        <option value="万源三居">万源三居</option>
                        <option value="古龙五居">古龙五居</option>
                        <option value="平吉六村">平吉六村</option>
                        <option value="华一新城">华一新城</option>
                        <option value="平吉二村">平吉二村</option>
                        <option value="平吉五村">平吉五村</option>
                        <option value="古美三村">古美三村</option>
                        <option value="古美十村">古美十村</option>
                        <option value="平南二居">平南二居</option>

                        <option value="平阳五村">平阳五村</option>
                        <option value="平吉一村">平吉一村</option>
                        <option value="万源二居">万源二居</option>
                        <option value="古美路街道办事处">古美路街道办事处</option>


                    </select>
                    <label class="control-label"id="zc">机构介绍更改：</label>
                    <input id="organ_text"></input>

                    <button onclick="updateOrganAndNews(3)">确定更改</button>
                </div>
            </div>
        </div>
    </div>

</div>
<script>
    function updateView(){
        $.ajax({
            type: "GET",
            url: "/visual/data/updateVisualData",
            dataType: "json",
            async: false,
            success: function (data) {
                alert("操作成功");
            }
        });
    }

    function updateOrganAndNews(type) {
        if(type==1){
            var name="新闻一";
            var content=$(" input[ id='news1_text' ] ").val();
        }else if(type==2){
            var name="新闻二";
            var content=$(" input[ id='news2_text' ] ").val();
        }else{
            var name=document.getElementById("jigou").value
            var content=$(" input[ id='organ_text' ] ").val();
        }
        $.ajax({
            url: "/visual/data/updateOrgAndNews",//这个就是请求地址对应sAjaxSourc
            data : {
                "name" : name,
                "content" : content,
            },
            type: 'GET',
            dataType: 'json',
            async:false,
            success: function (result) {
                if(result.success == true){
                    alert("修改成功");

                }
            }
        });

    }


</script>
<#--<#include "../spinner.ftl"/>-->
<#--<#include "home_oldman_import_type.ftl"/>-->
<#--<#include "add_oldman.ftl"/>-->
<#--<script src="/js/content.min.js?v=1.0.0"></script>-->
<#--<script src="/static/js/home/home_man_all.js" ></script>-->
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>

</body>

</html>