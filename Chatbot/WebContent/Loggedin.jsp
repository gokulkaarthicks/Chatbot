<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>
</head>
<body>
<%
response.setHeader("cache-control","no-cache,no-store,must-revalidate");
response.setHeader("Pragma","no-cache");
response.setHeader("Expires","0");
if(session.getAttribute("username")==null)
	response.sendRedirect("Login.html");
session.removeAttribute("otp");
session.removeAttribute("password");
session.removeAttribute("role");
session.removeAttribute("username");

%>

  <nav class="navbar navbar navbar-dark bg-dark">
  <a class="navbar-brand" href="#"></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
 <form action="Logout" method="post" id="form">
  <a class="nav-link" href="javascript:{}" onclick="document.getElementById('form').submit();" style="float:right"><i class="fa fa-sign-out"></i>Logout</a>
 </form>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="http://localhost:6065/Login/Loggedin.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#"></a>
      </li>

    </ul>
    <!--  <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>-->
  </div>
</nav>
  <div class="container">
	<div class="card text-center">
  <div class="card-header">
    Featured
  </div>
  <div class="card-body">
    <h5 class="card-title">Moratorium Records</h5>
    <p class="card-text">Click Below to open the Moratorium Details Filed By The Users</p>
    <a class="btn btn-primary" href="javascript:{}" onclick="document.getElementsByClassName('card text-center')[0].remove();getData();" >Show Details</a>
  </div>
  <div class="card-body">
    <h5 class="card-title">User Records</h5>
    <p class="card-text">Click Below to open the list of Users</p>
    <a class="btn btn-primary" href="javascript:{}" onclick="document.getElementsByClassName('card text-center')[0].remove();getData1();" >Show Users</a>
  </div>
  <div class="card-footer text-muted">
    Feeds
  </div>
</div>
</div>
  

