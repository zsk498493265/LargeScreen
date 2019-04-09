/**
 * Created by netlab606 on 2018/4/2.
 */
$(document).ready(function(){
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
            "columns":[{},{
                data:"firType"
            },{
                data:"secType"
            },{
                data:"name"
            },{
                data:"price"
            },{
                data:"intro"
            },{
                data:"imgUrl"
            },{
                data:"time"
            }
            ],
            "columnDefs": [
                // 列样式
                {
                    "targets": [0], // 目标列位置，下标从0开始
                    "data": "id", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        return"<input type='checkbox' name='id' value='"+data+"'/>"
                    }
                },{
                    "targets": [6], // 目标列位置，下标从0开始
                    "data": "imgUrl", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        if(data!=null && data!='')
                            return"<img src="+data+" width='100px'/>";
                        else
                            return "";
                    }
                },{
                    "targets": [5], // 目标列位置，下标从0开始
                    "data": "intro", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        if(data.length>20){
                            return "<span intro='"+data+"'>"+data.substr(0,20)+"......</span>"
                        }
                    }
                },
                // 增加一列，包括删除和修改，同时将我们需要传递的数据传递到链接中
                {
                    "targets": [8], // 目标列位置，下标从0开始
                    "data": "id", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        return "<span class='btn btn-primary' onclick='edit("+data+",this)'>修改</span>";
                    }
                }
            ],
            "sAjaxSource": "/product/data",//这个是请求的地址
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
                "organId":organId
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

    var oTable=$("#editable").dataTable();
    oTable.$("td").editable("",{
        "callback":function(sValue,y){var aPos=oTable.fnGetPosition(this);oTable.fnUpdate(sValue,aPos[0],aPos[1])},
        "submitdata":function(value,settings){return{"row_id":this.parentNode.getAttribute("id"),
            "column":oTable.fnGetPosition(this)[2]}},"width":"90%","height":"100%"});

});

function add() {
    $("#productModal form").attr("action","/product/add");
    $("#productModal small").html("添加");
    $("#productModal .sub").html("保存");
    $("#productModal input").val("");
    $("#productModal textarea").val();
    $("#productModal").modal();
}

function edit(id,obj) {
    $(".sec").html("");
    $("#productModal input[name='name']").html("");
    $("#productModal input[name='id']").val(id);
    $("#productModal input[name='price']").val($(obj).parent().prev().prev().prev().prev().text());
    $("#productModal textarea[name='intro']").val($(obj).parent().prev().prev().prev().find("span").attr("intro"));
    $(".nowsiaze").text($("#productModal textarea[name='intro']").val().length);
    $("#productModal .fir option").each(function () {
        if($(this).text().trim()==$(obj).parent().prev().prev().prev().prev().prev().prev().prev().text().trim()){
            $(this).prop("selected",true);
        }
    });
    $.ajax({
        url: "/product/type/"+$("#productModal .fir").val()+"/getByParent",
        type: 'GET',
        async:false,
        success: function (result) {
            if(result.success==true){
                for(var i=0;i<result.data.length;i++){
                    var s=$(obj).parent().prev().prev().prev().prev().prev().text().trim();
                    var op;
                    if(s==result.data[i].name){
                        op=$("<option value='"+result.data[i].id+"' selected>"+result.data[i].name+"</option>");
                    }else{
                        op=$("<option value='"+result.data[i].id+"'>"+result.data[i].name+"</option>");
                    }
                    $(".sec").append(op);
                }
            }
        }
    });
    $.ajax({
        url: "/product/type/"+$("#productModal .sec").val()+"/getByParent",
        type: 'GET',
        success: function (result) {
            if(result.success==true){
                for(var i=0;i<result.data.length;i++){
                    var s=$(obj).parent().prev().prev().prev().prev().prev().text().trim();
                    var op;
                    if(s==result.data[i].name){
                        op=$("<option value='"+result.data[i].id+"' selected>"+result.data[i].name+"</option>");
                    }else{
                        op=$("<option value='"+result.data[i].id+"'>"+result.data[i].name+"</option>");
                    }
                    $("select[name='type']").append(op);
                }
            }
        }
    });
    $("#productModal img").attr("src",($(obj).parent().prev().prev().find("img").attr("src")));
    $("#productModal form").attr("action","/product/update");
    $("#productModal small").html("修改");
    $("#productModal .sub").html("保存");
    $("#productModal").modal();
}