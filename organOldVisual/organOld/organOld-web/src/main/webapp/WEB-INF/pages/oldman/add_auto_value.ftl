<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog" style="width: 80%">
        <div class="modal-content">
            <div class="modal-body">
                <div class="wrapper wrapper-content animated fadeInRight">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="ibox float-e-margins">
                                <div class="ibox-title">
                                    <h5>${typeName}<small></small></h5>
                                </div>
                                <div class="ibox-content">
                                    <form method="post" id="autoValueForm" class="form-horizontal" action="">
                                        <input type="hidden" name="id" value="0">
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label"><span  class="star-content">*</span>名称</label>
                                            <div class="col-sm-8">
                                                <input type="text" class="form-control bx" name="value"/>
                                            </div>
                                        </div>
                                        <#if type==2 && organId?? && organId!=0>
                                            <input name="parentIndex" type="hidden" value="${organId!0}">
                                        <#elseif type==2>
                                            <div class="form-group">
                                                <label class="col-sm-1 control-label"><span  class="star-content">*</span>所属居委</label>
                                                <div class="col-sm-8">
                                                    <select name="parentIndex"  class="search_select bx" data-live-search="true">
                                                        <option></option>
                                                        <#list jw as list>
                                                            <option type="checkbox" value="${list.id!}" >${list.name!}</option>
                                                        </#list>
                                                    </select>
                                                </div>
                                            </div>
                                        </#if>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
            <div class="modal-footer">

                <a onclick="check()" href="javascript:void(0);" class="btn btn-primary firSub">添加</a>

                <a data-dismiss="modal" href="javascript:void(0);" class="btn btn-primary ">关闭</a>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>


<script>
    function check() {
        var i=0;
        $("#editModal .bx").each(function () {
            if($(this).val()==null || $(this).val().trim()==''){
                i=1;
                return ;
            }
        });
        if(i==0)
        $('#autoValueForm').submit();
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