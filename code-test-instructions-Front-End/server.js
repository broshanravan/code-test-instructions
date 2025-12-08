const express = require("express");
const app = express();
const path = require("path");
const PORT = process.env.PORT || 3500;
const customization = require("./web/pages/scripts/customization");

app.use(express({extended:true}));

/*Rendering the stylecheet file to the client side*/

app.get('/pages_style',(req,res) => {
    //res.sendFile('./web/Test_Index.html', {root: __dirname});
    res.sendFile(path.join(__dirname, './web/pages', '/styles/pages_style.css'));
});


/*Rendering the html file to the client side*/
app.get('/url_customization',(req,res) => {
    res.sendFile(path.join(__dirname, './web/pages', '/url_registration.html'));
});

/* Handling button clicks and events on the html page*/
app.get("/urlRegistration",(request,response) =>{

    var originalURL = request.query.originalFld;
    var customisedURL =request.query.customizedFld;
    //console.log(clicked_id);
    console.log(originalURL);
    console.log(customisedURL);
    if(customisedURL===""){

    }
    if(originalURL===""){

    }
});

app.listen(PORT, ()=>console.log(`server running on port: ${PORT}`));






