<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
    
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="sub_style.css" type="text/css">
        <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<style>
.page{
	height: 100%;
	vertical-align: top;
	text-align: center;
}

.page a{
	text-decoration: none;
}


input[type=text]{
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 3px solid #3e99d2;
    border-radius: 15px;
    box-sizing: border-box;
    outline: none;
    background-color: rgba(0,0,0,0.8);
    color: white;
    background-image: url('serchicon.png');
    background-position: 10px 10px;
    background-repeat: no-repeat;
}


</style>

</head>
<body>
<%String a = "files/"; %>


<div id="line"></div>
    
       <div id="header">
           <li class="home">
           <a href="index.html"><img src="main_logo.png"></a></li>
           <li class="left"><a href="http://70.12.109.117:8888/Day20/top10.do?action=chartList">CHARTS</a></li>
           <li class="left">
            <form method="get" action="/search" id="search">
            <input name="q" type="search" size="50" placeholder="Search for artists, bands, tracks"/>
        </form>
           </li>
        <li class="right"><a href="http://70.12.109.117:8888/Day20/upload_form.jsp">UPLOAD</a></li>
        <li class="right"><a href="http://70.12.109.117:8888/Day20/join_form1.jsp"><button>JOIN US</button></a></li>
        <li class="right"><a href="�α���������">LOGIN</a></li>
       </div>
    

<div id="wrap">
    <div>
    <br><br><br><br><br><br>
        <table id="ticket" width="95%" align="center">
        	<tr>
        		<td rowspan="2"><img src="pay01.jpg"></td>
        		<td rowspan="2">����� ���� ���ǰ���</td>
        		<td>3</td>
        		<td>4</td>
        		<td width="100px"><button>�����ϱ�</button></td>
        	</tr>
       		<tr>
        		<td>3</td>
        		<td>4</td>
        		<td><button>�����ϱ�</button></td>
        	</tr>
                	<tr>
        		<td rowspan="2"><img src="pay02.jpg"></td>
        		<td rowspan="2">���ǰ���</td>
        		<td>30��</td>
        		<td>3,000��</td>
        		<td><a href = "point.do?action=purchase&memberNum=1&days=30"><button>�����ϱ�</button></td>
        		</a>
        	</tr>
           	<tr>
        		<td>60��</td>
        		<td>6,000��</td>
        		<td><a href = "point.do?action=purchase&memberNum=1&days=60"><button>�����ϱ�</button></td>

        	</tr>
             	<tr>
        		<td rowspan="2"><img src="pay03.jpg"></td>
        		<td rowspan="2">���ǰ��� + MP3 30�� �ٿ�</td>
        		<td>3</td>
        		<td>4</td>
        		<td><button>�����ϱ�</button></td>

        	</tr>
         	<tr>
        		<td>3</td>
        		<td>4</td>
        		<td><button>�����ϱ�</button></td>

        	</tr>     
         	<tr>
        		<td rowspan="2"><img src="pay04.jpg"></td>
        		<td rowspan="2">���ǰ��� + ����Ʈ�� ������ �ٿ� + MP3 150�� �ٿ�</td>
        		<td>3</td>
        		<td>4</td>
        		<td><button>�����ϱ�</button></td>

        	</tr>
        	
        	<tr>
        		<td>3</td>
        		<td>4</td>
        		<td><button>�����ϱ�</button></td>

        	</tr>
        </table>
    </div>
    
    
           <div id="footer">
       </div>
    
    </div>

</body>
    
    

    

</html>

