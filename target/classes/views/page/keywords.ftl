<meta http-equiv="content-type" content="text/html; charset=utf-8">
<html>
 <body>
<#include "../common/head.ftl">
<form>
<table>
    <tr>
        <th>id</th>
        <th>keywords</th>
        <th>startTime</th>
        <th>endTime</th>
        <th>saveTime</th>
    </tr>
    <#list getKeywords() as keyword>
        <tr  id="keyword{message.id}">
            <td>${keyword.id}</td>
            <td>${keyword.keywords}</td>
            <td>${keyword.startTime}</td>
            <td>${keyword.endTime}</td>
            <td>${keyword.saveTime}</td>
            <td></td>
        </tr>
    </#list>
    <tr id="storeTable_add">
        <td><input type='text' name='id' id='id' /></td>
        <td>
            <input type='text' name='keywords' id='keywords' /></td>
        <td>
            <input type='text' name='startTime' id='startTime' /></td>
        <td>
            <input type='text' name='endTime' id='endTime' /></td>
        <td>
            <span>
                <input type='button' style="width: 70" id='btnAdd'   value='add'>
                <input type='button' style="width: 70" id='btnEdit'   value='edit'>
            </span>
        </td>
    </tr>
</table>
<script type="text/javascript">
       $(document).ready(function () {
           $('#btnAdd').click(function () {
                 var a = $('#keywords').val();
                 var b = $('#startTime').val();
                 var c = $('#endTime').val();
                 $.ajax({
                     async: false,
                     url: "/kw/add",
                     type: "post",
                     dataType: 'json',
                     data: { keywords: a, startTime: b, endTime: c },
                     error: function (msg) {
                     },
                     success: function (msg) {
                     }
                 });
                 location.reload();
          });
          $('#btnEdit').click(function () {
                   var a = $('#keywords').val();
                   var b = $('#startTime').val();
                   var c = $('#endTime').val();
                   var d = $('#id').val();
                   $.ajax({
                       async: false,
                       url: "/kw/edit",
                       type: "post",
                       dataType: 'json',
                       data: { keywords: a, startTime: b, endTime: c, id: d },
                       error: function (msg) {
                       },
                       success: function (msg) {
                       }
                   });
                   location.reload();
            });
       });
       </script>
</form>
</html>