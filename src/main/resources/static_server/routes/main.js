const {Router} = require('express')
const router = Router()
const logs = require('../models/Login')


router.get('/', (req, res) => {
    res.render('index', {
        title: 'Diets helper',
        isIndex: true
    })
})

router.get('/login', (req, res) => {
    res.render('login', {
        title: 'Login',
        isLogin: true
    })
})

router.post('/login', async(req, res) => {
    logs.login(req.body.login, req.body.password)
    if(logs.token !== null){
        res.render('index', {
            inLogin: req.body.login,
            isLogin: true
        })
    }

})

router.get('/signUp', (req, res) =>{
    res.render('signUp',{
        title: 'SignUp',
        isSignUp: true
    })
})

module.exports = router
