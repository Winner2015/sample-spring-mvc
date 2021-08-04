<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>上传与下载</title>
</head>
<body>

<form action="/uploadAndDownload/upload" enctype="multipart/form-data" method="post">
    <table>
        <tr>
            <td>请选择文件：</td>
            <td><input type="file" name="file"></td>
        </tr>
        <tr>
            <td>开始上传</td>
            <td><input type="submit" value="上传"></td>
        </tr>
    </table>
</form>

<hr/>

<a href ="/uploadAndDownload/download?fileName=test.png">下载图片</a>
<a href ="/uploadAndDownload/download?fileName=调试.xlsx">下载Excel</a>

</body>
</html>