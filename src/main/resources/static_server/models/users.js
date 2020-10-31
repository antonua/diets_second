const fetch = require('node-fetch')

let nameOfCookie = 'Auth-Token'
let token
let users = {};



module.exports ={
    getUser: async(res, req)=> {
        try {
            if (req.headers.cookie.match(nameOfCookie)) {
                token = req.headers.cookie.substring(11)
                let url = 'http://localhost:8080/users?token=' + token
                const resp = await fetch(url);
                users = await resp.json()
                console.log(users)
                res.render('users', {data: users});
            }
        }catch (e) {
            res.redirect('/login');
        }
    }
}
