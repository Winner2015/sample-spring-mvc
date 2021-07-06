<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>参数传递示例</title>

    <script src="/webjars/jquery/jquery.min.js">
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>

</head>
<body>

<a href ="/paramPass/byPathVariable/chen_long_fei/32">PathVariable注解传参</a>
<hr/>
<a href ="/paramPass/byCookieValue">传递Cookie参数</a>
<hr/>
<a href ="/paramPass/byRequestHeader">传递请求头参数</a>

<hr/>

<form action="/paramPass/byDefault" method="get">
  <p>姓名: <input type="text" name="name" value="陈龙飞"/></p>
  <p>年龄: <input type="text" name="age" value="32"/></p>
  <input type="submit" value="传参-默认方式" />
</form>

<hr/>

<form action="/paramPass/byDefault2" method="post">
  <p>姓名: <input type="text" name="name" value="魔杰"/></p>
  <p>年龄: <input type="text" name="age" value="102"/></p>
  <input type="submit" value="传参-默认方式2" />
</form>

<hr/>

<form action="/paramPass/byRequestParam" method="get">
  <p>姓名: <input type="text" name="myName" value="魔杰"/></p>
  <p>年龄: <input type="text" name="age" value="102"/></p>
  <input type="submit" value="传参-@RequestParam" />
</form>

</body>

<script>

$(function () {
                $("#showModalButton").bind('click', function (event) {
                    $('#myModal').modal();
                })
            })

</script>

</html>