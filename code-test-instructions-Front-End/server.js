const express = require("express");
const app = express();
const path = require("path");
const PORT = process.env.PORT || 3500;
const customization = require("./web/pages/scripts/customization");
const {body} = require("request");

app.use(express.urlencoded({extended:false}));
app.use(express.json());
app.use(express.static(path.join(__dirname, '/web/pages/images/Photos')));


/**
 * Rendering the stylesheet file to the client side
 * */

app.get('/pages_style',(req,res) => {
    //res.sendFile('./web/Test_Index.html', {root: __dirname});
    res.sendFile(path.join(__dirname, './web/pages', '/styles/pages_style.css'));
});



/**
 * Rout Handler rendering the html file to the client side
 * */
app.get('/url_customization',(req,res) => {
    res.sendFile(path.join(__dirname, './web/pages', '/url_registration.html'));
});


/**
 *  Handling button clicks and events on the html page
 *  */
app.get("/urlRegistration",(request,response) =>{

    var originalURL = request.query.originalFld;
    var customisedURL =request.query.customizedFld;
    //console.log(clicked_id);
    console.log(originalURL);
    console.log(customisedURL);
    validateForm(originalURL, customisedURL,request);

});

app.listen(PORT, ()=>console.log(`server running on port: ${PORT}`));

function validateForm (originalURL,customizedURL,request){

     let inputValue = request.body.processBtn.body.toString();

    console.log("validating");
    //console.log(inputValue);
}





