<html>
<body>
<h2>Hello World!</h2>

<%--动态选择方法及属性--%>
<script>
    var love={firstName:'elode',lastName:'Person'};
    var useFirstName=true;
    alert(love[useFirstName?'firstName':'lastName']);
</script>
</body>
</html>