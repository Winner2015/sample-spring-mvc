<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FreeMarker Web</title>
</head>
<body>
    <#if user??>
         <h1>姓名：${user.name!'未知2'}</h1>
         <h1>年龄：${user.age!1}</h1>
    <#else>
        <h1>姓名：${name!'未知'}</h1>
        <h1>年龄：${age!0}</h1>
    </#if>
    <h1>ID：${id!0}</h1>
    <h1><a href = "/paramPass/getSessionAttributes">获取Session中的参数</a></h1>
</body>
</html>