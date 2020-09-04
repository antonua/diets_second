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

//     function (login, password) {
//         let user = {
//             login: login,
//             password: password
//         }
//     let json = JSON.stringify(user)
//
//         let clientServerOption = {
//         url: 'http://localhost:8080/login',
//         headers: {'Content-Type' : 'application/json'},
//         method: 'POST',
//         body: json
//         }
//
//         request(clientServerOption,   async function (error, res) {
//             if(error == null){
//                 token = await JSON.parse(res.body).value;
//                 console.log(token)
//             }
//         })
//         console.log(token)
//         return token
// }
//}



