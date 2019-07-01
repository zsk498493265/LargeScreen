//可视化 颜色设置 变量定义
var legend_color='#fff';
var title_color="#fff";
var series_color_1='#6cbdfc',series_color_2='#dc88a9',series_color_3='#ffd289',series_color_4='#48e8dc',series_color_5='#f2f989',series_color_6='orange',series_color_7='rgb(139, 182, 93)';
var  title_text,yAxis_data,xAxis_data,series,legend_data;

var series_lebel_fontSize,title_fontSize,yAxis_axisLabel_fontSize_bar,yAxis_axisLabel_fontSize_line,xAxis_axisLabel_fontSize,
    yAxis_axisLabel_fontSize_barHei,xAxis_axisLabel_fontSize_barHei,series_item_fontSize,legand_fontSize;




if(winWidth>=1900){
    series_lebel_fontSize=20;
    title_fontSize=30;
    yAxis_axisLabel_fontSize_bar=20;
    yAxis_axisLabel_fontSize_line=18;
    xAxis_axisLabel_fontSize=18;
    yAxis_axisLabel_fontSize_barHei=20;
    xAxis_axisLabel_fontSize_barHei=20;
    series_item_fontSize=20;
    legand_fontSize=18;
}else if(winWidth<=1400 && winWidth>=1300){
    series_lebel_fontSize=10;
    title_fontSize=18;
    yAxis_axisLabel_fontSize_bar=16;
    yAxis_axisLabel_fontSize_line=14;
    xAxis_axisLabel_fontSize=14;
    yAxis_axisLabel_fontSize_barHei=16;
    xAxis_axisLabel_fontSize_barHei=16;
    series_item_fontSize=10;
    legand_fontSize=10;
}else if(winWidth<=1899 && winWidth>=1401){
    series_lebel_fontSize=10;
    title_fontSize=18;
    yAxis_axisLabel_fontSize_bar=16;
    yAxis_axisLabel_fontSize_line=14;
    xAxis_axisLabel_fontSize=14;
    yAxis_axisLabel_fontSize_barHei=16;
    xAxis_axisLabel_fontSize_barHei=16;
    series_item_fontSize=10;
    legand_fontSize=10;
}

var title= {
    text: "",
    target: "self",
    textStyle:{
        color:title_color,
        fontSize:title_fontSize,
        fontWeight:'normal'
    },
    x:'0%',
    y:'0%'
};

