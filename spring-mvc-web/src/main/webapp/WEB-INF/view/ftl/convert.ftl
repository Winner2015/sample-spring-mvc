<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>转换器</title>

    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>

</head>

<body>


    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text">时间字符串：</span>
        </div>
        <input id="bySpringDateTimeFormat_val" type="text" class="form-control" value="2021-07-18 12:00:00"/>
    </div>
    <button id="bySpringDateTimeFormat" type="submit" class="btn btn-primary">Spring转换器 @DateTimeFormat</button>

    <hr/>


    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text">对象字符串：</span>
        </div>
        <input id="byCustomFormatter_val" type="text" class="form-control" value="2021-07-18 12:00:00~2021-07-28 12:00:00~11.22~33.44"/>
    </div>
    <button id="byCustomFormatter" type="submit" class="btn btn-primary">Spring Formatter</button>

    <hr/>


    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text">对象字符串：</span>
        </div>
        <input id="byCustomConvertor_val" type="text" class="form-control" value="123456~陈龙飞"/>
    </div>
    <button id="byCustomConvertor" type="submit" class="btn btn-primary">Spring Convertor</button>

    <hr/>

    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text">JSON字符串：</span>
        </div>
        <input id="byJacksonConvertor_val" type="text" class="form-control" value=""/>
    </div>
    <button id="byJacksonConvertor" type="submit" class="btn btn-primary">Jackson Convertor</button>

    <hr/>

    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text">对象字符串：</span>
        </div>
        <input id="byCustomHttpMessageConverter_val" type="text" class="form-control" value="沙悟净:大师兄:师傅被妖怪抓走了！"/>
    </div>
    <button id="byCustomHttpMessageConverter" type="submit" class="btn btn-primary">Spring HttpMessageConverter</button>


</body>

<script>
    $(function() {

        $("#bySpringDateTimeFormat").click(function() {
            var dataStr = $("#bySpringDateTimeFormat_val").val();
            var data = {"dataStr":dataStr};
            $.ajax({
                type: "POST",
                url: "/convert/bySpringDateTimeFormat",
                data: data,
                success: function(data) {
                    alert(data);
                },
                error: function(xhr, error) {
                    alert(error);
                }
            });

        });

        $("#byCustomFormatter").click(function() {
            var str = $("#byCustomFormatter_val").val();
            var data = {"sample":str};
            $.ajax({
                type: "POST",
                url: "/convert/byCustomFormatter",
                data: data,
                success: function(data) {
                    alert(data);
                },
                error: function(xhr, error) {
                    alert(error);
                }
            });

        });

        $("#byCustomConvertor").click(function() {
            var str = $("#byCustomConvertor_val").val();
            var data = {"sample":str};
            $.ajax({
                type: "POST",
                url: "/convert/byCustomConvertor",
                data: data,
                success: function(data) {
                    alert(data);
                },
                error: function(xhr, error) {
                    alert(error);
                }
            });

        });


        $("#byJacksonConvertor").click(function() {
            var data = $("#byJacksonConvertor_val").val();
            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: "/convert/byJacksonConvertor",
                data: data,
                success: function(data) {
                    alert(data);
                },
                error: function(xhr, error) {
                    alert(error);
                }
            });

        });


        $("#byCustomHttpMessageConverter").click(function() {
            var data = $("#byCustomHttpMessageConverter_val").val();
            $.ajax({
                type: "POST",
                contentType: "application/clf",
                url: "/convert/byCustomHttpMessageConverter",
                data: data,
                success: function(data) {
                    alert(data);
                },
                error: function(xhr, error) {
                    alert(error);
                }
            });

        });


    });



</script>

</html>