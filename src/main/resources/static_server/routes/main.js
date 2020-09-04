const {Router} = require('express')
const router = Router()
const logs = require('../models/Login')
const signUp = require('../models/SignUp')
const getUsers = require('../models/users')

let nameOfCookie = 'Auth-Token'
let token

//home page

router.get('/', (req, res) => {
    res.render('index', {
        title: 'Diets helper',
        isIndex: true
    })
})


//Login page

router.get('/login', (req, res) => {
    res.render('login', {
        title: 'Login',
        isLogin: true
    })
})

//Login post req to Java Backend

router.post('/login', async(req, res) => {
    token = await logs.login(req.body.login, req.body.password)
    console.log(token)
    if(token !== undefined){
         res.cookie(nameOfCookie, token)
         res.render('index', {
            isLogin: true
        })
    }

})

//SignUp page

router.get('/signUp', (req, res) =>{
    res.render('signUp',{
        title: 'SignUp',
        isSignUp: true
    })
})


//SignUp post req to Java Backend

router.post('/signUp', async(req, res) =>{
    await signUp.signUp(req.body.login, req.body.firstName, req.body.lastName, req.body.email, req.body.hashPassword)
        if(signUp.error){
            res.render('index',{
                isSignedUp: true
            })
        }
})

//Users page

router.get('/users', (req, res) =>{
   if(req.headers.cookie.match(nameOfCookie) !== null){
       getUsers.getUser(req.headers.cookie.substring(11));
   }

    // if(res.cookies.nameOfCookie){
    //     getUsers.getUser()
    //     res.render('users', {
    //         title: 'Users'
    //     })
    // }
})

module.exports = router
