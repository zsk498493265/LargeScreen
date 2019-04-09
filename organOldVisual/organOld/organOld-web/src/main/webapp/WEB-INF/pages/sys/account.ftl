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
                    <h5>账号管理 <small></small></h5>
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
                        <a onclick="del('/user/del')" href="javascript:void(0);" class="btn btn-primary ">禁用</a>
                        <a onclick="del('/user/undel')" href="javascript:void(0);" class="btn btn-primary ">启用</a>
                        <a  href="javascript:void(0);" id="search" class="btn btn-primary ">搜索</a>
                    </div>
                    <div class="row">
                        <div class="col-sm-2">
                            <label>模糊匹配：</label>
                            <input class="search form-control inp" type="text">
                        </div>
                        <div class="col-sm-2">
                            <label>角色：</label>
                            <select name="role" class="form-control inp">
                                <option></option>
                                <#list roles as list>
                                    <option value="${list.id}">${list.desc}</option>
                                </#list>
                            </select>
                        </div>
                        <div class="col-sm-2">
                            <label>状态：</label>
                            <select name="disable" class="form-control inp" >
                                <option></option>
                                <option value="0">正常</option>
                                <option value="1">禁用</option>
                            </select>
                        </div>
                    </div>
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover dataTables-example text-nowrap">
                            <thead>
                            <tr>
                                <th><input type='checkbox' class="checktd" onclick="thCheck(this)"/></th>
                                <#--<th>序号</th>-->
                                <th>账号</th>
                                <th>密码</th>
                                <th>角色</th>
                                <th>对应机构</th>
                                <th>状态</th>
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

<#include "add_account.ftl" />

<script src="/js/content.min.js?v=1.0.0"></script>
<script src="/static/js/common.js" ></script>
<script src="/static/js/sys/account.js" ></script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>

</body>

</html>