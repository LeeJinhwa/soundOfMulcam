<!doctype html>  
<html>
<head>
    <title>Audio Element Sample</title>
    <!-- Uncomment the following meta tag if you have issues rendering this page on an intranet site. -->    
    <!--  <meta http-equiv="X-UA-Compatible" content="IE=9"/> --> 
</head>
<body>
    <h1>Audio Element Sample</h1>
    
    <!-- Display the audio player with control buttons. -->
    <audio src="files/<%=request.getParameter("fileNum") %>" controls autoplay loop> 
        HTML5 audio not supported
    </audio>
</body>
</html>