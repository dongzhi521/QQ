<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<html>
<head>
    <title>主页</title>
</head>

<body>
<center>


    <form action="select" method="post">

        <select name="lname">
            <option selected="selected" value="0">全部</option>

            <c:forEach items="${lists}" var="a">
                <c:if test="${lname==a.id}">
                    <option selected="selected" value="${a.id}">${a.name}</option>
                </c:if>

                <c:if test="${lname!=a.id}">
                    <option value="${a.id}">${a.name}</option>
                </c:if>
            </c:forEach>
        </select>
        <input  name="summary"/>
        <input type="submit"  value="搜索"/>
    </form>


    <table border="1px">
        <tr>
            <th  colspan="6" >电子文档表格</th>
        </tr>

        <tr>
            <th>文档编号</th>
            <th>文档名称</th>
            <th>文档摘要</th>
            <th>上传人</th>
            <th>上传时间</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${list}" var="c">
            <tr>
                <td id="aa">${c.id}</td>
                <td>${c.edoccategory.name}</td>
                <td>${c.summary}</td>
                <td>${c.uploaduser}</td>
                <td><fmt:formatDate value="${c.createdate}" pattern="yyyy-MM-dd" /></td>


                <td><a href="dels/${c.id}">删除</a> 修改</td>



            </tr>


        </c:forEach>

        <tr id="tr">
            <th  colspan="6"><span id="info">${shan}</span></th>
        </tr>
    </table>
    <a href="/inits/1">首页</a>
    <a href="/inits/${info.prePage}">上一页</a>
    <a href="/inits/${info.nextPage}">下一页</a>
    <a href="/inits/${info.pages}">末页</a>
    <a>第${info.getPageNum()}页/共${info.pages}页</a>
</center>
</body>

<script type="text/javascript">

    function fun(id){
        $.ajax({
            type: "POST",
            url: "del",
            data: "id="+id,
            success: function(m){
                $("#tr").show();
                if (m==1) {

                    $("#info").html("删除成功");
                }else{

                    $("#info").html("删除失败");
                }

            }
        });

    }

</script>
</html>
