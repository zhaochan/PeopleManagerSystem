<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<head>
<script type="text/javascript" src="js/jquery.core.js"></script>
<script type="text/javascript" src="js/jquery.superfish.js"></script>
<script type="text/javascript" src="js/jquery.jcarousel.pack.js"></script>
<script type="text/javascript" src="js/jquery.easing.js"></script>
<script type="text/javascript" src="js/jquery.scripts.js"></script>


<script>
   window.onload = function(){//段落字多的时候进行缩进处理
            var text = document.getElementById('txt'),
            str = text.innerHTML,
            textLeng = 80;
            if(str.length > textLeng ){
                  text .innerHTML = str.substring(0,textLeng )+">>>";
            } 
}
</script>
</head>

<body id="index">
	<%@ include file="common/top.jsp" %><!-- 引入头部的页面部分 -->


			<div class="middle_banner">

				<div class="featured_slider">
					<!-- begin: sliding featured banner -->
					<div id="featured_border" class="jcarousel-container">
						<div id="featured_wrapper" class="jcarousel-clip">
							<ul id="featured_images" class="jcarousel-list">
								<li><img src="images/slider_photo.jpg" width="965"
									height="280" alt="" />
								</li>
								<li><img src="images/slider_photo2.jpg" width="965"
									height="280" alt="" />
								</li>
								<li><img src="images/slider_photo3.jpg" width="965"
									height="280" alt="" />
								</li>
								<li><img src="images/slider_photo4.jpg" width="965"
									height="280" alt="" />
								</li>
							</ul>
						</div>
						<div id="featured_positioner_desc" class="jcarousel-container">
							<div id="featured_wrapper_desc" class="jcarousel-clip">
								<ul id="featured_desc" class="jcarousel-list">
									<li>
										<div>
											<p>欢迎来到Ushop校园二手跳蚤市场，University shop
												是一家充满特色的二手购物市场。在这里你不仅可以以低价买到自己心仪的商品，也可以将自己的旧物发布拍卖，买卖实惠又方便。</p>
										</div></li>
									<li>
										<div>
											<p>每天都有大批商品在Ushop跳蚤市场流通，商品种类丰富齐全，只要你进入Ushop，一定会买到称心如意的商品，包你满载而归。
											</p>
										</div></li>
									<li>
										<div>
											<p>Ushop在一些特定时季会有一些在原来低价的基础上进行再次打折，比如开学季，毕业季，都有跳楼价商品出售。</p>
										</div></li>
									<li>
										<div>
											<p>所以，亲耐的小伙伴们，你还在等什么，快快进入我们的Ushop校园二手跳蚤市场！</p>
										</div></li>
								</ul>
							</div>

						</div>
						<ul id="featured_buttons" class="clear_fix">
							<li>1</li>
							<li>2</li>
							<li>3</li>
							<li>4</li>
						</ul>
					</div>
					<!-- end: sliding featured banner -->
				</div>



			</div>
			<!---------------------------------end of middle banner-------------------------------->


			<div class="center_content">



				<div class="home_section_left">
					<img src="images/icon1.gif" alt="" title=""
						class="home_section_icon" border="0" />

					<h2 class="home_title">What we do</h2>


					<div class="home_section_thumb">
						<img src="images/home_section_thumb1.jpg" alt="" title=""
							border="0" />
					</div>
					<div id="txt">
						<p>Ushop是一家University shop ，主要进行校园二手商品的买卖。
							这是一家专为学生定制，具备提高旧物利用率，为学生省钱等诸多优点的购物网站。</p>
					</div>


				</div>


				<div class="home_section_left">
					<img src="images/icon2.gif" alt="" title=""
						class="home_section_icon" border="0" />

					<h2 class="home_title">Who we are</h2>


					<div class="home_section_thumb">
						<img src="images/home_section_thumb2.jpg" width="265" height="77"
							alt="" title="" border="0" />
					</div>
					<div id="txt">
						<p>我们作为Ushop的网站开发人员，主要由赵昌奎，段叶继，梁濠彦，李春，车军妮组成。能够给用户提供网站使用的方法和步骤，也能根据用户的建议对网站进行不断的完善，做到网站充分满足用户需求，与时俱进。
						</p>
					</div>

				</div>

				<div class="home_section_left">
					<img src="images/icon3.gif" alt="" title=""
						class="home_section_icon" border="0" />

					<h2 class="home_title">Special services</h2>


					<div class="home_section_thumb">
						<img src="images/home_section_thumb3.jpg" width="265" height="77"
							alt="" title="" border="0" />
					</div>
					<div id="txt">
						<p>Ushop特色服务如下：</p>
						<p>1.</p>
						<p>2.</p>
						<p>3.</p>
					</div>
				</div>


				<div class="left_block_wide">
					<h2>Latest Projects</h2>

					<a href="#"><img src="images/p1.jpg" alt="" title="" border="0"
						class="projects" />
					</a> <a href="#"><img src="images/p2.jpg" alt="" title=""
						border="0" class="projects" />
					</a> <a href="#"><img src="images/p3.jpg" alt="" title=""
						border="0" class="projects" />
					</a>


				</div>
				<div class="clear"></div>
			</div>

			

<%@ include file="common/button.jsp"%><!-- 引入头部的页面部分 -->

	
</body>

</html>
