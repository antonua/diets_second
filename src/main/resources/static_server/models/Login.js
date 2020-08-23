const request = require('request')
const serv = require('../server')
let token;

module.exports = {
    login :function (login, password) {
        let user = {
            login: login,
            password: password
        }
    let json = JSON.stringify(user)

        let clientServerOption = {
        url: 'http://localhost:8080/login',
        headers: {'Content-Type' : 'application/json'},
        method: 'POST',
        body: json
        }
        request( clientServerOption, function (error, response) {
            console.log(error, response.body)
            if(error == null){
                token = response.body;
                serv.cookie = "Auth-Token=" + token;
            }
        })
}
}
