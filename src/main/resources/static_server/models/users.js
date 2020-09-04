const fetch = require('node-fetch')
let users = {};



module.exports ={
    getUser: async(token)=>{
        let url = 'http://localhost:8080/users?token=' + token
        console.log(url)
        const resp = await fetch(url);
        users = await resp.json()
        console.log(users)

                    const table = users
    //             for(let i =0; i < body.length; i++){
    //                 let row = table.insertRow(i + 1);
    //                 const cellId = row.insertCell(0);
    //                 const cellLogin = row.insertCell(1);
    //                 cellId.innerHTML = data[i]["id"];
    //                 cellLogin.innerHTML = data[i]["login"];
    //             }
    //         }
    //     })
    }
}



// //if user try to use user-list.html
// app.get('/users', function(req, res, next){
//     //is token exist in cookies
//     //if not - redirect to login
//     let token = req.cookies['Auth-Token'];
//     console.log(token);
//     if(!req.cookies['Auth-Token']){
//         res.redirect('/login')
//     }
//     next();
// });