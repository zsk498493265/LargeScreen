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
    <style>
        .select{
            margin-left: 5px;
        }
    </style>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>老人 <small>健康档案</small></h5>
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
                    <div >
                        <a onclick=newPage("134","健康管理",'/oldman/health/select') href="javascript:void(0);" class="btn btn-primary jw">管理</a>
                        <a  href="javascript:void(0);" id="search" class="btn btn-primary ">搜索</a>
                    </div>
                    <div class="row">
                        <div class="col-sm-4">
                            <input class="search form-control inp" type="text" placeholder="模糊匹配">
                        </div>
                    </div>
                    <script>
                        $.ajax({
                            url: "/user/checkUserOrganType",
                            type: "get",
                            success: function (data) {
                                if (data.success == true) {
                                    if(data.data=="居委会" || data.data=="片区"){
                                        $(".jw").hide();
                                    }
                                }
                            }
                        });
                    </script>
                    <div class="table-responsive">
                        <div class="table-responsive">
                            <table class="table table-striped table-bordered table-hover dataTables-example text-nowrap text-nowrap">
                                <thead>
                                <tr>
                                    <th>姓名</th>
                                    <th>血型</th>
                                    <th>失智</th>
                                    <th>视力</th>
                                    <th>慢病</th>
                                    <th>失能</th>
                                    <th>药物反应</th>
                                    <th>恶性肿瘤史</th>
                                    <th>骨折史</th>
                                    <th>残疾情况</th>
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
<#include  "edit_health.ftl"/>
<script src="/js/content.min.js?v=1.0.0"></script>
<script src="/static/js/common.js"></script>
<script src="/static/js/oldman/health.js" ></script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>

</body>

</html>