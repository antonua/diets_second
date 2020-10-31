const fetch = require('node-fetch')

let diets


module.exports = {
    getDiets : async (dietType)=> {
        if (dietType !== undefined) {
            try {
                console.log(dietType)
                let url = 'http://localhost:8080/diets/' + dietType
                const resp = await fetch(url)
                diets = await resp.json()
                return diets
            } catch (e) {
                console.log(e)
            }
        } else {
            dietType = '/dessert'
            if (diets == null) {
                try {
                    let url = 'http://localhost:8080/diets' + dietType
                    const resp = await fetch(url)
                    diets = await resp.json()
                    return diets
                } catch (e) {
                    console.log(e)
                }
            } else {
                return diets;
            }
        }
    }
}