<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
        <link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet">
        <meta charset="UTF-8">
        <title>Add Todo Page</title>
    </head>

    <body>
        <div class="container">
            <h1>등록하기</h1>
            <form:form method="post" modelAttribute="todo">
                <fieldset class="mb-3">
                    <form:label path="description">할일</form:label>
                    <form:input type="text" path="description" required="required"/>
                    <form:errors path="description" cssClass="text-warning"/>
                </fieldset>

                <fieldset class="mb-3">
                    <form:label path="targetDate">목표 날짜</form:label>
                    <form:input type="text" path="targetDate" required="required"/>
                    <form:errors path="targetDate" cssClass="text-warning"/>
                </fieldset>

                <form:input type="hidden" path="id"/>
                <form:input type="hidden" path="done"/>
                <input type="submit" class="btn btn-success">
            </form:form>
        </div>

        <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
        <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
        <script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>

        <script type="text/javascript">
          $('#targetDate').datepicker({
            format: 'yyyy-mm-dd'
          });
        </script>
    </body>
</html>