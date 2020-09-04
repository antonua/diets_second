//add libs
const express = require('express')
const path = require('path')
const cookieParser = require('cookie-parser')
const exphbs = require('express-handlebars')
const mainRoutes = require('./routes/main')


//create instance of express-serv
const app = express();


//create instance of express-handlebars
const hbs = exphbs.create({
    defaultLayout: 'main',
    extname: 'hbs'
})

//adding engine to hbs
app.engine('hbs', hbs.engine)
app.set('view engine', 'hbs')
app.set('views', 'views')


app.use(express.urlencoded({ extended: true}))
app.use(mainRoutes)
app.use(express.static(path.join(__dirname, 'public')))

//using cookie-parser
app.use(cookieParser());

//given public folder
app.use(express.static(__dirname + '/public'));
//telling app the port is must be 80
app.listen(80);
console.log("StaticServer started...");