//条形图
function chartBar(title_text,legend_data,yAxis_data,series) {
    var option = {
        title: {
            text:title_text,
            textStyle:{
                color:'#fff',
                fontSize:title_fontSize,
                fontWeight:'normal'
            },
            x:'0%',
            y:'0%',
        },
        tooltip:{
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        legend: {
            orient: 'vertical',
            //right:'0',
            x:'right',
            data:legend_data,
        },
        grid:  {
            top:'35%',
            left: '3%',
            right: '8%',
            bottom: '3%',
            x2: 80,
            containLabel: true
        },
        xAxis: {
            show:false
        },
        yAxis: {
            type:'category',
            data: yAxis_data,
            axisLabel: {
                show: true,
                textStyle: {
                    //color: '#fff',
                    fontSize:'5',
                }
            },
            boundaryGap:false,
            axisTick:{
                show:false
            },
            // y 轴线
            axisLine:{
                show:false,

            },
            // 分割线设置
            splitLine:{
                show:false,  //显示分割线
            },
            axisLabel:{
                textStyle: {
                    color: '#fff',
                    fontSize:yAxis_axisLabel_fontSize_bar,
                    interval: 0,
                }
            }
        },
        series: series
    };
    return option;
}

//label
function chartBar_label_age(title_text,legend_data,yAxis_data,series) {
    var option = {
        title: {
            text:title_text,
            textStyle:{
                color:'#fff',
                fontSize:title_fontSize,
                fontWeight:'normal'
            },
            x:'0%',
            y:'0%',
        },
        tooltip:{
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        legend: {
            orient: 'vertical',
            //right:'0',
            x:'right',
            data:legend_data,
        },
        grid:  {
            top:'45%',
            left: '3%',
            right: '8%',
            bottom: '-3%',
            x2: 80,
            containLabel: true
        },
        xAxis: {
            show:false
        },
        yAxis: {
            type:'category',
            data: yAxis_data,
            axisLabel: {
                show: true,
                textStyle: {
                    //color: '#fff',
                    fontSize:'5',
                }
            },
            boundaryGap:false,
            axisTick:{
                show:false
            },
            // y 轴线
            axisLine:{
                show:false,

            },
            // 分割线设置
            splitLine:{
                show:false,  //显示分割线
            },
            axisLabel:{
                textStyle: {
                    color: '#fff',
                    fontSize:yAxis_axisLabel_fontSize_bar,
                    interval: 0,
                }
            }
        },
        series: series
    };
    return option;
}
function chartBarDisplayAll(title_text,legend_data,yAxis_data,series) {
    var option = {
        title: {
            text:title_text,
            textStyle:{
                color:'#fff',
                fontSize:title_fontSize,
                fontWeight:'normal'
            },
            x:'0%',
            y:'0%',
        },
        tooltip:{
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        legend: {
            orient: 'vertical',
            //right:'0',
            x:'right',
            data:legend_data,
        },
        grid:  {
            top:'48%',
            left: '6%',
            right: '15%',
            bottom: '-15%',
            //x2: 80,
            containLabel: true
        },
        xAxis: {
            show:false
        },
        yAxis: {
            type:'category',
            data: yAxis_data,
            axisLabel: {
                show: true,
                textStyle: {
                    //color: '#fff',
                    fontSize:'15',
                },
                interval:0,

            },
            boundaryGap:false,
            axisTick:{
                //show:false
                'interval': 0,
            },
            // y 轴线
            axisLine:{
                show:false,

            },
            // 分割线设置
            splitLine:{
                show:false,  //显示分割线
            },
            axisLabel:{
                textStyle: {
                    color: '#fff',
                    fontSize:16,
                    interval: 0,
                },
                interval:0,
            }
        },
        series: series
    };
    return option;
}
//chartbar for orgold
function chartBarForOrgOld(title_text,legend_data,yAxis_data,series) {
    var option = {
        title: {
            text:title_text,
            textStyle:{
                color:'#fff',
                fontSize:size_bed,
                fontWeight:'normal'
            },
            x:'0%',
            y:'0%'
        },
        tooltip:{
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        legend: {
            orient: 'vertical',
            // right:'0',
            data:legend_data,
            right:'20',
            data: legend_data,
            itemGap: 0,
            itemWidth: 18,
            itemHeight: 8,
        },
        grid:  {
            top:'0%',
            left: '8%',
            right: '16%',
            bottom: '0%',
            height:'65%',
            containLabel: true
        },
        yAxis: {
            show:false
        },
        xAxis: {
            type:'category',
            data: yAxis_data,
            axisLabel: {
                show: true,
                textStyle: {
                    color: '#fff',
                }
            },
            max:4.3,
          //  barGap:'1%',

            boundaryGap:false,
            axisTick:{
                //show:true,
                interval:0,
            },
            // y 轴线
            axisLine:{
                show:false,

            },
            // 分割线设置
            splitLine:{
                show:false,  //显示分割线
            },
            axisLabel:{
                textStyle: {
                    color: '#fff',
                    fontSize:10,

                },
                interval: 0,
            }
        },
        series: series
    };
    return option;
}
function chartBarForOrgOld2(title_text,legend_data,yAxis_data,series) {
    var option = {
        title: {
            text:title_text,
            textStyle:{
                color:'#fff',
                fontSize:20,
                fontWeight:'normal'
            },
            x:'0%',
            y:'0%',
        },
        tooltip:{
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        legend: {
            orient: 'vertical',
            right:'0',
            data:legend_data
        },
        grid:  {
            top:'50%',
            left: '3%',
            right: '16%',
            bottom: '-5%',
            containLabel: true
        },
        xAxis: {
            show:false
        },
        yAxis: {
            type:'category',
            data: yAxis_data,
            // axisLabel: {
            //     show: true,
            //     textStyle: {
            //         color: '#fff',
            //     }
            // },
            boundaryGap:false,
            axisTick:{
                show:false
            },
            // y 轴线
            axisLine:{
                show:false,

            },
            // 分割线设置
            splitLine:{
                show:false,  //显示分割线
            },
            axisLabel:{
                textStyle: {
                    color: '#fff',
                    fontSize:4,
                    interval: 0,
                },
                interval:0,
            }
        },
        series: series
    };
    return option;
}
//chartBar for part label
function chartBarPartAge(title_text,legend_data,yAxis_data,series) {
    var option = {
        title: {
            text:title_text,
            textStyle:{
                color:'#fff',
                fontSize:title_fontSize,
                fontWeight:'normal'
            },
            x:'0%',
            y:'0%',
        },
        tooltip:{
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        legend: {
            orient: 'horizontal',
            right:'0',
            data:legend_data
        },
        grid:  {
            top:'25%',
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: {
            show:false
        },
        yAxis: {
            type:'category',
            data: yAxis_data,
            // axisLabel: {
            //     show: true,
            //     textStyle: {
            //         color: '#fff',
            //     }
            // },
            boundaryGap:false,
            axisTick:{
                show:false
            },
            // y 轴线
            axisLine:{
                show:false,

            },
            // 分割线设置
            splitLine:{
                show:false,  //显示分割线
            },
            axisLabel:{
                textStyle: {
                    color: '#fff',
                    fontSize:yAxis_axisLabel_fontSize_bar,
                    interval: 0,
                }
            }
        },
        series: series
    };
    return option;
}
//chartBarForBaseAge
function chartBarFBA(title_text,legend_data,yAxis_data,series) {
    var option = {
        title: {
            text:title_text,
            textStyle:{
                color:'#fff',
                fontSize:title_fontSize,
                fontWeight:'normal'
            },
            x:'0%',
            y:'0%',
        },
        tooltip:{
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        legend: {
            orient: 'horizontal',
            right:'0',
            data:legend_data
        },
        grid:  {
            top:'25%',
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: {
            show:false
        },
        yAxis: {
            type:'category',
            data: yAxis_data,
            // axisLabel: {
            //     show: true,
            //     textStyle: {
            //         color: '#fff',
            //     }
            // },
            boundaryGap:false,
            axisTick:{
                show:false
            },
            // y 轴线
            axisLine:{
                show:false,

            },
            // 分割线设置
            splitLine:{
                show:false,  //显示分割线
            },
            axisLabel:{
                textStyle: {
                    color: '#fff',
                    fontSize:yAxis_axisLabel_fontSize_bar,
                    interval: 0,
                }
            }
        },
        series: series
    };
    return option;
}
//new
function chartBar2(title_text,legend_data,yAxis_data,series) {
    var option = {
        title: {
            text:title_text,
            textStyle:{
                color:'#fff',
                fontSize:title_fontSize,
                fontWeight:'normal'
            },
            x:'0%',
            y:'0%',
        },
        tooltip:{
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        legend: {
            orient: 'horizontal',
            right:'0',
            data:legend_data
        },
        grid:  {
            top:'25%',
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: {
            show:false
        },
        yAxis: {
            type:'category',
            data: yAxis_data,
            // axisLabel: {
            //     show: true,
            //     textStyle: {
            //         color: '#fff',
            //     }
            // },
            boundaryGap:false,
            axisTick:{
                show:false
            },
            // y 轴线
            axisLine:{
                show:false,

            },
            // 分割线设置
            splitLine:{
                show:false,  //显示分割线
            },
            axisLabel:{
                textStyle: {
                    color: '#fff',
                    fontSize:yAxis_axisLabel_fontSize_bar,
                    interval:0,//轴信息全部显示
                    rotate:15,//-15度角倾斜显示


                }
            }
        },
        series: series
    };
    return option;
}
function chartBarForChx(title_text,legend_data,yAxis_data,series) {
    var option = {
        title: {
            text:title_text,
            textStyle:{
                color:'#fff',
                fontSize:18,
                fontWeight:'normal'
            },
            x:'0%',
            y:'-3%',
        },
        tooltip:{
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        legend: {
            orient: 'horizontal',
            right:'0',
            data:legend_data
        },
        grid:  {
            top:'45%',
            left: '3%',
            right: '4%',
            bottom: '0%',
            containLabel: true
        },
        xAxis: {
            show:false
        },
        yAxis: {
            type:'category',
            data: yAxis_data,
            // axisLabel: {
            //     show: true,
            //     textStyle: {
            //         color: '#fff',
            //     }
            // },
            boundaryGap:false,
            axisTick:{
                show:false
            },
            // y 轴线
            axisLine:{
                show:false,

            },
            // 分割线设置
            splitLine:{
                show:false,  //显示分割线
            },
            axisLabel:{
                textStyle: {
                    color: '#fff',
                    fontSize:8,
                    interval:0,//轴信息全部显示
                    rotate:15,//-15度角倾斜显示
                },
                interval:0
            }
        },
        series: series
    };
    return option;
}
function chartBarForChxJi(title_text,legend_data,yAxis_data,series) {
    var option = {
        title: {
            text:title_text,
            textStyle:{
                color:'#fff',
                fontSize:18,
                fontWeight:'normal'
            },
            x:'0%',
            y:'-3%',
        },
        tooltip:{
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        legend: {
            orient: 'horizontal',
            right:'0',
            data:legend_data
        },
        grid:  {
            top:'45%',
            left: '3%',
            right: '4%',
            bottom: '-25%',
            containLabel: true
        },
        xAxis: {
            show:false
        },
        yAxis: {
            type:'category',
            data: yAxis_data,
            // axisLabel: {
            //     show: true,
            //     textStyle: {
            //         color: '#fff',
            //     }
            // },
            boundaryGap:false,
            axisTick:{
                show:false
            },
            // y 轴线
            axisLine:{
                show:false,

            },
            // 分割线设置
            splitLine:{
                show:false,  //显示分割线
            },
            axisLabel:{
                textStyle: {
                    color: '#fff',
                    fontSize:5,
                    interval:0,//轴信息全部显示
                    rotate:15,//-15度角倾斜显示
                },
                interval:0
            }
        },
        series: series
    };
    return option;
}
function chartBar3(title_text,legend_data,yAxis_data,series) {
    var option = {
        title: {
            text:title_text,
            textStyle:{
                color:'#fff',
                fontSize:title_fontSize,
                fontWeight:'normal'
            },
            x:'0%',
            y:'0%',
        },
        tooltip:{
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        legend: {
            orient: 'vertical',
            right:'0',
            data:legend_data
        },
        grid:  {
            top:'25%',
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: {
            show:false
        },
        yAxis: {
            type:'category',
            data: yAxis_data,
            // axisLabel: {
            //     show: true,
            //     textStyle: {
            //         color: '#fff',
            //     }
            // },
            boundaryGap:false,
            axisTick:{
                show:false
            },
            // y 轴线
            axisLine:{
                show:false,

            },
            // 分割线设置
            splitLine:{
                show:false,  //显示分割线
            },
            axisLabel:{
                textStyle: {
                    color: '#fff',
                    fontSize:yAxis_axisLabel_fontSize_bar,
                    interval:0,//轴信息全部显示
                    rotate:15,//-15度角倾斜显示


                }
            }
        },
        series: series
    };
    return option;
}

function chartBar_for_organ(title_text,legend_data,yAxis_data,series) {
    var option = {
        title: {
            text:title_text,
            textStyle:{
                color:'#fff',
                fontSize:title_fontSize,
                fontWeight:'normal'
            },
            x:'0%',
            y:'0%',
        },
        tooltip:{
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        legend: {
            orient: 'vertical',
            right:'0',
            data:legend_data
        },
        grid:  {
            top:'25%',
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: {
            show:false
        },
        yAxis: {
            type:'category',
            data: yAxis_data,
            // axisLabel: {
            //     show: true,
            //     textStyle: {
            //         color: '#fff',
            //     }
            // },
            boundaryGap:false,
            axisTick:{
                show:false
            },
            // y 轴线
            axisLine:{
                show:false,

            },
            // 分割线设置
            splitLine:{
                show:false,  //显示分割线
            },
            axisLabel:{
                textStyle: {
                    color: '#fff',
                    fontSize:yAxis_axisLabel_fontSize_bar,
                    interval:0,//轴信息全部显示
                    rotate:15,//-15度角倾斜显示


                }
            }
        },
        series: series
    };
    return option;
}

//折线图
function chartLine(title_text,legend_data,xAxis_data,series) {
    var option = {
        title: {
            text:title_text,
            textStyle:{
                color:'#fff',
            fontSize:20,
            fontWeight:'normal'
            },
            x:'0%',
            y:'0%'
        },
        tooltip:{
            trigger: 'axis'
        },
        legend: {
            right:'0',
            top:'6%',
            data:legend_data
        },
        grid:  {
            left: '3%',
            right: '4%',
            bottom: '-3%',
            top:'30%',
            containLabel: true
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data:xAxis_data,
            nameTextStyle: {
                color: ['#fff'],
            },
            axisLine:{
                lineStyle:{
                    color:'#fff',
                    width:1//这里是为了突出显示加上的
                }
            },
            axisTrack:{
                length:1
            },
            splitLine:{
                show:false
            },
            axisLabel:{
                textStyle: {
                    color: '#fff',
                    fontSize:10,
                    fontWeight:100

                }
            }

        },
        yAxis: {
            type: 'value',
            nameTextStyle: {
                color: ['#fff'],
            },
            splitLine:{
                show:false
            },
            axisLine:{
                lineStyle:{
                    color:'#fff',
                    width:1,//这里是为了突出显示加上的
                }
            },
            axisTrack:{
                length:1
            },
            axisLabel:{
                textStyle: {
                    color: '#fff',
                    fontSize:10,
                    fontWeight:100
                }
            },
            min:0,
            max:45000,
            splitNumber:3
        },
        series: series,
    };
    return option;
}
function chartLineForFamily(title_text,legend_data,xAxis_data,series) {
    var option = {
        title: {
            text:title_text,
            textStyle:{
                color:'#fff',
                fontSize:title_fontSize,
                fontWeight:'normal'
            },
            x:'0%',
            y:'0%'
        },
        tooltip:{
            trigger: 'axis'
        },
        legend: {
            // right:'-50',
            left:'50',
            top:'16%',
            data:legend_data,
        },
        grid:  {
            left: '3%',
            right: '4%',
            bottom: '3%',
            top:'20%',
            containLabel: true
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data:xAxis_data,
            nameTextStyle: {
                color: ['#fff'],
            },
            axisLine:{
                lineStyle:{
                    color:'#fff',
                    width:1//这里是为了突出显示加上的
                }
            },
            axisTrack:{
                length:1
            },
            splitLine:{
                show:false
            },
            axisLabel:{
                textStyle: {
                    color: '#fff',
                    fontSize:xAxis_axisLabel_fontSize,
                    fontWeight:100

                }
            }

        },
        yAxis: {
            type: 'value',
            nameTextStyle: {
                color: ['#fff'],
            },
            splitLine:{
                show:false
            },
            axisLine:{
                lineStyle:{
                    color:'#fff',
                    width:1,//这里是为了突出显示加上的
                }
            },
            axisTrack:{
                length:1
            },
            axisLabel:{
                textStyle: {
                    color: '#fff',
                    fontSize:10,
                    fontWeight:100
                }
            },
            min:0,
            max:100,
            splitNumber:3
        },
        series: series,
    };
    return option;
}

//饼图
function chartPie(title_text,legend_data,series) {
    //不用能以下方式 容易出现两个图一样的标题 应该是异步  不同步造成
    var option = {
        title : {
            text:title_text,
            textStyle:{
                color:'#fff',
                fontSize:title_fontSize,
                fontWeight: 'normal'
            },
            left:'left',
            x:'0%',
            y:'0%'
        },
        tooltip : {
            trigger: 'item',
            formatter: ""
        },
        legend: {
            orient: 'vertical',
            left:'right',
            // right: '0',
            top:"0",
            height:"250",
            data: legend_data,
        },
        series :series,
        color: [series_color_1,series_color_2,series_color_3,series_color_4,series_color_5,series_color_6,series_color_7],
    };
    return option;
}
size_bed=16;
function chartPieForOrgOld(title_text,legend_data,series) {
    //不用能以下方式 容易出现两个图一样的标题 应该是异步  不同步造成
    var option = {
        title : {
            text:title_text,
            textStyle:{
                color:'#fff',
                fontSize:size_bed,
                fontWeight: 'normal'
            },
            left:'left',
            x:'0%',
            y:'0%'
        },
        tooltip : {
            trigger: 'item',
            formatter: ""
        },
        legend: {
            orient: 'horizontal',
           // left:'right',
            // right: '0',
            //right:'180',
            // left:'10',
            top:"-5",
            right:'20',
            data: legend_data,
            itemGap: 0,
            itemWidth: 18,
            itemHeight: 8,
},
        series :series,
        color: [series_color_1,series_color_2,series_color_3,series_color_4,series_color_5,series_color_6,series_color_7],
    };
    return option;
}
function chartPieForOrgOldHealth(title_text,legend_data,series) {
    //不用能以下方式 容易出现两个图一样的标题 应该是异步  不同步造成
    var option = {
        title : {
            text:title_text,
            textStyle:{
                color:'#fff',
                fontSize:size_bed,
                fontWeight: 'normal'
            },
            left:'left',
            x:'0%',
            y:'0%'
        },
        tooltip : {
            trigger: 'item',
            formatter: ""
        },
        legend: {
            orient: 'horizontal',
            // left:'right',
            // right: '0',
            //right:'180',
            // left:'10',
            top:"-5",
            right:'12',
            data: legend_data,
            itemGap: 0,
            itemWidth: 18,
            itemHeight: 8,

        },
        series :series,
        color: [series_color_1,series_color_2,series_color_3,series_color_4,series_color_5,series_color_6,series_color_7],
    };
    return option;
}
function chartPieForChx(title_text,legend_data,series) {
    //不用能以下方式 容易出现两个图一样的标题 应该是异步  不同步造成
    var option = {
        title : {
            text:title_text,
            textStyle:{
                color:'#fff',
                fontSize:18,
                fontWeight: 'normal'
            },
            left:'left',
            x:'0%',
            y:'0%'
        },
        tooltip : {
            trigger: 'item',
            formatter: ""
        },
        legend: {
            orient: 'vertical',
            left:'right',
            // right: '0',
            top:"0",
            data: legend_data,
        },
        series :series,
        color: [series_color_1,series_color_2,series_color_3,series_color_4,series_color_5,series_color_6,series_color_7],
    };
    return option;
}
//new pie for yly,zz
function chartPie2(title_text,legend_data,series) {
    //不用能以下方式 容易出现两个图一样的标题 应该是异步  不同步造成
    var option = {
        title : {
            text:title_text,
            textStyle:{
                color:'#fff',
                fontSize:title_fontSize,
                fontWeight: 'normal'
            },
            left:'left',
            x:'0%',
            y:'0%'
        },
        tooltip : {
            trigger: 'item',
            formatter: ""
        },
        legend: {
            orient: 'vertical',
            left:'right',
            // right: '0',
            top:"0",
            data: legend_data,
        },
        series :series,
        color: [series_color_1,series_color_2,series_color_3,series_color_4,series_color_5,series_color_6,series_color_7],
    };
    return option;
}
function chartPie_for_big_SN(title_text,legend_data,series) {
    //不用能以下方式 容易出现两个图一样的标题 应该是异步  不同步造成
    var option = {
        title : {
            text:title_text,
            textStyle:{
                color:'#fff',
                fontSize:title_fontSize,
                fontWeight: 'normal'
            },
            left:'left',
            x:'0%',
            y:'0%'
        },
        tooltip : {
            trigger: 'item',
            formatter: ""
        },
        legend: {
            orient: 'horizontal',
            left:'right',
            // right: '0',
            top:"0",
            data: legend_data,
        },
        series :series,
        color: [series_color_1,series_color_2,series_color_3,series_color_4,series_color_5,series_color_6,series_color_7],
    };
    return option;
}
//饼图
function chartPieClick(title,legend_data,series) {
    var option = {
        title : title,
        tooltip : {
            trigger: 'item',
            formatter: ""
        },
        legend: {
            orient: 'vertical',
            right: '0',
            top:"0",
            align:"right",
            height:"500",
           // type:"scroll",
            data: legend_data
        },
        grid:  {
            top:'25%',
            left: '3%',
            right: '4%',
            bottom: '-30%',
            containLabel: true
        },
        series :series,
        color: [series_color_1,series_color_2,series_color_3,series_color_4,series_color_5,series_color_6,series_color_7]
    };
    return option;
}


function chartPie_1(title_text,legend_data,series) {
    var option = {
        title : {
            text: title_text,
            textStyle:{
                color:title_color,
                fontSize:title_fontSize,
                fontWeight: 'normal'
            },
            x:'0%',
            y:'0%'
        },
        graphic:{
            type:'text',
            left:'center',
            top:'center',
            style:{
                text:'',
                textAlign:'center',
                fill:'#fff',
                width:100,
                height:100,
                font: '2em "STHeiti", sans-serif'
            }
        },
        tooltip : {
            trigger: 'item',
            formatter: ""
        },
        legend: {
            orient: 'vertical',
            right: '0',
            top:"0",
            data: legend_data
        },
        series :series,
        color: [series_color_1,series_color_2,series_color_3,series_color_4,series_color_5,series_color_6,series_color_7]
    };
    return option;
}

function chartPie_1Click(title,legend_data,series) {
    var option = {
        title : {
            text: title_text,
            textStyle:{
                color:title_color,
                fontSize:title_fontSize,
                fontWeight: 'normal'
            },
            x:'0%',
            y:'0%'
        },
        graphic:{
            type:'text',
            left:'center',
            top:'center',
            style:{
                text:'总人数:1562',
                textAlign:'center',
                fill:'#fff',
                width:100,
                height:100,
                font: '2em "STHeiti", sans-serif'
            }
        },
        tooltip : {
            trigger: 'item',
            formatter: ""
        },
        legend: {
            orient: 'vertical',
            right: '0',
            top:"0",
            data: legend_data
        },
        series :series,
        color: [series_color_1,series_color_2,series_color_3,series_color_4,series_color_5,series_color_6,series_color_7]
    };
    return option;
}

//横向条形图
function chartBarHei(title_text,legend_data,xAxis_data,series) {
    var option = {
        title: {
            text:title_text,
            textStyle:{
                color:'#fff',
                fontSize:title_fontSize,
                fontWeight: 'normal'
            },
            x:'0%',
            y:'0%'
        },
        tooltip:{
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        legend: {
            orient: 'vertical',
            right:'0',
            data:legend_data
        },
        grid:  {
            top:'25%',
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis : [
            {
                type : 'category',
                data : xAxis_data,
                axisLabel:{
                    textStyle: {
                        color: '#fff',
                        fontSize:xAxis_axisLabel_fontSize_barHei,
                        fontWeight:100
                    },
                    show:true,
                    interval: 0//,
                },
                axisLine:{
                    lineStyle: {
                        color: '#fff'
                    }
                }
            }
        ],
        yAxis:[
            {
                type : 'value',
                axisLabel:{
                    textStyle: {
                        color: '#fff',
                        fontSize:yAxis_axisLabel_fontSize_barHei,
                        fontWeight:100
                    }
                },
                axisLine:{
                    lineStyle: {
                        color: '#fff'
                    }
                },
                splitLine:{
                    show:false
                }
            }
        ],
        series: series,
        color: [series_color_1,series_color_2,series_color_3,series_color_4,series_color_5,series_color_6,series_color_7]
    };
    return option;
}
function chartBarHeiForFinish(title_text,legend_data,xAxis_data,series) {
    var option = {
        title: {
            text:title_text,
            textStyle:{
                color:'#fff',
                fontSize:title_fontSize,
                fontWeight: 'normal'
            },
            x:'0%',
            y:'0%'
        },
        tooltip:{
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        legend: {
            orient: 'vertical',
            right:'0',
            data:legend_data
        },
        grid:  {
            top:'35%',
            left: '3%',
            right: '4%',
            bottom: '-1%',
            containLabel: true
        },
        xAxis : [
            {
                type : 'category',
                data : xAxis_data,
                axisLabel:{
                    textStyle: {
                        color: '#fff',
                        fontSize:16,
                        fontWeight:'normal'
                    },
                    show:true,
                    interval: 0,
                    rotate: 60,
                },
                axisLine:{
                    lineStyle: {
                        color: '#fff'
                    }
                }
            }
        ],
        yAxis:[
            {
                type : 'value',
                axisLabel:{
                    textStyle: {
                        color: '#fff',
                        fontSize:yAxis_axisLabel_fontSize_barHei,
                        fontWeight:'normal'
                    }
                },
                axisLine:{
                    lineStyle: {
                        color: '#fff'
                    }
                },
                splitLine:{
                    show:false
                }
            }
        ],
        series: series,
        color: [series_color_1,series_color_2,series_color_3,series_color_4,series_color_5,series_color_6,series_color_7]
    };
    return option;
}
function chartBarHei_1(title_text,legend_data,xAxis_data,series) {
    var option = {
        title: {
            text:title_text,
            textStyle:{
                color:'#fff',
                fontSize:title_fontSize,
                fontWeight: 'normal'
            },
            x:'0%',
            y:'0%'
        },
        tooltip:{
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        legend: {
            right:'0',
            data:legend_data
        },
        grid:  {
            top:'25%',
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis : [
            {
                type : 'category',
                data : xAxis_data,
                axisLabel:{
                    textStyle: {
                        color: '#fff',
                        fontSize:xAxis_axisLabel_fontSize_barHei,
                        fontWeight:100
                    },
                    show:true,
                    interval: 0//,
                },
                axisLine:{
                    lineStyle: {
                        color: '#fff'
                    }
                }
            }
        ],
        yAxis:[
            {
                type : 'value',
                axisLabel:{
                    textStyle: {
                        color: '#fff',
                        fontSize:yAxis_axisLabel_fontSize_barHei,
                        fontWeight:100
                    }
                },
                axisLine:{
                    lineStyle: {
                        color: '#fff'
                    }
                },
                splitLine:{
                    show:false
                }
            }
        ],
        series: series,
        color: [series_color_1,series_color_2,series_color_3,series_color_4,series_color_5,series_color_6,series_color_7]
    };
    return option;
}


function chartBarHeiSimpleAll(title_text,legend_data,xAxis_data,series) {
    var option = {
        title: {
            text:title_text,
            textStyle:{
                color:'#fff',
                fontSize:title_fontSize,
                fontWeight: 'normal'
            },
            x:'0%',
            y:'0%'
        },
        tooltip:{
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        legend: {
            orient: 'horizontal',
            right:'0',
            data:legend_data
        },
        grid: {
            y2: 140
        },
        xAxis: {
            type: 'category',
            boundaryGap: [0, 0.01],
            data : xAxis_data,
            axisLine:{
                lineStyle: {
                    color: '#fff',
                    fontSize:xAxis_axisLabel_fontSize_barHei,
                    fontWeight:100
                }
            },
            axisLabel:{
                interval:0,//横轴信息全部显示
                rotate:-30,//-30度角倾斜显示
                textStyle: {
                    color: '#fff'
                }
            }
        },
        yAxis:[
            {
                type : 'value',
                axisLabel:{
                    textStyle: {
                        color: '#fff',fontSize:yAxis_axisLabel_fontSize_barHei,
                        fontWeight:100
                    }
                },
                axisLine:{
                    lineStyle: {
                        color: '#fff'
                    }
                },
                splitLine:{
                    show:false
                }
            }
        ],
        series: series
    };
    return option;
}

function customizedPieClick(title,data) {
    var option = {
        title : title,
        tooltip : {
            trigger: 'item',
            formatter: ""
        },

        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },

        visualMap: {
            show: false,
            min: 80,
            max: 600,
            inRange: {
                colorLightness: [0, 1]
            }
        },
        series : [
            {
                name:'',
                type:'pie',
                radius : '65%',
                center: ['50%', '50%'],
                // data:[
                //     {value:335, name:dataName1},
                //     {value:310, name:dataName2},
                //     {value:400, name:dataName3},
                // ].sort(function (a, b) { return a.value - b.value; }),
                data:data.sort(function (a, b) { return a.value - b.value; }),
                roseType: 'radius',
                label: {
                    normal: {
                        textStyle: {
                            fontWeight: 'normal',      //标题颜色
                            color: '#FFFFFF',
                            fontSize: 12
                        }
                    }
                },
                labelLine: {
                    normal: {
                        lineStyle: {
                            color: 'rgba(255, 255, 255, 0.3)'
                        },
                        smooth: 0.2,
                        length: 10,
                        length2: 20
                    }
                },
                itemStyle: {
                    normal: {
                        color: series_color_5,
                        shadowBlur: 200,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                },

                animationType: 'scale',
                animationEasing: 'elasticOut',
                animationDelay: function (idx) {
                    return Math.random() * 200;
                }
            }
        ]
    };
    return option;
}

function customizedPie(title_text,data,legend_data) {
    var option = {

        title : {
            text:title_text,
            textStyle:{
                color:title_color,
                fontSize:title_fontSize,
                fontWeight: 'normal'
            },
            x:'0%',
            y:'0%'
        },
        tooltip : {
            trigger: 'item',
            formatter: ""
        },

        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            // left:'0',
            // top:'6%',
            orient: 'vertical',
            right: '0',
            top:"0",
            data:legend_data
        },

        visualMap: {
            show: false,
            min: 80,
            max: 600,
            inRange: {
                colorLightness: [0, 1]
            }
        },
        series : [
            {
                name:'',
                type:'pie',
                startAngle:90,
                radius : '45%',
                center: ['25%', '65%'],
                // data:[
                //     {value:335, name:dataName1},
                //     {value:310, name:dataName2},
                //     {value:400, name:dataName3},
                // ].sort(function (a, b) { return a.value - b.value; }),
                data:data,
                roseType: 'radius',
                label: {
                    normal: {
                        textStyle: {
                            fontWeight: 'normal',      //标题颜色
                            color: '#FFFFFF',
                            fontSize: 12
                        }
                    }
                },
                labelLine: {
                    normal: {
                        lineStyle: {
                            color: 'rgba(255, 255, 255, 0.3)'
                        },
                        smooth: 0.2,
                        length: 2,
                        length2: 2
                    }
                },
                itemStyle: {
                    normal: {
                        color: series_color_5,
                        shadowBlur: 200,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                },

                animationType: 'scale',
                animationEasing: 'elasticOut',
                animationDelay: function (idx) {
                    return Math.random() * 200;
                }
            }
        ]
    };
    return option;
}

function customizedPie2(title_text,data,legend_data) {
    var option = {

        title : {
            text:title_text,
            textStyle:{
                color:title_color,
                fontSize:title_fontSize,
                fontWeight: 'normal'
            },
            x:'0%',
            y:'0%'
        },

        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            // left:'0',
            // top:'6%',
            orient: 'vertical',
            right: '0',
            top:"0",
            data:legend_data
        },

        visualMap: {
            show: false,
            min: 80,
            max: 600,
            inRange: {
                colorLightness: [0, 1]
            }
        },
        series : [
            {
                name:'',
                type:'pie',
                radius : '45%',
                center: ['50%', '65%'],
                // data:[
                //     {value:335, name:dataName1},
                //     {value:310, name:dataName2},
                //     {value:400, name:dataName3},
                // ].sort(function (a, b) { return a.value - b.value; }),
                data:data,
                roseType: 'radius',
                label: {
                    normal: {
                        textStyle: {
                            fontWeight: 'normal',      //标题颜色
                            color: '#FFFFFF',
                            fontSize: 12
                        }
                    }
                },
                labelLine: {
                    normal: {
                        lineStyle: {
                            color: 'rgba(255, 255, 255, 0.3)'
                        },
                        smooth: 0.2,
                        length: 10,
                        length2: 20
                    }
                },
                itemStyle: {
                    normal: {
                        color: series_color_4,
                        shadowBlur: 200,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                },

                animationType: 'scale',
                animationEasing: 'elasticOut',
                animationDelay: function (idx) {
                    return Math.random() * 200;
                }
            }
        ]
    };
    return option;
}
function customizedPieOrgan(title,data,legend_data) {
    var option = {

        title : title,

        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            // left:'0',
            // top:'6%',
            orient: 'vertical',
            right: '0',
            top:"0",
            data:legend_data
        },

        visualMap: {
            show: false,
            min: 80,
            max: 600,
            inRange: {
                colorLightness: [0, 1]
            }
        },
        series : [
            {
                name:'',
                type:'pie',
                radius : '45%',
                center: ['50%', '65%'],
                // data:[
                //     {value:335, name:dataName1},
                //     {value:310, name:dataName2},
                //     {value:400, name:dataName3},
                // ].sort(function (a, b) { return a.value - b.value; }),
                data:data,
                roseType: 'radius',
                label: {
                    normal: {
                        textStyle: {
                            fontWeight: 'normal',      //标题颜色
                            color: '#FFFFFF',
                            fontSize: 12
                        }
                    }
                },
                labelLine: {
                    normal: {
                        lineStyle: {
                            color: 'rgba(255, 255, 255, 0.3)'
                        },
                        smooth: 0.2,
                        length: 10,
                        length2: 20
                    }
                },
                itemStyle: {
                    normal: {
                        color: series_color_2,
                        shadowBlur: 200,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                },

                animationType: 'scale',
                animationEasing: 'elasticOut',
                animationDelay: function (idx) {
                    return Math.random() * 200;
                }
            }
        ]
    };
    return option;
}
function customizedPie3(title1,data,legend_data) {
    var option = {

        title : title1,
        legend: {
            // left:'0',
            // top:'6%',
            orient: 'vertical',
            right: '0',
            top:"0",
            data:legend_data
        },

        visualMap: {
            show: false,
            min: 80,
            max: 600,
            inRange: {
                colorLightness: [0, 1]
            }
        },
        series : [
            {
                name:'',
                type:'pie',
                radius : '65%',
                center: ['50%', '50%'],
                // data:[
                //     {value:335, name:dataName1},
                //     {value:310, name:dataName2},
                //     {value:400, name:dataName3},
                // ].sort(function (a, b) { return a.value - b.value; }),
                data:data,
                roseType: 'radius',
                label: {
                    normal: {
                        textStyle: {
                            fontWeight: 'normal',      //标题颜色
                            color: '#FFFFFF',
                            fontSize: 12
                        }
                    }
                },
                labelLine: {
                    normal: {
                        lineStyle: {
                            color: 'rgba(255, 255, 255, 0.3)'
                        },
                        smooth: 0.2,
                        length: 10,
                        length2: 20
                    }
                },
                itemStyle: {
                    normal: {
                        color: series_color_4,
                        shadowBlur: 200,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                },

                animationType: 'scale',
                animationEasing: 'elasticOut',
                animationDelay: function (idx) {
                    return Math.random() * 200;
                }
            }
        ]
    };
    return option;
}
function toolTip(title_text,legend_data,name1,name2) {
    var base = +new Date(2016, 9, 3);
    var oneDay = 24 * 3600 * 1000;
    var valueBase = Math.random() * 300;
    var valueBase2 = Math.random() * 50;
    var data = [];
    var data2 = [];

    var myDate=new Date();
    var myMonth;
    var oneMonth=-2;
    var xData=[];
    var xData2=[];

    var dayStr;
    for (var i = 1; i < 6; i++) {
        //var now = new Date(base += oneDay);


        myMonth=myDate.getMonth()+1;
        month=myMonth+oneMonth;
        if(month==12){
            dayStr=myDate.getFullYear()+'-'+month;
        }else{
            dayStr=myDate.getFullYear()+'-'+month%12;
        }
        //var dayStr = [now.getFullYear(), month].join('-');
        //alert(dayStr);
        oneMonth++;
        valueBase = Math.round((Math.random() - 0.5) * 20 + valueBase);
        valueBase <= 0 && (valueBase = Math.random() * 300);
        data.push([dayStr, valueBase]);
        xData.push(dayStr);

        valueBase2 = Math.round((Math.random() - 0.5) * 20 + valueBase2);
        valueBase2 <= 0 && (valueBase2 = Math.random() * 50);
        data2.push([dayStr, valueBase2]);
        xData2.push(dayStr);

    }


    console.log(xData);
    option = {
        animation: false,
        title: {
            left: 'left',
            text: title_text,
            subtext: '',
            textStyle: {
                fontWeight: 'normal',      //标题颜色
                color: '#FFFFFF',
                fontSize: title_fontSize
            },
        },
        legend: {
            x:'right',
            y:'top',
            data:legend_data,

            textStyle: {
                fontWeight: 'normal',
                color: 'white'
            }
        },
        // tooltip: {
        //     triggerOn: 'none',
        //     position: function (pt) {
        //         return [pt[0], 130];
        //     }
        // },
        // toolbox: {
        //     left: 'center',
        //     itemSize: 25,
        //     top: 55,
        //     feature: {
        //         dataZoom: {
        //             yAxisIndex: 'none'
        //         },
        //         restore: {}
        //     }
        // },
        xAxis: {
            type: 'category',
            // boundaryGap: [0, 0],
            axisPointer: {
                value: '2016-10-7',
                snap: true,
                lineStyle: {
                    color: '#004E52',
                    opacity: 0.5,
                    width: 2
                },
                label: {
                    show: true,
                    formatter: function (params) {
                        return echarts.format.formatTime('yyyy-MM', params.value);
                    },
                    backgroundColor: '#004E52'
                },
                handle: {
                    show: true,
                    color: '#004E52'
                }
            },
            splitLine: {
                show: false
            },
            axisLine:{
                lineStyle:{
                    color:'white',
                    fontSize: 20
                }
            },
            data:xData
        },
        yAxis: {
            type: 'value',
            axisTick: {
                inside: true
            },
            splitLine: {
                show: false
            },
            axisLabel: {
                inside: true,
                formatter: '{value}\n'
            },
            axisLine:{
                lineStyle:{
                    color:'white',
                    fontSize: 20
                }
            },

            z: -5
        },
        grid: {
            top: 45,
            left: 15,
            right: 15,
            height: 100
        },
        dataZoom: [{
            type: 'inside',
            throttle: 50
        }],
        series: [
            {
                name:name1,
                type:'line',
                smooth: true,
                symbol: 'circle',
                symbolSize: 5,
                sampling: 'average',
                itemStyle: {
                    normal: {
                        color: '#8ec6ad'
                    }
                },
                stack: 'a',
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: '#8ec6ad'
                        }, {
                            offset: 1,
                            color: '#ffe'
                        }])
                    }
                },
                data:data
            },
            {
                name:name2,
                type:'line',
                smooth:true,
                stack: 'a',
                symbol: 'circle',
                symbolSize: 5,
                sampling: 'average',
                itemStyle: {
                    normal: {
                        color: '#d68262'
                    }
                },
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: '#d68262'
                        }, {
                            offset: 1,
                            color: '#ffe'
                        }])
                    }
                },
                data: data2
            },

        ]
    };

    return option;
}
function toolTipReal(title_text,legend_data,name1,name2,data_t1,data_t2) {
    var base = +new Date(2016, 9, 3);
    var oneDay = 24 * 3600 * 1000;
    var valueBase = Math.random() * 300;
    var valueBase2 = Math.random() * 50;
    var data = [];
    var data2 = [];

    var myDate=new Date();
    var myMonth;
    var oneMonth=-2;
    var xData=[];
    var xData2=[];

    var dayStr;
    myMonth=myDate.getMonth()+1;
    for (var i = 0; i < 5; i++) {
        //var now = new Date(base += oneDay);

        month=myMonth+oneMonth;
        //
        if(month<=0){
            month=12+month;
            dayStr=myDate.getFullYear()-1+'-'+month;
        }
        else{
            dayStr=myDate.getFullYear()+'-'+month;
        }
        //
        // if(month==12){
        //     dayStr=myDate.getFullYear()+'-'+month;
        // }else{
        //     if(month>12)
        //     dayStr=(myDate.getFullYear()+1)+'-'+(month-12);
        //     else
        //     {
        //         dayStr=myDate.getFullYear()+'-'+month;
        //     }
        // }

        oneMonth++;
        valueBase = Math.round((Math.random() - 0.5) * 20 + valueBase);
        valueBase <= 0 && (valueBase = Math.random() * 300);
        data.push([dayStr, data_t1[i]]);
        xData.push(dayStr);

        valueBase2 = Math.round((Math.random() - 0.5) * 20 + valueBase2);
        valueBase2 <= 0 && (valueBase2 = Math.random() * 50);
        data2.push([dayStr, data_t2[i]]);
        xData2.push(dayStr);

    }


    console.log(xData);
    option = {
        animation: false,
        title: {
            left: 'left',
            text: title_text,
            subtext: '',
            textStyle: {
                fontWeight: 'normal',      //标题颜色
                color: '#FFFFFF',
                fontSize: 20
            },
        },
        legend: {
            x:'right',
            y:'top',
            data:legend_data,

            textStyle: {
                fontWeight: 'normal',
                color: 'white'
            }
        },
        tooltip: {
            triggerOn: 'none',
            position: function (pt) {
                return [pt[0], 130];
            }
        },
        xAxis: {
            type: 'category',
            // boundaryGap: [0, 0],
            axisPointer: {
                value: '2016-10-7',
                snap: true,
                lineStyle: {
                    color: '#004E52',
                    opacity: 0.5,
                    width: 2
                },
                label: {
                    show: true,
                    formatter: function (params) {
                        return echarts.format.formatTime('yyyy-MM', params.value);
                    },
                    backgroundColor: '#004E52'
                },
                handle: {
                    show: false,
                    color: '#004E52'
                }
            },
            splitLine: {
                show: false
            },
            axisLine:{
                lineStyle:{
                    color:'white',
                    fontSize: 20
                }
            },
            data:xData
        },
        yAxis: {
            type: 'value',
            axisTick: {
                inside: true
            },
            splitLine: {
                show: false
            },
            axisLabel: {
                inside: true,
                formatter: '{value}\n'
            },
            axisLine:{
                lineStyle:{
                    color:'white',
                    fontSize: 20
                }
            },

            z: -5,
            min:0,
            max:15000,
            splitNumber:3
        },
        grid: {
            top: 40,
            left: 15,
            right: 15,
            height: 50,
            bottom:-30
        },
        dataZoom: [{
            type: 'inside',
            throttle: 50
        }],
        series: [
            {
                name:name1,
                type:'line',
                smooth: true,
                symbol: 'circle',
                symbolSize: 5,
                sampling: 'average',
                itemStyle: {
                    normal: {
                        color: '#8ec6ad'
                    }
                },
                stack: 'a',
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: '#8ec6ad'
                        }, {
                            offset: 1,
                            color: '#ffe'
                        }])
                    }
                },
                data:data
            },
            {
                name:name2,
                type:'line',
                smooth:true,
                stack: 'a',
                symbol: 'circle',
                symbolSize: 5,
                sampling: 'average',
                itemStyle: {
                    normal: {
                        color: '#d68262'
                    }
                },
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: '#d68262'
                        }, {
                            offset: 1,
                            color: '#ffe'
                        }])
                    }
                },
                data: data2
            },

        ]
    };

    return option;
}
function toolTipMulti1(title_text,legend_data,data_t1,data_t2,data_t3,data_t4) {
    var base = +new Date(2016, 9, 3);
    var oneDay = 24 * 3600 * 1000;
    var valueBase = Math.random() * 300;
    var valueBase2 = Math.random() * 50;
    var valueBase3 = Math.random() * 30;
    var valueBase4 = Math.random() * 10;
    var data = [];
    var data2 = [];
    var data3 = [];
    var data4 = [];

    var myDate=new Date();
    var myMonth;
    var oneMonth=-2;
    var xData=[];

    var dayStr;
    for (var i = 0; i < 5; i++) {
        //var now = new Date(base += oneDay);


        myMonth=myDate.getMonth()+1;
        month=myMonth+oneMonth;
        if(month<=0){
            month=12+month;
            dayStr=myDate.getFullYear()-1+'-'+month;
        }
        else{
            dayStr=myDate.getFullYear()+'-'+month;
        }
        // if(month==12){
        //     dayStr=myDate.getFullYear()+'-'+month;
        // }else{
        //     if(month>12)
        //         dayStr=(myDate.getFullYear()+1)+'-'+(month-12);
        //     else
        //     {
        //         dayStr=myDate.getFullYear()+'-'+month;
        //     }
        // }

        oneMonth++;
        valueBase = Math.round((Math.random() - 0.5) * 20 + valueBase);
        valueBase <= 0 && (valueBase = Math.random() * 300);
        data.push([dayStr, data_t1[i]]);
        xData.push(dayStr);

        valueBase2 = Math.round((Math.random() - 0.5) * 20 + valueBase2);
        valueBase2 <= 0 && (valueBase2 = Math.random() * 50);
        data2.push([dayStr, data_t2[i]]);


        valueBase3 = Math.round((Math.random() - 0.5) * 20 + valueBase3);
        valueBase3 <= 0 && (valueBase3 = Math.random() * 50);
        data3.push([dayStr, data_t3[i]]);


        valueBase4 = Math.round((Math.random() - 0.5) * 20 + valueBase4);
        valueBase4 <= 0 && (valueBase4 = Math.random() * 50);
        data4.push([dayStr, data_t4[i]]);


    }


    //console.log(xData);
    option = {
        animation: false,
        title: {
            left: 'left',
            text: title_text,
            subtext: '',
            textStyle: {
                fontWeight: 'normal',      //标题颜色
                color: '#FFFFFF',
                fontSize: 20
            },
        },
        legend: {
            x:'right',
            y:'top',
            width:'50%',
            data:legend_data,

            textStyle: {
                fontWeight: 'normal',
                color: 'white'
            }
        },
        tooltip: {
            triggerOn: 'none',
            position: function (pt) {
                return [pt[0], 130];
            }
        },
        xAxis: {
            type: 'category',
            // boundaryGap: [0, 0],
            axisPointer: {
                value: '2016-10-7',
                snap: true,
                lineStyle: {
                    color: '#004E52',
                    opacity: 0.5,
                    width: 2
                },
                label: {
                    show: true,
                    formatter: function (params) {
                        return echarts.format.formatTime('yyyy-MM', params.value);
                    },
                    backgroundColor: '#004E52'
                },
                handle: {
                    show: false,
                    color: '#004E52'
                }
            },
            splitLine: {
                show: false
            },
            axisLine:{
                lineStyle:{
                    color:'white',
                    fontSize: 20
                }
            },
            data:xData
        },
        yAxis: {
            type: 'value',
            axisTick: {
                inside: true
            },
            splitLine: {
                show: false
            },
            axisLabel: {
                inside: true,
                formatter: '{value}\n'
            },
            axisLine:{
                lineStyle:{
                    color:'white',
                    fontSize: 20
                }
            },

            z: -5,
            min:0,
            max:15000,
            splitNumber:3
        },
        grid: {
            top: 40,
            left: 15,
            right: 15,
            height: 50
        },
        dataZoom: [{
            type: 'inside',
            throttle: 50
        }],
        series: [
            {
                name:'60-70',
                type:'line',
                smooth: true,
                symbol: 'circle',
                symbolSize: 5,
                sampling: 'average',
                itemStyle: {
                    normal: {
                        color: '#8ec6ad'
                    }
                },
                stack: 'a',
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: '#8ec6ad'
                        }, {
                            offset: 1,
                            color: '#ffe'
                        }])
                    }
                },
                data: data
            },
            {
                name:'70-80',
                type:'line',
                smooth:true,
                stack: 'a',
                symbol: 'circle',
                symbolSize: 5,
                sampling: 'average',
                itemStyle: {
                    normal: {
                        color: '#d68262'
                    }
                },
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: '#d68262'
                        }, {
                            offset: 1,
                            color: '#ffe'
                        }])
                    }
                },
                data: data2
            },
            {
                name:'80-90',
                type:'line',
                smooth:true,
                stack: 'a',
                symbol: 'circle',
                symbolSize: 5,
                sampling: 'average',
                itemStyle: {
                    normal: {
                        color: '#F95E59'
                    }
                },
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: '#F95E59'
                        }, {
                            offset: 1,
                            color: '#ffe'
                        }])
                    }
                },
                data: data3
            },
            {
                name:'90-   ',
                type:'line',
                smooth:true,
                stack: 'a',
                symbol: 'circle',
                symbolSize: 5,
                sampling: 'average',
                itemStyle: {
                    normal: {
                        color: '#F4ED7C'
                    }
                },
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: '#F4ED7C'
                        }, {
                            offset: 1,
                            color: '#ffe'
                        }])
                    }
                },
                data: data4
            }

        ]
    };

    return option;
}
function toolTip2(title_text,legend_data,name1,name2) {
    var base = +new Date(2016, 9, 3);
    var oneDay = 24 * 3600 * 1000;
    var valueBase = Math.random() * 300;
    var valueBase2 = Math.random() * 50;
    var data = [];
    var data2 = [];


    for (var i = 1; i < 10; i++) {
        var now = new Date(base += oneDay);
        var dayStr = [now.getFullYear(), now.getMonth() + 1, now.getDate()].join('-');

        valueBase = Math.round((Math.random() - 0.5) * 20 + valueBase);
        valueBase <= 0 && (valueBase = Math.random() * 300);
        data.push([dayStr, valueBase]);

        valueBase2 = Math.round((Math.random() - 0.5) * 20 + valueBase2);
        valueBase2 <= 0 && (valueBase2 = Math.random() * 50);
        data2.push([dayStr, valueBase2]);

    }

    option = {
        animation: false,
        title: {
            left: 'left',
            text: title_text,
            subtext: '',
            textStyle: {
                fontWeight: 'normal',      //标题颜色
                color: '#FFFFFF',
                fontSize: title_fontSize
            },
        },
        legend: {
            x:'right',
            y:'top',
            data:legend_data,

            textStyle: {
                fontWeight: 'normal',
                color: 'white'
            }
        },
        tooltip: {
            triggerOn: 'none',
            position: function (pt) {
                return [pt[0], 130];
            }
        },
        // toolbox: {
        //     left: 'center',
        //     itemSize: 25,
        //     top: 55,
        //     feature: {
        //         dataZoom: {
        //             yAxisIndex: 'none'
        //         },
        //         restore: {}
        //     }
        // },
        xAxis: {
            type: 'time',
            // boundaryGap: [0, 0],
            axisPointer: {
                value: '2016-10-7',
                snap: true,
                lineStyle: {
                    color: '#004E52',
                    opacity: 0.5,
                    width: 2
                },
                label: {
                    show: true,
                    formatter: function (params) {
                        return echarts.format.formatTime('yyyy-MM-dd', params.value);
                    },
                    backgroundColor: '#004E52'
                },
                handle: {
                    show: true,
                    color: '#004E52'
                }
            },
            splitLine: {
                show: false
            },
            axisLine:{
                lineStyle:{
                    color:'white',
                    fontSize: 20
                }
            },
        },
        yAxis: {
            type: 'value',
            axisTick: {
                inside: true
            },
            splitLine: {
                show: false
            },
            axisLabel: {
                inside: true,
                formatter: '{value}\n'
            },
            axisLine:{
                lineStyle:{
                    color:'white',
                    fontSize: 20
                }
            },

            z: -5
        },
        grid: {
            top: 45,
            left: 15,
            right: 15,
            height: 100
        },
        dataZoom: [{
            type: 'inside',
            throttle: 50
        }],
        series: [
            {
                name:name1,
                type:'line',
                smooth: true,
                symbol: 'circle',
                symbolSize: 5,
                sampling: 'average',
                itemStyle: {
                    normal: {
                        color: '#8ec6ad'
                    }
                },
                center: ['48%', '80%'],
                stack: 'a',
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: '#8ec6ad'
                        }, {
                            offset: 1,
                            color: '#ffe'
                        }])
                    }
                },
                data: data
            },
            {
                name:name2,
                type:'line',
                center: ['48%', '80%'],
                smooth:true,
                stack: 'a',
                symbol: 'circle',
                symbolSize: 5,
                sampling: 'average',
                itemStyle: {
                    normal: {
                        color: '#d68262'
                    }
                },
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: '#d68262'
                        }, {
                            offset: 1,
                            color: '#ffe'
                        }])
                    }
                },
                data: data2
            },

        ]
    };

    return option;
}
function toolTipMulti(title_text,legend_data) {
    var base = +new Date(2016, 9, 3);
    var oneDay = 24 * 3600 * 1000;
    var valueBase = Math.random() * 300;
    var valueBase2 = Math.random() * 50;
    var valueBase3 = Math.random() * 30;
    var valueBase4 = Math.random() * 10;
    var data = [];
    var data2 = [];
    var data3 = [];
    var data4 = [];


    for (var i = 1; i < 10; i++) {
        var now = new Date(base += oneDay);
        var dayStr = [now.getFullYear(), now.getMonth() + 1, now.getDate()].join('-');

        valueBase = Math.round((Math.random() - 0.5) * 20 + valueBase);
        valueBase <= 0 && (valueBase = Math.random() * 300);
        data.push([dayStr, valueBase]);

        valueBase2 = Math.round((Math.random() - 0.5) * 20 + valueBase2);
        valueBase2 <= 0 && (valueBase2 = Math.random() * 50);
        data2.push([dayStr, valueBase2]);

        valueBase3 = Math.round((Math.random() - 0.5) * 20 + valueBase3);
        valueBase3 <= 0 && (valueBase3 = Math.random() * 50);
        data3.push([dayStr, valueBase3]);

        valueBase4 = Math.round((Math.random() - 0.5) * 20 + valueBase4);
        valueBase4 <= 0 && (valueBase4 = Math.random() * 50);
        data4.push([dayStr, valueBase4]);
    }

    option = {
        animation: false,
        title: {
            left: 'left',
            text: title_text,
            subtext: '',
            textStyle: {
                fontWeight: 'normal',      //标题颜色
                color: '#FFFFFF',
                fontSize: title_fontSize
            },
        },
        legend: {
            x: 'right',
            y: 'top',
            data: legend_data,

            textStyle: {
                fontWeight: 'normal',
                color: 'white',
            }
        },
        tooltip: {
            triggerOn: 'none',
            position: function (pt) {
                return [pt[0], 130];
            }
        },
        // toolbox: {
        //     left: 'center',
        //     itemSize: 25,
        //     top: 55,
        //     feature: {
        //         dataZoom: {
        //             yAxisIndex: 'none'
        //         },
        //         restore: {}
        //     }
        // },
        xAxis: {
            type: 'time',
            // boundaryGap: [0, 0],
            axisPointer: {
                value: '2016-10-7',
                snap: true,
                lineStyle: {
                    color: '#004E52',
                    opacity: 0.5,
                    width: 2
                },
                label: {
                    show: true,
                    formatter: function (params) {
                        return echarts.format.formatTime('yyyy-MM-dd', params.value);
                    },
                    backgroundColor: '#004E52'
                },
                handle: {
                    show: true,
                    color: '#004E52'
                }
            },
            splitLine: {
                show: false
            },
            axisLine:{
                lineStyle:{
                    color:'white',
                    fontSize: 20
                }
            },
        },
        yAxis: {
            type: 'value',
            axisTick: {
                inside: true
            },
            splitLine: {
                show: false
            },
            axisLabel: {
                inside: true,
                formatter: '{value}\n'
            },
            axisLine:{
                lineStyle:{
                    color:'white',
                    fontSize: 20
                }
            },

            z: -5
        },
        grid: {
            top: 45,
            left: 15,
            right: 15,
            height: 100
        },
        dataZoom: [{
            type: 'inside',
            throttle: 50
        }],
        series: [
            {
                name:'60-70',
                type:'line',
                smooth: true,
                symbol: 'circle',
                symbolSize: 5,
                sampling: 'average',
                itemStyle: {
                    normal: {
                        color: '#8ec6ad'
                    }
                },
                stack: 'a',
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: '#8ec6ad'
                        }, {
                            offset: 1,
                            color: '#ffe'
                        }])
                    }
                },
                data: data
            },
            {
                name:'70-80',
                type:'line',
                smooth:true,
                stack: 'a',
                symbol: 'circle',
                symbolSize: 5,
                sampling: 'average',
                itemStyle: {
                    normal: {
                        color: '#d68262'
                    }
                },
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: '#d68262'
                        }, {
                            offset: 1,
                            color: '#ffe'
                        }])
                    }
                },
                data: data2
            },
            {
                name:'80-90',
                type:'line',
                smooth:true,
                stack: 'a',
                symbol: 'circle',
                symbolSize: 5,
                sampling: 'average',
                itemStyle: {
                    normal: {
                        color: '#F95E59'
                    }
                },
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: '#F95E59'
                        }, {
                            offset: 1,
                            color: '#ffe'
                        }])
                    }
                },
                data: data3
            },
            {
                name:'90-   ',
                type:'line',
                smooth:true,
                stack: 'a',
                symbol: 'circle',
                symbolSize: 5,
                sampling: 'average',
                itemStyle: {
                    normal: {
                        color: '#F4ED7C'
                    }
                },
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: '#F4ED7C'
                        }, {
                            offset: 1,
                            color: '#ffe'
                        }])
                    }
                },
                data: data4
            }

        ]
    };

    return option;
}

