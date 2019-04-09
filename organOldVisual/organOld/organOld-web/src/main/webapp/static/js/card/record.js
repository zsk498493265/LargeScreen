/**
 * Created by netlab606 on 2018/4/2.
 */
$(document).ready(function(){
    var columns;
    if(type==0){
        columns=[{
            data:"time"
        },{
            data:"type"
        },{
            data:"organ.name"
        }
        ];
    }else{
        columns=[{
            data:"time"
        },{
            data:"order"
        },{
            data:"data"
        },{data:"moneyChange"}
        ];
    }



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
            "columnDefs":[
                // 列样式

            ],
            "sAjaxSource": "/card/record/data",//这个是请求的地址
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
                "id":id,
                "type":$("select[name='type']").val(),
                "start":$("input[name='startDate']").val(),
                "end":$("input[name='endDate']").val()
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
        var i=0;
        $("input.aa").each(function () {
            var mathc=new RegExp('[0-9]{4}-[0-9]{2}-[0-9]{2}','gi');
           if($(this).val().trim()!='' && !mathc.test($(this).val())){
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
               i+=1;
           }
        });
        if(i==2){
            table.fnFilter();
        }
    });

    var oTable=$("#editable").dataTable();
    oTable.$("td").editable("",{
        "callback":function(sValue,y){var aPos=oTable.fnGetPosition(this);oTable.fnUpdate(sValue,aPos[0],aPos[1])},
        "submitdata":function(value,settings){return{"row_id":this.parentNode.getAttribute("id"),
            "column":oTable.fnGetPosition(this)[2]}},"width":"90%","height":"100%"});

});

