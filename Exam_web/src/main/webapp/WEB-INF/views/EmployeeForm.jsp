<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Employee</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2>Add Employee</h2>
    <form:form modelAttribute="employee" method="post" action="/employees/add" class="form">
        <div class="form-group">
            <label for="name">Name:</label>
            <form:input path="name" id="name" class="form-control" />
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <form:input path="email" id="email" class="form-control" />
        </div>
        <div class="form-group">
            <label for="skills">Skills:</label>
            <form:input path="skills" id="skills" class="form-control" />
        </div>
        <div class="form-group">
            <label for="project">Project:</label>
            <form:select path="project.id" items="${projects}" itemValue="id" itemLabel="name" class="form-control" />
        </div>
        <button type="submit" class="btn btn-primary">Add Employee</button>
    </form:form>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrap.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
