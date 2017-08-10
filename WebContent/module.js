/**
 * 
 */
/**
 * 
 */

function validate_form() {
	if (validate_name() & validate_code() & validate_hours())
		return (true);
	else
		return (false);
}
function validate_name() {
	if (document.emp.mname.value == "") {
		document.getElementById('vname').innerHTML = "Name  should not be empty";
		emp.name.focus();
		return (false);
	} else
		return true;

}
function validate_code() {
	if (document.emp.mcode.value == "") {
		document.getElementById('vcode').innerHTML = "Code  should not be empty";
		emp.asn.focus();
		return (false)
	} else
		return true;
}

function validate_hours() {
	if (document.emp.mhours.value == "") {
		document.getElementById('vhours').innerHTML = "Hours should not be empty ";
		emp.batch.focus();
		return (false)

	} else
		return true;
}

function isNumberKey(evt) {
	var charCode = (evt.which) ? evt.which : event.keyCode;
	if (charCode != 46 && charCode > 31 && (charCode < 48 || charCode > 57)) {
		document.getElementById('vhours').innerHTML = "Enter number";
		return false;
	}

	return true;
}
function isStringKey(evt) {

	var pattern = new RegExp("[a-d1-7]");
	var charCode = (evt.which) ? evt.which : event.keyCode;
	document.write("inside string key");
	var res = pattern.test(charcode);
	if (true)
		return true;
	/* if (charCode.equals(pattern)) {
	 	document.getElementById('vname').innerHTML = "Enter string";
	 	document.write("inside string key if");
	     return true;
	 }*/
	else {
	document.getElementById('vname').innerHTML = "Enter string";
	return false;
  }
}
	

	

