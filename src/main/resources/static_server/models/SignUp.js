const fetch = require('node-fetch')

module.exports = {
    signUp: async (login, firstName, lastName, email, password) => {
        let user = {
            login: login,
            firstName: firstName,
            lastName: lastName,
            email: email,
            hashPassword: password

        }
        let json = JSON.stringify(user)

        const resp = await fetch('http://localhost:8080/signUp', {
            method: 'POST',
            body: json,
            headers: {
                'Content-Type': 'application/json'
            }
        })
        let body = await resp.json()
        console.log(body)
    }}