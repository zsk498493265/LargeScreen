<style>
    @media only screen and (min-width: 6000px){
        #news p{
            font-size: 38px;
        }
        #news img{
            padding-top: 30px;
        }
        .newsp{
            margin-top: 40px;
        }
        #logo{
            margin-top: 20px;
            width: 100px;
            height: 150px;
            display: inline;
        }
        #logo-title{
            margin-top: 40px;
            width: 250px;
            height: 110px;
            display: inline;
        }
    }
</style>
<div class="row" style="margin-top: 0px">
    <div class="col-lg-1" style="width: 5%"></div>
    <div class="col-lg-11">
        <div class="row">
            <div class="col-lg-12"  align="center">
                <img src="/static/img/news/picture.png" id="logo" style="height: 100px;width: 500px;" onclick="picChange(-1)" >
            </div>
        </div>

    </div>
    <#--<div class="col-lg-4">-->
        <#--<img src="/static/img/news/logo_title.png"  id="logo-title">-->
    <#--</div>-->
</div>
<div class="row" id="news" style="max-height: 20px;width:1000px;margin-left: 3px;margin-top:5px">
    <div class="col-lg-1" style="width: 3%"></div>
    <div class="col-lg-6" align="center" id="community">
            <div id="myCarousel" class="carousel slide">
                <!-- 轮播（Carousel）指标 -->
                <ol class="carousel-indicators">
                    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                    <li data-target="#myCarousel" data-slide-to="1"></li>
                    <#--<li data-target="#myCarousel" data-slide-to="2"></li>-->
                </ol>
                <!-- 轮播（Carousel）项目 -->
                <div class="carousel-inner"  style="height: 215px">
                    <div class="item active">
                        <img id="newsPic2" alt="First slide" >
                    </div>
                    <div class="item">
                        <img id="newsPic1" alt="Second slide" >
                    </div>
                    <#--<div class="item">-->
                        <#--<img src="/static/img/news/3.jpg" alt="Third slide" >-->
                    <#--</div>-->
                </div>
                <!-- 轮播（Carousel）导航 -->
                <a class="carousel-control left" href="#myCarousel"
                   data-slide="prev">
                </a>
                <a class="carousel-control right" href="#myCarousel"
                   data-slide="next">
                </a>
            </div>
    </div>
    <div class="col-lg-5" style="width: 450px;margin-top:20px">
        <p class="newsp p1" id="news1" style="text-indent:5em;font-size: 20px"> 不管是公办还是民营，不管是独立的养老院还是嵌入式养老机构，能打开“围墙”的统统打开，能共享的全部共享。闵行区第一家打开养老院“围墙”的是位于古美路街道的莲花老年公寓，社区老人可以进来享受日间照料、综合空间、短期照护和助餐等8项服务。</p>
        <p class="newsp p2" id="news2" style="text-indent:5em;display: none;font-size: 20px" >有意愿的老年人在志愿者团队登记后，只要符合条件就可以拿到这张“古美岁月敬老卡”。卡的背面印制了具有身份识别功能的二维码。这张“私人定制”的敬老卡中有老人参加每项服务的记录及自己基本的健康数据。社区也会根据敬老卡的记录为老人设计相应的活动。</p>
       <#--// <p class="newsp p3" style="text-indent:5em;display: none;font-size: 20px">有意愿的老年人在志愿者团队登记后，只要符合条件就可以拿到这张“古美岁月敬老卡”。卡的背面印制了具有身份识别功能的二维码。这张“私人定制”的敬老卡中有老人参加每项服务的记录及自己基本的健康数据。社区也会根据敬老卡的记录为老人设计相应的活动。</p>-->
    </div>
</div>
<div class="row">
    <h1></h1>
</div>

<script>
    $("#myCarousel").carousel('cycle');
    $("#news").css("height",winHeight/8.0);
    $("#news").css("height",winWidth/5);
    $("#news img").css("height",winHeight/4.8);
    $("#news img").css("width",winWidth/10);

    var i=1;
    $('#myCarousel').on('slide.bs.carousel', function () {
        $(".newsp").hide();
        $(".p"+i).show();
        i++;
        if(i==3)
            i=1;
    });
</script>