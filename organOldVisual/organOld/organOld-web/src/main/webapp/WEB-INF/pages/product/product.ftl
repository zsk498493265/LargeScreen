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
                    <h5>商品管理 <small></small></h5>
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
                            <a onclick="add()" href="javascript:void(0);" class="btn btn-primary ">添加</a>
                            <a onclick="del('/product/del')" href="javascript:void(0);" class="btn btn-primary ">删除</a>
                            <a  href="javascript:void(0);" id="search" class="btn btn-primary ">搜索</a>
                        </div>
                        <div class="row">
                            <div class="col-sm-4">
                                <input class="search form-control inp" type="text" placeholder="模糊匹配">
                            </div>
                        </div>
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover dataTables-example text-nowrap">
                            <thead>
                            <tr>
                                <th><input type='checkbox' onclick="thCheck(this)" /></th>
                                <#--<th>序号</th>-->
                                <th>一级类别</th>
                                <th>二级类别</th>
                                <th>名称</th>
                                <th>价格</th>
                                <th>描述</th>
                                <th>图片</th>
                                <th>更新时间</th>
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

<#include "product_add.ftl" />
<script>
    var organId=${(organId?c)!0};
</script>
<script src="/js/content.min.js?v=1.0.0"></script>
<script src="/static/js/common.js"></script>
<script src="/static/js/product/product.js" ></script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>

</body>

</html>