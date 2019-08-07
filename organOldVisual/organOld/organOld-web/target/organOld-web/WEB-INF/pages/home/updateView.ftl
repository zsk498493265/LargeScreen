<!DOCTYPE html>
<html>

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
                    <label class="control-label"id="zc">新闻一内容更改：</label>
                    <input id="news1_text></input>
                    <button onclick="updateOrganAndNews(1)">确定更改</button>

                </div>
                <div class="ibox-title">
                    <label class="control-label"id="zc">新闻二内容更改：</label>
                    <input id="news2_text></input>
                    <button onclick="updateOrganAndNews(2)">确定更改</button>
                </div>
                <div class="ibox-title">
                    <label class="control-label"id="zc">机构介绍更改：</label>
                    <label class="control-label"id="zc">机构名：</label>
                    <select name="tigong" id="tigong">
                        <option value="null">--全部--</option>
                        <option value="喜剧">喜剧</option>
                        <option value="动作">动作</option>
                        <option value="未知">未知</option>
                        <option value="其他">其他</option>
                    </select>

                    <input id="organ_name"></input>
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
            var name=$(" input[ id='organ_name' ] ").val();
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