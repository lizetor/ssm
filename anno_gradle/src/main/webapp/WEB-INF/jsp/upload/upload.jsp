<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.form.js"></script>
    <script type="text/javascript">
        function submitImgSize1Upload() {
            var option = {
                type: 'POST',
                url: '${pageContext.request.contextPath}/upload.html',
                dataType: 'text',
                data: {
                    fileName: 'imgSize1File'
                },
                success: function (data) {
                    console.log(data);
                }

            };

            $("#uploadForm").ajaxSubmit(option);
        }
    </script>
</head>

<body>
<form id="uploadForm" name="uploadForm" action="${pageContext.request.contextPath}/upload.html" method="post">
    <h1>使用spring mvc提供的类的方法上传文件</h1>
    <input type='file' id='imgSize1File' name='imgSize1File' onchange='submitImgSize1Upload()'/><span class="pos" id="imgSize1FileSpan">请上传图片</span>
</form>
</body>
</html>
