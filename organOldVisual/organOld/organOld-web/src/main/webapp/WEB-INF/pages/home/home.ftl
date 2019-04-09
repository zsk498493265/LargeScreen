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
                    <h5> ${title}</h5>
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
                        <a onclick="addHome()" href="javascript:void(0);" class="btn btn-primary ">添加</a>
                        <a onclick="del('/home/${type}/del')" href="javascript:void(0);" class="btn btn-primary ">删除</a>
                        <#if type==4 || type==5>
                        <a  href="javascript:void(0);" id="search" class="btn btn-primary" >搜索</a>
                        </#if>
                    </div>
                    <#if type==4 || type==5>
                        <div class="row" >
                            <div class="col-sm-4">
                                <input class="search form-control inp" type="text" placeholder="模糊匹配">
                            </div>
                        </div>
                    </#if>

                    <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover dataTables-example text-nowrap">
                            <thead>
                            <tr>
                                <th><input type='checkbox' class="checktd" onclick="thCheck(this)" /></th>
                                <#if type==1>
                                    <th>服务项目</th>
                                <#elseif type==3>
                                    <th>名称</th>
                                <#elseif type==2>
                                    <th>长护险级别</th>
                                <#elseif type==4>
                                    <th>医生姓名</th>
                                    <th>所在医院</th>
                                <#elseif type==5>
                                    <th>服务医院</th>
                                </#if>
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

<#include "add_home.ftl"/>
<script>
    var typeHome="${type}";
    $('.search_select').searchableSelect();
</script>

<script src="/js/content.min.js?v=1.0.0"></script>
<script src="/static/js/common.js" ></script>
<script src="/static/js/home/home.js" ></script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>

</body>

</html>