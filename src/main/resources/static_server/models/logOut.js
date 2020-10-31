
module.exports = {
    logOut : async (req,res)=>{
        res.clearCookie('Auth-Token')
        console.log('Cookie was cleared')
        res.redirect('/');

    }

}