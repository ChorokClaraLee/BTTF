<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="ko" class="no-js">
<!-- BEGIN HEAD -->

<head>
    <meta charset="utf-8" />
    <title>Home4 - Homebrew Community</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1" name="viewport" />
    <meta content="" name="description" />
    <meta content="" name="author" />

    <!-- GLOBAL MANDATORY STYLES -->
    <link href="http://fonts.googleapis.com/css?family=Hind:300,400,500,600,700" rel="stylesheet" type="text/css">
    <link href="../../resource/vendor/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
    <link href="../../resource/vendor/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />

    <!-- font-Glyphicon -->
    <!-- <link rel="stylesheet" href="vendor/fontawesome-free-5.15.4-web/fontawesome-free-5.15.4-web/css/fontawesome.css"> -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css">

    <!-- PAGE LEVEL PLUGIN STYLES -->
    <link href="../../resource/css/animate.css" rel="stylesheet">
    <link href="../../resource/vendor/swiper/css/swiper.min.css" rel="stylesheet" type="text/css" />

    <!-- THEME STYLES -->
    <link href="../../resource/css/layout.css" rel="stylesheet" type="text/css" />

    <!-- Favicon -->
    <link rel="shortcut icon" href="/resource/img/favicon/favicon-32x32.png" />

    <!-- custom -->
    <link rel="stylesheet" href="../../resource/css/custom.css">

    <!-- c3 chart -->
    <link href="../../resource/vendor/c3-0.7.20/c3.css" rel="stylesheet">
</head>
<!-- END HEAD -->

<!-- BODY -->

