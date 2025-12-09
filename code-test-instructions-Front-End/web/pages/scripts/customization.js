const express = require("express");
const app = express();
const fs =require("fs");

const request = require('request')
const axios = require('axios');


exports.customizeURL = (original_URL,customized_URL) =>{
    const api_url = `http://localhost:8080/customizeTheURL?originalURLStr=${original_URL}&newCustomizedUrl=${customized_URL}`;
    request.post({url:api_url},(error,response) =>{
        console.log(response.body);
    });

}

exports.getOriginalURL = async ( customized_URL) => {
    const api_url = `http://localhost:8080/getOriginalURL?newCustomizedUrl=${customized_URL}`;
    request({url:api_url},(error,response) =>{
        console.log(response.body);
        return response.body
    });
}

exports.deleteURLRecord = (customized_URL) =>{
    const api_url = `http://localhost:8080/deleteUrlRecord?customizedUrl=${customized_URL}`;
    axios
        .delete(api_url)
        .then((res) => {
            // Handle the response
            console.log('Status code:', res.status); // Print the status code
            console.log('Headers:', res.headers); // Print the headers
            console.log('Data:', res.data); // Print the data
        })
        .catch((err) => {
            // Handle any errors
            console.error('Error:', err.message); // Print the error message
        });
}




