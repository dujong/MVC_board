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
		<form action="reply.do" method="post">
			<input type="hidden" name="BId" value="${reply_view.BId}">
			<input type="hidden" name="BGroup" value="${reply_view.BGroup}">
			<input type="hidden" name="BStep" value="${reply_view.BStep}">
			<input type="hidden" name="BIndent" value="${reply_view.BIndent}">
			<tr>
				<td> ��ȣ </td>
				<td> ${reply_view.BId} </td>
			</tr>
			<tr>
				<td> ��Ʈ </td>
				<td> ${reply_view.BHit} </td>
			</tr>
			<tr>
				<td> �̸� </td>
				<td> <input type="text" name="BName" value="${reply_view.BName}"></td>
			</tr>
			<tr>
				<td> ���� </td>
				<td> <input type="text" name="BTitle" value="${reply_view.BTitle}"></td>
			</tr>
			<tr>
				<td> ���� </td>
				<td> <textarea rows="10"  name="BContent">${reply_view.BContent}</textarea></td>
			</tr>
			<tr >
				<td colspan="2"><input type="submit" value="�亯"> <a href="list.do" >���</a></td>
			</tr>
		</form>
	</table>
	
</body>
</html>