//chartline for baseage
function toolTipMultiForBaseAge(title_text,legend_data) {
    var base = +new Date(2016, 9, 3);
    var oneDay = 24 * 3600 * 1000;
    var valueBase = Math.random() * 300;
    var valueBase2 = Math.random() * 50;
    var valueBase3 = Math.random() * 30;
    var valueBase4 = Math.random() * 10;
    var data = [];
    var data2 = [];
    var data3 = [];
    var data4 = [];


    for (var i = 1; i < 10; i++) {
        var now = new Date(base += oneDay);
        var dayStr = [now.getFullYear(), now.getMonth() + 1, now.getDate()].join('-');

        valueBase = Math.round((Math.random() - 0.5) * 20 + valueBase);
        valueBase <= 0 && (valueBase = Math.random() * 300);
        data.push([dayStr, valueBase]);

        valueBase2 = Math.round((Math.random() - 0.5) * 20 + valueBase2);
        valueBase2 <= 0 && (valueBase2 = Math.random() * 50);
        data2.push([dayStr, valueBase2]);

        valueBase3 = Math.round((Math.random() - 0.5) * 20 + valueBase3);
        valueBase3 <= 0 && (valueBase3 = Math.random() * 50);
        data3.push([dayStr, valueBase3]);

        valueBase4 = Math.round((Math.random() - 0.5) * 20 + valueBase4);
        valueBase4 <= 0 && (valueBase4 = Math.random() * 50);
        data4.push([dayStr, valueBase4]);
    }

    option = {
        animation: false,
        title: {
            left: 'left',
            text: title_text,
            subtext: '',
            textStyle: {
                fontWeight: 'normal',      //标题颜色
                color: '#FFFFFF',
                fontSize: title_fontSize
            },
        },
        legend: {
            x: '0',
            y: '12%',
            data: legend_data,

            textStyle: {
                fontWeight: 'normal',
                color: 'white',
            }
        },
        tooltip: {
            triggerOn: 'none',
            position: function (pt) {
                return [pt[0], 130];
            }
        },
        // toolbox: {
        //     left: 'center',
        //     itemSize: 25,
        //     top: 55,
        //     feature: {
        //         dataZoom: {
        //             yAxisIndex: 'none'
        //         },
        //         restore: {}
        //     }
        // },
        xAxis: {
            type: 'time',
            // boundaryGap: [0, 0],
            axisPointer: {
                value: '2016-10-7',
                snap: true,
                lineStyle: {
                    color: '#004E52',
                    opacity: 0.5,
                    width: 2
                },
                label: {
                    show: true,
                    formatter: function (params) {
                        return echarts.format.formatTime('yyyy-MM-dd', params.value);
                    },
                    backgroundColor: '#004E52'
                },
                handle: {
                    show: true,
                    color: '#004E52'
                }
            },
            splitLine: {
                show: false
            },
            axisLine:{
                lineStyle:{
                    color:'white',
                    fontSize: 20
                }
            },
        },
        yAxis: {
            type: 'value',
            axisTick: {
                inside: true
            },
            splitLine: {
                show: false
            },
            axisLabel: {
                inside: true,
                formatter: '{value}\n'
            },
            axisLine:{
                lineStyle:{
                    color:'white',
                    fontSize: 20
                }
            },

            z: -5
        },
        grid: {
            top: 45,
            left: 15,
            right: 15,
            height: 100
        },
        dataZoom: [{
            type: 'inside',
            throttle: 50
        }],
        series: [
            {
                name:'60-70',
                type:'line',
                smooth: true,
                symbol: 'circle',
                symbolSize: 5,
                sampling: 'average',
                itemStyle: {
                    normal: {
                        color: '#8ec6ad'
                    }
                },
                stack: 'a',
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: '#8ec6ad'
                        }, {
                            offset: 1,
                            color: '#ffe'
                        }])
                    }
                },
                data: data
            },
            {
                name:'70-80',
                type:'line',
                smooth:true,
                stack: 'a',
                symbol: 'circle',
                symbolSize: 5,
                sampling: 'average',
                itemStyle: {
                    normal: {
                        color: '#d68262'
                    }
                },
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: '#d68262'
                        }, {
                            offset: 1,
                            color: '#ffe'
                        }])
                    }
                },
                data: data2
            },
            {
                name:'80-90',
                type:'line',
                smooth:true,
                stack: 'a',
                symbol: 'circle',
                symbolSize: 5,
                sampling: 'average',
                itemStyle: {
                    normal: {
                        color: '#F95E59'
                    }
                },
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: '#F95E59'
                        }, {
                            offset: 1,
                            color: '#ffe'
                        }])
                    }
                },
                data: data3
            },
            {
                name:'90-   ',
                type:'line',
                smooth:true,
                stack: 'a',
                symbol: 'circle',
                symbolSize: 5,
                sampling: 'average',
                itemStyle: {
                    normal: {
                        color: '#F4ED7C'
                    }
                },
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: '#F4ED7C'
                        }, {
                            offset: 1,
                            color: '#ffe'
                        }])
                    }
                },
                data: data4
            }

        ]
    };

    return option;
}
function gauge(title_text,val) {
    option = {
        title:{
            text:'未来空余',
            textStyle:{
                //文字颜色
                color:'#f2f989',
                //字体风格,'normal','italic','oblique'
                fontStyle:'normal',
                //字体粗细 'normal','bold','bolder','lighter',100 | 200 | 300 | 400...
                fontWeight:'normal',
                //字体系列
                fontFamily:'sans-serif',
                //字体大小
                fontSize:16,
                fontWeight: 'normal'
            },
            x:'center',
            y:'bottom',
        },
        legend: {
            orient: 'vertical',
            right: 'bottom',
            top:"0",
            data: ['未来空余','1'],
        },
        series: [
            {
                name: '业务指标',
                type: 'gauge',
                radius : "70%",
                detail: {formatter:'{value}%'},
                data: [{
                    value: val,
                    name: '',
                }],
                //data: [{value: 21, name: '完成率111'}],
                axisLabel: {
                    distance : 0 ,//文字离表盘的距离
                    textStyle: {
                        color: 'white',
                        fontSize:6,
                    }

                },
                detail: {
                    formatter : "{score|{value}%}",
                    offsetCenter: [0, "40%"],
                    height:30,
                    rich : {
                        score : {
                            fontFamily : "",
                            fontSize : 18,
                            color:'#f2f989',
                        }
                    }
                },
            }
        ]
    };

    return option;
}

