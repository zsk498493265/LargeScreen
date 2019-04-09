/**
 * Created by netlab606 on 2018/4/2.
 */
var table;
$(document).ready(function(){

    //这个方法用来启动该页面的ReverseAjax功能
    dwr.engine.setActiveReverseAjax(true);
    //设置在页面关闭时，通知服务端销毁会话
    dwr.engine.setNotifyServerOnPageUnload(true);

    var columns=[];
    var columnDefs=[];
        columns=[{},{
            data:"dName"
        },{
            data:"jName"
        },{
            data:"oldmanName"
        },{
            data:"sex"
        },{
            data:"age"
        },{
            data:"pid"
        },{
            data:"politicalStatus"
        },{
            data:"census"
        },{
            data:"oldStatus"
        },{},{
                data:"remark"
            }
        ];
        columnDefs= [
            // 列样式
            {
                "targets": [0], // 目标列位置，下标从0开始
                "data": "id", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    if(data!=undefined){
                        return "<input type='checkbox' name='id' value='"+data+"'/>";
                    }else{
                        return "";
                    }
                }
            },
            // 增加一列，包括删除和修改，同时将我们需要传递的数据传递到链接中
            {
                "targets": [10], // 目标列位置，下标从0开始
                "data": "isImplement", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    // var s="<span class='btn btn-primary'  onclick=newPageBefore($(this).parent().prev().prev().prev().prev().prev().prev().prev().text(),$(this).parent().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().find('input').val(),'/oldman/?/info') >查看</span>";
                    var s="";
                    if(data==0){
                        s+="<button class='btn btn-primary' onclick=implement($(this).parent().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().find('input').val(),$(this).parent().prev().prev().prev().prev().prev().prev().prev().text())>未操作</button>";
                    }else if(data==1){
                        s+="<button class='btn btn-default'>未落实</button>";
                    }else{
                        s+="<button class='btn btn-default'>已落实</button>";
                    }
                    return s;
                }
            }
        ];

    table =$(".dataTables-example").dataTable(
        {
            "sPaginationType": "full_numbers",
            "bPaginite": true,
            "bInfo": true,
            "bSort":false,
            "bFilter": false, //搜索栏
            "bStateSave": true,
            "bProcessing": true, //加载数据时显示正在加载信息
            "bServerSide": true, //指定从服务器端获取数据
            "columns":columns,
            "columnDefs":columnDefs,
            "sAjaxSource": "/oldman/label/manData",//这个是请求的地址
            "fnServerData": retrieveData
        });
    function retrieveData(url, aoData, fnCallback) {
        $.ajax({
            url: url,//这个就是请求地址对应sAjaxSource
            data : {
                "iDisplayStart" : aoData.iDisplayStart,
                "iDisplayLength" : aoData.iDisplayLength,
                "iSortCol_0" : aoData.iSortCol_0,
                "sEcho" : aoData.sEcho,
                "sSortDir_0" : aoData.sSortDir_0,
                "labelId" :labelId,
                // "id" : ($('input[name="id"]').val()==""?"0":$('input[name="id"]').val()),//参数不能是空 400
                "census_array":$("select[name='census']").val(),
                "ageStart":$("input[name='ageStart']").val(),
                "ageEnd":$("input[name='ageEnd']").val(),
                "family_array":$("select[name='familyIndex']").val(),
                "economic_array":$("select[name='economicIndex']").val(),
                "sex":$("select[name='sex']").val(),
                "search":$("input[name='search']").val().trim(),
                "politicalStatus_array":$("select[name='politicalStatuses']").val(),
                "district_array":$("select[name='district']").val(),
                "jw_array":$("select[name='jw']").val(),
                "louNumStart":$("input[name='louNumStart']").val(),
                "louNumEnd":$("input[name='louNumEnd']").val(),
                "xq_array":$("select[name='xq']").val()
            },
            type: 'POST',
            dataType: 'json',
            async: false,
            success: function (result) {
                fnCallback(result);//把返回的数据传给这个方法就可以了,datatable会自动绑定数据的
            },
            error:function(XMLHttpRequest, textStatus, errorThrown) {
                // alert("status:"+XMLHttpRequest.status+",readyState:"+XMLHttpRequest.readyState+",textStatus:"+textStatus);
            }
        });
    }

    $('#search').click(function () {
        table.fnFilter();
    });


    if(type=="bind"){
        var table2 =$(".dataTables-example-1").dataTable(
            {
                "sPaginationType": "full_numbers",
                "bPaginite": true,
                "bInfo": true,
                "bSort": false,
                "bFilter": false, //搜索栏
                "bStateSave": true,
                "bProcessing": true, //加载数据时显示正在加载信息
                "bServerSide": true, //指定从服务器端获取数据
                "columns":[{},{
                    data:"id"
                },{
                    data:"dName"
                },{
                    data:"jName"
                },{
                    data:"xName"
                },{
                    data:"name"
                },{
                    data:"sex"
                },{
                    data:"age"
                },{
                    data:"politicalStatus"
                },{
                    data:"census"
                }
                ],
                "order":[[1,"asc"]],
                "columnDefs": [
                    {
                        "targets": [0], // 目标列位置，下标从0开始
                        "data": "id", // 数据列名
                        "render": function(data, type, full) { // 返回自定义内容
                            return"<input type='checkbox' value='"+data+"' name='addSelectMan' />"
                        }
                    }
                ],
                "sAjaxSource": "/oldman/label/bind/"+labelId+"/getNoSelectManData",//这个是请求的地址
                "fnServerData": retrieveData1
            });

        function retrieveData1(url, aoData, fnCallback) {
            $.ajax({
                url: url,//这个就是请求地址对应sAjaxSource
                data : {
                    "iDisplayStart" : aoData.iDisplayStart,
                    "iDisplayLength" : aoData.iDisplayLength,
                    "iSortCol_0" : aoData.iSortCol_0,
                    "sEcho" : aoData.sEcho,
                    "sSortDir_0" : aoData.sSortDir_0,
                    "id" : ($('input[name="id_select"]').val()==""?"0":$('input[name="id_select"]').val()),//参数不能是空 400
                    "census_array":$("select[name='census_select']").val(),
                    "ageStart":$("input[name='ageStart_select']").val(),
                    "ageEnd":$("input[name='ageEnd_select']").val(),
                    "family_array":$("select[name='familyIndex_select']").val(),
                    "economic_array":$("select[name='economicIndex_select']").val(),
                    "sex":$("select[name='sex_select']").val(),
                    "search":$("input[name='search_select']").val().trim(),
                    "politicalStatus_array":$("select[name='politicalStatuses_select']").val(),
                    "district_array":$("select[name='district_select']").val(),
                    "jw_array":$("select[name='jw_select']").val(),
                    "louNumStart":$("input[name='louNumStart_select']").val(),
                    "louNumEnd":$("input[name='louNumEnd_select']").val(),
                    "xq_array":$("select[name='xq_select']").val()
                },
                type: 'POST',
                dataType: 'json',
                async: false,
                success: function (result) {
                    fnCallback(result);//把返回的数据传给这个方法就可以了,datatable会自动绑定数据的
                },
                error:function(XMLHttpRequest, textStatus, errorThrown) {
                    // alert("status:"+XMLHttpRequest.status+",readyState:"+XMLHttpRequest.readyState+",textStatus:"+textStatus);
                }
            });
        }

        $('#selectSearch').click(function () {
            table2.fnFilter();
        });

    }

    var oTable=$("#editable").dataTable();
    oTable.$("td").editable("",{
        "callback":function(sValue,y){var aPos=oTable.fnGetPosition(this);oTable.fnUpdate(sValue,aPos[0],aPos[1])},
        "submitdata":function(value,settings){return{"row_id":this.parentNode.getAttribute("id"),
            "column":oTable.fnGetPosition(this)[2]}},"width":"90%","height":"100%"});


});


