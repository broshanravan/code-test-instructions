const express = require("express");
const app = express();
const path = require("path");
const PORT = process.env.PORT || 3500;
const customization = require("./web/pages/scripts/customization");
const {body} = require("request");

app.use(express.urlencoded({extended:false}));
app.use(express.json());
app.use(express.static(path.join(__dirname, '/web/pages/images/Photos')));
app.use(
    express.urlencoded({
        extended: true
    })
)


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

    var originalURL = request.url;
    //var customisedURL =request.query.customizedFld;
    validateForm(originalURL);
});

app.listen(PORT, ()=>console.log(`server running on port: ${PORT}`));

function validateForm (originalURL){
    const urlParams = new URLSearchParams(originalURL);
    var customizedUrl ="";
    var originalUrl ="";
    var buttonPressed ="";

    for (const [key, value] of urlParams) {
        if(key === "customizedFld"){
            customizedUrl= value;
        } else if(key === "processBtn"){
            buttonPressed = value;
        } else{
            originalUrl = value
        }
    }
    processFormData(customizedUrl, originalUrl, buttonPressed);


}

/**
 * processing the data into
 * the relevant APIs from the
 * SpringBoot backend
 * */
function  processFormData(customizedUrl, originalUrl, buttonPressed){

    if(buttonPressed === "customizeBtn"){
        if(customizedUrl!== null && originalUrl !== null
        && customizedUrl.trim()!== "" && originalUrl.trim() !== "") {
            customization.customizeURL(originalUrl, customizedUrl)
        }
    } else if(buttonPressed === "findBtn"){

        if(customizedUrl!==null && customizedUrl.trim()!=="") {

            let originalURL = customization.getOriginalURL(customizedUrl)

            if (originalURL === null ) {
                originalURL = "Record does not exist"
            }


        }

    } else if(buttonPressed === "deleteBtn"){
        if(customizedUrl!==null && customizedUrl.trim()!=="") {
           // console.log("customizedUrl = " + customizedUrl);
           // console.log("originalUrl = " + originalUrl);
            customization.deleteURLRecord(customizedUrl)
        }
    }


}