</div>
<script>
function getData(){
	var myObject
	$.get("userdata",function(data, status){
		myObject = eval('(' + data + ')');
		var container=document.getElementsByClassName("container");
		var rowDiv = document.createElement("DIV");
		rowDiv.setAttribute("class", "row");
	    var length = Object.keys(myObject).length;
	    //console.log(myObject[0]["Name"]);
	    if(length%2==0){
	    	var count=0;
		for (i in myObject)
		{  
		   var temp=addDiv(myObject[i]["Name"],myObject[i]["AccountNumber"],myObject[i]["Reason"],myObject[i]["RepaymentDate"],myObject[i]["CurrentState"],myObject[i]["Confirmation"],myObject[i]["email"],myObject[i]["MobileNumber"],myObject[i]["LoanNumber"]);
		   count++;
		   rowDiv.appendChild(temp);
			if(count==2){
				count=0;
				container[0].appendChild(rowDiv);
				var rowDiv = document.createElement("DIV");
				rowDiv.setAttribute("class", "row");
			}
		}

	    }else if(length==1){
			var i=0;
			var temp=addDiv(myObject[i]["Name"],myObject[i]["AccountNumber"],myObject[i]["Reason"],myObject[i]["RepaymentDate"],myObject[i]["CurrentState"],myObject[i]["Confirmation"],myObject[i]["email"],myObject[i]["MobileNumber"],myObject[i]["LoanNumber"]);
			rowDiv.appendChild(temp);
			container[0].appendChild(rowDiv);
			//break;	
		}
	    else{
		    
		    	var count=0,gcount=0;
					
			for (i in myObject)
			{  
			   var temp=addDiv(myObject[i]["Name"],myObject[i]["AccountNumber"],myObject[i]["Reason"],myObject[i]["RepaymentDate"],myObject[i]["CurrentState"],myObject[i]["Confirmation"],myObject[i]["email"],myObject[i]["MobileNumber"],myObject[i]["LoanNumber"]);
			   count++;
			   gcount++;
			   rowDiv.appendChild(temp);
			   if(count==2){
					count=0;
					container[0].appendChild(rowDiv);
					var rowDiv = document.createElement("DIV");
					rowDiv.setAttribute("class", "row");
				}
				if(gcount==length-1){
					i++;
					var temp=addDiv(myObject[i]["Name"],myObject[i]["AccountNumber"],myObject[i]["Reason"],myObject[i]["RepaymentDate"],myObject[i]["CurrentState"],myObject[i]["Confirmation"],myObject[i]["email"],myObject[i]["MobileNumber"],myObject[i]["LoanNumber"]);
					rowDiv.appendChild(temp);
					container[0].appendChild(rowDiv);
					break;	
				}
			}

	    
	    }
	  });

	
}
function createRow(){
	var container=document.getElementsByClassName("container");
	var rowDiv = document.createElement("DIV");
	rowDiv.setAttribute("class", "row");
	rowDiv.appendChild(addDiv());
	rowDiv.appendChild(addDiv());
	container[0].appendChild(rowDiv);
}
function a(data){
	alert(data);
}
function addDiv(name,accno,reason,repay,state,conf,email,ln,mn){
	
	var colDiv=document.createElement("DIV");
	colDiv.setAttribute("class","col-sm-6");
	colDiv.setAttribute("style","padding: 10px");
	colDiv.setAttribute("name",'d'+accno);
	var cardDiv=document.createElement("DIV");
	cardDiv.setAttribute("class", "card");
	var cardBodyDiv=document.createElement("DIV");
	cardBodyDiv.setAttribute("class", "card-body");
	var h5=document.createElement("h5");
	h5.setAttribute("class", "card-title");
	var eleP=document.createElement("p");
	eleP.setAttribute("class", "card-text");
	var eleA=document.createElement("a");
	eleA.setAttribute("class", "btn btn-primary");
	eleA.setAttribute("href", "#");
	eleA.setAttribute("name", accno);
	eleA.setAttribute("href","javascript:{}");
	eleA.setAttribute("style","padding: 10px");
	var eleB=document.createElement("a");
	eleB.setAttribute("class", "btn btn-primary");
	eleB.setAttribute("href", "#");
	eleB.setAttribute("name", accno);
	eleB.setAttribute("href","javascript:{}");
	eleB.setAttribute("style","padding: 10px");
	var ak=accno.toString();
	eleA.setAttribute("onclick","$.post(\"deleteuserdata\",{accno:"+("1"+accno+"0")+"},function(data, status){document.getElementsByName('"+'d'+accno+"')[0].remove();});");
	eleB.setAttribute("onclick","$.post(\"deleteuserdata\",{accno:"+("2"+accno+"0")+"},function(data, status){document.getElementsByName('"+'d'+accno+"')[0].remove();});");
	h5.innerText="Name: "+name;
	//console.log(email);
	eleP.innerText="Account No: "+accno+"\nReason: "+reason+"\n Repayment Date: "+repay+"\n Current Economic Status: "+state+"\n Confirmation: "+conf+"\n Email id: "+email+"\n Loan Number: "+ln+"\n Mobile Number: "+mn;
	eleA.innerText="Accept";
	eleB.innerText="Reject";
	cardBodyDiv.appendChild(h5);
	cardBodyDiv.appendChild(eleP);
	cardBodyDiv.appendChild(eleA);
	cardBodyDiv.appendChild(eleB);
	cardDiv.appendChild(cardBodyDiv);
	colDiv.appendChild(cardDiv);
	
	
	return colDiv;
	
}
function getData1(){
	var myObject
	$.get("getuser",function(data, status){
		myObject = eval('(' + data + ')');
		var container=document.getElementsByClassName("container");
		var rowDiv = document.createElement("DIV");
		rowDiv.setAttribute("class", "row");
	    var length = Object.keys(myObject).length;
	    //console.log(myObject[0]["Name"]);
	    if(length%2==0){
	    	var count=0;
		for (i in myObject)
		{  
			var temp=addDiv1(myObject[i]["uname"],myObject[i]["email"],myObject[i]["urole"]);
			count++;
		   rowDiv.appendChild(temp);
			if(count==2){
				count=0;
				container[0].appendChild(rowDiv);
				var rowDiv = document.createElement("DIV");
				rowDiv.setAttribute("class", "row");
			}
		}

	    }else if(length==1){
			var i=0;
			var temp=addDiv1(myObject[i]["uname"],myObject[i]["email"],myObject[i]["urole"]);
			rowDiv.appendChild(temp);
			container[0].appendChild(rowDiv);
			//break;	
		}
	    else{
		    
		    	var count=0,gcount=0;
					
			for (i in myObject)
			{  
				var temp=addDiv1(myObject[i]["uname"],myObject[i]["email"],myObject[i]["urole"]);
			   count++;
			   gcount++;
			   rowDiv.appendChild(temp);
			   if(count==2){
					count=0;
					container[0].appendChild(rowDiv);
					var rowDiv = document.createElement("DIV");
					rowDiv.setAttribute("class", "row");
				}
				if(gcount==length-1){
					i++;
					var temp=addDiv1(myObject[i]["uname"],myObject[i]["email"],myObject[i]["urole"]);
					rowDiv.appendChild(temp);
					container[0].appendChild(rowDiv);
					break;	
				}
			}

	    
	    }
	  });

	
}

function addDiv1(name,email,role){
	
	var colDiv=document.createElement("DIV");
	colDiv.setAttribute("class","col-sm-6");
	colDiv.setAttribute("style","padding: 10px");
	colDiv.setAttribute("name",'d'+email);
	var cardDiv=document.createElement("DIV");
	cardDiv.setAttribute("class", "card");
	var cardBodyDiv=document.createElement("DIV");
	cardBodyDiv.setAttribute("class", "card-body");
	var h5=document.createElement("h5");
	h5.setAttribute("class", "card-title");
	var eleP=document.createElement("p");
	eleP.setAttribute("class", "card-text");
	var eleA=document.createElement("a");
	eleA.setAttribute("class", "btn btn-primary");
	eleA.setAttribute("name", email);
	eleA.setAttribute("href","javascript:{}");	
	eleA.setAttribute("onclick","$.post(\"deleteusers\",{email:\""+email+"\"},function(data){document.getElementsByName('"+'d'+email+"')[0].remove();})");
	//eleA.setAttribute("href","http://localhost:6065/Login/Loggedin.jsp");
	h5.innerText="Name: "+name;
	eleP.innerText="User Name: "+name+"\nUser Role: "+role+"\n Email id: "+email;
	eleA.innerText="Remove";
	cardBodyDiv.appendChild(h5);
	cardBodyDiv.appendChild(eleP);
	cardBodyDiv.appendChild(eleA);
	cardDiv.appendChild(cardBodyDiv);
	colDiv.appendChild(cardDiv);
	
	
	return colDiv;
	
}
</script>
</body>
</html> 
