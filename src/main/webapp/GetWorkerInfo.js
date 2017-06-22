/**
 * Created by User on 6/15/2017.
 */
function getAllWorkers() {
    const ul = document.getElementById('dishWasher')
    const url = 'http://localhost:9000/rest/worker'
    fetch(url, {
        method: 'get',
        headers: {
            'Content-Type': 'application/json'
        },
    }).then((response) => response.json()
    ).then(function (data) {
        let workerList = ""
        for (let i = 0; i < data.length; i++) {
            workerList += `<select><option>${data[i].firstName} ${data[i].lastName}</option></select>`
        }
        return ul.innerHTML = workerList

    })
}
getAllWorkers()

function rdyToWash() {
    const dishAmount = document.getElementById('dishes')
    const liquidAmount = document.getElementById('liquid')
    const workerWork = document.getElementById('dishWasher')
    const url = ''      //Think about what address or place you want it to show
    fetch(url, {
        method: 'post',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            dishAmount,
            liquidAmount,
            workerWork,
        })
    }).then((response) => response.json()
    ).then(function (data) {
        console.log(data)
    })

}
rdyToWash()