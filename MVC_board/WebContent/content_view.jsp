<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<form action="modify.do" method="post">
		<input type="hidden" name = "BId" value = "${content_view.BId }">
		<tr>
				<td> ��ȣ </td>
				<td> ${content_view.BId} </td>
			</tr>
			<tr>
				<td> ��Ʈ </td>
				<td> ${content_view.BHit} </td>
			</tr>
			<tr>
				<td> �̸� </td>
				<td> <input type="text" name="BName" value="${content_view.BName}"></td>
			</tr>
			<tr>
				<td> ���� </td>
				<td> <input type="text" name="BTitle" value="${content_view.BTitle}"></td>
			</tr>
			<tr>
				<td> ���� </td>
				<td> <textarea rows="10" name="BContent" >${content_view.BContent}</textarea></td>
			</tr>
			<tr >
				<td colspan="2"> <input type="submit" value="����"> &nbsp;&nbsp; <a href="list.do">��Ϻ���</a> &nbsp;&nbsp; <a href="delete.do?BId=${content_view.BId}">����</a> &nbsp;&nbsp; <a href="reply_view.do?BId=${content_view.BId}">�亯</a></td>
			</tr>
		</form>
		</table>
</body>
</html>