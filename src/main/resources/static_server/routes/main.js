const {Router} = require('express')
const router = Router()

const logs = require('../models/Login')
const signUp = require('../models/SignUp')
const getUsers = require('../models/users')
const logOut = require('../models/logOut')
const getDiets = require('../models/Diets')


let token
let isL = false
let username

//home page

router.get('/', (req, res) => {
    res.render('index', {
        title: 'Diets helper',
        isIndex: true,
        isLogged: isL
    })
    console.log(isL)
})


//Login page

router.get('/login', (req, res) => {
    res.render('login', {
        title: 'Login',
        isSignIn: true
    })
})

//Login post req to Java Backend

router.post('/login', async(req, res) => {
    token = await logs.login(req.body.login, req.body.password)
    if(token !== undefined){
        isL = true;
         res.cookie('Auth-Token', token)
         username = req.body.login
         res.render('index',{username: username, isL: isL})
    }else{
        res.render('login',{
            isError: true
        })

    }
    console.log(isL)
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
        if(!signUp.error){
            res.render('login')
        }
})

//Users page

router.get('/users', (req, res) =>{
       getUsers.getUser(res, req);
})

//Log out

router.get('/logOut', (req,res) =>{
    logOut.logOut(req,res);
    isL = false
})

//Recipes API
router.get('/diets',async (req,res)=>{
    let diets = await getDiets.getDiets();
    res.render('diets', {data: diets, ingredients: diets.extendedIngredients})
})

router.post('/diets', async (req,res)=>{
    let diet = await getDiets.getDiets(req.body.typeName);
    res.render('diets', {data: diet, ingredients: diet.extendedIngredients})
})

module.exports = router
