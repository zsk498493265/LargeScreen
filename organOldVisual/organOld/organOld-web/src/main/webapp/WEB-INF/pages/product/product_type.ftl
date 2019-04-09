<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <#include "../common/head.ftl" />
    <link href="/css/style.min.css?v=4.0.0" rel="stylesheet">
    <link href="/static/css/common_table.css" rel="stylesheet">
    <link href="/static/css/oldman/base.css" rel="stylesheet">
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5><small></small></h5>
                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                        <a class="close-link">
                            <i class="fa fa-times"></i>
                        </a>
                    </div>
                </div>
                <div class="ibox-content">
                    <div>
                        <button onclick="change(1,this)" class="btn btn-primary auto" index="1">商品名称</button>
                        <button onclick="change(2,this)" class="btn btn-primary auto" index="2">二级类别</button>
                        <button onclick="change(3,this)" class="btn btn-primary auto" index="3">一级类别</button>
                    </div>
                    <div>
                        <a href="javascript:void(0);" class="btn btn-primary " onclick="add()">添加</a>
                        <a onclick="del('/product/type/del')"  href="javascript:void(0);" class="btn btn-primary ">删除</a>
                    </div>
                    <div class="table-responsive table-1">
                        <table class="table table-striped table-bordered table-hover dataTables-example text-nowrap">
                            <thead>
                            <tr>
                                <th  class="start"><input type="checkbox" class="checktd" onclick="thCheck(this)" ></th>
                                <th class="th3">一级类别</th>
                                <th class="th2">二级类别</th>
                                <th>名称</th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
<#include "add_product_type.ftl"/>
<script>
    var type="${type!'0'}";
    $(".auto").each(function () {
       if($(this).attr("index").trim()==type){
            $(this).prop("disabled","true");
        }
    });
</script>
<script src="/js/content.min.js?v=1.0.0"></script>
<script src="/static/js/common.js"></script>
<script src="/static/js/product/product_type.js" ></script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>

</body>

</html>