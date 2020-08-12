//add libs
let express = require('express');
let cookieParser = require('cookie-parser');
//create instance of express-serv
let app = express();
//using cookie-parser
app.use(cookieParser());
//if user try to use user.html
app.get('/html/user-list.html', function(req, res, next){
    //is token exist in cookies
    //if not - redirect to login
    let token = req.cookies['Auth-Token'];
    if(!req.cookies['Auth-Token']){
        res.redirect('/html/login.html')
    }
    next();
});
//given public folder
app.use(express.static(__dirname + '/public'));
//telling app the port is must be 80
app.listen(80);
console.log("StaticServer started...");