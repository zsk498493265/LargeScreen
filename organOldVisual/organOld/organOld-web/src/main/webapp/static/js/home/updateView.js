/**
 * Created by netlab606 on 2018/4/2.
 */
$(document).ready(function(){
    var columns=[];
    var columnDefs=[];
    columns=[{},{
        data:"oldmanName"
    },{
        data:"oldmanStatus"
    },{
        data:"homeType"
    },{
        data:"homeName"
    },{
        data:"timeIn"
    },{
        data:"timeOut"
    },{
        data:"isService"
    },{},{
        data:"ny"
    }
    ];
    columnDefs=[
        // 列样式
        {
            "targets": [0], // 目标列位置，下标从0开始
            "data": "id", // 数据列名
            "render": function(data, type, full) { // 返回自定义内容
                return"<input type='checkbox' name='id' value='"+data+"' />"
            }
        },{
            "targets": [8], // 目标列位置，下标从0开始
            "data": "organ", // 数据列名
            "render": function(data, type, full) { // 返回自定义内容
                if(data!=null) return "<span>"+data.name+"</span>";
                else return "";
            }
        },
        // 增加一列，包括删除和修改，同时将我们需要传递的数据传递到链接中
        {
            "targets": [10], // 目标列位置，下标从0开始
            "data": "id", // 数据列名
            "render": function(data, type, full) { // 返回自定义内容
                return "<button class='btn btn-primary' onclick='edit("+data+")' >修改</button>";
            }
        }
    ];

    var table =$(".dataTables-example").dataTable(
        {
            "sPaginationType": "full_numbers",
            "bPaginite": true,
            "bInfo": true,
            "bSort": false,
            "bFilter": false, //搜索栏
            "bStateSave": true,
            "bProcessing": true, //加载数据时显示正在加载信息
            "bServerSide": true, //指定从服务器端获取数据
            "columns":columns,
            "columnDefs": columnDefs,
            "sAjaxSource": "/home/man/all/data",//这个是请求的地址
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
                "search" : $('.search').val(),
                "type_array":$("select[name='type']").val(),
                "ny":$(".ny").val()
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
        var mathc=new RegExp('[0-9]{4}-[0-9]{2}','i');
        if($(this).val().trim()!='' && !mathc.test($(this).val().trim())){
            BootstrapDialog.show({
                title: '',
                message: '格式不对，例：2018-01',
                buttons: [{
                    label: '确定',            cssClass:'btn btn-primary',
                    action: function(dialog) {
                        dialog.close();
                    }
                }]
            });
        }else{
            table.fnFilter();
        }
    });

    var oTable=$("#editable").dataTable();
    oTable.$("td").editable("",{
        "callback":function(sValue,y){var aPos=oTable.fnGetPosition(this);oTable.fnUpdate(sValue,aPos[0],aPos[1])},
        "submitdata":function(value,settings){return{"row_id":this.parentNode.getAttribute("id"),
            "column":oTable.fnGetPosition(this)[2]}},"width":"90%","height":"100%"});

});





function add() {
    $("#addModal input[name='timeIn']").val("");
    $("#addModal input[name='timeOut']").val("");
    $("#addModal select[name='organId'] option:first-child").prop("selected",true);
    $(".lr").show();
    $(".lr .searchable-select").attr("name","oldmanId");
    $(".id").attr("name","");
    $('#addModal').modal();
    $('#addModal form').attr("action","/home/oldman/add");
}

function edit(id) {
    $(".searchable-select").remove();
    $("#addModal input[name='timeIn']").val("");
    $("#addModal input[name='timeOut']").val("");
    $("#addModal select[name='organId'] option:first-child").prop("selected",true);
    $(".lr").hide();
    $(".lr .searchable-select").attr("name","");
    $(".id").attr("name","id");
    $('#addModal form').attr("action","/home/oldman/update");
    $.ajax({
        url: "/home/oldman/"+id+"/getById",
        type: "get",
        async:false,
        success: function (result) {
            var data=result.data;
            for(key in data){
                if(key=="timeIn" || key=="timeOut"){
                    if(data[key]!=null){
                        var date = new Date(data[key]);
                        var year = date.getFullYear(),
                            month = date.getMonth()+1,//月份是从0开始的
                            day = date.getDate();
                        var newTime = year + '-' +
                            (month < 10? '0' + month : month) + '-' +
                            (day < 10? '0' + day : day);
                        data[key]=newTime;
                    }
                }
                $("#addModal input[name='"+key+"']").val(data[key]);
                $("#addModal select[name='"+key+"'] option[value='"+data[key]+"']").prop("selected",true);
            }
            $('.search_select').searchableSelect();
            $(".jj .searchable-select-item").on('click',
                function () {
                    $(".nocheck").prop("checked",true);
                    $("input[name='timeIn']").val("");
                    $("input[name='timeOut']").val("");
                    if($("select[name='homeId']").find("option[value="+$(this).attr('data-value')+"]").attr("firType")=="2"){
                        $(".ischx").show();
                        $(".nochx").hide();
                        $(".jg").show();
                    }else if($("select[name='homeId']").find("option[value="+$(this).attr('data-value')+"]").attr("firType")=="1" ||$("select[name='homeId']").find("option[value="+$(this).attr('data-value')+"]").attr("firType")=="3"){
                        $(".ischx").hide();
                        $(".nochx").show();
                        $(".jg").show();
                    }else{
                        $(".jg").hide();
                        $(".ischx").hide();
                        $(".nochx").show();
                    }
                });
            if($("#addModal select[name='homeId'] option:selected").attr("firType")==2){
                $(".ischx").show();
                $(".nochx").hide();
                $(".jg").show();
            }else if($("#addModal select[name='homeId'] option:selected").attr("firType")==1|| $("#addModal select[name='homeId'] option:selected").attr("firType")==3){
                $(".ischx").hide();
                $(".nochx").show();
                $(".jg").show();
            }else{
                $(".jg").hide();
                $(".ischx").hide();
                $(".nochx").show();
            }
            $("#addModal").modal();
        }
    });
}

function thCheck(obj) {
    thCheckByName(obj,"id");
}


function thCheckByName(obj,name) {
    if($(obj).is(':checked')){
        $("input[name="+name+"]").prop("checked",true);
    }else{
        $("input[name="+name+"]").prop("checked",false);
    }
}

function del(url) {
    var ids=[];
    $("input[name='id']:checked").each(function () {
        ids.push($(this).val());
    });

    $.ajax({
        url : url,
        type : "post",
        dataType : 'json',
        data:{
            ids:ids
        },
        success : function(data) {
            if (data.success==true) {
                var start = $(".dataTables-example").dataTable().fnSettings()._iDisplayStart;
                var total = $(".dataTables-example").dataTable().fnSettings().fnRecordsDisplay();
                window.location.reload();
                if(total-start==1){
                    if(start>0){
                        $(".dataTables-example").dataTable().fnPageChange('previous',true);
                    }
                }

            } else {
                alert('删除失败！');
            }
        }
    });
}