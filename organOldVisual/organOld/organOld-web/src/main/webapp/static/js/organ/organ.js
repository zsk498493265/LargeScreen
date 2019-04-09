/**
 * Created by netlab606 on 2018/4/2.
 */
var table;
$(document).ready(function(){
    var columns=[];
    var columnDefs=[];
    if(firType==21 || firType==22){
        columns=[{},{
            data:"organType"
        },{
            data:"name"
        },{},{
            data:"time"
        }
        ];
        columnDefs= [
            // 列样式
            {
                "targets": [0], // 目标列位置，下标从0开始
                "data": "id", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    return"<input type='checkbox' name='id' value='"+data+"'/>"
                }
            },
            // {
            //     "targets": [4], // 目标列位置，下标从0开始
            //     "data": "intro", // 数据列名
            //     "render": function(data, type, full) { // 返回自定义内容
            //         if(data!=null && data.length>60){
            //             data=data.substr(0,60)+"......";
            //         }
            //         if(data!=null){
            //             data=data.substr(0,35)+"<br>"+data.substr(35);
            //         }
            //         return data;
            //     }
            // },
            {
                "targets": [3], // 目标列位置，下标从0开始
                "data": "organ", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    var btn="";
                    if(data.authConsume==1){
                        btn+="<span class='btn btn-primary' onclick=newPage("+data.id+",$(this).parent().prev().text(),'/record/1?organId="+data.id+"')>消费记录</span>";
                    }
                    if(data.authProduct==1){
                        btn+="<span class='btn btn-primary' onclick=newPage("+data.id+",$(this).parent().prev().text(),'/product?organId="+data.id+"')>服务产品</span>";
                    }
                    if(data.authProduct==1){
                        btn+="<span class='btn btn-primary' onclick=newPage("+data.id+",$(this).parent().prev().text(),'/product/book?organId="+data.id+"')>预定记录</span>";
                    }
                    if(data.authSign==1){
                        btn+="<span class='btn btn-primary' onclick=newPage("+data.id+",$(this).parent().prev().text(),'/record/2?organId="+data.id+"')>签到记录</span>";
                    }
                    if(data.authQueryInfo==1){
                        btn+="<span class='btn btn-primary' onclick=newPage("+data.id+",$(this).parent().prev().text(),'/record/3?organId="+data.id+"')>老人信息查询记录</span>";
                    }
                    if(data.authQueryIntegral==1){
                        btn+="<span class='btn btn-primary' onclick=newPage("+data.id+",$(this).parent().prev().text(),'/record/4?organId="+data.id+"')>老人积分查询记录</span>";
                    }
                    return btn;
                }
            },
            // 增加一列，包括删除和修改，同时将我们需要传递的数据传递到链接中
            {
                "targets": [5], // 目标列位置，下标从0开始
                "data": "id", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容

                    return "<span class='btn btn-primary' onclick=newPage("+data+",$(this).parent().prev().prev().prev().text(),'/organ/oldman/"+data+"/man')>人员</span>" +
                        "<span class='btn btn-primary' onclick=newPage("+data+",$(this).parent().prev().prev().prev().text(),'/organ/"+data+"/info')>查看</span>";

                }
            }
        ]
    }else if(firType==1){
        columns=[{},{
            data:"organType"
        },{
            data:"name"
        },{},{
            data:"time"
        }
        ];
        columnDefs= [
            // 列样式
            {
                "targets": [0], // 目标列位置，下标从0开始
                "data": "id", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    return"<input type='checkbox' name='id' value='"+data+"'/>"
                }
            },
            {
                "targets": [3], // 目标列位置，下标从0开始
                "data": "organ", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    var btn="";
                    if(data.authConsume==1){
                        btn+="<span class='btn btn-primary' onclick=newPage("+data.id+",$(this).parent().prev().text(),'/record/1?organId="+data.id+"')>消费记录</span>";
                    }
                    if(data.authProduct==1){
                        btn+="<span class='btn btn-primary' onclick=newPage("+data.id+",$(this).parent().prev().text(),'/product?organId="+data.id+"')>服务产品</span>";
                    }
                    if(data.authProduct==1){
                        btn+="<span class='btn btn-primary' onclick=newPage("+data.id+",$(this).parent().prev().text(),'/product/book?organId="+data.id+"')>预定记录</span>";
                    }
                    if(data.authSign==1){
                        btn+="<span class='btn btn-primary' onclick=newPage("+data.id+",$(this).parent().prev().text(),'/record/2?organId="+data.id+"')>签到记录</span>";
                    }
                    if(data.authQueryInfo==1){
                        btn+="<span class='btn btn-primary' onclick=newPage("+data.id+",$(this).parent().prev().text(),'/record/3?organId="+data.id+"')>老人信息查询记录</span>";
                    }
                    if(data.authQueryIntegral==1){
                        btn+="<span class='btn btn-primary' onclick=newPage("+data.id+",$(this).parent().prev().text(),'/record/4?organId="+data.id+"')>老人积分查询记录</span>";
                    }
                    return btn;
                }
            },
            // 增加一列，包括删除和修改，同时将我们需要传递的数据传递到链接中
            {
                "targets": [5], // 目标列位置，下标从0开始
                "data": "id", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    return "<span class='btn btn-primary' onclick=newPage("+data+",$(this).parent().prev().prev().prev().text(),'/organ/"+data+"/info')>查看</span>";

                }
            }
        ]
    }else if(firType==3 && status=="2"){
        columns=[{},{
            data:"organType"
        },{
            data:"name"
        },{},{
            data:"time"
        }
        ];
        columnDefs= [
            // 列样式
            {
                "targets": [0], // 目标列位置，下标从0开始
                "data": "id", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    return"<input type='checkbox' name='id' value='"+data+"' />"
                }
            },
            {
                "targets": [3], // 目标列位置，下标从0开始
                "data": "organ", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    var btn="";
                    if(data.authConsume==1){
                        btn+="<span class='btn btn-primary' onclick=newPage("+data.id+",$(this).parent().prev().text(),'/record/1?organId="+data.id+"')>消费记录</span>";
                    }
                    if(data.authProduct==1){
                        btn+="<span class='btn btn-primary' onclick=newPage("+data.id+",$(this).parent().prev().text(),'/product?organId="+data.id+"')>服务产品</span>";
                    }
                    if(data.authProduct==1){
                        btn+="<span class='btn btn-primary' onclick=newPage("+data.id+",$(this).parent().prev().text(),'/product/book?organId="+data.id+"')>预定记录</span>";
                    }
                    if(data.authSign==1){
                        btn+="<span class='btn btn-primary' onclick=newPage("+data.id+",$(this).parent().prev().text(),'/record/2?organId="+data.id+"')>签到记录</span>";
                    }
                    if(data.authQueryInfo==1){
                        btn+="<span class='btn btn-primary' onclick=newPage("+data.id+",$(this).parent().prev().text(),'/record/3?organId="+data.id+"')>老人信息查询记录</span>";
                    }
                    if(data.authQueryIntegral==1){
                        btn+="<span class='btn btn-primary' onclick=newPage("+data.id+",$(this).parent().prev().text(),'/record/4?organId="+data.id+"')>老人积分查询记录</span>";
                    }
                    return btn;
                }
            },
            // 增加一列，包括删除和修改，同时将我们需要传递的数据传递到链接中
            {
                "targets": [5], // 目标列位置，下标从0开始
                "data": "id", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    return "<span class='btn btn-primary' onclick=newPage("+data+",$(this).parent().prev().prev().prev().text(),'/organ/"+data+"/info')>查看</span>" +
                     "<span class='btn btn-danger' onclick=opera("+data+",'cancel')>撤销</span>";
                }
            }
        ]

    }else if(firType==3 && (status=="3")){

        columns=[{
            data:"organType"
        },{
            data:"name"
        },{
            data:"statusDesc"
        },{}
        ,{
            data:"time"
        }
        ];
        columnDefs= [
            {
                "targets": [3], // 目标列位置，下标从0开始
                "data": "organ", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    var btn="";
                    if(data.authConsume==1){
                        if(data.status=="4"){
                            btn+="<span class='btn btn-primary' onclick=newPage("+data.id+",$(this).parent().prev().prev().text(),'/record/1?organId="+data.id+"')>消费记录</span>";
                        } else{
                            btn+="<span class='noBtn'>消费记录</span>";
                        }

                    }
                    if(data.authProduct==1){
                        if(data.status=="4")
                        btn+="<span class='btn btn-primary' onclick=newPage("+data.id+",$(this).parent().prev().prev().text(),'/product?organId="+data.id+"')>服务产品</span>";
                        else
                            btn+="<span class='noBtn'>服务产品</span>";
                    }
                    if(data.authProduct==1){
                        if(data.status=="4")
                        btn+="<span class='btn btn-primary' onclick=newPage("+data.id+",$(this).parent().prev().prev().text(),'/product/book?organId="+data.id+"')>预定记录</span>";
                        else
                            btn+="<span class='noBtn'>预定记录</span>";
                    }
                    if(data.authSign==1){
                        if(data.status=="4")
                        btn+="<span class='btn btn-primary' onclick=newPage("+data.id+",$(this).parent().prev().prev().text(),'/record/2?organId="+data.id+"')>签到记录</span>";
                        else
                            btn+="<span class='noBtn'>签到记录</span>";
                    }
                    if(data.authQueryInfo==1){
                        if(data.status=="4")
                        btn+="<span class='btn btn-primary' onclick=newPage("+data.id+",$(this).parent().prev().prev().text(),'/record/3?organId="+data.id+"')>老人信息查询记录</span>";
                        else
                            btn+="<span class='noBtn'>老人信息查询记录</span>";
                    }
                    if(data.authQueryIntegral==1){
                        if(data.status=="4")
                        btn+="<span class='btn btn-primary' onclick=newPage("+data.id+",$(this).parent().prev().prev().text(),'/record/4?organId="+data.id+"')>老人积分查询记录</span>";
                        else
                            btn+="<span class='noBtn'>老人积分查询记录</span>";
                    }
                    return btn;
                }
            },
            // 增加一列，包括删除和修改，同时将我们需要传递的数据传递到链接中
            {
                "targets": [5], // 目标列位置，下标从0开始
                "data": "id", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    return "<span class='btn btn-primary' onclick=newPage("+data+",$(this).parent().prev().prev().prev().prev().text(),'/organ/"+data+"/info')>查看</span>";
                }
            }
        ]
    }else {
        columns=[{
            data:"organType"
        },{
            data:"name"
        },{},{
            data:"time"
        }
        ];
        columnDefs= [
            // 列样式
            {
                "targets": [2], // 目标列位置，下标从0开始
                "data": "organ", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    var btn="";
                    if(data.authConsume==1){
                        btn+="<span class='noBtn'>消费记录</span>";
                    }
                    if(data.authProduct==1){
                        btn+="<span  class='noBtn'>服务产品</span>";
                        btn+="<span  class='noBtn'>预定列表</span>";
                    }
                    if(data.authSign==1){
                        btn+="<span class='noBtn'>签到记录</span>";
                    }
                    if(data.authQueryInfo==1){
                        btn+="<span class='noBtn'>老人信息查询记录</span>";
                    }
                    if(data.authQueryIntegral==1){
                        btn+="<span class='noBtn'>老人积分查询记录</span>";
                    }
                    return btn;
                }
            },
            // 增加一列，包括删除和修改，同时将我们需要传递的数据传递到链接中
            {
                "targets": [4], // 目标列位置，下标从0开始
                "data": "id", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容

                    return "<span class='btn btn-primary' onclick=newPage("+data+",$(this).parent().prev().prev().prev().text(),'/organ/"+data+"/info')>查看</span>" +
                        "<span class='btn btn-primary' onclick=opera("+data+",'pass') id='"+data+"'>通过</span><span class='btn btn-danger' onclick=opera("+data+",'reject') id='"+data+"'>不通过</span>";

                }
            }
        ]
    }

    table =$(".dataTables-example").dataTable(
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
            "sAjaxSource": "/organ/data",//这个是请求的地址
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
                "type" : firType,
                "status":status,
                "search" : $('.search').val(),
                "organTypeId" : $('.type').val()
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

function opera(id,type) {
    $.ajax({
        url: "/organ/"+type,
        data : {
            id:id
        },
        type: 'POST',
        dataType: 'json',
        success: function (result) {
            BootstrapDialog.show({
                title: '',
                message: '操作成功',
                buttons: [{
                    label: '确定',            cssClass:'btn btn-primary',
                    action: function(dialog) {
                        dialog.close();
                    }
                }]
            });
            start = $(".dataTables-example").dataTable().fnSettings()._iDisplayStart;
            total = $(".dataTables-example").dataTable().fnSettings().fnRecordsDisplay();
            window.location.reload();
            if(total-start==1){
                if(start>0){
                    $(".dataTables-example").dataTable().fnPageChange('previous',true);
                }
            }

            $.ajax({
                url: "/organ/sendemail",
                data : {
                    organId:id,
                    type:type
                },
                type: 'POST',
                dataType: 'json',
                success: function (result) {

                }
            });
        },
        error:function(XMLHttpRequest, textStatus, errorThrown) {

        }
    });
}


// function cancel(id) {
//     $.ajax({
//         url: '/organ/society/' + id + '/cancel',
//         type: 'post',
//         success: function (result) {
//             if(result.success==true){
//                 alert("操作成功");
//                 table.fnFilter();
//             }
//         }
//     });
// }