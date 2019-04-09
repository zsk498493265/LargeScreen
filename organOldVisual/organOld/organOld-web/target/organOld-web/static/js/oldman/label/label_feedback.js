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
            "columns":[{
                data:"organId"
            },{
                data:"districtName"
            },{
                data:"organName"
            },{
                data:"isFinish"
            },{
                data:"remark"
            },{
                data:"labelManImplNum.sum"
            },{},{
                data:"labelManImplNum.impl"
            },{
                data:"labelManImplNum.noImpl"
            },{},{},{
                data:"time"
            }
            ],
            "columnDefs": [
                // 增加一列，包括删除和修改，同时将我们需要传递的数据传递到链接中
                {
                    "targets": [6], // 目标列位置，下标从0开始
                    "data": "labelManImplNum", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        if(data.sum!=0){
                            return data.sum-data.no;
                        }else{
                            return 0;
                        }
                    }
                },
                {
                    "targets": [9], // 目标列位置，下标从0开始
                    "data": "labelManImplNum", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        if(data.sum!=0){
                            return ((((data.sum-data.no)*1.00)/(data.sum))*100).toFixed(2);
                        }else{
                            return "0.00";
                        }
                    }
                },{
                    "targets": [10], // 目标列位置，下标从0开始
                    "data": "labelManImplNum", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        if(data.sum!=0){
                            return ((data.impl*1.00/(data.sum)*100)).toFixed(2);
                        }else{
                            return "0.00";
                        }
                    }
                }
            ],
            "sAjaxSource": "/oldman/label/feedback",//这个是请求的地址
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
                "labelId":labelId
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

function del(id) {
    $.ajax({
        url : "/oldman/economic/del",
        type : "post",
        dataType : 'json',
        data:{
            id:id
        },
        success : function(data) {
            if (data.success==true) {
                start = $(".dataTables-example").dataTable().fnSettings()._iDisplayStart;
                total = $(".dataTables-example").dataTable().fnSettings().fnRecordsDisplay();
                window.location.reload();
                if(total-start==1){
                    if(start>0){
                        $(".dataTables-example").dataTable().fnPageChange('previous',true);
                    }
                }

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
