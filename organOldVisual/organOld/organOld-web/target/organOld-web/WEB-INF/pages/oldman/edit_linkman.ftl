

<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog" style="width: 80%">
        <div class="modal-content">
            <div class="modal-body">
                <div class="wrapper wrapper-content animated fadeInRight">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="ibox float-e-margins">
                                <div class="ibox-title">
                                    <h5></h5>
                                </div>
                                <div class="ibox-content">
                                    <form method="post" id="oldmanEdit" class="form-horizontal" action="/oldman/linkman/update">
                                        <input type="hidden" name="id">
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">姓名</label>
                                            <div class="col-sm-8">
                                                <input type="text" class="form-control" name="name">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">关系</label>
                                            <div class="col-sm-8">
                                                <input type="text" class="form-control" name="relation">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">电话</label>
                                            <div class="col-sm-8">
                                                <input type="text" class="form-control" name="phone">
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
                <a onclick="$('#oldmanEdit').submit()" href="javascript:void(0);" class="btn btn-primary ">修改</a>
                <a data-dismiss="modal" href="javascript:void(0);" class="btn btn-primary ">关闭</a>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>


