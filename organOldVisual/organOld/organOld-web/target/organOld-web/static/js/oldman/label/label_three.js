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
                data:"sec"
            },{
                data:"name"
            },{
                data:"wh"
            },{
                data:"start"
            },{
                data:"end"
            },{
                data:"time"
            }
            ],
            "order":[[1,"asc"]],
            "columnDefs": [
                {
                    "targets": [0], // 目标列位置，下标从0开始
                    "data": "id", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        return "<input type='checkbox' name='id' value='"+data+"'/>";
                    }
                },
                // {
                //     "targets": [1], // 目标列位置，下标从0开始
                //     "data": "organName", // 数据列名
                //     "render": function(data, type, full) { // 返回自定义内容
                //         if(data!=null){
                //             return data;
                //         }else{
                //             return "";
                //         }
                //     }
                // },
                {
                    "targets": [3], // 目标列位置，下标从0开始
                    "data": "wh", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        if(data!=null){
                            return data;
                        }else{
                            return "";
                        }
                    }
                },
                // 增加一列，包括删除和修改，同时将我们需要传递的数据传递到链接中
                {
                    "targets": [7], // 目标列位置，下标从0开始
                    "data": "isFeedback", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        var name="$(this).parent().prev().prev().prev().prev().prev().text()";
                        var id="$(this).parent().prev().prev().prev().prev().prev().prev().prev().find('input').val()";
                        if(typeLabel=="1"){
                            //人员绑定
                            if(userType=="居委会"){
                                var s="<span class='btn btn-primary' onclick=newPageBefore("+id+","+name+",'/oldman/label/bind/?/man')>人员</span>";
                                if(data!=null && data!=0){
                                    s+="<span class='btn btn-primary' onclick=lookfeedback("+id+")>已反馈</span>";
                                }else{
                                    s+="<span class='btn btn-primary' onclick=feedback("+id+")>反馈</span>";
                                }
                                    s+="<span class='btn btn-primary' onclick=oldman_editBefore("+id+",'/oldman/label/?/getById')>查看</span>";
                                return s;
                            }else{
                                return "<span class='btn btn-primary' onclick=newPageBefore("+id+","+name+",'/oldman/label/bind/?/man') >人员</span>" +
                                    "<span class='btn btn-primary' onclick=newPageBefore("+id+","+name+",'/oldman/label/?/feedback')>反馈</span>" +
                                    "<button class='btn btn-primary' onclick=oldman_editBefore("+id+",'/oldman/label/?/getById')>查看</button>";
                            }
                        }else{
                            //规则指定
                            if(userType=="居委会" || userType=="片区"){
                                var s="<span class='btn btn-primary' onclick=newPageBefore("+id+","+name+",'/oldman/label/rule/?/man')>人员</span>";
                                if(data!=null && data!=0){
                                    s+="<span class='btn btn-primary' onclick=lookfeedback("+id+")>已反馈</span>";
                                }else{
                                    s+="<span class='btn btn-primary' onclick=feedback("+id+")>反馈</span>";
                                }
                                s+="<span class='btn btn-primary' onclick=oldman_editBefore("+id+",'/oldman/label/?/getById')>查看</span>";
                                return s;
                            }else{
                                return "<span class='btn btn-primary' onclick=newPageBefore("+id+","+name+",'/oldman/label/rule/?/man')>人员</span>" +
                                    "<span class='btn btn-primary' onclick=newPageBefore("+id+","+name+",'/oldman/label/rule/?')>规则</span>" +
                                    "<span class='btn btn-primary' onclick=newPageBefore("+id+","+name+",'/oldman/label/?/feedback')>反馈</span>" +
                                    "<span class='btn btn-primary' onclick=oldman_editBefore("+id+",'/oldman/label/?/getById')>查看</span>";
                            }
                        }
                    }
                }
            ],
            "sAjaxSource": "/oldman/label/data",//这个是请求的地址
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
                // "id" :  ($('input[name="id"]').val()==""?"0":$('input[name="id"]').val()),//参数不能是空 400
                "type":typeLabel,
                "census_array":$("select[name='census_array']").val(),
                "ageStart":$("input[name='ageStart']").val(),
                "isKey":$("select[name='isKey']").val(),
                "ageEnd":$("input[name='ageEnd']").val(),
                // "wh":$("input[name='wh']").val(),
                "family_array":$("select[name='family_array']").val(),
                "family_type_array":$("select[name='family_type_array']").val(),
                "economic_array":$("select[name='economic_array']").val(),
                "sex":$("select[name='sex']").val(),
                "search":$("input[name='search']").val().trim(),
                "politicalStatus_array":$("select[name='politicalStatuse_array']").val(),
                "isHealth_array":$("select[name='isHealth_array']").val(),
                "intelligence_array":$("select[name='intelligence_array']").val(),
                "eyesight_array":$("select[name='eyesight_array']").val(),
                "district_array":$("select[name='district_array']").val(),
                "jw_array":$("select[name='jw_array']").val(),
                "zc_array":$("select[name='zc_array']").val(),
                "sqzw_array":$("select[name='sqzw_array']").val(),
                "oldStatus_array":$("select[name='oldStatus_array']").val(),
                "chx_array":$("select[name='chx_array']").val(),
                // "belongOrgan":$("select[name='belongOrgan']").val(),
                // "firType":$("select[name='fir']").val(),
                "secType":$("select[name='sec']").val()
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

function newPageBefore(id,name,url) {
    var url_new=url.replace("?",id);
    newPage(id,name,url_new);
}

function feedback(id) {
    $("#feedbackModal").modal();
    $("#feedbackModal input[name='labelId']").val(id);
}

function lookfeedback(id) {
    $("#lookfeedbackModal").modal();
    $.ajax({
        url: "/oldman/label/feedback/"+id+"/look",//这个就是请求地址对应sAjaxSource
        type: 'GET',
        success: function (result) {
            $("#remark").html(result.data.remark);
            $("#isFinish").html(result.data.isFinish);
        }
    });
}
function oldman_editBefore(id,url) {
    //查看是否有修改标签的权限
    // $.ajax({
    //     url: "/oldman/label/"+id+"/checkCanChange",
    //     type: "get",
    //     success: function (data) {
    //         if (data.success ==false) {
    //             BootstrapDialog.show({
    //                 title: '',
    //                 message: '您没有权限修改',
    //                 buttons: [{
    //                     label: '确定',            cssClass:'btn btn-primary',
    //                     action: function(dialog) {
    //                         dialog.close();
    //                     }
    //                 }]
    //             });
    //         }else{
                url=url.replace("?",id);
                oldman_edit(id,url);

    if(userType!=null && userType!=''){
        $("#editModal .aaaa").hide();
        $("#editModal input").prop("disabled",true);
        $("#editModal select").prop("disabled",true);
    }


    //         }
    //     }
    // });


}