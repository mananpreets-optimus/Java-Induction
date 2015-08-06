<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<script>
function ValidateEmail(mail)   
{  
 if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(mail))  
  {  
    return (true)  
  }  
    alert("You have entered an invalid email address!")  
    return (false)  
}  
function phonenumber(inputtxt)  
{  
  var phoneno = /^\d{10}$/;  
  if(inputtxt.value.match(phoneno))  
        {  
      return true;  
        }  
      else  
        {  
        alert("message");  
        return false;  
        }  
} 
function evaluateFields(){
	
}
</script>

</head>
<body>
<b><u>Guest Login</u></b>
<br>
<form action="LoginGuest" method="GET">
Email : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="email"  onblur="ValidateEmail(this)" />
<br><br>
Password : <input type="password" name="password">
<br><br>

<input type="Submit"  value="Submit" />

</form>
<br>
<br>
<br>
<br>
<b><u>Admins Login</u></b>
<form action="LoginAdmin" method="GET">
Name : &nbsp;&nbsp;&nbsp;;&nbsp;&nbsp;<input type="text" name="adminName" />
<br><br>
Password : <input type="password" name="password">
<br><br>
<input type="Submit"   value="Submit" />
</form>
</body>
</html>