function polarPie(title_text) {
    option = {
        title: {
            text: title_text,
            textStyle: {
                fontWeight: 'normal',      //标题颜色
                color: '#FFFFFF',
                fontSize: 26
            },
            x: 'center',
            textAlign:'right'
        },
        angleAxis: {
            type: 'category',
            data: ['平阳','东兰','古龙','平吉','平南','古美'],
            z: 10,
            //textSize:20,
            axisLine:{
                lineStyle:{
                    color:'white',
                    fontSize: 80
                }
            },
        },
        radiusAxis: {
        },
        polar: {
        },
        series: [{
            type: 'bar',
            data: [1, 2, 3, 4, 3, 5, 1],
            coordinateSystem: 'polar',
            name: '已完成',
            fontSize: 40,
            color:series_color_5,
            stack: 'a'
        }],
        legend: {
            show: true,
            data: ['已完成'],
            x: 'right',
            textStyle:{
                color:'white',
            },

        }
    };
    return option;
}
function chartBarHei_x(title_text,legend_data,xAxis_data,series) {
    var option = {
        title: {
            text:title_text,
            textStyle:{
                color:'#fff',
                fontSize:title_fontSize,
                fontWeight: 'normal'
            },
            x:'0%',
            y:'0%'
        },
        tooltip:{
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        legend: {
            orient: 'vertical',
            right:'0',
            data:legend_data
        },
        grid:  {
            top:'25%',
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis : [
            {
                type : 'category',
                data : xAxis_data,
                axisLabel:{
                    textStyle: {
                        color: '#fff',
                        fontSize:xAxis_axisLabel_fontSize_barHei,
                        fontWeight:100
                    },
                    show:true,
                    interval: 0,//,
                    rotate:60
                },
                axisLine:{
                    lineStyle: {
                        color: '#fff'
                    }
                }
            }
        ],
        yAxis:[
            {
                type : 'value',
                axisLabel:{
                    textStyle: {
                        color: '#fff',
                        fontSize:yAxis_axisLabel_fontSize_barHei,
                        fontWeight:100
                    }
                },
                axisLine:{
                    lineStyle: {
                        color: '#fff'
                    }
                },
                splitLine:{
                    show:false
                }
            }
        ],
        series: series,
        color: [series_color_1,series_color_2,series_color_3,series_color_4,series_color_5,series_color_6,series_color_7]
    };
    return option;
}