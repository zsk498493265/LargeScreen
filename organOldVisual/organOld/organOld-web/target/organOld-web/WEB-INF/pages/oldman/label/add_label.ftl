<div class="modal fade" id="selectModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog" style="width: 80%">
        <div class="modal-content">
            <div class="modal-body">
                <div class="wrapper wrapper-content animated fadeInRight">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="ibox float-e-margins">
                                <div class="ibox-title">
                                    <h5>标签 <small>添加</small></h5>
                                </div>
                                <div class="ibox-content">
                                    <form method="post" id="labelAdd" class="form-horizontal" action="/oldman/label/add">
                                        <input type="hidden" value="${type}" name="type">
                                        <#--<div class="form-group">-->
                                            <#--<label class="col-sm-1 control-label">一级菜单<span  class="control-label star-content">*</span></label>-->
                                            <#--<div class="col-sm-2">-->
                                                <#--<select onchange="firLabelSelect(this)">-->
                                                    <#--<option></option>-->
                                                    <#--<#list rule.firLabel as list>-->
                                                        <#--<option  value="${list.id!}" > ${list.value!}</option>-->
                                                    <#--</#list>-->
                                                <#--</select>-->
                                            <#--</div>-->
                                            <#--<label class="col-sm-1 control-label">二级菜单<span  class="control-label star-content">*</span></label>-->
                                            <#--<div class="col-sm-2">-->
                                                <#--<select name="labelSec.id">-->
                                            <#--</select>-->
                                            <#--</div>-->
                                        <#--</div>-->
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label"><span  class="star-content">*</span>政策类型</label>
                                            <div class="col-sm-8">
                                                <select name="secId" class="search_select bx" data-live-search="true">
                                                <#list rule.secLabel as list>
                                                    <option  value="${list.id!}" > ${list.secName!}</option>
                                                </#list>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label"><span  class="star-content">*</span>名称</label>
                                            <div class="col-sm-8">
                                                <input type="text" class="form-control bx" name="name"/>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">条件</label>
                                            <div class="col-sm-8">

                                                <input type="text" class="form-control" name="rule"/>

                                            </div>
                                        </div>


                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">内容</label>
                                            <div class="col-sm-8">

                                                <input type="text" class="form-control" name="content"/>

                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">文号</label>
                                            <div class="col-sm-8">

                                                <input type="text" class="form-control" name="wh"/>

                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label"><span  class="star-content">*</span>开始时间</label>
                                            <div class="col-sm-3">
                                                <input type="date" class="form-control bx" name="startTime"/>
                                            </div>
                                            <label class="col-sm-1 control-label"><span  class="star-content">*</span>结束时间</label>
                                            <div class="col-sm-3">
                                                <input type="date" class="form-control bx" name="endTime"/>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
            <div class="modal-footer">

                <a onclick="check()" href="javascript:void(0);" class="btn btn-primary aaaa">保存 </a>

                <a data-dismiss="modal" href="javascript:void(0);" class="btn btn-primary ">关闭</a>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>

<script>
    function check() {
        var i=0;
        $("#selectModal .bx").each(function () {
            if($(this).val()==null || $.trim($(this).val())==''){
                i=1;
                return ;
            }
        });
        if(i==0)
            $('#labelAdd').submit();
        else
            BootstrapDialog.show({
                title: '',
                message: '标红处不能为空',
                buttons: [{
                    label: '确定',            cssClass:'btn btn-primary',
                    action: function(dialog) {
                        dialog.close();
                    }
                }]
            });
    }
</script>

<div class="modal fade" id="feedbackModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog" style="width: 80%">
        <div class="modal-content">
            <div class="modal-body">
                <div class="wrapper wrapper-content animated fadeInRight">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="ibox float-e-margins">
                                <div class="ibox-title">
                                    <h5>标签 <small>反馈</small></h5>
                                </div>
                                <div class="ibox-content">

                                    <form method="post" id="feedbackAdd" class="form-horizontal" action="/oldman/label/feedback/add">
                                        <input type="hidden" value="" name="labelId">
                                        <input type="hidden" value="${type}" name="type">
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">是否完成</label>
                                            <div class="col-sm-1">
                                                    <label>
                                                        <input type="radio" value="1" name="isFinish" > <i></i> 是</label>
                                            </div>
                                            <div class="col-sm-1">
                                                    <label>
                                                        <input type="radio" value="0" name="isFinish" > <i></i> 否</label>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">备注</label>
                                            <div class="col-sm-8">
                                                <input type="text" class="form-control" name="remark"/>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
            <div class="modal-footer">
                <a onclick="$('#feedbackAdd').submit()" href="javascript:void(0);" class="btn btn-primary ">添加</a>
                <a data-dismiss="modal" href="javascript:void(0);" class="btn btn-primary ">关闭</a>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>


<div class="modal fade" id="lookfeedbackModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog" style="width: 80%">
        <div class="modal-content">
            <div class="modal-body">
                <div class="wrapper wrapper-content animated fadeInRight">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="ibox float-e-margins">
                                <div class="ibox-title">
                                    <h5>标签 <small>反馈</small></h5>
                                </div>
                                <div class="ibox-content">

                                    <form  class="form-horizontal" >
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">是否完成</label>
                                            <div class="col-sm-1">
                                                <label id="isFinish">
                                                     </label>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">备注</label>
                                            <div class="col-sm-8">
                                                <label id="remark"></label>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
            <div class="modal-footer">
                <a data-dismiss="modal" href="javascript:void(0);" class="btn btn-primary ">关闭</a>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>



<script>
    //查看是否有修改标签的权限
    function firLabelSelect(obj) {
        $("select[name='labelSec.id']").html("");
            $.ajax({
                url: "/oldman/label/"+$(obj).val()+"/getSecLabel",
                type: 'GET',
                success: function (result) {
                    if(result.success==true){
                        for(var i=0;i<result.data.length;i++){
                            var op=$("<option value='"+result.data[i].id+"'>"+result.data[i].secName+"</option>");
                            $("select[name='labelSec.id']").append(op)
                        }
                    }
                }
            });
    }
</script>
