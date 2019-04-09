<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <#include "../common/head.ftl" />

<#--<link href="/css/animate.min.css" rel="stylesheet">-->
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
                    <h5>积分管理</h5>
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
                        <a  onclick="oldman_edit(1,'/oldman/integral/getRule')" class="btn btn-primary ">规则管理</a>
                        <a  href="javascript:void(0);" onclick="$('#integral').val('');$('#integralModal input:first').prop('checked',true);$('#integralModal').modal()" class="btn btn-primary ">积分变更</a>
                        <a  href="javascript:void(0);" onclick="zero()" class="btn btn-primary ">积分清零</a>
                        <a  href="javascript:void(0);" id="search" class="btn btn-primary ">搜索</a>
                    <#--<div class="row">-->
                        <#--<div class="col-sm-4">-->
                            <input class="search form-control inp" style="width: 50%" type="text" placeholder="模糊匹配">
                        <#--</div>-->
                    <#--</div>-->
                    </div>
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover dataTables-example text-nowrap">
                            <thead>
                            <tr>
                                <th><input type='checkbox' onclick="thCheck(this)"/></th>
                                <#--<th>老人序号</th>-->
                                <th>老人姓名</th>
                                <th>积分</th>
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

    <#include "edit_integral.ftl" />
<#include "integral_change.ftl"/>
<script src="/js/content.min.js?v=1.0.0"></script>
<script src="/static/js/common.js"></script>
<script src="/static/js/oldman/integral.js" ></script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>

</body>

</html>