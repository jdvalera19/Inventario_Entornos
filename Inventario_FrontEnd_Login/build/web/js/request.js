/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

const url = "http:/localhost:8095/"

function sendRequest(endPoint, method, data){
    let request = new XMLHttpRequest();
    request.open(method, url+endPoint);
    request.responseType = 'json';
    request.setRequestHeader('Content-Type','application/json');
    request.send(data ? JSON.stringify(data): data);
    return request;
}

