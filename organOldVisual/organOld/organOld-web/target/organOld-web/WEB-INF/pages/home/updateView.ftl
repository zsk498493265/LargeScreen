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


</script>
<#--<#include "../spinner.ftl"/>-->
<#--<#include "home_oldman_import_type.ftl"/>-->
<#--<#include "add_oldman.ftl"/>-->
<#--<script src="/js/content.min.js?v=1.0.0"></script>-->
<#--<script src="/static/js/home/home_man_all.js" ></script>-->
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>

</body>

</html>