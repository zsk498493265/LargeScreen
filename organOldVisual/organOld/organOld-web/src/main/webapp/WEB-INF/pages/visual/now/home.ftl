<#--<!DOCTYPE html>-->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<#include "../head_part.ftl" />
<#--<script src="/static/js/chart_part.js"></script>-->


</head>

<body style="margin-top: 0.7%">
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-3" style="position: relative;right: 80px">
            <div class="row">
                <div class="col-lg-12" >
                    <#include "news.ftl" />
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12" id="label">
                    <#include "label.ftl" />
                </div>
            </div>
        </div>
        <div class="col-lg-3" style="position: relative;right:30px;margin-top:30px" align="center">
            <div class="row">
                <div class="col-lg-12" id="map" style="position: relative;right:19.6px">
                    <#include "map.ftl" />
                    <#--<#include "heatmap.js" />-->
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12" id="table" style="position: relative;top:-54px;left:20px">
                    <#include "table.ftl" />
                </div>
            </div>
        </div>
        <div class="col-lg-6" style="position: relative;left:10px">
            <div class="row">
                <div class="col-lg-6"  id="total" style="margin-top: 1%;margin-bottom: 1%;">
                    <#include "total.ftl" />
                </div>
                <div class="col-lg-6" id="oldman" style="margin-top: 1%;margin-bottom: 1%;position: relative;left: 1%">
                    <#include "oldman.ftl" />
                    <#include "base.ftl" />
                    <#include "family.ftl" />
                    <#include "economic.ftl" />
                    <#include "health.ftl" />
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6" id="organ" >
                    <#include "organ.ftl" />
                    <#include "homeOldman.ftl" />
                    <#include "organOldman.ftl" />
                    <#include "zcdOldman.ftl" />
                    <#include "zzOldman.ftl" />
                    <#include "rzzxOldman.ftl" />
                    <#include "chx.ftl" />
                    <#include "znh.ftl" />
                    <#include "jjys.ftl" />
                    <#include "jjbc.ftl" />
                </div>
                <div class="col-lg-6" id="finish" style="position: relative;left: 1%">
                    <#include "finish.ftl" />
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    function downloadJSAtOnload() {
        var element = document.createElement("script");
        element.src = "heatmap.js";
        document.body.appendChild(element);
    }
    if (window.addEventListener)
        window.addEventListener("load", downloadJSAtOnload, false);
    else if (window.attachEvent)
        window.attachEvent("onload", downloadJSAtOnload);
    else window.onload = downloadJSAtOnload;
</script>
</body>
<script>
    var oldman_base=0,error=0;
    function change(source,des) {
        if(des=="child_base"&&error==1)return;
        error=0;
        if(source=="child_oldman"&&des!="child_base"){
            error=1;
        }
        //
        if(source=="child_oldman"&&des=="child_base"){
            oldman_base=1-oldman_base;
            if(oldman_base==0){
                source="child_base";
                des="child_oldman";
            }
        }

        $("#"+source).hide();
        $("#"+des).show();

        if(des=="child_oldman")error=0;
       // alert(error);
    }
</script>
</html>