function implement(id,name) {
    $("#implementModal input[name='id']").val(id);
    $("#implementModal h5").html(name);
    $("#implementModal input[name='remark']").val();
    $("#implementModal").modal();
}

function subImple() {
    $.ajax({
        url : "/oldman/label/implement",
        type : "post",
        dataType : 'json',
        data:{
            "id":$("#implementModal input[name='id']").val(),
            "isImplement":$("#implementModal input[name='isImpl']:checked").val(),
            "remark":$("#implementModal input[name='remark']").val()
        },
        success : function(data) {
            if (data.success==true) {
                $("#implementModal").modal("hide");
                table.fnFilter();

            } else {
                BootstrapDialog.show({
                    title: '',
                    message: '删除失败',
                    buttons: [{
                        label: '确定',            cssClass:'btn btn-primary',
                        action: function(dialog) {
                            dialog.close();
                        }
                    }]
                });
            }
        }
    });
}

function newPageBefore(name,id,url) {
    var url_new=url.replace("?",id);
    newPage(id,name,url_new);
}

function pqSelect() {
    var pqIds=$("select[name='district']").val();
    $.ajax({
        url : "/organ/select/getJwByPqIds",
        type : "post",
        data:{
            pqIds:pqIds
        },
        dataType:"json",
        success : function(data) {
            $('select[name="jw"]').html("<option></option>");
            var result=data.data;
            for(var i=0;i<result.length;i++){
                var $op=$("<option value='"+result[i].id+"'>"+result[i].name+"</option>");
                $('select[name="jw"]').append($op);
            }
            $('select[name="jw"]').selectpicker('refresh');
        }
    });
    $.ajax({
        url : "/autoValue/select/s/getXqByPqIds",
        type : "post",
        data:{
            pqIds:pqIds
        },
        dataType:"json",
        success : function(data) {
            $('select[name="xq"]').html("<option></option>");
            var result=data.data;
            for(var i=0;i<result.length;i++){
                var $op=$("<option value='"+result[i].id+"'>"+result[i].value+"</option>");
                $('select[name="xq"]').append($op);
            }
            $('select[name="xq"]').selectpicker('refresh');
        }
    });
}

function jwSelect() {
    var jwIds=$("select[name='jw']").val();
    $.ajax({
        url : "/autoValue/select/s/getXqByJwIds",
        type : "post",
        data:{
            jwIds:jwIds
        },
        dataType:"json",
        success : function(data) {
            $('select[name="xq"]').html("<option></option>");
            var result=data.data;
            for(var i=0;i<result.length;i++){
                var $op=$("<option value='"+result[i].id+"'>"+result[i].value+"</option>");
                $('select[name="xq"]').append($op);
            }
            $('select[name="xq"]').selectpicker('refresh');
        }
    });
}

function finishExport(data) {
    if(organId==data.data){
        $("#process").hide();
        $(".wrapper").show();
        BootstrapDialog.show({
            title: '',
            message: '已导出',
            buttons: [{
                label: '确定',            cssClass:'btn btn-primary',
                action: function(dialog) {
                    dialog.close();
                }
            }]
        });
    }
}