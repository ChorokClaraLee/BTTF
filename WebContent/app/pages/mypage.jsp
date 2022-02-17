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
                	마이페이지
            </h1>
            <div class="row row-space-1 margin-b-2">
                <div class="col-sm-12 sm-margin-b-2" style="margin-bottom: 20px;">
                    <div class="wow fadeInLeft" data-wow-duration=".3" data-wow-delay=".3s">
                        <div class="my_box_my_page" data-height="height">
                            <div class="my_box_my_page_element">
                                <i class="my_box_my_page_icon fas fa-id-card"></i>
                            </div>
                            <div class="my_box_my_page_info">
                                <h3>내 정보 수정</h3>
                                <a class="link" href="${pageContext.request.contextPath }/pages/MemberView.us">수정하기</a>
                            </div>
                            <a href="${pageContext.request.contextPath }/pages/MemberView.us" class="content-wrapper-link" ></a>
                        </div>
                    </div>
                </div>
                <div class="col-sm-4 sm-margin-b-2">
                    <div class="wow fadeInLeft" data-wow-duration=".3" data-wow-delay=".3s">
                        <div class="my_box_my_page" data-height="height">
                            <div class="my_box_my_page_element">
                                <i class="my_box_my_page_icon fas fa-edit"></i>
                            </div>
                            <div class="my_box_my_page_info">
                                <h3>작성한 글 수</h3>
                                <p class="margin-b-5">1111</p>
                                <!-- <a class="link" href="html5.html">Read More</a> -->
                            </div>
                            <!-- <a href="html5.html" class="content-wrapper-link"></a> -->
                        </div>
                    </div>
                </div>
                <div class="col-sm-4 sm-margin-b-2">
                    <div class="wow fadeInLeft" data-wow-duration=".3" data-wow-delay=".3s">
                        <div class="my_box_my_page" data-height="height">
                            <div class="my_box_my_page_element">
                                <i class="my_box_my_page_icon fas fa-comment-alt"></i>
                            </div>
                            <div class="my_box_my_page_info">
                                <h3>작성한 댓글 수</h3>
                                <p class="margin-b-5">1111</p>
                                <!-- <a class="link" href="html5.html">Read More</a> -->
                            </div>
                            <!-- <a href="html5.html" class="content-wrapper-link"></a> -->
                        </div>
                    </div>
                </div>
                <div class="col-sm-4 sm-margin-b-2">
                    <div class="wow fadeInLeft" data-wow-duration=".3" data-wow-delay=".3s">
                        <div class="my_box_my_page" data-height="height">
                            <div class="my_box_my_page_element">
                                <i class="my_box_my_page_icon fas fa-thumbs-up"></i>
                            </div>
                            <div class="my_box_my_page_info">
                                <h3>받은 추천 수</h3>
                                <p class="margin-b-5">1111</p>
                                <!-- <a class="link" href="html5.html">Read More</a> -->
                            </div>
                            <!-- <a href="html5.html" class="content-wrapper-link"></a> -->
                        </div>
                    </div>
                </div>
                <!--// end row -->
            </div>
            <!--// end row -->
        </div>
    </div>
<!--     <div class="bg-color-sky-light" data-auto-height="true"> -->
<!--         <div class="content-lg container"> -->
<!--             <h2>게시글 차트</h2> -->
<!--             <div class="row row-space-1 margin-b-2"> -->
<!--                 <div id="chart" class="wow fadeInLeft"></div> -->
<!--             </div> -->
<!--         </div> -->
<!--     </div>             -->
    
    <!-- End Service -->

    <!-- Latest Products -->
    
    <!-- End Latest Products -->

    <!-- notice -->
    <div class="bg-color-sky-light">
        <div class="content-lg container">
            <!-- notice -->
            <h2>
                <i class="fas fa-user-tag title_subject_icon"></i>
                	북마크
            </h2>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <th>제목</th>
                        <th>추천수</th>
                        <th>작성자</th>
                        <th>작성일자</th>
                    </thead>
                    <tbody>
                        <tr>
                            <td>asdasd</td>
                            <td>11</td>
                            <td>veiw1</td>
                            <td>2021-12-08</td>
                        </tr>
                        <tr>
                            <td>asddfgdgf</td>
                            <td>222</td>
                            <td>veiw2</td>
                            <td>2021-12-08</td>
                        </tr>
                        <tr>
                            <td>xcvccxvxcv</td>
                            <td>333</td>
                            <td>veiw3</td>
                            <td>2021-12-08</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <!-- End notice -->
        </div>
    </div>
    <!-- End notice -->
    <div class="content-lg container">
        
        <!--// end row -->

        <div class="row">
            <!-- notice -->
            <h2>
                <i class="fas fa-user-edit title_subject_icon"></i>
                	내가 작성한 글
            </h2>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <th>제목</th>
                        <th>추천수</th>
                        <th>작성자</th>
                        <th>작성일자</th>
                    </thead>
                    <tbody>
                        <tr>
                            <td>asdasd</td>
                            <td>11</td>
                            <td>veiw1</td>
                            <td>2021-12-08</td>
                        </tr>
                        <tr>
                            <td>asddfgdgf</td>
                            <td>222</td>
                            <td>veiw2</td>
                            <td>2021-12-08</td>
                        </tr>
                        <tr>
                            <td>xcvccxvxcv</td>
                            <td>333</td>
                            <td>veiw3</td>
                            <td>2021-12-08</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <!-- End notice -->
        </div>

    </div>
    <!-- End Work -->
    <!--========== END PAGE LAYOUT ==========-->





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

    <!-- Load d3.js and c3.js -->
    <script src="../../resource/vendor/c3-0.7.20/c3.js"></script>
    <script src="../../resource/vendor/c3-0.7.20/docs/js/d3-5.8.2.min.js" charset="utf-8"></script>

	<script>
        var chart = c3.generate({
            bindto: '#chart',
            data: {
            columns: [
                ['작성한 글', 30, 200, 100, 400, 150, 250],
                ['받은 추천수', 50, 20, 10, 40, 15, 25]
            ]
            }
        });
    </script>
	
</body>
<!-- END BODY -->

</html>