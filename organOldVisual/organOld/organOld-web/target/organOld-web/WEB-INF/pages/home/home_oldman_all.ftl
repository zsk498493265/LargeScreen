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
                    <h5>居家养老 <small>人员</small></h5>
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
                        <a onclick="del('/home/oldman/del')" href="javascript:void(0);" class="btn btn-primary ">删除</a>
                        <form action="/home/man/importExcel" method="post" enctype="multipart/form-data" id="importForm" style="display: inline">
                            <input type="button" style="display:inline" class="btn btn-primary" onclick="$('#formFile').trigger('click');" value="导入">
                            <input type="file" name="file" onchange="$('#editModal').modal()" id="formFile" style="display:inline">
                            <input type="hidden" name="ny">
                            <input type="hidden" name="type">
                        </form>
                        <a  href="javascript:void(0);" id="search" class="btn btn-primary ">搜索</a>
                        <script>
                            $("#formFile").hide();
                        </script>
                    </div>
                    <div class="row">
                        <div class="col-sm-4">
                            <input class="search form-control inp" type="text" placeholder="模糊匹配">
                        </div>
                        <div class="col-sm-3">
                            <label>类型：</label>
                            <select name="type"   class="selectpicker bla bla bli" multiple data-live-search="true">
                                <option></option>
                                <option value="1">家庭服务</option>
                                <option value="2">长护险</option>
                                <option value="3">智能终端</option>
                                <option value="4">家庭医生</option>
                                <option value="5">家庭病床</option>
                            </select>
                        </div>
                        <div class="col-sm-3">
                            <label>时间</label>
                            <input type="month" class="form-control inp ny" style="width: 80%" value="${ny!""}" />
                        </div>
                    </div>
                    <div class="table-responsive">
                        <div class="table-responsive">
                            <table class="table table-striped table-bordered table-hover dataTables-example text-nowrap text-nowrap">
                                <thead>
                                <tr>
                                    <th><input type='checkbox' onclick="thCheck(this)"></th>
                                    <th>老人姓名</th>
                                    <th>老人状态</th>
                                    <th>类型</th>
                                    <th>名称</th>
                                    <th>服务开始时间</th>
                                    <th>服务结束时间</th>
                                    <th>是否已获得服务</th>
                                    <th>对应机构</th>
                                    <th>时间</th>
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

</div>
<script>
    <#if result??>
    $.jGrowl('录入数据：${result.data.total}<br>'+
            '其中成功导入数据：${result.data.numSuccess}<br>'+
            '包括添加：${result.data.successAdd}，更新：${result.data.successUpdate}，删除：${result.data.successDel}<br>'+
            '未成功导入的行号：'+
            '<#list (result.data.fail_detail)?keys as key>'+
                '<br>原因：${key}<br>'+
                '<#list (result.data.fail_detail)?values[key_index]! as list>'+
                    '<#if (list_index+1)%6!=0>${list}&nbsp;&nbsp;&nbsp;<#else>${list}<br></#if>'+
                    '</#list>'+
                '</#list>', { sticky: true });

    </#if>
    <#if error??>
    BootstrapDialog.show({
        title: '',
        message: '${error}',
        buttons: [{
            label: '确定',            cssClass:'btn btn-primary',
            action: function(dialog) {
                dialog.close();
            }
        }]
    });

    </#if>
</script>
<#include "../spinner.ftl"/>
<#include "home_oldman_import_type.ftl"/>
<#include "add_oldman.ftl"/>
<script src="/js/content.min.js?v=1.0.0"></script>
<script src="/static/js/home/home_man_all.js" ></script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>

</body>

</html>