<body>

    <!--========== HEADER ==========-->
    <header class="header navbar-fixed-top">
        <!-- Navbar -->
                <%@ include file="/app/pages/header_control.jsp" %>  
        <!-- Navbar -->
    </header>
    <!--========== END HEADER ==========-->

    <!--========== SLIDER ==========-->
    
    <!--========== SLIDER ==========-->

    <!--========== PAGE LAYOUT ==========-->
    <!-- Service -->
    <div class="bg-color-sky-light" data-auto-height="true">
        <div class="content-lg container">
            <h1 class="pt-4">
                <i class="fas fa-user-circle title_subject_icon"></i>
                ê´ë¦¬ì íì´ì§
            </h1>
            <div role="tabpanel">
                <!-- Nav tabs -->
                <ul class="nav nav-tabs tab-text-nav" role="tablist" >
                    <li role="presentation" class="active col-md-4 tab_non"  style="padding: 0 !important;">
                        <a class="text-center" href="#management" aria-controls="management" role="tab" data-toggle="tab">
                            íìê´ë¦¬
                        </a>
                    </li>
                    <li role="presentation" class="col-md-4 tab_non"  style="padding: 0 !important;">
                        <a class="text-center" href="#postmanagement" aria-controls="postmanagement" role="tab" data-toggle="tab"> 
                            ê²ìê¸ ê´ë¦¬
                        </a>
                    </li>
                </ul>
                <!-- End Nav tabs -->
                <!-- tab panel -->
                <div class="tab-content">
                    <!-- member management tab-->
                    <div role="tabpanel" class="tab-pane active" id="management">

                        <div role="tabpanel " style="margin-top: 70px;">
                            <!-- Nav tabs -->
                            <ul class="nav nav-tabs tab-text-nav" role="tablist" >
                                <li role="presentation" class="active col-md-4 tab_non"  style="padding: 0 !important;">
                                    <a class="text-center" href="#allmembers" aria-controls="allmembers" role="tab" data-toggle="tab">
                                        ì ì²´íì
                                    </a>
                                </li>
                                <li role="presentation" class="col-md-4 tab_non"  style="padding: 0 !important;">
                                    <a class="text-center" href="#blockedmember" aria-controls="blockedmember" role="tab" data-toggle="tab"> 
                                        ì°¨ë¨ë íì
                                    </a>
                                </li>
                            </ul>
                            <!-- End Nav tabs -->
                            <!-- tab panel -->
                            <div class="tab-content">
                                <!-- allmembers tab-->
                                <div role="tabpanel" class="tab-pane active" id="allmembers">
                                    <div class="content-lg container">
                                        <!-- memberlist table -->
                                        <h2>
                                            <i class="fas fa-user-cog title_subject_icon"></i>
                                            ì ì²´íì
                                        </h2>
                                        <div class="table-responsive">
                                            <table class="table table-striped">
                                                <thead>
                                                    <th>ID</th>
                                                    <th>ì´ë¦</th>
                                                    <th>ì íë²í¸</th>
                                                    <th>ê°ìì¼ì</th>
                                                    <th>ì°¨ë¨íê¸°</th>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td>test1</td>
                                                        <td>test name</td>
                                                        <td>010-****-1111</td>
                                                        <td>2021-12-08</td>
                                                        <td><input class="btn btn-danger" type="button" value="ì°¨ë¨"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>test2</td>
                                                        <td>test name2</td>
                                                        <td>010-****-1111</td>
                                                        <td>2021-12-08</td>
                                                        <td><input class="btn btn-danger" type="button" value="ì°¨ë¨"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>test3</td>
                                                        <td>test name3</td>
                                                        <td>010-****-1111</td>
                                                        <td>2021-12-08</td>
                                                        <td><input class="btn btn-danger" type="button" value="ì°¨ë¨"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>test4</td>
                                                        <td>test name4</td>
                                                        <td>010-****-1111</td>
                                                        <td>2021-12-08</td>
                                                        <td><input class="btn btn-danger" type="button" value="ì°¨ë¨"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>test5</td>
                                                        <td>test name5</td>
                                                        <td>010-****-1111</td>
                                                        <td>2021-12-08</td>
                                                        <td><input class="btn btn-danger" type="button" value="ì°¨ë¨"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>test6</td>
                                                        <td>test name6</td>
                                                        <td>010-****-1111</td>
                                                        <td>2021-12-08</td>
                                                        <td><input class="btn btn-danger" type="button" value="ì°¨ë¨"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>test7</td>
                                                        <td>test name7</td>
                                                        <td>010-****-1111</td>
                                                        <td>2021-12-08</td>
                                                        <td><input class="btn btn-danger" type="button" value="ì°¨ë¨"></td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                        <!-- End notice -->
                                    </div>
                                </div>
                                <!-- allmembers tab end-->

                                <!--blockedmember tab -->
                                <div role="tabpanel" class="tab-pane" id="blockedmember">
                                    <div class="content-lg container">
                                        <!-- memberlist table -->
                                        <h2>
                                            <i class="fas fa-user-alt-slash title_subject_icon"></i>
                                            ì°¨ë¨ë íì
                                        </h2>
                                        <div class="table-responsive">
                                            <table class="table table-striped">
                                                <thead>
                                                    <th>ID</th>
                                                    <th>ì´ë¦</th>
                                                    <th>ì íë²í¸</th>
                                                    <th>ê°ìì¼ì</th>
                                                    <th>ì°¨ë¨í´ì </th>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td>blockedmember1</td>
                                                        <td>test name1</td>
                                                        <td>010-****-1111</td>
                                                        <td>2021-12-08</td>
                                                        <td><input class="btn btn-info" type="button" value="ì°¨ë¨í´ì "></td>
                                                    </tr>
                                                    <tr>
                                                        <td>blockedmember2</td>
                                                        <td>test name2</td>
                                                        <td>010-****-1111</td>
                                                        <td>2021-12-08</td>
                                                        <td><input class="btn btn-info" type="button" value="ì°¨ë¨í´ì "></td>
                                                    </tr>
                                                    <tr>
                                                        <td>blockedmember3</td>
                                                        <td>test name3</td>
                                                        <td>010-****-1111</td>
                                                        <td>2021-12-08</td>
                                                        <td><input class="btn btn-info" type="button" value="ì°¨ë¨í´ì "></td>
                                                    </tr>
                                                    <tr>
                                                        <td>blockedmember4</td>
                                                        <td>test name4</td>
                                                        <td>010-****-1111</td>
                                                        <td>2021-12-08</td>
                                                        <td><input class="btn btn-info" type="button" value="ì°¨ë¨í´ì "></td>
                                                    </tr>
                                                    <tr>
                                                        <td>blockedmember5</td>
                                                        <td>test name5</td>
                                                        <td>010-****-1111</td>
                                                        <td>2021-12-08</td>
                                                        <td><input class="btn btn-info" type="button" value="ì°¨ë¨í´ì "></td>
                                                    </tr>
                                                    <tr>
                                                        <td>blockedmember6</td>
                                                        <td>test name6</td>
                                                        <td>010-****-1111</td>
                                                        <td>2021-12-08</td>
                                                        <td><input class="btn btn-info" type="button" value="ì°¨ë¨í´ì "></td>
                                                    </tr>
                                                    <tr>
                                                        <td>blockedmember7</td>
                                                        <td>test name7</td>
                                                        <td>010-****-1111</td>
                                                        <td>2021-12-08</td>
                                                        <td><input class="btn btn-info" type="button" value="ì°¨ë¨í´ì "></td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                        <!-- End notice -->
                                    </div>     
                                </div>
                                <!--blockedmember tab end -->
                            </div>
                            <!-- End tab panel -->
                        </div>
                    </div>
                    <!-- member management tab end-->


                    <!--postmanagement tab -->
                    <div role="tabpanel" class="tab-pane" id="postmanagement">
                        <div role="tabpanel " style="margin-top: 70px;">
                            <!-- Nav tabs -->
                            <ul class="nav nav-tabs tab-text-nav" role="tablist" >
                                <li role="presentation" class="active col-md-4 tab_non"  style="padding: 0 !important;">
                                    <a class="text-center" href="#allboard" aria-controls="allboard" role="tab" data-toggle="tab">
                                        ì ì²´ ê²ìê¸
                                    </a>
                                </li>
                                <li role="presentation" class="col-md-4 tab_non"  style="padding: 0 !important;">
                                    <a class="text-center" href="#notice" aria-controls="notice" role="tab" data-toggle="tab"> 
                                        ê³µì§ì¬í­ ë±ë¡
                                    </a>
                                </li>
                                <li role="presentation" class="col-md-4 tab_non"  style="padding: 0 !important;">
                                    <a class="text-center" href="#blockedboard" aria-controls="blockedboard" role="tab" data-toggle="tab"> 
                                        ì ê³ ë ê²ìê¸
                                    </a>
                                </li>
                            </ul>
                            <!-- End Nav tabs -->
                            <!-- tab panel -->
                            <div class="tab-content">
                                <!-- allboard tab-->
                                <div role="tabpanel" class="tab-pane active" id="allboard">
                                    <div class="content-lg container">
                                        <!-- memberlist table -->
                                        <h2>
                                            <i class="fas fa-list title_subject_icon"></i>
                                            ì ì²´ ê²ìë¬¼
                                        </h2>
                                        <div class="table-responsive">
                                            <table class="table table-striped">
                                                <thead>
                                                    <th>ì ëª©</th>
                                                    <th>ì¶ì²ì</th>
                                                    <th>ìì±ì</th>
                                                    <th>ìì±ì¼ì</th>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td>asdasd</td>
                                                        <td>111</td>
                                                        <td>view1</td>
                                                        <td>2021-12-08</td>
                                                    </tr>
                                                    <tr>
                                                        <td>asddfgdgf</td>
                                                        <td>222</td>
                                                        <td>view2</td>
                                                        <td>2021-12-08</td>
                                                    </tr>
                                                    <tr>
                                                        <td>xcvccxvxcv</td>
                                                        <td>333</td>
                                                        <td>view3</td>
                                                        <td>2021-12-08</td>
                                                    </tr>
                                                    <tr>
                                                        <td>xcvccxvxcv</td>
                                                        <td>444</td>
                                                        <td>view4</td>
                                                        <td>2021-12-08</td>
                                                    </tr>
                                                    <tr>
                                                        <td>xcvccxvxcv</td>
                                                        <td>555</td>
                                                        <td>view5</td>
                                                        <td>2021-12-08</td>
                                                    </tr>
                                                    <tr>
                                                        <td>xcvccxvxcv</td>
                                                        <td>666</td>
                                                        <td>view6</td>
                                                        <td>2021-12-08</td>
                                                    </tr>
                                                    <tr>
                                                        <td>xcvccxvxcv</td>
                                                        <td>777</td>
                                                        <td>view7</td>
                                                        <td>2021-12-08</td>
                                                    </tr>
                                                    <tr>
                                                        <td>xcvccxvxcv</td>
                                                        <td>888</td>
                                                        <td>view8</td>
                                                        <td>2021-12-08</td>
                                                    </tr>
                                                    <tr>
                                                        <td>xcvccxvxcv</td>
                                                        <td>999</td>
                                                        <td>view9</td>
                                                        <td>2021-12-08</td>
                                                    </tr>
                                                    <tr>
                                                        <td>xcvccxvxcv</td>
                                                        <td>101010</td>
                                                        <td>view10</td>
                                                        <td>2021-12-08</td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                        <!-- End notice -->
                                    </div>
                                </div>
                                <!-- allboard tab end-->

                                <!--notice tab -->
                                <div role="tabpanel" class="tab-pane" id="notice">
                                    <div class="content-lg container">
                                        <!-- memberlist table -->
                                        <h2>
                                            <i class="fas fa-bullhorn title_subject_icon"></i>
                                            ê³µì§ì¬í­
                                        </h2>
                                        <div class="table-responsive">
                                            <table class="table table-striped">
                                                <thead>
                                                    <th>ì ëª©</th>
                                                    <th>ì¶ì²ì</th>
                                                    <th>ìì±ì</th>
                                                    <th>ìì±ì¼ì</th>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td colspan="4" class="text-center">ë±ë¡ë ê³µì§ì¬í­ì´ ììµëë¤.</td>
                                                        
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                        <!-- End notice -->
                                    </div>     
                                </div>
                                <!--notice tab end -->

                                <!-- blockedboard tab-->
                                <div role="tabpanel" class="tab-pane active" id="blockedboard">
                                    <div class="content-lg container">
                                        <!-- memberlist table -->
                                        <h2>
                                            <i class="fas fa-window-close title_subject_icon"></i>
                                            ì ê³ ë ê²ìê¸
                                        </h2>
                                        <div class="table-responsive">
                                            <table class="table table-striped">
                                                <thead>
                                                    <th>ì ëª©</th>
                                                    <th>ì¶ì²ì</th>
                                                    <th>ìì±ì</th>
                                                    <th>ìì±ì¼ì</th>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td>asdasd</td>
                                                        <td>111</td>
                                                        <td>view1</td>
                                                        <td>2021-12-08</td>
                                                    </tr>
                                                    <tr>
                                                        <td>asddfgdgf</td>
                                                        <td>222</td>
                                                        <td>view2</td>
                                                        <td>2021-12-08</td>
                                                    </tr>
                                                    <tr>
                                                        <td>xcvccxvxcv</td>
                                                        <td>333</td>
                                                        <td>view3</td>
                                                        <td>2021-12-08</td>
                                                    </tr>
                                                    <tr>
                                                        <td>xcvccxvxcv</td>
                                                        <td>444</td>
                                                        <td>view4</td>
                                                        <td>2021-12-08</td>
                                                    </tr>
                                                    <tr>
                                                        <td>xcvccxvxcv</td>
                                                        <td>555</td>
                                                        <td>view5</td>
                                                        <td>2021-12-08</td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                        <!-- End notice -->
                                    </div>
                                </div>
                                <!-- blockedboard tab end-->

                            </div>
                            <!-- End tab panel -->
                        </div>
                    </div>
                    <!--postmanagement tab end -->
                </div>
                <!-- End tab panel -->
            </div>
            
            <!--// end row -->
        </div>
    </div>
    
    <!-- End Service -->

    <!--========== FOOTER ==========-->
    <footer class="footer">

        <!-- Copyright -->
                <%@ include file="/app/pages/footer_control.jsp" %>  
        <!-- End Copyright -->
    </footer>
    <!--========== END FOOTER ==========-->

    <!-- Back To Top -->
    <a href="javascript:void(0);" class="js-back-to-top back-to-top">Top</a>

    <!-- JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
    <!-- CORE PLUGINS -->
    <script src="../../resource/vendor/jquery.min.js" type="text/javascript"></script>
    <script src="../../resource/vendor/jquery-migrate.min.js" type="text/javascript"></script>
    <script src="../../resource/vendor/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>

    <!-- PAGE LEVEL PLUGINS -->
    <script src="../../resource/vendor/jquery.easing.js" type="text/javascript"></script>
    <script src="../../resource/vendor/jquery.back-to-top.js" type="text/javascript"></script>
    <!--  <script src="vendor/jquery.smooth-scroll.js" type="text/javascript"></script> -->
    <script src="../../resource/vendor/jquery.wow.min.js" type="text/javascript"></script>
    <script src="../../resource/vendor/swiper/js/swiper.jquery.min.js" type="text/javascript"></script>
    <script src="../../resource/vendor/masonry/jquery.masonry.pkgd.min.js" type="text/javascript"></script>
    <script src="../../resource/vendor/masonry/imagesloaded.pkgd.min.js" type="text/javascript"></script>

    <!-- PAGE LEVEL SCRIPTS -->
    <script src="../../resource/js/layout.min.js" type="text/javascript"></script>
    <script src="../../resource/js/components/wow.min.js" type="text/javascript"></script>
    <script src="../../resource/js/components/swiper.min.js" type="text/javascript"></script>
    <script src="../../resource/js/components/masonry.min.js" type="text/javascript"></script>
    <script src="../../resource/js/action.js"></script>
    <!-- F12 ,right click block-->
    <!-- <script src="js/Prevention.js"></script> -->

    <!-- Load d3.js and c3.js -->
    <script src="../../resource/vendor/c3-0.7.20/c3.js"></script>
    <script src="../../resource/vendor/c3-0.7.20/docs/js/d3-5.8.2.min.js" charset="utf-8"></script>

    <script>
        var chart = c3.generate({
            bindto: '#chart',
            data: {
            columns: [
                ['ìì±í ê¸', 30, 200, 100, 400, 150, 250],
                ['ë°ì ì¶ì²ì', 50, 20, 10, 40, 15, 25]
            ]
            }
        });
    </script>
</body>
<!-- END BODY -->

</html>