const fetch = require('node-fetch')
let token

module.exports = {
     login : async (login, password) => {
        let user = {
            login: login,
            password: password
        }
        let json = JSON.stringify(user);

             const resp = await fetch('http://localhost:8080/login', {
                method: 'POST',
                body: json,
                headers: {
                    'Content-Type': 'application/json'
                }
            })
                token = await resp.json()
                    console.log(token.value)
            return token.value
    }
}




