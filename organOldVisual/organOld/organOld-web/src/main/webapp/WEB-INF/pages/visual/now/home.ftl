<!DOCTYPE html>
<html>
<head>
<#include "../head_part.ftl" />
<#--<script src="/static/js/chart_part.js"></script>-->

</head>

<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-3">
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
        <div class="col-lg-3" style="position: relative;left: -1.5%">
            <div class="row">
                <div class="col-lg-12" id="map">
                    <#include "map.ftl" />
                    <#--<#include "heatmap.js" />-->
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12" id="table">
                    <#include "table.ftl" />
                </div>
            </div>
        </div>
        <div class="col-lg-6" style="position: relative;left: -1.5%">
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
    var oldman_base=0;
    function change(source,des) {
        if(source=="child_oldman"&&des=="child_base"){
            oldman_base=1-oldman_base;
            if(oldman_base==0){
                source="child_base";
                des="child_oldman";
            }
        }

        $("#"+source).hide();
        $("#"+des).show();
    }
</script>
</html>