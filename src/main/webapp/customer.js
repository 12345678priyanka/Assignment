/**
 * 
 */
var customerData=[
	{"first_name":"Jane","last_name":"Doe","street":"Elvnu Street","addres":"H no 2","city":"Delhi","state":"Delhi","email":"sam@gmail.com","phone":"12345678"},
];

function populateCustomerTable(){
	var tableBody=document.getElementById("customerTableBody");
	var tableBody=document.getElementById("customerTableBody");
	
	tableBody.innerHTML="";
	
	for(var i=0;i<customerData.length;i++){
		var customer=customerData[i];
		var row=tableBody.insertRow(i);
		
		var properties=["first_name","last_name","street","address","city","state","email","phone"];
		for(var j=0;j<properties.length;j++){
			var cell=row.insertCell(j);
			cell.innerHTML=customer[properties[j]];
			}
			}
			}
windows.onload=populateCustomerTable;