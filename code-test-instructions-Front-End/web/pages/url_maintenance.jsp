<html>
        <head>
    		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    		<title>Registration</title>
    		<link rel="stylesheet" href="pages_style">
    		<script src="scripts/customization.js"></script>
    	</head>

    	<body class="register_body">
           <form  name="urlRegistrationForm" id="urlRegistrationForm"  onsubmit="return false;">
               <table class="noselect"id="main_table">
                   <tr>
                        <td><b><label>Original URL</label></b></td>
                        <td><input type="text" id="original" class="textFld"/>*</td>

                        <td>&nbsp;</td>
                        <td><label style="color:red; display:none;" id="postCodeError">Please insert a URL</label></td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td><b><label>Customized URL</label></b></td>
                        <td><input type="text" id="customized" class="textFld"/>*</td>

                        <td>&nbsp;</td>
                        <td><label style="color:red; display:none;" id="customized">Please insert The required customized URL/label></td>
                    </tr>


               </table>

            </form>
        </body>


        <table>
            <tr>
                <td>&nbsp;</td>
                <td>
                    <table>
                        <tr>
                            <td><button class="button" id="create" onclick="validateForm()">Create Customized URL</button></td>
                            <td><button class="button" id="Find" onclick="validateForm()">Find Customized URL</button></td>
                            <td><button class="button" id="deleteL" onclick="validateForm()">Delete Record</button></td>
                            <td><button class="button" id="clear"onclick="clearAllFields()">Clear</button></td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>


</html>