
function myLoginFunction(){
	 
    let link=document.getElementById("signin");
    if(link.value=="hrlogin.jsp"){
        location.assign(link.value);
    }
    if(link.value=="jobseekerlogin.jsp"){
        location.assign(link.value);
    }
}
 
function myRegistrationFunction(){
    let link=document.getElementById("signup");
    if(link.value=="hrregistration.jsp"){
        location.assign(link.value);
    }
    if(link.value=="jobseekerregistration.jsp"){
        location.assign(link.value);
    }
}

function hrLoginData(){
	let hrLoginDetails= document.getElementById("hrlogin");
    document.write("dbijb");
}