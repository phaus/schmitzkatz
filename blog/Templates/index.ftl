<!doctype html>
<html lang="en-us">
	<head>
		<title>mactun.es</title>

		<meta charset="utf-8">
		<!--[if IE]>
			<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<![endif]-->

        <meta name="HandheldFriendly" content="true" />
        <meta name="viewport" content="
              width=device-width, 
              initial-scale=1.0, 
              minimum-scale=1.0, 
              maximum-scale=1.0, 
              user-scalable=0,
              target-densitydpi=medium-dpi" />

        <!--[if IE]>
			<link rel="stylesheet" href="stylesheets/desktop.css" />	
        <![endif]-->
		<link rel="stylesheet" media="screen and (min-width : 768px)" href="stylesheets/desktop.css" />
		<link rel="stylesheet" href="stylesheets/mobile.css" media="screen and (max-width : 767px)" />

		<link rel="icon" href="media/favicon.ico" type="image/x-icon">

		<link rel="apple-touch-icon" href="media/touch-icon-iphone.png" />
		<link rel="apple-touch-icon" sizes="72x72" href="media/touch-icon-ipad.png" />
		<link rel="apple-touch-icon" sizes="114x114" href="media/touch-icon-iphone-retina.png" />
		<link rel="apple-touch-icon" sizes="144x144" href="media/touch-icon-ipad-retina.png" />
	</head>
	<body>
		<div id="container">
			<nav>
				<ul id="navigation">
					<li><a href="apps.html" class="left-link">apps</a></li>
					<li><a href="index.html" class="left-link active">blog</a></li>
					<li>
						<a href="http://mactun.es">
							<img src="media/logo_compact.png" alt="mactun.es Logo" />
						</a>
					</li>
					<li><a href="contact.html" class="right-link">contact</a></li>
					<li><a href="about.html" class="right-link">about</a></li>
				</ul>
			</nav>

			<hr />

			<section>
				<#list blogposts as post>
					<article>
						<header>
							<h1><a href="${post.link}">${post.title}</a></h1>
							<span>${post.date?string("yyyy-MM-dd")}</span>
						</header>
						<section class="post-text">
							${post.summary}
							<p>
								<a href="${post.link}">Read on...</a>
							</p>
						</section>
					</article>
				</#list>
			</section>
		</div>
	</body>
</html>